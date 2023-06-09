package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;

public record DadosListagemPacientes(Long id, String nome, String email, String cpf) {

    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getPaciente_id(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }


}
