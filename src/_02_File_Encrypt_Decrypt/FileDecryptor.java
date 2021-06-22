package _02_File_Encrypt_Decrypt;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public static String decrypt(String message, int key) {
		String[] alphabet="abcdefghijklmnopqrstuvwxyz".split("");
		String[] shifted = FileEncryptor.getShifted(key);
		String[] decrypted = new String[message.length()];
		char[] cArray = message.toLowerCase().toCharArray();
		for (int i = 0; i < cArray.length; i++) {
			char c = cArray[i];
			int indexOfC = FileEncryptor.search(shifted, "" + c);
			if (indexOfC == -1) {
				decrypted[i] = "" + c;
				continue;
			}
			;
			decrypted[i] = alphabet[indexOfC];
		}
		return FileEncryptor.join(decrypted);
			
	}
}
