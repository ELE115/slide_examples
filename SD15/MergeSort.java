// This code takes inspiration from the mergesort code in the COS 126 slides by 
//  Sedgewick and Wayne

public class MergeSort{
    public static void merge(String [] array, String [] aux, int beginning, int middle, int end)
    {
        // i tracks where we are in the left array
        int i = beginning;
        // j tracks where we are in the right array
        int j = middle;
        // k represents the location in the temporary merged array
        for(int k = beginning; k < end; k = k + 1) {
            if (i==middle) {
                // we have read all of the left array so copy from the right array
                aux[k] = array[j];
                j = j + 1;
            }
            else if (j == end) {
                // we have read all of the right array so copy from the left array
                aux[k] = array[i];
                i = i + 1;
            }
            else if (array[j].compareTo(array[i]) < 0) {
                aux[k] = array[j];
                j = j + 1;
            }
            else {
                aux[k] = array[i];
                i = i + 1;
            }
        }
        // copy into original array
        for(int l = beginning; l < end; l = l + 1) {
            array[l] = aux[l];
        }
    }
    public static void sort(String [] array, String [] aux, int beginning, int end) {
        // sort from array [beginning to end)
        if(beginning >= (end -1)) {
            // this is base case and a list of one is already sorted
            return;
        }
        int middle = beginning + (end - beginning)/2;
        sort(array, aux, beginning, middle);
        sort(array, aux, middle, end);
        merge(array, aux, beginning, middle, end);
//        for (int i = 0; i < array.length; i = i + 1)
//            System.out.print(array[i] + " ");
//        System.out.println("");
    }
    public static void main(String [] argv) {
        String [] array = new String [argv.length];
        String [] aux = new String [argv.length];
        for (int i = 0; i < argv.length; i = i + 1)
            array[i] = argv[i];
        sort(array, aux, 0, array.length);
        for (int i = 0; i < array.length; i = i + 1)
            System.out.print(array[i] + " ");
        System.out.println("");
    }
}
