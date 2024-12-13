package repositorio;

import java.util.ArrayList;
import modelo.Exame;

public class RepositorioExames {
    private ArrayList<Exame> repositorioExames;

    //Construtor
    public RepositorioExames() {
        this.repositorioExames = new ArrayList<>();
    }

    public void addExame(Exame exame) {
        repositorioExames.add(exame);
    }
    
 //cConverter um objeto Exame para String (Para Relatorios)
    public String converterExameParaString(Exame exame) {
        return exame.getTipo() + "," + exame.getDescricao() + "," + exame.getValorParticular() + "," + exame.getMedico();
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
                exameExistente.getMateriaisUsar().equals(exame.getMateriaisUsar()) &&
                exameExistente.getMedico().equals(exame.getMedico())) {
                
                repositorioExames.set(i, exame);
                return; 
            }
        }

        throw new IllegalArgumentException("Exame não encontrado");
    }
}
