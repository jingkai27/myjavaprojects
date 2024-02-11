package ProblemSet1B.Question4;

import java.math.BigInteger;

public class Server {
    // DO NOT CHANGE THIS PART OF THE CODE ======================
    private final int[] publicKey = new int[2];
    private final int[] privateKey = new int[2];
    private int p;
    private int q;

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int[] getPublicKey() {
        return publicKey;
    }

    public int[] getPrivateKey() {
        return privateKey;
    }

    private int computeModInverse(int e, int lambda) {
        for (int d=1; d<lambda; d++) {
            if ( ((e%lambda)*(d%lambda))%lambda==1 ) {
                return d;
            }
        }
        return 1;
    }
    private int computeE(int lambda) {
        for (int i=lambda-1; i>2; i-- ) {
            if (lambda%i!=0 && isPrime(i)) {
                return i;
            }
        }
        return 0;
    }
    private boolean isPrime(int a) {
        for (int i = 2; i<a/2; i++) {
            if (a%i==0) {
                return false;
            }
        }
        return true;
    }
    // =========================================

    // Start your answer from here onwards
    public void generatePublicPrivateKey() {
        // TODO 1: Compute modulus n
        // TODO 2: Compute lambda λ
        // TODO 3: Compute e
        // TODO 4: Compute d
        // TODO 5: Set (n,e) as the public key
        // TODO 6: Sset (n,d) as the private key
    }

    public String decryptMessage(BigInteger[] encryptedIntMessage) {
        BigInteger[] decryptedIntMessage = new BigInteger[encryptedIntMessage.length];

        // Hint:
        // 1. Decrypt each character of the message. Use .modPow from BigInteger
        // 2. Decrypted character is an ASCII value (integer). Convert to char
        // 3. Concatenate characters into string
        // 4. Return the decrypted string message

        return "";
    }

    private int lcm(int a, int b) {
        // Return the least common multiple of a and b

        return 0; // 0 is a placeholder to be replaced with the actual output
    }

    private int gcd(int a, int b) {
        // Return the greatest common divisor of a and b

        return 0; // 0 is a placeholder to be replaced with the actual output
    }
}

