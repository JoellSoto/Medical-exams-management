import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Visualizacoes extends JFrame{
	private ConstrutorTabela principal;
	private TituloTabela t;
	private boolean a;
	private Container c;
	private JTable tabela;
	private String[] titulo;
	private String[][] dadosTabela;
	private JMenuBar menu;
	private JMenu jmGeral, jmValores,jmBioquimica, jmHematologa, jmMicrobiologia;
	private JMenuItem jmiPesquisa, jmiQuantidades, jmiTodasAnalises, 
						jmiValorGanho, jmiGanhoSeguros,
						jmiTodasBioquimica, jmiColesterolAlto,
						jmiTodasHematologia, jmiAnemia,
						jmiTodasMicrobiologia, jmiInfeccao,jmiOrdena; 
	private JLabel lbPesquisas;
	private JTextField tfPesquisas;
	private JButton bPesquisas;
	

	public Visualizacoes(String titulo, ConstrutorTabela principal)
	{
		a=false;
		this.principal=principal;
		t = new TituloTabela();
		setTitle(titulo);
		setSize(700,400);

		c = getContentPane();
		c.setLayout(new BorderLayout());
		
		
		criarMenu();
		makeCompenents();
	
		setVisible(true);
	}

	private void criarMenu()
	{
		menu = new JMenuBar();
		
		//Criando opcoes principais de menu
		jmGeral = new JMenu("Geral");
		jmValores = new JMenu("Valor Ganho");
		jmBioquimica = new JMenu("Analise Bioquimica");
		jmHematologa = new JMenu("Analise Hematologa");
		jmMicrobiologia = new JMenu("Analise Microbiologia");

		//Criando elementos da camada 2
		jmiPesquisa = new JMenuItem("Pesquisar");
		jmiOrdena= new JMenuItem("Ordenar dados por data");
		jmiQuantidades = new JMenuItem("Quantidade de Analises");
		jmiTodasAnalises = new JMenuItem("Visualizar Todas Anlises");

		jmiValorGanho = new JMenuItem("Valor ganho");
		jmiGanhoSeguros = new JMenuItem("Pago por seguros");

		jmiTodasBioquimica = new JMenuItem("Todas Analises");
		jmiColesterolAlto = new JMenuItem("Problemas de Colesterol Alto");

		jmiTodasHematologia = new JMenuItem("Todas Analises");
		jmiAnemia = new JMenuItem("Anemia detectada");

		jmiTodasMicrobiologia = new JMenuItem("Todas Analises");
		jmiInfeccao = new JMenuItem("Infeccoes detectadas");

		//Criando relacao da camada 2 e principal
		jmGeral.add(jmiPesquisa);
		jmGeral.add(jmiOrdena);
		jmGeral.add(jmiQuantidades);
		jmGeral.add(jmiTodasAnalises);

		jmValores.add(jmiValorGanho);
		jmValores.add(jmiGanhoSeguros);

		jmBioquimica.add(jmiTodasBioquimica);
		jmBioquimica.add(jmiColesterolAlto);

		jmHematologa.add(jmiTodasHematologia);
		jmHematologa.add(jmiAnemia);

		jmMicrobiologia.add(jmiTodasMicrobiologia);
		jmMicrobiologia.add(jmiInfeccao);
		
		//Criando relacao da camada principal e o menuBar
		menu.add(jmGeral);
		menu.add(jmValores);
		menu.add(jmBioquimica);
		menu.add(jmHematologa);
		menu.add(jmMicrobiologia);

		//Adicionando Eventos aos items do menu
		makeMenuEvent();

		setJMenuBar(menu);
	}

	private void makeCompenents()
	{
		//Componentes usados para pesquisa
		lbPesquisas= new JLabel("Introduza o id");
		tfPesquisas = new JTextField(20);

		bPesquisas  = new JButton("Pesquisar");

		makeEvent();

	}

	private void makeEvent()
	{
		bPesquisas.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				try{
					int id, posi;
					id = Integer.parseInt(tfPesquisas.getText());
					posi = principal.pesquisarAnaliseT(id);
					if(posi<0) 		
						JOptionPane.showMessageDialog(null,"A analise nao existe!");
					else
					{
						remove();
						titulo = t.tituloAnalise();
						dadosTabela = principal.dadosDoElementoT(posi);
						tabela = new JTable(dadosTabela,titulo);
						
						c.add(tabela,BorderLayout.CENTER);
						update();
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Introduza o id correctamente!");}
		}});

	}

	private void makeMenuEvent()
	{
		jmiOrdena.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				principal.ordenarPorData();
				JOptionPane.showMessageDialog(null,"Dados Ordenados!");
		}});
		jmiPesquisa.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				JPanel j = new JPanel(new FlowLayout());
				j.add(lbPesquisas); j.add(tfPesquisas); j.add(bPesquisas);
				c.add(j,BorderLayout.CENTER);
				update();
		}});

		jmiQuantidades.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloQuantidades();
				dadosTabela = principal.quantidades();	
				JTable tabela = new JTable(dadosTabela,titulo);
				c.add(tabela,BorderLayout.CENTER);	
				update();	
		}});

		jmiTodasAnalises.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloAnalise();
				dadosTabela = principal.todasAnalises();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);
				update();			
		}});

		jmiValorGanho.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloValor();
				dadosTabela = principal.valorGanho();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);
				c.add(new JLabel(principal.lucroPrejuizo()),BorderLayout.SOUTH);	
				update();	
		}});

		jmiGanhoSeguros.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				c.add(new JLabel("Valor pago por seguros"),BorderLayout.NORTH);
				titulo = t.tituloValor();
				dadosTabela = principal.valorGanhoSeguros();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);
				update();			
		}});

		jmiTodasBioquimica.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloBioquimica();
				dadosTabela = principal.todasBioquimica();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);	
				update();		
		}});

		jmiColesterolAlto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloBioquimica();
				dadosTabela = principal.colesterolAlto();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);
				update();			
		}});

		jmiTodasHematologia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloHematologia();
				dadosTabela = principal.todasHematologia();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);	
				update();	
		}});

		jmiAnemia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloHematologia();
				dadosTabela = principal.anemia();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);	
				update();	
		}});

		jmiTodasMicrobiologia.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloMicrobiologia();
				dadosTabela = principal.todasMicrobiologia();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);	
				update();	
		}});

		jmiInfeccao.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				remove();
				titulo = t.tituloMicrobiologia();
				dadosTabela = principal.infeccao();	
				tabela = new JTable(dadosTabela,titulo);
				c.add(new JScrollPane(tabela),BorderLayout.CENTER);	
				update();	
		}});			
	}

	private void remove()
	{
		c.removeAll();
	}

	private void update()
	{
		if(a==false)
		{
			setSize(700,401);
			a=true;
		}
		else
		{
			setSize(700,400);
			a=false;
		}
	}

}