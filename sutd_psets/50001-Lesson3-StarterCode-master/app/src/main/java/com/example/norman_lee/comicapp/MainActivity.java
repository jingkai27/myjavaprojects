package com.example.norman_lee.comicapp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.norman_lee.comicapp.utils.Container;
import com.example.norman_lee.comicapp.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText editTextComicNo;
    Button buttonGetComic;
    TextView textViewTitle;
    ImageView imageViewComic;

    String comicNo;
    public static final String TAG = "Logcat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 6.1 Ensure that Android Manifest has permissions for internet and has orientation fixed
        //TODO 6.2 Get references to widgets
        editTextComicNo = findViewById(R.id.editTextComicNo);
        buttonGetComic = findViewById(R.id.buttonGetComic);
        textViewTitle = findViewById(R.id.textViewTitle);
        imageViewComic = findViewById(R.id.imageViewComic);

        //TODO 6.3 - 6.5 **********************************
        //TODO 6.3 Set up setOnClickListener for the button
        //TODO 6.4 Retrieve the user input from the EditText
        //TODO 6.5 If network is active, call the getComic method. Otherwise, show a Toast message
        buttonGetComic.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String userInput = editTextComicNo.getText().toString();

                if (Utils.isNetworkAvailable(getApplicationContext())) {
                    getComic(userInput);
                } else{
                    Toast.makeText(getApplicationContext(), "No Network Access", Toast.LENGTH_SHORT).show();

                }
            }
        });

        //TODO 6.6 - 6.15 Modify GetComic Below *************
    }

    //TODO 6.6 - 6.15 ****************
    //TODO you are reminded that this is NOT inside onCreate()
    //TODO 6.6 Make sure an executor and a handler are instantiated
    //TODO 6.7 (background work) create a final Container<Bitmap> cBitmap object which will be used for communication between the main thread and the child thread
    //TODO 6.8 Call Utils.buildURL to get the URL based on the comic number from userInput
    //TODO 6.9 Call Utils.getJSON to get the String response of the URL
    //TODO 6.10 If the response is null, write a Toast message in main thread, otherwise:
    //TODO 6.11 Inside a try/catch, get JSON object from the String response
    //TODO 6.12 Extract the image string url with key "img" from the JSON object
    //TODO 6.13 Extract the title with key "safe_title"
    //TODO 6.14 Download the Bitmap using Utils.getBitmap
    //TODO 6.15 (main thread) Assign the bitmap downloaded to imageView and set the title to textViewTitle
    void getComic(final String userInput) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable(){
            @Override
            public void run(){
                final Container<Bitmap> cBitmap = new Container<>();
                try{
                    URL url = Utils.buildURL(userInput);
                    String response = Utils.getJson(url);
                    if (response == null){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Response is null", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String image_url = jsonObject.getString("img");
                            String safe_title = jsonObject.getString("safe_title");
                            URL image = new URL(image_url);
                            Bitmap bitmap = Utils.getBitmap(image);
                            cBitmap.set(bitmap);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Bitmap bitmap = cBitmap.get();
                                    if (bitmap!=null){
                                        imageViewComic.setImageBitmap(bitmap);
                                        textViewTitle.setText(safe_title);
                                    }
                                }
                            });
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }

                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
