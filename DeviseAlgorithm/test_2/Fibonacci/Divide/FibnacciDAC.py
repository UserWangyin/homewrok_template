# 分治法解决斐波那契数列问题Python
# 学号：20201050470

def DAC_f(n):
    if n==1 or n==2:
        return 1
    else:
        return DAC_f(n-1)+DAC_f(n-2)

if __name__ == '__main__':
    n = (int)(input("斐波那契数列长度："))
    print("\n结果为:",DAC_f(n))