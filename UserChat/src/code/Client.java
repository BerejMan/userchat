package code;
import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; 
    private static BufferedReader reader; 
    
    private static BufferedReader in; 
    private static BufferedWriter out; 

    public static void main(String[] args) {
        try {
            try {
                
                clientSocket = new Socket("localhost", 4004); //MAXTEST234
                
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
