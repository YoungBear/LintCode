"""
744. Sum of first K even-length Palindrome numbers
http://www.lintcode.com/zh-cn/problem/sum-of-first-k-even-length-palindrome-numbers/
"""
class Solution:
    """
    @param k:
    @return: the sum of first k even-length palindrome numbers
    设f(n)为第n个偶数长度的回文数
    则f(1)为11，f(2)为22...f(10)为1001
    可以看到规律，f(n)为将n作为字符串，翻转后，两个串拼起来的数字
    参考：
    http://www.geeksforgeeks.org/sum-first-k-even-length-palindrome-numbers/
    """
    def sumKEven(self, k):
        result = 0
        for i in range(1, k + 1):
            s1 = str(i)
            # 翻转字符串
            s2 = s1[::-1]
            # 拼接两个字符串并转换为整数型
            cur = int(s1 + s2)
            # print(cur)
            # 添加到结果中
            result = result + cur
        return result


test = Solution()
print(test.sumKEven(1000))
