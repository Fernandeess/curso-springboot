
CREATE TABLE consultas(
consulta_id bigint auto_increment,
medico_id bigint not null,
paciente_id BIGINT not null,
FOREIGN KEY(medico_id) references medicos(medico_id),
FOREIGN KEY(paciente_id) references pacientes(paciente_id),
primary key (consulta_id,medico_id,paciente_id));