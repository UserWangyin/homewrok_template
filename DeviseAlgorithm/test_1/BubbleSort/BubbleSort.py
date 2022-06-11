# 冒泡排序Python实现
# 学号：20201050470
# 时间复杂度：O(n^2)
import random
# 冒泡排序
def BubbleSort(arr):
    for i in range(len(arr) - 1, 0, -1):  # 反向遍历
        for j in range(0, i):  # 由于最右侧的值已经有序，不再比较，每次都减少遍历次数
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


# 随机生成一个数组
def RandomArray(n):
    arr = []
    for i in range(n):
        arr.append(random.randint(0, 100))
    return arr


if __name__ == '__main__':
    n = (int)(input("随机数组长度："))
    arr = RandomArray(n)
    print(arr)
    print("冒泡排序后：\n")
    print(BubbleSort(arr))