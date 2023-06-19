/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utfpr.converter;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import utfpr.model.Municipio;
import utfpr.model.Uf;

/**
 *
 * @author felipe
 */
public class MunicipioConverter {
    
    public static List<Municipio> jsonToMunicipio(String json) {
        List<Municipio> municipios = new ArrayList<>();
        
        JSONArray jsonArray = new JSONArray(json);
        
        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonMunicipio = jsonArray.getJSONObject(i);
            
            int id = jsonMunicipio.getInt("id");
            String nome = jsonMunicipio.getString("nome");
            Uf uf = UfConverter.jsonObjectToUf(jsonMunicipio.getJSONObject("microrregiao").getJSONObject("mesorregiao").getJSONObject("UF").toString());
            String regiao = jsonMunicipio.getJSONObject("microrregiao").getJSONObject("mesorregiao").getJSONObject("UF").getJSONObject("regiao").getString("nome");
            
            Municipio municipio = new Municipio();
            municipio.setId(id);
            municipio.setNome(nome);
            municipio.setRegiao(regiao);
            municipio.setUf(uf);
            
            municipios.add(municipio);
        }
        
        return municipios;
    }
    
}
