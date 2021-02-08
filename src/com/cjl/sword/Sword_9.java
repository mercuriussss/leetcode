package com.cjl.sword;

/*
    问题描述：
        用两个栈实现一个队列。
        队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
        (若队列中没有元素，deleteHead 操作返回 -1 )
    示例 1：
        输入：
        ["CQueue","appendTail","deleteHead","deleteHead"]
        [[],[3],[],[]]
        输出：[null,null,3,-1]
    示例 2：
        输入：
            ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
            [[],[],[5],[2],[],[]]
        输出：[null,-1,null,null,5,2]
    提示：
        1 <= values <= 10000
        最多会对 appendTail、deleteHead 进行 10000 次调用
 */

import java.util.Stack;

public class Sword_9 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Sword_9() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        int deleteNode;
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        deleteNode = stack2.pop();
        return deleteNode;
    }
}
