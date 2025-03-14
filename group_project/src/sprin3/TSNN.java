package sprin3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class ArrayProcessor {
    public static int findMin(int[] numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}

public class TSNN extends JFrame {

    private JTextField numField, resultField;
    private JButton findMinButton;

    public TSNN() {
        setTitle("Find Min in Array");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel numLabel = new JLabel("Enter numbers (comma-separated):");
        numLabel.setBounds(20, 20, 200, 25);
        add(numLabel);

        numField = new JTextField();
        numField.setBounds(230, 20, 150, 25);
        add(numField);

        findMinButton = new JButton("Find Min");
        findMinButton.setBounds(20, 90, 100, 30);
        add(findMinButton);

        resultField = new JTextField();
        resultField.setBounds(230, 140, 150, 25);
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
            String[] input = numField.getText().split(",");
            int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int min = ArrayProcessor.findMin(numbers);
            resultField.setText("Min: " + min);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TSNN frame = new TSNN();
            frame.setVisible(true);
        });
    }
}