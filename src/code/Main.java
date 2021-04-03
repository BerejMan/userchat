package code;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
//		Scanner log = new Scanner(System.in);
//		//String  key = "F" + (System.currentTimeMillis() * (((int) Math.random() * 100000)));
//		String src = "";
//		for(int i = 0; i < 128; i++) {
//			src += (int) (Math.random() * 10);
//		}
//		System.out.println("Key: " + src);
//		BigInteger key = new BigInteger(src);
//		
//		BigInteger text = new BigInteger("997002999"); //997002999

		BigInteger key = new BigInteger("0");
		EncryptTBM obj = new EncryptTBM(key.toString());
		String TheText = "login";
		System.out.println("Text: " + TheText);
		String coded = obj.EncodingTextToInt(TheText);
		System.out.println("Coded: " + coded);
		BigInteger Encrypted = obj.Encrypting(coded);
		System.out.println("Enc: " + Encrypted);
		String Decrypted = obj.DecodingIntToText(coded);
		System.out.println(Decrypted);
		
		
	
		
		
		
	}

}
