package sprin2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PalindromeChecker {
    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return original == reversed;
    }
}

public class KT extends JFrame {

    private JTextField numField, resultField;
    private JButton checkPalindromeButton;

    public KT() {
        setTitle("Palindrome Checker");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel numLabel = new JLabel("Enter Number:");
        numLabel.setBounds(20, 20, 100, 25);
        add(numLabel);

        numField = new JTextField();
        numField.setBounds(130, 20, 150, 25);
        add(numField);

        checkPalindromeButton = new JButton("Check");
        checkPalindromeButton.setBounds(20, 90, 100, 30);
        add(checkPalindromeButton);

        resultField = new JTextField();
        resultField.setBounds(130, 140, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        checkPalindromeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkPalindrome();
            }
        });
    }

    private void checkPalindrome() {
        try {
            int num = Integer.parseInt(numField.getText());
            boolean isPalindrome = PalindromeChecker.isPalindrome(num);
            resultField.setText(isPalindrome ? "Palindrome" : "Not Palindrome");
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KT frame = new KT();
            frame.setVisible(true);
        });
    }
}