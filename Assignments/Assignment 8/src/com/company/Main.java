package com.company;

public class Main {

    /* Recursive methods that return the nth term of the Fibonacci sequence where the 0th term is 0. */

    public static void main(String[] args) {
    System.out.println(linear_fib(4, 0, 1));
    System.out.println(tail_fib(5));
    System.out.println(head_fib(6));
    }

    static int linear_fib(int number, int n, int m) {
        if (number <= 0) {
            return n;
        } if (number <= 0) {
            return m;
        } else {
            return linear_fib(number - 1, m, n + m);
        }
    }

    static int tail_fib(int number) {
        if (number <= 1) {
            return number;
        } else {
            return tail_fib(number - 1) + tail_fib(number - 2);
        }
    }

    static int head_fib(int number) {
        if (number > 1) {
            return head_fib(number - 1) + head_fib(number - 2);
        } else {
            return number;
        }
    }
}