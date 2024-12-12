package repositorio;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import modelo.Consulta;

public class RepositorioConsultas {
    static String chave; 
    LinkedHashMap<String, Consulta> repositorioConsultas;   
    // LinkedHashMap<String, String> repositorioConsultas;
    
    public RepositorioConsultas() {        
        this.repositorioConsultas = new LinkedHashMap<>();        
    }
    
    //TESTE
    /*public void addConsulta(String chave, String consulta) {         
        repositorioConsultas.put(chave, consulta);
    } */
    
    // Esta sera usada depois:    <-------
    public void addConsulta(String chave, Consulta consulta) {         
        repositorioConsultas.put(chave, consulta);
    } 
    
    public LinkedHashMap<String, Consulta> getConsultas() {
        return this.repositorioConsultas;
    }
    
    public boolean procurarConsulta(String chave) {
        if (this.repositorioConsultas.get(chave) == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public Consulta getConsulta(String chave) {
        return this.repositorioConsultas.get(chave);     
    }
    
    /*private ArrayList<Consulta> repositorioConsultas;

    // Construtor
    public RepositorioConsultas() {
        this.repositorioConsultas = new ArrayList<>();
    }

    public void addConsulta(Consulta consulta) {
        repositorioConsultas.add(consulta);
    }

    public ArrayList<Consulta> getListaConsultas() {
        return this.repositorioConsultas;
    } */
}
