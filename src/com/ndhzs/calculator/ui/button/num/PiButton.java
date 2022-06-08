package com.ndhzs.calculator.ui.button.num;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 21:17
 */
public class PiButton extends AbstractNumButton {

    public PiButton(IOperate iOperate) {
        super("π", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        return input + getText();
    }
}
