package controller;

import model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Renard on controller.
 */
public class ProgressoController {

    public Progresso progresso;

    //Singleton
    private static ProgressoController instance = null;
    public static ProgressoController getInstance() {
        if (instance == null) instance = new ProgressoController();
        return instance;
    }

    private ProgressoController(){

    }

    public void novoProgresso(String nomeJogador){
        try {
            Files.deleteIfExists(Paths.get(nomeJogador + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        carregaProgresso(nomeJogador);
    }
    public void carregaProgresso(String nomeJogador){
        progresso = new Progresso(nomeJogador);
    }
    public Progresso getProgresso(){
        return this.progresso;
    }


}
