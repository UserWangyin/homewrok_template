//归并排序C
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int sum=0;//记录比较次数

void Merge(int Array[], int first, int middle, int last){//合并函数
	int n1 = middle - first;//左半边数组长度
	int n2 = last - middle;//右半边数组长度
	
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
	sum=sum+n1+n2;//记录比较次数
}
void MergeSort(int list[], int first, int last){
	
	if(first + 1 < last){     		 
		int middle = (last + first) / 2;  //计算中间位置
		MergeSort(list, first, middle);  //归并前半个数组
		MergeSort(list, middle, last);  //归并后半个数组
		Merge(list, first, middle, last);  //讲两个数组合并
	}
}

void RandomLGC(int *list,int n,int l,int r)   //生成范围在l~r的随机数 
{
	srand(time(0));                     //设置时间种子
	for(int i=0;i<n;i++){
		list[i]=rand()%(r-l+1)+l;          //生成区间r~l的随机数 
	}
}

int main()
{
	int n;   //数组元素的个数，即生成随机数的个数
    printf("请输入生成随机数的个数：");
    scanf("%d",&n);
	int list[n];
	RandomLGC(list,n,1,100000);//生成随机数的通常范围为0~32767，这里通过取模控制取值为0~100000
    int len = (int) sizeof(list) / sizeof(*list);
	printf("随机生成的数组为:\n");
	for (int i = 0; i < len; i++){
        printf("%d ",list[i]);
    }
    MergeSort(list, 0, n);
	printf("\n合并排序后的数组为:\n");
    for (int i = 0; i < len; i++){
        printf("%d ",list[i]);
    }
	printf("\n比较次数为：%d\n",sum);
    return 0;
}
