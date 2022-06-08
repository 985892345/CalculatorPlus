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
 * @date 2022/6/6 22:18
 */
public class InverseButton extends AbstractCalculatorButton {

    public InverseButton(IOperate iOperate) {
        super("1/X", iOperate);
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        char end = input.charAt(input.length() - 1);
        String lastText = String.valueOf(end);
        if (lastText.matches("[\\d)!eπ]$")) {
            return input + "^(-1)";
        }
        return null;
    }
}
