package com.distribuida.model;

<<<<<<< HEAD
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria") // Asegúrate que coincida con tu columna real
    private int idCategoria;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "descripcion")
    private String descripcion;

    // Constructor vacío obligatorio para JPA
    public Categoria() {}

    // Constructor con parámetros
=======
public class Categoria {

    private int idCategoria;
    private String categoria;
    private String descripcion;

    public Categoria() {}

>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
    public Categoria(int idCategoria, String categoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

<<<<<<< HEAD
    // Getters y setters
=======
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", categoria='" + categoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
=======
        return "Categoria [idCategoria=" + idCategoria + ", categoria=" + categoria + ", descripcion=" + descripcion
                + "]";
    }



}
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
