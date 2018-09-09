import java.io.*;

public class Main {

    public static void main(String[] args) {
        // Open file and read in info
        File inputFile = new File("/Users/MacbookAir1/Documents/CS313E/josephus.txt");
        BufferedReader reader = null;


        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String text = null;

            int num_sold = Integer.valueOf(reader.readLine().trim());
            int start = Integer.valueOf(reader.readLine().trim());
            int n = Integer.valueOf(reader.readLine().trim());

            // create circular linked list and populate it with numbered soldiers
            CircularList sold_lst = CircularList();
            for (int i=1; i<num_sold+1; i++) {
                sold_lst.insert(i);
            }

            // start elimination pattern and display output
            for (int i; i<num_sold; i++) {
                Link arr[] = sold_lst.delete_after(start, n);
                Link newPlace = arr[0];
                Link del_link = arr[1];
                start = newPlace.data;
                System.out.println(del_link.data);
            }
        }
        catch(FileNotFoundException) {
            System.out.print("Error: File not found");
        } catch(IOException) {
            System.out.print("Error: Input/Output exception");
        }

        }
    }
