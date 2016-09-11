import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;


abstract class MetodosCodigo implements ValoresConstantes {
	
	static Scanner entrada = new Scanner(System.in);
	
	
	static Random generator = new Random();

	static int validaValor(){
		int valor = 0;
		boolean sair= false;
		
		while(!sair){
			try{
		
				valor = entrada.nextInt();
				
				if(valor < 2222222 || valor > 9999999) throw new ArithmeticException();
				
				sair = true;
			}
				catch(InputMismatchException e){
					System.out.print("Valor inválido, tente novamente: ");
					
					entrada.nextLine();
					
				}
				catch(ArithmeticException e){
					System.out.print("Valor inválido, tente novamente: ");
					
					entrada.nextLine();
					
				}
			
		}
		
		return valor;					
	}

	static ArrayList<Letra> criarSuperPalavra(int valorDigitado){
	
		NumerosTeclado[] letrasDoTeclado = {num_2, num_3, num_4, num_5, num_6, num_7, num_8, num_9};
		
		
		
		ArrayList<Letra> superPalavra = new ArrayList<Letra>();
		
		int[] numerosUsuario = new int[7];
		int aux = 1000000;	
		
		
		//Separação do valor digitado em VETOR;
				for(int i=0; i< numerosUsuario.length; i++){		
					
					int aux2 = valorDigitado/aux;								
						numerosUsuario[i] = aux2;		
					
					valorDigitado = valorDigitado%aux;
					aux = aux/10;
				}
				
	
			
				
				
				
				
				//Criação do array com todos os Caracteres;
				for(int k = 0; k < numerosUsuario.length; k++){
					
					for(int i=0; i< letrasDoTeclado.length; i++){
						
						if(numerosUsuario[k] == letrasDoTeclado[i].valorNumero){
							
							for(int j = 0; j<3; j++){
								superPalavra.add(letrasDoTeclado[i].LetrasNum[j]);
							}
							
						}
						
					}
				}
		
		
		return superPalavra;
	}
	


	static ArrayList<Palavra> criarPopulacao(NumerosTeclado[] letrasDoTeclado, int numCromossomos){
		
		ArrayList<Palavra> populacao = new ArrayList<Palavra>();
		int aux = 0;
		
			
		while(aux < numCromossomos){
									
			Letra[] palavraDeLetras = new Letra[7];
			
			for(int i=0; i < palavraDeLetras.length; i++){
				
				int randomIndex = generator.nextInt(3);
				
				palavraDeLetras[i] = letrasDoTeclado[i].LetrasNum[randomIndex];
				
			}
						
			Palavra umaPalavra = new Palavra(palavraDeLetras);
			umaPalavra.setAptidao();
			
			populacao.add(umaPalavra);			
			
			aux++;
		}
		
		
		// ordena as palavras da maio aptdao para a menor, o método CompareTo está em Palavra
		Collections.sort(populacao);
		
		return populacao;
	}

	static ArrayList<Palavra> selecionarPopulacao(ArrayList<Palavra> populacao, int nivelSelecao){
		
		ArrayList<Palavra> populacaoSelecionada = new ArrayList<>();
		
		for(Palavra pal: populacao){	
			
			Palavra novaPalavra = new Palavra(pal.getLetrasPalavra());
			
			novaPalavra.setAptidao();					
					
			if(novaPalavra.getAptidao() >= 70){
				populacaoSelecionada.add(novaPalavra);			
			}		
		}
		
			
		return populacaoSelecionada;
		
	}

	
	// OBX (Order Based Crossover );
	static Palavra OBXcrossover(ArrayList<Palavra> populacao){
			
		int aux1 = generator.nextInt(populacao.size());
				
		Letra[] letrasFilho = new Letra[7];
		
		for(int i = 0; i< 7; i++){
			
			letrasFilho[i] =  populacao.get(aux1).getLetrasPalavra()[i];		
			
		}	
		
		int rand1 = generator.nextInt(7);
		int rand2 = generator.nextInt(7);
		int rand3 = generator.nextInt(7);	
		
		Letra l1 = populacao.get(aux1).getLetrasPalavra()[rand1]; 
		Letra l2 = populacao.get(aux1).getLetrasPalavra()[rand2];  
		Letra l3 = populacao.get(aux1).getLetrasPalavra()[rand3];				
			
		letrasFilho[rand1] = l2;
		letrasFilho[rand2] = l3;
		letrasFilho[rand3] = l1;						
			
		Palavra filho = new Palavra(letrasFilho);
		
		filho.setAptidao();
			
		return filho;		
	}
	
	// PBX (Position Based Crossover);
	static Palavra PBXcrossover(ArrayList<Palavra> populacao){		
		
		
		int aux1 = generator.nextInt(populacao.size());
		int aux2 = generator.nextInt(populacao.size());	
			
		int rand1 = generator.nextInt(7);
		int rand2 = generator.nextInt(7);
		int rand3 = generator.nextInt(7);	
		
		
		
		Letra[] letrasFilho = new Letra[7];	
		Letra[] letrasFilho2 = new Letra[7];	
		
		
		for(int i =0; i<7; i++){			
			letrasFilho[i] = populacao.get(aux1).getLetrasPalavra()[i]; // Pai 1
		}
		
		for(int i =0; i<7; i++){			
			letrasFilho2[i] = populacao.get(aux2).getLetrasPalavra()[i]; // Pai 2
		}
		
		
		
		letrasFilho[rand1] = letrasFilho2[rand1];
		letrasFilho[rand2] = letrasFilho2[rand2];
		letrasFilho[rand3] = letrasFilho2[rand3];			
			
		Palavra filho = new Palavra(letrasFilho);
		
		filho.setAptidao();
		
		return filho;
		
	}

	// MUTAÇÃO 
	static Palavra  multacao(Palavra palavra){
		
		int randId   = generator.nextInt(7);		
		
		Letra[] letras = palavra.getLetrasPalavra();	
		
		Letra[] vogaisVetor     = {A, E, I, O, U};
		Letra[] consoantesVetor = {B, C, D, F, G, H, J, L, M, N, P, R, S, T, V};	
		
		
		if(letras[randId].getCod() == 0){
			int rand = generator.nextInt(5);				
			letras[randId] = vogaisVetor[rand];
										
		}else if(letras[randId].getCod() == 1){
			int rand = generator.nextInt(15);
					
			letras[randId] = consoantesVetor[rand];			
		}
		
		Palavra filho = new Palavra(letras);		
		filho.setAptidao();
		
		return filho;		
	}
	
	
	static void dadosPopulacao(ArrayList<Palavra> populacao){
			
			int contPos = 0;
			int contNeg = 0;
			int cont70  = 0;
		  
				  for(Palavra pal: populacao){
					  
					  if(pal.getAptidao() >= 0){
						  contPos++;
					  }else{
						  
						  contNeg++;
					  }
					  
					  if(pal.getAptidao() >= 70){
						  cont70++;
					  }
					  
				   }  
				  
				  System.out.println("Size: "+populacao.size());	
				  System.out.println("Pos: "+contPos);	
				  System.out.println("Neg: "+contNeg);	
				  System.out.println("Ap=70: "+cont70+"\n");
			
	}
	
	
	
	static ArrayList<Palavra> gerarListaSemRepeticao(ArrayList<Palavra> populacao){
		
		ArrayList<Palavra> populacaoImpressao= new ArrayList<Palavra>();
		
		int i = 0;
		
		boolean sair = false;
		
		while(!sair){

			Palavra filhoComparativo = populacao.get(i);
			
			
			for(int j = 0; j<populacao.size(); j++){
				
				if(j != i){
					
					int cont = 0;
					
					for(int k = 0; k < 7; k++){
							
						if(filhoComparativo.getLetrasPalavra()[k].getId() == populacao.get(j).getLetrasPalavra()[k].getId()){
								cont++;
						}							
					}	
					
					if(cont == 7){
						
						populacao.remove(j);
						
						
						if(j==0){
							j = 0;
						}else{
							j--;
						}
					}
					
				}			
				
			}		
			
			
			i++;
			
			if(i>=populacao.size()){
				sair = true;
			}
			
		}	
		
		populacaoImpressao = populacao;
		
		return populacaoImpressao;
	}
	
	
	static String convertePalavra(Palavra palavra){
		
		String stPalavra = "";
		
		for(int i=0; i< palavra.getLetrasPalavra().length; i++){		
			
			stPalavra += palavra.getLetrasPalavra()[i].getId();		
			
		}		
		
		
		return stPalavra;
	}
	
	
	
	static void gerarArquivo(ArrayList<Palavra> populacao) throws IOException{
		
		String[] vetorPalavras = new String[20];
		 
	 	PrintStream ps = new PrintStream("Projeto II Unidade - Marcos Jefferson.txt"); 	
	 	 	
	 	for(int i = 0; i< vetorPalavras.length; i++){		
	 		vetorPalavras[i] = convertePalavra(populacao.get(i));
			
			ps.println((i+1) + " - "+vetorPalavras[i]);
		}
	 	
	 	ps.close();
	 	
	}
	
	
	
	
	
	
	
}
