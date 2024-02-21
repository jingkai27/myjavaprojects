import java.math.BigInteger;

public class Browser {
    private final int[] publicKey = new int[2]; // DO NOT CHANGE THIS DATA FIELD

    public void establishConnection(Server s) {
        // Generate public and private keys
        s.generatePublicPrivateKey();

        // Get the publicKey from the server and set it as the Browser object’s publicKey attribute
        publicKey[0] = s.getPublicKey()[0];
        publicKey[1] = s.getPublicKey()[1];
    }

    public BigInteger[] encryptMessage(String message) {
        BigInteger[] encryptedIntMessage = new BigInteger[message.length()];
        for (int i = 0 ; i < message.length() ; i ++) {
            //GET ASCII VALUE OF characters
            int charValue = (int) message.charAt(i);
            // Encrypt using private key
            BigInteger encryptedChar = BigInteger.valueOf(charValue).modPow(BigInteger.valueOf(publicKey[1]), BigInteger.valueOf(publicKey[0]));
            //Store encrypted char in encryped message array
            encryptedIntMessage[i] = encryptedChar;

        }

        // Hint:
        // 1. Loop through each character of the message
        // 2. Convert to its ASCII value in integer
        // 3. Encrypt the value. Use .modPow method from BigInteger

        return encryptedIntMessage;
    }
}