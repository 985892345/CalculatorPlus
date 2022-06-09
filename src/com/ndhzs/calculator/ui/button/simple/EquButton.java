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
public class EquButton extends AbstractCalculatorButton {

    private final IEqualOutput mIEqualOutput;

    public EquButton(IOperate iOperate, IEqualOutput iEqualClick) {
        super("=", iOperate);
        this.mIEqualOutput = iEqualClick;
        setForeground(Color.ORANGE);
        setBackground(Color.WHITE);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        mIEqualOutput.onResult(input);
        return null;
    }

    public interface IEqualOutput {
        void onResult(String output);
    }
}
