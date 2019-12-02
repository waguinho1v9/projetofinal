package br.com.wagstore.frames;

import java.awt.BorderLayout;

import br.com.wagstore.dal.ConnectionModule;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login do Painel de Administra\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPainel = new JLabel("Login - Painel Administrativo");
		lblLoginPainel.setForeground(new Color(255, 255, 255));
		lblLoginPainel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginPainel.setBounds(94, 24, 283, 20);
		contentPane.add(lblLoginPainel);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setForeground(new Color(255, 255, 255));
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsurio.setBounds(33, 81, 84, 14);
		contentPane.add(lblUsurio);
		
		txtUser = new JTextField();
		txtUser.setBounds(99, 80, 194, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setBackground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(33, 121, 48, 14);
		contentPane.add(lblSenha);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(99, 120, 194, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 2.5");
		lblVerso.setForeground(new Color(255, 255, 255));
		lblVerso.setBounds(10, 236, 71, 14);
		contentPane.add(lblVerso);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.setBounds(143, 184, 103, 25);
		contentPane.add(btnLogin);
	}
	
	//login
		private void login() {
			String read = "select * from usuarios where email =? and senha =?";
			try {
				pst = (PreparedStatement) con.prepareStatement(read);
				pst.setString(1, txtUser.getText());
				pst.setString(2, txtPassword.getText());
				rs = pst.executeQuery();
				if(rs.next()) {
					String perfil = rs.getString(2);
					if(perfil.equals("admin")) {
						Principal principal = new Principal();
						principal.setVisible(true);					
					}
					else {
						Principal principal = new Principal();
						principal.setVisible(true);
						// Centralizar o Jframe
						principal.setLocationRelativeTo(null);
						this.dispose();
						
						}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuário Inválido! Verifique os dados.");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
} 

