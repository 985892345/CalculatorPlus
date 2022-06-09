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
    protected void onInput(String input, int inputIndex, int outputIndex) {
        //"年", "周", "天", "小时", "分钟", "秒", "毫秒"
        if(inputIndex == outputIndex){
            setResult(input);
            return;
        }
        double inputDouble = Double.parseDouble(input);
        switch (inputIndex){
            case 0: {
                switch (outputIndex){
                    case 1: {
                        inputDouble = inputDouble * 365 / 7;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 2: {
                        inputDouble = inputDouble * 365;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 3: {
                        inputDouble = inputDouble * 365 * 24;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 4: {
                        inputDouble = inputDouble * 365 * 24 * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 5: {
                        inputDouble = inputDouble * 365 * 24 * 60 * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 6: {
                        inputDouble = inputDouble * 365 * 24 * 60 * 60 * 1000;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                }
                break;
            }
            case 1: {
                switch (outputIndex) {
                    case 0: {
                        inputDouble = inputDouble * 7 / 365;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 2: {
                        inputDouble = inputDouble * 7;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 3: {
                        inputDouble = inputDouble * 7 * 24;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 4: {
                        inputDouble = inputDouble * 7 * 24 * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 5: {
                        inputDouble = inputDouble * 7 * 24 * 60 * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 6: {
                        inputDouble = inputDouble * 7 * 24 * 60 * 60 * 1000;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (outputIndex) {
                    case 0: {
                        inputDouble = inputDouble / 365;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 1: {
                        inputDouble = inputDouble / 7;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 3: {
                        inputDouble = inputDouble * 24;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 4: {
                        inputDouble = inputDouble * 24 * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 5: {
                        inputDouble = inputDouble * 24 * 60 * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 6: {
                        inputDouble = inputDouble * 24 * 60 * 60 * 1000;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                }
                break;
            }
            case 3:{
                switch (outputIndex) {
                    case 0: {
                        inputDouble = inputDouble /24 / 365;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 1: {
                        inputDouble = inputDouble / 24 / 7;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 2: {
                        inputDouble = inputDouble / 24;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 4: {
                        inputDouble = inputDouble * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 5: {
                        inputDouble = inputDouble * 60 * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 6: {
                        inputDouble = inputDouble * 60 * 60 * 1000;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                }
                break;
            }
            case 4: {
                switch (outputIndex) {
                    case 0: {
                        inputDouble = inputDouble / 60 /24 / 365;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 1: {
                        inputDouble = inputDouble / 60 / 24 / 7;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 2: {
                        inputDouble = inputDouble / 60 / 24;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 3: {
                        inputDouble = inputDouble / 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 5: {
                        inputDouble = inputDouble * 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 6: {
                        inputDouble = inputDouble * 60 * 1000;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                }
                break;
            }
            case 5: {
                switch (outputIndex) {
                    case 0: {
                        inputDouble = inputDouble / 60 / 60 /24 / 365;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 1: {
                        inputDouble = inputDouble / 60 / 60 / 24 / 7;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 2: {
                        inputDouble = inputDouble / 60 / 60 / 24;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 3: {
                        inputDouble = inputDouble / 60 / 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 4: {
                        inputDouble = inputDouble / 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 6: {
                        inputDouble = inputDouble * 1000;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                }
                break;
            }
            case 6:{
                switch (outputIndex) {
                    case 0: {
                        inputDouble = inputDouble / 1000 / 60 / 60 /24 / 365;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 1: {
                        inputDouble = inputDouble / 1000 / 60 / 60 / 24 / 7;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 2: {
                        inputDouble = inputDouble / 1000 / 60 / 60 / 24;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 3: {
                        inputDouble = inputDouble / 1000 / 60 / 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 4: {
                        inputDouble = inputDouble / 1000 / 60;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                    case 5: {
                        inputDouble = inputDouble / 1000;
                        setResult(String.valueOf(inputDouble));
                        break;
                    }
                }
                break;
            }
        }
    }
}
