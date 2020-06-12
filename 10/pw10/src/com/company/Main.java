package com.company;
/*Написати графічну програму, що використовуючи JFileChooser дозволяє обрати файл і виводить його зміст.*/
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main extends JFrame{

    Main(){
        super();
        this.setTitle("Program");
        this.setSize(500,500);
        init();
    }

    private void init() {
        JLabel jLabel = new JLabel();
        File file = getFile();
        String text = "<html>";
        if(file!=null){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String str;
                while ((str=bufferedReader.readLine())!=null){
                    text+=str+"<br>";
                }
            }catch (Exception exception){
                text = "Error";
            }
        }else{
            text = "No file chosen";
        }
        text+="</html>";
        jLabel.setText(text);
        jLabel.setSize(500,500);
        JScrollPane jScrollPane = new JScrollPane(jLabel);
        setPreferredSize(new Dimension(500,500));
        this.add(jScrollPane);
        jScrollPane.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }

    private File getFile(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("File Chooser");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION ){
            return fileChooser.getSelectedFile();
        }else {
            return null;
        }
    }


}
