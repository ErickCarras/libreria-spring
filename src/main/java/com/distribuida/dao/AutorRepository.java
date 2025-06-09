package com.distribuida.dao;

import com.distribuida.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository //es un bean para gestionar persistencia con jpa
public interface AutorRepository extends JpaRepository<Autor, Integer>{


}

