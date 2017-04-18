import java.io.*;
import java.util.*;

public class HeapSortTest {


    public static void main (String [] args) {
        Integer [] a;
        Integer[] copyA;
        int n;

        // get large data set size
        n = Integer.parseInt(args[0]);

        // heap sort a random array of size n
        System.out.println("HeapSort large random array size " + n + " ...");
        a = ArrayBuilder.getRandom(n);
        copyA = Arrays.copyOf(a, n);
        testWith(a, "heap");

        // heap sort an inorder array of size n
        System.out.println("HeapSort large in order array size " + n + " ...");
        a = ArrayBuilder.getInorder(n);
        testWith(a, "heap");

        // heap sort a reverse order array of size n
        System.out.println("HeapSort large reverse order array size " + n + " ...");
        a = ArrayBuilder.getReverseOrder(n);
        testWith(a, "heap");


        // optimized heap sort a random array of size n
        System.out.println("Optimized HeapSort large random array size " + n + " ...");
        a = Arrays.copyOf(copyA, n);
        testWith(a, "opt");

        // optimized heap sort an inorder array of size n
        System.out.println("Optimized HeapSort large in order array size " + n + " ...");
        a = ArrayBuilder.getInorder(n);
        testWith(a, "opt");

        // optimized heap sort a reverse order array of size n
        System.out.println("Optimized HeapSort large reverse order array size " + n + " ...");
        a = ArrayBuilder.getReverseOrder(n);
        testWith(a, "opt");

    }
    // Parameters: a - integer array
    //             type - string either "heap" or any other == "opt"
    // Post: sorts a with either a standard heap sort if type is 
    //       "heap" or an optimized siftdown if type is any other string
    //        reports time taken for the sort if it is sorted, reports not
    //        sorted o/w
    public static void testWith (Integer [] a, String type) {
        if (a.length < 21) {
            System.out.println(Arrays.toString(a));    	
        }
        
        HeapSort sort;

        if (type.equals("heap")) {
            sort = new HeapSort(a);
        } else {
            sort = new HeapSortOp(a);
        }

        long start = System.currentTimeMillis();
        sort.sort();
        long stop = System.currentTimeMillis();

        if (sort.isSorted()) {
            System.out.println("Time: " + (stop-start));
        } else {
            System.out.println("NOT sorted...");
            if (a.length < 21)
                System.out.println(Arrays.toString(a));  
        }

    }
}
