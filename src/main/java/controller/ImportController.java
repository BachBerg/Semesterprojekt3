package controller;

import com.google.gson.Gson;
import model.Aftale;
import model.AftaleListe;
import dataAccesLayer.apiDAO;
import org.json.JSONArray;
import org.json.JSONObject;

public class ImportController {

    private ImportController() {
    }

    static private final ImportController importControllerOBJ = new ImportController();

    static public ImportController getimportControllerOBJ() {
        return importControllerOBJ;
    }

    public AftaleListe getImportAftaleListe(String http, String liste, String listearray) {

        AftaleListe aftaleListe = new AftaleListe();

        JSONArray newAftaleList = apiDAO.getApiDAOOBJ().getJsonOBJ(http,System.getenv("apiKey")).getJSONObject(liste).getJSONArray(listearray);

        for (int i = 0; i < newAftaleList.length(); i++) {
            aftaleListe.addAftaler(new Gson().fromJson(String.valueOf(newAftaleList.getJSONObject(i)), Aftale.class));
        }

        return aftaleListe;
    }

    public JSONObject getImportJSON(String http) {
        return apiDAO.getApiDAOOBJ().getJsonOBJ(http,System.getenv("apiKey"));
    }
}
