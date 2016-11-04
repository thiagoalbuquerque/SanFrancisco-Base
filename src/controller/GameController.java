package controller;
import model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Renard on 27/10/2015.
 */
public class GameController {

    private static GameController instance;
    private Caso caso; //Um caso � composto por um conjunto de cenas e suspeitos
    public Map<Cena,Suspeito> hmap = new HashMap<Cena,Suspeito>();

    private GameController(){
    }

    public Caso getCaso(){
        return this.caso;
    }

    //Singleton
    public static GameController getInstance() {
        if (instance == null) instance = new GameController();
        return instance;
    }

    //Debrief � um resumo do caso e contexto em que o nosso investigador estar� situado
    /*public void showDebrief(){
        String debrief = "Seu amigo, o milion�rio e ca�ador de antiguidades J.Peterman adquiriu recentemente em um leil�o na Inglaterra um item bastante peculiar.\nUm peda�o de bolo do casamento real de Edward VIII e Wallis Simpson em 1937. O pre�o pago no leil�o: $ 29.000,00. \nNo �ltimo domingo � noite, o item em quest�o foi roubado de dentro do cofre do simp�tico magnata. Recuperar o bolo � importante\n mas a prioridade de Peterman � descobrir quem o traiu, e confia a voc� essa miss�o. Antes de sua chegada, ele passou aos poss�veis\n suspeitos (funcion�rios e famili�rios) a seguinte instru��o: quem mentir para o investigador ser� considerado o ladr�o e nunca mais voltar� a mans�o.\n" +
                "Sabendo que o roubo aconteceu em um intervalo curto, aproximadamente 17h e 18h, enquanto JP tirava um cochilo e que as c�meras de seguran�a\n n�o flagraram nenhum estranho � sua propriedade nos �ltimos dias, sua miss�o � investigar a casa e os suspeitos para entregar \n aquele que estiver faltando a verdade";
        System.out.println(debrief);
    }

    public void inicializaCaso(){
        Suspeito suspeitos[] = {
                new Suspeito(new Ficha("Madruga",48,"ex-lutador de boxe; aposentado;","Madruga prefere acordar tarde. Apesar de ser uma pessoa culta e ter uma l�bia impressionante parece n�o conseguir escapar das pancadas que a vida lhe d�. \nN�o consegue trabalho e vive de favor com seu primo JP"), "Uma vergonha! Aposto que foi aquele morto de fome do chaves. Estava consertando o ar-condicionado da cozinha."),
                new Suspeito(new Ficha("Elaine",30,"redatora","Elaine � namorada de J.P."),"O que est� de errado com as pessoas, hoje em dia? \n Eu estava alisando o cabelo no banheiro de visitas quando tudo aconteceu"),
                new Suspeito(new Ficha("Furtado",35,"jardineiro","Come�ou a trabalhar recentemente como jardineiro na residencia de J.P. Possui um bom relacionamento com o patr�o."),"Aposto que tenha sido aquele encostado do Madruga. \nEstava assistindo o jogo do Botafogo na hora em que o tal bolo foi roubado."),
                new Suspeito(new Ficha("Florinda",35,"cozinheira","Funcion�ria mais antiga na casa de J.P. Est� endividada desde a �ltima viagem que fez a Acapulco, no come�o do ano."),"N�o fa�o ideia de quem tenha sido o respons�vel. \nEstava cozinhando.")
        };
        Cena cenas[] = {
                new Cena("varanda",null),
                new Cena("quarto principal",new Pista("�leo nas teclas do cofre", "Utilizando uma lanterna, voc� percebe que algu�m passou uma fina camada de �leo, impercept�vel ao olhar desatento \nnas teclas do painel do cofre. Provavelmente atrav�s de algum tipo de um spray")),
                new Cena("quarto de h�spedes", null),
                new Cena("cozinha",null),
                new Cena("banheiro de visitas", new Pista("Spray fixador para cabelos","pode ter sido utilizado para marcar as teclas digitadas no teclado do cofre")),
                new Cena("sala de estar", null),
                new Cena("�rea externa", new Pista("carteira", "carteira do jardineiro Furtado. Nela voc� v� a carteirinha de s�cio torcedor do Botafogo"))
        };
        this.caso = new Caso(cenas,suspeitos,suspeitos[2]);
        hmap.put(cenas[3],suspeitos[3]); //Florinda na cozinha
        hmap.put(cenas[5],suspeitos[1]); //Elaine na sala de estar
        hmap.put(cenas[6],suspeitos[2]); //Furtado na �rea externa
        hmap.put(cenas[2],suspeitos[0]); //Madruga no quarto de h�spedes
    }

    public void percorreCenas(){
        Cena cenas[] = this.caso.cenas;
        Suspeito suspeitos[] = this.caso.suspeitos;
        for(Cena cena : cenas){
            System.out.println("Cena: "+cena.descricao);
            if(hmap.get(cena)!=null){
                investigaSuspeito(hmap.get(cena));
            };
            System.out.println("Investigando cena...");
            System.out.println(cena.investigaCena());
            Scanner sc = new Scanner(System.in);
            String digitada = sc.nextLine();
            switch(digitada){
                case "quit":
                    System.exit(0);
                    break;
                case "responder":
                    responder(digitada);
                    break;
            }
        }
        responder("");
    }
    public void investigaSuspeito(Suspeito suspeito){
        System.out.println("Voc� acaba de encontrar "+suspeito.ficha.nome+".");
        System.out.println(suspeito.ficha);
        System.out.println("Depoimento: "+suspeito.getDepoimento());
    }

    public void responder(String resposta){
        while(resposta.length()<4){ Scanner sc = new Scanner(System.in); resposta = sc.nextLine();};
        if(resposta.equals(this.caso.culpado.ficha.nome)) {
            System.out.println("PARABENS!!! VOCE ACERTOU!!!");
        }else System.out.println("ERROU!!! =(");
    }*/
}
