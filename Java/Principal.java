package br.com.wagstore.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;
	public Object btnVendas;
	public Object btnEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setResizable(false);
		setTitle("Painel Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 513);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEstoque = new JButton("");
		btnEstoque.setIcon(new ImageIcon(Principal.class.getResource("/br/com/wagstore/icon/estoque.png")));
		btnEstoque.setToolTipText("Estoque");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque estoque = new Estoque();
				estoque.setVisible(true);
			}
		});
		btnEstoque.setBounds(48, 97, 128, 128);
		contentPane.add(btnEstoque);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/br/com/wagstore/icon/cadastro.png")));
		btnNewButton_1.setToolTipText("Cadastro");
		btnNewButton_1.setBounds(141, 268, 128, 128);
		contentPane.add(btnNewButton_1);
		
		JButton btnVendas = new JButton("");
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vendas vendas = new Vendas();
				vendas.setVisible(true);
			}
		});
		btnVendas.setIcon(new ImageIcon(Principal.class.getResource("/br/com/wagstore/icon/vendas.png")));
		btnVendas.setToolTipText("Vendas");
		btnVendas.setBounds(236, 97, 128, 128);
		contentPane.add(btnVendas);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setBounds(10, 428, 89, 23);
		contentPane.add(btnSobre);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(388, 43, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblPainelAdministrativoDo = new JLabel("Painel Administrativo do Wag Store");
		lblPainelAdministrativoDo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPainelAdministrativoDo.setBounds(48, 35, 316, 34);
		contentPane.add(lblPainelAdministrativoDo);
	}
}
