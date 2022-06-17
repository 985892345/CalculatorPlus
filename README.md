# CalculatorPlus
某高校的 Swing 计算器作业

## 简介
模仿小米计算器

由我和某位同学共同完成

## 实现功能
- [x] 多则混合运算
- [x] 单位换算

## 算法实现
实现类请看 [CalculatorUtils](src/com/ndhzs/calculator/utils/CalculatorUtils.java)

大致步骤：
- 先遍历一遍字符串，切割成数字或者计算符
- 在转换成逆波兰表达式（后缀表达式）
- 最后使用栈来计算

# 注意
该作业可用于参考，但请不要直接 CV，否则后果自负
