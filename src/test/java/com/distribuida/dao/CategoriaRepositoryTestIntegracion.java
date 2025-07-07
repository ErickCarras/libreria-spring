package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CategoriaRepositoryTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void finAll(){
        List<Categoria> categorias = categoriaRepository.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size()>0);
        for(Categoria item: categorias){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Categoria> categoria =categoriaRepository.findById(1);
        assertTrue(categoria.isPresent());
        System.out.println(categoria.toString());
    }

    @Test
    public void save (){
        Categoria categoria = new Categoria(0,"Ficción","Misterio");
        Categoria categoriaGuardado = categoriaRepository.save(categoria);
        assertNotNull(categoriaGuardado);
        assertEquals("Ficción", categoriaGuardado.getCategoria());
        assertEquals("Misterio", categoriaGuardado.getDescripcion());
    }
    @Test
    public void update(){
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(58);

        assertNotNull(categoriaExistente);

        categoriaExistente.orElse(null).setCategoria("Ficción22");
        categoriaExistente.orElse(null).setDescripcion("Misterio22");

        Categoria categoriaActualizada = categoriaRepository.save(categoriaExistente.orElse(null));

        assertNotNull(categoriaActualizada);
        assertEquals("Ficción22", categoriaActualizada.getCategoria());
    }

    @Test
    public void delete(){
        if (categoriaRepository.existsById(51)){
            categoriaRepository.deleteById(51);
        }
        assertFalse(categoriaRepository.existsById(51));
    }

}

