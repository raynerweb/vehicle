package br.com.raynerweb.vehicle.mapper;

import br.com.raynerweb.vehicle.dto.VehicleDto;
import br.com.raynerweb.vehicle.entity.VehicleEntity;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleDto entityToDto(VehicleEntity e) {
        return new VehicleDto(
                e.getId(),
                e.getCustomerId(),
                e.getTelemetryProfileId(),
                e.getDriverId(),
                e.getNumPlate(),
                e.getColor(),
                e.getVin()
        );
    }

    public VehicleEntity dtoToEntity(VehicleDto dto) {
        VehicleEntity entity = new VehicleEntity();
        entity.setId(dto.id());
        entity.setColor(dto.color());
        entity.setCustomerId(dto.customerId());
        entity.setDriverId(dto.driverId());
        entity.setNumPlate(dto.numPlate());
        entity.setTelemetryProfileId(dto.telemetryProfileId());
        entity.setVin(dto.vin());
        return entity;
    }

}
