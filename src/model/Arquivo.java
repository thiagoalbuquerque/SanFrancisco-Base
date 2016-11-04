package model;

import java.util.*;
import java.io.*;
import java.lang.*;

/**
 * Created by Renard on model.
 */
public class Arquivo {
    public Formatter formatter = null;
    public Scanner sc = null;
    public String nome = "default.txt";
    public String plaintext = "";

    public Arquivo(String nome){
        this.nome = nome;
    }

    public String readFromFile(){
        try {
            sc = new Scanner(new File(nome));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        while(sc.hasNext()){
            this.plaintext += sc.next() + " ";
        }
        sc.close();
        return plaintext;
    }
    public void writeToFile(String outputString){
        try {
            formatter = new Formatter(nome);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        formatter.format("%s", outputString);
        formatter.flush();
        formatter.close();
    }
    public String toString(){
        return plaintext;
    }

}
