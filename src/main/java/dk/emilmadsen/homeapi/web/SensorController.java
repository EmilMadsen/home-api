package dk.emilmadsen.homeapi.web;

import com.google.gson.Gson;
import dk.emilmadsen.homeapi.model.HumidSensorLog;
import dk.emilmadsen.homeapi.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService service;
    private final Gson gson;

    @GetMapping("/{id}")
    public HumidSensorLog findById(@PathVariable String id) {
        return service.findById(Long.valueOf(id)).orElse(null);
    }

    @GetMapping
    public List<HumidSensorLog> getLatest() {
        return service.getLatest();
    }

    @PostMapping
    public HumidSensorLog save(@RequestBody HumidSensorLog log, HttpServletRequest request) {
        log.setDevice(request.getRemoteAddr());
        return service.save(log);
    }


}
