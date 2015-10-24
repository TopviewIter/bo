package com.xluo.arithmetic.recursion;

public class Fibonacci_01 {

	//多层递归,在超大数据量的情况下会溢出
	public static int fibonacci(int n) {
		if(n == 0){
            return 0;
        }else if(n == 1 || n == 2){
            return 1;
        }else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }         
    }
	
	public static int fibonacci_02(int n){
		if(n == 0){
            return 0;
        }else if(n == 1 || n == 2){
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        while(n-- > 2){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(7));
		System.out.println(fibonacci_02(7));
	}
	
}
