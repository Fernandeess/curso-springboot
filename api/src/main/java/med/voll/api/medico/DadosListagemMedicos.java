package med.voll.api.medico;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidade especialidade, Boolean ativo) {
    public DadosListagemMedicos(Medico medico) {
        this(medico.getMedico_id(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getAtivo());
    }
}
