# 快速排序python实现
# 学号：20201050470
# 时间复杂度：O(nlog(n))
import random

def RandomArray(n):
    arr = []
    for i in range(n):
        arr.append(random.randint(-100000, 100000))
    return arr

# 生成线性同余序列
# def randlist(m, a, c, x0, n):
#     arr = [x0]
#     i: int
#     for i in range(n - 1):
#         arr.append((a * arr[i] + c) % m)
#     return arr


# 快速排序
def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[0]
    left = [i for i in arr[1:] if i <= pivot]
    right = [i for i in arr[1:] if i > pivot]
    return quick_sort(left) + [pivot] + quick_sort(right)


# 测试算法
if __name__ == '__main__':
    n = (int)(input("随机数组长度："))
    # arr=randlist(100000, n, 0, 100, n)
    arr = RandomArray(n)
    print("排序前：\n",arr)
    print("\n排序后：\n",quick_sort(arr))