package com.ndhzs.calculator.ui.window.content.calculator.text;

import com.ndhzs.calculator.ui.button.IOperate;

import javax.swing.*;
import java.awt.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 15:53
 */
public class TextEditPanel extends JPanel implements IOperate {

    private static final float TEXT_AREA_INPUT_HEIGHT_RADIO = 0.7F;
    private static final float TEXT_AREA_RESULT_HEIGHT_RADIO = 0.3F;

    private final JTextField mTextAreaInput = new JTextField("0");
    private final JTextField mTextAreaResult = new JTextField("计算结果");

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

    @Override
    public String input() {
        return mTextAreaInput.getText();
    }

    @Override
    public void output(String output) {
        if (output != null) {
            mTextAreaInput.setText(output);
        }
    }
}
