package cn.openread.demo.frame;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * 简单版
 */
public class HelloLabel {

    public static void main(String args[]) throws InterruptedException {
        JFrame frame = new JFrame("Hello World");
        JLabel label = new JLabel("就是一个文本-Simon");
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(5L);
        SwingUtilities.invokeLater(() -> label.setText("来了来了"));

    }
}
