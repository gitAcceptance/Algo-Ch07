import java.io.*;
import java.util.*;

public class InsertionSortTest {


    public static void main (String [] args) {

        Integer [] a;
        Integer[] copyA;
        int n;

        // get large data set size
        n = Integer.parseInt(args[0]);

        // insertion sort a random array of size n
        System.out.println("InsertionSort large random array size " + n + " ...");
        a = ArrayBuilder.getRandom(n);
        copyA = Arrays.copyOf(a, n);
        testWith(a, "insertion");
        System.out.println();

        // insertion sort an inorder array of size n
        System.out.println("InsertionSort large in order array size " + n + " ...");
        a = ArrayBuilder.getInorder(n);
        testWith(a, "insertion");
        System.out.println();

        // insertion sort a reverse order array of size n
        System.out.println("InsertionSort large reverse order array size " + n + " ...");
        a = ArrayBuilder.getReverseOrder(n);
        testWith(a, "insertion");
        System.out.println();

        // insertion sort an array with smallest values in the center
        // example    5 3 1 2 4
        System.out.println("InsertionSort smallest in middle array size " + n + " ...");
        a = ArrayBuilder.getSmallestInMiddle(n);
        testWith(a, "insertion");
        System.out.println();

        // double insertion sort a random array of size n
        System.out.println("Double InsertionSort large random array size " + n + " ...");
        a = Arrays.copyOf(copyA, n);
        testWith(a, "double");
        System.out.println();

        // double insertion sort an inorder array of size n
        System.out.println("Double InsertionSort large in order array size " + n + " ...");
        a = ArrayBuilder.getInorder(n);
        testWith(a, "double");
        System.out.println();

        // double insertion sort a reverse order array of size n
        System.out.println("Double InsertionSort large reverse order array size " + n + " ...");
        a = ArrayBuilder.getReverseOrder(n);
        testWith(a, "double");
        System.out.println();

        // double insertion sort an array with smallest values in the center
        // example    5 3 1 2 4
        System.out.println("Double InsertionSort smallest in middle array size " + n + " ...");
        a = ArrayBuilder.getSmallestInMiddle(n);
        testWith(a, "double");

    }

    // Parameters: a - integer array
    //             type - string either "insertion" or any other == "double"
    // Post: sorts a with either a standard insertion sort if type is 
    //       "insertion" or a double insertion sort if type is any other string
    //        reports time taken for the sort if it is sorted, reports not
    //        sorted o/w
    public static void testWith (Integer [] a, String type) {
        if (a.length < 21)
            System.out.println(Arrays.toString(a));  
            InsertionSort sort;
        if (type.equals("insertion"))
            sort = new InsertionSort(a);
        else
            sort = new DoubleInsertionSort(a);

        long start = System.currentTimeMillis();
        sort.sort();
        long stop = System.currentTimeMillis();
        if (sort.isSorted())
            System.out.println("Time: " + (stop-start));
        else {
            System.out.println("NOT sorted...");
        if (a.length < 21)
            System.out.println(Arrays.toString(a));  
        }
    }



}
