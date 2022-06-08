package com.ndhzs.calculator.ui.button.num;

import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 22:44
 */
public class EButton extends AbstractNumButton {

    public EButton(IOperate iOperate) {
        super("e", iOperate);
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
        return input + getText();
    }
}
