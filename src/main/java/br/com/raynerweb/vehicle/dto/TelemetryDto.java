package br.com.raynerweb.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TelemetryDto(
        @JsonProperty("telemetryprofileId")
        String telemetryId,
        String name
) {
}
