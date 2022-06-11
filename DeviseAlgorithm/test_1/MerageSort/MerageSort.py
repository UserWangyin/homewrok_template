# 归并排序Python实现
# 学号：20201050470
# 时间复杂度：O(nlog(n))

import random

# 归并算法
def merge(left, right):
    result = []
    while len(left) > 0 and len(right) > 0:
        if left[0] <= right[0]:
            result.append(left[0])
            left = left[1:]
        else:
            result.append(right[0])
            right = right[1:]
    result = result + left + right
    return result


# 归并排序
def mergesort(lst):
    if len(lst) <= 1:
        return lst
    mid = len(lst) // 2
    left = mergesort(lst[:mid])
    right = mergesort(lst[mid:])
    return merge(left, right)
# random()函数生成随机数组
def RandomArray(n):
    arr = []
    for i in range(n):
        arr.append(random.randint(0, 100000))
    return arr


# 测试
if __name__ == '__main__':
    n = (int)(input("随机数组长度："))
    arr=RandomArray(n)
    print("测试序列\n",arr)
    arr = mergesort(arr)
    print("非降序序列\n", arr)
