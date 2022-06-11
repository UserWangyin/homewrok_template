#include <iostream>
#include <cstdlib> 
#include <ctime>
using namespace std;

void RandomLCG(int *list,int n,int l,int r)   //生成范围在l~r的随机数 
{
	srand(time(0));                     //设置时间种子
	for(int i=0;i<n;i++){
		list[i]=rand()%(r-l+1)+l;          //生成区间r~l的随机数 
	}
}

void BubbleSort(int list[], int n) {
        int i, j, temp;
        for (i = 0; i < n - 1; i++)
                for (j = 0; j < n - 1 - i; j++)
                        if (list[j] > list[j + 1]) {
                                temp = list[j];
                                list[j] = list[j + 1];
                                list[j + 1] = temp;
                        }
}


int main()
{
	int n;   //数组元素的个数，即生成随机数的个数
    printf("请输入生成随机数的个数：");
    scanf("%d",&n);
	int list[n];
	RandomLCG(list,n,1,100000);//生成随机数的通常范围为0~32767，这里通过取模控制取值为0~100000
    int len = (int) sizeof(list) / sizeof(*list);
    BubbleSort(list, len);
    for (int i = 0; i < len; i++){
        printf("%d ",list[i]);
    }
        return 0;
}