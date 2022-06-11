/*
   归并排序Java实现
   学号：20201050470
   时间复杂度：O(nlog2n)
*/

import java.util.Scanner;
public class MergeSort {
    public static void main(String[] args) {
        MergeSort_1 p = new MergeSort_1();
        p.InitMerage();
       
    }

}

class MergeSort_1{
    public void Merge(int[] list,int p,int q,int r){
        int[] tmp = new int[r-p+1];//声明一个临时数组，长度为要归并数组的长度
        int i = p;   //记住左边数组第一个元素的下标
        int j = q+1; //记住右边数组第一个元素的下标
        int k = 0;     
        int sum=0;//记录比较次数
        while(i <= q && j <= r){
            //左边数组元素和右边数组元素比较，把小的元素赋给临时数组
            if(list[i] <=list[j]){               
                tmp[k++] = list[i++];
            }
            else{               
                tmp[k++] =list[j++];
            }
        }
        //把左边剩余的数组元素赋给临时数组
        while(i <= q){          
            tmp[k++] = list[i++];
        }
        //把右边剩余的数组元素赋给临时数组
        while(j <= r){          
            tmp[k++] = list[j++];
        }
        //用临时数组元素覆盖原数组元素
        for(int k2 = 0;k2 < tmp.length;k2++){           
           list[k2+p] = tmp[k2]; 
        }
        sum=sum+q-p+1;
        // System.out.println("\n比较次数："+sum);
    }
    public void Merge_sort(int[]list,int p,int r){//p为起始位置，r为结束位置
        int q = (p+r)/2;//q为二分位置
        if(p < r){
            //递归调用          
            Merge_sort(list,p,q);//递归解决前半部分
            Merge_sort(list,q + 1,r);//递归解决后半部分
            //归并排序数据元素
            Merge(list,p,q,r);//最后将所有有序数组完成归并
        }
    }
   public int[]  RandomArray(int len,int max){
			int[] arr=new int[len];
			for(int i=0;i<arr.length;i++){
				arr[i]=(int)(Math.random()*max);
			}
			return arr;
	}
    public void InitMerage(){
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("请输入数组长度：");
            int n=input.nextInt();
            //int sum=0;
            int []arr=RandomArray(n, 10000);
            System.out.println("排序前的数组：");
            for (int i = 0; i < arr.length; i++) {
            	System.out.print(arr[i]+" ");
            }
            Merge_sort(arr,0,arr.length -1);//从数组A的0位到A.length-1位排序
            System.out.println("\n合并排序后的结果： ");
            for(int i = 0;i < arr.length;i++){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}