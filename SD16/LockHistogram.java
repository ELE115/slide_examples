import java.util.concurrent.locks.ReentrantLock;
public class LockHistogram{
    private static void computeHistogram(int[] array, long [] buckets, ReentrantLock [] lockArray, int startLocation, int length) {
        System.out.println("computeHistogram called with startLocation " + startLocation + " length " + length);
        for(int counter = startLocation; counter < startLocation + length; counter = counter + 1) {
            int location = array[counter];
            lockArray[location].lock();
            buckets[location] = buckets[location] + 1;
            lockArray[location].unlock();
        }
    }
    public static void main(String [] argv) {
        int numberOfBuckets = 100;
        int inputSize = 100000;
        int numberOfThreads = 5;
        int [] array = new int[inputSize];
        long [] buckets = new long [numberOfBuckets];
        ReentrantLock [] lockArray = new ReentrantLock[numberOfBuckets];
        for(int i = 0; i < numberOfBuckets; i = i + 1) {
            lockArray[i] = new ReentrantLock();
        }
        for(int i = 0; i < inputSize; i = i + 1)
            array[i] = i % numberOfBuckets;
        Thread [] threads = new Thread [numberOfThreads];
        // create the threads
        for(int i = 0; i < numberOfThreads; i = i + 1) {
            final int tempI = i;
            threads[i] = new Thread("" + i){
                public void run(){
                    computeHistogram(array, buckets, lockArray, (inputSize/numberOfThreads)*tempI, inputSize/numberOfThreads);
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
