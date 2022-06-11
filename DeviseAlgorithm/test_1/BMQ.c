/*
    BubbleSort,MergeSort,QuickSort算法比较操作次数比较
    学号：202010650470
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int Bsum=0, Msum=0,Qsum=0;//记录次数
int compare=0, swap=0;//记录比较次数和交换次数
//rand()函数生成随机数

void RandomLGC(int *list,int n,int l,int r)   //生成范围在l~r的随机数 
{
    //int list[n];
	srand(time(0));                     //设置时间种子
	for(int i=0;i<n;i++){
		list[i]=rand()%(r-l+1)+l;          //生成区间r~l的随机数 
	}
}
//冒泡排序
void BubbleSort(int list[], int n) {
        int i, j, temp;
        for (i = 0; i < n - 1; i++){
                for (j = 0; j < n - 1 - i; j++){
                        if (list[j] > list[j + 1]) {//交换两个数的位置
                                temp = list[j];
                                list[j] = list[j + 1];
                                list[j + 1] = temp;
                                Bsum++;
                        }
                }
        }
        // printf("\n冒泡排序后的数组为：");
        // for (int i = 0; i < n; i++){
        //     printf("%d ",list[i]);
        // }
        //printf("\n冒泡排序次数为：%d\n",sum);
}


//归并排序
void Merge(int Array[], int first, int middle, int last){//合并函数
	int n1 = middle - first;//左半边数组长度
	int n2 = last - middle;//右半边数组长度
	//int sum=0;//记录次数
	int left[n1];
	int right[n2];
	
	for(int i = 0; i < n1; i++){
		left[i] = Array[first + i];    //将左半部分数组拷贝到left数组中
	}
	for(int i = 0; i < n2; i++){
		right[i] = Array[middle + i];  //将右半部分数组拷贝到right数组中
	}
	int i = 0, j = 0, key;
	for(key = first; key < last; key++){
		if(i < n1 && left[i] <= right[j]){  //如果左半部分数组中的元素小于等于右半部分数组中的元素
			Array[key] = left[i++];  //将左半部分数组中的元素拷贝到Array数组中
		}
		else if(j < n2 && left[i] >= right[j]){  //如果左半部分数组中的元素大于右半部分数组中的元素
			Array[key] = right[j++];  //将右半部分数组中的元素拷贝到Array数组中
			}
		else if(i == n1 && j < n2){   //左半部分数组中的元素已经全部拷贝到Array中
			Array[key] = right[j++];//将右半部分数组中的元素拷贝到Array数组中
		}
			
		else if(j == n2 && i < n1){
			Array[key] = left[i++];//将左半部分数组中的元素拷贝到Array数组中
		}	
			
	}
	Msum=Msum+n1+n2;//记录次数
}
//归并排序
void MergeSort(int list[], int first, int last){
	
	if(first + 1 < last){     		 
		int middle = (last + first) / 2;  //计算中间位置
		MergeSort(list, first, middle);  //归并前半个数组
		MergeSort(list, middle, last);  //归并后半个数组
		Merge(list, first, middle, last);  //讲两个数组合并
	}
}

//快速排序
void QuickSort(int *list,int left,int right){
  
    if(left < right){
        int i = left,j = right,x = list[left];
        while(i < j){
            while(i < j && list[j] >= x){//从右向左找第一个小于x的数
                j--;                     //找到后，将其和x交换
                compare++;
            }
            list[i] = list[j];      //将找到的小于x的数放到左边
            while(i < j && list[i] <= x){//从左向右找第一个大于x的数
                i++;                    //找到后将其放到右边
                compare++;
            }
            list[j] = list[i];//交换
        }
        list[i] = x;//将x放到最终位置
        QuickSort(list,left,i-1);
        QuickSort(list,i+1,right);
        Qsum=Qsum+i-left+right-i;//记录次数
        //printf("比较次数：%d\n",sum);
    }
     //printf("比较次数：%d\n",Qsum);
}


int main(){
    int n;  //数组元素的个数，即生成随机数的个数
    printf("请输入生成随机数的个数：");
    scanf("%d",&n);
	int Blist[n],Mlist[n],Qlist[n];

	RandomLGC(Blist,n,1,100000);//生成随机数
    // for(int i = 0; i < n; i++){
    //     Qlist[i] = Blist[i];
    //     Mlist[i] = Blist[i];
    //     printf("%d ",Qlist[i]);
    // }
    int len = (int) sizeof(Blist) / sizeof(*Blist);
    printf("随机生成的数组为：");
    for (int i = 0; i < len; i++){
        printf("%d ",Blist[i]);
    }
    BubbleSort(Blist, len);
    printf("\n冒泡排序的比较次数为：%d\n",Bsum);
    MergeSort(Blist, 0, len);
    printf("\n归并排序的比较次数为：%d\n",Msum);
    QuickSort(Blist, 0, len-1);
    printf("\n快速排序的比较次数为：%d\n",Qsum);
    return 0;
}