package com.distribuida.model;

<<<<<<< HEAD
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "factura_detalle")

public class FacturaDetalle {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_factura_detalle")
    private int idFacturaDetalle;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "subtotal")
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;


    // Constructor vacío
    public FacturaDetalle() {
    }

    public FacturaDetalle(int idFacturaDetalle, int cantidad, double subtotal, Libro libro, Factura factura) {
=======
public class FacturaDetalle {


    private int idFacturaDetalle;
    private int cantidad;
    private double subtotal;

    private Factura factura; //private int idFactura
    private Libro libro; // private int idLibro

    public FacturaDetalle() {}

    public FacturaDetalle(int idFacturaDetalle, int cantidad, double subtotal) {
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
        this.idFacturaDetalle = idFacturaDetalle;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.factura = factura;
        this.libro = libro;
    }

    public int getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(int idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

<<<<<<< HEAD
    public void setAutor(Factura factura) {
        this.factura = factura;
    }

=======
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
    public Factura getFactura() {
        return factura;
    }

<<<<<<< HEAD
    public void setLibro(Libro libro) {
        this.libro = libro;
=======
    public void setFactura(Factura factura) {
        this.factura = factura;
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
    }

    public Libro getLibro() {
        return libro;
    }

<<<<<<< HEAD
=======
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
    @Override
    public String toString() {
        return "FacturaDetalle [idFacturaDetalle=" + idFacturaDetalle + ", cantidad=" + cantidad + ", subtotal="
                + subtotal + ", factura=" + factura + ", libro=" + libro + "]";
<<<<<<< HEAD
         }

     }
=======
    }
}
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
