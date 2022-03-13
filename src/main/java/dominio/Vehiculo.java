
package dominio;

public class Vehiculo {
    private int idVehiculo;
    private String marca;
    private String placa;
    private String nombre;

    public Vehiculo() {
    }

    public Vehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehiculo(String marca, String placa, String nombre) {
        this.marca = marca;
        this.placa = placa;
        this.nombre = nombre;
    }

    public Vehiculo(int idVehiculo, String marca, String placa, String nombre) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.placa = placa;
        this.nombre = nombre;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idVehiculo=" + idVehiculo + ", marca=" + marca + ", placa=" + placa + ", nombre=" + nombre + '}';
    }
    
    
}
