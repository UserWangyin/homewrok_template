/*  
     Java斐波那契数列动态规划(Dynamic Programming)
     学号：20201050470
     时间复杂度：O(n)
*/
import java.util.Scanner;

public class FibonacciDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入斐波那契数列的项数：");
        int n = sc.nextInt();
        DPF dp=new DPF();
        System.out.print("动态规划结果为：");
        for(int i=1;i<=n;i++){
            System.out.print(dp.fib(i)+" ");
        }
    }
}

class DPF{
    public int fib(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}