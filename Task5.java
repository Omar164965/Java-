 import java.util.*;

class TreeNode {
    String val;
    TreeNode left, right;

    TreeNode(String val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class ExpressionTree {
    TreeNode root;
    Map<String, Integer> vars;

    ExpressionTree() {
        this.root = null;
        this.vars = new HashMap<String, Integer>();
    }

    void build(String exp) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                continue;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                TreeNode node = new TreeNode(Character.toString(c));
                node.left = stack.pop();
                node.right = stack.pop();
                stack.push(node);
            } else if (Character.isLetter(c)) {
                TreeNode node = new TreeNode(Character.toString(c));
                stack.push(node);
            } else if (Character.isDigit(c)) {
                String num = "";
                while (i < exp.length() && Character.isDigit(exp.charAt(i))) {
                    num += exp.charAt(i++);
                }
                i--;
                TreeNode node = new TreeNode(num);
                stack.push(node);
            } else if (c == ')') {
                continue;
            }
        }
        this.root = stack.pop();
    }

    int evaluate(TreeNode node) {
        if (node.left == null && node.right == null)