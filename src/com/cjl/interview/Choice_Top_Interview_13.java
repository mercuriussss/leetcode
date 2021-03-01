package com.cjl.interview;

/*
    问题描述：
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串""。
    示例 1：
        输入：strs = ["flower","flow","flight"]
        输出："fl"
    示例 2：
        输入：strs = ["dog","racecar","car"]
        输出：""
        解释：输入不存在公共前缀。
    提示：
        0 <= strs.length <= 200
        0 <= strs[i].length <= 200
        strs[i] 仅由小写英文字母组成
 */
public class Choice_Top_Interview_13 {

    public static String solution1(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefixStr = "";
        String tmp = "";
        boolean flag = true;
        for (int i = 0; i < strs[0].length() && flag; i++) {
            tmp = strs[0].substring(0,i + 1);
            for (String str : strs) {
                if (!str.startsWith(tmp)) {
                    flag = false;
                    break;
                }
            }
            prefixStr = flag? tmp:prefixStr;
        }
        return prefixStr;
    }

}
