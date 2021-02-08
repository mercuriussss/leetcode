package com.cjl.sword;

/*
    问题描述：
        请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    示例 1：
        输入：s = "We are happy."
        输出："We%20are%20happy."
    限制：
        0 <= s 的长度 <= 10000
 */

public class Sword_5 {

    public String solution1(String s) {
        int length = s.length();
        char[] arr = new char[length * 3];
        int size = 0;
        char tmp;
        for (int i = 0; i < length; i++) {
            tmp = s.charAt(i);
            if(tmp == ' '){
                arr[size++] = '%';
                arr[size++] = '2';
                arr[size++] = '0';
            }else{
                arr[size++] = tmp;
            }
        }
        String newstr = new String(arr,0,size);
        return newstr;
    }
}
