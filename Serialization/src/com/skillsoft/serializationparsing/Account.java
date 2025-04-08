package com.skillsoft.serializationparsing;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    public static String acctType="LOAN";
    private long acctNo;
    private String custName;
    private double bal;
    public Account(long acctNo,String custName,double bal){
        this.acctNo=acctNo;
        this.custName=custName;
        this.bal=bal;
    }
    public static String getAcctType() {
        return acctType;
    }

    public long getAcctNo(){
        return acctNo;
    }

    public double getBal() {
        return bal;
    }

    public String getCustName() {
        return custName;
    }

    @Override
    public String toString() {
        return String.format("acctType: %s, acctNo: %d custName: %sbal: %.1f ",
                acctType, acctNo,custName,bal);
    }
}
