package com.ndhzs.calculator.ui.window.content.convert;

import com.ndhzs.calculator.ui.window.content.convert.select.SelectConvertPanel;
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
 * @date 2022/6/7 8:51
 */
public class ConvertPanel extends JPanel implements IConvert {

    private final CardLayout mCardLayout = new CardLayout();

    private static final String PANEL_SELECT_CONVERT = "PANEL_SELECT_CONVERT";
    private static final String PANEL_AREA_CONVERT = "PANEL_AREA_CONVERT";
    private static final String PANEL_HEX_BIN_DEC_OCT_CONVERT = "PANEL_HEX_BIN_DEC_OCT";
    private static final String PANEL_VELOCITY_CONVERT = "PANEL_VELOCITY_CONVERT";
    private static final String PANEL_VOLUME_CONVERT = "PANEL_VOLUME_CONVERT";


    private final SelectConvertPanel mPanelSelectConvert;
    private final AreaConvertPanel mPanelAreaConvert;
    private final TimeConvertPanel mPanelHexBinDecOctConvert;
    private final VelocityConvertPanel mPanelVelocityConvert;
    private final VolumeConvertPanel mPanelVolumeConvert;

    public ConvertPanel() {
        super(null);
        setLayout(mCardLayout);
        mPanelSelectConvert = new SelectConvertPanel(this);
        mPanelAreaConvert = new AreaConvertPanel(this);
        mPanelHexBinDecOctConvert = new TimeConvertPanel(this);
        mPanelVelocityConvert = new VelocityConvertPanel(this);
        mPanelVolumeConvert = new VolumeConvertPanel(this);
        add(mPanelSelectConvert, PANEL_SELECT_CONVERT);
        add(mPanelAreaConvert, PANEL_AREA_CONVERT);
        add(mPanelHexBinDecOctConvert, PANEL_HEX_BIN_DEC_OCT_CONVERT);
        add(mPanelVelocityConvert, PANEL_VELOCITY_CONVERT);
        add(mPanelVolumeConvert, PANEL_VOLUME_CONVERT);
    }

    public void showMainUI() {
        mCardLayout.show(this, PANEL_SELECT_CONVERT);
    }

    @Override
    public void showSelectConvert() {
        mCardLayout.show(this, PANEL_SELECT_CONVERT);
    }

    @Override
    public void showAreaConvert() {
        mCardLayout.show(this, PANEL_AREA_CONVERT);
    }

    @Override
    public void showHexBinDecOctConvert() {
        mCardLayout.show(this, PANEL_HEX_BIN_DEC_OCT_CONVERT);
    }

    @Override
    public void showVelocityConvert() {
        mCardLayout.show(this, PANEL_VELOCITY_CONVERT);
    }

    @Override
    public void showVolumeConvert() {
        mCardLayout.show(this, PANEL_VOLUME_CONVERT);
    }
}
