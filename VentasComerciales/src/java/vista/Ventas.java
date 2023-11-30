/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Andres
 */
public class Ventas {
    
    String fecha,comercial,cantidad,descuento,precio,total,totaldescuento;
    

    public Ventas() {
    }

    public Ventas(String fecha, String comercial, String cantidad, String precio ,String descuento, String total, String totaldescuento) {
        this.fecha = fecha;
        this.comercial = comercial;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.precio = precio;
        this.total = total;
        this.totaldescuento = totaldescuento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotaldescuento() {
        return totaldescuento;
    }

    public void setTotaldescuento(String totaldescuento) {
        this.totaldescuento = totaldescuento;
    }

    
    
}
