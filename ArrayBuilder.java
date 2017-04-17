import java.util.*;

public class ArrayBuilder {

    // Parameter n - the array size
    // Returns - a random Integer array, size n, values in range 0-(2n-1)
    public static Integer[] getRandom(int n) {
	Integer [] result = new Integer[n];
	Random rand = new Random();
	rand.setSeed(17);
	for (int i = 0; i < n; i++)
	    result[i] = rand.nextInt(2*n);
	return result;
    }

    // Parameter n - the array size
    //           seed - to seed the random number generator
    // Returns - a random Integer array, size n, values in range 0-(2n-1)
    public static Integer[] getRandom(int n, long seed) {
	Integer [] result = new Integer[n];
	Random rand = new Random();
      	rand.setSeed(seed);
	for (int i = 0; i < n; i++)
	    result[i] = rand.nextInt(2*n);
	return result;
    }

    // Parameter n - the array size
    // Returns - a random Integer array, size n, values in range 0-(2n-1)
    public static Integer[] getRandom(int n, int low, int high) {
	int range = high-low + 1;
	Integer [] result = new Integer[n];
	Random rand = new Random();
	for (int i = 0; i < n; i++)
	    result[i] = rand.nextInt(range) + low;
	return result;
    }

    // Parameter n - the array size
    //           seed - to seed the random number generator
    // Returns - a random Integer array, size n, values in range 0-(2n-1)
    public static Integer[] getRandom(int n, int low, int high, long seed) {
	int range = high-low + 1;
	Integer [] result = new Integer[n];
	Random rand = new Random();
	rand.setSeed(seed);
	for (int i = 0; i < n; i++)
	    result[i] = rand.nextInt(range) + low;
	return result;
    }

    // Parameter n - the array size
    // Returns - an inorder array, size n, even values 0, 2, ..., 2n-2
    public static Integer[] getInorder(int n) {
	Integer [] result = new Integer[n];
	for (int i = 0; i < n; i++)
	    result[i] = 2*i;
	return result;
    }

    // Parameter n - the array size
    // Returns - an reverse order array, size n, even values 2n, 2n-2, ... 0
    public static Integer[] getReverseOrder(int n) {
	Integer [] result = new Integer[n];
	for (int i = 0; i < n; i++)
	    result[i] = 2*(n-i);
	return result;
    }

    // Parameter n - the array size
    // Returns - for odd n:  n, n-2, ..., 1, 2, ..., n-1
    //           for even n: n, n-2, ,,,, 2, 1, ..., n-1
    public static Integer[] getSmallestInMiddle(int n) {
	Integer [] result = new Integer[n];
	int low, high;
	int count = 1;
	if (n % 2 == 1) {
	    low = high = n/2;
	    result[low] = count++;
	} else {
	    high = n/2;
	    low = high-1;
            result[high] = count++;
            result[low] = count++;
	}

        while (low > 0 && high < n-1) {
            result[++high] = count++;
            result[--low] =  count++;
	}
	return result;

    }
}
