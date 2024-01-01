import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class JanelaAdicionar extends JFrame{
	private String[]mes={"01","02","03","04","05","06","07","08","09","10","11","12"};
	private String ano[]={"2019","2020","2021","2022"};
	private String []dia;

	private JTextField numeroBI, nome,codigo, numeroTelefone, valorAnalise,idade;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	private JComboBox an,me,di;
	private JRadioButton r1,r2,r3,r4,r5,r6;
	private ButtonGroup genero,formaPagamento, tipoAnalise;
	private JPanel p1,p2,p3,p4,ro1,ro2,p5;
	private Container cont;
	private JButton btn1,btn2,btn;
	private Tarefas t;
	private String nome1,data,nBI,gen1,fP;
	private int codigo1, nTel;
	private double valor;
	private byte ida;
	
	public JanelaAdicionar(Tarefas t){
		
		super("Nova Analise");
		setLocationRelativeTo(null);
		cont=getContentPane();
		this.t = t;
		
		p1=new JPanel();
		p1.setLayout(new GridLayout(8,1));
		
		l1=new JLabel("Introduza o nome do Paciente");
		p1.add(l1);
		nome=new JTextField(10);
		p1.add(nome);
		
	
	    l3=new JLabel("Numero de BI do Paciente");
		p1.add(l3);
		numeroBI=new JTextField(10);
		p1.add(numeroBI);
		
		
		l4=new JLabel("Numero de telefone do Paciente");
		p1.add(l4);
		numeroTelefone= new JTextField(10);
		p1.add(numeroTelefone);
		
		
		l11=new JLabel("Idade do Paciente");
	    p1.add(l11);
	    idade=new JTextField(10);
	    p1.add(idade);
	 

		p4=new JPanel(new GridLayout(4,1));
		p4.add(p1);

		//Data
		p2=new JPanel(new FlowLayout());
		
		dia=dias();

		l6 = new JLabel("Data: ");
		an=new JComboBox(ano);
		me=new JComboBox(mes);
		di=new JComboBox(dia);
		p2.add(l6);
		p2.add(di);
		p2.add(me);
		p2.add(an);
		//Fim Data
		
		p4.add(p2);
	
		p3=new JPanel(new GridLayout(2,1));
		
		
		l9=new JLabel("Genero do Paciente: ");
		p3.add(l9);

		ro1=new JPanel(new GridLayout(1,2));
		r1=new JRadioButton("Masculino",true);
		ro1.add(r1);
		r2=new JRadioButton("Feminino",false);
		ro1.add(r2);
		p3.add(ro1);
		
		genero=new ButtonGroup();
        genero.add(r1);
        genero.add(r2);
        
        l10=new JLabel("Forma de pagamento: ");
        p3.add(l10);
        ro2=new JPanel(new GridLayout(1,3));
        r3=new JRadioButton("Numerario",true);
        ro2.add(r3);
            
        r4=new JRadioButton("cartao",false);
        ro2.add(r4);
		
        r5=new JRadioButton("seguro",false);
        ro2.add(r5);
        p3.add(ro2);

        formaPagamento=new ButtonGroup();
        formaPagamento.add(r3);
        formaPagamento.add(r4);
        formaPagamento.add(r5);
        p4.add(p3);
       
        btn1=new JButton("Hematologia");
		p5=new JPanel(new GridLayout(1,3));
	 	p5.add(btn1);	
		
		btn2=new JButton("MicroBiologia");
		p5.add(btn2);
		
		btn=new JButton("BioQuimica");
	    p5.add(btn);

        p4.add(p5);
        cont.add(p4);
        events();
        setVisible(true);
		setSize(700,600);	
	}



	private String [] dias(){
		String[]dias=new String[31];
		
		for(byte i=1;i<=dias.length;i++){
			if(i<10)
				dias[i-1]="0"+i;
			else
				dias[i-1]=""+i;
		}return dias;
	}

	private boolean receberDados()
	{
		nome1=nome.getText();
		nBI=numeroBI.getText();

		String ano1=ano[an.getSelectedIndex()];
		String mes1=mes[me.getSelectedIndex()];
		String dia1=dia[di.getSelectedIndex()];
		data=dia1+"/"+mes1+"/"+ano1;

		if(r1.isSelected())
        	gen1="Masculino";
        else
        	gen1="Feminino";
        
 
        if(r3.isSelected())
        	fP="Numerario";
        else{
        	if(r4.isSelected())
        		fP="Cartao";
        	else
        		fP="Seguro";
        }

		try{
			nTel=Integer.parseInt(numeroTelefone.getText());	
	    	ida=Byte.parseByte(idade.getText());
			codigo1 = t.novoCodigo();
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Preencha correctamente os espacos!");
			return false;
		}  
		setVisible(false);
		return true;
	}

	private void events()
	{
		btn.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent ev){
	    		valor = 1000;
	    		if(receberDados())
	    			new JanelaBioQuimica(codigo1,nTel,nBI,nome1,gen1,data,fP,"BioQuimica",ida,valor,t);
	    	}
	    });

		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				valor = 700;
				if(receberDados())
				new JanelaMB(codigo1,nTel,nBI,nome1,gen1,data,fP,"MicroBiologia",ida,valor,t);	
			}
		});

		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				valor = 1500;
				if(receberDados())
				new JanelaHematologia(codigo1,nTel,nBI,nome1,gen1,data,fP,"Hematologia",ida,valor,t);
						
			}
		});

	}

}
