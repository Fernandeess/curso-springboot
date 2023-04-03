package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;


@Table(name = "pacientes") // nome da tabela
@Entity(name = "paciente") // nome da entidade
@Getter //Geração dos Getters
@NoArgsConstructor //Contrutor padrão sem parametros/argumentos
@AllArgsConstructor //Contrutor padrão com todos os parametros/argumentos
@EqualsAndHashCode(of = "id")
public class Paciente {
    //ENTIDADE JPA Paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = dados.endereco();
        this.ativo = true;
    }


    public void atualizarInformacoes(DadosAtualizarPaciente dadosPaciente) {
        if (dadosPaciente.nome() != null) {
            this.nome = dadosPaciente.nome();
        }
        if (dadosPaciente.telefone() != null) {
            this.telefone = dadosPaciente.telefone();
        }
        if (dadosPaciente.endereco() != null) {
            this.endereco.atualizarEndereco(dadosPaciente.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
