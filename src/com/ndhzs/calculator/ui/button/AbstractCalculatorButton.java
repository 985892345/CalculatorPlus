package com.ndhzs.calculator.ui.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 23:00
 */
public abstract class AbstractCalculatorButton extends JButton {

    public AbstractCalculatorButton(String text, IOperate iOperate) {
        super(text);
        setFont(new Font(null, Font.PLAIN, 12));
        addActionListener(event -> iOperate.output(onOperate(iOperate.input(), event)));
    }

    /**
     * 点击事件的回调，用于设置输出结果或进行计算
     * @param input 输入值
     * @param event 事件
     * @return 输出值
     */
    protected abstract String onOperate(String input, ActionEvent event);
}
