import java.util.*;

class SistemaAyudas {
    List<Ayuda> ayudas = new ArrayList<>();

    public void registrarAyuda(Ayuda ayuda) {
        ayudas.add(ayuda);
    }

    public void actualizarEstadoAyuda(Ayuda ayuda, Estado nuevoEstado, Date fechaEntrega) {
        if (nuevoEstado == Estado.ENTREGADO) {
            ayuda.entregar(fechaEntrega);
        } else if (nuevoEstado == Estado.RECHAZADO) {
            ayuda.rechazar();
        }
    }

    public void resumenAyudas() {
        int cantidadEntregadas = 0;
        int cantidadFavorecidos = 0;
        List<String> estudiantesFavorecidos = new ArrayList<>();

        for (Ayuda ayuda : ayudas) {
            if (ayuda.estado == Estado.ENTREGADO) {
                cantidadEntregadas++;
                if (!estudiantesFavorecidos.contains(ayuda.estudiante.codigo)) {
                    estudiantesFavorecidos.add(ayuda.estudiante.codigo);
                    cantidadFavorecidos++;
                }
            }
        }

        System.out.println("Cantidad de ayudas entregadas: " + cantidadEntregadas);
        System.out.println("Número de estudiantes favorecidos: " + cantidadFavorecidos);
    }
}