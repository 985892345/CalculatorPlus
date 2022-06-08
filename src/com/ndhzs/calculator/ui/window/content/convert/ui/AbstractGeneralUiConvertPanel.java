package com.ndhzs.calculator.ui.window.content.convert.ui;

import com.ndhzs.calculator.ui.button.num.*;
import com.ndhzs.calculator.ui.button.simple.BackButton;
import com.ndhzs.calculator.ui.button.simple.ClearButton;
import com.ndhzs.calculator.ui.button.simple.PointButton;
import com.ndhzs.calculator.ui.window.content.convert.IConvert;

import javax.swing.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/8 8:41
 */
public abstract class AbstractGeneralUiConvertPanel extends AbstractUiConvertPanel {

    private final ClearButton mBtnClear = new ClearButton(this);
    private final BackButton mBtnBack = new BackButton(this);
    private final PointButton mBtnPoint = new PointButton(this);

    private final Num0Button mBtnNum0 = new Num0Button(this);
    private final Num1Button mBtnNum1 = new Num1Button(this);
    private final Num2Button mBtnNum2 = new Num2Button(this);
    private final Num3Button mBtnNum3 = new Num3Button(this);
    private final Num4Button mBtnNum4 = new Num4Button(this);
    private final Num5Button mBtnNum5 = new Num5Button(this);
    private final Num6Button mBtnNum6 = new Num6Button(this);
    private final Num7Button mBtnNum7 = new Num7Button(this);
    private final Num8Button mBtnNum8 = new Num8Button(this);
    private final Num9Button mBtnNum9 = new Num9Button(this);

    private final JButton mBtnBackUI = new JButton("返回");

    private final JButton[][] mBtnGrid = {
            {mBtnNum7, mBtnNum8, mBtnNum9},
            {mBtnNum4, mBtnNum5, mBtnNum6},
            {mBtnNum1, mBtnNum2, mBtnNum3},
            {mBtnBackUI, mBtnNum0, mBtnPoint}
    };

    public AbstractGeneralUiConvertPanel(String title, String[] inputTypes, String[] outputTypes, IConvert iConvert) {
        super(title, inputTypes, outputTypes);

        mBtnBackUI.addActionListener(e -> iConvert.showSelectConvert());

        add(mBtnBackUI);
        add(mBtnClear);
        add(mBtnBack);
        add(mBtnPoint);
        add(mBtnNum0);
        add(mBtnNum1);
        add(mBtnNum2);
        add(mBtnNum3);
        add(mBtnNum4);
        add(mBtnNum5);
        add(mBtnNum6);
        add(mBtnNum7);
        add(mBtnNum8);
        add(mBtnNum9);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

        final int interval = 1;

        int childDx = width / 4;
        int childDy = (height - getUsedHeight() - 50) / 4;

        int childX = 0;
        int childY = 0;
        int childWidth = childDx - interval * 2;
        int childHeight = childDy - interval * 2;

        for (int i = 0; i < 4; i++) {
            childY = childDy * i + interval + getUsedHeight();
            for (int j = 0; j < 3; j++) {
                childX = childDx * j + interval;
                mBtnGrid[i][j].setBounds(childX, childY, childWidth, childHeight);
            }
        }
        childX = childDx * 3 + interval;
        childY = interval + getUsedHeight();
        childHeight = childDy * 2 - interval * 2;
        mBtnClear.setBounds(childX, childY, childWidth, childHeight);

        childY = childDy * 2 + interval + getUsedHeight();
        mBtnBack.setBounds(childX, childY, childWidth, childHeight);
    }
}
