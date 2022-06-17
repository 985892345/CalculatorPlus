package com.ndhzs.calculator.ui.window.toorbar;

import com.ndhzs.calculator.ui.window.content.IContent;

import javax.swing.*;
import java.awt.*;

/**
 * 顶部按钮容器，其中包含“计算”和“换算”两个按钮
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 16:20
 */
public class ToolBarPanel extends JPanel {

    private final JButton mBtnCalculate = new JButton("计算");
    private final JButton mBtnConvert = new JButton("换算");

    private final IContent mIContent;

    public ToolBarPanel(IContent iContent) {
        super(new GridLayout(1, 2));
        this.mIContent = iContent;
        initLayout();
        initButton();
        initAction();
    }

    /**
     * 设置布局
     */
    private void initLayout() {
        mBtnCalculate.setBackground(Color.WHITE);
        mBtnConvert.setBackground(Color.WHITE);
        add(mBtnCalculate);
        add(mBtnConvert);
    }

    /**
     * 设置按钮
     */
    private void initButton() {
        mBtnCalculate.setToolTipText("打开计算界面");
        mBtnConvert.setToolTipText("打开换算界面");
    }

    /**
     * 设置点击事件
     */
    private void initAction() {
        mBtnCalculate.addActionListener(e -> mIContent.showCalculator());
        mBtnConvert.addActionListener(e -> mIContent.showConvert());
    }
}
