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

}


