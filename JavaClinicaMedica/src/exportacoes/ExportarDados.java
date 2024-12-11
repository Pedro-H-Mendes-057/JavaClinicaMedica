package exportacoes;

import controle.ControladorFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
                                endereco.getRua() + ";" +
                                endereco.getNumero() + ";" +                               
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
            Endereco endereco = paciente.getEndereco();
            //System.out.println(arquivo.getAbsolutePath());
            String salvar = paciente.getNome() + ";;" +
                            paciente.getDataNasc() + ";;" +
                            paciente.getContato() + ";;" +
                            paciente.getTipoSang() + ";;" +
                            paciente.getAltura() + ";;" +
                            paciente.getPeso() + ";;" +
                            paciente.getConvenio() + ";;" +
                            endereco.getRua() + ";;" +
                            endereco.getNumero() + ";;" +                            
                            endereco.getBairro() + ";;" +
                            endereco.getCep() + ";;" +
                            endereco.getCidade() + ";;" +
                            endereco.getEstado() + "\n";
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
    
    public static void recuperarPacientes() throws IOException {
        try {
            File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Pacientes.txt");  
            FileReader fR = new FileReader(arquivo);
            String registros = "";
            String [] arrayRegistros;
            int i;
            
            while (true) {
                i = fR.read();
                if (i == -1) break;
                char c = (char) i;
                registros += c;
            }
            
            if (registros.length() != 0) {
                arrayRegistros = registros.split("\n");
                for (String registro : arrayRegistros) {
                    String [] arrayRegistro = registro.split(";;");
                    Paciente paciente = new Paciente(); 
                    Endereco endereco = new Endereco();
                    paciente.setNome(arrayRegistro[0]);
                    paciente.setDataNasc(arrayRegistro[1]);
                    paciente.setContato(arrayRegistro[2]);
                    paciente.setTipoSang(arrayRegistro[3]);
                    paciente.setAltura(Double.parseDouble(arrayRegistro[4]));
                    paciente.setPeso(Double.parseDouble(arrayRegistro[5]));
                    paciente.setConvenio(arrayRegistro[6]);                    
                    endereco.setRua(arrayRegistro[7]);
                    endereco.setNumero(arrayRegistro[8]);                          
                    endereco.setBairro(arrayRegistro[9]);
                    endereco.setCep(arrayRegistro[10]);
                    endereco.setCidade(arrayRegistro[11]);
                    endereco.setEstado(arrayRegistro[12]);
                    paciente.setEndereco(endereco);
                    
                    ControladorFrame.repositorioPacientes.addPaciente(paciente);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Pacientes.txt não encontrado.\nCriando arquivo...");
            File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Pacientes.txt");          
            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ExportarDados.class.getName()).log(Level.SEVERE, null, ex);
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
	                           medico.getValorConsulta();
	           pw.println(salvar);
	       }
	
	       pw.close();
	       fw.close();
	   } catch (IOException e) {
	       System.err.println("Erro ao salvar médicos");
	   }
	}
	
	public static void anexarMedico(Medico medico) {
	   FileWriter fW = null;
	   try {
	       File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Medicos.txt");
	       fW = new FileWriter(arquivo, true);
	       String salvar = medico.getNome() + ";;" +
	                       medico.getEspecialidade() + ";;" +
	                       medico.getCrm() + ";;" +
	                       medico.getContato() + ";;" +
	                       medico.getValorConsulta() + "\n";
	       fW.write(salvar, 0, salvar.length());
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
	
////////////MATERIAIS
	public static void exportarMateriais() {
	   RepositorioMateriais repositorio = new RepositorioMateriais();
	
	   try {
	       FileWriter fw = new FileWriter("Materiais.txt");
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
	
	public static void anexarMaterial(Material material) {
	   FileWriter fW = null;
	   try {
	       File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Materiais.txt");
	       fW = new FileWriter(arquivo, true);
	       String salvar = material.getNome() + ";;" +
	                       material.getQuant() + ";;" +
	                       material.getQuantMin() + ";;" +
	                       material.getFornecedor() + ";;" +
	                       material.getPreco() + "\n";
	       fW.write(salvar, 0, salvar.length());
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

////////////EXAMES
  /*
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   * 
   */

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
