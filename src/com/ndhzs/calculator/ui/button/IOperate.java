package com.ndhzs.calculator.ui.button;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 23:30
 */
public interface IOperate {
    /**
     * 得到输入值
     * @return 输出值
     */
    String input();

    /**
     * 向外输出值
     * @param output 输出值
     */
    void output(String output);
}
