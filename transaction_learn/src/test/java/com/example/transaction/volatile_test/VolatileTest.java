package com.example.transaction.volatile_test;

/**
 * @Auther: liXu
 * @Date: 2020/9/17 00:07
 * @Description:
 */
public class VolatileTest {
    private int a = 1;
    private int abc = 1;
    private volatile int b = 2;
    public void write(){
        a = 3;
        b = a;
        abc = 100;

    }
    public void read(){
        System.out.println("b = " + b + " , a = " + a + " , abc = " + abc);
    }
    public static void main(String[] args) {
        while (true){
            VolatileTest volatileTest = new VolatileTest();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileTest.write();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    volatileTest.read();
                }
            }).start();
        }
    }
}
