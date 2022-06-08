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
 * @date 2022/6/6 16:00
 */
public class BackButton extends AbstractCalculatorButton {

    public BackButton(IOperate iOperate) {
        super("◀", iOperate);
        setForeground(Color.ORANGE);
        setBackground(Color.WHITE);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        if (input.matches(".*((lg\\()|(ln\\())$")) {
            input = input.substring(0, input.length() - 1 - 2);
        }
        if (input.matches(".*((sin\\()|(cos\\()|(tan\\())$")) {
            input = input.substring(0, input.length() - 1 - 3);
        }
        if (input.matches(".*(arcsin\\(|arccos\\(|arctan\\()$")) {
            input = input.substring(0, input.length() - 1 - 6);
        }
        if (input.length() <= 1) {
            return "0";
        }
        return input.substring(0, input.length() - 1);
    }
}
