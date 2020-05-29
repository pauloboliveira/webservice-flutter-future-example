package br.com.paulo.flutterfuture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paulo.flutterfuture.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
