import java.net.*;
import java.io.*;

public class client {
    private Socket server_soc = null;
    private BufferedReader cli_in = null;
    private DataInputStream server_in = null;
    private DataOutputStream server_out = null;
    private static final String STR_END = "over";

    public client(String address, int port) {

        // Create a socket and connect
        try {
            server_soc = new Socket(address, port);
            System.out.println("Connetcted!");

            cli_in = new BufferedReader( 
			new InputStreamReader(System.in));
            server_in = new DataInputStream(
                            new BufferedInputStream(server_soc.getInputStream()));
            server_out = new DataOutputStream(server_soc.getOutputStream());

        } catch ( UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        // read/write
        String line = "";
        
        while (!line.equals(STR_END)) {
            try {
                line = cli_in.readLine();
                server_out.writeUTF(line);
                System.out.println(server_in.readUTF());

            } catch (IOException i) {
                System.out.println(i);
            }
        }
        try {
            server_soc.close();
            server_in.close();
            server_out.close();
            cli_in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        client client_obj = new client("localhost", 5000);
    }
}
