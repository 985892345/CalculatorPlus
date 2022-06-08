package com.ndhzs.calculator.ui.button.simple;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;
import com.ndhzs.calculator.ui.utils.CalculatorUtils;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 16:04
 */
public class EquButton extends AbstractCalculatorButton {

    public EquButton(IOperate iOperate) {
        super("=", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        return String.valueOf(CalculatorUtils.getResult(input));
    }
}
