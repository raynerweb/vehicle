CREATE TABLE TB_VEHICLE (
    COD_VEHICLE BIGSERIAL PRIMARY KEY,
    COD_CUSTOMER VARCHAR(36) NOT NULL,
    COD_TELEMETRY_PROFILE VARCHAR(36) NOT NULL,
    COD_CURRENT_DRIVER VARCHAR(36) NOT NULL,
    NUM_PLATE VARCHAR(10) NOT NULL,
    TXT_COLOR VARCHAR(255),
    TXT_VIN VARCHAR(255),
    CONSTRAINT UQK_PLATE UNIQUE (NUM_PLATE)
);