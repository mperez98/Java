import java.util.Arrays;
import java.util.Stack;

public class Tree {
    Node root;

    // Constructor
    Tree () {
        root = null;
    }

    // create binary tree from expression read in from file
    public void createTree (String expr) {
        Stack theStack = new Stack();
        String[] operators = new String[] {"+", "-", "*", "/"};
        String[] tokens = expr.split(",*");

        Node newNode = new Node(null);
        this.root = newNode;
        Node current = newNode;

        for (String item:tokens) {
            if (item.equals("(")) {
                current.lchild = new Node(null);
                theStack.push(current);
                current = current.lchild;
            } else if (Arrays.asList(operators).contains(item)) {
                current.data = item;
                theStack.push(current);
                current.rchild = new Node(null);
            } else if (item.equals(")")) {
                if (!theStack.isEmpty()){
                    current = new Node (theStack.pop());
                }
            }
            else {
                current.data = item;
                if (!theStack.isEmpty()) {
                    Node newCur = new Node (theStack.pop());
                    current = newCur;
                }
            }
        }
    }

    // calculate operation between two operands
    public float operate (int oper1, int oper2, String token) {
        switch (token) {
            case "+":
                return (float) oper1 + (float) oper2;
            case "-":
                return (float) oper1 - (float) oper2;
            case "*":
                return (float) oper1 * (float) oper2;
            default:
                return (float) oper1 / (float) oper2;
        }
    }

    // evaluate the mathematical result of an expression tree
    public int evaluate (Node aNode) {
        if (aNode.lchild == null && aNode.rchild == null) {
            return (int) aNode.data;
        } else {
            int leftv = evaluate(aNode.lchild);
            int rightv = evaluate(aNode.lchild);
            float result = operate(leftv, rightv, (String) aNode.data);
            return (int) result;
        }
    }

    // convert in-order expression to pre-order expression
    public void preOrder (Node aNode) {
        if (aNode != null) {
            System.out.print(aNode.data + " ");
            preOrder(aNode.lchild);
            preOrder(aNode.rchild);
        }
    }

    // convert in-order expression to post-order expression
    public void postOrder (Node aNode) {
        postOrder(aNode.lchild);
        postOrder(aNode.rchild);
        System.out.print(aNode.data + " ");
    }

}
