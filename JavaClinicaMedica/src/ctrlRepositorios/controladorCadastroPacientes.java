package ctrlRepositorios;

import repositorio.RepositorioPacientes;
import modelo.Endereco;
import modelo.Paciente;

public class controladorCadastroPacientes {
    private RepositorioPacientes repositorioPacientes;

    public controladorCadastroPacientes() {
        this.repositorioPacientes = new RepositorioPacientes();
    }

    public void cadastrarNovoPaciente(String nome, String dataNasc, String contato, String tipoSang,
    								  int altura, double peso, String convenio, Endereco endereco) {
        Paciente paciente = new Paciente(nome, dataNasc, contato, tipoSang, altura, peso, null, convenio, endereco);
        repositorioPacientes.addPaciente(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void exibirPacientes() {
        for (Paciente p : repositorioPacientes.getListaPacientes()) {
            System.out.println("Nome: " + p.getNome());
        }
    }
}
