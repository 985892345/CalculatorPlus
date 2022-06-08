package com.ndhzs.calculator.ui.window.content.convert.ui;

import com.ndhzs.calculator.ui.window.content.convert.IConvert;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 10:34
 */
public class TimeConvertPanel extends AbstractGeneralUiConvertPanel {

    public static final String TITLE = "时间转换";

    private static final String[] INPUT_TYPE = {
            "年", "周", "天", "小时", "分钟", "秒", "毫秒"
    };

    private static final String[] OUTPUT_TYPE = {
            "年", "周", "天", "小时", "分钟", "秒", "毫秒"
    };

    public TimeConvertPanel(IConvert iConvert) {
        super(TITLE, INPUT_TYPE, OUTPUT_TYPE, iConvert);
    }

    @Override
    protected void onInput(String input) {

    }
}
