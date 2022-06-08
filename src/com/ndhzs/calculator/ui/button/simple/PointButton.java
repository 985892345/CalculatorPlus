package com.ndhzs.calculator.ui.button.simple;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 16:06
 */
public class PointButton extends AbstractCalculatorButton {

    public PointButton(IOperate iOperate) {
        super(".", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        char end = input.charAt(input.length() - 1);
        String lastText = String.valueOf(end);
        if (lastText.matches("\\d")) {
            int i = input.length()-1;
            while (i >= 0 && Character.isDigit(input.charAt(i))){
                i--;
            }
            if(i>=0) {
                if (input.charAt(i) == 'e') {
                    return null;
                }
            }
            return input + getText();
        }
        return null;
    }
}
