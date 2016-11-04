package model;

public class Cena
{
    public Evidencia evidencia;
    public Evidencia depoimento;
    public Suspeito suspeito;
    public String descricao;
    public String imageFileName;

    /*public Cena( String descricao, Evidencia evidencia){
        this.descricao = descricao;
        this.evidencia = evidencia;
    }*/
    public Cena( String imageFileName, String descricao){
        this.imageFileName = imageFileName;
        this.descricao = descricao;
    }
    public Cena(String imageFileName, String nomeSuspeito, String descricao, String suspeitoFileName, String evidenciaFileName ){
        this.suspeito = new Suspeito(nomeSuspeito, suspeitoFileName);
        this.descricao = descricao;
        this.imageFileName = imageFileName;
        if(evidenciaFileName.trim().equals("NOT_AVAILABLE")){
            this.evidencia = null;
        }else{
            this.evidencia = new Evidencia(evidenciaFileName);
        }
        if(suspeitoFileName.trim().equals("NOT_AVAILABLE")){
            this.depoimento = null;
        }else{
            this.depoimento = new Evidencia(suspeitoFileName);
        }
    }


    /*public String interrogaSuspeito( )
    {
        if(suspeito != null)
        {
            evidencia.habilitaEvidencia();
            return suspeito.getDepoimento();
        }
        else
        {
            return "N�o h� suspeitos nesta Area";
        }

    }*/

    /*public String investigaCena()
    {

        /*if(evidencia != null)
        {
            evidencia.habilitaEvidencia();
            return "Voc� encontrou uma evid�ncia: "+evidencia.getDescricao();
        }
        else
        {
            return "N�o foi encontrada nenhuma evid�ncia.";
        }

    }*/
    public String toString(){
        return this.imageFileName + " - "+this.descricao + " - " + evidencia.imageFileName;
    }
}