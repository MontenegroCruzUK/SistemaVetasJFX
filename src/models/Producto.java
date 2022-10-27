package models;

/**
 *
 * @author montenegro
 */
public class Producto {

    private int id;
    private int codigo;
    private String descripcion;
    private String proveedor;
    private int stock;
    private double precio;

    public Producto() {
    }

    public Producto(int id, int codigo, String descripcion, String proveedor, int stock, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
