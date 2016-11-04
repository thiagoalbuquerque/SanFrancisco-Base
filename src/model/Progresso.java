package model;

import java.io.File;
import java.util.*;

public class Progresso{
    public Arquivo arquivo;
    public Jogador jogador;
    public String nomeCasoAtual;
    public int cenaAtual = 0; //index da cenaAtual do jogador no arrayList de cenas de Caso
    public String evidenciasDesbloqueadas = ""; //appended one by one to this String as they get unlocked

    public Progresso(String nomeJogador){
        this.jogador = new Jogador(nomeJogador);
        this.arquivo = new Arquivo(nomeJogador + ".txt");
        File f = new File(nomeJogador+".txt");
        if(!f.exists()) {
            nomeCasoAtual = "roubo-no-navio";
            new Caso(nomeCasoAtual);
            this.save();
        }
        this.loadFromProgressoSalvo();
    }

    public String getProgresso(){
        return jogador.nome+"#"+nomeCasoAtual+"#"+cenaAtual+"#"+evidenciasDesbloqueadas;
    }

    public Progresso getProgressoSalvo(){
        String plaintext = arquivo.readFromFile();
        //System.out.println("{" + plaintext + "}");
        String temp[] = plaintext.split("#");
        Progresso prog = new Progresso(temp[0].trim());
        prog.nomeCasoAtual = temp[1].trim();
        prog.cenaAtual = Integer.parseInt(temp[2].trim());
        prog.evidenciasDesbloqueadas = temp[3].trim();
        return prog;
    }
    public void loadFromProgressoSalvo(){
        String plaintext = arquivo.readFromFile();
        //System.out.println("{" + plaintext + "}");
        String temp[] = plaintext.split("#");
        jogador = new Jogador(temp[0].trim());
        nomeCasoAtual = temp[1].trim();
        cenaAtual = Integer.parseInt(temp[2].trim());
        evidenciasDesbloqueadas = temp[3].trim();
        //System.out.printf(temp[2]);
    }
    public void updateCenaAtual(int index){
        cenaAtual = index;
        this.save();
    }

    public void adicionaEvidenciaDesbloqueada(int index){
        if(!isEvidenciaUnlocked(index)) {
            if (this.evidenciasDesbloqueadas.equals("")) {
                this.evidenciasDesbloqueadas += index;
            } else {
                evidenciasDesbloqueadas += ",";
                evidenciasDesbloqueadas += index;
            }
            this.save();
        }
    }

    public boolean isEvidenciaUnlocked(Integer num){
        if(evidenciasDesbloqueadas.equals("")) return false;
        Set<Integer> set = new TreeSet<Integer>();
        String temp[] = evidenciasDesbloqueadas.split(",");
        for(String evidencia : temp){
            set.add(Integer.parseInt(evidencia));
        }
        if(set.contains(num)){return true;}else{return false;}
    }
    /*public Integer getProximaEvidenciaDesbloqueada(){

    }
    public Integer getEvidenciaDesbloqueadaAnterior(){
        return 0;
    }*/

    public void save(){
        arquivo.writeToFile(this.getProgresso());
    }


}
