public class StringSearch {
    public static int search(String key, String [] array) {
        for(int i = 0; i < array.length; i = i + 1) {
            if(array[i].equals(key))
                return i;
        }
        return -1;
    }
    public static void main(String [] argv) {
        String [] array = new String [argv.length - 1];
        for (int i = 1; i < argv.length; i = i + 1)
            array[i-1] = argv[i];
        int found = search(argv[0], array);
        if(found >= 0) {
            System.out.println("Found " + argv[0] + " at position " + found);
        }
    }
}
