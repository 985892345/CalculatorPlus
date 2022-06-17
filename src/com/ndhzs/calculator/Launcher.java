package com.ndhzs.calculator;

import com.ndhzs.calculator.ui.Window;

/**
 * 用于启动整个系统
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/6 15:24
 */
public class Launcher {
    public static void main(String[] args) {
        Window window = new Window(400, 680);
        window.show();
    }
}
