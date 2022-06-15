/*
   冒泡排序java实现
   时间复杂度：O(n^2)
*/

import java.util.Scanner;

public class BubbleSort{
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("请输入数组长度：");
            int n=input.nextInt();
            int []arr=RandomArray(n, 10000);
            System.out.println("排序前的数组：");
            for (int i = 0; i < arr.length; i++) {
            	System.out.print(arr[i]+" ");
            }
            BubbleSortAlgorithm(arr);
        }
	}
    //随机生成数组 
	public static int[]  RandomArray(int len,int max){
		int[] arr=new int[len];
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*max);
		}
		return arr;
	}
    // 冒泡排序算法
    public static void BubbleSortAlgorithm(int[] arr){
        //int temp;
        int sum=0;
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            sum=sum+arr.length-i;
        }
         System.out.println("\n排序后的数组：");
        for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
    }
    System.out.println("\n排序次数："+sum);
    }
}