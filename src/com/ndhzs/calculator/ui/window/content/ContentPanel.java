package com.ndhzs.calculator.ui.window.content;

import com.ndhzs.calculator.ui.window.content.calculator.CalculatorPanel;
import com.ndhzs.calculator.ui.window.content.convert.ConvertPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 显示主要内容的容器，里面包含计算器主界面和换算主界面
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 17:08
 */
public class ContentPanel extends JPanel implements IContent {

    private static final String PANEL_CALCULATOR = "PANEL_CALCULATOR";
    private static final String PANEL_CONVERT = "PANEL_CONVERT";

    // 计算器主界面
    private final CalculatorPanel mPanelCalculator = new CalculatorPanel();
    // 换算主界面
    private final ConvertPanel mPanelConvert = new ConvertPanel();

    private final CardLayout mCardLayout = new CardLayout();

    public ContentPanel() {
        super(null);
        setLayout(mCardLayout);
        add(mPanelCalculator, PANEL_CALCULATOR);
        add(mPanelConvert, PANEL_CONVERT);
    }

    /**
     * 显示计算器界面
     */
    @Override
    public void showCalculator() {
        mCardLayout.show(this, PANEL_CALCULATOR);
    }

    /**
     * 显示换算主界面
     */
    @Override
    public void showConvert() {
        mCardLayout.show(this, PANEL_CONVERT);
        mPanelConvert.showSelectConvert();
    }
}
