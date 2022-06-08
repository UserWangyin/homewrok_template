#include<stdio.h>
int DAC_f(int n){  //分治法
	if(n==1||n==2){
		return 1;}
	else{
		return DAC_f(n-1)+DAC_f(n-2);
	}
}
int main(){
	int n;
	printf("请输入测试值: ");
	scanf("%d",&n);
	printf("DAC_f(%d)=%d",n,DAC_f(n));
	n=0;
	return 0;
}
