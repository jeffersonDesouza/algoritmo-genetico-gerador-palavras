
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.Random;

public class FrameGUI extends JFrame implements ValoresConstantes  {
	
	int i = 0; 	
	private int valorTeclado;
	
	
			public int getValorTeclado() {
				return valorTeclado;
			}
			
			public void setValorTeclado(int valorTeclado) {
				this.valorTeclado = valorTeclado;
			}





	private JPanel cabecalhoPanel;
	private JPanel tecladoPanel;
	private JPanel calculadoraPanel;
	private JPanel botoesInfoPanel;
	
	private JLabel    cabecalhoLabel;	
	private JTextArea campoNumero;
	private JButton   gerarPalButton;
	
	private Icon   brasaoUEPB;
	
	
	// Botoes teclado
	private JButton num1 = new JButton("<HTML> <p font align = center><font size='6' > 1 </font><br> - ");
	private JButton num2 = new JButton("<HTML> <p font align = center><font size='6' > 2 </font><br>ABC");
	private JButton num3 = new JButton("<HTML> <p font align = center><font size='6' > 3 </font><br>DEF");
	private JButton num4 = new JButton("<HTML> <p font align = center><font size='6' > 4 </font><br>GHI");
	private JButton num5 = new JButton("<HTML> <p font align = center><font size='6' > 5 </font><br>JKL");
	private JButton num6 = new JButton("<HTML> <p font align = center><font size='6' > 6 </font><br>MNO");
	private JButton num7 = new JButton("<HTML> <p font align = center><font size='6' > 7 </font><br>PRS");
	private JButton num8 = new JButton("<HTML> <p font align = center><font size='6' > 8 </font><br>TUV");
	private JButton num9 = new JButton("<HTML> <p font align = center><font size='6' > 9 </font><br>WXY");
	private JButton numA = new JButton("<HTML> <p font align = center><font size='3' >LIMPAR</font><br>   ");
	private JButton num0 = new JButton("<HTML> <p font align = center><font size='6' > 0 </font><br>___");
	private JButton numH = new JButton("<HTML> <p font align = LEFT><font size='3' >SAIR</font><br>   ");
	
	private JButton[] botoesTecladoVet = {num1, num2, num3, num4, num5, num6, num7, num8, num9, numA, num0, numH};
	
	
	private JButton objetivosBotao;
	private JButton algoritmoBotao; // explicar o algoritmo usado
	private JButton dadosAlunoBotao; // dados pessoais de aluno, mat etc; // eles devem gerar JOptionPane.ShowMessagePane(); 
	
	
    NumerosTeclado[] letrasDoTeclado = new NumerosTeclado[7];

	String campoTxt = "";
    public int valorDig;
    
    

	String textoCabecalho =   "<HTML><p align=center> UIVERSIDADE ESTADUAL DA PARAÍBA"
				            + "<br>Campus VII - Patos"
				            + "<br>Bacharelado em Ciências da Computação"
				            + "<br>Prof.: Wellington Candeia"
				            + "<br>Aluno: Marcos Jéfferson</center> </HTML>";

	  
	    public FrameGUI() throws IOException {  
	    	
	    	super("Projeto II Unidade");
	    	
	    	setLayout(new BorderLayout(5,15));
 
	    	
	    	
	    ///CABEÇALHO
	    	// icone BRASÃO
	    
	    	
	    	cabecalhoPanel = new JPanel(new GridLayout());
	    		
	    
	    	cabecalhoLabel = new JLabel(textoCabecalho, SwingConstants.CENTER);
	    	
	    	
	    	
	    	
	    	
	    	
	    	cabecalhoPanel.add(cabecalhoLabel);
	  
	    	
	    	
	    	
	    	add(cabecalhoPanel, BorderLayout.NORTH);
	    	
	    	
	    	
	    	
	    	
	   /// CALCULADORA
	    	calculadoraPanel = new JPanel(new BorderLayout());	    	
	    	
	    	//// campo de texto
	    		campoNumero = new JTextArea();
	    		campoNumero.setPreferredSize(new Dimension(50, 25));
	    		campoNumero.setToolTipText("Informe um valor com 7 dígitos");
	    		campoNumero.setEditable(false);
	    		
	    		
	    	   	calculadoraPanel.add(campoNumero, BorderLayout.NORTH);
	    	
	    	//// Teclado
	    	
	    	tecladoPanel = new JPanel(new GridBagLayout());
	    	
	    	GridBagConstraints cons = new GridBagConstraints();
	    	
	    	cons.insets = new Insets(0, 3, 3, 0);
	    	
	    	int x = 0;
	    	int y = 0;
	    	
	    	
	    	
	    	for(int i=0; i<botoesTecladoVet.length; i++){
	    		
	    		
	    		cons.gridx = x;
				cons.gridy = y;
								
				x ++;
				if(x == 3) {
					x = 0;
					y ++;
				}
				
	    	
				
				
	    		botoesTecladoVet[i].setPreferredSize(new Dimension(70, 70));
	    		//botoesTecladoVet[i].setFont(font);
	    		
	    		
	    		tecladoPanel.add(botoesTecladoVet[i], cons);
	    			    		
	    	}
	    	calculadoraPanel.add(tecladoPanel, BorderLayout.CENTER);
	    	
	    	
	    	// Botão Gerar Palavras
	    	gerarPalButton = new JButton("GERAR PALAVRAS");
	    	gerarPalButton.setPreferredSize(new Dimension(100,80));
	    	gerarPalButton.setEnabled(false);
	    	
	    	
	    	
	    	calculadoraPanel.add(gerarPalButton, BorderLayout.SOUTH);
	    	
	    	
	    	add(calculadoraPanel, BorderLayout.CENTER);
	    	
	    
	    // BOTÕES INFORMATIVOS
	    	objetivosBotao  = new JButton("<HTML><p align=center> OBJETIVO <br>DO <br>PROJETO");
	    	
	    	algoritmoBotao  = new JButton("<HTML><p align=center>DESCRIÇÃO <br>DO <br>ALGORÍTMO");
	    	
	    	dadosAlunoBotao = new JButton("<HTML><p align = center>DADOS <br>DO <br>ALUNO");
	    
	    botoesInfoPanel = new JPanel(new GridLayout(1,3, 15,15));
	    	
	  
	    botoesInfoPanel.add(objetivosBotao);
	    botoesInfoPanel.add(algoritmoBotao);
	    botoesInfoPanel.add(dadosAlunoBotao);
	 
	   
	    add(botoesInfoPanel, BorderLayout.SOUTH);	
	    	
	    	
	    // ADD extras
	    	add(new JLabel("           "), BorderLayout.WEST);
	    	add(new JLabel("           "), BorderLayout.EAST);
	    	
	    	
	    	// Teclado
	    	eventTeclado handler = new eventTeclado();
	    		    	
	    	num2.addActionListener(handler);
	    	num3.addActionListener(handler);
	    	num4.addActionListener(handler);
	    	num5.addActionListener(handler);
	    	num6.addActionListener(handler);
	    	num7.addActionListener(handler);
	    	num8.addActionListener(handler);
	    	num9.addActionListener(handler);
	    	numA.addActionListener(handler);
	    	numH.addActionListener(handler);
	    	
	    	
	    	
	    	gerarPalButton.addActionListener(handler);
	    
	    	// Gerar Palavras
	    	
	    	
	   
	    
	    objetivosBotao.addActionListener(new ActionListener(){
	    	
	    	public void actionPerformed(ActionEvent evt){
	    		
	    		String objetivos = "<HTML><p align = 'justify'><br>Escrever um programa que, dado um número de sete dígitos"
	    				+ "sejam criadas vinte <br>possiveis combinações de palavras a partir das letras referêntes a estes <br>"
	    				+ "números no teclado da aplicação."; 
	    	
	    		JOptionPane.showMessageDialog(null, objetivos, "Objetivos", 1);
	    	
	    	}
	    	
	    	
	    });	
	    	
	    algoritmoBotao.addActionListener(new ActionListener(){
		   
		   public void actionPerformed(ActionEvent e){
			   
			   String descricao = 
					   "<HTML><p align = justify><br>O presente algoritmo faz uso (ainda que superficial) de técnicas conhecidas no desenvolvimento de algoritmos genéticos.<br>"
					   + "					   <br>A partir de um número com sete dígitos, o programa seleciona as letras referentes a cada dígito gerando em seguida uma <br>População Inicial contendo 10000 palavras, onde cada letra da Nova Palavra é escolhida de forma aleatória junto ao conjunto<br> de letras referentes ao dígito de mesma posição à letra da Nova Palavra.<br>"
					   + "					   <br>Tomando por base a formação básica das palavras em Português, fora criado um meio de qualificar (Aptidão) a formação das palavras.<br>"
					   + "					   <br>Tendo em mãos a população inicial, realizou-se uma seleção tomando-se por base uma nota de corte onde as palavras ‘menos aptas’ foram descartadas.<br>"
					   + "					   <br>Em seguida são realizadas seções de Crossovers, mutações e novas seleções das populações geradas por um número fixo de “gerações”.<br>"
					   + "						<br>Por fim, os dados gerados foram tratados para evitar a presença de palavras repetidas e em <br>ordem de Adaptação.<br>"
					   + "					  <br>É interessante destacar que a população inicial é criada com 10000 palavras, onde dependendo da variedade do número inicialmente digitado cerca de 0,3% das palavras <br>tinha aptidão maior ou igual a 70. Já apôs utilização das técnicas descritas esse número <br>chegou a 30%.";

			   JOptionPane.showMessageDialog(null, descricao, "Descrição do Algoritmo",1 );
		   }
		   
	   });	
	    	
	    
	    Icon incone =new ImageIcon("icone1.jpg");
	    dadosAlunoBotao.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				String dados = "<HTML><p align = justify><br>ALUNO: Marcos Jéfferson F. de Souza <br>MATRÍCULA: 141813180"
						+ "						<br>Bacharelado Em Ciências da Computação <br>3º Período ";

				
				JOptionPane.showMessageDialog(null, dados, "Dados do Aluno", 1, incone);
				
			}
		});
	    	    
	    // GERAR DADOS E ALGORITMO GENETICO /////
	    
	    //if(campoTxt.length() >= 7) gerarPalButton.setEnabled(true); 
	    
	}
	    
	    
	    
	  /////// CLASSE PRIVADA 1 BOTOES DO TECLADO
	    
	    private class eventTeclado implements ActionListener{
	    	
	    	geraAlgoritmoGenetico algoGene;
	    		
	    	
			public void actionPerformed(ActionEvent e) {				
				
				
				if(i  < 7){		
					
					
					
					if(e.getSource() == num2){					
						campoTxt += "2";					
						letrasDoTeclado[i] = num_2;
						i++;					
						
					}else if(e.getSource() == num3){
						campoTxt += "3";
						letrasDoTeclado[i] = num_3;
						i++;
						
						
					}else if(e.getSource() == num4){
							campoTxt += "4";
							letrasDoTeclado[i] = num_4;
							i++;
							
					}else if(e.getSource() == num5){
							campoTxt += "5";
							letrasDoTeclado[i] = num_5;
							i++;
							
							
					}else if(e.getSource() == num6){
							campoTxt += "6";
							letrasDoTeclado[i] = num_6;
							i++;
							
					}else if(e.getSource() == num7){
							campoTxt += "7";
							letrasDoTeclado[i] = num_7;
							i++;
					
							
					}else if(e.getSource() == num8){
							campoTxt+= "8";
							letrasDoTeclado[i] = num_8;
							i++;
							
							
					}else if(e.getSource() == num9){
							campoTxt += "9";
							letrasDoTeclado[i] = num_9;
							i++;
												
					}
						 
						
						
				}	
							
					
				if(e.getSource() == numH){		
								
					System.exit(0);
				}
				
				if(e.getSource() == numA){		
					
					campoTxt = "";				
					i = 0;
					gerarPalButton.setEnabled(false);
				
				}
				
				if(e.getSource() == numA && i >= 7){		
					
									
					i = 0;				
					
					algoGene.populacao.clear();
					algoGene.populacaoInicial.clear();
					algoGene.populacaoFinal.clear();
					
					campoNumero.setText("");
					
					
				}
				
				
				
				campoNumero.setText(campoTxt);			
				
				if(i >= 7){
					
					gerarPalButton.setEnabled(true);
					
					algoGene = new geraAlgoritmoGenetico(letrasDoTeclado);					
					valorDig = Integer.parseInt(campoTxt);
					
					
					if(e.getSource() == numA){								
						
						i = 0;										
						algoGene.populacao.clear();
						algoGene.populacaoInicial.clear();
						algoGene.populacaoFinal.clear();
						
						campoNumero.setText("");
						
					}
					
									
				
					// Algoritimo Genetico				
					if(e.getSource() == gerarPalButton)
			    											
							criaPanelPalavras(algoGene.populacaoFinal);
							try {
								gerarArquivo(algoGene.populacaoFinal);
							} catch (IOException e1) {
								
								e1.printStackTrace();
							}
							
							
							
			    	}
			}
		    }
			
	    
	    
	   
	    static String convertePalavra(Palavra palavra){
			
			String stPalavra = "";
			
			for(int i=0; i< palavra.getLetrasPalavra().length; i++){		
				
				stPalavra += palavra.getLetrasPalavra()[i].getId();		
				
			}		
			
			
			return stPalavra;
		}
	    
	   
	    
	    public void criaPanelPalavras(ArrayList<Palavra> populacao){
	    	

	        String listaDePalavras = "PALAVRAS GERADAS\n\n";
	    	
	    	for(int i = 0; i < 20; i++){		

				listaDePalavras += (i+1+" - ")+convertePalavra(populacao.get(i))+"\n";
						
			}
	    	
	    	listaDePalavras+= "\n\nOBS: Gerado arquivo de texto 'Projeto II Unidade - Marcos Jefferson.txt'";
	    		
					
			JOptionPane.showMessageDialog(null, listaDePalavras);
					
				
	    	
	    }

	    
	   
	    
	    public void activate(){
	    	

	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	
	    
	    	setSize(500, 600);
	    	
	    	setResizable(false);
	    	setLocationRelativeTo(null); 
	    	
	    	setVisible(true); 
	    	
	    }	
	
	    
	    

		void gerarArquivo(ArrayList<Palavra> populacao) throws IOException{
			
			String[] vetorPalavras = new String[20];
			 
		 	PrintStream ps = new PrintStream("Projeto II Unidade - Marcos Jefferson.txt"); 	
		 	 	
		 	for(int i = 0; i< vetorPalavras.length; i++){		
		 		vetorPalavras[i] = convertePalavra(populacao.get(i));
				
				ps.println((i+1) + " - "+vetorPalavras[i]);
			}
		 	
		 	ps.close();
		 	
		}	    
	    
///////////////////////////////   CLASSE PRIVADA
	    
	private class geraAlgoritmoGenetico extends AlgoritmoGenetico{

		geraAlgoritmoGenetico(NumerosTeclado[] numeroDigitado){
			super(numeroDigitado);
			
		}

		
		
		
	}
	    
	    

}// CLASSE FRAME GUI
