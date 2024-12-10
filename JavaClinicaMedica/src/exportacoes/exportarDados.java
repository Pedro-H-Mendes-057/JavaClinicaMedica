package exportacoes;

import repositorio.RepositorioPacientes;
import repositorio.RepositorioMedicos;
import modelo.Paciente;
import modelo.Medico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class exportarDados {

    //////////// PACIENTES
    public static void exportarPacientes() {
        RepositorioPacientes repositorio = new RepositorioPacientes();

        try {
    		FileWriter fw = new FileWriter("PacientesLOL.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < repositorio.getPacientes().size(); i++) {
                Paciente paciente = repositorio.getPacientes().get(i);
                String salvar = paciente.getNome() + ";" +
                                paciente.getDataNasc() + ";" +
                                paciente.getContato() + ";" +
                                paciente.getTipoSang() + ";" +
                                paciente.getAltura() + ";" +
                                paciente.getPeso();
                pw.println(salvar);
                pw.flush();
            }

            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar paciente");
        }
    }

////////////MÉDICOS
	
    
}
