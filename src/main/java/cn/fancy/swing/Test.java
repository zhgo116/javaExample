package cn.fancy.swing;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(200, 200, 400, 400);

        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("鼠标点击事件");
            }
        });

        jFrame.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println("焦点事件");
            }
        });
    }
}
