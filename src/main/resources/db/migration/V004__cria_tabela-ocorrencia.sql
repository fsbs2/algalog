CREATE TABLE occurrence
(
    id                bigint   not null auto_increment,
    delivery_id       bigint   not null,
    description       text     not null,
    registration_date datetime not null,

primary key(id)
);

ALTER TABLE occurrence
    ADD CONSTRAINT fk_occurrence_delivery FOREIGN KEY (delivery_id) REFERENCES delivery (id);