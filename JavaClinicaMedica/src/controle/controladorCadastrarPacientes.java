package controle;

import repositorio.RepositorioPacientes;
import modelo.Endereco;
import modelo.Paciente;

public class controladorCadastrarPacientes {
    private RepositorioPacientes repositorioPacientes;

    public controladorCadastrarPacientes() {
        this.repositorioPacientes = new RepositorioPacientes();
    }

    public void cadastrarNovoPaciente(String nome, String dataNasc, String contato, String tipoSang,
    								  int altura, double peso, String convenio, Endereco endereco) {
        Paciente paciente = new Paciente(nome, dataNasc, contato, tipoSang, altura, peso, null, convenio, endereco);
        repositorioPacientes.addPaciente(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void exibirPacientes() {
        for (Paciente p : repositorioPacientes.getPacientes()) {
            System.out.println("Nome: " + p.getNome());
        }
    }
}
