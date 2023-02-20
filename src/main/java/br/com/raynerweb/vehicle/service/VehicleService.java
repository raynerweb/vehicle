package br.com.raynerweb.vehicle.service;

import br.com.raynerweb.vehicle.dto.DriverDto;
import br.com.raynerweb.vehicle.dto.TelemetryDto;
import br.com.raynerweb.vehicle.dto.vehicle.RequestVehicleDto;
import br.com.raynerweb.vehicle.dto.vehicle.ResponseVehicleDto;
import br.com.raynerweb.vehicle.entity.VehicleEntity;
import br.com.raynerweb.vehicle.mapper.VehicleMapper;
import br.com.raynerweb.vehicle.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleMapper mapper;

    @Autowired
    private TelemetryService telemetryService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private VehicleRepository repository;

    public List<ResponseVehicleDto> findAll() {
        return repository.findAll().stream().map(mapper::entityToDto).toList();
    }

    public ResponseVehicleDto save(RequestVehicleDto dto) {
        TelemetryDto telemetryDto = telemetryService.findById(dto.telemetryId());
        DriverDto driverDto = driverService.findById(dto.driverId());
        VehicleEntity saved = repository.save(mapper.dtoToEntity(dto, telemetryDto, driverDto));
        return mapper.entityToDto(saved);
    }

}
