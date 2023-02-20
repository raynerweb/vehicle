package br.com.raynerweb.vehicle.service;

import br.com.raynerweb.vehicle.dto.DriverDto;
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
public class DriverService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverService.class);

    @Value("${driver.uri}")
    private String driverUri;

    public DriverDto findById(String id) {
        Map<String, String> variables = new HashMap<>();
        variables.putIfAbsent("driverId", id);
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<DriverDto> forEntity = restTemplate.getForEntity(driverUri, DriverDto.class, variables);
            return forEntity.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new NotFoundException("Driver not found.");
        } catch (HttpClientErrorException e) {
            String uuid = UUID.randomUUID().toString();
            String message = "Something went wrong. Contact the support team and tell them this identifier: %s".formatted(uuid);
            LOGGER.error(message + System.lineSeparator() + "DriverId %s".formatted(id), e);
            throw new InternalServerErrorException(message);
        }
    }
}
