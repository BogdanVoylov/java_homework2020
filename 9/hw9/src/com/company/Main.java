package com.company;
/*Написати програму "Математична гра", що виводить приклади на додавання і віднімання з 2,3-х дій і просить у користувача відповідь. В якості обмеження користувач вказує максимальне число до якого він вже знає числа. Наприклад, користувач ввів 6 і кількість прикладів - 4, йому виводяться приклади: 2+2=, 4+2=, 3+3=, 6-2=. Це гра з графічним інтерфейсом.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main extends JFrame{
    int maxNum = 0;
    int times = 0;
    String attempt = "";
    String required = "";
    JLabel task;
    JLabel jLabel;
    JTextField jTextField;
    JButton jButton;
    public Main(){
        super();
        this.setTitle("Program");
        this.setSize(500,500);
        this.getContentPane().setLayout(new GridLayout(4,1));
        init();
    }

    private void init(){
        maxNum = Integer.valueOf(JOptionPane.showInputDialog("Enter max num(>0)"));
        while (maxNum<=0){
            maxNum = Integer.valueOf(JOptionPane.showInputDialog("Enter max num(>0)"));
        }
        times =  Integer.valueOf(JOptionPane.showInputDialog("Enter num of times(>0)"));
        while (times<=0){
            times =  Integer.valueOf(JOptionPane.showInputDialog("Enter num of times(>0)"));
        }
        task = new JLabel("Написати програму \"Математична гра\", що виводить приклади на додавання і віднімання з 2,3-х дій і просить у користувача відповідь.\n В якості обмеження користувач вказує максимальне число до якого він вже знає числа.");
        jLabel = new JLabel("");
        jTextField = new JTextField();
        jButton = new JButton("Ok");
        this.add(jLabel);
        this.add(jTextField);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                attempt = jTextField.getText();
                if(attempt.equals(required)){
                    JOptionPane.showMessageDialog(null,"Correct","Result",JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null,"Wrong","Result",JOptionPane.INFORMATION_MESSAGE);
                }
                if(times>0){
                    run();
                }else{
                    System.exit(0);
                }
            }
        };
        jButton.addActionListener(actionListener);
        this.add(jButton);
    }

    public void run(){
        times--;
        jTextField.setText("");
        Random random = new Random();
        int numOfSteps = 0;
        int res = 0;
        int currentRandomized = 0;
        String text = "";
        do{
            numOfSteps = random.nextInt(3);
        }while (numOfSteps==0);
        res = random.nextInt(maxNum);
        if(res==0){
            res+=1;
        }
        text += res;
        for(int j = 0; j < numOfSteps;j++){
            if(random.nextBoolean()){//if true then sign is plus
                currentRandomized=random.nextInt(maxNum-res);
                text+="+"+currentRandomized;
                res+=currentRandomized;
            }else{//sign is minus
                currentRandomized=random.nextInt(res);
                text+="-"+currentRandomized;
                res-=currentRandomized;
            }

        }
        text+="=";
        required=res+"";
        jLabel.setText(text);

    }
    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
        main.run();
    }
}
