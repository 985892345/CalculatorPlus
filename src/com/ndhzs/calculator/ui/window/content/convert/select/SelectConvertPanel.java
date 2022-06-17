package com.ndhzs.calculator.ui.window.content.convert.select;

import com.ndhzs.calculator.ui.window.content.convert.IConvert;
import com.ndhzs.calculator.ui.window.content.convert.ui.AreaConvertPanel;
import com.ndhzs.calculator.ui.window.content.convert.ui.TimeConvertPanel;
import com.ndhzs.calculator.ui.window.content.convert.ui.VelocityConvertPanel;
import com.ndhzs.calculator.ui.window.content.convert.ui.VolumeConvertPanel;

import javax.swing.*;
import java.awt.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 9:04
 */
public class SelectConvertPanel extends JPanel {

    private final IConvert mIConvert;

    private final JButton mBtnAreaConvert = new JButton(AreaConvertPanel.TITLE);
    private final JButton mBtnHexBinDecOct = new JButton(TimeConvertPanel.TITLE);
    private final JButton mBtnVelocity = new JButton(VelocityConvertPanel.TITLE);
    private final JButton mBtnVolume = new JButton(VolumeConvertPanel.TITLE);

    public SelectConvertPanel(IConvert iConvert) {
        super(new GridLayout(2, 2, 5, 5));
        this.mIConvert = iConvert;
        add(mBtnAreaConvert);
        add(mBtnHexBinDecOct);
        add(mBtnVelocity);
        add(mBtnVolume);
        initBtn();
    }

    private void initBtn() {
        mBtnAreaConvert.addActionListener(e -> mIConvert.showAreaConvert());
        mBtnHexBinDecOct.addActionListener(e -> mIConvert.showTimeConvert());
        mBtnVelocity.addActionListener(e -> mIConvert.showVelocityConvert());
        mBtnVolume.addActionListener(e -> mIConvert.showVolumeConvert());
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, (int) (height * 0.4));
    }
}
