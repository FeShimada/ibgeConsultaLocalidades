/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.converter;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import utfpr.model.Uf;

/**
 *
 * @author felipe
 */
public class UfConverter  {
    
    public static List<Uf> jsonToUf(String json) {
        List<Uf> ufs = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonUf = jsonArray.getJSONObject(i);
            int id = jsonUf.getInt("id");
            String nome = jsonUf.getString("nome");
            String sigla = jsonUf.getString("sigla");
            
            Uf uf = new Uf();
            uf.setId(id);
            uf.setNome(nome);
            uf.setSigla(sigla);
            
            ufs.add(uf);
        }
        
        return ufs;
    }
    
    public static Uf jsonObjectToUf(String json) {
        
        Uf uf = new Uf();
        JSONObject jsonObject = new JSONObject(json);
        
        int id = jsonObject.getInt("id");
        String nome = jsonObject.getString("nome");
        String sigla = jsonObject.getString("sigla");
        
        uf.setId(id);
        uf.setNome(nome);
        uf.setSigla(sigla);
        
        return uf;
    }
    
}
