package group_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Subtraction {
    public static double subtract(double a, double b) {
        return a - b;
    }
}

public class Truclass extends JFrame {

    private JTextField num1Field, num2Field, resultField;
    private JButton subButton;

    public Truclass() {
        setTitle("Calculator");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel num1Label = new JLabel("Number 1:");
        num1Label.setBounds(20, 20, 80, 25);
        add(num1Label);

        num1Field = new JTextField();
        num1Field.setBounds(100, 20, 150, 25);
        add(num1Field);

        JLabel num2Label = new JLabel("Number 2:");
        num2Label.setBounds(20, 50, 80, 25);
        add(num2Label);

        num2Field = new JTextField();
        num2Field.setBounds(100, 50, 150, 25);
        add(num2Field);

        subButton = new JButton("-");
        subButton.setBounds(20, 90, 50, 30);
        add(subButton);

        resultField = new JTextField();
        resultField.setBounds(100, 140, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('-');
            }
        });
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = Subtraction.subtract(num1, num2);
            
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Truclass frame = new Truclass();
            frame.setVisible(true);
        });
    }
}
