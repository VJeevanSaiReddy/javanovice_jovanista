package com.skillsoft.serializationparsing;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Socket socket=null;
        ObjectInputStream objInp=null;
        try(ServerSocket serverSocket=new ServerSocket(8020)){
            System.out.println("Waiting for connection");
            socket=serverSocket.accept();
            objInp=new ObjectInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            while(true){
                Account account=(Account) objInp.readObject();
                System.out.println("The account info"+account);
            }
        }
        finally {
            socket.close();
            objInp.close();
        }
    }
}
