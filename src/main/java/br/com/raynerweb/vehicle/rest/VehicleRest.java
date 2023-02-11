package br.com.raynerweb.vehicle.rest;

import br.com.raynerweb.vehicle.dto.VehicleDto;
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
    public List<VehicleDto> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void save(@RequestBody VehicleDto dto) {
        service.save(dto);
    }

}
