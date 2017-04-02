
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JOHN
 */
public class SimpleServer {
    
    public static void main(String[] args) throws IOException {
    
        /*if (args.length != 1) {
          System.err.println("Usage: java EchoServer <port number>");
          System.exit(1);
        }*/
        try{
            int portNumber = Integer.parseInt(args[0]);
            ServerSocket serverSock = new ServerSocket(portNumber);
            Socket sock = serverSock.accept();///KOLLAEI EDW
            System.out.println("aggouria");
            InputStream sis = sock.getInputStream();
            System.out.println("aggouria");
            BufferedReader br = new BufferedReader(new InputStreamReader(sis));
            //String request = br.readLine(); // Now you get GET index.html HTTP/1.1`
            //String[] requestParam = request.split(" ");
            System.out.println("aggouria");
            String path = args[1];
                System.out.println("aggouria");
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            File file = new File(path);
            System.out.println("aggouria");
            if (!file.exists()) {
                 out.write("HTTP 404"); // the file does not exists
                 System.out.println("GAMW TUB NABATASDA");
            }
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            String line;
            while ((line = bfr.readLine()) != null) {
                System.out.println("segrafsww");
                out.write(line);
                
            }

            bfr.close();
            br.close();
            out.close();
        }
        catch (IOException e) {
          System.out.println("Exception caught when trying to listen on port ");
          System.out.println(e.getMessage());
        }
    }
}
