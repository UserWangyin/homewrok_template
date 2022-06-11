/*
    java斐波那契数列分治法(Divide and Conquer)
    分治法的基本思想是：
    将问题分解为子问题，然后递归解决子问题，最后合并解决子问题得到原问题的解。
    学号：20201050470
*/

import java.util.Scanner;

public class FibnacciDAC{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入斐波那契数列的项数：");
        int n = sc.nextInt();
        DACF dp=new DACF();
        System.out.print("分治法结果为：");
        System.out.println(dp.fib(n));
    }
}

class DACF{
    public int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        else{
            return fib(n-1)+fib(n-2);
        }
    }
}