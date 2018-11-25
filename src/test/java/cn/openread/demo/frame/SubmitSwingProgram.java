package cn.openread.demo.frame;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * 利用SwingUtilities.invokeLater，分其它线程处理
 */
public class SubmitSwingProgram extends JFrame {
    private static SubmitSwingProgram ssp;
    private JLabel label;

    public SubmitSwingProgram() throws HeadlessException {
        super("窗体应用程序");
        label = new JLabel("就是一个文本-Simon");
        label.setBackground(new Color(116, 156, 168));
        super.add(label);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 300);
        super.setVisible(true);
    }

    public static void main(String args[]) throws InterruptedException {
        SwingUtilities.invokeLater(() -> ssp = new SubmitSwingProgram());

        TimeUnit.SECONDS.sleep(5L);

        SwingUtilities.invokeLater(() -> ssp.label.setText("来了来了"));

    }
}
