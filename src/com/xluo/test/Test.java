package com.xluo.test;

/**
 * ①所有的byte,short,char型的值将被提升为int型； 
 * ②如果有一个操作数是long型，计算结果是long型；
 * ③如果有一个操作数是float型，计算结果是float型； 
 * ④如果有一个操作数是double型，计算结果是double型；
 * 而声明为final的变量会被JVM优化，第6行相当于 b6 = 10 
 * java的常量分为编译期常量和运行期常量 编译期常量 
 * 如 final int a = 3*2; 运行期常量 
 * 如 final int b = new Random(100); 顾名思义，编译期常量的值在编译期就确定了。
 * 
 * @author luozhangjie
 *
 */
public class Test {

	public static void add(Byte b) {
		b = b++;
	}

	public static void test() {
		Byte a = 127;
		Byte b = 127;
		add(++a);
		System.out.print(a + " ");
		add(b);
		System.out.print(b + "");
	}

	public static void test_02() {
		byte b1 = 1, b2 = 2, b3, b6;
		final byte b4 = 4, b5 = 6;
		b6 = b4 + b5; // 因为运算的变量被定义为final的,因此不会先向上类型转换成int再进行运算
		b3 = (byte) (b1 + b2); // 这里运算后会转成int类型
		System.out.println(b3 + b6);
	}

	public static void main(String[] args) {
		test();
	}

}
