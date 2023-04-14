package med.voll.api.consulta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.controller.DadosCadastrarConsulta;
import med.voll.api.medico.Medico;
import med.voll.api.paciente.Paciente;

@Table(name = "consultas") // nome da tabela
@Entity(name = "consulta") // nome da entidade
@Getter //Geração dos Getters
@NoArgsConstructor //Contrutor padrão sem parametros/argumentos
@AllArgsConstructor //Contrutor padrão com todos os parametros/argumentos
@EqualsAndHashCode(of = "consulta_id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consulta_id;
    @ManyToOne
    @JoinColumn(name = "fk_paciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "fk_medico")
    private Medico medico;

    public Consulta(DadosCadastrarConsulta dados) {

        this.medico = dados.medico();
        this.paciente = dados.paciente();

    }
}
