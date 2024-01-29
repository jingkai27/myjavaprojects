import java.lang.Math;

public class PrimeNumberChecker{
	public static int isPrime(int num){

		double mid = num/2;
		System.out.println(mid);
		for (int i = 2; i <= mid; i++){
			if (num % i == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		int numberToCheck = 99;
		if (isPrime(numberToCheck) == 1) {
			System.out.println(numberToCheck + " is a prime number.");
		} else {
			System.out.println(numberToCheck + " is not a prime number.");
		}
	}
}