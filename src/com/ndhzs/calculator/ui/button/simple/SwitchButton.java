package com.ndhzs.calculator.ui.button.simple;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 16:35
 */
public class SwitchButton extends AbstractCalculatorButton {

    private final INextButtonPanel mINext;

    private int mCLickCount = 0;

    public SwitchButton(INextButtonPanel iNext, IOperate iOperate) {
        super("◲", iOperate);
        this.mINext = iNext;
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        if (mCLickCount % 2 == 0) {
            mINext.showComplexButton();
            setToolTipText("切换至科学计算器");
        } else {
            mINext.showSimpleButton();
            setToolTipText("切换至简单计算器");
        }
        mCLickCount++;
        return null;
    }

    public interface INextButtonPanel {
        void showSimpleButton();
        void showComplexButton();
        int getNowUIPosition();
    }
}
