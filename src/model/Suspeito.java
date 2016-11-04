package model;

/**
 * Created by Renard on 27/10/2015.
 */
public class Suspeito extends NonPlayerCharacter
{
    public String nome;
    public String depoimento;
    public String fichaFileName;

    public Suspeito(String nome, String fichaFileName)
    {
        this.fichaFileName = fichaFileName;
        this.depoimento = depoimento;
    }

    public String getDepoimento()
    {
        return this.depoimento;
    }
}
