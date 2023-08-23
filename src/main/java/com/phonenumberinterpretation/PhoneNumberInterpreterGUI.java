package com.phonenumberinterpretation;

import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhoneNumberInterpreterGUI {
    private JFrame frame;
    private JTextArea inputArea;
    private JButton interpretButton;
    private JTextArea resultArea;

    public PhoneNumberInterpreterGUI() {
        frame = new JFrame("Phone Number Interpreter");

        inputArea = new JTextArea(5, 40);
        inputArea.setWrapStyleWord(true);
        inputArea.setLineWrap(true);
        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        
        interpretButton = new JButton("Interpret");
        interpretButton.addActionListener(new InterpretButtonListener());

        resultArea = new JTextArea(10, 40);
        resultArea.setWrapStyleWord(true);
        resultArea.setLineWrap(true);
        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);

        JPanel panel = new JPanel();
        panel.add(inputScrollPane);
        panel.add(interpretButton);
        panel.add(resultScrollPane);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    class InterpretButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = inputArea.getText().trim();
            try {
                String interpretedNumber = PhoneNumberInterpreter.interpretNumberSequence(input);
                List<String> interpretations = PhoneNumberInterpreter.generatePossibleInterpretations(interpretedNumber.split("(?<=\\G.{3})"), 0);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < interpretations.size(); i++) {
                    sb.append("Interpretation " + (i + 1) + ": " + interpretations.get(i) + " " + PhoneNumberInterpreter.validatePhoneNumber(interpretations.get(i))).append("\n");
                }
                resultArea.setText(sb.toString());
            } catch (IllegalArgumentException ex) {
                resultArea.setText(ex.getMessage() + "\nInvalid input. Please ensure you're entering numbers separated by spaces.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhoneNumberInterpreterGUI());
    }
}
