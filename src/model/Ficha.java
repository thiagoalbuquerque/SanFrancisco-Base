package model;

/**
 * Created by Renard on 27/10/2015.
 */
public class Ficha
{
        public String nome;
        public int idade;
        public String profissao;
        public String descricao;

        public Ficha (String n, int i, String p, String d)
        {
            nome = n;
            idade = i;
            profissao = p;
            descricao = d;
        }

        public String toString(){

            return "Nome: "+nome+", idade: "+idade+" anos, profissão: "+profissao+", \n"+ "descrição: "+descricao;
        }

}
