package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.charset.MalformedInputException;
import java.util.*;

/**
 * Created by Renard on controller.
 */
public class PartidaController {

    public Partida partida = Partida.getInstance();
    private static PartidaController instance = null;
    public java.util.Timer timer = new java.util.Timer();;
    public Integer evidenciaAtualExibida = 0;
    public Boolean flagAcusacao = false;


    private PartidaController(){
        //caso = CasoController.getInstance().getCasoAtual();
        //progresso = ProgressoController.getInstance().getProgresso();
    }

    //Singleton
    public static PartidaController getInstance() {
        if (instance == null) instance = new PartidaController();
        return instance;
    }

    public void novaPartida(String param){
        ProgressoController.getInstance().novoProgresso(param);
        carregaMainView();
    }
    public void continuaPartida(String param){
        ProgressoController.getInstance().carregaProgresso(param);
        carregaMainView();
        if(!ProgressoController.getInstance().progresso.evidenciasDesbloqueadas.equals("")) {
            MainView.getInstance().updateCardImg(CasoController.getInstance().caso.evidencias.get(0).imageFileName);
        }
    }
    public void carregaMainView(){
        Progresso progresso = ProgressoController.getInstance().progresso;
        MainView mv = MainView.getInstance();
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mv.setVisible(true);
        Caso caso = CasoController.getInstance().carregaCaso("roubo-no-navio");
        //Carrega Primeira Cena da Intro
        Cena cenaInicial = caso.cenas.get(progresso.cenaAtual);
        mv.textArea.setText(cenaInicial.descricao);
        mv.updateCenaImg(cenaInicial.imageFileName);
    }
    public void cenaAnterior(){
        Caso caso = CasoController.getInstance().getCasoAtual();
        Progresso progresso = ProgressoController.getInstance().progresso;
        progresso.updateCenaAtual(progresso.cenaAtual - 1);
        if(progresso.cenaAtual == -1){ //passou do index da primeira
            progresso.updateCenaAtual(caso.cenas.size()-1);
            Cena cenaAnterior = caso.cenas.get(progresso.cenaAtual);
            MainView.getInstance().updateCenaImg(cenaAnterior.imageFileName);
            MainView.getInstance().updateText(cenaAnterior.descricao);
        }else{
            Cena proximaCena = caso.cenas.get(progresso.cenaAtual);
            MainView.getInstance().updateCenaImg(proximaCena.imageFileName);
            MainView.getInstance().updateText(proximaCena.descricao);
        }
        this.flagAcusacao = false;
    }
    public void proximaCena(){
        Caso caso = CasoController.getInstance().getCasoAtual();
        Progresso progresso = ProgressoController.getInstance().progresso;
        progresso.updateCenaAtual(progresso.cenaAtual + 1);
        if(caso.cenas.size() == (progresso.cenaAtual)){ //passou do index da última
            progresso.cenaAtual = 0;
            Cena proximaCena = caso.cenas.get(progresso.cenaAtual);
            MainView.getInstance().updateCenaImg(proximaCena.imageFileName);
            MainView.getInstance().updateText(proximaCena.descricao);
        }else{
            Cena proximaCena = caso.cenas.get(progresso.cenaAtual);
            MainView.getInstance().updateCenaImg(proximaCena.imageFileName);
            MainView.getInstance().updateText(proximaCena.descricao);
        }
        this.flagAcusacao = false;
    }
    public void investigaCena(){
        Caso caso = CasoController.getInstance().getCasoAtual();
        Progresso progresso = ProgressoController.getInstance().progresso;
        if( caso.cenas.get(progresso.cenaAtual).evidencia == null ){
            MainView.getInstance().updateText("Nenhuma evidência encontrada.");
            timer.schedule(new TimerTask(){
                public void run(){
                    MainView.getInstance().updateText(caso.cenas.get(progresso.cenaAtual).descricao);
                }
            }, 1500);
        }else{
            this.evidenciaAtualExibida = progresso.cenaAtual;
            progresso.adicionaEvidenciaDesbloqueada(progresso.cenaAtual);
            MainView.getInstance().updateText(caso.cenas.get(progresso.cenaAtual).evidencia.imageFileName);
            MainView.getInstance().updateCardImg(caso.cenas.get(progresso.cenaAtual).evidencia.imageFileName);
        }
    }
    public void interrogaSuspeito(){
        Caso caso = CasoController.getInstance().getCasoAtual();
        Progresso progresso = ProgressoController.getInstance().progresso;
        if( caso.cenas.get(progresso.cenaAtual).depoimento == null ){
            MainView.getInstance().updateText("Nenhum suspeito encontrado nesta cena para prestar depoimento.");
            timer.schedule(new TimerTask() {
                public void run() {
                    MainView.getInstance().updateText(caso.cenas.get(progresso.cenaAtual).descricao);
                }
            }, 1500);
        }else{
            this.evidenciaAtualExibida = progresso.cenaAtual;
            progresso.adicionaEvidenciaDesbloqueada(progresso.cenaAtual);
            MainView.getInstance().updateText(caso.cenas.get(progresso.cenaAtual).depoimento.imageFileName);
            MainView.getInstance().updateCardImg(caso.cenas.get(progresso.cenaAtual).depoimento.imageFileName);
        }
    }
    public void proximaEvidencia(){
        if(ProgressoController.getInstance().progresso.evidenciasDesbloqueadas.equals("")) return; //Se não houver evidencia atual
        Caso caso = CasoController.getInstance().getCasoAtual();
        Progresso progresso = ProgressoController.getInstance().progresso;
        MainView mv = MainView.getInstance();
        Integer temp = evidenciaAtualExibida + 1;
        mv.consoleDebug(evidenciaAtualExibida + "");
       while(temp != evidenciaAtualExibida){
            if(temp>=caso.cenas.size() - 1) temp = 0;
            if(progresso.isEvidenciaUnlocked(temp)){
                if(caso.cenas.get(temp).evidencia!=null) {
                    mv.updateCardImg(caso.cenas.get(temp).evidencia.imageFileName);
                }else if(caso.cenas.get(temp).depoimento!=null){
                    mv.updateCardImg(caso.cenas.get(temp).depoimento.imageFileName);
                }
                this.evidenciaAtualExibida = temp;
                break;
            }
            temp++;
        }

    }
    public void evidenciaAnterior(){
        if(ProgressoController.getInstance().progresso.evidenciasDesbloqueadas.equals("")) return; //Se não houver evidencia atual
        Caso caso = CasoController.getInstance().getCasoAtual();
        Progresso progresso = ProgressoController.getInstance().progresso;
        MainView mv = MainView.getInstance();
        Integer temp = evidenciaAtualExibida - 1;
        mv.consoleDebug(evidenciaAtualExibida+"");
        while(temp != evidenciaAtualExibida){
            if(temp<0) temp = caso.cenas.size() - 1;
            if(progresso.isEvidenciaUnlocked(temp)){
                if(caso.cenas.get(temp).evidencia!=null) {
                    mv.updateCardImg(caso.cenas.get(temp).evidencia.imageFileName);
                }else if(caso.cenas.get(temp).depoimento!=null){
                    mv.updateCardImg(caso.cenas.get(temp).depoimento.imageFileName);
                }
                this.evidenciaAtualExibida = temp;
                break;
            }
            temp--;
        }
    }
    public void acusar(){
        if(this.flagAcusacao){
            //MainView.getInstance().consoleDebug(ProgressoController.getInstance().progresso.cenaAtual+"");
            if(ProgressoController.getInstance().progresso.cenaAtual == 12){
                MainView.getInstance().updateText("Parabéns, "+ ProgressoController.getInstance().progresso.jogador.nome + ", você desvendou o crime!");
            }else{
                MainView.getInstance().updateText("Game Over");
                ProgressoController.getInstance().novoProgresso(ProgressoController.getInstance().progresso.jogador.nome);
                MainView.getInstance().disableMouseEvents();
            }
        }else{
            flagAcusacao = true;
            MainView.getInstance().updateText("Deseja mesmo acusar a pessoa à sua frente?");
        }
    }
}
