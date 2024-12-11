package exportacoes;

import java.io.File;
import repositorio.RepositorioPacientes;
import repositorio.RepositorioConsultas;
import repositorio.RepositorioExames;
import repositorio.RepositorioMateriais;
import repositorio.RepositorioMedicos;
import modelo.Paciente;
import modelo.Endereco;
import modelo.Exame;
import modelo.Material;
import modelo.Medico;
import modelo.Consulta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExportarDados {

    //////////// PACIENTES
    public static void exportarPacientes() {
        RepositorioPacientes repositorio = new RepositorioPacientes();

        try {
    		FileWriter fw = new FileWriter("PacientesLOL.txt");
                PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < repositorio.getPacientes().size(); i++) {
                Paciente paciente = repositorio.getPacientes().get(i);
                Endereco endereco = paciente.getEndereco();
                String salvar = paciente.getNome() + ";" +
                                paciente.getDataNasc() + ";" +
                                paciente.getContato() + ";" +
                                paciente.getTipoSang() + ";" +
                                paciente.getAltura() + ";" +
                                paciente.getPeso() + ";" +
                                endereco.getLogradouro() + ";" +
                                endereco.getNumero() + ";" +
                                endereco.getComplemento() + ";" +
                                endereco.getBairro() + ";" +
                                endereco.getCep() + ";" +
                                endereco.getCidade() + ";" +
                                endereco.getEstado();
                pw.println(salvar);
                //pw.flush();
            }

            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar paciente");
        }
    }
    
    public static void anexarPaciente(Paciente paciente) {
        FileWriter fW = null;
        try {
            File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Pacientes.txt");          
            fW = new FileWriter(arquivo, true); // para anexar paciente
            System.out.println(arquivo.getAbsolutePath());
            String salvar = paciente.getNome() + ";" +
                            paciente.getDataNasc() + ";" +
                            paciente.getContato() + ";" +
                            paciente.getTipoSang() + ";" +
                            paciente.getAltura() + ";" +
                            paciente.getPeso() + ";";
            fW.write(salvar, 0, salvar.length());
            //System.out.println(salvar);
        } catch (IOException ex) {
            Logger.getLogger(ExportarDados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fW.close();
            } catch (IOException ex) {
                Logger.getLogger(ExportarDados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

////////////MÉDICOS
    public static void exportarMedicos() {
        RepositorioMedicos repositorio = new RepositorioMedicos();

        try {
            FileWriter fw = new FileWriter("MedicosLOL.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < repositorio.getMedicos().size(); i++) {
                Medico medico = repositorio.getMedicos().get(i);
                String salvar = medico.getNome() + ";" +
                                medico.getEspecialidade() + ";" +
                                medico.getCrm() + ";" +
                                medico.getContato() + ";" +
                                //Arrays.toString(medico.getHorasAtend()) + ";" + //AAAAAAAA COMO Q RESOLVE ISSSOOOOO
                                medico.getValorConsulta();
                pw.println(salvar);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar médicos");
        }
    }

////////////MATERIAIS
    public static void exportarMateriais() {
        RepositorioMateriais repositorio = new RepositorioMateriais();

        try {
            FileWriter fw = new FileWriter("MateriaisLOL.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < repositorio.getMateriais().size(); i++) {
                Material material = repositorio.getMateriais().get(i);
                String salvar = material.getNome() + ";" +
                                material.getQuant() + ";" +
                                material.getQuantMin() + ";" +
                                material.getFornecedor() + ";" +
                                material.getPreco();
                pw.println(salvar);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar materiais");
        }
    }

////////////EXAMES
    public static void exportarExames() {
        RepositorioExames repositorio = new RepositorioExames();

        try {
            FileWriter fw = new FileWriter("ExamesLOL.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < repositorio.getExames().size(); i++) {
                Exame exame = repositorio.getExames().get(i);
                String salvar = exame.getNomeExame() + ";" +
                                exame.getDescricao() + ";" +
                                exame.getTipo() + ";" +
                                exame.getValorParticular() + ";" +
                                exame.getMateriasUsar().toString() + ";" +
                                exame.getMedico().getNome();
                pw.println(salvar);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar exames");
        }
    }

////////////CONSULTAS
   /* public static void exportarConsultas() {
        RepositorioConsultas repositorio = new RepositorioConsultas();

        try {
            FileWriter fw = new FileWriter("ConsultasLOL.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (int i = 0; i < repositorio.getConsultas().size(); i++) {
                Consulta consulta = repositorio.getConsultas().get(i); //Consulta é um LinkedHashMap
                String salvar = consulta.getData() + ";" +
                                consulta.getHora() + ";" +
                                consulta.getMedico() + ";" +
                                consulta.getPaciente() + ";" +
                                consulta.getQueixa() + ";" +
                                consulta.getTipoConsulta() + ";" +
                                consulta.getConvenio() + ";" +
                                consulta.getObservacoes() + ";" +
                                //.toString(consulta.getMateriaisUsar());  //criar um for pra resolver isso
                pw.println(salvar);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar consultas");
        }
    } */

    
}
