import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Remover extends JFrame implements ActionListener{
	private Container c;
	private JTextField tfId;
	private JLabel lbTexto;
	private JButton bRemover;
	private Tarefas t;

	public Remover(String titulo,Tarefas t)
	{
		this.t = t;
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(450,100);
		setLocationRelativeTo(null);
		
		c = getContentPane();
		c.setLayout(new FlowLayout());

		makeComponents();
		setVisible(true);
	}

	private void makeComponents()
	{
		lbTexto = new JLabel("Introduza o ID da Analise: ");
		tfId = new JTextField(10);

		bRemover  = new JButton("Remover");
		bRemover.addActionListener(this);

		c.add(lbTexto);
		c.add(tfId);
		c.add(bRemover);
	}

	public void actionPerformed(ActionEvent ev)
	{
		try{
			int id = Integer.parseInt(tfId.getText());
			int posi = t.pesquisarCodigo(id);
			if(posi<0)
				JOptionPane.showMessageDialog(null,"Analise nao Encontrada!");
			else
			{
				t.removerAnalise(posi);
				JOptionPane.showMessageDialog(null,"Analise removida!");
			}
			setVisible(false);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,"Preencha correctamente o espaco!");}
	}
}