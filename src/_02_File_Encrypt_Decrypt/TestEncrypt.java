package _02_File_Encrypt_Decrypt;
import static org.junit.Assert.assertEquals;

import org.junit.*;
public class TestEncrypt {
@Test
public void testEncrypt() {
	assertEquals("lipps asvph", FileEncryptor.encrypt("hello world", 4));
}
@Test
public void testDecrypt() {
	assertEquals("hello world", FileDecryptor.decrypt("lipps asvph", 4));
}
}