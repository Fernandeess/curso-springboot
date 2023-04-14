package med.voll.api.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.paciente.Paciente;


@Table(name = "enderecos")
@Entity(name = "endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;
    @ManyToOne
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;


    public Endereco(DadosCadastroEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.paciente = dados.paciente();
        this.complemento = dados.complemento();
    }


    public void atualizarEndereco(Endereco endereco) {
        if (endereco.complemento != null) {
            this.complemento = endereco.complemento;
        }
        if (endereco.cidade != null) {
            this.cidade = endereco.cidade;
        }
        if (endereco.cep != null) {
            this.cep = endereco.cep;
        }
        if (endereco.bairro != null) {
            this.bairro = endereco.bairro;
        }
        if (endereco.uf != null) {
            this.uf = endereco.uf;
        }
        if (endereco.numero != null) {
            this.numero = endereco.numero;
        }
        if (endereco.logradouro != null) {
            this.logradouro = endereco.logradouro;
        }
    }
}
