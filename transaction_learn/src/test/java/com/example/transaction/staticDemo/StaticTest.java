package com.example.transaction.staticDemo;

/**
 * @Auther: liXu
 * @Date: 2020/3/31 23:47
 * @Description:
 */

class StaticDemo{

    //静态代码块
    static {
        System.out.println("父类静态代码块被执行");
    }

    //非静态代码块
    {
        System.out.println("父类非静态代码块被执行");
    }
    //构造方法
    StaticDemo(){

        System.out.println("父类构造方法被执行");
    }
}
public class StaticTest extends StaticDemo {

    /**
     * 静态代码块的特点：
     * 随着类的加载而执行，而且只执行一次
     * 静态代码块额执行顺序优先于main函数
     */
    static {

        System.out.println("子类静态代码块被执行");
    }
    //非静态代码块
    {
        System.out.println("子类非静态代码块被执行");
    }
    StaticTest(){
        System.out.println("子类构造方法被执行");
    }

    public static void main(String[] hq){
        new StaticTest();
        System.out.println("main函数");
    }
}

