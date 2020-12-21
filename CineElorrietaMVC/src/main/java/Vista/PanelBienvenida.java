package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controlador.ControladorPanelBienvenida;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

@SuppressWarnings("serial")
public class PanelBienvenida extends JPanel{
	private JLabel lblBienvenida;
	private ControladorPanelBienvenida controladorPanelBienvenida;
	
	public PanelBienvenida(ControladorPanelBienvenida controladorPanelBienvenida) {
		setBackground(Color.BLACK);
		this.controladorPanelBienvenida = controladorPanelBienvenida;
		setLayout(null);
		
		lblBienvenida = new JLabel("BIENVENIDOS");
		lblBienvenida.setBounds(80, 133, 367, 121);
		lblBienvenida.setForeground(Color.WHITE);
		lblBienvenida.setFont(new Font("Arial", Font.BOLD, 50));
		add(lblBienvenida);
		
		JLabel lblNewLabel = new JLabel("CARTELERA DE CINE ELORRIETA");
		lblNewLabel.setBounds(66, 253, 367, 44);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		add(lblNewLabel);
		
		initializeEvents();
	}
	
	private void initializeEvents() {
	}
}


