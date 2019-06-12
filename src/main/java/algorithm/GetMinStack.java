package algorithm;

import junit.framework.TestCase;

import java.util.Stack;

/**
 * @author cc
 * @Date 2019-04-14 00:13:13 Sunday
 * <p>
 * 实现一个栈,该栈带有出栈 入栈 取最小元素3个方法,要保证3个方法的时间复杂度都是o(1)
 */
public class GetMinStack extends TestCase {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element) {
        mainStack.push(element);

        // 如果辅助栈为空,或者新元素小于或等于辅助栈栈顶,则将新元素压入辅助栈
        if (minStack.empty() || element <= minStack.peek()) {
            minStack.push(element);
        }
    }

    public Integer pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if(mainStack.empty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public void testGetMinStack() throws Exception {
        GetMinStack getMinStack = new GetMinStack();
        getMinStack.push(5);
        getMinStack.push(9);
        getMinStack.push(3);
        getMinStack.push(1);
        getMinStack.push(8);
        getMinStack.push(3);
        System.out.println(getMinStack.getMin());
        getMinStack.pop();
        getMinStack.pop();
        getMinStack.pop();
        System.out.println(getMinStack.getMin());
    }


}
