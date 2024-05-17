import java.util.Date;
class Ayuda {
    Estudiante estudiante;
    TipoAyuda tipoAyuda;
    Estado estado;
    Date fechaAsignacion;
    Date fechaEntrega;

    public Ayuda(Estudiante estudiante, TipoAyuda tipoAyuda, Date fechaAsignacion) {
        this.estudiante = estudiante;
        this.tipoAyuda = tipoAyuda;
        this.fechaAsignacion = fechaAsignacion;
        this.estado = Estado.ASIGNADO;
    }

    public void entregar(Date fechaEntrega) {
        this.estado = Estado.ENTREGADO;
        this.fechaEntrega = fechaEntrega;
    }

    public void rechazar() {
        this.estado = Estado.RECHAZADO;
    }
}