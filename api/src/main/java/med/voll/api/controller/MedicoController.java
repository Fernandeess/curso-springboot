package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import med.voll.api.paciente.DadosAtualizarPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository; //dao

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados) {
        System.out.println(dados);
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicos::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarMedico dadosMedico){

        var medico = repository.getReferenceById(dadosMedico.id());
        medico.atualizarInformacoes(dadosMedico);

    }

@DeleteMapping("/{id}") //pegando esse padrao na assinatura da função
    @Transactional
    public void excuir(@PathVariable/*AQUI*/ Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
}

}
