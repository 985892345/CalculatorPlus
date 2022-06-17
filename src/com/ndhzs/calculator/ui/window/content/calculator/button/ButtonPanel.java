package com.ndhzs.calculator.ui.window.content.calculator.button;

import com.ndhzs.calculator.ui.button.IOperate;
import com.ndhzs.calculator.ui.button.simple.EquButton;
import com.ndhzs.calculator.ui.button.simple.SwitchButton;

import javax.swing.*;
import java.awt.*;

/**
 * 显示按钮的容器，使用 CardLayout 卡片式布局，用于切换简单计算的容器和复杂计算的容器
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 20:31
 */
public class ButtonPanel extends JPanel implements SwitchButton.INextButtonPanel {

    private final CardLayout mCardLayout = new CardLayout();

    private static final String PANEL_SIMPLE_BUTTON = "panel_simple_button";
    private static final String PANEL_COMPLEX_BUTTON = "panel_complex_button";

    // 显示简单计算的容器
    private final SimpleButtonPanel mPanelSimpleButton;
    // 显示复杂计算的容器
    private final ComplexButtonPanel mPanelComplexButton;

    // 当前显示的界面
    private int mNowUIPosition = 1;

    public ButtonPanel(IOperate iOperate, EquButton.IEqualOutput iEqualOutput) {
        super(null);
        setLayout(mCardLayout);
        mPanelSimpleButton = new SimpleButtonPanel(this, iOperate, iEqualOutput);
        mPanelComplexButton = new ComplexButtonPanel(this, iOperate, iEqualOutput);
        add(mPanelSimpleButton, PANEL_SIMPLE_BUTTON);
        add(mPanelComplexButton, PANEL_COMPLEX_BUTTON);
    }

    /**
     * 显示简单计算界面
     */
    @Override
    public void showSimpleButton() {
        mNowUIPosition = 1;
        mCardLayout.show(this, PANEL_SIMPLE_BUTTON);
    }

    /**
     * 显示复杂计算界面
     */
    @Override
    public void showComplexButton() {
        mNowUIPosition = 2;
        mCardLayout.show(this, PANEL_COMPLEX_BUTTON);
    }

    /**
     * @return 当前显示界面的位置
     */
    @Override
    public int getNowUIPosition() {
        return mNowUIPosition;
    }
}
