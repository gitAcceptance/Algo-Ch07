import java.io.*;
import java.util.*;

public class InsertionSort extends Sort {

	public InsertionSort(Integer [] a) {
		this.data = a;
	}                

	// sort the array
	public void sort() {
		// insert i'th record
		for (int i=1; i<data.length; i++) { 
		// insert position i
			Integer temp = data[i];
			int pos = i;
    		while (pos > 0 && data[pos-1] > temp) {
    			data[pos] = data[pos-1];
    			pos--;
    		}
			data[pos] = temp;
		}
	}
}



// DoubleInsertionSort Class here
class DoubleInsertionSort extends InsertionSort {

	public DoubleInsertionSort(Integer [] a) {
		super(a);
	}


    public void sort() {
        int smaller, larger;
        int toMove, middle;

        if (this.data.length % 2 == 0) { // if it's even do this
            middle = this.data.length/2 - 1;
            for (int edge = 0; edge < this.data.length/2 ; edge++) {

                // Get the pair
                if (this.data[middle - edge ] > this.data[middle + edge + 1]) {
                    smaller = this.data[middle + edge + 1];
                    larger = this.data[middle - edge ];
                } else {
                    larger = this.data[middle + edge + 1];
                    smaller = this.data[middle - edge ];
                }

                // Insert the larger
                for (toMove = middle+edge; this.data[toMove] > larger; toMove--) {
                    this.data[toMove + 1] = this.data[toMove];
                }
                this.data[toMove + 1] = larger;


                // Insert the smaller
                for (toMove = middle-edge+1; this.data[toMove] < smaller; toMove++) {
                    this.data[toMove - 1] = this.data[toMove];
                }
                this.data[toMove - 1] = smaller;

            }

        } else { // else it's odd
            middle = this.data.length/2;
            for (int edge = 0; edge < this.data.length/2; edge++) {

                // Get the pair
                if (this.data[middle - edge - 1] > this.data[middle + edge + 1]) {
                    smaller = this.data[middle + edge + 1];
                    larger = this.data[middle - edge - 1];
                } else {
                    larger = this.data[middle + edge + 1];
                    smaller = this.data[middle - edge - 1];
                }

                // Insert the larger
                for (toMove = middle+edge; this.data[toMove] > larger; toMove--) {
                    this.data[toMove + 1] = this.data[toMove];
                }
                this.data[toMove + 1] = larger;


                // Insert the smaller
                for (toMove = middle-edge; this.data[toMove] < smaller; toMove++) {
                    this.data[toMove - 1] = this.data[toMove];
                }
                this.data[toMove - 1] = smaller;

            }

        }


    }

}


