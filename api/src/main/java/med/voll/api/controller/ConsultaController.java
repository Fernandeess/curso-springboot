package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.consulta.Consulta;
import med.voll.api.consulta.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @Autowired
    ConsultaRepository repository;
    @PostMapping
    @Transactional
    public void criarConsulta(@RequestBody @Valid DadosCadastrarConsulta dados ){
        System.out.println(dados);
        repository.save( new Consulta(dados));
    }


}
