package br.com.raynerweb.vehicle.rest;

import br.com.raynerweb.vehicle.dto.vehicle.RequestVehicleDto;
import br.com.raynerweb.vehicle.dto.vehicle.ResponseVehicleDto;
import br.com.raynerweb.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleRest {

    @Autowired
    private VehicleService service;

    @GetMapping
    public List<ResponseVehicleDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public ResponseVehicleDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseVehicleDto save(@RequestBody RequestVehicleDto dto) {
        return service.save(dto);
    }

}
