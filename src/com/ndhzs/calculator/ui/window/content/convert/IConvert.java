package com.ndhzs.calculator.ui.window.content.convert;

/**
 * 定义换算主界面的接口
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 10:41
 */
public interface IConvert {
    /**
     * 跳转详细选择换算界面
     */
    void showSelectConvert();

    /**
     * 跳转面积换算界面
     */
    void showAreaConvert();

    /**
     * 跳转时间换算界面
     */
    void showTimeConvert();

    /**
     * 跳转速度换算界面
     */
    void showVelocityConvert();

    /**
     * 跳转体积换算界面
     */
    void showVolumeConvert();
}
