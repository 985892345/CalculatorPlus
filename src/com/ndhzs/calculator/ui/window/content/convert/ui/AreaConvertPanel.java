package com.ndhzs.calculator.ui.window.content.convert.ui;

import com.ndhzs.calculator.ui.window.content.convert.IConvert;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 11:00
 */
public class AreaConvertPanel extends AbstractGeneralUiConvertPanel {

    public static final String TITLE = "面积转换";

    private static final String[] INPUT_TYPE = {
            "平方米", "平方分米", "平方厘米", "平方毫米", "平方微米"
    };

    private static final String[] OUTPUT_TYPE = {
            "平方米", "平方分米", "平方厘米", "平方毫米", "平方微米"
    };

    public AreaConvertPanel(IConvert iConvert) {
        super(TITLE, INPUT_TYPE, OUTPUT_TYPE, iConvert);
    }

    @Override
    protected void onInput(String input, int inputIndex, int outputIndex) {
        double result = Double.parseDouble(input) * Math.pow(10, (outputIndex - inputIndex) * 2);
        setResult(String.valueOf(result));
    }
}
