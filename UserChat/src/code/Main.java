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
		String secKey =	"7497862570093155078048993106825419352620321757322123500108797889117088766862176738821133898533344076082882528415467825026288234688290898988885946657338195568033113271315739663324070719653839884463908712164962392605262732608831982589813201544828121645783195";
		
		Scanner log = new Scanner(System.in);
		System.out.print("Enter text:");
		String ent = log.nextLine();
		System.out.println();

		BigInteger key = new BigInteger(secKey);
		EncryptTBM obj = new EncryptTBM(key.toString());
		String TheText = ent;
		System.out.println("Text: " + TheText);
		String coded = obj.EncodingTextToInt(TheText);
		System.out.println("Coded: " + coded);
		BigInteger Encrypted = obj.Encrypting(coded);
		System.out.println("Enc: " + Encrypted);
		String Decrypted = obj.DecodingIntToText(coded);
		System.out.println(Decrypted);
		
		
	
		
		
		
	}

}
