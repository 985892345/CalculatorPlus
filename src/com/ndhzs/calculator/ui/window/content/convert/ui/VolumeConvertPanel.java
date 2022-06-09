package com.ndhzs.calculator.ui.window.content.convert.ui;

import com.ndhzs.calculator.ui.window.content.convert.IConvert;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 10:58
 */
public class VolumeConvertPanel extends AbstractGeneralUiConvertPanel {

    public static final String TITLE = "体积转换";

    private static final String[] INPUT_TYPE = {
            "立方米", "立方分米", "立方厘米", "立方毫米", "立方微米"
    };

    private static final String[] OUTPUT_TYPE = {
            "立方米", "立方分米", "立方厘米", "立方毫米", "立方微米"
    };

    public VolumeConvertPanel(IConvert iConvert) {
        super(TITLE, INPUT_TYPE, OUTPUT_TYPE, iConvert);
    }

    @Override
    protected void onInput(String input, int inputIndex, int outputIndex) {
        double result = Double.parseDouble(input) * Math.pow(10, (outputIndex - inputIndex) * 3);
        setResult(String.valueOf(result));
    }
}
