package app.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import app.Utils;

public class CSV {
    public static ArrayList<String[]> lerAlunos() {
        ArrayList<String[]> listaAlunos = new ArrayList<String[]>();
        String separador = ",";
        try (FileReader leitor_arquivo = new FileReader(new File("lib/dados/Alunos.csv"));
                BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);) {
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaAlunos.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaAlunos;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String[]> lerMateria() {
        ArrayList<String[]> listaMateria = new ArrayList<String[]>();
        String separador = ",";
        try (FileReader leitor_arquivo = new FileReader(new File("lib/dados/Materia.csv"));
                BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);) {
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaMateria.add(lista_temporaria);
            }
            return listaMateria;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String[]> lerProfessores() {
        ArrayList<String[]> listaProfessores = new ArrayList<String[]>();
        String separador = ",";
        try (FileReader leitor_arquivo = new FileReader(new File("lib/dados/Professores.csv"));
                BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);) {
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaProfessores.add(lista_temporaria);
            }
            return listaProfessores;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String[]> lerGrade() {
        ArrayList<String[]> listaGrade = new ArrayList<String[]>();
        String separador = ",";
        try (FileReader leitor_arquivo = new FileReader(new File("lib/dados/Grade.csv"));
                BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);) {
            String linha = "";
            String[] lista_temporaria;
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaGrade.add(lista_temporaria);
            }
            return listaGrade;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String[]> lerCompletas() {
        ArrayList<String[]> completas = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File("lib/dados/MateriasFeitas.csv");
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                completas.add(lista_temporaria);
            }
            leitor_buffer.close();
            return completas;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String[]> lerTurmas() {
        ArrayList<String[]> completas = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File("lib/dados/Turmas.csv");
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                completas.add(lista_temporaria);
            }
            leitor_buffer.close();
            return completas;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public static Boolean gravarCompletas(Collection<Aluno> alunos) {
        try {
            FileWriter w = new FileWriter("lib/dados/MateriasFeitas.csv");
            w.write("RA,CURSO,MATERIAS_FEITAS\n");
            w.close();
        } catch (IOException e) {
            return false;
        }

        try {
            FileWriter w = new FileWriter("lib/dados/MateriasFeitas.csv", true);
            for (Aluno a : alunos) {
                Set<Materia> completas = a.getCompletas();
                if (completas.isEmpty()) {
                    continue;
                }

                String linha = a.getRa() + "," + a.getCurso().nomeCurto() + ",\"";
                int tam = completas.size();
                int i = 0;
                for (Materia m : completas) {
                    linha += m.getCodigo();
                    if (i != tam - 1) linha += ",";
                    i++;
                }
                linha += "\"\n";

                w.write(linha);
            }
            w.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static Boolean gravarAlunos(Collection<Aluno> alunos) {
        try {
            FileWriter w = new FileWriter("lib/dados/Alunos.csv");
            w.write("NOME,CPF,DATA_NASCIMENTO,DATA_CADASTRO,CURSO,RA\n");
            w.close();
        } catch (IOException e) {
            return false;
        }

        try {
            FileWriter w = new FileWriter("lib/dados/Alunos.csv", true);
            for (Aluno a : alunos) {
                String linha = a.getNome() + "," + a.getCpf().getValor() + "," + a.getDataNascimento().format(Utils.formatadorPadrao) + "," +
                a.getDataCadastro().format(Utils.formatadorPadrao) + "," + a.getCurso().nomeCurto() + "," + a.getRa() + "\n";
                w.write(linha);
            }
            w.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}