package br.com.raynerweb.vehicle.mapper;

import br.com.raynerweb.vehicle.dto.DriverDto;
import br.com.raynerweb.vehicle.dto.TelemetryDto;
import br.com.raynerweb.vehicle.dto.vehicle.RequestVehicleDto;
import br.com.raynerweb.vehicle.dto.vehicle.ResponseVehicleDto;
import br.com.raynerweb.vehicle.entity.VehicleEntity;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public ResponseVehicleDto entityToDto(VehicleEntity e) {
        return new ResponseVehicleDto(
                e.getId(),
                e.getCustomerId(),
                e.getTelemetryProfileId(),
                e.getDriverId(),
                e.getNumPlate(),
                e.getColor(),
                e.getVin()
        );
    }

    public VehicleEntity dtoToEntity(RequestVehicleDto dto, TelemetryDto telemetryDto, DriverDto driverDto) {
        VehicleEntity entity = new VehicleEntity();
        entity.setCustomerId(driverDto.customerId());
        entity.setDriverId(driverDto.driverId());

        entity.setTelemetryProfileId(telemetryDto.telemetryId());

        entity.setColor(dto.color());
        entity.setNumPlate(dto.numPlate());
        entity.setVin(dto.vin());
        return entity;
    }

}
