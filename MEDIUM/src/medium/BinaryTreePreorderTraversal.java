package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import classes.TreeNode;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal_iterative_original(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            list.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        return list;
    }
    
    public List<Integer> preorderTraversal_iterative_online(TreeNode root) {
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        if(root == null) return list;
        while(root != null || !stack.isEmpty()){
            if(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop().right;
            }
        }
        return list;
    }
    
    //recursive solution is really trivial:
    public List<Integer> preorderTraversal_recursive(TreeNode root) {
        List<Integer> list = new ArrayList();
        return pre(root, list);
    }
    
    List<Integer> pre(TreeNode root, List<Integer> list){
        if(root == null) return list;
        list.add(root.val);
        pre(root.left, list);
        pre(root.right, list);
        return list;
    }
    
}
