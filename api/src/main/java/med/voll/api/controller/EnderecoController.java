package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.DadosCadastroEndereco;
import med.voll.api.endereco.Endereco;
import med.voll.api.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    //verbo do protocolo http que o metodo vai utilizar
    @PostMapping
    @Transactional // haverá uma transação entre o banco de dados e o metodo controller
    public void cadastrar(@RequestBody @Valid DadosCadastroEndereco dados) { /*puxando o parametro direto do corpo da requisição
    Padrão DTO DATA TRANSFER OBJECT: Representa os dados que chegam na Api e tmb os dados que devolvemos a api
    */
        repository.save(new Endereco(dados));
    }


}
