package view;

import controller.*;

import javax.swing.JFrame;

public class Main{

    public static void main(String args[]) {

        /*MainView mv = new MainView();
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //mv.setSize(1024,768);
        mv.setVisible(true);*/

        LauncherView lv = LauncherView.getInstance();
        lv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lv.setSize(578,768);
        lv.setVisible(true);



    }
    /*public static void main(String args[]){
        GameController gc = GameController.getInstance();

        gc.inicializaCaso();

        System.out.println(getSeparador());
        gc.showDebrief();
        System.out.println(getSeparador());

        gc.percorreCenas();

    }
    public static String getSeparador(){
        char c[] = new char[100];  Arrays.fill(c,'-');
        return new String(c);
    }*/
}