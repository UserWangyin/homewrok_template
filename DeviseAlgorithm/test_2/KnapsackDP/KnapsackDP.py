# 0-1背包动态规划Python实现
# 时间复杂度;O(n*c)
import random
import time
# 求解背包
def bag(n, c, w, v):
    # 置零，表示初始状态
    value = [[0 for j in range(c + 1)] for i in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, c + 1):
            value[i][j] = value[i - 1][j]
            # 背包总容量够放当前物体，遍历前一个状态考虑是否置换
            if j >= w[i - 1] and value[i][j] < value[i - 1][j - w[i - 1]] + v[i - 1]:
                value[i][j] = value[i - 1][j - w[i - 1]] + v[i - 1]
    for x in value:
        print(x)
    return value
# 最大值和最优解
def PackageMax(n, c, w, value):
    print('最大价值为:', value[n][c])
    x = [False for i in range(n)]
    j = c
    for i in range(n, 0, -1):
        if value[i][j] > value[i - 1][j]:
            x[i - 1] = True
            j -= w[i - 1]
    print("背包中所装物品为:")
    for i in range(n):
        if x[i]:
            print('第', i+1, '个,', end='')

# 随机n个物品的重量
def RandomWeight(n):
    arr = []
    for i in range(n):
        arr.append(random.randint(1, 100))
    return arr

# 随机n个物品的价值
def RandomValue(n):
    list = []
    for i in range(n):
        list.append(random.randint(1, 100))
    return list

if __name__ == '__main__':
    n= (int)(input("物品数量："))
    c = (int)(input("背包最大容量："))
    
    w=RandomWeight(n)
    v=RandomValue(n)
    print("物品的重量:")
    print(w)
    print("物品的价值：")
    print(v)
    start_time=time.time()
    value = bag(n, c, w, v)
    PackageMax(n, c, w, value)
    end_time=time.time()
    print("\n运行时间：",float(end_time-start_time)*1000.0,"ms")



