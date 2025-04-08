package com.skillsoft.serializationparsing;

import java.awt.desktop.SystemSleepListener;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Account acc1=new Account(11111,"Jeevan",12345.55f);
        Account acc2=new Account(22222,"Mphasis",56432.55f);

        String filename="Accounts.txt";
        try(ObjectOutputStream objOut=new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(filename)))){
                objOut.writeObject(acc1);
                objOut.writeObject(acc2);
        }
        try(ObjectInputStream objInp=new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(filename)))){
                for(int i=0;i<2;i++){
                    Account ac1=(Account) objInp.readObject();
                    System.out.println(ac1.toString());
                }
        }
        finally{
            System.out.println("Successfully written");
        }
    }
}
