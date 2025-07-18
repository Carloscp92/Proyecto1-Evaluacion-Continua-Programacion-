public class Cliente {

private String nombre;
private String dni;
private String telefono;
private String email;


public Cliente(String nombre, String dni, String telefono, String email){
    this.nombre= nombre;
    this.dni= dni;
    this.telefono= telefono;
    this.email= email;
    }

    public String toString(){
    return "\nNombre: " + this.nombre  + "\nDni: " + this.dni+ " \nTelefono: " + this.telefono+ "\nEmail: "+ this.email;
    }
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
