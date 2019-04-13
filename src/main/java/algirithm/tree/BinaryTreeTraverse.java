package algirithm.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cc
 * @Date 2019-04-14 00:16:16 Sunday
 */
public class BinaryTreeTraverse {

    // 前序遍历
    // 左右根,因为是栈,所以先压右节点
    public static void preNodeTraverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.rightNode != null) {
                stack.push(cur.rightNode);
            }
            if (cur.leftNode != null) {
                stack.push(cur.leftNode);
            }
        }
    }

    // 中序遍历 左根右
    // 一直压入左节点 弹出最左的节点 弹出最左的根节点 压入右节点
    public static void inNodeTraverse(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur =  root;
        while (!stack.isEmpty() || cur != null) {
            while (cur!=null){
                stack.push(cur.leftNode);
                cur = cur.leftNode;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.rightNode;
        }
    }

    // 后序遍历 左右根
    public static void postNodeTraverse(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> outPut = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            outPut.push(cur.val);
            // 先压入右节点,进入输出栈,右边节点就在下面
            if(cur.rightNode != null){
                stack.push(cur.rightNode);
            }
            if(cur.leftNode != null){
                stack.push(cur.leftNode);
            }
        }
        while (!outPut.isEmpty()){
            result.add(outPut.pop());
        }
    }


}
