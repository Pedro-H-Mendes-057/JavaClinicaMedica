package repositorio;

import java.util.ArrayList;
import modelo.Paciente;

public class RepositorioPacientes {
    private ArrayList<Paciente> listaPacientes;

    // Construtor que inicializa a lista de pacientes
    public RepositorioPacientes() {
        this.listaPacientes = new ArrayList<>();
    }

    // Método para adicionar um paciente
    public void addPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    // Método opcional para retornar a lista de pacientes
    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }
}
