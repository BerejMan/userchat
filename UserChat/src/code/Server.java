package code;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static Socket clientSocket; 
    private static ServerSocket server; 
    private static BufferedReader in; 
    private static BufferedWriter out; 

    public static void main(String[] args) {
    	Scanner log = new Scanner(System.in);
        try {
            try  {
                server = new ServerSocket(4004); 
                System.out.println("Server Started"); 
                clientSocket = server.accept(); 
               
                try { 
                  
                    
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                  
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String word = log.nextLine();
                    System.out.println(word);
                    
                    out.write("Sys Admin says: " + word + "\n");
                    out.flush(); 

                } finally { 
                    clientSocket.close();
                    
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server Closed");
                    server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}