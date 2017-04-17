import java.io.*;
import java.util.*;


public class HeapSort extends Sort {

    public HeapSort(Integer [] a) {
	this.data = a;
    }                

    // sort the array
    public void sort() {
	MaxHeap h = new MaxHeap(data, data.length, data.length);
	h.comps=0; h.moves=0;
	for (int i = data.length-1; i >= 0; i--) {
	    data[i] = h.remove(0);
	}
    }

}

// HeapSortOp
class HeapSortOp extends HeapSort {


}
