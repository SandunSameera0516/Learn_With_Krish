package com.sandun;

class TestChain {

    public static void main(String[] args) {
        Chain chain = new Chain();

        //Calling chain of responsibility
        chain.process(new Number(100));
        chain.process(new Number(-60));
        chain.process(new Number(0));
        chain.process(new Number(85));
    }

}
