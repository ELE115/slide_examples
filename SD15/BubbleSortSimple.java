public class BubbleSortSimple{
    public static void sort(String [] array) {
        for(int i = 0; i < (array.length - 1); i = i + 1) {
            for(int j = 0; j < (array.length - 1); j = j + 1) {
                if(array[j].compareTo(array[j+1]) > 0)
                {
                    // swap the two variables
                    String temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                for (int k = 0; k < array.length; k = k + 1)
                    System.out.print(array[k] + " ");
                System.out.println("");
            }
            System.out.println("");
        }
    }
    public static void main(String [] argv) {
        String [] array = new String [argv.length];
        for (int i = 0; i < argv.length; i = i + 1)
            array[i] = argv[i];
        sort(array);
        for (int i = 0; i < array.length; i = i + 1)
            System.out.print(array[i] + " ");
        System.out.println("");
    }
}
