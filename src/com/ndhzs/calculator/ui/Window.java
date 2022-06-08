package com.ndhzs.calculator.ui;

import com.ndhzs.calculator.ui.window.WindowPanel;

import javax.swing.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 15:25
 */
public class Window {

    private final JFrame mWindow = new JFrame("计算器增强版");

    public Window(int width, int height) {
        mWindow.setLayout(null);
        mWindow.setResizable(false);
        mWindow.setSize(width, height);
        mWindow.setLocationRelativeTo(null);
        mWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        WindowPanel windowPanel = new WindowPanel();
        windowPanel.setBounds(0, 0, width, height);
        mWindow.add(windowPanel);
    }

    public void show() {
        mWindow.setVisible(true);
    }
}
