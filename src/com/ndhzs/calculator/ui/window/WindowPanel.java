package com.ndhzs.calculator.ui.window;

import com.ndhzs.calculator.ui.window.content.ContentPanel;
import com.ndhzs.calculator.ui.window.toorbar.ToolBarPanel;

import javax.swing.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 15:49
 */
public class WindowPanel extends JPanel {

    private static final float TOOL_BAR_HEIGHT_RADIO = 0.06F;

    private final ToolBarPanel mPanelToolBar;
    private final ContentPanel mPanelContent;

    public WindowPanel() {
        super(null);
        mPanelContent = new ContentPanel();
        mPanelToolBar = new ToolBarPanel(mPanelContent);
        add(mPanelToolBar);
        add(mPanelContent);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        mPanelToolBar.setBounds(0, 0, width - 10, (int) (height * TOOL_BAR_HEIGHT_RADIO));
        mPanelContent.setBounds(10, mPanelToolBar.getHeight(), width - 30, height - mPanelToolBar.getHeight());
    }
}
