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
public class LnButton extends AbstractCalculatorButton {

    public LnButton(IOperate iOperate) {
        super("ln", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        if("0".equals(input)){
            return getText() + "(";
        }
        return input + getText() + "(";
    }
}
