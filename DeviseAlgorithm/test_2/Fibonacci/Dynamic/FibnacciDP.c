/*
    斐波那契数动态规划法(Dynamic Programming)
	学号：20201050470
	时间复杂度：O(n)

*/
#include<stdio.h>
#include<stdlib.h>
/*动态规划法*/ 
int *DP_f(int n){
	int *f=(int*)malloc(sizeof(int)*n);
	f[0]=0;
	for(int i=1;i<=n;i++){
		if(i==1||i==2){
			f[i]=1;
		}
		else{
			f[i]=f[i-1]+f[i-2];
		}
	}
	return f;//返回fibonacci数列
}

int main(){
	int n;
	printf("输入测试数据: ");
	scanf("%d",&n);
	printf("输出结果为：");
	int *f=DP_f(n);
	for(int i=1;i<=n;i++){
		printf("%d ",f[i]);
	}
	return 0;
}

