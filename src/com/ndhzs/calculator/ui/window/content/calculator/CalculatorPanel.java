package com.ndhzs.calculator.ui.window.content.calculator;

import com.ndhzs.calculator.ui.window.content.calculator.button.ButtonPanel;
import com.ndhzs.calculator.ui.window.content.calculator.text.TextEditPanel;

import javax.swing.*;

/**
 * 计算主界面，其中包含输入和结果文本框的容器和显示按钮的容器
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 8:53
 */
public class CalculatorPanel extends JPanel {

    private static final float TEXT_EDIT_PANEL_HEIGHT_RADIO = 0.26F;

    // 包含输入和结果文本框的容器
    private final TextEditPanel mPanelTextEdit;
    // 显示按钮的容器
    private final ButtonPanel mPanelButton;

    public CalculatorPanel() {
        super(null);
        mPanelTextEdit = new TextEditPanel();
        mPanelButton = new ButtonPanel(mPanelTextEdit, mPanelTextEdit);
        add(mPanelTextEdit);
        add(mPanelButton);
    }

    /**
     * 布局
     * @param x 左上角坐标 x
     * @param y 左上角坐标 y
     * @param width 宽
     * @param height 高
     */
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        mPanelTextEdit.setBounds(0, 0, width, (int) (height * TEXT_EDIT_PANEL_HEIGHT_RADIO));
        mPanelButton.setBounds(0, mPanelTextEdit.getHeight() + 10, width, height - mPanelTextEdit.getHeight() - 55);
    }
}
