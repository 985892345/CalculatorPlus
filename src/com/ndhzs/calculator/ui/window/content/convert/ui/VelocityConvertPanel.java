package com.ndhzs.calculator.ui.window.content.convert.ui;

import com.ndhzs.calculator.ui.window.content.convert.IConvert;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 11:01
 */
public class VelocityConvertPanel extends AbstractGeneralUiConvertPanel {

    public static final String TITLE = "速度转换";

    private static final String[] INPUT_TYPE = {
            "米/秒", "千米/小时", "千米/秒"
    };

    private static final String[] OUTPUT_TYPE = {
            "米/秒", "千米/小时", "千米/秒"
    };

    public VelocityConvertPanel(IConvert iConvert) {
        super(TITLE, INPUT_TYPE, OUTPUT_TYPE, iConvert);
    }

    @Override
    protected void onInput(String input) {

    }
}
