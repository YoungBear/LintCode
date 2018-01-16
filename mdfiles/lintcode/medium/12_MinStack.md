### [12. 带最小值操作的栈](http://www.lintcode.com/zh-cn/problem/min-stack/)

**题目描述：**

实现一个带有取最小值min方法的栈，min方法将返回当前栈中的最小值。

你实现的栈将支持push，pop 和 min 操作，所有操作要求都在O(1)时间内完成。

样例

如下操作：push(1)，pop()，push(2)，push(3)，min()， push(1)，min() 返回 2，1

**思路：**

使用两个列表mData和mMinData，分别存储栈的元素和最小值：

```
    // mData模拟一个栈
    private List<Integer> mData;
    // mMinData用来存储最小的值，并且当前最小的值是最后一个元素
    private List<Integer> mMinData;
```

**核心代码：**

即push方法。在第一次的时候，将第一个元素直接添加到mMinData中。之后，判断number与当前最小值的大小，将较小值添加到mMinData中。这样的话，mMinData与mData的长度相等，并且，当前的最小值，都存储在最后一个位置。

```
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        mData.add(number);
        // 第一次push，将第一个元素添加到mMinData中
        if (mMinData.size() == 0) {
            mMinData.add(number);
        } else {
            // 之后，将number与mMinData中的最小值比较，将较小的值添加到mMinData中
            mMinData.add(Math.min(number, mMinData.get(mMinData.size() - 1)));
        }
    }
```

完整代码为：

```
public class MinStack {
    // mData模拟一个栈
    private List<Integer> mData;
    // mMinData用来存储最小的值，并且当前最小的值是最后一个元素
    private List<Integer> mMinData;
    public MinStack() {
        mData = new LinkedList<>();
        mMinData = new LinkedList<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        mData.add(number);
        // 第一次push，将第一个元素添加到mMinData中
        if (mMinData.size() == 0) {
            mMinData.add(number);
        } else {
            // 之后，将number与mMinData中的最小值比较，将较小的值添加到mMinData中
            mMinData.add(Math.min(number, mMinData.get(mMinData.size() - 1)));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int top = mData.get(mData.size() - 1);
        mData.remove(mData.size() - 1);
        mMinData.remove(mMinData.size() - 1);
        return top;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return mMinData.get(mMinData.size() - 1);
    }
}
```