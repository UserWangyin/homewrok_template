# 实验二、动态规划算法实验报告

## 学号：20201050470

## 实验 2.1 动态规划算法的实现与时间复杂度测试

## 实验目的：

>编程实现经典的动态规划算法，理解动态规划算法设计的基本思想、程序实现的相关技巧，加深对动态规划算法设计与
>分析思想的理解。通过程序的执行时间测试结果，与理论上的时间复杂度结论进行对比、分析和验证.

## 实验原理

动态规划算法的基本思想:
   动态规划是一种在数学和计算机科学中使用的、用于求解包含重叠子问题的
最优化问题的有效方法。其基本思想是：将原问题分解为相似的子问题，在求解
的过程中通过子问题的解描述并求出原问题的解。动态规划的思想是多种算法的
基础，被广泛应用于计算机科学和工程领域，在查找有很多重叠子问题的情况的
最优解时有效。它将问题重新组合成子问题，为了避免多次解决这些子问题，它
们的结果都逐渐被计算并保存，从小规模的子问题直到整个问题都被解决。因此，
动态规划对每一子问题只做一次计算，具有较高的效率。

## 实验输入数据集

文本数据集：
文件数据集：[数据集](./data_2/list.txt)

### 实验内容

1. [knapsackDP.py](./KnapsackDP/KnapsackDP.py) 算法实现的python版本
1. [knapsackDP.c](./KnapsackDP/KnapsackDP.c) 算法实现的C语言版本
1. [knapsackDP.java](./KnapsackDP/KnapsackDP.java) 算法实现的java版本

### 实验预期结果与实际结果
+ 实验预期结果：

实验过程及实验结果（C版
1. ![knapsackDP.c](./KnapsackDP/KnapsackDP.c)
实验过程及实验结果（Java版）
2. ![knapsackDP.java](./KnapsackDP/KnapsackDP.java)
实验过程及实验结果（Python版）
3. ![knapsackDP.py](./KnapsackDP/KnapsackDP.py)

## 实验 2.2 动态规划算法的适应性测试

### 实验目的：

1. 
>对于同一问题，编程实现其分治算法和动态规划算法，通过对比分析，理解
>动态规划算法的适用情形。通过程序的执行时间测试结果，与理论结论进行对比、
>分析和验证。

### 实验原理
分治算法与动态规划算法的对比：
   针对子问题是否重叠虽然很多问题均可分解为子问题、动态规划和分治算法都是通过子问题的解
决来获得原问题的解。然而，分治算法适用于子问题不重叠（即相互独立）的情
形，对于子问题重叠的情形分治法具有较高的时间复杂度，动态规划是针对这类
情形的有效算法。

### 实验输入数据集

文本数据集：
文件数据集：[数据集](./data_2/list.txt)

### 实验内容

#### DAC_f
1. [FinacciDAC.py](./Fibonacci/Divide/FibnacciDAC.py) 算法实现的python版本
2. [FinacciDAC.c](./Fibonacci/Divide/FibnacciDAC.c) 算法实现的C语言版本
3. [FinacciDAC.java](./Fibonacci/Divide/FibnacciDAC.java) 算法实现的java版本

#### DP_f
1. [FinacciDAC.py](./Fibonacci/Dynamic/FibonacciDP.py) 算法实现的python版本
2. [FinacciDAC.c](./Fibonacci/Dynamic/FibonacciDP.c) 算法实现的C语言版本
3. [FinacciDAC.java](./Fibonacci/Dynamic/FibonacciDP.java) 算法实现的java版本
4. [Fib.c](./Fib.c)

### 实验预期结果与实际结果

#### DAC_f
+ 实验预期结果：

实验过程及实验结果（Java版）
1. ![FinacciDAC.java](./data_2/images_2/DivideI/dfj.png)
实验过程及实验结果（C版）
2. ![FinacciDAC.c](./data_2/images_2/DivideI/dfc.png)
实验过程及实验结果（Python版）
3. ![FinacciDAC.py](./data_2/images_2/DivideI/dfp.png)
#### DP_f
+  实验预期结果：

实验过程及实验结果（Java版）
1. ![FinacciDP.java](./data_2/images_2/DynamicI/dpj.png)
实验过程及实验结果（C版）
2. ![FinacciDP.c](./data_2/images_2/DynamicI/dpc.png)
实验过程及实验结果（Python版)
3. ![FinacciDP.py](./data_2/images_2/DynamicI/dpp.png)

#### Fib
[Fib.c](./data_2/DynamicI/fibc.png)