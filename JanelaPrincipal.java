import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.StringTokenizer;

public class JanelaPrincipal extends JFrame{
	private Container cont;
	private JMenuBar bar;
	private JMenu ficheiro,operacoes,guardar;
	private JMenuItem  ler,sair,visualizacoes,novaAnalise,escFichObj,fichtxt,remover;
	private JLabel lbl1;
	private JTextField txt;
	private Tarefas t;
	

	//JamesArtur_JoelSoto, TB
	public JanelaPrincipal(){
	
		super("Laboratorio Joaquim Chaves ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t = new Tarefas();
		bar=new JMenuBar();
		setJMenuBar(bar);
		
		ficheiro=new JMenu("ficheiro");
		
		ler=new JMenuItem("Selecione os ficheiro"); 
		ficheiro.add(ler);


		guardar = new JMenu("Gravar dados");
		fichtxt = new JMenuItem("Ficheiro texto");
		escFichObj=new JMenuItem("Ficheiro objecto");
		guardar.add(escFichObj);
		guardar.add(fichtxt);
		ficheiro.add(guardar);
		
		sair=new JMenuItem("sair");  
		ficheiro.add(sair);

		bar.add(ficheiro); 

		operacoes=new JMenu("Operacoes");
		novaAnalise=new JMenuItem("Nova Analise");
		remover = new JMenuItem("Remover Analise");
		 
		operacoes.add(novaAnalise);
		operacoes.add(remover);
		 
		bar.add(operacoes);
		 
		visualizacoes=new JMenuItem("Visualizacoes");
		
		bar.add(visualizacoes);
		    
		 
		setVisible(true);
        setSize(500,250);

        events();
	}

	private void events()
	{
		visualizacoes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				if(t.totalDeAnalises()>0)
					new Visualizacoes("Visualizacoes",(ConstrutorTabela)t);	
				else
					JOptionPane.showMessageDialog(null,"Nao ha analises carregadas!");	
			}
		});

		remover.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new Remover("Remover Analise",t);
			}
		});

		novaAnalise.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				new JanelaAdicionar(t);
			}
		});

		escFichObj.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				selectFToSave(ev,"Dados.dat",1);	
			}
		});

		fichtxt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				selectFToSave(ev,"Dados.txt",0);			
			}
		});

		sair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent  ev){
				System.exit( 0 ); 
			}
		});

		ler.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent  ev){
				selectF(ev);
			}
		});


	}
	private void selectFToSave(ActionEvent evt, String fileName,int type)
	{
		try{
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setDialogTitle("Escolha o Directorio");

			if(chooser.showOpenDialog(this)==JFileChooser.OPEN_DIALOG)
			{
				File selected = chooser.getSelectedFile();
				String file = selected.getPath()+"\\"+fileName;
				if(type==0)
					JOptionPane.showMessageDialog(null,t.salvarFicheiroTexto(file));
				else
					JOptionPane.showMessageDialog(null,t.salvarFicheiroObjecto(file));
			}
		}catch(Exception e){}
	}

	private void selectF(ActionEvent evt)
	{	try{
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.setDialogTitle("Escolha o dat/txt");

			if(chooser.showOpenDialog(this)==JFileChooser.OPEN_DIALOG)
			{
				File selected = chooser.getSelectedFile();
				carregarDados(selected);
			}
		}catch(Exception e){}
	}

	private void carregarDados(File file)
	{
		StringTokenizer tk = new StringTokenizer(file.getName(),".");
		String nome = tk.nextToken();
		String extensao = tk.nextToken();
		if(extensao.equals("dat"))
			JOptionPane.showMessageDialog(null,t.lerFicheiroObjecto(file.getPath()));
		else if(extensao.equals("txt"))
			JOptionPane.showMessageDialog(null,t.lerFicheiroTexto(file.getPath()));
		else
			JOptionPane.showMessageDialog(null,"Ficheiro Invalido!");
	}

	public static void main(String[]args){
		new JanelaPrincipal();
	}
	
	

}
