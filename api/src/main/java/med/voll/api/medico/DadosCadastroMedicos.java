package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.medico.Especialidade;

public record DadosCadastroMedicos(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String telefone,
        @NotBlank
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco) {

}