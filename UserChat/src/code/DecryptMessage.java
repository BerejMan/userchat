package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.io.*;

public class DecryptMessage {

	public static void main(String[] args) throws FileNotFoundException {
		String PKey;
		try {
		File file = new File("");
		FileReader fr = new FileReader(file);
		BufferedReader reader = new BufferedReader(fr);
		String line = reader.readLine();	

		
		
		Scanner log = new Scanner(System.in);
		System.out.print("Key: ");
		//String ent = log.nextLine();
		System.out.print(line);
		String ent = line;
		System.out.println();
		
		BigInteger key = new BigInteger(ent);
		EncryptTBM obj = new EncryptTBM(ent); // giving key
		while(true) {
			System.out.println("For exiting from programm print: stop");
			System.out.print("Enc: ");
			String text = log.nextLine();
			if(text.equals("stop")) break; //exiting operator
			System.out.println();
			
			BigInteger Enc = new BigInteger(text);
			String Decrypt = "" + (Enc.divide(key));
			System.out.println(obj.DecodingIntToText(Decrypt));
			
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
