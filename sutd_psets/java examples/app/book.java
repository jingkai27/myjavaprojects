/*
* Attributes of title, author, yearPublished
* Method called book
* 3 instances and print their details
*  */

public class book {
    String title;
    String author;
    int yearPublished;

    int currentYear = 2024;

    public book(){
        this.title = "nil";
        this.author = "nil";
        this.yearPublished = 0;
    }

    public book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void getDetails(){
        System.out.println("This is the book's title: " + this.title);
        System.out.println("This is the book's author: " + this.author);
        System.out.println("This is the year of publication: " + this.yearPublished);
    }

    public int getBookAge(){
        return currentYear - this.yearPublished;
    }

    public static void main(String[] args){
        book book1 = new book();
        book book2 = new book("Mario", "Sui", 2024);
        book book3 = new book("Smelly", "En", 9000);
        book3.getDetails();
        book2.getBookAge();
    }
    //create constructor
}
