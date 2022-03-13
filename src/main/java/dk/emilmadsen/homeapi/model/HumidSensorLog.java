package dk.emilmadsen.homeapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Table(name = "humid_log")
@Data
public class HumidSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("UTC"));
    private Double humidity;
    private Double temperature;
    private String device;


}
