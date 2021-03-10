package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PainelEntregaDeProduto extends JPanel {

	private JLabel lblEntregaDeProdutos;
	private JLabel jLabelCliente;
	private JTextField jTextFieldCliente;
	private JLabel jLabelEndereo;
	private JTextField jTextFieldEndereco;
	private JLabel jLabelNumero;
	private JTextField jTextFieldNumero;
	private JLabel jLabelComplemento;
	private JTextField jTextFieldComplemento;
	private JLabel jLabelBairro;
	private JTextField jTextFieldBairro;
	private JLabel jLabelCidade;
	private JTextField jTextFieldCidade;
	private JComboBox<String> jComboBoxUF;
	private JLabel jLabelUf;
	private JLabel jLabelCep;
	private JTextField jTextFieldCEP;
	private JLabel jLabelTelefone;
	private JTextField jTextFieldTelefone;
	private JTextField jTextFieldCelular;
	private JLabel jLabelCelular;
	private JTextField jTextFieldDataDeEntrega;
	private JLabel jLabelDataDaEntrega;
	private DefaultTableModel defaultTableModelEntregaEsquerda;
	private JTable jTableEntregaEsquerda;
	private JScrollPane barraRolagemEntregaEsquerda;
	private DefaultTableModel defaultTableModelEntregaDireita;
	private JTable jTableEntregaDireita;
	private JScrollPane barraRolagemEntregaDireita;
	private JButton jButtonUmMaiorQue;
	private JButton jButtonDoisMaiorQue;
	private JButton jButtonUmMenorQue;
	private JButton jButtonDoisMenorQue;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	public PainelEntregaDeProduto()
	{
		setBackground(Color.LIGHT_GRAY);
		setSize(1197,693);
		setLayout(null);
		add(getLblEntregaDeProdutos());
		add(getJLabelCliente());
		add(getJTextFieldCliente());
		add(getJLabelEndereo());
		add(getJTextFieldEndereco());
		add(getJLabelNumero());
		add(getJTextFieldNumero());
		add(getJLabelComplemento());
		add(getJTextFieldComplemento());
		add(getJLabelBairro());
		add(getJTextFieldBairro());
		add(getJLabelCidade());
		add(getJTextFieldCidade());
		add(getJComboBoxUF());
		add(getJLabelUf());
		add(getJLabelCep());
		add(getJTextFieldCEP());
		add(getJLabelTelefone());
		add(getJTextFieldTelefone());
		add(getJTextFieldCelular());
		add(getJLabelCelular());
		add(getJTextFieldDataDeEntrega());
		add(getJLabelDataDaEntrega());
		add(getBarraRolagemEntregaEsquerda());
		add(getBarraRolagemEntregaDireita());
		add(getJButtonUmMaiorQue());
		add(getJButtonDoisMaiorQue());
		add(getJButtonUmMenorQue());
		add(getJButtonDoisMenorQue());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getLblEntregaDeProdutos() {
		if (lblEntregaDeProdutos == null) {
			lblEntregaDeProdutos = new JLabel("Entrega de produtos");
			lblEntregaDeProdutos.setFont(new Font("Arial", Font.BOLD, 32));
			lblEntregaDeProdutos.setBounds(79, 39, 319, 65);
		}
		return lblEntregaDeProdutos;
	}

	public JLabel getJLabelCliente() {
		if (jLabelCliente == null) {
			jLabelCliente = new JLabel("Cliente");
			jLabelCliente.setBounds(79, 126, 46, 22);
		}
		return jLabelCliente;
	}

	public JTextField getJTextFieldCliente() {
		if (jTextFieldCliente == null) {
			jTextFieldCliente = new JTextField();
			jTextFieldCliente.setColumns(10);
			jTextFieldCliente.setBounds(79, 146, 220, 22);
		}
		return jTextFieldCliente;
	}

	public JLabel getJLabelEndereo() {
		if (jLabelEndereo == null) {
			jLabelEndereo = new JLabel("Endere\u00E7o");
			jLabelEndereo.setBounds(314, 126, 81, 22);
		}
		return jLabelEndereo;
	}

	public JTextField getJTextFieldEndereco() {
		if (jTextFieldEndereco == null) {
			jTextFieldEndereco = new JTextField();
			jTextFieldEndereco.setColumns(10);
			jTextFieldEndereco.setBounds(314, 146, 240, 22);
		}
		return jTextFieldEndereco;
	}

	public JLabel getJLabelNumero() {
		if (jLabelNumero == null) {
			jLabelNumero = new JLabel("N\u00FAmero");
			jLabelNumero.setBounds(569, 126, 46, 22);
		}
		return jLabelNumero;
	}

	public JTextField getJTextFieldNumero() {
		if (jTextFieldNumero == null) {
			jTextFieldNumero = new JTextField();
			jTextFieldNumero.setColumns(10);
			jTextFieldNumero.setBounds(569, 146, 66, 22);
		}
		return jTextFieldNumero;
	}

	public JLabel getJLabelComplemento() {
		if (jLabelComplemento == null) {
			jLabelComplemento = new JLabel("Complemento");
			jLabelComplemento.setBounds(651, 126, 81, 22);
		}
		return jLabelComplemento;
	}

	public JTextField getJTextFieldComplemento() {
		if (jTextFieldComplemento == null) {
			jTextFieldComplemento = new JTextField();
			jTextFieldComplemento.setColumns(10);
			jTextFieldComplemento.setBounds(651, 146, 167, 22);
		}
		return jTextFieldComplemento;
	}

	public JLabel getJLabelBairro() {
		if (jLabelBairro == null) {
			jLabelBairro = new JLabel("Bairro");
			jLabelBairro.setBounds(828, 126, 156, 22);
		}
		return jLabelBairro;
	}

	public JTextField getJTextFieldBairro() {
		if (jTextFieldBairro == null) {
			jTextFieldBairro = new JTextField();
			jTextFieldBairro.setColumns(10);
			jTextFieldBairro.setBounds(828, 146, 156, 22);
		}
		return jTextFieldBairro;
	}

	public JLabel getJLabelCidade() {
		if (jLabelCidade == null) {
			jLabelCidade = new JLabel("Cidade");
			jLabelCidade.setBounds(79, 179, 46, 22);
		}
		return jLabelCidade;
	}

	public JTextField getJTextFieldCidade() {
		if (jTextFieldCidade == null) {
			jTextFieldCidade = new JTextField();
			jTextFieldCidade.setColumns(10);
			jTextFieldCidade.setBounds(79, 199, 220, 22);
		}
		return jTextFieldCidade;
	}

	public JComboBox<String> getJComboBoxUF() {
		if (jComboBoxUF == null) {
			jComboBoxUF = new JComboBox<String>();
			jComboBoxUF.setModel(new DefaultComboBoxModel(new String[] {"--", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
			jComboBoxUF.setBounds(318, 200, 81, 20);
		}
		return jComboBoxUF;
	}

	public JLabel getJLabelUf() {
		if (jLabelUf == null) {
			jLabelUf = new JLabel("UF");
			jLabelUf.setBounds(318, 179, 46, 22);
		}
		return jLabelUf;
	}

	public JLabel getJLabelCep() {
		if (jLabelCep == null) {
			jLabelCep = new JLabel("CEP");
			jLabelCep.setBounds(430, 179, 58, 22);
		}
		return jLabelCep;
	}

	public JTextField getJTextFieldCEP() {
		if (jTextFieldCEP == null) {
			jTextFieldCEP = new JTextField();
			jTextFieldCEP.setColumns(10);
			jTextFieldCEP.setBounds(430, 199, 119, 22);
		}
		return jTextFieldCEP;
	}

	public JLabel getJLabelTelefone() {
		if (jLabelTelefone == null) {
			jLabelTelefone = new JLabel("Telefone");
			jLabelTelefone.setBounds(573, 179, 81, 22);
		}
		return jLabelTelefone;
	}

	public JTextField getJTextFieldTelefone() {
		if (jTextFieldTelefone == null) {
			jTextFieldTelefone = new JTextField();
			jTextFieldTelefone.setColumns(10);
			jTextFieldTelefone.setBounds(573, 199, 119, 22);
		}
		return jTextFieldTelefone;
	}

	public JTextField getJTextFieldCelular() {
		if (jTextFieldCelular == null) {
			jTextFieldCelular = new JTextField();
			jTextFieldCelular.setColumns(10);
			jTextFieldCelular.setBounds(717, 199, 119, 22);
		}
		return jTextFieldCelular;
	}

	public JLabel getJLabelCelular() {
		if (jLabelCelular == null) {
			jLabelCelular = new JLabel("Celular");
			jLabelCelular.setBounds(717, 179, 81, 22);
		}
		return jLabelCelular;
	}

	public JTextField getJTextFieldDataDeEntrega() {
		if (jTextFieldDataDeEntrega == null) {
			jTextFieldDataDeEntrega = new JTextField();
			jTextFieldDataDeEntrega.setColumns(10);
			jTextFieldDataDeEntrega.setBounds(857, 199, 127, 22);
		}
		return jTextFieldDataDeEntrega;
	}

	public JLabel getJLabelDataDaEntrega() {
		if (jLabelDataDaEntrega == null) {
			jLabelDataDaEntrega = new JLabel("Data da entrega");
			jLabelDataDaEntrega.setBounds(857, 179, 127, 22);
		}
		return jLabelDataDaEntrega;
	}

	public DefaultTableModel getDefaultTableModelEntregaEsquerda() {
		if (defaultTableModelEntregaEsquerda == null) {
			defaultTableModelEntregaEsquerda = new DefaultTableModel(new Object[][] {},
					new String[] { "Código", "Descrição", "Quantidade" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelEntregaEsquerda;
	}

	public JTable getJTableEntregaEsquerda() {
		if (jTableEntregaEsquerda == null) {
			jTableEntregaEsquerda = new JTable(getDefaultTableModelEntregaEsquerda());
			jTableEntregaEsquerda.getTableHeader().setReorderingAllowed(false);
			jTableEntregaEsquerda.setRowSelectionAllowed(true);
			jTableEntregaEsquerda.getColumnModel().getColumn(0).setPreferredWidth(300);
			jTableEntregaEsquerda.getColumnModel().getColumn(1).setPreferredWidth(100);
			jTableEntregaEsquerda.getColumnModel().getColumn(2).setPreferredWidth(300);
			jTableEntregaEsquerda.setLocation(79, 384);
			jTableEntregaEsquerda.setSize(700, 317);
		}
		return jTableEntregaEsquerda;
	}

	public JScrollPane getBarraRolagemEntregaEsquerda() {
		if (barraRolagemEntregaEsquerda == null) {
			barraRolagemEntregaEsquerda = new JScrollPane(getJTableEntregaEsquerda());
			barraRolagemEntregaEsquerda.setLocation(82, 251);
			barraRolagemEntregaEsquerda.setSize(357, 413);
		}
		return barraRolagemEntregaEsquerda;
	}

	public DefaultTableModel getDefaultTableModelEntregaDireita() {
		if (defaultTableModelEntregaDireita == null) {
			defaultTableModelEntregaDireita = new DefaultTableModel(new Object[][] {},
					new String[] { "Código", "Descrição", "Quantidade" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelEntregaDireita;
	}

	public JTable getJTableEntregaDireita() {
		if (jTableEntregaDireita == null) {
			jTableEntregaDireita = new JTable(getDefaultTableModelEntregaEsquerda());
			jTableEntregaDireita.getTableHeader().setReorderingAllowed(false);
			jTableEntregaDireita.setRowSelectionAllowed(true);
			jTableEntregaDireita.getColumnModel().getColumn(0).setPreferredWidth(300);
			jTableEntregaDireita.getColumnModel().getColumn(1).setPreferredWidth(100);
			jTableEntregaDireita.getColumnModel().getColumn(2).setPreferredWidth(300);
			jTableEntregaDireita.setLocation(79, 384);
			jTableEntregaDireita.setSize(700, 317);
		}
		return jTableEntregaDireita;
	}

	public JScrollPane getBarraRolagemEntregaDireita() {
		if (barraRolagemEntregaDireita == null) {
			barraRolagemEntregaDireita = new JScrollPane(getJTableEntregaDireita());
			barraRolagemEntregaDireita.setLocation(556, 251);
			barraRolagemEntregaDireita.setSize(357, 413);
		}
		return barraRolagemEntregaDireita;
	}

	public JButton getJButtonUmMaiorQue() {
		if (jButtonUmMaiorQue == null) {
			jButtonUmMaiorQue = new JButton(">");
			jButtonUmMaiorQue.setBounds(464, 312, 66, 23);
		}
		return jButtonUmMaiorQue;
	}

	public JButton getJButtonDoisMaiorQue() {
		if (jButtonDoisMaiorQue == null) {
			jButtonDoisMaiorQue = new JButton(">>");
			jButtonDoisMaiorQue.setBounds(464, 381, 66, 23);
		}
		return jButtonDoisMaiorQue;
	}

	public JButton getJButtonUmMenorQue() {
		if (jButtonUmMenorQue == null) {
			jButtonUmMenorQue = new JButton("<");
			jButtonUmMenorQue.setBounds(464, 463, 66, 23);
		}
		return jButtonUmMenorQue;
	}

	public JButton getJButtonDoisMenorQue() {
		if (jButtonDoisMenorQue == null) {
			jButtonDoisMenorQue = new JButton("<<");
			jButtonDoisMenorQue.setBounds(464, 554, 66, 23);
		}
		return jButtonDoisMenorQue;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(1000, 568, 145, 40);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(1000, 624, 145, 40);
		}
		return jButtonCancelar;
	}
}
