package com.example.mariodesenvolvimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.mariodesenvolvimentos.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
