package group_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MinNumberFinder {
    public static double findMin(double a, double b) {
        return Math.min(a, b);
    }
}

public class SNN extends JFrame {

    private JTextField num1Field, num2Field, resultField;
    private JButton findMinButton;

    public SNN() {
        setTitle("Find Minimum Number");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("Number 1:");
        num1Label.setBounds(20, 20, 100, 25);
        add(num1Label);

        num1Field = new JTextField();
        num1Field.setBounds(130, 20, 150, 25);
        add(num1Field);

        JLabel num2Label = new JLabel("Number 2:");
        num2Label.setBounds(20, 50, 100, 25);
        add(num2Label);

        num2Field = new JTextField();
        num2Field.setBounds(130, 50, 150, 25);
        add(num2Field);

        findMinButton = new JButton("Find Min");
        findMinButton.setBounds(20, 90, 100, 30);
        add(findMinButton);

        resultField = new JTextField();
        resultField.setBounds(130, 140, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        findMinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findMin();
            }
        });
    }

    private void findMin() {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = MinNumberFinder.findMin(num1, num2);
            resultField.setText("Min: " + result);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SNN frame = new SNN();
            frame.setVisible(true);
        });
    }
}