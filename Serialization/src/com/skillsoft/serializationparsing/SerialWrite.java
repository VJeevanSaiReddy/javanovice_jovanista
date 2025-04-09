package com.skillsoft.serializationparsing;
import java.io.*;
import java.math.BigInteger;

public class SerialWrite {
    public static void main(String args[]) throws IOException {
        BigInteger productIds[]={
                new BigInteger("12344567809"),
                new BigInteger("12345678909"),
                new BigInteger("114323456655")
        };
        String[] products={"Samsung galaxy","iphone 16pro","Nike jordan"};
        float[] productPrices={899.99f,1100.34f,00.00f};
        System.out.println("Big integer implements serializable" +
                productIds[0] instanceof Serializable);
        System.out.println("String implements serializable" +
                products[0] instanceof Serializable);
        System.out.println("ProductPrices implements serializable" +
                productPrices[0] instanceof Serializable);
        String productFilename="products.txt";
        try(ObjectOutputStream objOut=new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(productFilename)))){
            for(int i=0;i<productIds.length;i++){
                objOut.writeObject(productIds[i]);
                objOut.writeUTF(products[i]);
                objOut.writeFloat(productPrices[i]);
            }
        }
        finally {
            System.out.println("completed writing");
        }
    }
}
