package com.distribuida.dao;


import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
=======
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ClienteRepositoryTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;


     @Test
    public void findAll(){
         List<Cliente> clientes = clienteRepository.findAll();
<<<<<<< HEAD
         assertNotNull(clientes);
         assertTrue(clientes.size()>0);
=======
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
         for (Cliente item: clientes){
             System.out.println(item.toString());
         }
     }
<<<<<<< HEAD
     @Test
    public void findOne(){
         Optional<Cliente> cliente = clienteRepository.findById(1);
         assertTrue(cliente.isPresent());
         System.out.println(cliente.toString());
     }

     @Test
    public void save (){
         Cliente cliente = new Cliente(0,"1701234567","Juan","Taipe","Av. por ahi.","0932374862","jtaipe@correo.com");
         Cliente clienteGuardado = clienteRepository.save(cliente);
         assertNotNull(clienteGuardado);
         assertEquals("Juan", clienteGuardado.getNombre());
         assertEquals("Taipe", clienteGuardado.getApellido());
     }

    @Test
    public void update(){
        Optional<Cliente> cliente = clienteRepository.findById(40);
        assertTrue(cliente.isPresent(), "El cliente con id = 40 debería existir");
        cliente.orElse(null).setCedula("1701234562");
        cliente.orElse(null).setNombre("Juan22");
        cliente.orElse(null).setApellido("Taipe2");
        cliente.orElse(null).setDireccion("Av. por ahi.2");
        cliente.orElse(null).setTelefono("0932374822");
        cliente.orElse(null).setCorreo("jtaipe2@correo.com");
        Cliente clienteActualizado = clienteRepository.save(cliente.orElse(null));
        assertNotNull(clienteActualizado);
        assertEquals("Juan22", clienteActualizado.getNombre());
        assertEquals("Taipe2", clienteActualizado.getApellido());

    }
    @Test
    public void delete(){
         if (clienteRepository.existsById(40)){
             clienteRepository.deleteById(40);
         }
         assertFalse(clienteRepository.existsById(40), "El id = 40 deveria haberse eliminado");
    }
=======
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
}
