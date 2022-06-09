package com.ndhzs.calculator.ui.window.content.calculator.button;

import com.ndhzs.calculator.ui.button.IOperate;
import com.ndhzs.calculator.ui.button.complex.*;
import com.ndhzs.calculator.ui.button.num.*;
import com.ndhzs.calculator.ui.button.simple.*;

import javax.swing.*;
import java.awt.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 15:53
 */
public class ComplexButtonPanel extends JPanel implements SwitchButton.INextButtonPanel, IOperate, EquButton.IEqualOutput {

    private final ClearButton mBtnClear = new ClearButton(this);
    private final BackButton mBtnBack = new BackButton(this);
    private final ModButton mBtnMod = new ModButton(this);
    private final DivButton mBtnDiv = new DivButton(this);
    private final MulButton mBtnMul = new MulButton(this);
    private final SubButton mBtnSub = new SubButton(this);
    private final AddButton mBtnAdd = new AddButton(this);
    private final EquButton mBtnEqu = new EquButton(this, this);
    private final PointButton mBtnPoint = new PointButton(this);
    private final SwitchButton mBtnSwitch = new SwitchButton(this, this);
    private final ArcButton mBtnArc = new ArcButton(this);
    private final InverseTrigButton mBtnDegToRad = new InverseTrigButton(this);
    private final SinButton mBtnSin = new SinButton(this);
    private final CosButton mBtnCos = new CosButton(this);
    private final TanButton mBtnTan = new TanButton(this);
    private final PowerButton mBtnPow = new PowerButton(this);
    private final SqrtButton mBtnSqrt = new SqrtButton(this);
    private final FactorialButton mBtnFactorial = new FactorialButton(this);
    private final InverseButton mBtnInverse = new InverseButton(this);
    private final PiButton mBtnPi = new PiButton(this);
    private final LgButton mBtnLg = new LgButton(this);
    private final LnButton mBtnLn = new LnButton(this);
    private final LBracketButton mBtnLBracket = new LBracketButton(this);
    private final RBracketButton mBtnRBracket = new RBracketButton(this);
    private final EButton mBtnE = new EButton(this);

    private final Num0Button mBtnNum0 = new Num0Button(this);
    private final Num1Button mBtnNum1 = new Num1Button(this);
    private final Num2Button mBtnNum2 = new Num2Button(this);
    private final Num3Button mBtnNum3 = new Num3Button(this);
    private final Num4Button mBtnNum4 = new Num4Button(this);
    private final Num5Button mBtnNum5 = new Num5Button(this);
    private final Num6Button mBtnNum6 = new Num6Button(this);
    private final Num7Button mBtnNum7 = new Num7Button(this);
    private final Num8Button mBtnNum8 = new Num8Button(this);
    private final Num9Button mBtnNum9 = new Num9Button(this);

    private final SwitchButton.INextButtonPanel mINext;
    private final IOperate mIOperate;
    private final EquButton.IEqualOutput mIEqualOutput;

    private static final int ROWS = 7;
    private static final int COLS = 5;
    private static final int MARGIN = 5;

    private final JButton[][] mBtnAll = {
            {mBtnArc, mBtnDegToRad, mBtnSin, mBtnCos, mBtnTan},
            {mBtnPow, mBtnLg, mBtnLn, mBtnLBracket, mBtnRBracket},
            {mBtnSqrt, mBtnClear, mBtnBack, mBtnMod, mBtnDiv},
            {mBtnFactorial, mBtnNum7, mBtnNum8, mBtnNum9, mBtnMul},
            {mBtnInverse, mBtnNum4, mBtnNum5, mBtnNum6, mBtnSub},
            {mBtnPi, mBtnNum1, mBtnNum2, mBtnNum3, mBtnAdd},
            {mBtnSwitch, mBtnE, mBtnNum0, mBtnPoint, mBtnEqu}
    };

    public ComplexButtonPanel(SwitchButton.INextButtonPanel iNext, IOperate iOperate, EquButton.IEqualOutput iEqualOutput) {
        super(new GridLayout(ROWS, COLS, MARGIN, MARGIN));
        this.mINext = iNext;
        this.mIOperate = iOperate;
        this.mIEqualOutput = iEqualOutput;
        initButton();
    }

    private void initButton() {
        for (JButton[] jButtons : mBtnAll) {
            for (JButton jButton : jButtons) {
                add(jButton);
            }
        }

        mBtnArc.addActionListener(e -> {
            if (mBtnDegToRad.isEnabled()) {
                mBtnDegToRad.setEnabled(false);
                mBtnSin.setText("arcsin");
                mBtnCos.setText("arccos");
                mBtnTan.setText("arctan");
            } else {
                mBtnDegToRad.setEnabled(true);
                mBtnSin.setText("sin");
                mBtnCos.setText("cos");
                mBtnTan.setText("tan");
            }
        });

        mBtnDegToRad.addActionListener(e -> {
            if (mBtnArc.isEnabled()) {
                mBtnArc.setEnabled(false);
                mBtnSin.setText("csc");
                mBtnCos.setText("sec");
                mBtnTan.setText("cot");
            } else {
                mBtnArc.setEnabled(true);
                mBtnSin.setText("sin");
                mBtnCos.setText("cos");
                mBtnTan.setText("tan");
            }
        });
    }

    @Override
    public String input() {
        return mIOperate.input();
    }

    @Override
    public void output(String output) {
        mIOperate.output(output);
    }

    @Override
    public void showSimpleButton() {
        mINext.showSimpleButton();
    }

    @Override
    public void showComplexButton() {
        mINext.showComplexButton();
    }

    @Override
    public int getNowUIPosition() {
        return mINext.getNowUIPosition();
    }

    @Override
    public void onResult(String output) {
        mIEqualOutput.onResult(output);
    }
}
