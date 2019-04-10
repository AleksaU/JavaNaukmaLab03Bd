package enteties;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import enteties.builders.DisciplinesBuilder;

import java.io.IOException;

public class DisciplinesDeserializer extends KeyDeserializer {

    @Override
    public Object deserializeKey(String s, DeserializationContext deserializationContext) throws IOException {
        int id = Integer.parseInt(s.substring(s.indexOf("=") + 1, s.indexOf(",")));
        s = s.substring(s.indexOf(",") + 1);
        String name = s.substring(s.indexOf("=") + 1, s.indexOf(","));
        s = s.substring(s.indexOf(",") + 1);
        Double credits = Double.valueOf(s.substring(s.indexOf("=") + 1, s.indexOf("}")));
        return new DisciplinesBuilder().setId(id).setName(name).setCredits(credits).createDisciplines();
    }
}
