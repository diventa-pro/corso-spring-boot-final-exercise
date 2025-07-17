CREATE TABLE property
(
    id      UUID         NOT NULL,
    name    VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    vat_id  VARCHAR(255) NOT NULL,
    CONSTRAINT pk_property PRIMARY KEY (id)
);

ALTER TABLE property
    ADD CONSTRAINT uc_property_vat UNIQUE (vat_id);


CREATE TABLE contractor
(
    id     UUID         NOT NULL,
    name   VARCHAR(255) NOT NULL,
    vat_id VARCHAR(255) NOT NULL,
    CONSTRAINT pk_contractor PRIMARY KEY (id)
);

ALTER TABLE contractor
    ADD CONSTRAINT uc_contractor_vat UNIQUE (vat_id);


CREATE TABLE contract
(
    property_id   UUID NOT NULL,
    contractor_id UUID NOT NULL,
    start_date    date NOT NULL,
    end_date      date,
    CONSTRAINT pk_contract PRIMARY KEY (property_id, contractor_id, start_date)
);

ALTER TABLE contract
    ADD CONSTRAINT FK_CONTRACT_ON_CONTRACTOR FOREIGN KEY (contractor_id) REFERENCES contractor (id);

ALTER TABLE contract
    ADD CONSTRAINT FK_CONTRACT_ON_PROPERTY FOREIGN KEY (property_id) REFERENCES property (id);