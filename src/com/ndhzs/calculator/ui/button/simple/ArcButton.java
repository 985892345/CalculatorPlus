package com.ndhzs.calculator.ui.button.simple;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 22:35
 */
public class ArcButton extends AbstractCalculatorButton {

    public ArcButton(IOperate iOperate) {
        super("arc", iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        return null;
    }
}
