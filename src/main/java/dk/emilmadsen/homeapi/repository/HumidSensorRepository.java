package dk.emilmadsen.homeapi.repository;

import dk.emilmadsen.homeapi.model.HumidSensorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface HumidSensorRepository extends JpaRepository<HumidSensorLog, Long> {
    List<HumidSensorLog> findAllByTimestampGreaterThan(ZonedDateTime d);
}
