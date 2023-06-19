package utfpr;

import java.util.List;
import utfpr.converter.MunicipioConverter;
import utfpr.converter.UfConverter;
import utfpr.http.ClienteHttp;
import utfpr.model.Municipio;
import utfpr.model.Uf;

public class Main {

    public static void main(String[] args) {
        ClienteHttp cliente = new ClienteHttp();
        
        String baseUrlUf = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
        String resultUf = cliente.buscaDados(baseUrlUf);
        
        String resultMun = cliente.getMunicipiosByUf("sp");
        System.out.println(resultMun);
        
        List<Uf> ufs = UfConverter.jsonToUf(resultUf);
        for (Uf uf : ufs) {
            //System.out.println(uf.getNome());
        }
        
        List<Municipio> municipios = MunicipioConverter.jsonToMunicipio(resultMun);
        for (Municipio municipio : municipios) {
            System.out.println(municipio.getNome());
        }
        
        
    }
}
