package br.com.doc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.text.html.HTMLEditorKit.Parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BuscadorCNPJ {

	public static void main(String[] args) throws IOException, JSONException {
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("Digite o CNPJ sem pontos e traços: ");
		String cnpj = sc.nextLine(); 
		
		//27865757000102
		
		URL url = new URL("https://www.receitaws.com.br/v1/cnpj/" + cnpj);

		try {
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestProperty("Accept", "application/json");
			httpURLConnection.setRequestMethod("GET");
			if (200 <= httpURLConnection.getResponseCode() && httpURLConnection.getResponseCode() <= 299) {
				BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
				StringBuilder sb = new StringBuilder();
				String output;
				while ((output = br.readLine()) != null) {
					sb.append(output);
				}

				JSONArray json = new JSONArray("[" + sb.toString() + "]");

				for (int i = 0; i < json.length(); i++) {

					JSONObject jsonObject = (JSONObject) json.get(i);

					PessoaJuridica pj = new PessoaJuridica();

					// Atividade Principal
					JSONArray atividade = jsonObject.getJSONArray("atividade_principal");
					for (int j = 0; j < atividade.length(); j++) {
						JSONObject p = (JSONObject) atividade.get(i);
						String ativ = p.getString("text");
						pj.setAtividadePrincipal(ativ);
					}					
					
					//Imprimindo retorno do json
					System.out.println(pj.getAtividadePrincipal());
					
					
				}
				// System.out.println(json.toString());
			}
		} catch (Exception e) {
			throw e;
		}

		sc.close();
		
	}
}