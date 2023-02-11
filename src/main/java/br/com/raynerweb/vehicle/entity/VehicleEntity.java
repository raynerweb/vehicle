package br.com.raynerweb.vehicle.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_VEHICLE", uniqueConstraints = @UniqueConstraint(columnNames = {"NUM_PLATE"}, name = "UQK_PLATE"))
public class VehicleEntity {

    @Id
    @SequenceGenerator(name = "TB_VEHICLE_COD_VEHICLE_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_VEHICLE", updatable = false)
    private Long id;

    @Column(name = "COD_CUSTOMER", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String customerId;

    @Column(name = "COD_TELEMETRY_PROFILE", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String telemetryProfileId;

    @Column(name = "COD_CURRENT_DRIVER", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String driverId;

    @Column(name = "NUM_PLATE", updatable = false, nullable = false, columnDefinition = "VARCHAR(10)")
    private String numPlate;

    @Column(name = "TXT_COLOR", updatable = false)
    private String color;

    @Column(name = "TXT_VIN", updatable = false)
    private String vin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTelemetryProfileId() {
        return telemetryProfileId;
    }

    public void setTelemetryProfileId(String telemetryProfileId) {
        this.telemetryProfileId = telemetryProfileId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
