package com.chendehe.test;

public class Test2 {
    public static void main(String[] args) {
        MyFunc car = print2();
        car.print("123");
    }

    private static MyFunc print2() {
        return Test2::print;
    }

    private static void print(String str) {
        System.out.println(3213);
    }

}

@FunctionalInterface
interface MyFunc {
    void print(String str);
}
