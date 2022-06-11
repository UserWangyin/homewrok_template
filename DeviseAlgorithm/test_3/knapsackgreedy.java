/*
    背包问题贪心算法java实现
    学号：20201050470
    时间复杂度：O(n^2)

*/
import java.util.*;

//[1..n]和 w[1..n]分别含有按 vi/wi>v(i+1)(i+1)排序的 n件物品的价值和重量。M 是背包的容量大小，而 x[1..n]是解向量
class Knapsackgreedy {
    public static void main(String[] args) {
        KnapsackGr kp = new KnapsackGr();
        kp.initPackage();
    }
}

class KnapsackGr{
    public void Knapsack(double P[], double W[], int M, int n) {
        int i;
        double X[] = new double[n]; //定义结果向量
        for (i = 0; i < X.length; i++) {
            X[i] = 0;
        }
        double cu = M; //cu是背包剩余重量
        for (i = 0; i < n; i++) {
            if (W[i] > cu) {
                break;
            }
            X[i] = 1;
            cu = cu - W[i];
        }
        System.out.println("从0开始计数装入的前n+1个物品:"+i);
        if (i < n) {
            X[i] = cu / W[i];
        }
        System.out.println("问题的解为：");
        for (int k = 0; k < X.length; k++) {
            System.out.print(X[k] + " ");
        }
        float sum = 0;
        for (int j = 0; j < X.length; j++) {
            sum += X[j] * P[j];
        }
        System.out.println("\n总价值为：" + sum);
    }
    public void sortkp(double PW[], int index[], int n, double P[], double W[],int M) {
        for (int i = 0; i < n; i++) {
            PW[i] = P[i] / W[i];
            index[i] = i;
        }
        double temp = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n; j++) {
                if (PW[i] < PW[j])       //对效益/重量数组按递增进行排序
                {
                    temp = PW[i];
                    PW[i] = PW[j];
                    PW[j] = temp;
                    int x = index[i];       //交换相应的数组下标
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }
        double[] w1 = new double[n];
        double[] p1 = new double[n];
        for (int i = 0; i < n; i++) {
            w1[i] = W[index[i]];     //将排序后的重量和价值数组分别赋给w1[]和p1[]
            p1[i] = P[index[i]];
        }
        System.out.println("\n各物品效益/重量的值为：");
        for (int i = 0; i < n; i++) {
            System.out.print(PW[i] + " ");
        }
        System.out.println("\n\t\tv[1..n]和 w[1..n]分别含有按 vi/wi>v(i+1)(i+1)排序的n 件物品的价值和重量\n" );
        System.out.println("相应的重量数组为：" + Arrays.toString(w1));
        System.out.println("相应的效益数组为：" + Arrays.toString(p1));
        KnapsackGr kg = new KnapsackGr();
        kg.Knapsack(p1,w1,M,n);
    }
    public void RandomWeight(double weight[], int len, int max) {
        for (int i = 0; i < weight.length; i++) {
            weight[i] = (double) (Math.random() * max + 1);
        }
        System.out.println("物品的随机重量：");
        for (int i = 0; i < weight.length; i++) {
            System.out.print(weight[i] + " ");
        }
    }
    public void RandomValue(double value[], int len, int max) {
        for (int i = 0; i < value.length; i++) {
            value[i] = (double) (Math.random() * max + 1);
        }
        System.out.println("物品的随机价值：");
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
        }
    }
    public void initPackage(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入物品个数：");
        int N = sc.nextInt();
        System.out.print("请输入背包的最大容量：");
        int C = sc.nextInt();
        double[] weight = new double[N];
        double[] value = new double[N];
        RandomWeight(weight,N,100);
        System.out.println();
        RandomValue(value,N,100);
        double PW[] = new double[value.length];
        int[] index = new int[N];
        long startTime = System.currentTimeMillis();//起始时间
        sortkp(PW,index,N,value,weight,C);
        long endTime = System.currentTimeMillis();//结束时间
        System.out.println("\n程序运行时间： " + (endTime - startTime ) + "ms");
    }
}
