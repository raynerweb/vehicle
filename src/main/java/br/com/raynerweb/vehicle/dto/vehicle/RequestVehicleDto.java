package br.com.raynerweb.vehicle.dto.vehicle;

public record RequestVehicleDto(
        String telemetryId,
        String driverId,
        String numPlate,
        String color,
        String vin
) {
}
