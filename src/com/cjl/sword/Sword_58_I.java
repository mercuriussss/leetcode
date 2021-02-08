package com.cjl.sword;

/*
    问题描述：
        输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
        为简单起见，标点符号和普通字母一样处理。
        例如输入字符串"I am a student. "，则输出"student. a am I"。
    示例 1：
        输入: "the sky is blue"
        输出: "blue is sky the"
    示例 2：
        输入: "  hello world!  "
        输出: "world! hello"
        解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
    示例 3：
        输入: "a good   example"
        输出: "example good a"
        解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
    说明：
        无空格字符构成一个单词。
        输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class Sword_58_I {

    // 库函数解法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    // split()、trim()、strip()、join()、reverse()方法的时间复杂度都为O(N)
    public String solution1(String s){
        String[] arr = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            res.append(arr[i]).append(" ");
        }
        return res.toString().trim();
    }

    // 双指针解法
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public String solution2(String s){
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        StringBuilder res = new StringBuilder();
        while(left >= 0){
            // 搜索首个空格
            while(left >= 0 && s.charAt(left) != ' '){
                left --;
            }
            // 添加单词
            res.append(s, left + 1, right + 1).append(" ");
            // 跳过单词间空格
            while(left >= 0 && s.charAt(left) == ' '){
                left --;
            }
            // 指向下一个单词的尾字符
            right = left;
        }
        return res.toString().trim();
    }
}
