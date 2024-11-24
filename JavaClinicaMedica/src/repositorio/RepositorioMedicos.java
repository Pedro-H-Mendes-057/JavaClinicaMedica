package repositorio;

/*import java.util.ArrayList; */
import modelo.Medico;
import java.util.LinkedHashMap;

public class RepositorioMedicos {
    static int contador = 0; 
    LinkedHashMap<Integer, Medico> repositorioMedicos;
    String [] nomesMedicos;
    
    public RepositorioMedicos() {        
        this.repositorioMedicos = new LinkedHashMap<>();        
    }
    
     public void addMedico(Medico medico) {
        repositorioMedicos.put(RepositorioMedicos.contador, medico);
        RepositorioMedicos.contador++;
    }
    
    public LinkedHashMap<Integer, Medico> getMedicos() {
        return this.repositorioMedicos;
    }
    
    public String[] getNomesMedicos() {
    	this.nomesMedicos = new String[this.repositorioMedicos.size()];
        int cont = 0;
    	
        for (Integer chave : this.repositorioMedicos.keySet()) {            
               this.nomesMedicos[cont++] = this.repositorioMedicos.get(chave).getNome();            
        }
    	
    	return this.nomesMedicos;
    }
     
    /*private ArrayList<Medico> repositorioMedicos;
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
    }*/
}
