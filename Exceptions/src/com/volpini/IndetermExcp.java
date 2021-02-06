package com.volpini;

public class IndetermExcp extends RuntimeException{
    public IndetermExcp() {
        super("Equazione indeterminata");
    }
    public IndetermExcp(String msg) {
        super(msg);
    }


}
