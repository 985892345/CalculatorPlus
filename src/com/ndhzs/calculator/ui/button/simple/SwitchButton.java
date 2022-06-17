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
 * @date 2022/6/6 16:35
 */
public class SwitchButton extends AbstractCalculatorButton {

    private final INextButtonPanel mINext;

    public SwitchButton(INextButtonPanel iNext, IOperate iOperate) {
        super("◲", iOperate);
        this.mINext = iNext;
        setForeground(Color.ORANGE);
        setBackground(Color.WHITE);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        switch (mINext.getNowUIPosition()) {
            case 1 :
                mINext.showComplexButton();
                setToolTipText("切换至科学计算器");
                break;
            case 2 :
                mINext.showSimpleButton();
                setToolTipText("切换至简单计算器");
                break;
        }
        return null;
    }

    /**
     * 用于实现点击下一次按钮后操作的接口
     */
    public interface INextButtonPanel {
        /**
         * 显示简单计算界面
         */
        void showSimpleButton();

        /**
         * 显示简单计算界面
         */
        void showComplexButton();

        /**
         * @return 当前显示界面的位置
         */
        int getNowUIPosition();
    }
}
