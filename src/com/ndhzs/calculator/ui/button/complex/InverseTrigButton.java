package com.ndhzs.calculator.ui.button.complex;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 22:32
 */
public class InverseTrigButton extends AbstractCalculatorButton {

    public InverseTrigButton(IOperate iOperate) {
        super("1/trig", iOperate);
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        return null;
    }
}
