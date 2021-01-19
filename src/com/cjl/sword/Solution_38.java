package com.cjl.sword;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
    问题描述：
        输入一个字符串，打印出该字符串中字符的所有排列。
        你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
    示例:
        输入：s = "abc"
        输出：["abc","acb","bac","bca","cab","cba"]
    限制：
        1 <= s 的长度 <= 8
 */
public class Solution_38 {

    // 回溯法，剪枝
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] solution1(String s){
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    private void dfs(int x){
        if(x == c.length - 1){
            // 添加排列方案
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            // 重复，因此剪枝
            if(set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            swap(i,x);       // 交换，将 c[i] 固定在第 x 位
            dfs(x+1);   // 开启固定第 x + 1 位字符
            swap(i,x);      // 恢复交换
        }
    }
    private void swap(int a,int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
