package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.Endereco;

public record/*O Record é um recurso que permite representar uma classe imutável, contendo apenas atributos,
 construtor e métodos de leitura, de uma maneira muito simples e enxuta.*/
DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone

)
        /*Aqui ficam os campos que chegão da requisição*/ {


}
