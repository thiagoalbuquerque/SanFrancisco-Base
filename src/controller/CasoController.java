package controller;

import model.*;

/**
 * Created by Renard on controller.
 */
public class CasoController {

    public Caso caso;

    //Singleton
    private static CasoController instance = null;
    public static CasoController getInstance() {
        if (instance == null) instance = new CasoController();
        return instance;
    }

    public Caso carregaCaso(String nomeCaso){
        this.caso = new Caso(nomeCaso);
        return caso;
    }

    public Caso getCasoAtual(){
        return caso;
    }
}
