package repositorio;

import java.util.ArrayList;
import modelo.Medico;

public class RepositorioMedicos {
    private ArrayList<Medico> repositorioMedicos;

    // Construtor
    public RepositorioMedicos() {
        this.repositorioMedicos = new ArrayList<>();
    }

    public void addMedico(Medico medico) {
        repositorioMedicos.add(medico);
    }

    public ArrayList<Medico> getMedicos() {
        return this.repositorioMedicos;
    }
}
