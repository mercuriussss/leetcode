package com.cjl.leetcode;

import com.cjl.common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    20. 有效的括号
        给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。
    示例 1：
        输入：s = "()"
        输出：true
    示例 2：
        输入：s = "()[]{}"
        输出：true
    示例 3：
        输入：s = "(]"
        输出：false
    提示：
        1 <= s.length <= 10^4
        s 仅由括号 '()[]{}' 组成
 */
public class Question_20 {

    // 时间复杂度O(N)，空间复杂度O(N)
    public boolean solution1(String s) {
        if (s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('(',')');
                put('[',']');
                put('{','}');
            }
        };
        for (int i = 0; i < s.length() ; i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(map.get(s.charAt(i)));
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
                        return false;
                    }
            }
        }
        return true;
    }
}
