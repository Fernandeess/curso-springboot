package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //define que essa classe e um controller que vai ser carregada na inicialização do projeto
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    //verbo do protocolo http que o metodo vai utilizar
    @PostMapping
    @Transactional // haverá uma transação entre o banco de dados e o metodo controller
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosPaciente) { /*puxando o parametro direto do corpo da requisição
    Padrão DTO DATA TRANSFER OBJECT: REpresenta os dados que chegam na Api e tmb os dados que devolvemos a api
    */
        repository.save(new Paciente(dadosPaciente));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listar(Pageable paginas) {
        return repository.findAllByAtivoTrue(paginas).map(DadosListagemPacientes::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarPaciente dadosPaciente) {
        var paciente = repository.getReferenceById(dadosPaciente.id());
        paciente.atualizarInformacoes(dadosPaciente);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
//        repository.deleteById(id);
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }

}
