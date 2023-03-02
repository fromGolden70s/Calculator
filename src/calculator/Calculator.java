package calculator;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Calculator extends JFrame {

    static ArrayList<Integer> arr = new ArrayList<>();

    private static String fieldText = "";
    public static String getFieldText() {
        return fieldText;
    }
    public static void addToFieldText(String addText) {
        fieldText += addText;
    }


    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 400);
        setLayout(null);

        elements();
        setVisible(true);
    }

    private void elements() {


        int buttonHeight = 30;
        int buttonWidth = 50;
        int yFirstRow = 100;
        int ySecondRow = 150;
        int yThirdRow = 200;
        int yFourthRow = 250;
        int yFifthRow = 300;
        int xFirstCol = 20;
        int xSecondCol = 90;
        int xThirdCol = 160;
        int xFourthCol = 230;

        JLabel input = new JLabel();
        input.setName("EquationLabel");
        input.setBounds(20, 20, 250, 20);
        Font font = new Font("Courier", Font.BOLD,12);
        input.setFont(font);
        add(input);

        JLabel resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        resultLabel.setBounds(20, 50, 250, 40);
        Font fontRes = new Font("Courier", Font.BOLD,22);
        resultLabel.setFont(fontRes);
        add(resultLabel);



        JButton delete = new JButton("<");
        delete.setName("Delete");
        delete.setBounds(xFourthCol, yFirstRow, buttonWidth, buttonHeight);
        add(delete);
        delete.addActionListener( e -> {
            if(fieldText.length() > 0) {
                fieldText = fieldText.substring(0, fieldText.length() - 1);
            }
            input.setText(fieldText);
        });

        JButton clear = new JButton("C");
        clear.setName("Clear");
        clear.setBounds(xThirdCol, yFirstRow, buttonWidth, buttonHeight);
        add(clear);
        clear.addActionListener( e -> {
            fieldText = "";
            input.setText(fieldText);
        });

        JButton seven = new JButton("7");
        seven.setName("Seven");
        seven.setBounds(xFirstCol, ySecondRow, buttonWidth, buttonHeight);
        add(seven);
        seven.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("7");
            input.setText(fieldText);
        });

        JButton eight = new JButton("8");
        eight.setName("Eight");
        eight.setBounds(xSecondCol, ySecondRow, buttonWidth, buttonHeight);
        add(eight);
        eight.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("8");
            input.setText(fieldText);
        });

        JButton nine = new JButton("9");
        nine.setName("Nine");
        nine.setBounds(xThirdCol, ySecondRow, buttonWidth, buttonHeight);
        add(nine);
        nine.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("9");
            input.setText(fieldText);
        });

        JButton divide = new JButton("/");
        divide.setName("Divide");
        divide.setBounds(xFourthCol, ySecondRow, buttonWidth, buttonHeight);
        add(divide);
        divide.addActionListener( e -> {
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            if (fieldText.length() > 0) {
                if (fieldText.charAt(fieldText.length() - 1) == '\u00F7' || fieldText.charAt(fieldText.length() - 1) == '\u00D7'
                        || fieldText.charAt(fieldText.length() - 1) == '\u2212' || fieldText.charAt(fieldText.length() - 1) == '\u002B') {
                    fieldText = fieldText.substring(0, fieldText.length() - 1);
                }
            addToFieldText("\u00F7");
            input.setText(fieldText);
            }
        });


        JButton four = new JButton("4");
        four.setName("Four");
        four.setBounds(xFirstCol, yThirdRow, buttonWidth, buttonHeight);
        add(four);
        four.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("4");
            input.setText(fieldText);
        });

        JButton five = new JButton("5");
        five.setName("Five");
        five.setBounds(xSecondCol, yThirdRow, buttonWidth, buttonHeight);
        add(five);
        five.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("5");
            input.setText(fieldText);
        });

        JButton six = new JButton("6");
        six.setName("Six");
        six.setBounds(xThirdCol, yThirdRow, buttonWidth, buttonHeight);
        add(six);
        six.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("6");
            input.setText(fieldText);
        });

        JButton multiply = new JButton("x");
        multiply.setName("Multiply");
        multiply.setBounds(xFourthCol, yThirdRow, buttonWidth, buttonHeight);
        add(multiply);
        multiply.addActionListener( e -> {
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            if (fieldText.length() > 0) {
                if (fieldText.charAt(fieldText.length() - 1) == '\u00F7' || fieldText.charAt(fieldText.length() - 1) == '\u00D7'
                        || fieldText.charAt(fieldText.length() - 1) == '\u2212' || fieldText.charAt(fieldText.length() - 1) == '\u002B') {
                    fieldText = fieldText.substring(0, fieldText.length() - 1);
                }
                addToFieldText("\u00D7");
                input.setText(fieldText);
            }
        });

        JButton one = new JButton("1");
        one.setName("One");
        one.setBounds(xFirstCol, yFourthRow, buttonWidth, buttonHeight);
        add(one);
        one.addActionListener( e -> {
            if(input.getText().length() == 0) {
                resultLabel.setText("");
                fieldText = "";
            }
            addToFieldText("1");
            input.setText(fieldText);
        });

        JButton two = new JButton("2");
        two.setName("Two");
        two.setBounds(xSecondCol, yFourthRow, buttonWidth, buttonHeight);
        add(two);
        two.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("2");
            input.setText(fieldText);
        });

        JButton three = new JButton("3");
        three.setName("Three");
        three.setBounds(xThirdCol, yFourthRow, buttonWidth, buttonHeight);
        add(three);
        three.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("3");
            input.setText(fieldText);
        });

        JButton add = new JButton("+");
        add.setName("Add");
        add.setBounds(xFourthCol, yFourthRow, buttonWidth, buttonHeight);
        add(add);
        add.addActionListener( e -> {
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            if (fieldText.length() > 0) {
                if (fieldText.charAt(fieldText.length() - 1) == '\u00F7' || fieldText.charAt(fieldText.length() - 1) == '\u00D7'
                        || fieldText.charAt(fieldText.length() - 1) == '\u2212' || fieldText.charAt(fieldText.length() - 1) == '\u002B') {
                    fieldText = fieldText.substring(0, fieldText.length() - 1);
                }
                addToFieldText("\u002B");
                input.setText(fieldText);
            }
        });


        JButton zero = new JButton("0");
        zero.setName("Zero");
        zero.setBounds(xSecondCol, yFifthRow, buttonWidth, buttonHeight);
        add(zero);
        zero.addActionListener( e -> {
            resultLabel.setText("");
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText("0");
            input.setText(fieldText);
        });

        JButton dot = new JButton(".");
        dot.setName("Dot");
        dot.setBounds(xFirstCol, yFifthRow, buttonWidth, buttonHeight);
        add(dot);
        dot.addActionListener( e -> {
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            addToFieldText(".");
            input.setText(fieldText);
        });

        JButton subtract = new JButton("-");
        subtract.setName("Subtract");
        subtract.setBounds(xFourthCol, yFifthRow, buttonWidth, buttonHeight);
        add(subtract);
        subtract.addActionListener( e -> {
            if(input.getText().length() == 0) {
                fieldText = "";
            }
            if (fieldText.length() > 0) {
                if (fieldText.charAt(fieldText.length() - 1) == '\u00F7' || fieldText.charAt(fieldText.length() - 1) == '\u00D7'
                        || fieldText.charAt(fieldText.length() - 1) == '\u2212' || fieldText.charAt(fieldText.length() - 1) == '\u002B') {
                    fieldText = fieldText.substring(0, fieldText.length() - 1);
                }
                addToFieldText("-");
                input.setText(fieldText);
            }
        });


        JButton equals = new JButton("=");
        equals.setName("Equals");
        equals.setBounds(xThirdCol, yFifthRow, buttonWidth, buttonHeight);
        add(equals);
        equals.addActionListener( e -> {
            if (CheckErrors.check(fieldText)) {
                input.setForeground(Color.RED.darker());
                input.setText(fieldText);
            } else {
                input.setForeground(Color.BLACK);
                resultLabel.setText(DoCalc.shuntingYard());
                fieldText = "";
                arr.clear();
            }
        });
    }
}
