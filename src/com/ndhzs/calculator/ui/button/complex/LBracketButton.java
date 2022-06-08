package com.ndhzs.calculator.ui.button.complex;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 22:30
 */
public class LBracketButton extends AbstractCalculatorButton {

    public LBracketButton(IOperate iOperate) {
        super("(", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        if("0".equals(input))
            return "(";
        return input + "(";
    }
}
