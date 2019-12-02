package br.com.wagstore.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.wagstore.dal.ConnectionModule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cadastro extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtSobrenome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {	
		setTitle("Painel de Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelDeCadastro = new JLabel("Painel de Cadastro de Clientes");
		lblPainelDeCadastro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPainelDeCadastro.setBounds(10, 27, 257, 14);
		contentPane.add(lblPainelDeCadastro);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(10, 68, 48, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(47, 65, 124, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Cadastro.class.getResource("/br/com/wagstore/icon/pesquisar.png")));
		btnNewButton.setBounds(181, 61, 89, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNome.setBounds(10, 128, 48, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(77, 125, 229, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Email");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTelefone.setBounds(10, 212, 48, 14);
		contentPane.add(lblTelefone);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(77, 210, 229, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel txtLogradouro = new JLabel("Logradouro");
		txtLogradouro.setFont(new Font("Dialog", Font.BOLD, 12));
		txtLogradouro.setBounds(10, 255, 81, 14);
		contentPane.add(txtLogradouro);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(77, 253, 229, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCep.setBounds(10, 298, 48, 14);
		contentPane.add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(77, 296, 229, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCidade.setBounds(10, 341, 48, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(77, 339, 229, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Dialog", Font.BOLD, 12));
		lblEstado.setBounds(10, 381, 48, 14);
		contentPane.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(77, 379, 229, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		button.setIcon(new ImageIcon(Cadastro.class.getResource("/br/com/wagstore/icon/create.png")));
		button.setBounds(345, 356, 64, 64);
		contentPane.add(button);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(77, 165, 229, 20);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSobrenome.setBounds(10, 167, 81, 14);
		contentPane.add(lblSobrenome);
	}
	
	private void limpar() {
		txtCpf.setText(null);
		txtNome.setText(null);
		txtSobrenome.setText(null);
		txtEmail.setText(null);
		txtEndereco.setText(null);
		txtCep.setText(null);
		txtCidade.setText(null);
		txtEstado.setText(null);
	}
	
	private void adicionar() {
		String create = "insert into clientes (nome,sobrenome,cpf,email,endereco,cidade,estado,cep) values(?,?,?,?,?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			// passagem de parâmetros
			
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtSobrenome.getText());
			pst.setString(3, txtCpf.getText());
			pst.setString(4, txtEmail.getText());
			pst.setString(5, txtEndereco.getText());
			pst.setString(6, txtCidade.getText());
			pst.setString(7, txtEstado.getText());
			pst.setString(8, txtCep.getText());
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro!");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim do catch

	}// fim do construtor
	
	private void pesquisar() {
		String read = "select * from clientes where cpf=?";
		// Usamos o try catch para tratar exceção
		try {
			pst = (PreparedStatement) con.prepareStatement(read);
			// passagem do parâmetro
			pst.setString(1, txtCpf.getText());
			// atribuimos a variavel rs retorno do comando
			rs = pst.executeQuery();// Executar a query(sql)
			//
			if (rs.next()) {
				txtNome.setText(rs.getString(2));
				txtSobrenome.setText(rs.getString(3));
				txtEmail.setText(rs.getString(4));
				txtEndereco.setText(rs.getString(5));
				txtCep.setText(rs.getString(6));
				txtCidade.setText(rs.getString(7));
				txtEstado.setText(rs.getString(8));
			} else {
				JOptionPane.showMessageDialog(null, "Cliente não encontrado no sistema!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do construtor
}
