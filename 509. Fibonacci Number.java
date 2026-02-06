class Solution {
    public int fib(int n) {
        int result = fibonacci(n);
        return result;
    }

    public int fibonacci(int n){
        if(n < 2){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}