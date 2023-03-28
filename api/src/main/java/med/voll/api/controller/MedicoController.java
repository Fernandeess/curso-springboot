package med.voll.api.controller;


import jakarta.persistence.OrderBy;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedicos;
import med.voll.api.medico.DadosListagemMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @OrderBy("nome")
    public List<DadosListagemMedicos> listar() {
        return repository.findAll().stream().map(DadosListagemMedicos::new).toList();
    }

}
