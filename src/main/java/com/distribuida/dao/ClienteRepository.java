package com.distribuida.dao;

import com.distribuida.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Repository;
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c


//@Repository //es un bean para gestionar persistencia con jpa
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

<<<<<<< HEAD
    Cliente findByCedula(String cedula);

=======
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c

}


