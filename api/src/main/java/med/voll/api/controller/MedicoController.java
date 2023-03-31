package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedicos;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
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
        return repository.findAll(paginacao).map(DadosListagemMedicos::new);
    }

}
