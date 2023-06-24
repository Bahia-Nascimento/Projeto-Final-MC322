package app.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {
    public ArrayList<String[]> lerAlunos() {
        ArrayList<String[]> listaAlunos = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File("lib/dados/Alunos.csv");
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaAlunos.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaAlunos;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

     public ArrayList<String[]> lerMateria() {
        ArrayList<String[]> listaMateria = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File("lib/dados/Materia.csv");
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaMateria.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaMateria;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public ArrayList<String[]> lerProfessores() {
        ArrayList<String[]> listaProfessores = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File("lib/dados/Professores.csv");
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaProfessores.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaProfessores;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public ArrayList<String[]> lerGrade() {
        ArrayList<String[]> listaGrade = new ArrayList<String[]>();
        String separador =",";
        try{
            File file = new File("lib/dados/Grade.csv");
            FileReader leitor_arquivo = new FileReader(file);
            BufferedReader leitor_buffer = new BufferedReader(leitor_arquivo);
            String linha = "";
            String[] lista_temporaria;
            leitor_buffer.readLine();
            while ((linha = leitor_buffer.readLine()) != null) {
                lista_temporaria = linha.split(separador);
                listaGrade.add(lista_temporaria);
            }
            leitor_buffer.close();
            return listaGrade;
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
}
