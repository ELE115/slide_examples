public class SyncHistogram{
    private static synchronized void incrementBucket(long [] buckets, int location) {
        buckets[location] = buckets[location] + 1;
    }
    private static void computeHistogram(int[] array, long [] buckets, int startLocation, int length) {
        System.out.println("computeHistogram called with startLocation " + startLocation + " length " + length);
        for(int counter = startLocation; counter < startLocation + length; counter = counter + 1) {
            incrementBucket(buckets, array[counter]);
        }
    }
    public static void main(String [] argv) {
        int numberOfBuckets = 100;
        int inputSize = 100000;
        int numberOfThreads = 5;
        int [] array = new int[inputSize];
        long [] buckets = new long [numberOfBuckets];
        for (int i = 0; i < inputSize; i = i + 1)
            array[i] = i % numberOfBuckets;
        Thread [] threads = new Thread [numberOfThreads];
        // create the threads
        for(int i = 0; i < numberOfThreads; i = i + 1) {
            final int tempI = i;
            threads[i] = new Thread("" + i){
                public void run(){
                    computeHistogram(array, buckets, (inputSize/numberOfThreads)*tempI, inputSize/numberOfThreads);
                }
            };
        }
        // start all of the threads
        for(int i = 0; i < numberOfThreads; i = i + 1) {
            threads[i].start();
        }
        // wait for all of the threads to finish
        for(int i = 0; i < numberOfThreads; i = i + 1) {
            try { 
                threads[i].join();
            }
            catch (Exception e) { 
                System.out.println(e); 
            } 
        }
        for (int i = 0; i < buckets.length; i = i + 1)
            System.out.print(buckets[i] + " ");
        System.out.println("");
    }
}
