package br.com.doc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
				BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream()), StandardCharsets.UTF_8));
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
					String ativPrinc = "";
					for (int j = 0; j < atividade.length(); j++) {
						JSONObject p = (JSONObject) atividade.get(i);
						String ativ = p.getString("code") + " " + p.getString("text");
						ativPrinc += ativ;
					}
					
					pj.setAtividadePrincipal(ativPrinc);					
					pj.setAbertura(jsonObject.getString("data_situacao") );
					pj.setNome(jsonObject.getString("nome"));
					pj.setUf(jsonObject.getString("uf"));
					pj.setTelefone(jsonObject.getString("telefone"));					
					
					// Atividade Secundaria
					JSONArray atividadeSec = jsonObject.getJSONArray("atividades_secundarias");
					String ativSec = "";
					for (int j = 0; j < atividadeSec.length(); j++) {
						JSONObject p = (JSONObject) atividadeSec.get(i);
						String ativ = p.getString("code") + " " + p.getString("text");
						//pj.setAtividadeSecundaria((j + 1) == (atividadeSec.length()) ? ativ : ativ + "\n");
						ativSec +=  (j + 1) == (atividadeSec.length()) ? ativ : ativ + "\n";
					}
					
					pj.setAtividadeSecundaria(ativSec);					
					pj.setSituacao(jsonObject.getString("situacao"));
					pj.setBairro(jsonObject.getString("bairro"));
					pj.setLogradouro(jsonObject.getString("logradouro"));
					pj.setNumero(jsonObject.getString("numero"));
					pj.setCep(jsonObject.getString("cep"));
					pj.setMunicipio(jsonObject.getString("municipio"));
					pj.setDataSitucao(jsonObject.getString("data_situacao"));
					pj.setFantasia(jsonObject.getString("fantasia"));
					pj.setCnpj(jsonObject.getString("cnpj"));
					pj.setStatus(jsonObject.getString("status"));
					
					//Imprimindo retorno do json
					System.out.println(pj.getAtividadePrincipal());
					System.out.println(pj.getDataSitucao());
					System.out.println(pj.getNome());
					System.out.println(pj.getUf());
					System.out.println(pj.getTelefone());
					System.out.println(pj.getAtividadeSecundaria());
					System.out.println(pj.getSituacao());
					System.out.println(pj.getBairro());
					System.out.println(pj.getLogradouro());
					System.out.println(pj.getNumero());
					System.out.println(pj.getCep());
					System.out.println(pj.getMunicipio());					
					System.out.println(pj.getAbertura());
					System.out.println(pj.getFantasia());
					System.out.println(pj.getCnpj());
					System.out.println(pj.getStatus());
					
				}
				// System.out.println(json.toString());
			}
		} catch (Exception e) {
			throw e;
		}

		sc.close();
		
	}
}