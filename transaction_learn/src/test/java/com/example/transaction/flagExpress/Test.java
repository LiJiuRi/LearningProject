package com.example.transaction.flagExpress;

/**
 * @Auther: liXu
 * @Date: 2020/4/27 23:17
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //由于new Double(0)存在，故dSrc不会向下类型转换，
        Double dSrc1 = null;
        Double distinct1;
        distinct1 = true ? dSrc1 : new Double(0);

        //由于0d，故dSrc会做向下类型转换，即dSrc.doubleValue()拆箱操作，null.doubleValue()就报空指针异常
        Double dSrc = null;
        Double distinct2;
        distinct2 = true ? dSrc : 0d;

        //此时也会做拆箱操作，报空指针
        Double dWarp1 = null;
        double d1 = dWarp1;
    }
}
