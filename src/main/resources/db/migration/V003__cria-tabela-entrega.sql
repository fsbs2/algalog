CREATE TABLE delivery
(
    id                  bigint         not null auto_increment,
    client_id           bigint         not null,
    tax                 decimal(10, 2) not null,
    status              varchar(20)    not null,
    start_delivery      datetime       not null,
    end_delivery        datetime,

    adresser_name       varchar(60)    not null,
    adresser_street     varchar(255)   not null,
    adresser_number     varchar(30)    not null,
    adresser_complement varchar(60)    not null,
    adresser_district   varchar(30)    not null,

    primary key (id)
);
ALTER TABLE delivery ADD CONSTRAINT fk_delivery_adresser FOREIGN KEY (client_id) REFERENCES client(id);