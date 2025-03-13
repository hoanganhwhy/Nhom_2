
package team_ngu;

import javax.swing.*;

public class Team_ngu extends JFrame {

    private JTextField num1Field, num2Field, resultField;

    public Team_ngu() {
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

        resultField = new JTextField();
        resultField.setBounds(100, 130, 150, 25);
        resultField.setEditable(false);
        add(resultField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Team_ngu().setVisible(true));
    }
}