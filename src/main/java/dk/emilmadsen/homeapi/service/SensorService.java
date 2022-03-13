package dk.emilmadsen.homeapi.service;

import dk.emilmadsen.homeapi.repository.HumidSensorRepository;
import dk.emilmadsen.homeapi.model.HumidSensorLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final HumidSensorRepository humidSensorRepository;

    public Optional<HumidSensorLog> findById(Long id) {
        return humidSensorRepository.findById(id);
    }

    public HumidSensorLog save(HumidSensorLog log) {
        return humidSensorRepository.save(log);
    }

}
