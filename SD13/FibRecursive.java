public class FibRecursive{
    public static long fib(long l){
        if(l == 0) {
            return 0;
        }
        else if(l == 1){
            return 1;
        }
        else {
            return fib(l-1) + fib(l-2);
        }
    }
    public static void main(String[] args){
        System.out.println(fib(Integer.parseInt(args[0])));
    }
}
