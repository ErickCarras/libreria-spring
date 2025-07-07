package com.distribuida.dao;

import com.distribuida.model.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class LibroRepositoryTestIntegracion {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository ;

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void finAll(){
        List<Libro> libros = libroRepository.findAll();
        assertNotNull(libros);
        assertTrue(libros.size()>0);
        for(Libro item: libros){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Libro> libro = libroRepository.findById(82);
        assertNotNull(libro);
        assertEquals("Cien años de soledad", libro.orElse(null).getTitulo());
        System.out.println(libro.toString());

    }


    @Test
    public void save(){
        Optional<Categoria> categoria = categoriaRepository.findById(1);
        Optional<Autor> autor = autorRepository.findById(1);
        assertTrue(categoria.isPresent());
        Libro libro = new Libro();
        libro.setIdLibro(0);
        libro.setTitulo("Cien años de soledad");
        libro.setEditorial("Sudamericana");
        libro.setNumPaginas(417);
        libro.setEdicion("Primera");
        libro.setIdioma("Español");
        libro.setFechaPublicacion(LocalDate.parse("1967-01-01"));
        libro.setDescripcion("Novela emblemática del realismo mágico.");
        libro.setTipoPasta("Dura");
        libro.setIsbn("978-3-16-148410-0");
        libro.setNumEjemplares(10);
        libro.setPortada("");
        libro.setPresentacion("Tapa dura con sobrecubierta");
        libro.setPrecio(19.99);

        libro.setCategoria(categoria.orElse(null));
        libro.setAutor(autor.orElse(null));

        Libro libroGuardado = libroRepository.save(libro);
        assertNotNull(libroGuardado);
        assertEquals("Cien años de soledad", libroGuardado.getTitulo());
        assertEquals(19.99, libroGuardado.getPrecio());
    }

    @Test
    public void update(){
        Optional<Libro> libroExistente = libroRepository.findById(81);
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(2);
        Optional<Autor> autorExistente = autorRepository.findById(2);

        assertTrue(libroExistente.isPresent());
        assertTrue(categoriaExistente.isPresent());
        assertTrue(autorExistente.isPresent());

        Libro libro = libroExistente.get();

        libroExistente.orElse(null).setTitulo("Luna");
        libroExistente.orElse(null).setEditorial("Española");
        libroExistente.orElse(null).setNumPaginas(350);
        libroExistente.orElse(null).setEdicion("Primera");
        libroExistente.orElse(null).setIdioma("Español");
        libroExistente.orElse(null).setFechaPublicacion(LocalDate.parse("2024-01-01"));
        libroExistente.orElse(null).setDescripcion("Novela ficticia ");
        libroExistente.orElse(null).setTipoPasta("Dura");
        libroExistente.orElse(null).setIsbn("674-3-16-148410-0");
        libroExistente.orElse(null).setNumEjemplares(12);
        libroExistente.orElse(null).setPortada("portada.jpg");
        libroExistente.orElse(null).setPresentacion("Tapa suave con sobrecubierta");
        libroExistente.orElse(null).setPrecio(22.99);
        libroExistente.orElse(null).setCategoria(categoriaExistente.orElse(null));
        libroExistente.orElse(null).setAutor(autorExistente.orElse(null));

        Libro libroActualizado = libroRepository.save(libro);

        assertNotNull(libroActualizado);
        assertEquals("Luna", libroActualizado.getTitulo());
    }

    @Test
    public void delete(){
        if (libroRepository.existsById(79)){
            libroRepository.deleteById(79);
        }
        assertFalse(libroRepository.existsById(79));
    }

}

