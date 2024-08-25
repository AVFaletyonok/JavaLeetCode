import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        TreeNode rightLieftChild = new TreeNode(3);
        TreeNode rootRightChild = new TreeNode(2, rightLieftChild, null);
        TreeNode root = new TreeNode(1, null, rootRightChild);

        List<Integer> postorderList = postorderTraversal(root);

        System.out.println(Arrays.toString(postorderList.toArray()));

    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        addNodeToList(root, resultList);
        return resultList;
    }

    private static void addNodeToList(TreeNode curNode, List<Integer> list) {
        if (curNode == null) return;

        if (curNode.left != null) addNodeToList(curNode.left, list);
        if (curNode.right != null) addNodeToList(curNode.right, list);
        list.add(curNode.val);
    }
}