package com.distribuida.dao;

import com.distribuida.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository //es un bean para gestionar persistencia con jpa
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{



}
