package com.skillsoft.serializationparsing;

import javax.imageio.IIOException;
import java.io.*;
import java.math.BigInteger;

public class SerialRead {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        try(ObjectInputStream objInp=new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("products.txt")))){
            for(int i=0;i<3;i++){
                BigInteger productId= (BigInteger) objInp.readObject();
                String products= objInp.readUTF();
                float productPrices=(float) objInp.readFloat();
                System.out.format("productId : %d , products : %s , productPrices : %f \n",
                        productId,products,productPrices);
            }
        }
        finally {
            System.out.println("so we have read pperfectly");
        }
    }
}
