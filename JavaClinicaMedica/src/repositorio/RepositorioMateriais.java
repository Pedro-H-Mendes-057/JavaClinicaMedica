/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.util.ArrayList;
import modelo.Material;

public class RepositorioMateriais {
    private ArrayList<Material> repositorioMateriais;
    
    
    
    public RepositorioMateriais() {
        this.repositorioMateriais = new ArrayList<Material>();
    }    
    
    public void addMaterial(Material material) {
        this.repositorioMateriais.add(material);
    }
    
    public ArrayList<Material> getMateriais() {       
        return this.repositorioMateriais;
    }
    
    public boolean buscarMaterial(String nomeMaterial) {
        for (int i = 0; i < getMateriais().size(); i++) {
            if (getMateriais().get(i).getNome().equalsIgnoreCase(nomeMaterial)) {
                return true; 
            }
        }
        
        return false;
    }
}
