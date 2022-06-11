# 斐波那契数列动态规划
# 学号：20201050470
# 时间复杂度：O(n)

def DP_f(n):
    f=[]
    for i in range(n):
        if i==0:
            f.append(0)
        elif i==1:
            f.append(1)
        else:
            f.append(f[i-1]+f[i-2])
    return f

if __name__ == '__main__':
    n = (int)(input("斐波那契数列长度："))
    print("\n结果为：",DP_f(n))