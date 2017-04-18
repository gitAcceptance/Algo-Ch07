import java.io.*;
import java.util.*;

// for use with radix sorts only
public class RadixSortTest {

    public static void main (String [] args) {

        // get sort type: radix or radixshift
        String type = args[0];
        type = type.toLowerCase();

        // get  data set size
        int n = Integer.parseInt(args[1]);

        // get the radix
        int r = Integer.parseInt(args[2]);

        // max value is 2*n
        int max = 2*n;


        //  sort a random array of size n
        System.out.println(type+"Sort large random array size " + n + " ...");
        Integer [] a = ArrayBuilder.getRandom(n, 23);
        testWith(type, a, r, max);

        //sort an inorder array of size n
        System.out.println(type+"Sort large in order array size " + n + " ...");
        a = ArrayBuilder.getInorder(n);
        testWith(type, a, r, max);

        //sort a reverse order array of size n
        System.out.println(type+"Sort large reverse order array size " + n + " ...");
        a = ArrayBuilder.getReverseOrder(n);
        testWith(type, a, r, max);
    }

    // Parameters: a - integer array
    //             type - string either "radix" or "radixshift"
    // Post: sorts a with either radix sort that uses division if type is 
    //       "radix" or uses bit shifting on a radix that is a power of 2
    //        if type i "radixshift" reports time taken for the sort if 
    //        it is sorted, reports not sorted o/w
    // Throws: IllegalArgumentException if type is not "radix" or "radixshift"
    public static void testWith (String type, Integer [] a, int r, int max) {
        if (a.length < 21)
            System.out.println(Arrays.toString(a));  

        Sort sort;

        if (type.equals("radix"))
            sort = new RadixSort(a, r, max);
        else if (type.equals("radixshift"))
            sort = new RadixShiftSort(a, r);
        else 
            throw new IllegalArgumentException("Unknown sort: " + type);

        System.out.println("Sorting with " + type + " sort");
        long start = System.currentTimeMillis();
        sort.sort();
        long stop = System.currentTimeMillis();

        if (a.length < 21) {
            System.out.println(Arrays.toString(a));  
        }
        
        if (sort.isSorted()) {
            System.out.println("Time: " + (stop-start));
        } else {
            System.out.println("NOT sorted...");
        }
    }


}
