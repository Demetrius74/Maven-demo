package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.dto.NameModel;

import java.io.IOException;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("name.json")) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();

            NameModel dto = gson.fromJson(new String(stream.readAllBytes()), NameModel.class);
            String toJson = gson.toJson(dto);
            System.out.println(toJson);
        }
    }
}