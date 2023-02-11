package br.com.raynerweb.vehicle.service;

import br.com.raynerweb.vehicle.dto.VehicleDto;
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
    private VehicleRepository repository;

    public List<VehicleDto> findAll() {
        return repository.findAll().stream().map(mapper::entityToDto).toList();
    }

    public void save(VehicleDto dto) {
        repository.save(mapper.dtoToEntity(dto));
    }
}
