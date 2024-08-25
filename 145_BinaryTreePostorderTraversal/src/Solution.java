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

    public static List<Integer> postorderTraversal(TreeNode root) {

        return new ArrayList<>();
    }
}