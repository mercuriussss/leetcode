package com.cjl.old.sword;

/*
    问题描述：
        字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
        请定义一个函数实现字符串左旋转操作的功能。
        比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    示例 1：
        输入: s = "abcdefg", k = 2
        输出: "cdefgab"
    示例 2：
        输入: s = "lrloseumgh", k = 6
        输出: "umghlrlose"
    限制：
        1 <= k < s.length <= 10000
 */
public class Sword_58_II {

    // 字符串切片
    // 时间复杂度是O(N)，空间复杂度是O(1)
    public static String solution1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    // 列表遍历（不允许切片的情况下可以使用该方法）
    // 时间复杂度是O(N)，空间复杂度是O(N)
    public String solution2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}
