import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class AlgoritmoGenetico extends MetodosCodigo implements ValoresConstantes{
	
	int numCromossomosPais = 10000;
	
	ArrayList<Letra>   superPalavra = new ArrayList<Letra>();	
	
	ArrayList<Palavra> populacao        = new ArrayList<Palavra>();
	ArrayList<Palavra> populacaoInicial   = new ArrayList<Palavra>();	
	ArrayList<Palavra> populacaoFinal   = new ArrayList<Palavra>();	
	
	
	
	
	
	AlgoritmoGenetico(NumerosTeclado[] numeroDigitado){
	
			
		
	// EXECUÇÃO		
	// os valores digitados pelo usuário são transformados em um grande vetor com 21 caracterred de Letras		
	

	
	// são realizados sorteios randonicos detro da SuperPalavra, criando a população de cormossomos pai definida
	populacaoInicial = criarPopulacao(numeroDigitado, numCromossomosPais);
	

	
	
	for(Palavra pal: populacaoInicial){

		Letra[] l = new Letra[7];
		
		l = pal.getLetrasPalavra();
		
		Palavra auxPal = new Palavra(l);
		populacao.add(auxPal);

		
	}
				
	
	boolean sair = false;
	int numGeracoes = 0;

/// ALGORTMO GENETICO --------------------------	
	while(!sair){
			
		
		  // 1 - Seleção da População	  			
		  ArrayList<Palavra> popSelecionada   = new ArrayList<Palavra>();
		  
		  popSelecionada = selecionarPopulacao(populacao, 70);	 	
		  populacao.clear();
		  
		  
			  for(Palavra pal: popSelecionada){	  								  
				  populacaoFinal.add(pal);					  
			  }
			  			
		 	
		
			 //2 - crossOver, cada funçao adiciona um cromossomo filho à população intermediaria, 
			  // indo de encontro à teoria dos AG que propoem a geração de dois filhos a partir de dois pais
				
			 
			  
			  boolean fimCrossOver = false;
			  int cont2 = 0;
			  while(!fimCrossOver){
				  
				  try{
			
					ArrayList<Palavra> popIntermediaria = new ArrayList<Palavra>(); 
					Random randNum = new Random();						
					int aux = randNum.nextInt(2);
					
					switch (aux) {
					
						case 1:							
							// OBX - Order Based CrossOver
							Palavra palavraFilho = OBXcrossover(popSelecionada);	
							
							popIntermediaria.add(palavraFilho);								
							
							break;
							
						case 2:
							// PBX (Position Based Crossover);							
							
							Palavra palavraFilho2 = PBXcrossover(popSelecionada);	
							
							popIntermediaria.add(palavraFilho2);								
							
							
							break;
							
						case 3:
							Palavra palavraFilho3 = PBXcrossover(popSelecionada);
							
							popIntermediaria.add(palavraFilho3);
							
							break;
					
					}// FIM SWITCH
					
					
															
					
					for(Palavra pal: popIntermediaria){						
						 populacao.add(pal);						
					}
				
				  
					  if(cont2 == 2000){
						  fimCrossOver = true;
					  }else{
						  cont2++;
					  }
				  
				  }catch(IllegalArgumentException exp){
					  
					  fimCrossOver = true;
				  }
			  }// FIM while CrossOver
			  
			  if(numGeracoes == 5){
				  
				 	
				  sair = true;
			  }else{
				  numGeracoes++;		  
				  
			  }
	  
	}// FIM while Algorítmo Genético
	 

	if(populacaoFinal.size() > 20){
		
		populacaoFinal = gerarListaSemRepeticao(populacaoFinal);
		Collections.sort(populacaoFinal);
		
	}
	
	
	if(populacaoFinal.size() < 20){
		
		Collections.sort(populacaoInicial);
		
	
		
		int i = 0;
		
		do{
			
			populacaoFinal.add(populacaoInicial.get(i));	 	
			populacaoFinal = gerarListaSemRepeticao(populacaoFinal);
			i++;
			
			
			
		}while(populacaoFinal.size() < 20);
			
			
		
		Collections.sort(populacaoFinal);
		
	 }
	 
			
    	//gerarArquivo(populacaoFinal);	
			 
	
//	frame.criaPanelPalavras(populacaoFinal);		

	

}	
	
	
	
	
	
	
	

}
