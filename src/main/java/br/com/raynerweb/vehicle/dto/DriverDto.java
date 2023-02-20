package br.com.raynerweb.vehicle.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DriverDto(
        @JsonProperty("customer_id")
        String customerId,
        @JsonProperty("driver_id")
        String driverId,
        String mail,
        String name,
        String phone
) {

}
