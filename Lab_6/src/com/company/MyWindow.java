package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyWindow extends JFrame {

    private int number;
    private int count = 3;
    private JLabel startText;
    private JTextField digit;
    private JButton enter;

    public class ButtonEnter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            count--;
            if (number != Integer.parseInt(digit.getText())) {
                startText.setText("Компьютер загадал число от 1 до 10! " +
                        "У вас есть " + count + " попытки отгадать!");
                if(count == 0) {
                    JOptionPane.showMessageDialog(null, "Попытки кончились, Вы проиграли!");
                    dispose();
                } else {
                    if (number > Integer.parseInt(digit.getText())) {
                        JOptionPane.showMessageDialog(null, "Загаданное число больше " + Integer.parseInt(digit.getText()) + "!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Загаданное число меньше " + Integer.parseInt(digit.getText()) + "!");
                    }
                }
            } else {
                startText.setText("Компьютер загадал число от 1 до 10! " +
                        "У вас есть " + count + " попытки отгадать!");
                JOptionPane.showMessageDialog(null, "Вы Выиграли!");
                dispose();
            }
            digit.setText("");
        }
    }


    MyWindow(String name) {
        super(name);
        this.setBounds(500, 200, 700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setBackground(new Color(100,100,220));
        container.setLayout(null);
        startText = new JLabel("Компьютер загадал число от 1 до 10! " +
                "У вас есть " + count + " попытки отгадать!");
        startText.setForeground(Color.BLACK);
        startText.setFont(new Font("TimesRoman", Font.BOLD, 14));
        digit = new JTextField(6);
        enter = new JButton("Проверить!");
        enter.addActionListener(new ButtonEnter());

        startText.setBounds(100,200, 500, 20);
        digit.setBounds(300,230, 80, 30);
        enter.setBounds(280, 270, 120, 30);
        container.add(startText);
        container.add(digit);
        container.add(enter);

        Random random = new Random();
        number = random.nextInt(10) + 1;
    }
}
