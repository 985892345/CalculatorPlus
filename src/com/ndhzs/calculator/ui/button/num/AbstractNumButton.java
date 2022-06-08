package com.ndhzs.calculator.ui.button.num;

import com.ndhzs.calculator.ui.button.AbstractCalculatorButton;
import com.ndhzs.calculator.ui.button.IOperate;

import java.awt.event.ActionEvent;

public abstract class AbstractNumButton extends AbstractCalculatorButton {

    public AbstractNumButton(String num, IOperate iOperate) {
        super(num, iOperate);
    }

    @Override
    protected String onOperate(String input, ActionEvent event) {
        return getOutput(input);
    }

    protected boolean isInputLegal(String input) {
        char last = input.charAt(input.length() - 1);
        switch (last) {
            case 'π':{
                return false;
            }
            case 'e':{
                if(input.length()>1) {
                    char lastSecond = input.charAt(input.length() - 2);
                    if(!Character.isDigit(lastSecond)){
                        return false;
                    }
                    return false;
                }
                break;
            }
            default:
                return true;
        }
        return true;
    }

    private String getOutput(String input) {
        if (isInputLegal(input)) {
            if ("0".equals(input)) {
                // 如果只有一个 0
                return getText();
            }
            // 倒序遍历
            for (int i = input.length() - 1; i >= 0; i--) {
                char c = input.charAt(i);
                if (!Character.isDigit(c)) {
                    // 找到倒序中第一个非数字
                    if (c == '.') {
                        // 判断小数点
                        return input + getText();
                    }
                    // 从后往前便利找到第一个不是数字的索引
                    if (i < input.length() - 1) {
                        // 后面的那一位要判断是否越界
                        if (input.charAt(i + 1) == '0') {
                            return input.substring(0, input.length() - 1) + getText();
                        }
                    }
                    break;
                }
            }
            return input + getText();
        }
        return null;
    }
}
