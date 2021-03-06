package com.ndhzs.calculator.ui.button.simple;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.*;
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
        setForeground(Color.ORANGE);
        setBackground(Color.WHITE);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        char end = input.charAt(input.length() - 1);
        String lastText = String.valueOf(end);
        if (lastText.matches("[\\d)!āeĻ]$")) {
            if(input.charAt(input.length() - 1) == 'ā') {
                return input + "(-";
            }
            return input + getText();
        }
        return null;
    }
}
