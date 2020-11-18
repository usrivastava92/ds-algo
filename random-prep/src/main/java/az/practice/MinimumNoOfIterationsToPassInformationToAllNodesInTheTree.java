package az.practice;

import com.ds.tree.TreeNode;
import com.ds.utils.TreeUtils;

import java.util.Arrays;
import java.util.Collections;

public class MinimumNoOfIterationsToPassInformationToAllNodesInTheTree {

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = TreeUtils.createRandomTree(20);
        System.out.println(TreeUtils.getLevelOrderTraverseListLevelWise(treeNode));

    }

    public static int minIter(TreeNode<Integer> treeNode) {
        if (treeNode == null || TreeUtils.isLeaf(treeNode)) {
            return 0;
        }
        if (TreeUtils.getHeight(treeNode) == 2) {
            return treeNode.getChildren().size();
        }
        Integer[] minItrTemp = treeNode.getChildren().stream().mapToInt(MinimumNoOfIterationsToPassInformationToAllNodesInTheTree::minIter).boxed().toArray(Integer[]::new);
        Arrays.sort(minItrTemp, Collections.reverseOrder());
        for (int k = 0; k < treeNode.getChildren().size(); k++) {
            int temp = minItrTemp[k] + k + 1;
            //minItr[u] = Math.max(minItr[u], temp);
        }
        return 1;
    }


}
/*
1. Get minItr(B) of all children (B) of a node (A)
2. Sort all minItr(B) in descending order
3. Get minItr of A based on all minItr(B)
    minItr(A) = child(A)
    For children B from i = 0 to child(A)
             minItr(A) = max ( minItr(A), minItr(B) + i + 1)

Base cases would be:
If node is leaf, minItr = 0
If node's height is 1, minItr = children count
 */