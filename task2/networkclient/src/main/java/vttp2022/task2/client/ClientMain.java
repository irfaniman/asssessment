package vttp2022.task2.client;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain {

    public static void main(String[] args) 
            throws IOException {

        // Connect the server
        Socket sock = new Socket("task02.chuklee.com", 80);

        // Get the output stream
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        ObjectOutputStream oos = new ObjectOutputStream(dos);     
     
        // Get the input stream
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        ObjectInputStream ois = new ObjectInputStream(dis);
        String response = ois.readUTF();
        System.out.printf(">> %s\n", response);

        String[] terms = response.split(" ");
        String id = terms[0];
        String number = terms[1];
        number = number.replace(","," ");
        System.out.println(number);
        

        System.out.println(terms[0]);
        oos.writeUTF(terms[0]);
        oos.flush();

        oos.writeUTF("Muhammad Irfan Iman Bin Abu Bakar");
        oos.flush();

        oos.writeUTF("irfanimanabub@gmail.com");
        oos.flush();

        /*dos.writeFloat();
        dos.flush(); */

        // close the streams
        is.close();
        os.close();

        // close the socket
        sock.close();
    }
    
}
