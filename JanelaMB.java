import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JanelaMB extends JFrame{
	private Container cont;
	private JLabel l1,l2;
	private JPanel p1,p2,p3,p4,p5;
	private JRadioButton r1,r2,r3,r4;
	private ButtonGroup bg,bg1;
	private JButton btn;
	private Tarefas t;
	public JanelaMB(int cod,int nT,String nB,String nome,String gene,String data,String pa,String tipo,byte ida,double vp,Tarefas t){
		super("MicroBiologia");
		setLocationRelativeTo(null);
		cont=getContentPane();
		this.t = t;

		p1=new JPanel(new GridLayout(3,1));
		p2=new JPanel(new BorderLayout(1,1));
		l1=new JLabel("Bacteria na urina");
		p2.add(l1,BorderLayout.CENTER);
		p1.add(p2);
		
		p3=new JPanel(new GridLayout(1,2));
		r1=new JRadioButton("sim",true);
		p3.add(r1);
		
		r2=new JRadioButton("nao",false);
		p3.add(r2);
		p1.add(p3);
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		p4=new JPanel(new BorderLayout(1,1));
		l2=new JLabel("Bacteria nas fezes");
		p4.add(l2,BorderLayout.CENTER);
		p1.add(p4);
		
		
		p5=new JPanel(new GridLayout(1,2));
		
		r3=new JRadioButton("sim",true);
		p5.add(r3);
		
		r4=new JRadioButton("nao",false);
		p5.add(r4);
		p1.add(p5);
		bg1=new ButtonGroup();
		bg1.add(r3);
		bg1.add(r4);

		
		btn=new JButton("Gravar");
	    btn.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent ev){
	    	
	    		Microbiologia mc = new Microbiologia(cod, nT, nB, nome, gene, data, pa, ida, vp,r1.isSelected(),r3.isSelected());
	    		String erros = t.validarAnalise(mc);
	    		JOptionPane.showMessageDialog(null,erros);
	    		if(erros.equalsIgnoreCase("Analise Valida!"))
	    		{
	    			t.adicionarAnalise(mc);
	    			setVisible(false);
	    		}
	    		
	    	}
	    });
      
	   p1.add(btn);
        cont.add(p1);
        setVisible(true);
		setSize(300,300);
		
		
	}
	
}
