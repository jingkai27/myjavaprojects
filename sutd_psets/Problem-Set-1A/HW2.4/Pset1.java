// **ATTENTION**
// Edit just this file to submit your answer
// You need not edit the TestPset1.java file

import java.util.Arrays;

public class Pset1 {	
	public static boolean isAllCharacterUnique(String sIn) { /* Let's try brute force' */
	  int MAX_CHAR = 256;
	  if (sIn.length() > MAX_CHAR){
		  return false;
	  }
	  boolean[] chars = new boolean[MAX_CHAR];
	  Arrays.fill(chars, false);
	  for (int i=0; i<sIn.length(); i++){
		  int index = (int)sIn.charAt(i);
		  if (chars[index] == true){
			  return false;
		  }
		  chars[index] = true;
	  }

	  return true;
		/*
	  Method 1: Brute Force -> Time complexity => O(n^2)
	  for (int k = 0; k < sIn.length(); k++){
		  for (int j = 0; j < sIn.length(); j++){
			  if (sIn.charAt(k) == sIn.charAt(j))
				  return false;
			}
		}
	  return true;

	   */
	}
	public static boolean isPermutation(String sIn1, String sIn2) {
	  //todo: add your implementation

		// condition2: cannot be empty
		if (sIn1.length() == 0 || sIn2.length() == 0){
			return false;
		}

		// condition 1: same length
		if (sIn1.length() != sIn2.length()){
			return false;
		}

		char[] charArray1 = sIn1.toCharArray();
		char[] charArray2 = sIn2.toCharArray();

		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		System.out.println(charArray1);
		System.out.println(charArray2);
		if (Arrays.equals(charArray1, charArray2)){
			return true;
		}
		return false;
	}
}
