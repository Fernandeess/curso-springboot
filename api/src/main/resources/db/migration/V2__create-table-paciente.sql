CREATE TABLE pacientes(
	paciente_id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(11) not null unique,
    telefone varchar (20) not null unique,
    ativo tinyint not null  ,
    PRIMARY KEY(paciente_id)
);