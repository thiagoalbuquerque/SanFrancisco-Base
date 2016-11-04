package model;

public class Evidencia {

    public String nome;
    public String descricao;
    public boolean desbloqueada = false;
    public String imageFileName;

    public Evidencia( String n, String d)
    {
        nome = n;
        descricao = d;
    }

    public Evidencia( String imageFileName )
    {
        this.imageFileName = imageFileName;
        this.descricao = "Indefinida";
        this.nome = "Indefinido";
    }

    public String getNome()
    {
        return nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void habilitaEvidencia()
    {
        if (!this.desbloqueada)
        {
            this.desbloqueada = true;
        }
    }
}