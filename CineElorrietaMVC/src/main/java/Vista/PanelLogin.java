package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.ControladorPanelLogin;

public class PanelLogin extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField passContrasena;
	private JLabel lblError;
	private JLabel lblLogin;

	/**
	 * Create the panel.
	 */
	public PanelLogin(ControladorPanelLogin controladorPanelLogin) {
		setBackground(Color.DARK_GRAY);
		
		setLayout(null);
		
		JLabel lblContrasena = new JLabel("CONTRASE\u00D1A:");
		lblContrasena.setFont(new Font("Shocking Headline", Font.PLAIN, 16));
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setBounds(115, 233, 116, 14);
		add(lblContrasena);
		
		JLabel lblUsuario = new JLabel("USUARIO:");
		lblUsuario.setFont(new Font("Shocking Headline", Font.PLAIN, 16));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(115, 202, 97, 14);
		add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(252, 199, 121, 20);
		add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passContrasena = new JPasswordField();
		passContrasena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				  if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	   controladorPanelLogin.accionadoBotonEntrarPanelLogin(txtUsuario.getText()
								, String.valueOf(getPassContrasena().getPassword()));
			       }
			}
		});
		passContrasena.setBounds(252, 230, 121, 20);
		add(passContrasena);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controladorPanelLogin.accionadoBotonEntrarPanelLogin(txtUsuario.getText()
						, String.valueOf(getPassContrasena().getPassword()));
				
				
			}
		});
		btnEntrar.setBounds(198, 327, 89, 23);
		add(btnEntrar);
		
		lblError = new JLabel("usuario/contrase\u00F1a incorrectos");
		lblError.setForeground(Color.RED);
		lblError.setBounds(164, 283, 272, 14);
		add(lblError);
		
		lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 40));
		lblLogin.setBounds(172, 78, 143, 55);
		add(lblLogin);
		lblError.setVisible(false);
	

	}

	public JLabel getLblError() {
		return lblError;
	}

	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getPassContrasena() {
		return passContrasena;
	}

	public void setPassContrasena(JPasswordField passContrasena) {
		this.passContrasena = passContrasena;
	}
	public void mostrarLoginError() {
		this.getLblError().setVisible(true);
	}

}