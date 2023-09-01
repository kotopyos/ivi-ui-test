package api.utils;

import api.specs.Specs;
import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class RandomFilmExtractor {
    static ClassLoader cl = Specs.class.getClassLoader();
    public static int randomFilmNumber() throws Exception {

        try (
                InputStream resource = cl.getResourceAsStream("db/films.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(resource))
        ) {
            List<String[]> content = reader.readAll();
            int ranNum = 0 + (int)(Math.random() * ((content.size() - 1 - 0) + 1));

            return Integer.parseInt(content.get(ranNum)[0]);
        }
    }
}
