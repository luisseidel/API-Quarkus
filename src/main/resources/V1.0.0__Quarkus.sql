create database teste_quarkus;

create table pais
(
    id       bigserial primary key not null,
    nome     text                  not null,
    cod_area varchar(4)
);

create table estado
(
    id       bigserial primary key not null,
    nome     text                  not null,
    cod_area varchar(4),
    id_pais  bigserial references pais(id)
);

create table cidade
(
    id        bigserial primary key not null,
    nome      text                  not null,
    id_estado bigserial references estado(id)
);

create table endereco
(
    id               bigserial primary key not null,
    cep              varchar(8)            not null,
    tipo_logradouro  text,
    logradouro       text,
    numero           text,
    complemento      text,
    ponto_referencia text,
    id_cidade        bigserial references cidade(id)
);

create table empresa
(
    id                 bigserial primary key not null,
    razao_social       text                  not null,
    nome_fantasia      text                  not null,
    cpf_cnpj           varchar(14)           not null,
    tipo_pessoa        int2                  not null,
    situacao           int2                  not null,
    data_abertura      date,
    porte_empresa      int2,
    telefone           varchar(11) not null,
    email              text not null,
    id_endereco        bigserial             not null references endereco (id)
);

