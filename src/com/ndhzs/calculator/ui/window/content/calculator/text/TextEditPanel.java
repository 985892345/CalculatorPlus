package com.ndhzs.calculator.ui.window.content.calculator.text;

import com.ndhzs.calculator.ui.button.IOperate;
import com.ndhzs.calculator.ui.button.simple.EquButton;
import com.ndhzs.calculator.utils.CalculatorUtils;

import javax.swing.*;
import java.awt.*;

/**
 * 包含输入和结果文本框的容器，包含显示输入的文本框和显示计算结果的文本框
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 15:53
 */
public class TextEditPanel extends JPanel implements IOperate, EquButton.IEqualOutput {

    private static final float TEXT_AREA_INPUT_HEIGHT_RADIO = 0.7F;
    private static final float TEXT_AREA_RESULT_HEIGHT_RADIO = 0.3F;

    // 显示输入的文本框
    private final JTextField mTextAreaInput = new JTextField("0");
    // 显示计算结果的文本框
    private final JTextField mTextAreaResult = new JTextField("0");

    public TextEditPanel() {
        super(null);
        initTextArea();
    }

    private void initTextArea() {
        add(mTextAreaInput);
        add(mTextAreaResult);

        mTextAreaInput.setMargin(new Insets(10, 10, 10, 10));
        mTextAreaResult.setMargin(new Insets(10, 10, 10, 10));

        mTextAreaInput.setFont(new Font(null, Font.BOLD, 40));
        mTextAreaResult.setFont(new Font(null, Font.PLAIN, 26));

        mTextAreaInput.setEditable(false);
        mTextAreaResult.setEditable(false);

        mTextAreaInput.setBackground(Color.LIGHT_GRAY);
        mTextAreaResult.setBackground(Color.GRAY);
    }

    /**
     * 布局
     * @param x 左上角坐标 x
     * @param y 左上角坐标 y
     * @param width 宽
     * @param height 高
     */
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        int childX = 0;
        int childY = 0;
        int childWidth = width - 2;
        int childHeight = (int) (height * TEXT_AREA_INPUT_HEIGHT_RADIO);
        mTextAreaInput.setBounds(childX, childY, childWidth, childHeight);

        childY += childHeight;
        childHeight = (int) (height * TEXT_AREA_RESULT_HEIGHT_RADIO);
        mTextAreaResult.setBounds(childX, childY, childWidth, childHeight);
    }

    /**
     * 得到输入值
     * @return 输出值
     */
    @Override
    public String input() {
        return mTextAreaInput.getText();
    }

    /**
     * 向外输出值
     * @param output 输出值
     */
    @Override
    public void output(String output) {
        if (output != null) {
            mTextAreaInput.setText(output);
            try {
                mTextAreaResult.setText(String.valueOf(CalculatorUtils.getResult(output)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置结果
     * @param output 输出的结果值
     */
    @Override
    public void onResult(String output) {
        try {
            mTextAreaResult.setText(String.valueOf(CalculatorUtils.getResult(output)));
        } catch (Exception e) {
            e.printStackTrace();
            mTextAreaResult.setText("计算出错");
        }
    }
}
