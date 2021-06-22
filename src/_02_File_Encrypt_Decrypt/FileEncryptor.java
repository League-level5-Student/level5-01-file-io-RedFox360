package _02_File_Encrypt_Decrypt;

import java.util.Arrays;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information in such a way
	 * that only authorized parties can access it and those who are not authorized
	 * cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message down based
	 * on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user. Use the key to
	 * shift each letter in the users input and save the final result to a file.
	 */

	public static String encrypt(String message, int key) {
		String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		String[] shifted = getShifted(key);
		String[] encrypted = new String[message.length()];
		char[] cArray = message.toLowerCase().toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			char c = cArray[i];
			int indexOfC = search(alphabet, "" + c);
			if (indexOfC == -1) {
				encrypted[i] = "" + c;
				continue;
			}
			;
			encrypted[i] = shifted[indexOfC];
		}
		return join(encrypted);

	}

	protected static String[] getShifted(int key) {

		String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
		String[] shifted = new String[alphabet.length];
		for (int i = 0; i < alphabet.length; i++) {
			int newPos = i + key;
			if (newPos >= alphabet.length) {
				newPos = newPos - alphabet.length;
			}
			shifted[i] = alphabet[newPos];
		}
		System.out.println("= Alphabet =");
		for (String letter : alphabet) {
			System.out.print(letter + " ");
		}
		System.out.println("\n= Shifted =");
		for (String letter : shifted) {
			System.out.print(letter + " ");
		}
		return shifted;
	}

	protected static String join(String[] arr) {
		String joined = "";
		for (int i = 0; i < arr.length; i++) {
			joined += arr[i];
		}
		return joined;
	}

	protected static int search(String[] arr, String key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(key)) {
				return i;
			}
		}
		System.out.println(key);
		return -1;
	}
}
