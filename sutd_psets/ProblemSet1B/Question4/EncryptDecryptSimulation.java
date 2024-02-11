package ProblemSet1B.Question4;

import java.math.BigInteger;
import java.util.Arrays;

public class EncryptDecryptSimulation {
    public static void main(String[] args) {
        String msg = "red is sus";
        Browser b = new Browser();
        Server s = new Server();

        s.setP(97);
        s.setQ(53);
        b.establishConnection(s);

        BigInteger[] encryptedMsg = b.encryptMessage(msg);
        String decryptedMessage = s.decryptMessage(encryptedMsg);

        System.out.println(Arrays.toString(encryptedMsg));
        System.out.println(decryptedMessage);
    }
}
