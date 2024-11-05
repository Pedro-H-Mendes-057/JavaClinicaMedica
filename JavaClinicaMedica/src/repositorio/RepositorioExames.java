package repositorio;

import java.util.ArrayList;
import modelo.Exame;

public class RepositorioExames {
    private ArrayList<Exame> repositorioExames;

    // Construtor
    public RepositorioExames() {
        this.repositorioExames = new ArrayList<>();
    }

    public void addExame(Exame exame) {
        repositorioExames.add(exame);
    }

    public ArrayList<Exame> getListaExames() {
        return this.repositorioExames;
    }
}
