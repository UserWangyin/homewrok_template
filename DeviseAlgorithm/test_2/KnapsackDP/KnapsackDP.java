/* 
    0-1背包动态规划Java实现
    时间复杂度：O(nW)
 */
 
import java.util.Scanner;
public class KnapsackDP {
    public static void main(String[] args) {
        package01_1 p = new package01_1();
        p.initPackage();
    }
}
class package01_1{
    public int max(int a,int b){
        if(a>b)
            return a;
        else
            return b;
    }
    //0-1背包动态规划
    public int[][] knapsack(int n,int C,int weight[],int value[]){
        int[][] F=new int[n+1][C+1];
        for(int i=0;i<=n;i++){
            F[i][0]=0;
        }
        for(int j=0;j<=C;j++){
            F[0][j]=0;
        }
        System.out.printf("\n编号 重量 价值\n");
        for(int i=1;i<=n;i++){
            System.out.printf("%d\t%d\t%d\n",i,weight[i-1],value[i-1]);
        }
        System.out.println("\n0—1背包动态规划表：");
        for(int i=0;i<=C;i++){
            System.out.printf("%d ",i);
        }
        System.out.println();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=C;j++){
                if(weight[i-1]<=j){
                    F[i][j]=max(F[i-1][j],F[i-1][j-weight[i-1]]+value[i-1]);
                    System.out.print(F[i][j]+" ");
                }
                else {
                    F[i][j] = F[i - 1][j];
                    System.out.print(F[i][j] + " ");
                }
            }
            System.out.println();
        }
        return F;
    }
    //求最优解
    public void Judge(int n,int C,int weight[],int F[][]){
        int state[]=new int[n];
        int j=C;
        for(int i=n-1;i>=1;i--){
            if(F[i][j]>F[i-1][j]){
                state[i]=1;
                j=j-weight[i-1];
            }
            else
                state[i]=0;
        }
        System.out.println("选中的物品编号是:");
        for(int i=0;i<n;i++) {
            if (state[i] == 1)
                System.out.print(i+" ");
        }
       //System.out.println(" ");
    }
    //随机生成物品重量
    public void RandomWeight(int weight[], int len, int max) {
        for (int i = 0; i < weight.length; i++) {
            weight[i] = (int) (Math.random() * max + 1);
        }
        System.out.println("物品的随机重量：");
        for (int i = 0; i < weight.length; i++) {
            System.out.print(weight[i] + " ");
        }
    }
    //随机生成物品价值
    public void RandomValue(int value[], int len, int max) {
        for (int i = 0; i < value.length; i++) {
            value[i] = (int) (Math.random() * max + 1);
        }
        System.out.println("物品的随机价值：");
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
        }
    }
    //初始化
    public void initPackage(){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("请输入物品个数：");
            int N = sc.nextInt();
            System.out.print("请输入背包的最大容量：");
            int C = sc.nextInt();
            int[] weight = new int[N];
            int[] value = new int[N];
            RandomWeight(weight,N,100);
            System.out.println();
            RandomValue(value,N,100);
            //int F[][] = knapsack(N,C,weight,value);
            long startTime = System.currentTimeMillis();//起始时间
            int F[][] = knapsack(N,C,weight,value);
            Judge(N,C,weight,F);

            System.out.println("\n最大价值为："+F[N][C]);
            long endTime = System.currentTimeMillis();//结束时间
            System.out.println("\n程序运行时间： " + (endTime - startTime ) + "ms");
        }
    }
}

