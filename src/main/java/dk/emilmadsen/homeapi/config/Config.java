package dk.emilmadsen.homeapi.config;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, (JsonDeserializer<ZonedDateTime>) (json, type, jsonDeserializationContext)
                        -> ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_DATE_TIME))
                .registerTypeAdapter(ZonedDateTime.class, (JsonSerializer<ZonedDateTime>) (zonedDateTime, type, jsonSerializationContext)
                        -> new JsonPrimitive(zonedDateTime.format(DateTimeFormatter.ISO_DATE_TIME))).create();
    }
}
