package io.ideahell.graduation.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.ideahell.graduation.domain.Bunny;

public final class Names {

    private static final ObjectMapper OBJ_MAPPER = new ObjectMapper();

    private Names() {}

    public static String generate(Bunny.Gender gender) {
        // TODO: cleanup lol so horrible
        try {
            URLConnection namegen = new URL("https://uinames.com/api/?gender=" + gender.toString().toLowerCase()).openConnection();
            String jsonResponse = new BufferedReader(new InputStreamReader(namegen.getInputStream())).lines()
                    .collect(Collectors.joining("\n"));

            return (String) OBJ_MAPPER.readValue(jsonResponse, Map.class).get("name");
        } catch (IOException ex) {
            return "Fufuu";
        }
    }

}
