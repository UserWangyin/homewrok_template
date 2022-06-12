#include<stdio.h>
#include<stdlib.h>
/*分治法*/ 
int psum=0;//
int DAC_f(int n){ 
    //int sum=0;
	if(n==1||n==2){
		return 1;}
	else{
        psum++;
		return DAC_f(n-1)+DAC_f(n-2);
        
	}
    return psum;
    //printf("\n动态规划加法次数：%d",sum);
}

/*动态规划法*/ 
int *DP_f(int n){//动态规划法
	int sum=0;
	int *f=(int*)malloc(sizeof(int)*n);
	f[0]=0;
	for(int i=1;i<=n;i++){
		if(i==1||i==2){
			f[i]=1;
		}
		else{
			f[i]=f[i-1]+f[i-2];
            sum++;
		}
	}
    printf("\n分治法加法次数：%d\n",sum);
	return f;//返回fibonacci数列
}


int main(){
	int n;
	printf("请输入斐波那契数列的项数: ");
	scanf("%d",&n);
	printf("分治法：\nDAC_f(%d)=%d",n,DAC_f(n));
    int *f=DP_f(n);
    printf("\n动态规划法：");
	for(int i=1;i<=n;i++){
		printf("%d ",f[i]);
	}
    printf("\n动态规划法加法次数：%d",psum);
	n=0;
	return 0;
}
