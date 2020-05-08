/****
* network socket in linux 20200507
* source reference: 
*	https://www.geeksforgeeks.org/socket-programming-in-java/
*	https://www.baeldung.com/a-guide-to-java-sockets
*
*	install IDE in AWS AMI
*	Java: sudo yum install java-devel
*	https://stackoverflow.com/questions/15933343/how-to-run-simple-java-app-on-amazon-ec2
*	
*/
import java.net.*;
import java.io.*;

public class server {
    private Socket  client_sock = null;
    private ServerSocket server_sock = null; 
    private DataInputStream cli_in = null;
    private DataOutputStream cli_out = null;
	// magic word to terminate
    private static final String STR_END = "over";

	// init function
    public server(int port) {
        try {
			// setup server socket
            server_sock = new ServerSocket(port);
            System.out.println("Server started...");
			
			// listening 
            client_sock = server_sock.accept();

			// set up I/O for client connection
            cli_in = new DataInputStream(
                    new BufferedInputStream(client_sock.getInputStream()));
            cli_out = new DataOutputStream( client_sock.getOutputStream() );
            String line = "";

			// continue until client terminate with word: STR_END
            while ( !line.equals(STR_END)) {
                try {
                    line = cli_in.readUTF();
                    cli_out.writeUTF("server reply: "+line);
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Close connection");

			// clean up
            client_sock.close();
            cli_in.close();
            cli_out.close();

        } catch (IOException i) {
            System.out.println(i);
        }

    }

	// main function, start point
    public static void main(String args[]) {
        server server_obj = new server(5000);
        
    }

}
