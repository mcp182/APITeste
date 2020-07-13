package com.example.mariodesenvolvimentos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mariodesenvolvimentos.model.Pessoa;
import com.example.mariodesenvolvimentos.repository.PessoaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/pessoa")
@CrossOrigin(origins = "*")
@Api(value="API REST Pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@ApiOperation(value="Cadastra uma Pessoa")
	@PostMapping("/adicionar")
    public Pessoa adicionar(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
	
	@ApiOperation(value="Retorna uma lista de Pessoas")
	@GetMapping("/listar")
	public List<Pessoa> listar(){
		this.testeFilter();
		return pessoaRepository.findAll();
	}
	
	public void testeFilter(){
		
		List<String> listaString = Arrays.asList("spring", "node", "mkyong");
		List<Pessoa> ListaPessoas = pessoaRepository.findAll();
		List<String> result = listaString.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println); 
        
        List<Pessoa> result1 = ListaPessoas.stream()                        // Convert to steam
                .filter(x -> "Mario".equals(x.getNome()) || x.getIdade()==10)        // we want "jack" only
                .collect(Collectors.toList());                                  // If not found, return null

        for (Pessoa pessoa : result1) {
			System.out.println(pessoa.getNome() + pessoa.getIdade());
		}
	}
	
}
