package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*Створити форму для зчитування логіна і пароля, в разі вірно введених даних виводити секретну інформацію, в іншому випадку видавати помилку (і те, і те - в нових вікнах-повідомленнях).*/

public class Main extends  JFrame{

    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button;
    private static  final String LOGIN = "login";
    private static final String PASSWORD = "password";

    public Main(String name){
        super();
        this.setTitle(name);
        this.setSize(300,200);
        this.getContentPane().setLayout(new GridLayout(3,1));
        init();
        this.add(textField);
        this.add(passwordField);
        this.add(button);


    }

    private void init(){
        textField = new JTextField();
        passwordField = new JPasswordField();
        button = new JButton("OK");
        ActionListener actionListener = actionEvent -> {
            String text;
            if(new String(passwordField.getPassword()).equals(PASSWORD) && textField.getText().equals(LOGIN)){
                text="secret";
            }else{
                text="Wrong password and/or login";
            }
            JOptionPane.showMessageDialog(null,
                    text,
                    "MESSAGE",
                    JOptionPane.INFORMATION_MESSAGE);
        };
        button.addActionListener(actionListener);
    }

    public static void showSecret(){

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Main ui = new Main("Перша SWING програма");
        ui.setVisible(true);
    }
}
