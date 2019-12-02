package br.com.wagstore.frames;

import br.com.wagstore.dal.ConnectionModule;

import java.awt.BorderLayout;
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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Vendas extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;


	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtRastreio;
	private JTextField txtProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendas frame = new Vendas();
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
	public Vendas() {
		setTitle("Painel de Vendas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPainelDeVendas = new JLabel("Painel de Vendas - Wag Store");
		lblPainelDeVendas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPainelDeVendas.setBounds(20, 11, 229, 28);
		contentPane.add(lblPainelDeVendas);
		
		JLabel lblCpf = new JLabel("* CPF");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setBounds(20, 71, 48, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(77, 70, 96, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Vendas.class.getResource("/br/com/wagstore/icon/pesquisar.png")));
		btnNewButton.setBounds(203, 47, 64, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblCdigoDeRastreio = new JLabel("Nome Cliente:");
		lblCdigoDeRastreio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCdigoDeRastreio.setBounds(20, 129, 153, 14);
		contentPane.add(lblCdigoDeRastreio);
		
		txtNome = new JTextField();
		txtNome.setBounds(121, 126, 146, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNomeDoTitular = new JLabel("Produto:");
		lblNomeDoTitular.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNomeDoTitular.setBounds(20, 154, 96, 14);
		contentPane.add(lblNomeDoTitular);
		
		txtRastreio = new JTextField();
		txtRastreio.setBounds(121, 176, 146, 20);
		contentPane.add(txtRastreio);
		txtRastreio.setColumns(10);
		
		JLabel lblProduto = new JLabel("C\u00F3d. Rastreio");
		lblProduto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProduto.setBounds(20, 179, 96, 14);
		contentPane.add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(121, 151, 146, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 2.5");
		lblVerso.setBounds(10, 317, 87, 14);
		contentPane.add(lblVerso);
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatrios.setBounds(292, 18, 132, 19);
		contentPane.add(lblCamposObrigatrios);
		
		JButton btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreate.setIcon(new ImageIcon(Vendas.class.getResource("/br/com/wagstore/icon/create.png")));
		btnCreate.setBounds(87, 298, 64, 64);
		contentPane.add(btnCreate);
		
		JButton btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		
		});
		btnEditar.setIcon(new ImageIcon(Vendas.class.getResource("/br/com/wagstore/icon/update.png")));
		btnEditar.setBounds(163, 298, 64, 64);
		contentPane.add(btnEditar);
		
		JButton btnDeletar = new JButton("");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnDeletar.setIcon(new ImageIcon(Vendas.class.getResource("/br/com/wagstore/icon/delete.png")));
		btnDeletar.setBounds(239, 298, 64, 64);
		contentPane.add(btnDeletar);
		
		JButton btnVisualizarDadosDo = new JButton("Visualizar Dados do Cliente");
		btnVisualizarDadosDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
			}
		});
		btnVisualizarDadosDo.setBounds(39, 220, 200, 23);
		contentPane.add(btnVisualizarDadosDo);
	}
	
	private void limpar() {
		txtCpf.setText(null);
		txtNome.setText(null);
		txtRastreio.setText(null);
		txtProduto.setText(null);
	}
	
	private void adicionar() {
		String create = "insert into tb_vendas (cpf,nomeCliente,produto,rastreio) values(?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			// passagem de parâmetros
			pst.setString(1, txtCpf.getText());
			pst.setString(2, txtNome.getText());
			pst.setString(3, txtRastreio.getText());
			pst.setString(4, txtProduto.getText());
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar a venda!");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim do catch

	}// fim do construtor
	
	private void pesquisar() {
		String read = "select * from tb_vendas where cpf=?";
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
				txtRastreio.setText(rs.getString(3));
				txtProduto.setText(rs.getString(4));
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
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão desta venda?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			String delete = "delete from tb_vendas where cpf=?";

			try {

				pst = (PreparedStatement) con.prepareStatement(delete);
				pst.setString(1, txtCpf.getText());
				int r = pst.executeUpdate();
				if (r > 0) {
					limpar();
					JOptionPane.showMessageDialog(null, "Venda deletada com sucesso!");

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel deletar a venda");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		} // fim do if

	}// fim do construtor
	
	private void atualizar() {
		String update = "update tb_vendas set nomeCliente=?, produto=?, rastreio=? where cpf=?";
		try {
			
			pst = (PreparedStatement) con.prepareStatement(update);
			// passagem de parâmetros
			// o id é o ultimo parâmetro
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtProduto.getText());
			pst.setString(3, txtRastreio.getText());
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar o produtp");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim
	}// fim do construtor
}
