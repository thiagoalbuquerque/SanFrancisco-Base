package model;


import java.util.Scanner;

public class Partida {

    public Progresso progresso;
    private static Partida instance;

    //Singleton
    public static Partida getInstance() {
        if (instance == null) instance = new Partida();
        return instance;
    }

    private Partida(){

    }
}
