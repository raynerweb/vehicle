package br.com.raynerweb.vehicle.rest;

import br.com.raynerweb.vehicle.dto.vehicle.RequestVehicleDto;
import br.com.raynerweb.vehicle.dto.vehicle.ResponseVehicleDto;
import br.com.raynerweb.vehicle.service.DriverService;
import br.com.raynerweb.vehicle.service.TelemetryService;
import br.com.raynerweb.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleRest {

    @Autowired
    private VehicleService service;

    @Autowired
    private DriverService driverService;

    @Autowired
    private TelemetryService telemetryService;

    @GetMapping
    public List<ResponseVehicleDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/teste")
    public void teste() {
        telemetryService.findById("e8d6cede-e3dc-47c9-a61d-429f316c35cf");
    }

    @PostMapping
    public ResponseVehicleDto save(@RequestBody RequestVehicleDto dto) {
        return service.save(dto);
    }

}
