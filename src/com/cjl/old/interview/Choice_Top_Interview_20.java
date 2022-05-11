package com.cjl.old.interview;

import java.util.Stack;

/*
    问题描述：
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
    示例 1：
        输入：s = "()"
        输出：true
    示例 2：
        输入：s = "()[]{}"
        输出：true
    示例 3：
        输入：s = "(]"
        输出：false
    示例 4：
        输入：s = "([)]"
        输出：false
    示例 5：
        输入：s = "{[]}"
        输出：true
    提示：
        1 <= s.length <= 10^4
        s 仅由括号 '()[]{}' 组成
 */
public class Choice_Top_Interview_20 {

    // 时间复杂度是O(N)，空间复杂度是O(N)
    public boolean solution1(String s) {
        if(s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.empty() || c!= stack.pop()){
                return false;
            }
        }
        return stack.empty();
    }
}
