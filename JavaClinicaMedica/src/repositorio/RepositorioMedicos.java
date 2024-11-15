package repositorio;

import java.util.ArrayList;
import modelo.Medico;

public class RepositorioMedicos {
    private ArrayList<Medico> repositorioMedicos;
    private String[] nomesMedicos;

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
    
    public String[] getNomesMedicos() {
    	this.nomesMedicos = new String[this.repositorioMedicos.size()];
    	for(int i = 0; i < this.repositorioMedicos.size(); i++) {
    		this.nomesMedicos[i] = this.repositorioMedicos.get(i).getNome();
    	}
    	
    	return this.nomesMedicos;
    }
}
