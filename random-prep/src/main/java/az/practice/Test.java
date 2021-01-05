package az.practice;

import com.ds.tree.BinaryTreeNode;
import com.ds.tree.TreeNode;
import com.ds.utils.TreeUtils;

public class Test {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node = TreeUtils.createRandomBST(10);
        System.out.println(TreeUtils.preorderTraversal(node));
        TreeUtils.prettyPrintTree(node);
    }

}
