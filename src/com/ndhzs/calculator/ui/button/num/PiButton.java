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
        if (isInputLegal(input)) {
            if ("0".equals(input)) {
                // 如果只有一个 0
                return getText();
            }
        }
        for (int i = input.length() - 1;i >= 0; i--) {
            if (!Character.isDigit(input.charAt(i))) {
                if (input.charAt(i) == '.') {
                    return input;
                }
                break;
            }
        }
        return input + getText();
    }
}
