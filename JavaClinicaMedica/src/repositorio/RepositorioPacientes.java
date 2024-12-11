package repositorio;

import java.util.ArrayList;

import modelo.Material;
import modelo.Paciente;

public class RepositorioPacientes {
    private ArrayList<Paciente> repositorioPacientes;
    // Construtor
    public RepositorioPacientes() {
        this.repositorioPacientes = new ArrayList<>();
    }

    public void addPaciente(Paciente paciente) {
        repositorioPacientes.add(paciente);
    }
    
    public void atualizarPaciente(Paciente pacienteAtualizado) {
        for (int i = 0; i < repositorioPacientes.size(); i++) {
            Paciente pacienteExistente = repositorioPacientes.get(i);
            
            if (pacienteExistente.getNome().equalsIgnoreCase(pacienteAtualizado.getNome())) {
                pacienteExistente.setAltura(pacienteAtualizado.getAltura());
                pacienteExistente.setPeso(pacienteAtualizado.getPeso());
                pacienteExistente.setConvenio(pacienteAtualizado.getConvenio());
                pacienteExistente.setEndereco(pacienteAtualizado.getEndereco());
                return; // Se encontrar e atualizar, para a busca
            }
        }
    }

    public ArrayList<Paciente> getPacientes() {
        return this.repositorioPacientes;
    }
}
