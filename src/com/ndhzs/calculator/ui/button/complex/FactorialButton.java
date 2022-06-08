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
 * @date 2022/6/6 22:24
 */
public class FactorialButton extends AbstractCalculatorButton {

    public FactorialButton(IOperate iOperate) {
        super("X!", iOperate);
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        char end = input.charAt(input.length() - 1);
        String lastText = String.valueOf(end);
        if (lastText.matches("[\\d)]$")) {
            for (int i = input.length() - 1;i >= 0; i--) {
                if(!Character.isDigit(input.charAt(i))){
                    if(input.charAt(i) == '.'){
                        return input;
                    }
                    break;
                }
            }
            return input + "!";
        }
        return null;
    }
}
