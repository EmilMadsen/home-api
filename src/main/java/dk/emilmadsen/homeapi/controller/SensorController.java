package dk.emilmadsen.homeapi.controller;

import com.google.gson.Gson;
import dk.emilmadsen.homeapi.model.HumidSensorLog;
import dk.emilmadsen.homeapi.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
@RequestMapping("/api/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService service;
    private final Gson gson;

    @GetMapping("/{id}")
    public String findById(@PathVariable String id) {
        return gson.toJson(service.findById(Long.valueOf(id)));
    }

    @PostMapping
    public String save(@RequestBody String body, HttpServletRequest request) {
        HumidSensorLog log = gson.fromJson(body, HumidSensorLog.class);
        log.setDevice(request.getRemoteAddr());
        return gson.toJson(service.save(log));
    }


}
