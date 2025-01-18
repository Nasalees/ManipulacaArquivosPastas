package com.nathalia.cursojavaintermediario.ManipulacaoDeArquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.nathalia.cursojavaintermediario.ManipulacaoDeArquivos.Entites.Aluno;

public class ArquivoAluno {
	static Scanner sc = new Scanner(System.in);
	static List<Aluno> alunos = new ArrayList<>();
	static List<String> nomeArquivosList = new ArrayList<>();
	static int nomeAqruivo = 0;
	
	public static void main(String[] args) {
		menu();		
	}
	
	public static void criarArquivoAluno(String nome, int matricula, String arquivoString) {
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoString))){
			bw.write(nome);
			bw.newLine();
			bw.write(matricula);
			
			alunos.add(new Aluno(nome, matricula));
		}catch(IOException e) {
			System.out.println("Não foi possível criar o arquivo: "  + e.getMessage());
		}
	}
	
	public static String gerarNomeArquivo() {
		
		Random gerador = new Random();
		int novoNumero = gerador.nextInt(100);
		do {
			if(novoNumero < 20) {
				String novoArquivo =  novoNumero + "A";
				if(!nomeArquivosList.contains(novoArquivo)) {
					nomeArquivosList.add(novoArquivo);
					return novoArquivo;
				}
				
			}else if(novoNumero < 50) {
				String novoArquivo =  novoNumero + "B";
				if(!nomeArquivosList.contains(novoArquivo)) {
					nomeArquivosList.add(novoArquivo);
					return novoArquivo;
				}
			}else if(novoNumero < 70) {
				String novoArquivo =  novoNumero + "C";
				if(!nomeArquivosList.contains(novoArquivo)) {
					nomeArquivosList.add(novoArquivo);
					return novoArquivo;
				}
			}else {
				String novoArquivo =  novoNumero + "D";
				if(!nomeArquivosList.contains(novoArquivo)) {
					nomeArquivosList.add(novoArquivo);
					return novoArquivo;
			}
		  }
		}while(!nomeArquivosList.contains(novoNumero));
		
		return null;
	}
	
	public static void moverArquivoTurma(String caminhoOrigem, String turmaString) {
	
		String separador = "\\\\";
		String letra = "";

		String[] s = caminhoOrigem.split(separador); // C:\Users\nasal\Downloads\turmas\26B.txt
  		String[] a = s[5].split("\\.");
  		String turma = a[0];
		
		if(turma.endsWith("A")) {
			letra = "A";
		}else if(turma.endsWith("B")) {
			letra = "B";
		}else if(turma.endsWith("C")) {
			letra = "C";
		}else if(turma.endsWith("D")) {
			letra = "D";
		}
		
		String novoDiretorio = turmaString + "\\turma(" + letra + ")";
		File diretorioFinal = new File(novoDiretorio);
		
		if(!diretorioFinal.exists()) {
			boolean criado = diretorioFinal.mkdirs();
		}
		
		File arquivoOrigem = new File(caminhoOrigem);
		File arquivoDestino = new File (diretorioFinal + "\\" + arquivoOrigem.getName());
		
		boolean movido = arquivoOrigem.renameTo(arquivoDestino);
		
		if(movido) {
			System.out.println("Arquivo movido para o diretório: " + arquivoDestino);
		}
		
	}
	
	public static void menu() {
		
		String caminhoGeral = "C:\\Users\\nasal\\Downloads"; //C:\Users\nasal\Downloads
		String turmaString = caminhoGeral + "\\turmas"; //C:\Users\nasal\Downloads\turmas
		File turma = new File(turmaString); //C:\Users\nasal\Downloads\turmas
		if(!turma.exists()) {
			boolean diretorioCriado = turma.mkdirs();
		}
		
		String nomeArquivoInt = gerarNomeArquivo();
		String arquivoString = turma + "\\" + nomeArquivoInt + ".txt"; //C:\Users\nasal\Downloads\turmas\26B.txt
		File nomeArquivo = new File(arquivoString); //C:\Users\nasal\Downloads\turmas\26B.txt
		
		
		
		System.out.println("Digite o que deseja fazer");
		System.out.println("1.CRIAR UM ARQUIVO PARA ALUNO E MOVER PARA O DIRETÓRIO CORRETO");
		System.out.println("3.SAIR");
		int opcoes = sc.nextInt();
		sc.nextLine();
		
		switch(opcoes) {
		case 1:
			System.out.println("Digite o nome do aluno: ");
			String nome = sc.nextLine();

			System.out.println("Digite a matrícula do aluno: ");
			String matriculaStr = sc.nextLine();
			int matricula = Integer.parseInt(matriculaStr); // Converte para int

			criarArquivoAluno(nome, matricula, arquivoString);
			moverArquivoTurma(arquivoString, turmaString);
			menu();
		}
	}
}


