package com.ndhzs.calculator.ui.button.simple;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 16:04
 */
public class SubButton extends AbstractCalculatorButton {

    public SubButton(IOperate iOperate) {
        super("-", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        char end = input.charAt(input.length() - 1);
        String lastText = String.valueOf(end);
        if (lastText.matches("[\\d)!√eπ]$")) {
            if(input.charAt(input.length() - 1) == '√') {
                return input + "(-";
            }
            return input + getText();
        }
        return null;
    }
}
