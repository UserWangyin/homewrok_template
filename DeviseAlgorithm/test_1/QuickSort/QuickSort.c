/*
  快速排序算法C语言实现
  学号：20201050470
  时间复杂度：O(nlog(n))
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int sum = 0;//记录比较次数
//快速排序
void QuickSort(int *list,int left,int right){
    //int sum = 0;
    if(left < right){
        int i = left,j = right,x = list[left];
        while(i < j){
            while(i < j && list[j] >= x){//从右向左找第一个小于x的数
                j--;                      //找到后，将其和x交换
            }
            list[i] = list[j];      //将找到的小于x的数放到左边
            while(i < j && list[i] <= x){//从左向右找第一个大于x的数
                i++;                    //找到后将其放到右边
            }
            list[j] = list[i];//交换
        }
        list[i] = x;//将x放到最终位置
        QuickSort(list,left,i-1);
        QuickSort(list,i+1,right);
        sum=sum+i-left+right-i;
    }
    
}
//生成随机数
void RandomLGC(int *list,int n,int l,int r)   //生成范围在l~r的随机数 
{
	srand(time(0));                     //设置时间种子
	for(int i=0;i<n;i++){
		list[i]=rand()%(r-l+1)+l;          //生成区间r~l的随机数 
	}
}

int main(){
    int n;   //数组元素的个数，即生成随机数的个数
    printf("请输入生成随机数的个数：");
    scanf("%d",&n);
	int list[n];
	RandomLGC(list,n,1,100000);//生成随机数的通常范围为0~32767，这里通过取模控制取值为0~100000
    int len = (int) sizeof(list) / sizeof(*list);
    printf("随机生成的数组为：");
    for (int i = 0; i < len; i++){
        printf("%d ",list[i]);
    }
    QuickSort(list,0,len-1);  
    printf("\n快速排序后的数组为：");
    for (int i = 0; i < len; i++){
        printf("%d ",list[i]);
    }
    printf("\n快速排序次数为：%d\n",sum);
    printf("\n");
    return 0;
}
