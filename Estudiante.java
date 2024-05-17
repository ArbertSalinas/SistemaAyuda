import java.util.Date;

class Estudiante {
    String codigo;
    String documento;
    TipoDocumento tipoDocumento;
    String nombre;
    String apellido;
    Date fechaNacimiento;
    int estrato;
    String email;

    public Estudiante(String codigo, String documento, TipoDocumento tipoDocumento, String nombre, String apellido, Date fechaNacimiento, int estrato, String email) {
        this.codigo = codigo;
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.estrato = estrato;
        this.email = email;
    }
}
