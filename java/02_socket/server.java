//https://www.geeksforgeeks.org/socket-programming-in-java/
//https://www.baeldung.com/a-guide-to-java-sockets

import java.net.*;
import java.io.*;

public class server {
    private Socket  client_sock = null;
    private ServerSocket server_sock = null; 
    private DataInputStream cli_in = null;
    private DataOutputStream cli_out = null;
    private static final String STR_END = "over";

    public server(int port) {
        try {
            server_sock = new ServerSocket(port);
            System.out.println("Server started...");

            client_sock = server_sock.accept();

            cli_in = new DataInputStream(
                    new BufferedInputStream(client_sock.getInputStream()));
            cli_out = new DataOutputStream( client_sock.getOutputStream() );
            String line = "";

            while ( !line.equals(STR_END)) {
                try {
                    line = cli_in.readUTF();
                    cli_out.writeUTF("server reply: "+line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Close connection");

            client_sock.close();
            cli_in.close();
            cli_out.close();

        } catch (IOException i) {
            System.out.println(i);
        }

    }

    public static void main(String args[]) {
        server server_obj = new server(5000);
        
    }

}
