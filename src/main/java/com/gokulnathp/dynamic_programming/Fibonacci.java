package com.gokulnathp.dynamic_programming;

public class Fibonacci {
    int[] memo = new int[100];
    int counter = 0;

    public int withoutMemo(int n) {
        counter++;

        if (n == 0 || n == 1) return n;

        return withoutMemo(n - 1) + withoutMemo(n - 2);
    }

    public int topDown(int n) {
        counter++;
        if (memo[n] != 0) return memo[n];

        if (n == 0 || n == 1) return n;

        memo[n] = topDown(n - 1) + topDown(n - 2);
        return memo[n];
    }

    public int bottomUp(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            counter++;
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        // Counter: (2^n)
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Without Memo (2^n)");
        System.out.println("Value: " + fibonacci.withoutMemo(40));
        System.out.println("Counter: " + fibonacci.counter);

        // Counter: (2n - 1)
        fibonacci = new Fibonacci();
        System.out.println("Top down (2n - 1)");
        System.out.println("Value: " + fibonacci.topDown(40));
        System.out.println("Counter: " + fibonacci.counter);

        // Counter: (n - 1)
        fibonacci = new Fibonacci();
        System.out.println("Bottom Up (n - 1)");
        System.out.println("Value: " + fibonacci.bottomUp(40));
        System.out.println("Counter: " + fibonacci.counter);
    }
}
