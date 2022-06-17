package com.ndhzs.calculator.ui.window.content.convert.ui;

import com.ndhzs.calculator.ui.button.IOperate;

import javax.swing.*;
import java.awt.*;
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

    // 标题
    private final JTextField mTitle = new JTextField();

    // 输入的多选框
    private final JComboBox<String> mComboBoxInput;
    // 输出的多选框
    private final JComboBox<String> mComboBoxOutput;

    // 输入的文本框
    private final JTextField mTextInput = new JTextField("0");
    // 输出的文本框
    private final JTextField mTextOutput = new JTextField("0");

    public AbstractUiConvertPanel(String title, String[] inputTypes, String[] outputTypes) {
        super(null);
        mTitle.setText(title);
        mTitle.setEditable(false);

        mComboBoxInput = new JComboBox<>(inputTypes);
        mComboBoxOutput = new JComboBox<>(outputTypes);

        mTitle.setHorizontalAlignment(JTextField.CENTER);

        // 设置默认选择项
        mComboBoxInput.setSelectedIndex(0);
        mComboBoxOutput.setSelectedIndex(1);

        // 添加选择监听
        mComboBoxInput.addItemListener(itemEvent ->
                onInput(mTextInput.getText(), mComboBoxInput.getSelectedIndex(), mComboBoxOutput.getSelectedIndex()));
        mComboBoxOutput.addItemListener(itemEvent ->
                onInput(mTextInput.getText(), mComboBoxInput.getSelectedIndex(), mComboBoxOutput.getSelectedIndex()));
        // 设置背景
        mComboBoxInput.setBackground(Color.WHITE);
        mComboBoxOutput.setBackground(Color.WHITE);

        // 设置不可选中编辑
        mTextInput.setEditable(false);
        mTextOutput.setEditable(false);

        // 设置文本边距值
        mTextInput.setMargin(new Insets(0, 4, 0, 0));
        mTextOutput.setMargin(new Insets(0, 4, 0, 0));

        add(mTitle);
        add(mComboBoxInput);
        add(mComboBoxOutput);
        add(mTextInput);
        add(mTextOutput);
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
        int childWidth = width;
        int childHeight = (int) (height * 0.05);
        mTitle.setBounds(childX, childY, childWidth, childHeight);

        double heightRadio = 0.2;

        childY += childHeight;
        childWidth = (int) (width  * 0.3);
        childHeight = (int) (height * heightRadio);
        mComboBoxInput.setBounds(childX, childY, childWidth, childHeight);

        childY += childHeight;
        mComboBoxOutput.setBounds(childX, childY, childWidth, childHeight);

        childX += childWidth;
        childWidth = width - childWidth;
        mTextOutput.setBounds(childX, childY, childWidth, childHeight);

        childY -= (int) (height * heightRadio);
        mTextInput.setBounds(childX, childY, childWidth, childHeight);
    }

    /**
     * @return 在子类中得到子控件已使用的高度
     */
    protected int getUsedHeight() {
        return mTitle.getHeight() + mComboBoxInput.getHeight() + mComboBoxOutput.getHeight();
    }

    /**
     * @return 得到输入值
     */
    @Override
    public String input() {
        return mTextInput.getText();
    }

    /**
     * @param output 输出值
     */
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

    /**
     * 多选框监听的回调，由子类实现
     * @param input 输入值
     * @param inputIndex 输入多选框选择的索引值
     * @param outputIndex 输出多选框选择的索引值
     */
    protected abstract void onInput(String input, int inputIndex, int outputIndex);
}
