package model;

import java.util.*;

/**
 * Created by luis_ on 27/10/2015.
 */
public class Caso
{
    public String nome;
    public Arquivo arquivo;
    public String descricao;
    public Suspeito[ ] suspeitos;
    public Map<Integer, Evidencia> evidencias = new HashMap<Integer,Evidencia>();
    public List<Cena> intros = new ArrayList<Cena>();
    public List<Cena> cenas = new ArrayList<Cena>();
    public Suspeito culpado;

    //toDo: Ler e escrever json e usar uma biblioteca para tal. Perd�o pela bagun�a do formato atual e do custom-made parser.
    public Caso(String nomeCaso){
        this.nome = nomeCaso;
        arquivo = new Arquivo(nomeCaso+".txt");
        String plainText = arquivo.readFromFile(); //plaintext cheio de separadores
        String temp[] = plainText.split("###");
       // System.out.println("Debuger;");
        parseIntro(temp[0]);
        //System.out.println("Debuger;");
        parseCenas(temp[1]);
        //System.out.println("Debuger;");

    }

    public void parseIntro(String plaintext){
        Cena cena;
        String temp[] = plaintext.split("@");
        for(int i=0;i<temp.length-1;i+=2){
            cena = new Cena(temp[i].trim(),temp[i+1].trim());
            cenas.add(cena);
            //System.out.println(cena);
        }
    }

    public void parseCenas(String plaintext){
        Cena cena;
        Integer indexCena = 0;
        String temp[] = plaintext.split("@");
        for(int i=1;i<temp.length-1;i+=5){
            cena = new Cena(temp[i].trim(),temp[i+1].trim(),temp[i+2].trim(),temp[i+3].trim(), temp[i+4].trim());
            cenas.add(cena);
            if(cena.evidencia != null){
                evidencias.put(indexCena,cena.evidencia);
            }else if(cena.depoimento != null){
                evidencias.put(indexCena,cena.depoimento);
            }
            indexCena++;
            //System.out.println(cena);
        }
        //System.exit(0);
    }

    public void resolveCaso(Suspeito suspeito)
    {
        if(suspeito == culpado)
        {
            //Ganha o jogo
        }
        else
        {
            //Perde o jogo
        }
    }
}