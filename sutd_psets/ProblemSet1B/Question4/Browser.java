package ProblemSet1B.Question4;

import java.math.BigInteger;

public class Browser {
    private final int[] publicKey = new int[2]; // DO NOT CHANGE THIS DATA FIELD

    public void establishConnection(Server s) {
        // TODO 1: Generating public and private key by the server
        // TODO 2: Get the public key from the server and use it to set Browser object's public key
    }

    public BigInteger[] encryptMessage(String message) {
        BigInteger[] encryptedIntMessage = new BigInteger[message.length()];

        // Hint:
        // 1. Loop through each character of the message
        // 2. Convert to its ASCII value in integer
        // 3. Encrypt the value. Use .modPow method from BigInteger

        return encryptedIntMessage;
    }
}
