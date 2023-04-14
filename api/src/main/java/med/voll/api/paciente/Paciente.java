package med.voll.api.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Medico;

import java.util.ArrayList;
import java.util.List;


@Table(name = "pacientes") // nome da tabela
@Entity(name = "paciente") // nome da entidade
@Getter //Geração dos Getters
@NoArgsConstructor //Contrutor padrão sem parametros/argumentos
@AllArgsConstructor //Contrutor padrão com todos os parametros/argumentos
@EqualsAndHashCode(of = "paciente_id")
public class Paciente {
    //ENTIDADE JPA Paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paciente_id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @OneToMany
    @JoinColumn(name="id_endereco")
    private List<Endereco> enderecos;
    @ManyToMany @JoinTable(
            name = "consultas",joinColumns = @JoinColumn(name = "fk_paciente"),
            inverseJoinColumns = @JoinColumn(name = "fk_medico")
    )
    private List<Medico> medicos;
    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.ativo = true;
    }


    public void atualizarInformacoes(DadosAtualizarPaciente dadosPaciente) {
        if (dadosPaciente.nome() != null) {
            this.nome = dadosPaciente.nome();
        }
        if (dadosPaciente.telefone() != null) {
            this.telefone = dadosPaciente.telefone();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
