package com.distribuida.model;

<<<<<<< HEAD
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private int idFactura;
    @Column(name = "num_factura")
    private String numFactura;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "total_neto")
    private Double totalNeto;
    @Column(name = "iva")
    private Double iva;
    @Column(name = "total")
    private Double total;

    // patron de inyección de independencias
    @ManyToOne
    @JoinColumn(name = "factura")
=======
import java.util.Date;

public class Factura {

    private int idFactura;
    private String numFactura;
    private Date fecha;
    private Double totalNeto;
    private Double iva;
    private Double total;

    // patron de inyección de independencias
>>>>>>> e81cf4bca0f466b65687c118f540721cf99b4f8c
    private Cliente cliente;

    public Factura() {
    }

    public Factura(int idFactura, String numFactura, Date fecha, Double totalNeto, Double iva, Double total, Cliente cliente) {
        this.idFactura = idFactura;
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.totalNeto = totalNeto;
        this.iva = iva;
        this.total = total;
        this.cliente = cliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(Double totalNeto) {
        this.totalNeto = totalNeto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", numFactura='" + numFactura + '\'' +
                ", fecha=" + fecha +
                ", totalNeto=" + totalNeto +
                ", iva=" + iva +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
