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
public class FacturaDetalleRepositoryTestIntegracion {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Test
    public void finAll() {
        List<FacturaDetalle> facturaDetalles = facturaDetalleRepository.findAll();
        assertNotNull(facturaDetalles);
        assertTrue(facturaDetalles.size() > 0);
        for (FacturaDetalle item : facturaDetalles) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {
        Optional<FacturaDetalle> facturaDetalle = facturaDetalleRepository.findById(206);
        assertNotNull(facturaDetalle);
        assertEquals(3, facturaDetalle.orElse(null).getCantidad());
        System.out.println(facturaDetalle.toString());

    }


    @Test
    public void save(){
        Optional<Factura> factura = facturaRepository.findById(1);
        Optional<Libro> libro = libroRepository.findById(1);
        assertTrue(factura.isPresent());

        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setIdFacturaDetalle(0);
        facturaDetalle.setCantidad(5);
        facturaDetalle.setSubtotal(10.4);

        facturaDetalle.setAutor(factura.orElse(null));
        facturaDetalle.setLibro(libro.orElse(null));

        FacturaDetalle facturaDetalleGuardado = facturaDetalleRepository.save(facturaDetalle);
        assertNotNull(facturaDetalleGuardado);
        assertEquals(5, facturaDetalleGuardado.getCantidad());
        assertEquals(10.4, facturaDetalleGuardado.getSubtotal());
    }


    @Test
    public void update(){
        Optional<FacturaDetalle> facturaDetalleExistente = facturaDetalleRepository.findById(210);
        Optional<Factura> facturaExistente = facturaRepository.findById(2);
        Optional<Libro> libroExistente = libroRepository.findById(2);

        assertTrue(libroExistente.isPresent());
        assertTrue(facturaDetalleExistente.isPresent());
        assertTrue(facturaExistente.isPresent());

        FacturaDetalle facturaDetalle = facturaDetalleExistente.get();

        facturaDetalleExistente.orElse(null).setCantidad(6);
        facturaDetalleExistente.orElse(null).setSubtotal(13.99);

        facturaDetalleExistente.orElse(null).setAutor(facturaExistente.orElse(null));
        facturaDetalleExistente.orElse(null).setLibro(libroExistente.orElse(null));

        FacturaDetalle facturaDetalleActualizado = facturaDetalleRepository.save(facturaDetalle);

        assertNotNull(facturaDetalleActualizado);
        assertEquals(6, facturaDetalleActualizado.getCantidad());
    }

    @Test
    public void delete(){
        if (facturaDetalleRepository.existsById(210)){
            facturaDetalleRepository.deleteById(210);
        }
        assertFalse(facturaRepository.existsById(210));
    }

}

