package code;
import java.lang.Math;
import java.math.BigInteger;
import java.util.Scanner;

public class EncryptTBM {
	private String TKey;
	public String src;
	public EncryptTBM(String GivedKey) { 
		if (GivedKey.equals("0")) {
			src = "";
			for(int i = 0; i < 256; i++) { //creating 256-byte key
				src += (int) (Math.random() * 10);
				
			}
			System.out.println("TEST KEY - " + src);
		}
		else {
			src = GivedKey;
		}
	}
	
	public boolean getTKey() {
		String scan = "";
		if (TKey == scan) return true;
		else return false;
	}
	
	
	public String EncodingTextToInt(String txt) { // DON'T TOUCH THIS WORKING CODE
		TxtToInt transfer = new TxtToInt();
		char[] text = txt.toCharArray();
													//Char Array to String Array ||
		String[] StrText = new String[txt.length()]; 
		for(int i = 0; i < txt.length(); i++) {
			StrText[i] = "" + text[i];
		}
		long[] TextArr = new long[2500];
		for(int i = 0; i < txt.length(); i++) { 	//transform text to the Num Array
			TextArr[i] = transfer.getAssociation(StrText[i]);
		}
		String ReturnIntText = "";
		for(int i = 0; i < txt.length(); i++) {
			ReturnIntText += TextArr[i]; 			//finally create coded text
		}
		return ReturnIntText;
	}
	public String DecodingIntToText(String coded) {
		//Transform coded text to string array and transform in symbols
		String sec = coded; // --__--
		int[] ArrOfCoded = new int[(sec.length())/3];
		long repeater = 0;
		char[] Symbols = coded.toCharArray();
		String[] GroupedSymbols = new String[sec.length()/3];
		for(int i = 0; i < sec.length()/3; i++) {
			GroupedSymbols[i] = "";
		}
		int Indexnum = 0;
		for(int i = 0; i < sec.length()/3; i++) {
			for(int y = 0; y < 3; y++) { //Grouping 3 symbols
				GroupedSymbols[i] += Symbols[Indexnum];
				Indexnum++;
			}
		}
		
		for (int i = 0; i < sec.length()/3; i++) {
			//System.out.println(GroupedSymbols[i]);
			ArrOfCoded[i] = Integer.parseInt(GroupedSymbols[i]); //Full Integer array
		}
		
		
		//Transforming in text
		String TEXT = "";
		TxtToInt transfer = new TxtToInt();
		for(int i = 0; i < sec.length()/3; i++) {
			TEXT += transfer.getCharFromNum(ArrOfCoded[i]);
		}
		
		
		return TEXT;
	}
	
	
	
	

	public BigInteger Encrypting(String TransmText) {		
		BigInteger key = new BigInteger(src);
		BigInteger text = new BigInteger(TransmText);
		
		BigInteger Enc = key.multiply(text);
		
//		System.out.println("Key: " + src);
//		System.out.println("Enc: " + Enc);
//		BigInteger res = Enc.divide(key);
//		System.out.println("TXT: " + res);
		
		
		
		
		
		
		return Enc;
	}


}
