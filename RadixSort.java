
import java.io.*;
import java.util.*;

public class RadixSort extends Sort {

    // radix used for sort
    protected  int RADIX;
    // max value (base 10)
    protected  int MAX;


    public RadixSort(Integer[] a, int radix, int max) {
        this.data = a;
        this.RADIX = radix;
        this.MAX = max;
    }

    // Post: array is sorted in ascending order
    public void sort() {
        Integer[] bin = new Integer[data.length];     
        int[] count = new int[RADIX];
        int digits = (int)Math.ceil(Math.log10(MAX) / Math.log10(RADIX));
        radix(bin, digits, RADIX, count);
    }

    // Parameters: B - the bins
    //             k - the max value in the array, base r
    //             r - the base logr(max) == k
    //             count - count on each of r digits in a value in the array
    // Post: array is sorted in ascending order
    private void radix(Integer[] B, int k, int r, int[] count) {

        // count[i] stores number of records in bin[i]

        System.out.println(" k = " + k + " r = " + r);
        int i, j, rtok;
        // For each of  k digits
        for (i=0,  rtok=1; i<k; i++, rtok*=r) { 
        // Initialize count
            for (j=0; j<r; j++) {
                count[j] = 0;
            }

            // count the number of records for each bin on this pass on
            // based on the  digit in r^rtok place
            for (j=0; j<data.length; j++) {
                count[data[j] / rtok %r]++;
            }

            // convert count to a cumulative frequency
            // count[j] will be index in B for last slot of bin j + 1
            for (j=1; j<r; j++) {
                count[j] = count[j-1] + count[j];        
            }


            // Put records from data array into bins, working from 
            // end of data array to preserve secondary order based
            // on previous sorts lower order digits
            for (j=data.length-1; j>=0; j--) {
                B[--count[ data[j] /rtok %r]] = data[j];
            }

            // Copy B back to data array
            for (j=0; j<data.length; j++) {
                data[j] = B[j]; 
            }
            // System.out.println("A = " + Arrays.toString(A));
        }
    }

       // Parameter: A - array
       // Post: Prints sorted if A is sorted in ascending order, NOT sorted o/w
       public void check(Integer[] A) {
            for (int i =0; i < data.length-1; i++)
             if (data[i] > data[i+1]) {
		System.out.println(data[i] + " > " + data[i+1]);
	        System.out.println("NOT sorted");
            }
           System.out.println("sorted");
      }    
}

// RadixShiftSort
class RadixShiftSort extends RadixSort {

    public RadixShiftSort(Integer[] a, int radix) {
        super(a, radix, 2*a.length);
        if ((radix & (radix - 1)) != 0) {
            throw new IllegalArgumentException("Radix given was not a power of 2");
        }
        if (radix > 16) {
            throw new IllegalArgumentException("Radix given was larger than 16");
        }
    }



    private void radix(Integer[] B, int k, int r, int[] count) {

        // count[i] stores number of records in bin[i]

        System.out.println(" k = " + k + " r = " + r);
        int i, j, rtok, idk;
        // For each of  k digits
        for (i=0,  rtok=1; i<k; i++, rtok*=r) { 
        // Initialize count
            for (j=0; j<r; j++) {
                count[j] = 0;
            }

            // count the number of records for each bin on this pass on
            // based on the  digit in r^rtok place
            for (j=0; j<data.length; j++) {
                idk = data[j] >> (rtok & (r-1));
                count[idk]++;
            }

            // convert count to a cumulative frequency
            // count[j] will be index in B for last slot of bin j + 1
            for (j=1; j<r; j++) {
                count[j] = count[j-1] + count[j];        
            }


            // Put records from data array into bins, working from 
            // end of data array to preserve secondary order based
            // on previous sorts lower order digits
            for (j=data.length-1; j>=0; j--) {
                idk = data[j] >> (rtok & (r-1));
                B[--count[idk]] = data[j];
            }

            // Copy B back to data array
            for (j=0; j<data.length; j++) {
                data[j] = B[j]; 
            }
            // System.out.println("A = " + Arrays.toString(A));
        }
    }

}
