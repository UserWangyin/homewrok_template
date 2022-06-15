/*
   斐波那契数分治法C语言实现
*/

#include<stdio.h>

/*分治法*/ 
int DAC_f(int n){ 

	if(n==1||n==2){
		return 1;}
	else{
		return DAC_f(n-1)+DAC_f(n-2);
	}
}
int main(){
	int n;
	printf("请输入斐波那契数列的项数: ");
	scanf("%d",&n);
	printf("DAC_f(%d)=%d",n,DAC_f(n));
	n=0;
	return 0;
}
