package sprin2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LinearEquationSolver {
    public static String solveEquation(double a, double b) {
        if (a == 0) {
            return (b == 0) ? "Infinite solutions" : "No solution";
        }
        return "x = " + (-b / a);
    }
}

public class PTBN extends JFrame {

    private JTextField aField, bField, resultField;
    private JButton solveButton;

    public PTBN() {
        setTitle("Linear Equation Solver");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel aLabel = new JLabel("Coefficient a:");
        aLabel.setBounds(20, 20, 100, 25);
        add(aLabel);

        aField = new JTextField();
        aField.setBounds(130, 20, 150, 25);
        add(aField);

        JLabel bLabel = new JLabel("Coefficient b:");
        bLabel.setBounds(20, 50, 100, 25);
        add(bLabel);

        bField = new JTextField();
        bField.setBounds(130, 50, 150, 25);
        add(bField);

        solveButton = new JButton("Solve");
        solveButton.setBounds(20, 90, 80, 30);
        add(solveButton);

        resultField = new JTextField();
        resultField.setBounds(130, 140, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveEquation();
            }
        });
    }

    private void solveEquation() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            String result = LinearEquationSolver.solveEquation(a, b);
            resultField.setText(result);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PTBN frame = new PTBN();
            frame.setVisible(true);
        });
    }
}
