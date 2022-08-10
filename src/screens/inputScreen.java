package screens;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout.Constraints;

import ContainerClass.ImplFilhaThread;
import ContainerClass.ObjetoFilaThread;

public class inputScreen   extends JDialog  {
	
	private JPanel window = new JPanel(new GridBagLayout());
	private JLabel lblTitulo = new JLabel();
	private JLabel lblNome = new JLabel();
	private JLabel lblEmail = new JLabel();
	private JTextField tfNome = new JTextField();
	private JTextField tfEmail = new JTextField();
	private JButton btnEnviar  = new JButton();
	private JButton btnCancel  = new JButton();
	
	// Thread objeto		
	ImplFilhaThread FilhaThread = new ImplFilhaThread(); 
			
	int z = 0;
	
	public inputScreen() {
		setTitle("Pilha & thread ");
		setSize(new Dimension(640,480));
		setLocation(Integer.valueOf((int) Window.CENTER_ALIGNMENT),Integer.valueOf((int) Window.CENTER_ALIGNMENT));
		setResizable(false);
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.insets = new Insets(1,1,1,1);
		gridConstraints.gridwidth = 2;
		
		lblTitulo.setPreferredSize(new Dimension(300,50));
		lblTitulo.setText("Pilha de Processos");
		window.add(lblTitulo,gridConstraints);
		
		gridConstraints.gridy++;
		lblNome.setPreferredSize(new Dimension(200,25));
		lblNome.setText("Nome");
		window.add(lblNome,gridConstraints);
		
		gridConstraints.gridy++;
		tfNome.setPreferredSize(new Dimension(200,25));
		//tfNome.setText("Email");
		window.add(tfNome,gridConstraints);
		
		
		gridConstraints.gridy++;
		lblEmail.setPreferredSize(new Dimension(200,25));
		lblEmail.setText("Email");
		window.add(lblEmail,gridConstraints);
		
		gridConstraints.gridy++;
		tfEmail.setPreferredSize(new Dimension(200,25));
		//tfNome.setText("Email");
		window.add(tfEmail,gridConstraints);
		
		gridConstraints.gridwidth = 1;
		
		gridConstraints.gridy++;
		btnEnviar.setPreferredSize(new Dimension(100,25));
		btnEnviar.setText("Enviar");
		window.add(btnEnviar,gridConstraints);
		
		gridConstraints.gridx++;
		btnCancel.setPreferredSize(new Dimension(100,25));
		btnCancel.setText("Pause");
		window.add(btnCancel,gridConstraints);
		
		
		
		//***************************************************
		
		
		btnEnviar.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {

				if(FilhaThread == null) {
					FilhaThread = new ImplFilhaThread(); 
					FilhaThread.start();
					btnEnviar.setText("Enviar");
				}else {
					ObjetoFilaThread Objeto = new ObjetoFilaThread();
					Objeto.setNome(tfNome.getText() + z);
					Objeto.setEmail(tfEmail.getText());
					FilhaThread.add(Objeto);
					z++;
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(FilhaThread != null) {
					FilhaThread.stop();
					FilhaThread = null;
					btnEnviar.setText("Continue");
				}
			}
		});

		
		
		FilhaThread.start();
		
		
		add(window,BorderLayout.CENTER);
		setVisible(true);
	}
	
	

}
