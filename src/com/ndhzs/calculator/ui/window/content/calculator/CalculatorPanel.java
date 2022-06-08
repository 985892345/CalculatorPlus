package com.ndhzs.calculator.ui.window.content.calculator;

import com.ndhzs.calculator.ui.window.content.calculator.button.ButtonPanel;
import com.ndhzs.calculator.ui.window.content.calculator.text.TextEditPanel;

import javax.swing.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 8:53
 */
public class CalculatorPanel extends JPanel {

    private static final float TEXT_EDIT_PANEL_HEIGHT_RADIO = 0.4F;

    private final TextEditPanel mPanelTextEdit;
    private final ButtonPanel mPanelButton;

    public CalculatorPanel() {
        super(null);
        mPanelTextEdit = new TextEditPanel();
        mPanelButton = new ButtonPanel(mPanelTextEdit, mPanelTextEdit);
        add(mPanelTextEdit);
        add(mPanelButton);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        mPanelTextEdit.setBounds(0, 0, width, (int) (height * TEXT_EDIT_PANEL_HEIGHT_RADIO));
        mPanelButton.setBounds(0, mPanelTextEdit.getHeight() + 10, width, height - mPanelTextEdit.getHeight() - 55);
    }
}
