package br.com.raynerweb.vehicle.service;

import br.com.raynerweb.vehicle.dto.TelemetryDto;
import br.com.raynerweb.vehicle.exception.InternalServerErrorException;
import br.com.raynerweb.vehicle.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TelemetryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryService.class);

    @Value("${telemetry.uri}")
    private String telemetryUri;

    public TelemetryDto findById(String id) {
        Map<String, String> variables = new HashMap<>();
        variables.putIfAbsent("telemetryId", id);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<TelemetryDto> forEntity = restTemplate.getForEntity(telemetryUri, TelemetryDto.class, variables);
            return forEntity.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new NotFoundException("Telemetry not found.");
        } catch (HttpClientErrorException e) {
            String uuid = UUID.randomUUID().toString();
            String message = "Something went wrong. Contact the support team and tell them this identifier: %s".formatted(uuid);
            LOGGER.error(message + System.lineSeparator() + "Telemetry id %s".formatted(id), e);
            throw new InternalServerErrorException(message);
        }
    }


}
