package sprin3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class ArrayProcessor {
    public static int findMax(int[] numbers) {
        return Arrays.stream(numbers).max().orElse(Integer.MIN_VALUE);
    }
}

public class TSLN extends JFrame {

    private JTextField numField, resultField;
    private JButton findMaxButton;

    public TSLN() {
        setTitle("Find Max in Array");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel numLabel = new JLabel("Enter numbers (comma-separated):");
        numLabel.setBounds(20, 20, 200, 25);
        add(numLabel);

        numField = new JTextField();
        numField.setBounds(230, 20, 150, 25);
        add(numField);

        findMaxButton = new JButton("Find Max");
        findMaxButton.setBounds(20, 90, 100, 30);
        add(findMaxButton);

        resultField = new JTextField();
        resultField.setBounds(230, 140, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        findMaxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findMax();
            }
        });
    }

    private void findMax() {
        try {
            String[] input = numField.getText().split(",");
            int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int max = ArrayProcessor.findMax(numbers);
            resultField.setText("Max: " + max);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TSLN frame = new TSLN();
            frame.setVisible(true);
        });
    }
}
