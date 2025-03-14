package sprint3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Collectors;

class ArrayProcessor {
    public static String findOddNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                     .filter(n -> n % 2 != 0)
                     .mapToObj(String::valueOf)
                     .collect(Collectors.joining(", "));
    }
}

public class Nhap_Mang_TimSoLonNhat extends JFrame {

    private JTextField numField, resultField;
    private JButton findOddButton;

    public Nhap_Mang_TimSoLonNhat() {
        setTitle("Find Odd Numbers in Array");
        setSize(400, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel numLabel = new JLabel("Enter numbers (comma-separated):");
        numLabel.setBounds(20, 20, 200, 25);
        add(numLabel);

        numField = new JTextField();
        numField.setBounds(230, 20, 150, 25);
        add(numField);

        findOddButton = new JButton("Find Odd Numbers");
        findOddButton.setBounds(20, 90, 150, 30);
        add(findOddButton);

        resultField = new JTextField();
        resultField.setBounds(230, 140, 150, 25);
        resultField.setEditable(false);
        add(resultField);

        findOddButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findOddNumbers();
            }
        });
    }

    private void findOddNumbers() {
        try {
            String[] input = numField.getText().split(",");
            int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            String oddNumbers = ArrayProcessor.findOddNumbers(numbers);
            resultField.setText("Odds: " + oddNumbers);
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Nhap_Mang_TimSoLonNhat frame = new Nhap_Mang_TimSoLonNhat();
            frame.setVisible(true);
        });
    }
}