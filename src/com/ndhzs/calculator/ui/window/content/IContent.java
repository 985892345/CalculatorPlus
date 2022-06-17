package com.ndhzs.calculator.ui.window.content;

/**
 * 定义内容主界面的接口，用于跳转计算界面和跳转换算界面
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 8:21
 */
public interface IContent {
    /**
     * 跳转计算界面
     */
    void showCalculator();

    /**
     * 跳转换算界面
     */
    void showConvert();
}
