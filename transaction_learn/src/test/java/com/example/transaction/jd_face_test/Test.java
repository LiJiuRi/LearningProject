package com.example.transaction.jd_face_test;

import org.mockito.internal.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: liXu
 * @Date: 2020/9/20 23:15
 * @Description: 输入描述： 单组输入，输入一段英文短文，可能包含字母大小写，标点符号及空格。（不超过2000个字符）
 * 输出描述： 输出所提取到的所有可能的年份字符串，两两之间用一个空格隔开。
 * <p>
 * 小明想从一段英文短文中提取潜在的年份信息，待匹配的年份的范围为1000年至3999年，包含1000和3999。
 * 输入一段英文短文，按出现次序输出所提取到的所有可能的年份字符串。
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        scanner.close();
        int count = 0;
        System.out.println(inputLine);
        List<String> all = new ArrayList<>();
        for (int i = 0; i < inputLine.length(); i++) {
            char temp = inputLine.charAt(i);
            if (temp >= '0' && temp <= '9') {
                count++;
            } else {
                count = 0;
            }
            if (count == 4) {
                all.add(inputLine.substring(i - 3, i + 1));
                count = 0;
            }
        }
        System.out.println(StringUtil.join(0, ',', all));
    }
}
