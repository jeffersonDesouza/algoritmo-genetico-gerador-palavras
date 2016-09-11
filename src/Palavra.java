import java.util.Arrays;

public class Palavra implements Comparable, ValoresConstantes {
	
	private int aptidao;
	private Letra[] letrasPalavra;
	
	
	Palavra(Letra[] letrasPalavra){
		this.letrasPalavra = letrasPalavra;
		getAptidao();
	}
	
	public Letra[] getLetrasPalavra() {
		return letrasPalavra;
	}

	

	public int getAptidao() {
		return aptidao;
	}	
	
	
	

	public void setAptidao(){
		
		
		aptidao = 0;
		
		for(int i=0; i< letrasPalavra.length; i++){		
			
		
				
			if(i+1 < (letrasPalavra.length) && letrasPalavra[i].getCod() != letrasPalavra[i+1].getCod()){
				
				aptidao +=10;					
			}else if(i+1 <(letrasPalavra.length) && letrasPalavra[i].getCod() == letrasPalavra[i+1].getCod()){
				aptidao -=10;
			}
			
			// RR
			if(i>0 && i<5 && letrasPalavra[i] == R && (letrasPalavra[i+1] == R) && (letrasPalavra[i-1].getCod() == 0)
																				&& (letrasPalavra[i+2].getCod() == 0)){					
				aptidao += 20;					
			}
			
			
			// Encontros consonotais do TR, DR, CR, PR
			
			if(i > 0 && (i+1 < letrasPalavra.length) && letrasPalavra[i] == R && letrasPalavra[i+1].getCod() == 0){
				
				if(letrasPalavra[i-1] == T || letrasPalavra[i-1] == D || 
				   letrasPalavra[i-1] == C || letrasPalavra[i-1] == P){					
					aptidao += 20;					
				}												
			}
								
			
			// encontros consonotais do M
			
			if(i>0 && i<5 && letrasPalavra[i] == M && letrasPalavra[i-1].getCod() == 0 
					&& letrasPalavra[i+1].getCod() == 1){
				
				if(letrasPalavra[i+1] == P || letrasPalavra[i+1] == B){
					aptidao += 20;					
				}else{
					aptidao -= 10;					
				}
			}			
			
			// encontros consonotais do N	
			
			if(i>0 && i<5 && letrasPalavra[i] == N && letrasPalavra[i-1].getCod() == 0 
					&& letrasPalavra[i+1].getCod() == 1){
				
				if(letrasPalavra[i+1] == M || letrasPalavra[i+1] == N || letrasPalavra[i+1] == P || letrasPalavra[i+1] == B){
					aptidao -= 10;					
				}else{
					aptidao += 20;					
				}
			}					
			
			
			// Encontros do H
				
			
			
		
			if(i>0 && (i+1 < letrasPalavra.length) && letrasPalavra[i] == H && letrasPalavra[i-1].getCod() == 1 
				     									            && letrasPalavra[i+1].getCod() == 0){

				if(letrasPalavra[i-1] == L || letrasPalavra[i-1] == N || letrasPalavra[i-1] == C){
					aptidao += 10;					
				}else if(i>0 && letrasPalavra[i-1].getCod() == 0 && letrasPalavra[i+1].getCod() == 0){
					aptidao -= 50;
				}
				
				else{
					aptidao -= 50;					
				}		
				
				
				
			}
			
			
			if(i>0 && (i+1 < letrasPalavra.length) && letrasPalavra[i] == U && letrasPalavra[i-1] == G 
																			&& letrasPalavra[i+1] == I){
				aptidao += 20;					
									
			}
			
			
		
			
			
			
			// encontros consonotais do K, W, Y
			
			
			if(i>0 && letrasPalavra[i] == K || letrasPalavra[i] == W || letrasPalavra[i] == Y){
				aptidao -= 50;	
			}
			
			
			
			
		} // fim laço for
		
		/*	if(letrasPalavra[0] == A && letrasPalavra[1] == L){
				aptidao += 10;	
			}
			
			if(letrasPalavra[0] == A && letrasPalavra[1] == R ){
				aptidao += 10;	
			}*/
		
		// Fim de palavra Consoante Vogal
		if(letrasPalavra[5].getCod() == 1 && letrasPalavra[6].getCod() == 0){
			
			aptidao += 20;					
		}
		
		// Fim de palavra com S, R, M
		if(letrasPalavra[5].getCod() == 0 && letrasPalavra[6].getCod() == 1){
			
			if(letrasPalavra[6] == S || letrasPalavra[6] == R || letrasPalavra[6] == M){					
				aptidao += 10;					
			}else{
				aptidao -= 30;				
			}
		}
		
		//Fim de palavra com 'AO'
		if(letrasPalavra[5] == A && letrasPalavra[6] == O && letrasPalavra[4].getCod() == 1){			
			aptidao +=20;					
		}
		//Fim de palavra com 'OES'
		if(letrasPalavra[4] == O && letrasPalavra[5] == E && letrasPalavra[6] == S && letrasPalavra[3].getCod() == 1){			
			aptidao +=20;					
		}			
		
		
	}


	
	public void setLetrasPalavra(Letra[] letrasPalavra) {
		this.letrasPalavra = letrasPalavra;
	}

	public int compareTo(Object aptd) {
		int compareAptidao = ((Palavra) aptd).getAptidao(); 
		
		return compareAptidao - this.aptidao;
	}
	
	
	

	
	public String toString() {
		return Arrays.toString(letrasPalavra);
	}

	
	
	

	

	
	
	
}
