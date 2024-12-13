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
	public static void recuperarMedicos() throws IOException {
            try {
                File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Medicos.txt");  
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
                        Medico medico = new Medico();                         
                        medico.setNome(arrayRegistro[1]);
                        medico.setEspecialidade(arrayRegistro[2]);
                        medico.setCrm(arrayRegistro[3]);
                        medico.setContato(arrayRegistro[4]);
                        medico.setValorConsulta(Double.parseDouble(arrayRegistro[5]));
                        
                        int [][] horasAtend = new int[11][5];
                        for (int j = 0; j < 11; j++) {
                            for (int k = 0; k < 5; k++) {
                                horasAtend[j][k] = arrayRegistro[6].charAt(j * 5 + k) - '0';
                            }
                            
                        }
                        medico.setHorasAtend(horasAtend);
                        
                        ControladorFrame.repositorioMedicos.recuperarMedico(medico, Integer.parseInt(arrayRegistro[0]));
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Arquivo Medicos.txt não encontrado.\nCriando arquivo...");
                File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Medicos.txt");          
                arquivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ExportarDados.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	public static void anexarMedico(Medico medico, int chaveMedico) {
	   FileWriter fW = null;
	   try {
	       File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Medicos.txt");
	       fW = new FileWriter(arquivo, true);
	       String salvar = chaveMedico + ";;" +
                               medico.getNome() + ";;" +
	                       medico.getEspecialidade() + ";;" +
	                       medico.getCrm() + ";;" +
	                       medico.getContato() + ";;" +
	                       medico.getValorConsulta() + ";;";
               for (int i = 0; i < medico.getHorasAtend().length; i++) {
                  for (int j = 0; j < medico.getHorasAtend()[i].length; j++) {
                      salvar += medico.getHorasAtend()[i][j];
                  }
               }
               salvar += "\n";
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
////////////CONSULTAS
        public static void anexarConsulta(Consulta consulta, String chaveConsulta) {
	   FileWriter fW = null;
	   try {
	       File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Consultas.txt");
	       fW = new FileWriter(arquivo, true);
	       String salvar = chaveConsulta + ";;" +
                               consulta.getPaciente() + ";;" +
	                       consulta.getConvenio() + ";;" +
	                       consulta.getData() + ";;" +
	                       consulta.getQueixa() + ";;" +
	                       consulta.getObservacoes() + ";;" + 
                               consulta.getHora() + ";;" +
                               consulta.getTipoConsulta() + ";;" + 
                               consulta.getMedico() + ";;";
               for (int i = 0; i < consulta.getMateriaisUsar().length; i++) {
                   salvar += consulta.getMateriaisUsar()[i][0] + "<>";
                   salvar += consulta.getMateriaisUsar()[i][1] + "<>";
               }
               salvar += "\n";
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
        
	public static void recuperarConsultas() throws IOException {
            try {
                File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Consultas.txt");  
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
                        Consulta consulta = new Consulta();                         
                        consulta.setPaciente(arrayRegistro[1]);
                        consulta.setConvenio(arrayRegistro[2]);
                        consulta.setObservacoes(arrayRegistro[5]);
                        consulta.setQueixa(arrayRegistro[4]);
                        consulta.setData(arrayRegistro[3]);
                        consulta.setMedico(Integer.parseInt(arrayRegistro[8]));
                        consulta.setHora(arrayRegistro[6]);
                        consulta.setTipoConsulta(arrayRegistro[7]);
                        consulta.setMedico(Integer.parseInt(arrayRegistro[8]));
                        String [] arrayMateriais = arrayRegistro[9].split("<>");
                        System.err.println(arrayMateriais.length);
                        Object[][] chaveMateriais = new Object[arrayMateriais.length - 1][2];
                        
                        for (int j = 0; j < arrayMateriais.length - 1; j++) {
                            chaveMateriais[j][0] = arrayMateriais[j];
                            chaveMateriais[j][1] = arrayMateriais[j + 1]; 
                                                                                    
                        }
                        
                        consulta.setMateriaisUsar(chaveMateriais);
                        
                        ControladorFrame.repositorioConsultas.addConsulta(arrayRegistro[0], consulta);
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("Arquivo Consultas.txt não encontrado.\nCriando arquivo...");
                File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Consultas.txt");          
                arquivo.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ExportarDados.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
        
        public static void atualizarTodasAsConsultas() {
	   FileWriter fW = null;
	   try {
	       File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Consultas.txt");
	       fW = new FileWriter(arquivo);
               String salvar = "";
               for (String chave : ControladorFrame.repositorioConsultas.getConsultas().keySet()) {
                   Consulta consulta = ControladorFrame.repositorioConsultas.getConsulta(chave);
                   salvar += chave + ";;" +
                               consulta.getPaciente() + ";;" +
	                       consulta.getConvenio() + ";;" +
	                       consulta.getData() + ";;" +
	                       consulta.getQueixa() + ";;" +
	                       consulta.getObservacoes() + ";;" + 
                               consulta.getHora() + ";;" +
                               consulta.getTipoConsulta() + ";;" + 
                               consulta.getMedico() + ";;";
                    for (int i = 0; i < consulta.getMateriaisUsar().length; i++) {
                        salvar += consulta.getMateriaisUsar()[i][0] + "<>";
                        salvar += consulta.getMateriaisUsar()[i][1] + "<>";
                    }
                    salvar += "\n";	       
               }              
	       
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
        public static void atualizarTodosOsMateriais() {
	   FileWriter fW = null;
	   try {
	       File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Materiais.txt");
	       fW = new FileWriter(arquivo);
               String salvar = "";
               for (int i = 0; i < ControladorFrame.repositorioMateriais.getMateriais().size(); i++) {
                    Material material = ControladorFrame.repositorioMateriais.getMateriais().get(i);
                    salvar += material.getNome() + ";;" +
                              material.getQuant() + ";;" +
                              material.getQuantMin() + ";;" +
                              material.getFornecedor() + ";;" +
                              material.getPreco() + ";;" +
                              material.getUtilizado() + "\n";
                }              
	       
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
        
	public static void anexarMaterial(Material material) {
	   FileWriter fW = null;
	   try {
	       File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Materiais.txt");
	       fW = new FileWriter(arquivo, true);
	       String salvar = material.getNome() + ";;" +
	                       material.getQuant() + ";;" +
	                       material.getQuantMin() + ";;" +
	                       material.getFornecedor() + ";;" +
	                       material.getPreco() + ";;" + 
                               material.getUtilizado() + "\n";
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
        
        public static void recuperarMateriais() throws IOException {
        try {
            File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Materiais.txt");  
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
                    Material material = new Material();
                    material.setNome(arrayRegistro[0]);
                    material.setQuant(Integer.parseInt(arrayRegistro[1]));
                    material.setQuantMin(Integer.parseInt(arrayRegistro[2]));
                    material.setFornecedor(arrayRegistro[3]); 
                    material.setPreco(arrayRegistro[4]);
                    material.setUtilizado(Boolean.parseBoolean(arrayRegistro[5]));
                    
                    ControladorFrame.repositorioMateriais.addMaterial(material);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Materiais.txt não encontrado.\nCriando arquivo...");
            File arquivo = new File("src" + File.separator + "exportacoes" + File.separator, "Materiais.txt");          
            arquivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ExportarDados.class.getName()).log(Level.SEVERE, null, ex);
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
