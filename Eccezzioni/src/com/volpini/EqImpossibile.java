package com.volpini;

public class EqImpossibile extends RuntimeException{
    public EqImpossibile() {
        super("Equazione impossibile");
    }
    public EqImpossibile(String msg) {
        super(msg);
    }
}
