import java.util.*;

public class MaxHeap {

    protected Integer[]  heap; // The array to holding the heap
    protected int cap;  // max size or capacity of the heap
    protected int n;    // current size of heap


    public MaxHeap (Integer[] heap, int cap, int n) {
	this.heap = heap; this.cap = cap; this.n = n;
	buildHeap();
    }

    public MaxHeap (int cap) {
	this.cap = cap;
	this.heap = new Integer[cap];
	this.n = 0;
    }

    // return size
    public int size() {
	return this.n;
    }

    // returns true if this is a legal heap, handy for testing
    public boolean isHeap() {
        int pos = n/2 - 1;
        if (heap[pos] < heap[leftChild(pos)])
	    return false;
        if (2*pos + 2 < this.n && heap[pos] < heap[rightChild(pos)])
	    return false;
	for (int i = pos-1; i>=0; i--)
            if (heap[i] < heap[leftChild(i)] || 
                heap[i] < heap[rightChild(i)] )
		return false;
	return true;

    }

    // insert new value into the heap
    public void insert (Integer element) {
	if (this.n >= this.cap)
	    throw new IllegalStateException("heap is full");
        this.heap[this.n] = element;
	this.n++;
	siftup(this.n-1);
    }


    // remove and return maximum in the heap
    public Integer removeMax () {
        if (n <= 0)
	    throw new IllegalStateException("removing from empty heap");
	return this.remove(0);
    }

    // remove and return element at specified position, pos
    public Integer remove(int pos) {
	if (pos < 0 || pos >=n)
	    throw new IllegalArgumentException();
        Integer result = this.heap[pos];
        // swap last leaf and this position
	this.heap[pos] = this.heap[n-1];
	this.n--;
	// if this heap is empty or we removed the last position
        if (this.n == 0 || this.n == pos)
	    return result;
        // if this new element > parent, sift up
        if (this.heap[pos] > this.heap[parent(pos)])
	    siftup(pos);
	// else sift it down
	else 
	    siftdown(pos);
       return result;
        
    }

    // returns string representation of the heap
    public String toString () {
	return Arrays.toString(this.heap);
    }

    // heapify contents of the array
    protected void buildHeap() {
	for (int i = n/2-1; i>=0; i--) {
	    siftdown(i);
	}
    }

    // put element i of the array in its correct place
    protected void siftdown(int pos) {
	if (pos < 0 || pos >= this.n)
	    throw new IllegalArgumentException(" pos = " + pos);
        while (!this.isLeaf(pos)) {
	    int i = this.leftChild(pos);
	    // get the larger child
	    if (i < n-1 && this.heap[i] < this.heap[i+1])
		i++;
            if (this.heap[pos] >= this.heap[i])
		return; // what is at pos is larger than both children
            this.swap(pos, i); // swap pos and i
            pos = i; // move pos down
	}
    }


    // put element i of the array in its correct place from pos
    protected void siftup(int pos) {
	int parent = 0;
        if (pos > 0)
	    parent = parent(pos);
	while (pos > 0 && 
               this.heap[pos] > this.heap[parent]) {
            swap(pos, parent);
	    pos = parent;
	    parent = parent(pos);
	}
    }


    // returns the position of the left child of element at pos
    protected int leftChild (int pos) {
	if (2*pos + 1 >= this.n)
	    throw new IllegalArgumentException("no left child");
	return 2*pos + 1;
    }

    // return the position of the right child of element at pos
    protected int rightChild(int pos) {
	if (2*pos + 2 >= this.n)
	    throw new IllegalArgumentException("no right child");
	return 2*pos + 2;
    }

    // return the position of the parent of element at pos
    protected int parent(int pos) {
	if (pos < 0 || pos >= n)
	    throw new IllegalArgumentException();
        return (pos-1)/2;
    }

    // returns true if this is a leaf
    protected boolean isLeaf(int pos) {
	return pos >= n/2 && pos < n;
    }

    // swap positions i and j
    protected void swap (int i, int j) {
	Integer temp = this.heap[i];
	this.heap[i] = this.heap[j];
	this.heap[j] = temp;
    }
}


// MaxHeapOp
class MaxHeapOp extends MaxHeap {
    public MaxHeapOp (Integer[] heap, int cap, int n) {
        super(heap, cap, n)
    }

    public MaxHeap (int cap) {
        super(new Integer[cap], cap, 0)
    }


    // FIXME need to override removemax

    // FIXME need to implement a new siftdown to be used for removals

}
