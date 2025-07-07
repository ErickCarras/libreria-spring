package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;

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
public class AutorRepositoryTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void finAll(){
        List<Autor> autores = autorRepository.findAll();
        assertNotNull(autores);
        assertTrue(autores.size()>0);
        for(Autor item: autores){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Autor> autor =autorRepository.findById(1);
        assertTrue(autor.isPresent());
        System.out.println(autor.toString());
    }

    @Test
    public void save (){
        Autor autor = new Autor(1,"Erika55","Esperanza55", "Brasil55", "portuguez55", "0987234355", "jtaipe55@correo.com");
        Autor autorGuardado = autorRepository.save(autor);
        assertNotNull(autorGuardado);
        assertEquals("Erika55", autorGuardado.getNombre());
        assertEquals("Esperanza55", autorGuardado.getApellido());
    }
    @Test
    public void update(){
        Optional<Autor> autorExistente = autorRepository.findById(50);
        assertTrue(autorExistente.isPresent());

        Autor autor = autorExistente.get();
        autor.setNombre("Erika22");
        autor.setApellido("Esperanza22");
        autor.setPais("Brasil22");
        autor.setDireccion("portugues");
        autor.setTelefono("0987234322");
        autor.setCorreo("jtaipe22@correo.com");

        Autor autorActualizado = autorRepository.save(autor);

        assertNotNull(autorActualizado);
        assertEquals("Erika22", autorActualizado.getNombre());
    }


    @Test
    public void delete(){
        if (autorRepository.existsById(54)){
            autorRepository.deleteById(54);
        }
        assertFalse(autorRepository.existsById(54));
    }

}

