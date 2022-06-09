package com.ndhzs.calculator.ui.button.num;

import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.*;
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
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        if (isInputLegal(input)) {
            if ("0".equals(input)) {
                // 如果只有一个 0
                return getText();
            }
        }
        if (input.endsWith(".")) {
            return input;
        }
        if (input.length() >= 2) {
            char c = input.charAt(input.length() - 2);
            if(input.charAt(input.length() - 1)== '0' && (c != '.' && !Character.isDigit(c) )){
                return input.substring(0,input.length() - 1) + getText();
            }
        }
        return input + getText();
    }
}
