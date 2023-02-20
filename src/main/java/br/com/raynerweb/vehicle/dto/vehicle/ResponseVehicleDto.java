package br.com.raynerweb.vehicle.dto.vehicle;

public record ResponseVehicleDto(
        Long id,
        String customerId,
        String telemetryProfileId,
        String driverId,
        String numPlate,
        String color,
        String vin
) {
}