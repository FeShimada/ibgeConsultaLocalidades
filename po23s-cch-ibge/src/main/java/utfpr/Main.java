package utfpr;

import utfpr.http.ClienteHttp;

public class Main {

    public static void main(String[] args) {
        ClienteHttp cliente = new ClienteHttp();
        String baseUrl = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios";
        String result = cliente.buscaDados(baseUrl);
        System.out.println(result);
    }
}
