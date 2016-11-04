package model;

/**
 * Created by luis_ on 27/10/2015.
 */
public class Pista
{
    private String nome;
    private String descricao;

    public Pista(String n, String d)
    {
        nome = n;
        descricao = d;
    }

    public String getNome()
    {
        return nome;
    }

    public String getDescricao()
    {
        return descricao;
    }
}
