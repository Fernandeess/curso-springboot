package med.voll.api.controller;

import jakarta.validation.constraints.NotNull;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.Paciente;

public record DadosCadastrarConsulta(@NotNull Paciente paciente, @NotNull Medico medico) {
}
