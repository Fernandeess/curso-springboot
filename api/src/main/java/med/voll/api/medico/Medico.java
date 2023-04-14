package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.paciente.Paciente;

import java.util.ArrayList;
import java.util.List;


@Table(name = "medicos")
@Entity(name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "medico_id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medico_id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated
    private Especialidade especialidade;
    @ManyToMany @JoinTable(
            name = "consultas",joinColumns = @JoinColumn(name = "fk_medico"),
            inverseJoinColumns = @JoinColumn(name = "fk_paciente")
    )
    private List<Paciente> pacientes;
    private Boolean ativo;
    public Medico(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.ativo = true;

    }

    public void atualizarInformacoes(DadosAtualizarMedico dadosMedico) {

        if (dadosMedico.nome() != null){
            this.nome = dadosMedico.nome();
        }
        if (dadosMedico.telefone() != null){
            this.telefone =  dadosMedico.telefone();
        }





    }

    public void excluir() {
        this.ativo =false;
    }
}
