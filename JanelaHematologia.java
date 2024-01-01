import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class JanelaHematologia extends JFrame {
	
	private Container cont;
	private JLabel l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3,t4,t5,t6,t7;
	private JPanel p1,p2,p3,p4;
	private JRadioButton r1,r2;
	private ButtonGroup gb;
	private JButton btn;
	private Tarefas t;
	
	public JanelaHematologia(int cod,int nT,String nB,String nome,String gene,String data,String pa,String tipo,byte ida,double vp,Tarefas t){
		super("Dados Da BioQuimica");
		setLocationRelativeTo(null);
		cont=getContentPane();
		this.t = t;
		p1=new JPanel(new BorderLayout(5,5));
		
		p2=new JPanel(new GridLayout(9,1));
		
		l1=new JLabel("Introduza a quantidade de globulos Vermelhos");
		p2.add(l1);
	
		t1=new JTextField(10);
		p2.add(t1);
		
				
				
		l2=new JLabel("introduza a quantidade de globulos brancos");
        p2.add(l2);
		
		t2=new JTextField(10);
		p2.add(t2);
		
		
		l4=new JLabel("introduza a quantidade de plaquetas");
        p2.add(l4);
		
		t3=new JTextField(10);
		p2.add(t3);
		
		
		
        
        
        p4=new JPanel(new GridLayout(1,3));
        l5=new JLabel("Transporte");
        p4.add(l5);
        r1=new JRadioButton("sim",true);
        p4.add(r1);
        r2=new JRadioButton("nao",false);
        p4.add(r2);
        gb=new ButtonGroup();
		gb.add(r1);
		gb.add(r2);
	    p2.add(p4);
	   
		
		p1.add(p2,BorderLayout.NORTH);
		
		btn=new JButton("Gravar");
	    btn.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent ev){
	    		try{
	    			final int gv=Integer.parseInt(t1.getText());
	    			final int gB=Integer.parseInt(t2.getText());
	    			final int fC=Integer.parseInt(t3.getText());
	    		
	    			Hematologia hm = new Hematologia(cod, nT, nB, nome, gene, data, pa, ida, vp,  gv, gB, fC, r1.isSelected());	
	   				String erros = t.validarAnalise(hm);
	    			JOptionPane.showMessageDialog(null,erros);
	    			if(erros.equalsIgnoreCase("Analise Valida!"))
	    			{
	    				t.adicionarAnalise(hm);
	    				setVisible(false);
	    			}
	    		}catch(NumberFormatException e){
	    			JOptionPane.showMessageDialog(null,"Preencha correctamente os espacos!");
	    		}
	    		
	    	}
	    });
        p1.add(btn,BorderLayout.SOUTH);
	   
        cont.add(p1);
        setVisible(true);
		setSize(300,300);
	}
	
}
