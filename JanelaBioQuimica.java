import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class JanelaBioQuimica extends JFrame{
	private Container cont;
	private JLabel l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3,t4,t5,t6,t7;
	private JPanel p1,p2,p3;
	private JButton btn;
	private Tarefas t;

	public JanelaBioQuimica(int cod,int nT,String nB,String nome,String gene,String data,String pa,String tipo,byte ida,double vp,Tarefas t){
		super("Dados Bioquimica");
		setLocationRelativeTo(null);
		cont=getContentPane();
		this.t=t;
		p1=new JPanel(new BorderLayout(5,5));
		
		p2=new JPanel(new GridLayout(10,1));
		
		l1=new JLabel("Introduza a quantidade de glicose");
		p2.add(l1);
	
		t1=new JTextField(10);
		p2.add(t1);
		
				
		l2=new JLabel("introduza a quantidade de colestrol");
        p2.add(l2);
		
		t2=new JTextField(10);
		p2.add(t2);
		
		
		l3=new JLabel("valores de funcoo cardiaca");
        p2.add(l3);
		
		t3=new JTextField(10);
		p2.add(t3);
		
		
		l4=new JLabel("valores de funcao renal");
        p2.add(l4);
		
		t4=new JTextField(10);
		p2.add(t4);
		
		p1.add(p2,BorderLayout.NORTH);
		
		btn=new JButton("Gravar");
	    btn.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent ev){
	    		try{
	    			final float glicose=Float.parseFloat(t1.getText());
	    			final float col=Float.parseFloat(t2.getText());
	    			final float fC=Float.parseFloat(t3.getText());
	    			final float renal=Float.parseFloat(t4.getText());

		    		Bioquimica bquimica = new Bioquimica(cod, nT, nB, nome, gene, data, pa, ida, vp, glicose, col, fC, renal);
		    		String erros = t.validarAnalise(bquimica);
		    		JOptionPane.showMessageDialog(null,erros);
		    		if(erros.equalsIgnoreCase("Analise Valida!"))
		    		{
		    			t.adicionarAnalise(bquimica);
		    			setVisible(false);
		    		}
		    	}catch(NumberFormatException e){
		    		JOptionPane.showMessageDialog(null,"Preencha os espacos correctamente!");
		    	}
	    		
	    	}
	    });
        p1.add(btn,BorderLayout.SOUTH);
	   
        cont.add(p1);
        setVisible(true);
		setSize(300,300);
		
		
	}
	

}
