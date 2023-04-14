create table medicos(

    medico_id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,
    telefone varchar(20) not null,
    ativo tinyint not null,

    primary key(medico_id)

);

