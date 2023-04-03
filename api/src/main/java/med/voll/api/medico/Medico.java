package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;


@Table(name = "medicos")
@Entity(name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;


    public Medico(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizarMedico dadosMedico) {

        if (dadosMedico.nome() != null){
            this.nome = dadosMedico.nome();
        }
        if (dadosMedico.telefone() != null){
            this.telefone =  dadosMedico.telefone();
        }
          if (dadosMedico.endereco() != null){
              this.endereco.atualizarEndereco(dadosMedico.endereco());
          }




    }

    public void excluir() {
        this.ativo =false;
    }
}
