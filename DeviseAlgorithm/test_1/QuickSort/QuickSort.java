/*
    快速排序Java实现
    学号：20201050470
    时间复杂度：O(nlog(n))
*/

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        QuickSortAlgorithm qs = new QuickSortAlgorithm();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("请输入数组的长度：");
            int n = sc.nextInt();
            int [] a=qs.RandomArray(n,100000);   //生成随机数组
            System.out.println("随机序列");
            for (int j : a) {
                System.out.print(j+" ");
            }
            System.out.println();
            qs.quickSort(a,0,a.length-1);
            System.out.println("快速排序生成的非降序序列");
            for (int j : a) {
                System.out.print(j+" ");
            }
        }
    }
}
class QuickSortAlgorithm {
    int[]  RandomArray(int len,int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
         return arr;
 }
    //快速排序
    void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    //分区
    int partition(int[] arr, int low, int high) {
        int pivotkey = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivotkey) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivotkey) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivotkey;
        return low;
    }
}