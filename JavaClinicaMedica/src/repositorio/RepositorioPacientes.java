package repositorio;

import java.util.ArrayList;
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

    public ArrayList<Paciente> getPacientes() {
        return this.repositorioPacientes;
    }
}
