public abstract class Sort {

    // fields
    protected Integer[] data;

    // sort()
    public abstract void sort();

    // isSorted()
    // check that an array is sorted
    public boolean isSorted() {
        for (int i =0; i < data.length-1; i++)
            if (data[i] > data[i+1])
                return false;
        // else
        return true;
    }    


}