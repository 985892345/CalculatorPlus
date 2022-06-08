package com.ndhzs.calculator.ui.window.content.calculator.button;

import com.ndhzs.calculator.ui.button.IOperate;
import com.ndhzs.calculator.ui.button.simple.EquButton;
import com.ndhzs.calculator.ui.button.simple.SwitchButton;

import javax.swing.*;
import java.awt.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 20:31
 */
public class ButtonPanel extends JPanel implements SwitchButton.INextButtonPanel {

    private final CardLayout mCardLayout = new CardLayout();

    private static final String PANEL_SIMPLE_BUTTON = "panel_simple_button";
    private static final String PANEL_COMPLEX_BUTTON = "panel_complex_button";

    private final SimpleButtonPanel mPanelSimpleButton;
    private final ComplexButtonPanel mPanelComplexButton;

    private int mNowUIPosition = 1;

    public ButtonPanel(IOperate iOperate, EquButton.IEqualOutput iEqualOutput) {
        super(null);
        setLayout(mCardLayout);
        mPanelSimpleButton = new SimpleButtonPanel(this, iOperate, iEqualOutput);
        mPanelComplexButton = new ComplexButtonPanel(this, iOperate, iEqualOutput);
        add(mPanelSimpleButton, PANEL_SIMPLE_BUTTON);
        add(mPanelComplexButton, PANEL_COMPLEX_BUTTON);
    }

    @Override
    public void showSimpleButton() {
        mNowUIPosition = 1;
        mCardLayout.show(this, PANEL_SIMPLE_BUTTON);
    }

    @Override
    public void showComplexButton() {
        mNowUIPosition = 2;
        mCardLayout.show(this, PANEL_COMPLEX_BUTTON);
    }

    @Override
    public int getNowUIPosition() {
        return mNowUIPosition;
    }
}
