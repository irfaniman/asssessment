package vttp2022.task2.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) 
            throws IOException {

        // Create a server socket and listen to a port
        ServerSocket server = new ServerSocket(80);

        System.out.println("Waiting for connection on port 80"); 
        // Wait for incoming client connection
        Socket sock = server.accept();
        System.out.println("Connection accepted");

        // Get the output stream
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        ObjectOutputStream oos = new ObjectOutputStream(dos);
       

        // Get the input and output stream - bytes
        // Get the input stream
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        ObjectInputStream ois = new ObjectInputStream(dis);
                    

        String idRequest = ois.readUTF();
        System.out.printf("Received request: %s\n", idRequest);

        // close the streams
        is.close();
        os.close();

        // close the socket
        sock.close();
    }
}
