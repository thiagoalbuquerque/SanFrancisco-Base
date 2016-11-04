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
    private Caso caso; //Um caso é composto por um conjunto de cenas e suspeitos
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

    //Debrief é um resumo do caso e contexto em que o nosso investigador estará situado
    /*public void showDebrief(){
        String debrief = "Seu amigo, o milionário e caçador de antiguidades J.Peterman adquiriu recentemente em um leilão na Inglaterra um item bastante peculiar.\nUm pedaço de bolo do casamento real de Edward VIII e Wallis Simpson em 1937. O preço pago no leilão: $ 29.000,00. \nNo último domingo à noite, o item em questão foi roubado de dentro do cofre do simpático magnata. Recuperar o bolo é importante\n mas a prioridade de Peterman é descobrir quem o traiu, e confia a você essa missão. Antes de sua chegada, ele passou aos possíveis\n suspeitos (funcionários e familiários) a seguinte instrução: quem mentir para o investigador será considerado o ladrão e nunca mais voltará a mansão.\n" +
                "Sabendo que o roubo aconteceu em um intervalo curto, aproximadamente 17h e 18h, enquanto JP tirava um cochilo e que as câmeras de segurança\n não flagraram nenhum estranho à sua propriedade nos últimos dias, sua missão é investigar a casa e os suspeitos para entregar \n aquele que estiver faltando a verdade";
        System.out.println(debrief);
    }

    public void inicializaCaso(){
        Suspeito suspeitos[] = {
                new Suspeito(new Ficha("Madruga",48,"ex-lutador de boxe; aposentado;","Madruga prefere acordar tarde. Apesar de ser uma pessoa culta e ter uma lábia impressionante parece não conseguir escapar das pancadas que a vida lhe dá. \nNão consegue trabalho e vive de favor com seu primo JP"), "Uma vergonha! Aposto que foi aquele morto de fome do chaves. Estava consertando o ar-condicionado da cozinha."),
                new Suspeito(new Ficha("Elaine",30,"redatora","Elaine é namorada de J.P."),"O que está de errado com as pessoas, hoje em dia? \n Eu estava alisando o cabelo no banheiro de visitas quando tudo aconteceu"),
                new Suspeito(new Ficha("Furtado",35,"jardineiro","Começou a trabalhar recentemente como jardineiro na residencia de J.P. Possui um bom relacionamento com o patrão."),"Aposto que tenha sido aquele encostado do Madruga. \nEstava assistindo o jogo do Botafogo na hora em que o tal bolo foi roubado."),
                new Suspeito(new Ficha("Florinda",35,"cozinheira","Funcionária mais antiga na casa de J.P. Está endividada desde a última viagem que fez a Acapulco, no começo do ano."),"Não faço ideia de quem tenha sido o responsável. \nEstava cozinhando.")
        };
        Cena cenas[] = {
                new Cena("varanda",null),
                new Cena("quarto principal",new Pista("óleo nas teclas do cofre", "Utilizando uma lanterna, você percebe que alguém passou uma fina camada de óleo, imperceptível ao olhar desatento \nnas teclas do painel do cofre. Provavelmente através de algum tipo de um spray")),
                new Cena("quarto de hóspedes", null),
                new Cena("cozinha",null),
                new Cena("banheiro de visitas", new Pista("Spray fixador para cabelos","pode ter sido utilizado para marcar as teclas digitadas no teclado do cofre")),
                new Cena("sala de estar", null),
                new Cena("área externa", new Pista("carteira", "carteira do jardineiro Furtado. Nela você vê a carteirinha de sócio torcedor do Botafogo"))
        };
        this.caso = new Caso(cenas,suspeitos,suspeitos[2]);
        hmap.put(cenas[3],suspeitos[3]); //Florinda na cozinha
        hmap.put(cenas[5],suspeitos[1]); //Elaine na sala de estar
        hmap.put(cenas[6],suspeitos[2]); //Furtado na área externa
        hmap.put(cenas[2],suspeitos[0]); //Madruga no quarto de hóspedes
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
        System.out.println("Você acaba de encontrar "+suspeito.ficha.nome+".");
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
