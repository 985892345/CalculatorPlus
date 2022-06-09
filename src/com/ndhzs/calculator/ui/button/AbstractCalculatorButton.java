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

    protected abstract String onOperate(String input, ActionEvent event);
}
