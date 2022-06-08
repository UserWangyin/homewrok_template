//背包动态规划java实现
package DeviseAlgorithm.test_2.KnapsackDP;
import java.util.Scanner;
public class KnapsackDP {
/*  N表示物体的个数，V表示背包的载重
    weight[]用于存储每个物体的重量，下标从1开始;  
    value[]存储每个物体的价值，下标从1开始 ;
    F[][]二维数组，用来保存每种状态下的最大收益
    使用非递归方式，求解F[0 .. N][0 .. V]，即for循环从下至上求解
 */
	
    public static void ZeroOnePackNonRecursive(int N, int V, int weight[], int value[], int F[][]) {
        //对二维数组F进行初始化
        for(int j = 0; j <= V; j++) {
            F[0][j] = 0;
        }
        System.out.println("编号   重量   收益");
        for(int i=0;i<N;i++){
            System.out.println(i+"\t  "+weight[i]+"     \t"+value[i]);
        }
        //注意边界问题，i是从1开始的，j是从0开始的
        //因为F[i - 1][j]中i要减1
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                //如果容量为j的背包放得下第i个物体
                if(j >= weight[i]) {
                    F[i][j] = Math.max(F[i - 1][j - weight[i]] + value[i], F[i - 1][j]);
                }else {
                    //放不下，只能选择不放第i个物体
                    F[i][j] = F[i - 1][j];
                }
            }
        }

        //打印所有结果，我们要求的是F[N][V]
        System.out.println("\n0—1背包动态规划表：");
        for(int i=0;i<=V;i++){
            System.out.print(i+" ");
        }
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= V; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     求解F[n][m]这个最优值具体选取哪几样物品能获得最大价值，但只会输出一种情况
     表示前n个物体，n <= N;表示背包的容量，v <= V
     */
    public static void printResult(int n, int v, int weight[], int F[][]) {
        boolean[] isAdd = new boolean[n + 1];

        for(int i = n; i >= 1; i--) {
            if (F[i][v] ==F[i - 1][v]) {
                isAdd[i] = false;
        }
            else {
                isAdd[i] = true;
                v -= weight[i];
            }
        }
        System.out.println("选中物品：");
        for(int i = 1; i <= n; i++) {
                //System.out.print(i + " ");
            System.out.print(isAdd[i] + " ");
        }
        System.out.println();
    }

    public static void  RandomWeight(int weight[],int len,int max){
        //int[] arr=new int[len];
        for(int i=0;i<weight.length;i++){
            weight[i]=(int)(Math.random()*max+1);
        }
        System.out.println("物品的随机重量：");
        for(int i=0;i<weight.length;i++) {
            System.out.print(weight[i] + " ");
        }
    }
    public static void  RandomValue(int value[], int len,int max){
        //int[] arr=new int[len];
        for(int i=0;i<value.length;i++){
            value[i]=(int)(Math.random()*max+1);
        }
        System.out.println("物品的随机价值：");
        for(int i=0;i<value.length;i++) {
            System.out.print(value[i] + " ");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("请输入物品个数：");
            int N = sc.nextInt();
            System.out.print("请输入背包的最大容量：");
            int V = sc.nextInt();
            //下标从1开始，表示第1个物品
            int weight[] = new int[N + 1];
            int value[] = new int[N + 1];
            int  F[][]= new int[N + 1][V + 1];//注意是 N + 1，因为需要一个初始状态F[0][0]，表示前0个物品放进空间为0的背包的最大收益
            //long startTime = System.currentTimeMillis();//起始时间
            RandomWeight(weight,N,V);
            System.out.println();
            RandomValue(value,N,V);
            long startTime = System.currentTimeMillis();//起始时间
            ZeroOnePackNonRecursive(N,V,weight,value,F);
            printResult(N,V,weight,F);
            long endTime = System.currentTimeMillis();//结束时间
            System.out.println("\n算法运行时间： " + (endTime - startTime ) + "ms");
        }
    }
}

