package code;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket clientSocket; 
    private static BufferedReader reader; 
    
    private static BufferedReader in; 
    private static BufferedWriter out; 

    public static void main(String[] args) {
    	Scanner log = new Scanner(System.in);
    	
        try {
            try {
            	System.out.print("IP Termination number:");
                String ent = log.nextLine();
                clientSocket = new Socket("192.168.0." + ent, 4004); 
                
                reader = new BufferedReader(new InputStreamReader(System.in));
               
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
               
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Say");
              
                String word = reader.readLine();
                
                out.write(word + "\n");
                out.flush();
                String serverWord = in.readLine(); 
                System.out.println(serverWord);
            } finally { 
                System.out.println("Client close");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
