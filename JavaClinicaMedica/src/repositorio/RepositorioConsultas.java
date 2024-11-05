package repositorio;

import java.util.ArrayList;
import modelo.Consulta;

public class RepositorioConsultas {
    private ArrayList<Consulta> repositorioConsultas;

    // Construtor
    public RepositorioConsultas() {
        this.repositorioConsultas = new ArrayList<>();
    }

    public void addConsulta(Consulta consulta) {
        repositorioConsultas.add(consulta);
    }

    public ArrayList<Consulta> getListaConsultas() {
        return this.repositorioConsultas;
    }
}
