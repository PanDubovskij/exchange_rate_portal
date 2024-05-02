-- drop table if exists rates;
create table if not exists rates
(
    id   bigint auto_increment primary key,
    tp   varchar        not null,
    dt   date           not null,
    ccy1 varchar        not null,
    amt1 numeric(20, 8) not null,
    ccy2 varchar        not null,
    amt2 numeric(20, 8) not null
);

-- insert into rates(tp, dt, ccy1, amt1, ccy2, amt2)
-- values ('eu', '2024-04-26', 'eur', 1, 'aud', 1.6392);