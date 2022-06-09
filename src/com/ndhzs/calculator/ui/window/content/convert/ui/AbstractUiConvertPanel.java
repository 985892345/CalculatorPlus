package com.ndhzs.calculator.ui.window.content.convert.ui;

import com.ndhzs.calculator.ui.button.IOperate;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 11:17
 */
public abstract class AbstractUiConvertPanel extends JPanel implements IOperate {

    private final JTextField mTitle = new JTextField();

    private final JComboBox<String> mComboBoxInput;
    private final JComboBox<String> mComboBoxOutput;

    private final JTextField mTextInput = new JTextField("0");
    private final JTextField mTextOutput = new JTextField("0");

    public AbstractUiConvertPanel(String title, String[] inputTypes, String[] outputTypes) {
        super(null);
        mTitle.setText(title);
        mComboBoxInput = new JComboBox<>(inputTypes);
        mComboBoxOutput = new JComboBox<>(outputTypes);

        mTitle.setHorizontalAlignment(JTextField.CENTER);
        mComboBoxInput.setSelectedIndex(0);
        mComboBoxOutput.setSelectedIndex(1);
        mComboBoxInput.addItemListener(itemEvent ->
                onInput(mTextInput.getText(), mComboBoxInput.getSelectedIndex(), mComboBoxOutput.getSelectedIndex()));
        mComboBoxOutput.addItemListener(itemEvent ->
                onInput(mTextInput.getText(), mComboBoxInput.getSelectedIndex(), mComboBoxOutput.getSelectedIndex()));

        mTextInput.setEditable(false);
        mTextOutput.setEditable(false);

        add(mTitle);
        add(mComboBoxInput);
        add(mComboBoxOutput);
        add(mTextInput);
        add(mTextOutput);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        int childX = 0;
        int childY = 0;
        int childWidth = width;
        int childHeight = (int) (height * 0.05);
        mTitle.setBounds(childX, childY, childWidth, childHeight);

        childY += childHeight;
        childWidth = (int) (width  * 0.2);
        childHeight = (int) (height * 0.1);
        mComboBoxInput.setBounds(childX, childY, childWidth, childHeight);

        childY += childHeight;
        mComboBoxOutput.setBounds(childX, childY, childWidth, childHeight);

        childX += childWidth;
        childWidth = width - childWidth;
        mTextOutput.setBounds(childX, childY, childWidth, childHeight);

        childY -= (int) (height * 0.1);
        mTextInput.setBounds(childX, childY, childWidth, childHeight);
    }

    protected int getUsedHeight() {
        return mTitle.getHeight() + mComboBoxInput.getHeight() + mComboBoxOutput.getHeight();
    }

    @Override
    public String input() {
        return mTextInput.getText();
    }

    @Override
    public void output(String output) {
        if (output != null) {
            mTextInput.setText(output);
            onInput(output, mComboBoxInput.getSelectedIndex(), mComboBoxOutput.getSelectedIndex());
        }
    }

    /**
     * 设置结果
     * @param text 结果值
     */
    protected void setResult(String text) {
        mTextOutput.setText(text);
    }

    protected abstract void onInput(String input, int inputIndex, int outputIndex);
}
