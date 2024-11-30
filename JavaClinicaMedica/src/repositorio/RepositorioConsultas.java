package repositorio;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import modelo.Consulta;

public class RepositorioConsultas {
    static String chave; 
    LinkedHashMap<Integer, Consulta> repositorioConsultas;
    
    
    public RepositorioConsultas() {        
        this.repositorioConsultas = new LinkedHashMap<>();        
    }
    
     public void addEconsulta(Consulta consulta) {
         
        //repositorioConsultas.put(, consulta);
    }
    
    public LinkedHashMap<Integer, Consulta> getConsultas() {
        return this.repositorioConsultas;
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
