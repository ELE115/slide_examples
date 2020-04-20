public class SortedStringSearch {
    // Important, this assumes that the array is sorted
    // This assumes that end is one beyond the end of the array
    public static int binarySearch(String key, String [] array, int beginning, int end) {
        if(beginning >= end) {
            return -1;
        }
        int middle = beginning + (end - beginning)/2;
        int comparison = array[middle].compareTo(key);
        if(comparison > 0) {
            return binarySearch(key, array, middle, end);
        }
        if(comparison < 0) {
            return binarySearch(key, array, beginning, middle);
        }
        return middle; 
    }
    public static void main(String [] argv) {
        String [] array = new String [argv.length - 1];
        for (int i = 1; i < argv.length; i = i + 1)
            array[i-1] = argv[i];
        int found = binarySearch(argv[0], array, 0, array.length);
        if(found >= 0) {
            System.out.println("Found " + argv[0] + " at position " + found);
        }
    }
}
