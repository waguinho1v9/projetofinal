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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.Color;

public class Estoque extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtRef;
	private JTextField txtMarca;
	private JTextField txtCor;
	private JTextField txtModelo;
	private JTextField txtQtd;
	private JTextField txtTamanho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque();
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
	public Estoque() {
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 471, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelDeEstoque = new JLabel("Estoque de Produtos");
		lblPainelDeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPainelDeEstoque.setBounds(10, 12, 261, 32);
		contentPane.add(lblPainelDeEstoque);
		
		JLabel lblReferencia = new JLabel("* Refer\u00EAncia");
		lblReferencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReferencia.setBounds(10, 81, 106, 14);
		contentPane.add(lblReferencia);
		
		txtRef = new JTextField();
		txtRef.setBounds(103, 80, 179, 20);
		contentPane.add(txtRef);
		txtRef.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnSearch.setIcon(new ImageIcon(Estoque.class.getResource("/br/com/wagstore/icon/pesquisar.png")));
		btnSearch.setBounds(304, 69, 89, 41);
		contentPane.add(btnSearch);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBackground(Color.LIGHT_GRAY);
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(10, 166, 48, 14);
		contentPane.add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCor.setBounds(25, 195, 48, 14);
		contentPane.add(lblCor);
		
		JLabel lblTamanho = new JLabel("Tamanho");
		lblTamanho.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTamanho.setBounds(10, 227, 63, 14);
		contentPane.add(lblTamanho);
		
		txtCor = new JTextField();
		txtCor.setBounds(68, 193, 203, 20);
		contentPane.add(txtCor);
		txtCor.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(68, 164, 203, 20);
		contentPane.add(txtModelo);
		txtModelo.setColumns(10);
		
		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setIcon(new ImageIcon(Estoque.class.getResource("/br/com/wagstore/icon/create.png")));
		btnCreate.setBounds(113, 305, 64, 64);
		contentPane.add(btnCreate);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnDelete.setIcon(new ImageIcon(Estoque.class.getResource("/br/com/wagstore/icon/delete.png")));
		btnDelete.setBounds(262, 305, 64, 64);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Estoque.class.getResource("/br/com/wagstore/icon/update.png")));
		btnNewButton.setBounds(187, 305, 64, 64);
		contentPane.add(btnNewButton);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 2.5");
		lblVerso.setBounds(10, 331, 63, 14);
		contentPane.add(lblVerso);
		
		JLabel lblQuantidade = new JLabel("Qtd");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantidade.setBounds(25, 265, 71, 14);
		contentPane.add(lblQuantidade);
		
		txtQtd = new JTextField();
		txtQtd.setBounds(68, 263, 203, 20);
		contentPane.add(txtQtd);
		txtQtd.setColumns(10);
		
		txtTamanho = new JTextField();
		txtTamanho.setBounds(68, 225, 203, 20);
		contentPane.add(txtTamanho);
		txtTamanho.setColumns(10);
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatrios.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCamposObrigatrios.setBounds(307, 22, 148, 14);
		contentPane.add(lblCamposObrigatrios);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(68, 129, 203, 20);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMarca.setBounds(10, 132, 48, 14);
		contentPane.add(lblMarca);
	}
	
	private void limpar() {
		txtRef.setText(null);
		txtMarca.setText(null);
		txtCor.setText(null);
		txtTamanho.setText(null);
		txtModelo.setText(null);
		txtQtd.setText(null);
	}
	
	private void adicionar() {
		String create = "insert into estoque (marca,modelo,cor,tamanho,quantidade) values(?,?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			// passagem de parâmetros
			pst.setString(1, txtMarca.getText());
			pst.setString(2, txtModelo.getText());
			pst.setString(3, txtCor.getText());
			pst.setString(4, txtTamanho.getText());
			pst.setString(5, txtQtd.getText());
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso no estoque!");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar o produto no estoque!");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim do catch

	}// fim do construtor
	
	private void pesquisar() {
		String read = "select * from estoque where id =?";
		// Usamos o try catch para tratar exceção
		try {
			pst = (PreparedStatement) con.prepareStatement(read);
			// passagem do parâmetro
			pst.setString(1, txtRef.getText());
			// atribuimos a variavel rs retorno do comando
			rs = pst.executeQuery();// Executar a query(sql)
			//
			if (rs.next()) {
				txtMarca.setText(rs.getString(2));
				txtModelo.setText(rs.getString(3));
				txtCor.setText(rs.getString(4));
				txtTamanho.setText(rs.getString(5));
				txtQtd.setText(rs.getString(6));
			} else {
				JOptionPane.showMessageDialog(null, "Produto Inexistente");
				limpar();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}// fim do construtor
	
	private void remover() {
		// criar uma caixa de diálogo para confirmar a exclusão
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste produto?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			String delete = "delete from estoque where id=?";

			try {

				pst = (PreparedStatement) con.prepareStatement(delete);
				pst.setString(1, txtRef.getText());
				int r = pst.executeUpdate();
				if (r > 0) {
					limpar();
					JOptionPane.showMessageDialog(null, "Produto deletado com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel deletar o produto");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} // fim do if

	}// fim do construtor
	
	private void atualizar() {
		String update = "update estoque set marca=?, modelo=?, cor=?, tamanho=?, quantidade=? where id=?";
		try {
			
			pst = (PreparedStatement) con.prepareStatement(update);
			// passagem de parâmetros
			// o id é o ultimo parâmetro
			pst.setString(1, txtMarca.getText());
			pst.setString(2, txtModelo.getText());
			pst.setString(3, txtCor.getText());
			pst.setString(4, txtTamanho.getText());
			pst.setString(5, txtQtd.getText());
			pst.setString(6, txtRef.getText());
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar o produto");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim
	}// fim do construtor
}
