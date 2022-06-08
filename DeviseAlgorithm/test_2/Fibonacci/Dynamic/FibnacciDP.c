//动态规划
#include<stdio.h>
int f[100000000]={0};//用于存储fibonacci数列
int DP_f(int n){//动态规划法
	//int f[n]=0;
	for(int i=0;i<=n;i++){
		if(i==1||i==2){
			f[i]=1;
		}
		else{
			f[i]=f[i-1]+f[i-2];
		}
	}
	return f[n];//返回fibonacci数列的第n个数
}
int main(){
	int n;
	printf("输入测试数据: ");
	scanf("%d",&n);
    printf("DP_f(%d)=%d",n,DP_f(n));
	n=0;
	return 0;
}
