package br.com.desafio.musicas.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import org.apache.http.HttpException;

import java.io.IOException;

public class ConsultaGemini {
    private static final String GEMINI_API_KEY = System.getenv("GEMINI_API_KEY");

    public static String obterInformacaoSobreArtista(String texto) {

        try {
            if (GEMINI_API_KEY == null || GEMINI_API_KEY.isBlank()) {
                throw new IllegalStateException("A variável de ambiente GEMINI_API_KEY não foi configurada no sistema.");
            }

            Client client = Client.builder()
                    .apiKey(GEMINI_API_KEY)
                    .build();

            GenerateContentConfig config =
                    GenerateContentConfig.builder()
                            .maxOutputTokens(1000)
                            .temperature(0.7F)
                            .build();

            GenerateContentResponse response =
                    client.models.generateContent(
                            "gemini-2.5-flash",
                            "Me fale sobre o artista " + texto,
                            config);

            return response.text();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Erro ao fazer a busca";
        }
    }
}
