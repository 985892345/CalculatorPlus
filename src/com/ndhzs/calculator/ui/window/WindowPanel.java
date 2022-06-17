package com.ndhzs.calculator.ui.window;

import com.ndhzs.calculator.ui.window.content.ContentPanel;
import com.ndhzs.calculator.ui.window.toorbar.ToolBarPanel;

import javax.swing.*;

/**
 * 整体界面的容器，里面包含其他界面
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 15:49
 */
public class WindowPanel extends JPanel {

    private static final float TOOL_BAR_HEIGHT_RADIO = 0.06F;

    // 包含顶部按钮的容器
    private final ToolBarPanel mPanelToolBar;

    // 显示主要内容的容器
    private final ContentPanel mPanelContent;

    public WindowPanel() {
        super(null);
        mPanelContent = new ContentPanel();
        mPanelToolBar = new ToolBarPanel(mPanelContent);
        add(mPanelToolBar);
        add(mPanelContent);
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
        mPanelToolBar.setBounds(0, 0, width - 10, (int) (height * TOOL_BAR_HEIGHT_RADIO));
        mPanelContent.setBounds(10, mPanelToolBar.getHeight(), width - 30, height - mPanelToolBar.getHeight());
    }
}
