package com.skillsoft.serializationparsing;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String args[]) throws IOException, InterruptedException {
        Account account1=new Account(1234,"Mahesh",155.7f);
        Account account2=new Account(1235,"Akash",1553.7f);
        Account account3=new Account(1236,"Ben",455.7f);
        Account account4=new Account(1237,"Stoksey",755.7f);

        List<Account> accountsList=new ArrayList<>
                (Arrays.asList(account1,account2,account3,account4));
        ObjectOutputStream objOut=null;
        try{
            Socket socket=new Socket(InetAddress.getLocalHost(),8020);
            objOut=new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            for(Account acct:accountsList){
                objOut.writeObject(acct);
                objOut.flush();
                Thread.sleep(5000);
            }
        }
        catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            objOut.close();
        }
    }
}
