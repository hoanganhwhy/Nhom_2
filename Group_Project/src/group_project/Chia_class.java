package group_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Division {
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class Chia_class extends JFrame {

    private JTextField num1Field, num2Field, resultField;
    private JButton divButton;

    public Chia_class() {
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

        divButton = new JButton("/");
        divButton.setBounds(20, 90, 50, 30);
        add(divButton);

        resultField = new JTextField();
        resultField.setBounds(100, 140, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate('/');
            }
        });
    }

    private void calculate(char operator) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = Division.divide(num1, num2);
            
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        } catch (ArithmeticException ex) {
            resultField.setText(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Chia_class frame = new Chia_class();
            frame.setVisible(true);
        });
    }
}