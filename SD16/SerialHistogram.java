public class SerialHistogram{
    private static void computeHistogram(int[] array, long [] buckets, int startLocation, int length) {
        for(int counter = startLocation; counter < startLocation + length; counter = counter + 1) {
            buckets[array[counter]] = buckets[array[counter]] + 1;
        }
    }
    public static void main(String [] argv) {
        int numberOfBuckets = 100;
        int inputSize = 100000;
        int [] array = new int[inputSize];
        long [] buckets = new long [numberOfBuckets];
        for (int i = 0; i < inputSize; i = i + 1)
            array[i] = i % numberOfBuckets;
        computeHistogram(array, buckets, 0, array.length);
        for (int i = 0; i < buckets.length; i = i + 1)
            System.out.print(buckets[i] + " ");
        System.out.println("");
    }
}
