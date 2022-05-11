package com.cjl.old.interview;

/*
    问题描述：
        实现 strStr() 函数。
        给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
        如果不存在，则返回  -1。
    示例 1:
        输入: haystack = "hello", needle = "ll"
        输出: 2
    示例 2:
        输入: haystack = "aaaaa", needle = "bba"
        输出: -1
    说明:
        当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
        对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Choice_Top_Interview_28 {

    // String.index方法源码……qwq
    // 时间复杂度是O(N),空间复杂度是O(1)
    public int solution1(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()){
            return -1;
        }
        int max = haystack.length() - needle.length();
        char firstChar = needle.charAt(0);
        for (int i = 0; i <= max; i++) {
            if(haystack.charAt(i) != firstChar){
                while(++i <= max && haystack.charAt(i) != firstChar);
            }
            if(i <= max){
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j < end && haystack.charAt(j) == needle.charAt(k); j++, k++);
                if(j == end){
                    return i;
                }
            }
        }
        return -1;
    }
}
