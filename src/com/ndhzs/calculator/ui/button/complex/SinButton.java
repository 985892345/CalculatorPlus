package com.ndhzs.calculator.ui.button.complex;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 22:32
 */
public class SinButton extends AbstractCalculatorButton {

    public SinButton(IOperate iOperate) {
        super("sin", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        return input + getText() + "(";
    }
}
