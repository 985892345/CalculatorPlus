package com.ndhzs.calculator.ui.button.complex;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 22:29
 */
public class LgButton extends AbstractCalculatorButton {

    public LgButton(IOperate iOperate) {
        super("lg", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        return input + getText() + "(";
    }
}
