import java.io.*;

public class Main {

    public static void main(String[] args) {
	    // read in file
        File inputFile = new File("/Users/MacbookAir1/Documents/CS/expression.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(inputFile));

            String expr = reader.readLine().trim();

            // initialize expression tree
            Tree newTree = new Tree();
            newTree.createTree(expr);
            int result = newTree.evaluate(newTree.root);

            // display output
            System.out.println(expr.trim() + " = " + result);
            System.out.print("Prefix Expression: ");
            newTree.preOrder(newTree.root);
            System.out.println();
            System.out.print("Postfix Expression: ");
            newTree.postOrder(newTree.root);
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}