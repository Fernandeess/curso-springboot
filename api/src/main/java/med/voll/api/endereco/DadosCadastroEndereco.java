package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.paciente.Paciente;

public record DadosCadastroEndereco(@NotBlank
                                    String logradouro,
                                    @NotBlank
                                    String bairro,
                                    @NotBlank
                                    @Pattern(regexp = "\\d{8}")
                                    String cep,
                                    @NotBlank
                                    String cidade,
                                    @NotBlank
                                    String uf,
                                    String complemento,

                                    String numero,
                                    @NotNull
                                    Paciente paciente
) {
}
