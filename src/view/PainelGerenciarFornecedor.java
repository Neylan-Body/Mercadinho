package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.FormataMascaras;
import com.toedter.calendar.JDateChooser;


public class PainelGerenciarFornecedor extends JPanel {

	
	private JLabel label;
	private JRadioButton jRadioButtonPessoaFisica;
	private JRadioButton jRadioButtonPessoaJuridica;
	private JSeparator separatorPJ;
	private JComboBox<String> jComboBoxPesquisaPJ;
	private JTextField jTextFieldPesquisaPJ;
	private JButton jButtonPesquisarPJ;
	private JButton jButtonExcluir;
	private JButton jButtonAlterar;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;
	private DefaultTableModel defaultTableModelFornecedorPJ;
	private JTable jTableFornecedorPJ;
	private JScrollPane barraRolagemFornecedorPJ;
	private JButton jButtonIncluir;
	private JPanel painelPF;
	private JPanel painelPJ;
	private JLabel jLabelCodigoPF;
	private JTextField jTextFieldCodigoPF;
	private JLabel jLabelNomePF;
	private JTextField jTextFieldNomePF;
	private JLabel jLabelCPFPF;
	private JTextField jTextFieldCPFPF;
	private JLabel jLabelRGPF;
	private JTextField jTextFieldRGPF;
	private JLabel jLabelOrgaoEmissorPF;
	private JTextField jTextFieldOrgaoEmissorPF;
	private JLabel jLabelDataEmissaoPF;
	private JLabel jLabelRazaoSocialPJ;
	private JTextField jTextFieldRazaoSocialPJ;
	private JLabel jLabelNacionalidadePF;
	private JTextField jTextFieldNacionalidadePF;
	private JLabel jLabelUFDocPF;
	private JComboBox<String> jComboBoxUFDocPF;
	private JTextField jTextFieldNaturalidadePF;
	private JLabel jLabelNaturalidadePF;
	private JComboBox<String> jComboBoxSexoPF;
	private JLabel jLabelSexoPF;
	private JLabel jLabelCadastradoEmPF;
	private JTextField jTextFieldCEPPF;
	private JLabel jLabelCEPPF;
	private JTextField jTextFieldLogradouroPF;
	private JLabel jLabelLogradouroPF;
	private JLabel jLabelNumeroPF;
	private JTextField jTextFieldNumeroPF;
	private JLabel jLabelComplementoPF;
	private JTextField jTextFieldComplementoPF;
	private JLabel jLabelBairroPF;
	private JTextField jTextFieldBairroPF;
	private JLabel jLabelMunicipioPF;
	private JTextField jTextFieldMunicipioPF;
	private JLabel jLabelUFPF;
	private JComboBox<String> jComboBoxUFPF;
	private JLabel jLabelEmailPF;
	private JTextField jTextFieldEmailPF;
	private JLabel jLabelTelefonePF;
	private JTextField jTextFieldTelefonePF;
	private JLabel jLabelCelularPF;
	private JTextField jTextFieldCelularPF;
	private JRadioButton jRadioButtonInativoPF;
	private JRadioButton jRadioButtonAtivoPF;
	private JLabel jLabelCodigoPJ;
	private JTextField jTextFieldCodigoPJ;
	private JLabel jLabelCNPJPJ;
	private JTextField jTextFieldCNPJPJ;
	private JLabel jLabelIEPJ;
	private JTextField jTextFieldIEPJ;
	private JLabel jLabelCadastradoEmPJ;
	private JTextField jTextFieldCEPPJ;
	private JLabel jLabelCEPPJ;
	private JTextField jTextFieldLogradouroPJ;
	private JLabel jLabelLogradouroPJ;
	private JLabel jLabelNumeroPJ;
	private JTextField jTextFieldNumeroPJ;
	private JLabel jLabelComplementoPJ;
	private JTextField jTextFieldComplementoPJ;
	private JLabel jLabelBairroPJ;
	private JTextField jTextFieldBairroPJ;
	private JLabel jLabelMunicipioPJ;
	private JTextField jTextFieldMunicipioPJ;
	private JLabel jLabelUFPJ;
	private JComboBox<String> jComboBoxUFPJ;
	private JLabel jLabelEmailPJ;
	private JTextField jTextFieldEmailPJ;
	private JLabel jLabelTelefonePJ;
	private JTextField jTextFieldTelefonePJ;
	private JLabel jLabelCelularPJ;
	private JTextField jTextFieldCelularPJ;
	private JRadioButton jRadioButtonInativoPJ;
	private JRadioButton jRadioButtonAtivoPJ;
	private DefaultTableModel defaultTableModelFornecedorPF;
	private JTable jTableFornecedorPF;
	private JScrollPane barraRolagemFornecedorPF;
	private JComboBox<String> jComboBoxPesquisaPF;
	private JTextField jTextFieldPesquisaPF;
	private JButton jButtonPesquisarPF;
	private JSeparator separatorPF;
	
	private ButtonGroup grupoFis_Jur;
	private ButtonGroup grupoIna_AtiPF;
	private ButtonGroup grupoIna_AtiPJ;
	private JDateChooser jDateChooserCadastradoEmPJ;
	private JDateChooser jDateChooserDataDeEmissaoPF;
	private JDateChooser jDateChooserCadastradoEmPF;
	

	public PainelGerenciarFornecedor()
	{
		setBackground(Color.LIGHT_GRAY);
		setSize(1197,693);
		setLayout(null);
		add(getLabel());
		add(getJRadioButtonPessoaFisica());
		add(getJRadioButtonPessoaJuridica());
		add(getJButtonExcluir());
		add(getJButtonAlterar());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
		add(getJButtonIncluir());
		add(getPainelPJ());
		add(getPainelPF());
		getPainelPF().setVisible(false);
		getPainelPJ().setVisible(false);
	}
	public JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Gerenciar fornecedor");
			label.setFont(new Font("Arial", Font.BOLD, 32));
			label.setBounds(79, 39, 489, 65);
		}
		return label;
	}
	public JRadioButton getJRadioButtonPessoaFisica() {
		if (jRadioButtonPessoaFisica == null) {
			jRadioButtonPessoaFisica = new JRadioButton("Pessoa F\u00EDsica");
			getgrupoFis_Jur().add(getJRadioButtonPessoaFisica());
			jRadioButtonPessoaFisica.setBackground(Color.LIGHT_GRAY);
			jRadioButtonPessoaFisica.setBounds(79, 101, 109, 23);
		}
		return jRadioButtonPessoaFisica;
	}
	public JRadioButton getJRadioButtonPessoaJuridica() {
		if (jRadioButtonPessoaJuridica == null) {
			jRadioButtonPessoaJuridica = new JRadioButton("Pessoa Jur\u00EDdica");
			getgrupoFis_Jur().add(getJRadioButtonPessoaJuridica());
			jRadioButtonPessoaJuridica.setBackground(Color.LIGHT_GRAY);
			jRadioButtonPessoaJuridica.setBounds(193, 101, 130, 23);
		}
		return jRadioButtonPessoaJuridica;
	}
	public JSeparator getSeparatorPJ() {
		if (separatorPJ == null) {
			separatorPJ = new JSeparator();
			separatorPJ.setBounds(0, 162, 1340, 2);
			separatorPJ.setBackground(Color.BLACK);
		}
		return separatorPJ;
	}
	public JComboBox<String> getJComboBoxPesquisaPJ() {
		if (jComboBoxPesquisaPJ == null) {
			jComboBoxPesquisaPJ = new JComboBox<String>();
			jComboBoxPesquisaPJ.setBounds(76, 175, 119, 22);
			jComboBoxPesquisaPJ.setModel(new DefaultComboBoxModel(new String[] { "--", "Razão social", "Codigo", "CNPJ" }));
		}
		return jComboBoxPesquisaPJ;
	}
	public JTextField getJTextFieldPesquisaPJ() {
		if (jTextFieldPesquisaPJ == null) {
			jTextFieldPesquisaPJ = new JTextField();
			jTextFieldPesquisaPJ.setBounds(206, 175, 595, 22);
			jTextFieldPesquisaPJ.setColumns(10);
		}
		return jTextFieldPesquisaPJ;
	}
	public JButton getJButtonPesquisarPJ() {
		if (jButtonPesquisarPJ == null) {
			jButtonPesquisarPJ = new JButton("Pesquisar");
			jButtonPesquisarPJ.setBounds(811, 175, 173, 23);
		}
		return jButtonPesquisarPJ;
	}
	public JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton("Excluir");
			jButtonExcluir.setForeground(Color.WHITE);
			jButtonExcluir.setBackground(new Color(255,0,0));
			jButtonExcluir.setBounds(422, 670, 111, 23);
		}
		return jButtonExcluir;
	}
	public JButton getJButtonAlterar() {
		if (jButtonAlterar == null) {
			jButtonAlterar = new JButton("Alterar");
			jButtonAlterar.setForeground(Color.WHITE);
			jButtonAlterar.setBackground(new Color(0,0,0));
			jButtonAlterar.setBounds(547, 670, 111, 23);
		}
		return jButtonAlterar;
	}
	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(666, 670, 111, 23);
		}
		return jButtonConfirmar;
	}
	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(785, 670, 98, 23);
		}
		return jButtonCancelar;
	}
	
	
	public DefaultTableModel getDefaultTableModelFornecedorPF() {
		if (defaultTableModelFornecedorPF == null) {
			defaultTableModelFornecedorPF = new DefaultTableModel(new Object[][] {},
					new String[] { "Codigo", "Nome", "CPF", "E-mail"}) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelFornecedorPF;
	}
	
	public DefaultTableModel getDefaultTableModelFornecedorPJ() {
		if (defaultTableModelFornecedorPJ == null) {
			defaultTableModelFornecedorPJ = new DefaultTableModel(new Object[][] {},
					new String[] { "Codigo", "Razão social", "CNPJ", "E-mail" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelFornecedorPJ;
	}
	
	
	public JTable getJTableFornecedorPJ() {
		if (jTableFornecedorPJ == null) {
			jTableFornecedorPJ = new JTable(getDefaultTableModelFornecedorPJ());
			jTableFornecedorPJ.getTableHeader().setReorderingAllowed(false);
			jTableFornecedorPJ.setRowSelectionAllowed(true);
			jTableFornecedorPJ.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTableFornecedorPJ.getColumnModel().getColumn(1).setPreferredWidth(300);
			jTableFornecedorPJ.getColumnModel().getColumn(2).setPreferredWidth(150);
			jTableFornecedorPJ.getColumnModel().getColumn(3).setPreferredWidth(300);
			jTableFornecedorPJ.setLocation(79, 384);
			jTableFornecedorPJ.setSize(700, 317);
		}
		return jTableFornecedorPJ;
	}
	
	public JTable getJTableFornecedorPF() {
		if (jTableFornecedorPF == null) {
			jTableFornecedorPF = new JTable(getDefaultTableModelFornecedorPF());
			jTableFornecedorPF.getTableHeader().setReorderingAllowed(false);
			jTableFornecedorPF.setRowSelectionAllowed(true);
			jTableFornecedorPF.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTableFornecedorPF.getColumnModel().getColumn(1).setPreferredWidth(300);
			jTableFornecedorPF.getColumnModel().getColumn(2).setPreferredWidth(150);
			jTableFornecedorPF.getColumnModel().getColumn(3).setPreferredWidth(300);
			jTableFornecedorPF.setLocation(79, 384);
			jTableFornecedorPF.setSize(700, 317);
		}
		return jTableFornecedorPF;
	}

	public JScrollPane getBarraRolagemFornecedorPJ() {
		if (barraRolagemFornecedorPJ == null) {
			barraRolagemFornecedorPJ = new JScrollPane(getJTableFornecedorPJ());
			barraRolagemFornecedorPJ.setBounds(76, 208, 911, 314);
		}
		return barraRolagemFornecedorPJ;
	}
	
	public JScrollPane getBarraRolagemFornecedorPF() {
		if (barraRolagemFornecedorPF == null) {
			barraRolagemFornecedorPF = new JScrollPane(getJTableFornecedorPF());
			barraRolagemFornecedorPF.setBounds(76, 243, 911, 288);
		}
		return barraRolagemFornecedorPF;
	}
	public JButton getJButtonIncluir() {
		if (jButtonIncluir == null) {
			jButtonIncluir = new JButton("Incluir");
			jButtonIncluir.setForeground(Color.WHITE);
			jButtonIncluir.setBackground(new Color(51,0,255));
			jButtonIncluir.setBounds(301, 670, 111, 23);
		}
		return jButtonIncluir;
	}
	public JPanel getPainelPJ() {
		if (painelPJ == null) {
			painelPJ = new JPanel();
			painelPJ.setLayout(null);
			painelPJ.setBounds(0, 131, 1197, 533);
			painelPJ.setBackground(Color.LIGHT_GRAY);
			painelPJ.add(getJLabelRazaoSocialPJ());
			painelPJ.add(getJTextFieldRazaoSocialPJ());
			painelPJ.add(getJLabelCodigoPJ());
			painelPJ.add(getJTextFieldCodigoPJ());
			painelPJ.add(getJLabelCNPJPJ());
			painelPJ.add(getJTextFieldCNPJPJ());
			painelPJ.add(getJLabelIEPJ());
			painelPJ.add(getJTextFieldIEPJ());
			painelPJ.add(getJLabelCadastradoEmPJ());
			painelPJ.add(getJTextFieldCEPPJ());
			painelPJ.add(getJLabelCEPPJ());
			painelPJ.add(getJTextFieldLogradouroPJ());
			painelPJ.add(getJLabelLogradouroPJ());
			painelPJ.add(getJLabelNumeroPJ());
			painelPJ.add(getJTextFieldNumeroPJ());
			painelPJ.add(getJLabelComplementoPJ());
			painelPJ.add(getJTextFieldComplementoPJ());
			painelPJ.add(getJLabelBairroPJ());
			painelPJ.add(getJTextFieldBairroPJ());
			painelPJ.add(getJLabelMunicipioPJ());
			painelPJ.add(getJTextFieldMunicipioPJ());
			painelPJ.add(getJLabelUFPJ());
			painelPJ.add(getJComboBoxUFPJ());
			painelPJ.add(getJLabelEmailPJ());
			painelPJ.add(getJTextFieldEmailPJ());
			painelPJ.add(getJLabelTelefonePJ());
			painelPJ.add(getJTextFieldTelefonePJ());
			painelPJ.add(getJLabelCelularPJ());
			painelPJ.add(getJTextFieldCelularPJ());
			painelPJ.add(getJRadioButtonInativoPJ());
			painelPJ.add(getJRadioButtonAtivoPJ());
			painelPJ.add(getBarraRolagemFornecedorPJ());
			painelPJ.add(getJComboBoxPesquisaPJ());
			painelPJ.add(getJTextFieldPesquisaPJ());
			painelPJ.add(getJButtonPesquisarPJ());
			painelPJ.add(getSeparatorPJ());
			painelPJ.add(getJDateChooserCadastradoEmPJ());
		}
		return painelPJ;
	}
	public JPanel getPainelPF() {
		if (painelPF == null) {
			painelPF = new JPanel();
			painelPF.setBounds(0, 128, 1197, 531);
			painelPF.setLayout(null);
			painelPF.setBackground(Color.LIGHT_GRAY);
			painelPF.add(getJLabelCodigoPF());
			painelPF.add(getJTextFieldCodigoPF());
			painelPF.add(getJLabelNomePF());
			painelPF.add(getJTextFieldNomePF());
			painelPF.add(getJLabelCPFPF());
			painelPF.add(getJTextFieldCPFPF());
			painelPF.add(getJLabelRGPF());
			painelPF.add(getJTextFieldRGPF());
			painelPF.add(getJLabelOrgaoEmissorPF());
			painelPF.add(getJTextFieldOrgaoEmissorPF());
			painelPF.add(getJLabelDataEmissaoPF());
			painelPF.add(getJLabelNacionalidadePF());
			painelPF.add(getJTextFieldNacionalidadePF());
			painelPF.add(getJLabelUFDocPF());
			painelPF.add(getJComboBoxUFDocPF());
			painelPF.add(getJTextFieldNaturalidadePF());
			painelPF.add(getJLabelNaturalidadePF());
			painelPF.add(getJComboBoxSexoPF());
			painelPF.add(getJLabelSexoPF());
			painelPF.add(getJLabelCadastradoEmPF());
			painelPF.add(getJTextFieldCEPPF());
			painelPF.add(getJLabelCEPPF());
			painelPF.add(getJTextFieldLogradouroPF());
			painelPF.add(getJLabelLogradouroPF());
			painelPF.add(getJLabelNumeroPF());
			painelPF.add(getJTextFieldNumeroPF());
			painelPF.add(getJLabelComplementoPF());
			painelPF.add(getJTextFieldComplementoPF());
			painelPF.add(getJLabelBairroPF());
			painelPF.add(getJTextFieldBairroPF());
			painelPF.add(getJLabelMunicipioPF());
			painelPF.add(getJTextFieldMunicipioPF());
			painelPF.add(getJLabelUFPF());
			painelPF.add(getJComboBoxUFPF());
			painelPF.add(getJLabelEmailPF());
			painelPF.add(getJTextFieldEmailPF());
			painelPF.add(getJLabelTelefonePF());
			painelPF.add(getJTextFieldTelefonePF());
			painelPF.add(getJLabelCelularPF());
			painelPF.add(getJTextFieldCelularPF());
			painelPF.add(getJRadioButtonInativoPF());
			painelPF.add(getJRadioButtonAtivoPF());
			painelPF.add(getBarraRolagemFornecedorPF());
			painelPF.add(getJComboBoxPesquisaPF());
			painelPF.add(getJTextFieldPesquisaPF());
			painelPF.add(getJButtonPesquisarPF());
			painelPF.add(getSeparatorPF());
			painelPF.add(getJDateChooserDataDeEmissaoPF());
			painelPF.add(getJDateChooserCadastradoEmPF());
		}
		return painelPF;
	}
	public JLabel getJLabelCodigoPF() {
		if (jLabelCodigoPF == null) {
			jLabelCodigoPF = new JLabel("C\u00F3digo");
			jLabelCodigoPF.setBounds(76, 11, 46, 22);
		}
		return jLabelCodigoPF;
	}
	public JTextField getJTextFieldCodigoPF() {
		if (jTextFieldCodigoPF == null) {
			jTextFieldCodigoPF = new JTextField();
			jTextFieldCodigoPF.setColumns(10);
			jTextFieldCodigoPF.setBounds(76, 28, 109, 22);
		}
		return jTextFieldCodigoPF;
	}
	public JLabel getJLabelNomePF() {
		if (jLabelNomePF == null) {
			jLabelNomePF = new JLabel("Nome");
			jLabelNomePF.setBounds(200, 11, 107, 22);
		}
		return jLabelNomePF;
	}
	public JTextField getJTextFieldNomePF() {
		if (jTextFieldNomePF == null) {
			jTextFieldNomePF = new JTextField();
			jTextFieldNomePF.setColumns(10);
			jTextFieldNomePF.setBounds(200, 28, 249, 22);
		}
		return jTextFieldNomePF;
	}
	public JLabel getJLabelCPFPF() {
		if (jLabelCPFPF == null) {
			jLabelCPFPF = new JLabel("CPF");
			jLabelCPFPF.setBounds(467, 11, 75, 22);
		}
		return jLabelCPFPF;
	}
	public JTextField getJTextFieldCPFPF() {
		if (jTextFieldCPFPF == null) {
			jTextFieldCPFPF = new JFormattedTextField(new FormataMascaras().getCPF());
			jTextFieldCPFPF.setColumns(10);
			jTextFieldCPFPF.setBounds(467, 28, 115, 22);
		}
		return jTextFieldCPFPF;
	}
	public JLabel getJLabelRGPF() {
		if (jLabelRGPF == null) {
			jLabelRGPF = new JLabel("RG");
			jLabelRGPF.setBounds(602, 11, 75, 22);
		}
		return jLabelRGPF;
	}
	public JTextField getJTextFieldRGPF() {
		if (jTextFieldRGPF == null) {
			jTextFieldRGPF = new JTextField();
			jTextFieldRGPF.setColumns(10);
			jTextFieldRGPF.setBounds(602, 28, 111, 22);
		}
		return jTextFieldRGPF;
	}
	public JLabel getJLabelOrgaoEmissorPF() {
		if (jLabelOrgaoEmissorPF == null) {
			jLabelOrgaoEmissorPF = new JLabel("\u00D3rg\u00E3o emissor");
			jLabelOrgaoEmissorPF.setBounds(736, 11, 94, 22);
		}
		return jLabelOrgaoEmissorPF;
	}
	public JTextField getJTextFieldOrgaoEmissorPF() {
		if (jTextFieldOrgaoEmissorPF == null) {
			jTextFieldOrgaoEmissorPF = new JTextField();
			jTextFieldOrgaoEmissorPF.setColumns(10);
			jTextFieldOrgaoEmissorPF.setBounds(735, 28, 103, 22);
		}
		return jTextFieldOrgaoEmissorPF;
	}
	public JLabel getJLabelDataEmissaoPF() {
		if (jLabelDataEmissaoPF == null) {
			jLabelDataEmissaoPF = new JLabel("Data de emiss\u00E3o");
			jLabelDataEmissaoPF.setBounds(862, 11, 96, 22);
		}
		return jLabelDataEmissaoPF;
	}
	public JLabel getJLabelRazaoSocialPJ() {
		if (jLabelRazaoSocialPJ == null) {
			jLabelRazaoSocialPJ = new JLabel("Raz\u00E3o Social");
			jLabelRazaoSocialPJ.setBounds(206, 11, 119, 22);
		}
		return jLabelRazaoSocialPJ;
	}
	public JTextField getJTextFieldRazaoSocialPJ() {
		if (jTextFieldRazaoSocialPJ == null) {
			jTextFieldRazaoSocialPJ = new JTextField();
			jTextFieldRazaoSocialPJ.setColumns(10);
			jTextFieldRazaoSocialPJ.setBounds(206, 28, 161, 22);
		}
		return jTextFieldRazaoSocialPJ;
	}
	public JLabel getJLabelNacionalidadePF() {
		if (jLabelNacionalidadePF == null) {
			jLabelNacionalidadePF = new JLabel("Nacionalidade");
			jLabelNacionalidadePF.setBounds(76, 49, 87, 22);
		}
		return jLabelNacionalidadePF;
	}
	public JTextField getJTextFieldNacionalidadePF() {
		if (jTextFieldNacionalidadePF == null) {
			jTextFieldNacionalidadePF = new JTextField();
			jTextFieldNacionalidadePF.setColumns(10);
			jTextFieldNacionalidadePF.setBounds(76, 66, 134, 22);
		}
		return jTextFieldNacionalidadePF;
	}
	public JLabel getJLabelUFDocPF() {
		if (jLabelUFDocPF == null) {
			jLabelUFDocPF = new JLabel("UF");
			jLabelUFDocPF.setBounds(230, 49, 63, 22);
		}
		return jLabelUFDocPF;
	}
	public JComboBox<String> getJComboBoxUFDocPF() {
		if (jComboBoxUFDocPF == null) {
			jComboBoxUFDocPF = new JComboBox<String>();
			jComboBoxUFDocPF.setModel(new DefaultComboBoxModel(
					new String[] { "--", "Acre", "Alagoas", "Amap\u00E1", "Amazonas", "Bahia", "Cear\u00E1",
							"Distrito Federal", "Espir\u00EDto Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso",
							"Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1",
							"Pernambuco", "Piau\u00ED", "Rio de Janero", "Rio Grande do Norte", "Rio Grande do Sul",
							"Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins" }));
			jComboBoxUFDocPF.setBounds(230, 66, 143, 22);
		}
		return jComboBoxUFDocPF;
	}
	public JTextField getJTextFieldNaturalidadePF() {
		if (jTextFieldNaturalidadePF == null) {
			jTextFieldNaturalidadePF = new JTextField();
			jTextFieldNaturalidadePF.setColumns(10);
			jTextFieldNaturalidadePF.setBounds(396, 66, 143, 22);
		}
		return jTextFieldNaturalidadePF;
	}
	public JLabel getJLabelNaturalidadePF() {
		if (jLabelNaturalidadePF == null) {
			jLabelNaturalidadePF = new JLabel("Naturalidade");
			jLabelNaturalidadePF.setBounds(396, 49, 75, 22);
		}
		return jLabelNaturalidadePF;
	}
	public JComboBox<String> getJComboBoxSexoPF() {
		if (jComboBoxSexoPF == null) {
			jComboBoxSexoPF = new JComboBox<String>();
			jComboBoxSexoPF.setModel(new DefaultComboBoxModel(new String[] { "--", "Feminino", "Masculino" }));
			jComboBoxSexoPF.setBounds(558, 66, 119, 22);
		}
		return jComboBoxSexoPF;
	}
	public JLabel getJLabelSexoPF() {
		if (jLabelSexoPF == null) {
			jLabelSexoPF = new JLabel("Sexo");
			jLabelSexoPF.setBounds(558, 49, 51, 22);
		}
		return jLabelSexoPF;
	}
	public JLabel getJLabelCadastradoEmPF() {
		if (jLabelCadastradoEmPF == null) {
			jLabelCadastradoEmPF = new JLabel("Cadastrado em");
			jLabelCadastradoEmPF.setBounds(691, 49, 115, 22);
		}
		return jLabelCadastradoEmPF;
	}
	public JTextField getJTextFieldCEPPF() {
		if (jTextFieldCEPPF == null) {
			jTextFieldCEPPF = new JFormattedTextField(new FormataMascaras().getCEP());
			jTextFieldCEPPF.setColumns(10);
			jTextFieldCEPPF.setBounds(823, 66, 164, 22);
		}
		return jTextFieldCEPPF;
	}
	public JLabel getJLabelCEPPF() {
		if (jLabelCEPPF == null) {
			jLabelCEPPF = new JLabel("CEP");
			jLabelCEPPF.setBounds(825, 49, 63, 22);
		}
		return jLabelCEPPF;
	}
	public JTextField getJTextFieldLogradouroPF() {
		if (jTextFieldLogradouroPF == null) {
			jTextFieldLogradouroPF = new JTextField();
			jTextFieldLogradouroPF.setColumns(10);
			jTextFieldLogradouroPF.setBounds(76, 110, 277, 22);
		}
		return jTextFieldLogradouroPF;
	}
	public JLabel getJLabelLogradouroPF() {
		if (jLabelLogradouroPF == null) {
			jLabelLogradouroPF = new JLabel("Logradouro");
			jLabelLogradouroPF.setBounds(76, 93, 109, 22);
		}
		return jLabelLogradouroPF;
	}
	public JLabel getJLabelNumeroPF() {
		if (jLabelNumeroPF == null) {
			jLabelNumeroPF = new JLabel("N\u00FAmero");
			jLabelNumeroPF.setBounds(368, 93, 109, 22);
		}
		return jLabelNumeroPF;
	}
	public JTextField getJTextFieldNumeroPF() {
		if (jTextFieldNumeroPF == null) {
			jTextFieldNumeroPF = new JTextField();
			jTextFieldNumeroPF.setColumns(10);
			jTextFieldNumeroPF.setBounds(368, 110, 109, 22);
		}
		return jTextFieldNumeroPF;
	}
	public JLabel getJLabelComplementoPF() {
		if (jLabelComplementoPF == null) {
			jLabelComplementoPF = new JLabel("Complemento");
			jLabelComplementoPF.setBounds(498, 93, 109, 22);
		}
		return jLabelComplementoPF;
	}
	public JTextField getJTextFieldComplementoPF() {
		if (jTextFieldComplementoPF == null) {
			jTextFieldComplementoPF = new JTextField();
			jTextFieldComplementoPF.setColumns(10);
			jTextFieldComplementoPF.setBounds(498, 110, 159, 22);
		}
		return jTextFieldComplementoPF;
	}
	public JLabel getJLabelBairroPF() {
		if (jLabelBairroPF == null) {
			jLabelBairroPF = new JLabel("Bairro");
			jLabelBairroPF.setBounds(672, 93, 109, 22);
		}
		return jLabelBairroPF;
	}
	public JTextField getJTextFieldBairroPF() {
		if (jTextFieldBairroPF == null) {
			jTextFieldBairroPF = new JTextField();
			jTextFieldBairroPF.setColumns(10);
			jTextFieldBairroPF.setBounds(672, 110, 134, 22);
		}
		return jTextFieldBairroPF;
	}
	public JLabel getJLabelMunicipioPF() {
		if (jLabelMunicipioPF == null) {
			jLabelMunicipioPF = new JLabel("Munic\u00EDpio");
			jLabelMunicipioPF.setBounds(823, 93, 164, 22);
		}
		return jLabelMunicipioPF;
	}
	public JTextField getJTextFieldMunicipioPF() {
		if (jTextFieldMunicipioPF == null) {
			jTextFieldMunicipioPF = new JTextField();
			jTextFieldMunicipioPF.setColumns(10);
			jTextFieldMunicipioPF.setBounds(823, 110, 164, 22);
		}
		return jTextFieldMunicipioPF;
	}
	public JLabel getJLabelUFPF() {
		if (jLabelUFPF == null) {
			jLabelUFPF = new JLabel("UF");
			jLabelUFPF.setBounds(76, 131, 63, 22);
		}
		return jLabelUFPF;
	}
	public JComboBox<String> getJComboBoxUFPF() {
		if (jComboBoxUFPF == null) {
			jComboBoxUFPF = new JComboBox<String>();
			jComboBoxUFPF.setModel(new DefaultComboBoxModel(
					new String[] { "--", "Acre", "Alagoas", "Amap\u00E1", "Amazonas", "Bahia", "Cear\u00E1",
							"Distrito Federal", "Espir\u00EDto Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso",
							"Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1",
							"Pernambuco", "Piau\u00ED", "Rio de Janero", "Rio Grande do Norte", "Rio Grande do Sul",
							"Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins" }));
			jComboBoxUFPF.setBounds(76, 148, 134, 22);
		}
		return jComboBoxUFPF;
	}
	public JLabel getJLabelEmailPF() {
		if (jLabelEmailPF == null) {
			jLabelEmailPF = new JLabel("E-mail");
			jLabelEmailPF.setBounds(226, 131, 109, 22);
		}
		return jLabelEmailPF;
	}
	public JTextField getJTextFieldEmailPF() {
		if (jTextFieldEmailPF == null) {
			jTextFieldEmailPF = new JTextField();
			jTextFieldEmailPF.setColumns(10);
			jTextFieldEmailPF.setBounds(226, 148, 255, 22);
		}
		return jTextFieldEmailPF;
	}
	public JLabel getJLabelTelefonePF() {
		if (jLabelTelefonePF == null) {
			jLabelTelefonePF = new JLabel("Telefone");
			jLabelTelefonePF.setBounds(511, 131, 109, 22);
		}
		return jLabelTelefonePF;
	}
	public JTextField getJTextFieldTelefonePF() {
		if (jTextFieldTelefonePF == null) {
			jTextFieldTelefonePF = new JFormattedTextField(new FormataMascaras().getTelefone());
			jTextFieldTelefonePF.setColumns(10);
			jTextFieldTelefonePF.setBounds(511, 148, 143, 22);
		}
		return jTextFieldTelefonePF;
	}
	public JLabel getJLabelCelularPF() {
		if (jLabelCelularPF == null) {
			jLabelCelularPF = new JLabel("Celular");
			jLabelCelularPF.setBounds(673, 131, 109, 22);
		}
		return jLabelCelularPF;
	}
	public JTextField getJTextFieldCelularPF() {
		if (jTextFieldCelularPF == null) {
			jTextFieldCelularPF = new JFormattedTextField(new FormataMascaras().getCelular());
			jTextFieldCelularPF.setColumns(10);
			jTextFieldCelularPF.setBounds(673, 148, 143, 22);
		}
		return jTextFieldCelularPF;
	}
	public JRadioButton getJRadioButtonInativoPF() {
		if (jRadioButtonInativoPF == null) {
			jRadioButtonInativoPF = new JRadioButton("Inativo");
			getgrupoIna_AtiPF().add(getJRadioButtonInativoPF());
			jRadioButtonInativoPF.setBackground(Color.LIGHT_GRAY);
			jRadioButtonInativoPF.setBounds(841, 148, 63, 23);
		}
		return jRadioButtonInativoPF;
	}
	public JRadioButton getJRadioButtonAtivoPF() {
		if (jRadioButtonAtivoPF == null) {
			jRadioButtonAtivoPF = new JRadioButton("Ativo");
			getgrupoIna_AtiPF().add(getJRadioButtonAtivoPF());
			jRadioButtonAtivoPF.setBackground(Color.LIGHT_GRAY);
			jRadioButtonAtivoPF.setBounds(924, 148, 63, 23);
		}
		return jRadioButtonAtivoPF;
	}
	
	public JLabel getJLabelCodigoPJ() {
		if (jLabelCodigoPJ == null) {
			jLabelCodigoPJ = new JLabel("C\u00F3digo");
			jLabelCodigoPJ.setBounds(76, 11, 46, 22);
		}
		return jLabelCodigoPJ;
	}
	public JTextField getJTextFieldCodigoPJ() {
		if (jTextFieldCodigoPJ == null) {
			jTextFieldCodigoPJ = new JTextField();
			jTextFieldCodigoPJ.setColumns(10);
			jTextFieldCodigoPJ.setBounds(76, 28, 109, 22);
		}
		return jTextFieldCodigoPJ;
	}
	public JLabel getJLabelCNPJPJ() {
		if (jLabelCNPJPJ == null) {
			jLabelCNPJPJ = new JLabel("CNPJ");
			jLabelCNPJPJ.setBounds(390, 11, 75, 22);
		}
		return jLabelCNPJPJ;
	}
	public JTextField getJTextFieldCNPJPJ() {
		if (jTextFieldCNPJPJ == null) {
			jTextFieldCNPJPJ = new JFormattedTextField(new FormataMascaras().getCNPJ());
			jTextFieldCNPJPJ.setColumns(10);
			jTextFieldCNPJPJ.setBounds(390, 28, 115, 22);
		}
		return jTextFieldCNPJPJ;
	}
	public JLabel getJLabelIEPJ() {
		if (jLabelIEPJ == null) {
			jLabelIEPJ = new JLabel("IE");
			jLabelIEPJ.setBounds(533, 11, 75, 22);
		}
		return jLabelIEPJ;
	}
	public JTextField getJTextFieldIEPJ() {
		if (jTextFieldIEPJ == null) {
			jTextFieldIEPJ = new JTextField();
			jTextFieldIEPJ.setColumns(10);
			jTextFieldIEPJ.setBounds(533, 28, 111, 22);
		}
		return jTextFieldIEPJ;
	}
	public JLabel getJLabelCadastradoEmPJ() {
		if (jLabelCadastradoEmPJ == null) {
			jLabelCadastradoEmPJ = new JLabel("Cadastrado em");
			jLabelCadastradoEmPJ.setBounds(670, 11, 115, 22);
		}
		return jLabelCadastradoEmPJ;
	}
	public JTextField getJTextFieldCEPPJ() {
		if (jTextFieldCEPPJ == null) {
			jTextFieldCEPPJ = new JFormattedTextField(new FormataMascaras().getCEP());
			jTextFieldCEPPJ.setColumns(10);
			jTextFieldCEPPJ.setBounds(850, 28, 137, 22);
		}
		return jTextFieldCEPPJ;
	}
	public JLabel getJLabelCEPPJ() {
		if (jLabelCEPPJ == null) {
			jLabelCEPPJ = new JLabel("CEP");
			jLabelCEPPJ.setBounds(850, 11, 137, 22);
		}
		return jLabelCEPPJ;
	}
	public JTextField getJTextFieldLogradouroPJ() {
		if (jTextFieldLogradouroPJ == null) {
			jTextFieldLogradouroPJ = new JTextField();
			jTextFieldLogradouroPJ.setColumns(10);
			jTextFieldLogradouroPJ.setBounds(76, 79, 332, 22);
		}
		return jTextFieldLogradouroPJ;
	}
	public JLabel getJLabelLogradouroPJ() {
		if (jLabelLogradouroPJ == null) {
			jLabelLogradouroPJ = new JLabel("Logradouro");
			jLabelLogradouroPJ.setBounds(76, 62, 109, 22);
		}
		return jLabelLogradouroPJ;
	}
	public JLabel getJLabelNumeroPJ() {
		if (jLabelNumeroPJ == null) {
			jLabelNumeroPJ = new JLabel("N\u00FAmero");
			jLabelNumeroPJ.setBounds(431, 62, 109, 22);
		}
		return jLabelNumeroPJ;
	}
	public JTextField getJTextFieldNumeroPJ() {
		if (jTextFieldNumeroPJ == null) {
			jTextFieldNumeroPJ = new JTextField();
			jTextFieldNumeroPJ.setColumns(10);
			jTextFieldNumeroPJ.setBounds(431, 79, 109, 22);
		}
		return jTextFieldNumeroPJ;
	}
	public JLabel getJLabelComplementoPJ() {
		if (jLabelComplementoPJ == null) {
			jLabelComplementoPJ = new JLabel("Complemento");
			jLabelComplementoPJ.setBounds(561, 62, 109, 22);
		}
		return jLabelComplementoPJ;
	}
	public JTextField getJTextFieldComplementoPJ() {
		if (jTextFieldComplementoPJ == null) {
			jTextFieldComplementoPJ = new JTextField();
			jTextFieldComplementoPJ.setColumns(10);
			jTextFieldComplementoPJ.setBounds(561, 79, 109, 22);
		}
		return jTextFieldComplementoPJ;
	}
	public JLabel getJLabelBairroPJ() {
		if (jLabelBairroPJ == null) {
			jLabelBairroPJ = new JLabel("Bairro");
			jLabelBairroPJ.setBounds(691, 62, 109, 22);
		}
		return jLabelBairroPJ;
	}
	public JTextField getJTextFieldBairroPJ() {
		if (jTextFieldBairroPJ == null) {
			jTextFieldBairroPJ = new JTextField();
			jTextFieldBairroPJ.setColumns(10);
			jTextFieldBairroPJ.setBounds(691, 79, 134, 22);
		}
		return jTextFieldBairroPJ;
	}
	public JLabel getJLabelMunicipioPJ() {
		if (jLabelMunicipioPJ == null) {
			jLabelMunicipioPJ = new JLabel("Munic\u00EDpio");
			jLabelMunicipioPJ.setBounds(839, 62, 103, 22);
		}
		return jLabelMunicipioPJ;
	}
	public JTextField getJTextFieldMunicipioPJ() {
		if (jTextFieldMunicipioPJ == null) {
			jTextFieldMunicipioPJ = new JTextField();
			jTextFieldMunicipioPJ.setColumns(10);
			jTextFieldMunicipioPJ.setBounds(839, 79, 148, 22);
		}
		return jTextFieldMunicipioPJ;
	}
	public JLabel getJLabelUFPJ() {
		if (jLabelUFPJ == null) {
			jLabelUFPJ = new JLabel("UF");
			jLabelUFPJ.setBounds(76, 112, 63, 22);
		}
		return jLabelUFPJ;
	}
	public JComboBox<String> getJComboBoxUFPJ() {
		if (jComboBoxUFPJ == null) {
			jComboBoxUFPJ = new JComboBox<String>();
			jComboBoxUFPJ.setModel(new DefaultComboBoxModel(
					new String[] { "--", "Acre", "Alagoas", "Amap\u00E1", "Amazonas", "Bahia", "Cear\u00E1",
							"Distrito Federal", "Espir\u00EDto Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso",
							"Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1",
							"Pernambuco", "Piau\u00ED", "Rio de Janero", "Rio Grande do Norte", "Rio Grande do Sul",
							"Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins" }));
			jComboBoxUFPJ.setBounds(76, 129, 134, 22);
		}
		return jComboBoxUFPJ;
	}
	public JLabel getJLabelEmailPJ() {
		if (jLabelEmailPJ == null) {
			jLabelEmailPJ = new JLabel("E-mail");
			jLabelEmailPJ.setBounds(226, 112, 109, 22);
		}
		return jLabelEmailPJ;
	}
	public JTextField getJTextFieldEmailPJ() {
		if (jTextFieldEmailPJ == null) {
			jTextFieldEmailPJ = new JTextField();
			jTextFieldEmailPJ.setColumns(10);
			jTextFieldEmailPJ.setBounds(226, 129, 255, 22);
		}
		return jTextFieldEmailPJ;
	}
	public JLabel getJLabelTelefonePJ() {
		if (jLabelTelefonePJ == null) {
			jLabelTelefonePJ = new JLabel("Telefone");
			jLabelTelefonePJ.setBounds(511, 112, 109, 22);
		}
		return jLabelTelefonePJ;
	}
	public JTextField getJTextFieldTelefonePJ() {
		if (jTextFieldTelefonePJ == null) {
			jTextFieldTelefonePJ = new JFormattedTextField(new FormataMascaras().getTelefone());
			jTextFieldTelefonePJ.setColumns(10);
			jTextFieldTelefonePJ.setBounds(511, 129, 143, 22);
		}
		return jTextFieldTelefonePJ;
	}
	public JLabel getJLabelCelularPJ() {
		if (jLabelCelularPJ == null) {
			jLabelCelularPJ = new JLabel("Celular");
			jLabelCelularPJ.setBounds(673, 112, 109, 22);
		}
		return jLabelCelularPJ;
	}
	public JTextField getJTextFieldCelularPJ() {
		if (jTextFieldCelularPJ == null) {
			jTextFieldCelularPJ = new JFormattedTextField(new FormataMascaras().getCelular());
			jTextFieldCelularPJ.setColumns(10);
			jTextFieldCelularPJ.setBounds(673, 129, 143, 22);
		}
		return jTextFieldCelularPJ;
	}
	public JRadioButton getJRadioButtonInativoPJ() {
		if (jRadioButtonInativoPJ == null) {
			jRadioButtonInativoPJ = new JRadioButton("Inativo");
			getgrupoIna_AtiPJ().add(getJRadioButtonInativoPJ());
			jRadioButtonInativoPJ.setBackground(Color.LIGHT_GRAY);
			jRadioButtonInativoPJ.setBounds(839, 129, 63, 23);
		}
		return jRadioButtonInativoPJ;
	}
	public JRadioButton getJRadioButtonAtivoPJ() {
		if (jRadioButtonAtivoPJ == null) {
			jRadioButtonAtivoPJ = new JRadioButton("Ativo");
			getgrupoIna_AtiPJ().add(getJRadioButtonAtivoPJ());
			jRadioButtonAtivoPJ.setBackground(Color.LIGHT_GRAY);
			jRadioButtonAtivoPJ.setBounds(915, 129, 63, 23);
		}
		return jRadioButtonAtivoPJ;
	}
	
	public JComboBox<String> getJComboBoxPesquisaPF() {
		if (jComboBoxPesquisaPF == null) {
			jComboBoxPesquisaPF = new JComboBox<String>();
			jComboBoxPesquisaPF.setModel(new DefaultComboBoxModel(new String[] { "--", "Nome", "Codigo", "CPF" }));
			jComboBoxPesquisaPF.setBounds(76, 210, 119, 22);
		}
		return jComboBoxPesquisaPF;
	}
	public JTextField getJTextFieldPesquisaPF() {
		if (jTextFieldPesquisaPF == null) {
			jTextFieldPesquisaPF = new JTextField();
			jTextFieldPesquisaPF.setColumns(10);
			jTextFieldPesquisaPF.setBounds(200, 210, 595, 22);
		}
		return jTextFieldPesquisaPF;
	}
	public JButton getJButtonPesquisarPF() {
		if (jButtonPesquisarPF == null) {
			jButtonPesquisarPF = new JButton("Pesquisar");
			jButtonPesquisarPF.setBounds(805, 210, 173, 23);
		}
		return jButtonPesquisarPF;
	}
	public JSeparator getSeparatorPF() {
		if (separatorPF == null) {
			separatorPF = new JSeparator();
			separatorPF.setBackground(Color.BLACK);
			separatorPF.setBounds(0, 197, 1340, 2);
		}
		return separatorPF;
	}
	
	public ButtonGroup getgrupoFis_Jur() {
		if (grupoFis_Jur == null) {
			grupoFis_Jur = new ButtonGroup();
		}
		return grupoFis_Jur;
	}
	
	public ButtonGroup getgrupoIna_AtiPF() {
		if (grupoIna_AtiPF == null) {
			grupoIna_AtiPF = new ButtonGroup();
		}
		return grupoIna_AtiPF;
	}
	
	public ButtonGroup getgrupoIna_AtiPJ() {
		if (grupoIna_AtiPJ == null) {
			grupoIna_AtiPJ = new ButtonGroup();
		}
		return grupoIna_AtiPJ;
	}
	public JDateChooser getJDateChooserCadastradoEmPJ() {
		if (jDateChooserCadastradoEmPJ == null) {
			jDateChooserCadastradoEmPJ = new JDateChooser();
			jDateChooserCadastradoEmPJ.setBounds(671, 28, 154, 22);
		}
		return jDateChooserCadastradoEmPJ;
	}
	public JDateChooser getJDateChooserDataDeEmissaoPF() {
		if (jDateChooserDataDeEmissaoPF == null) {
			jDateChooserDataDeEmissaoPF = new JDateChooser();
			jDateChooserDataDeEmissaoPF.setBounds(862, 28, 124, 22);
		}
		return jDateChooserDataDeEmissaoPF;
	}
	public JDateChooser getJDateChooserCadastradoEmPF() {
		if (jDateChooserCadastradoEmPF == null) {
			jDateChooserCadastradoEmPF = new JDateChooser();
			jDateChooserCadastradoEmPF.setBounds(692, 66, 114, 22);
		}
		return jDateChooserCadastradoEmPF;
	}
}
