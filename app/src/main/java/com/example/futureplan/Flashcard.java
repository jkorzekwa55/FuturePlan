package com.example.futureplan;

public class Flashcard {

    private String op1, n1, op2, n2;

    public Flashcard(){

    }

    public void setData(String op1, String n1, String op2, String n2) {
        this.op1 = op1;
        this.n1 = n1;
        this.op2 = op2;
        this.n2 = n2;
    }

    public String getOp1(){
        return op1;
    }
    public String getOp2(){
        return op2;
    }
    public String getN1(){
        return n1;
    }
    public String getN2(){
        return n2;
    }
}
