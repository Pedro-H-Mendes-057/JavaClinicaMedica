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

    public ArrayList<Exame> getExames() {
        return this.repositorioExames;
    }
    
    public void atualizarExame(Exame exame) {
        for (int i = 0; i < repositorioExames.size(); i++) {
            Exame exameExistente = repositorioExames.get(i);
            
            if (exameExistente.getNomeExame().equals(exame.getNomeExame()) &&
                exameExistente.getDescricao().equals(exame.getDescricao()) &&
                exameExistente.getTipo().equals(exame.getTipo()) &&
                exameExistente.getValorParticular() == exame.getValorParticular() &&
                exameExistente.getMateriasUsar().equals(exame.getMateriasUsar()) &&
                exameExistente.getMedico().equals(exame.getMedico())) {
                
                repositorioExames.set(i, exame);
                return; 
            }
        }

        throw new IllegalArgumentException("Exame não encontrado para atualização.");
    }
}
