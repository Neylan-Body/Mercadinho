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

public class PainelGerenciarCliente extends JPanel {

	private JLabel jLabelCodigoPF;
	private JTextField jTextFieldCodigoPF;
	private JTextField jTextFieldNomePF;
	private JLabel jLabelNomePF;
	private JTextField jTextFieldCPFPF;
	private JLabel jLabelCPFPF;
	private JLabel jLabelRGPF;
	private JTextField jTextFieldRGPF;
	private JTextField jTextFieldOrgaoEmissorPF;
	private JLabel jLabelOrgaoEmissorPF;
	private JLabel jLabelDataDeEmissaoPF;
	private JComboBox<String> jComboBoxEstadoCivilPF;
	private JLabel jLabelEstadoCivilPF;
	private JLabel jLabelDataNascimentoPF;
	private JLabel jLabelNacionalidadePF;
	private JTextField jTextFieldNacionalidadePF;
	private JLabel jLabelCadastradoEmPF;
	private JLabel jLabelNaturalidadePF;
	private JTextField jTextFieldNaturalidadePF;
	private JComboBox<String> jComboBoxUFDocPF;
	private JLabel jLabelUFDocPF;
	private JComboBox<String> jComboBoxSexoPF;
	private JLabel jLabelSexoPF;
	private JLabel jLabelCepPF;
	private JTextField jTextFieldCEPPF;
	private JLabel jLabelLogradouroPF;
	private JTextField jTextFieldLogradouroPF;
	private JLabel jLabelNumeroPF;
	private JTextField jTextFieldNumeroPF;
	private JLabel jLabelComplementoPF;
	private JTextField jTextFieldComplementoPF;
	private JLabel jLabelBairroPF;
	private JTextField jTextFieldBairroPF;
	private JLabel jLabelMunicipioPF;
	private JTextField jTextFieldMunicipioPF;
	private JTextField jTextFieldEmailPF;
	private JLabel jLabelEmailPF;
	private JTextField jTextFieldCelularPF;
	private JLabel jLabelCelularPF;
	private JTextField jTextFieldTelefonePF;
	private JLabel jLabelTelefonePF;
	private JComboBox<String> jComboBoxUFPF;
	private JLabel jLabelUFPF;
	private JTextField jTextFieldCreditoPF;
	private JLabel jLabelCreditoPF;
	private JRadioButton jRadioButtonInativoPF;
	private JRadioButton jRadioButtonAtivoPF;
	private JSeparator separatorPF;
	private JComboBox<String> jComboBoxPesquisaPF;
	public JTextField jTextFieldPesquisaPF;
	private JButton jButtonPesquisaPF;
	private DefaultTableModel defaultTableModelClientePF;
	private JTable jTableClientePF;
	private JScrollPane barraRolagemClientePF;
	private JLabel jLabelCodigoPJ;
	private JTextField jTextFieldCodigoPJ;
	private JTextField jTextFieldRazaoSocialPJ;
	private JLabel jLabelRazaoSocialPJ;
	private JTextField jTextFieldCNPJPJ;
	private JLabel jLabelCNPJPJ;
	private JLabel jLabelIEPJ;
	private JTextField jTextFieldIEPJ;
	private JLabel jLabelCadastradoEmPJ;
	private JLabel jLabelCepPJ;
	private JTextField jTextFieldCEPPJ;
	private JLabel jLabelLogradouroPJ;
	private JTextField jTextFieldLogradouroPJ;
	private JLabel jLabelNumeroPJ;
	private JTextField jTextFieldNumeroPJ;
	private JLabel jLabelComplementoPJ;
	private JTextField jTextFieldComplementoPJ;
	private JLabel jLabelBairroPJ;
	private JTextField jTextFieldBairroPJ;
	private JLabel jLabelMunicipioPJ;
	private JTextField jTextFieldMunicipioPJ;
	private JTextField jTextFieldEmailPJ;
	private JLabel jLabelEmailPJ;
	private JTextField jTextFieldCelularPJ;
	private JLabel jLabelCelularPJ;
	private JTextField jTextFieldTelefonePJ;
	private JLabel jLabelTelefonePJ;
	private JComboBox<String> jComboBoxUFPJ;
	private JLabel jLabelUFPJ;
	private JTextField jTextFieldCreditoPJ;
	private JLabel jLabelCreditoPJ;
	private JSeparator separatorPJ;
	private JComboBox<String> jComboBoxPesquisaPJ;
	public JTextField jTextFieldPesquisaPJ;
	private JButton jButtonPesquisaPJ;
	private DefaultTableModel defaultTableModelClientePJ;
	private JTable jTableClientePJ;
	private JScrollPane barraRolagemClientePJ;
	
	private JLabel jLabelGerenciarCliente;
	private JRadioButton jRadioButtonPessoaFisica;
	private JRadioButton jRadioButtonPessoaJuridica;
	private JButton jButtonIncluir;
	private JButton jButtonExcluir;
	private JButton jButtonAlterar;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;

	private JRadioButton jRadioButtonInativoPJ;
	private JRadioButton jRadioButtonAtivoPJ;
	
	private ButtonGroup grupoFis_Jur;
	private ButtonGroup grupoIna_AtiPF;
	private ButtonGroup grupoIna_AtiPJ;

	private JPanel painelPF;
	private JPanel painelPJ;
	private JLabel jLabelAberturaPJ;
	private JDateChooser jDateChooserDataDeEmissaoPF;
	private JDateChooser jDateChooserCadastradoEmPF;
	private JDateChooser jDateChooserDataDeNascimentoPF;
	private JDateChooser jDateChooserDataDeAberturaPJ;
	private JDateChooser jDateChooserCadastradoEmPJ;

	public JPanel getPainelPF() {
		if (painelPF == null) {
			painelPF = new JPanel();
			painelPF.setBackground(Color.LIGHT_GRAY);
			painelPF.setBounds(0, 70, 1197, 582);
			painelPF.setLayout(null);
			painelPF.add(getJLabelCodigoPF());
			painelPF.add(getJTextFieldCodigoPF());
			painelPF.add(getJTextFieldNomePF());
			painelPF.add(getJLabelNomePF());
			painelPF.add(getJTextFieldCPFPF());
			painelPF.add(getJLabelCPFPF());
			painelPF.add(getJLabelRGPF());
			painelPF.add(getjTextFieldRGPF());
			painelPF.add(getJTextFieldOrgaoEmissorPF());
			painelPF.add(getjLabelOrgaoEmissorPF());
			painelPF.add(getjLabelDataDeEmissaoPF());
			painelPF.add(getJComboBoxEstadoCivilPF());
			painelPF.add(getjLabelEstadoCivilPF());
			painelPF.add(getJLabelDataNascimentoPF());
			painelPF.add(getJLabelNacionalidadePF());
			painelPF.add(getJTextFieldNacionalidadePF());
			painelPF.add(getJLabelCadastradoEmPF());
			painelPF.add(getJLabelNaturalidadePF());
			painelPF.add(getJTextFieldNaturalidadePF());
			painelPF.add(getJComboBoxUFDocPF());
			painelPF.add(getJLabelUFDocPF());
			painelPF.add(getJComboBoxSexoPF());
			painelPF.add(getJLabelSexoPF());
			painelPF.add(getJLabelCepPF());
			painelPF.add(getJTextFieldCEPPF());
			painelPF.add(getJLabelLogradouroPF());
			painelPF.add(getJTextFieldLogradouroPF());
			painelPF.add(getJLabelNumeroPF());
			painelPF.add(getJTextFieldNumeroPF());
			painelPF.add(getJLabelComplementoPF());
			painelPF.add(getJTextFieldComplementoPF());
			painelPF.add(getJLabelBairroPF());
			painelPF.add(getJTextFieldBairroPF());
			painelPF.add(getjLabelMunicipioPF());
			painelPF.add(getJTextFieldMunicipioPF());
			painelPF.add(getJTextFieldEmailPF());
			painelPF.add(getJLabelEmailPF());
			painelPF.add(getJTextFieldCelularPF());
			painelPF.add(getJLabelCelularPF());
			painelPF.add(getJTextFieldTelefonePF());
			painelPF.add(getJLabelTelefonePF());
			painelPF.add(getJComboBoxUFPF());
			painelPF.add(getJLabelUFPF());
			painelPF.add(getJTextFieldCreditoPF());
			painelPF.add(getJLabelCreditoPF());
			painelPF.add(getJRadioButtonInativoPF());
			painelPF.add(getJRadioButtonAtivoPF());
			painelPF.add(getSeparatorPF());
			painelPF.add(getJComboBoxPesquisaPF());
			painelPF.add(getJTextFieldPesquisaPF());
			painelPF.add(getJButtonPesquisaPF());
			painelPF.add(getBarraRolagemClientePF());
			painelPF.add(getJDateChooserDataDeEmissaoPF());
			painelPF.add(getJDateChooserCadastradoEmPF());
			painelPF.add(getJDateChooserDataDeNascimentoPF());
		}
		return painelPF;
	}

	public JPanel getPainelPJ() {
		if (painelPJ == null) {
			painelPJ = new JPanel();
			painelPJ.setBackground(Color.LIGHT_GRAY);
			painelPJ.setBounds(0, 70, 1197, 582);
			painelPJ.setLayout(null);
			painelPJ.add(getJLabelCodigoPJ());
			painelPJ.add(getJTextFieldCodigoPJ());
			painelPJ.add(getJTextFieldRazaoSocialPJ());
			painelPJ.add(getJLabelRazaoSocialPJ());
			painelPJ.add(getJTextFieldCNPJPJ());
			painelPJ.add(getJLabelCNPJPJ());
			painelPJ.add(getJLabelIEPJ());
			painelPJ.add(getjTextFieldIEPJ());
			painelPJ.add(getJLabelCadastradoEmPJ());
			painelPJ.add(getJLabelCepPJ());
			painelPJ.add(getJTextFieldCEPPJ());
			painelPJ.add(getJLabelLogradouroPJ());
			painelPJ.add(getJTextFieldLogradouroPJ());
			painelPJ.add(getJLabelNumeroPJ());
			painelPJ.add(getJTextFieldNumeroPJ());
			painelPJ.add(getJLabelComplementoPJ());
			painelPJ.add(getJTextFieldComplementoPJ());
			painelPJ.add(getJLabelBairroPJ());
			painelPJ.add(getJTextFieldBairroPJ());
			painelPJ.add(getjLabelMunicipioPJ());
			painelPJ.add(getJTextFieldMunicipioPJ());
			painelPJ.add(getJTextFieldEmailPJ());
			painelPJ.add(getJLabelEmailPJ());
			painelPJ.add(getJTextFieldCelularPJ());
			painelPJ.add(getJLabelCelularPJ());
			painelPJ.add(getJTextFieldTelefonePJ());
			painelPJ.add(getJLabelTelefonePJ());
			painelPJ.add(getJComboBoxUFPJ());
			painelPJ.add(getJLabelUFPJ());
			painelPJ.add(getJTextFieldCreditoPJ());
			painelPJ.add(getJLabelCreditoPJ());
			painelPJ.add(getJRadioButtonInativoPJ());
			painelPJ.add(getJRadioButtonAtivoPJ());
			painelPJ.add(getSeparatorPJ());
			painelPJ.add(getJComboBoxPesquisaPJ());
			painelPJ.add(getJTextFieldPesquisaPJ());
			painelPJ.add(getJButtonPesquisaPJ());
			painelPJ.add(getBarraRolagemClientePJ());
			painelPJ.add(getJLabelAberturaPJ());
			painelPJ.add(getJDateChooserDataDeAberturaPJ());
			painelPJ.add(getJDateChooserCadastradoEmPJ());
		}
		return painelPJ;
	}

	public PainelGerenciarCliente() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1197, 693);
		setLayout(null);
		add(getPainelPF());
		add(getPainelPJ());
		getPainelPF().setVisible(false);
		getPainelPJ().setVisible(false);
		add(getJLabelGerenciarCliente());
		add(getJRadioButtonPessoaFisica());
		add(getJRadioButtonPessoaJuridica());
		add(getJButtonIncluir());
		add(getJButtonExcluir());
		add(getJButtonAlterar());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
	}

	public JLabel getJLabelGerenciarCliente() {
		if (jLabelGerenciarCliente == null) {
			jLabelGerenciarCliente = new JLabel("Gerenciar cliente");
			jLabelGerenciarCliente.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelGerenciarCliente.setBounds(79, 12, 489, 65);
		}
		return jLabelGerenciarCliente;
	}

	public JLabel getJLabelCodigoPF() {
		if (jLabelCodigoPF == null) {
			jLabelCodigoPF = new JLabel("C\u00F3digo");
			jLabelCodigoPF.setBounds(79, 12, 46, 22);
		}
		return jLabelCodigoPF;
	}

	public JTextField getJTextFieldCodigoPF() {
		if (jTextFieldCodigoPF == null) {
			jTextFieldCodigoPF = new JTextField();
			jTextFieldCodigoPF.setColumns(10);
			jTextFieldCodigoPF.setBounds(79, 32, 109, 22);
		}
		return jTextFieldCodigoPF;
	}

	public JTextField getJTextFieldNomePF() {
		if (jTextFieldNomePF == null) {
			jTextFieldNomePF = new JTextField();
			jTextFieldNomePF.setColumns(10);
			jTextFieldNomePF.setBounds(199, 32, 234, 22);
		}
		return jTextFieldNomePF;
	}

	public JLabel getJLabelNomePF() {
		if (jLabelNomePF == null) {
			jLabelNomePF = new JLabel("Nome");
			jLabelNomePF.setBounds(199, 12, 107, 22);
		}
		return jLabelNomePF;
	}

	public JTextField getJTextFieldCPFPF() {
		if (jTextFieldCPFPF == null) {
			jTextFieldCPFPF = new JFormattedTextField(new FormataMascaras().getCPF());
			jTextFieldCPFPF.setColumns(10);
			jTextFieldCPFPF.setBounds(445, 32, 103, 22);
		}
		return jTextFieldCPFPF;
	}

	public JLabel getJLabelCPFPF() {
		if (jLabelCPFPF == null) {
			jLabelCPFPF = new JLabel("CPF");
			jLabelCPFPF.setBounds(442, 12, 119, 22);
		}
		return jLabelCPFPF;
	}

	public JLabel getJLabelRGPF() {
		if (jLabelRGPF == null) {
			jLabelRGPF = new JLabel("RG");
			jLabelRGPF.setBounds(555, 12, 81, 22);
		}
		return jLabelRGPF;
	}

	public JTextField getjTextFieldRGPF() {
		if (jTextFieldRGPF == null) {
			jTextFieldRGPF = new JTextField();
			jTextFieldRGPF.setColumns(10);
			jTextFieldRGPF.setBounds(555, 32, 103, 22);
		}
		return jTextFieldRGPF;
	}

	public JTextField getJTextFieldOrgaoEmissorPF() {
		if (jTextFieldOrgaoEmissorPF == null) {
			jTextFieldOrgaoEmissorPF = new JTextField();
			jTextFieldOrgaoEmissorPF.setColumns(10);
			jTextFieldOrgaoEmissorPF.setBounds(668, 32, 103, 22);
		}
		return jTextFieldOrgaoEmissorPF;
	}

	public JLabel getjLabelOrgaoEmissorPF() {
		if (jLabelOrgaoEmissorPF == null) {
			jLabelOrgaoEmissorPF = new JLabel("\u00D3rg\u00E3o emissor");
			jLabelOrgaoEmissorPF.setBounds(668, 12, 125, 22);
		}
		return jLabelOrgaoEmissorPF;
	}

	public JLabel getjLabelDataDeEmissaoPF() {
		if (jLabelDataDeEmissaoPF == null) {
			jLabelDataDeEmissaoPF = new JLabel("Data de emiss\u00E3o");
			jLabelDataDeEmissaoPF.setBounds(781, 12, 125, 22);
		}
		return jLabelDataDeEmissaoPF;
	}

	public JComboBox<String> getJComboBoxEstadoCivilPF() {
		if (jComboBoxEstadoCivilPF == null) {
			jComboBoxEstadoCivilPF = new JComboBox<String>();
			jComboBoxEstadoCivilPF.setModel(new DefaultComboBoxModel(new String[] { "--", "Solteiro", "Casado",
					"Uni\u00E3o est\u00E1vel", "Vi\u00FAvo", "Divorciado" }));
			jComboBoxEstadoCivilPF.setBounds(904, 32, 96, 22);
		}
		return jComboBoxEstadoCivilPF;
	}

	public JLabel getjLabelEstadoCivilPF() {
		if (jLabelEstadoCivilPF == null) {
			jLabelEstadoCivilPF = new JLabel("Estado Civil");
			jLabelEstadoCivilPF.setBounds(904, 12, 125, 22);
		}
		return jLabelEstadoCivilPF;
	}

	public JLabel getJLabelDataNascimentoPF() {
		if (jLabelDataNascimentoPF == null) {
			jLabelDataNascimentoPF = new JLabel("Data de Nascimento");
			jLabelDataNascimentoPF.setBounds(79, 66, 119, 22);
		}
		return jLabelDataNascimentoPF;
	}

	public JLabel getJLabelNacionalidadePF() {
		if (jLabelNacionalidadePF == null) {
			jLabelNacionalidadePF = new JLabel("Nacionalidade");
			jLabelNacionalidadePF.setBounds(209, 66, 87, 22);
		}
		return jLabelNacionalidadePF;
	}

	public JTextField getJTextFieldNacionalidadePF() {
		if (jTextFieldNacionalidadePF == null) {
			jTextFieldNacionalidadePF = new JTextField();
			jTextFieldNacionalidadePF.setColumns(10);
			jTextFieldNacionalidadePF.setBounds(210, 89, 134, 22);
		}
		return jTextFieldNacionalidadePF;
	}

	public JLabel getJLabelCadastradoEmPF() {
		if (jLabelCadastradoEmPF == null) {
			jLabelCadastradoEmPF = new JLabel("Cadastrado em");
			jLabelCadastradoEmPF.setBounds(805, 66, 96, 22);
		}
		return jLabelCadastradoEmPF;
	}

	public JLabel getJLabelNaturalidadePF() {
		if (jLabelNaturalidadePF == null) {
			jLabelNaturalidadePF = new JLabel("Naturalidade");
			jLabelNaturalidadePF.setBounds(510, 66, 75, 22);
		}
		return jLabelNaturalidadePF;
	}

	public JTextField getJTextFieldNaturalidadePF() {
		if (jTextFieldNaturalidadePF == null) {
			jTextFieldNaturalidadePF = new JTextField();
			jTextFieldNaturalidadePF.setColumns(10);
			jTextFieldNaturalidadePF.setBounds(510, 89, 152, 22);
		}
		return jTextFieldNaturalidadePF;
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
			jComboBoxUFDocPF.setBounds(356, 89, 143, 22);
		}
		return jComboBoxUFDocPF;
	}

	public JLabel getJLabelUFDocPF() {
		if (jLabelUFDocPF == null) {
			jLabelUFDocPF = new JLabel("UF");
			jLabelUFDocPF.setBounds(356, 66, 63, 22);
		}
		return jLabelUFDocPF;
	}

	public JComboBox<String> getJComboBoxSexoPF() {
		if (jComboBoxSexoPF == null) {
			jComboBoxSexoPF = new JComboBox<String>();
			jComboBoxSexoPF.setModel(new DefaultComboBoxModel(new String[] { "--", "Feminino", "Masculino" }));
			jComboBoxSexoPF.setBounds(674, 89, 119, 22);
		}
		return jComboBoxSexoPF;
	}

	public JLabel getJLabelSexoPF() {
		if (jLabelSexoPF == null) {
			jLabelSexoPF = new JLabel("Sexo");
			jLabelSexoPF.setBounds(678, 66, 51, 22);
		}
		return jLabelSexoPF;
	}

	public JLabel getJLabelCepPF() {
		if (jLabelCepPF == null) {
			jLabelCepPF = new JLabel("CEP");
			jLabelCepPF.setBounds(79, 123, 63, 22);
		}
		return jLabelCepPF;
	}

	public JTextField getJTextFieldCEPPF() {
		if (jTextFieldCEPPF == null) {
			jTextFieldCEPPF = new JFormattedTextField(new FormataMascaras().getCEP());
			jTextFieldCEPPF.setColumns(10);
			jTextFieldCEPPF.setBounds(79, 145, 103, 22);
		}
		return jTextFieldCEPPF;
	}

	public JLabel getJLabelLogradouroPF() {
		if (jLabelLogradouroPF == null) {
			jLabelLogradouroPF = new JLabel("Logradouro");
			jLabelLogradouroPF.setBounds(194, 123, 109, 22);
		}
		return jLabelLogradouroPF;
	}

	public JTextField getJTextFieldLogradouroPF() {
		if (jTextFieldLogradouroPF == null) {
			jTextFieldLogradouroPF = new JTextField();
			jTextFieldLogradouroPF.setColumns(10);
			jTextFieldLogradouroPF.setBounds(194, 145, 332, 22);
		}
		return jTextFieldLogradouroPF;
	}

	public JLabel getJLabelNumeroPF() {
		if (jLabelNumeroPF == null) {
			jLabelNumeroPF = new JLabel("N\u00FAmero");
			jLabelNumeroPF.setBounds(539, 123, 109, 22);
		}
		return jLabelNumeroPF;
	}

	public JTextField getJTextFieldNumeroPF() {
		if (jTextFieldNumeroPF == null) {
			jTextFieldNumeroPF = new JTextField();
			jTextFieldNumeroPF.setColumns(10);
			jTextFieldNumeroPF.setBounds(538, 145, 109, 22);
		}
		return jTextFieldNumeroPF;
	}

	public JLabel getJLabelComplementoPF() {
		if (jLabelComplementoPF == null) {
			jLabelComplementoPF = new JLabel("Complemento");
			jLabelComplementoPF.setBounds(660, 123, 109, 22);
		}
		return jLabelComplementoPF;
	}

	public JTextField getJTextFieldComplementoPF() {
		if (jTextFieldComplementoPF == null) {
			jTextFieldComplementoPF = new JTextField();
			jTextFieldComplementoPF.setColumns(10);
			jTextFieldComplementoPF.setBounds(659, 145, 159, 22);
		}
		return jTextFieldComplementoPF;
	}

	public JLabel getJLabelBairroPF() {
		if (jLabelBairroPF == null) {
			jLabelBairroPF = new JLabel("Bairro");
			jLabelBairroPF.setBounds(829, 123, 109, 22);
		}
		return jLabelBairroPF;
	}

	public JTextField getJTextFieldBairroPF() {
		if (jTextFieldBairroPF == null) {
			jTextFieldBairroPF = new JTextField();
			jTextFieldBairroPF.setColumns(10);
			jTextFieldBairroPF.setBounds(830, 145, 134, 22);
		}
		return jTextFieldBairroPF;
	}

	public JLabel getjLabelMunicipioPF() {
		if (jLabelMunicipioPF == null) {
			jLabelMunicipioPF = new JLabel("Munic\u00EDpio");
			jLabelMunicipioPF.setBounds(79, 179, 109, 22);
		}
		return jLabelMunicipioPF;
	}

	public JTextField getJTextFieldMunicipioPF() {
		if (jTextFieldMunicipioPF == null) {
			jTextFieldMunicipioPF = new JTextField();
			jTextFieldMunicipioPF.setColumns(10);
			jTextFieldMunicipioPF.setBounds(79, 202, 159, 22);
		}
		return jTextFieldMunicipioPF;
	}

	public JTextField getJTextFieldEmailPF() {
		if (jTextFieldEmailPF == null) {
			jTextFieldEmailPF = new JTextField();
			jTextFieldEmailPF.setColumns(10);
			jTextFieldEmailPF.setBounds(397, 202, 255, 22);
		}
		return jTextFieldEmailPF;
	}

	public JLabel getJLabelEmailPF() {
		if (jLabelEmailPF == null) {
			jLabelEmailPF = new JLabel("E-mail");
			jLabelEmailPF.setBounds(397, 179, 109, 22);
		}
		return jLabelEmailPF;
	}

	public JTextField getJTextFieldCelularPF() {
		if (jTextFieldCelularPF == null) {
			jTextFieldCelularPF = new JFormattedTextField(new FormataMascaras().getCelular());
			jTextFieldCelularPF.setColumns(10);
			jTextFieldCelularPF.setBounds(821, 202, 143, 22);
		}
		return jTextFieldCelularPF;
	}

	public JLabel getJLabelCelularPF() {
		if (jLabelCelularPF == null) {
			jLabelCelularPF = new JLabel("Celular");
			jLabelCelularPF.setBounds(821, 179, 109, 22);
		}
		return jLabelCelularPF;
	}

	public JTextField getJTextFieldTelefonePF() {
		if (jTextFieldTelefonePF == null) {
			jTextFieldTelefonePF = new JFormattedTextField(new FormataMascaras().getTelefone());
			jTextFieldTelefonePF.setColumns(10);
			jTextFieldTelefonePF.setBounds(660, 202, 143, 22);
		}
		return jTextFieldTelefonePF;
	}

	public JLabel getJLabelTelefonePF() {
		if (jLabelTelefonePF == null) {
			jLabelTelefonePF = new JLabel("Telefone");
			jLabelTelefonePF.setBounds(662, 179, 109, 22);
		}
		return jLabelTelefonePF;
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
			jComboBoxUFPF.setBounds(251, 202, 134, 22);
		}
		return jComboBoxUFPF;
	}

	public JLabel getJLabelUFPF() {
		if (jLabelUFPF == null) {
			jLabelUFPF = new JLabel("UF");
			jLabelUFPF.setBounds(251, 179, 63, 22);
		}
		return jLabelUFPF;
	}

	public JTextField getJTextFieldCreditoPF() {
		if (jTextFieldCreditoPF == null) {
			jTextFieldCreditoPF = new JTextField();
			jTextFieldCreditoPF.setColumns(10);
			jTextFieldCreditoPF.setBounds(79, 258, 143, 22);
			
		}
		return jTextFieldCreditoPF;
	}

	public JLabel getJLabelCreditoPF() {
		if (jLabelCreditoPF == null) {
			jLabelCreditoPF = new JLabel("Cr\u00E9dito(R$)");
			jLabelCreditoPF.setBounds(79, 236, 109, 22);
		}
		return jLabelCreditoPF;
	}

	public JRadioButton getJRadioButtonInativoPF() {
		if (jRadioButtonInativoPF == null) {
			jRadioButtonInativoPF = new JRadioButton("Inativo");
			getgrupoIna_AtiPF().add(getJRadioButtonInativoPF());
			jRadioButtonInativoPF.setBackground(Color.LIGHT_GRAY);
			jRadioButtonInativoPF.setBounds(243, 258, 63, 23);
		}
		return jRadioButtonInativoPF;
	}

	public JRadioButton getJRadioButtonAtivoPF() {
		if (jRadioButtonAtivoPF == null) {
			jRadioButtonAtivoPF = new JRadioButton("Ativo", false);
			getgrupoIna_AtiPF().add(getJRadioButtonAtivoPF());
			jRadioButtonAtivoPF.setBackground(Color.LIGHT_GRAY);
			jRadioButtonAtivoPF.setBounds(322, 258, 63, 23);
		}
		return jRadioButtonAtivoPF;
	}

	public ButtonGroup getgrupoIna_AtiPF() {
		if (grupoIna_AtiPF == null) {
			grupoIna_AtiPF = new ButtonGroup();
		}
		return grupoIna_AtiPF;
	}

	public JSeparator getSeparatorPF() {
		if (separatorPF == null) {
			separatorPF = new JSeparator();
			separatorPF.setBackground(Color.BLACK);
			separatorPF.setBounds(0, 300, 1340, 2);
		}
		return separatorPF;
	}

	public JComboBox<String> getJComboBoxPesquisaPF() {
		if (jComboBoxPesquisaPF == null) {
			jComboBoxPesquisaPF = new JComboBox<String>();
			jComboBoxPesquisaPF.setBounds(79, 322, 119, 22);
			jComboBoxPesquisaPF.setModel(new DefaultComboBoxModel(new String[] { "--", "Nome", "Codigo", "CPF" }));
		}
		return jComboBoxPesquisaPF;
	}

	public JTextField getJTextFieldPesquisaPF() {
		if (jTextFieldPesquisaPF == null) {
			jTextFieldPesquisaPF = new JTextField();
			jTextFieldPesquisaPF.setColumns(10);
			jTextFieldPesquisaPF.setBounds(209, 322, 595, 22);
		}
		return jTextFieldPesquisaPF;
	}

	public JButton getJButtonPesquisaPF() {
		if (jButtonPesquisaPF == null) {
			jButtonPesquisaPF = new JButton("Pesquisar");
			jButtonPesquisaPF.setBounds(818, 322, 173, 23);
		}
		return jButtonPesquisaPF;
	}

	public DefaultTableModel getDefaultTableModelClientePF() {
		if (defaultTableModelClientePF == null) {
			defaultTableModelClientePF = new DefaultTableModel(new Object[][] {},
					new String[] { "Codigo", "Nome", "CPF", "E-mail" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelClientePF;
	}

	public JTable getJTableClientePF() {
		if (jTableClientePF == null) {
			jTableClientePF = new JTable(getDefaultTableModelClientePF());
			jTableClientePF.getTableHeader().setReorderingAllowed(false);
			jTableClientePF.setRowSelectionAllowed(true);
			jTableClientePF.setBounds(79,384,700, 317);
			jTableClientePF.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTableClientePF.getColumnModel().getColumn(1).setPreferredWidth(300);
			jTableClientePF.getColumnModel().getColumn(2).setPreferredWidth(150);
			jTableClientePF.getColumnModel().getColumn(3).setPreferredWidth(300);
		}
		return jTableClientePF;
	}

	public JScrollPane getBarraRolagemClientePF() {
		if (barraRolagemClientePF == null) {
			barraRolagemClientePF = new JScrollPane(getJTableClientePF());
			barraRolagemClientePF.setBounds(79, 356, 912, 198);
		}
		return barraRolagemClientePF;
	}

	public JLabel getJLabelCodigoPJ() {
		if (jLabelCodigoPJ == null) {
			jLabelCodigoPJ = new JLabel("C\u00F3digo");
			jLabelCodigoPJ.setBounds(79, 12, 46, 22);
		}
		return jLabelCodigoPJ;
	}

	public JTextField getJTextFieldCodigoPJ() {
		if (jTextFieldCodigoPJ == null) {
			jTextFieldCodigoPJ = new JTextField();
			jTextFieldCodigoPJ.setColumns(10);
			jTextFieldCodigoPJ.setBounds(79, 32, 109, 22);
		}
		return jTextFieldCodigoPJ;
	}

	public JTextField getJTextFieldRazaoSocialPJ() {
		if (jTextFieldRazaoSocialPJ == null) {
			jTextFieldRazaoSocialPJ = new JTextField();
			jTextFieldRazaoSocialPJ.setColumns(10);
			jTextFieldRazaoSocialPJ.setBounds(199, 32, 234, 22);
		}
		return jTextFieldRazaoSocialPJ;
	}

	public JLabel getJLabelRazaoSocialPJ() {
		if (jLabelRazaoSocialPJ == null) {
			jLabelRazaoSocialPJ = new JLabel("Razão social");
			jLabelRazaoSocialPJ.setBounds(199, 12, 107, 22);
		}
		return jLabelRazaoSocialPJ;
	}

	public JTextField getJTextFieldCNPJPJ() {
		if (jTextFieldCNPJPJ == null) {
			jTextFieldCNPJPJ = new JFormattedTextField(new FormataMascaras().getCNPJ());
			jTextFieldCNPJPJ.setColumns(10);
			jTextFieldCNPJPJ.setBounds(445, 32, 142, 22);
			
		}
		return jTextFieldCNPJPJ;
	}

	public JLabel getJLabelCNPJPJ() {
		if (jLabelCNPJPJ == null) {
			jLabelCNPJPJ = new JLabel("CNPJ");
			jLabelCNPJPJ.setBounds(445, 12, 61, 22);
			
		}
		return jLabelCNPJPJ;
	}

	public JLabel getJLabelIEPJ() {
		if (jLabelIEPJ == null) {
			jLabelIEPJ = new JLabel("IE");
			jLabelIEPJ.setBounds(599, 12, 81, 22);
			
		}
		return jLabelIEPJ;
	}

	public JTextField getjTextFieldIEPJ() {
		if (jTextFieldIEPJ == null) {
			jTextFieldIEPJ = new JTextField();
			jTextFieldIEPJ.setColumns(10);
			jTextFieldIEPJ.setBounds(599, 32, 103, 22);
			
		}
		return jTextFieldIEPJ;
	}

	public JLabel getJLabelCadastradoEmPJ() {
		if (jLabelCadastradoEmPJ == null) {
			jLabelCadastradoEmPJ = new JLabel("Cadastrado em");
			jLabelCadastradoEmPJ.setBounds(845, 12, 96, 22);
			
		}
		return jLabelCadastradoEmPJ;
	}

	public JLabel getJLabelCepPJ() {
		if (jLabelCepPJ == null) {
			jLabelCepPJ = new JLabel("CEP");
			jLabelCepPJ.setBounds(423, 68, 63, 22);			
			
		}
		return jLabelCepPJ;
	}

	public JTextField getJTextFieldCEPPJ() {
		if (jTextFieldCEPPJ == null) {
			jTextFieldCEPPJ = new JFormattedTextField(new FormataMascaras().getCEP());
			jTextFieldCEPPJ.setColumns(10);
			jTextFieldCEPPJ.setBounds(423, 88, 119, 22);
			
		}
		return jTextFieldCEPPJ;
	}

	public JLabel getJLabelLogradouroPJ() {
		if (jLabelLogradouroPJ == null) {
			jLabelLogradouroPJ = new JLabel("Logradouro");
			jLabelLogradouroPJ.setBounds(79, 66, 109, 22);
			
		}
		return jLabelLogradouroPJ;
	}

	public JTextField getJTextFieldLogradouroPJ() {
		if (jTextFieldLogradouroPJ == null) {
			jTextFieldLogradouroPJ = new JTextField();
			jTextFieldLogradouroPJ.setColumns(10);
			jTextFieldLogradouroPJ.setBounds(79, 88, 332, 22);
			
		}
		return jTextFieldLogradouroPJ;
	}

	public JLabel getJLabelNumeroPJ() {
		if (jLabelNumeroPJ == null) {
			jLabelNumeroPJ = new JLabel("N\u00FAmero");
			jLabelNumeroPJ.setBounds(80, 122, 109, 22);			
		}
		return jLabelNumeroPJ;
	}

	public JTextField getJTextFieldNumeroPJ() {
		if (jTextFieldNumeroPJ == null) {
			jTextFieldNumeroPJ = new JTextField();
			jTextFieldNumeroPJ.setColumns(10);
			jTextFieldNumeroPJ.setBounds(79, 144, 109, 22);
			
		}
		return jTextFieldNumeroPJ;
	}

	public JLabel getJLabelComplementoPJ() {
		if (jLabelComplementoPJ == null) {
			jLabelComplementoPJ = new JLabel("Complemento");
			jLabelComplementoPJ.setBounds(566, 66, 109, 22);
			
		}
		return jLabelComplementoPJ;
	}

	public JTextField getJTextFieldComplementoPJ() {
		if (jTextFieldComplementoPJ == null) {
			jTextFieldComplementoPJ = new JTextField();
			jTextFieldComplementoPJ.setColumns(10);
			jTextFieldComplementoPJ.setBounds(554, 88, 173, 22);
			
		}
		return jTextFieldComplementoPJ;
	}

	public JLabel getJLabelBairroPJ() {
		if (jLabelBairroPJ == null) {
			jLabelBairroPJ = new JLabel("Bairro");
			jLabelBairroPJ.setBounds(739, 66, 141, 22);
			
		}
		return jLabelBairroPJ;
	}

	public JTextField getJTextFieldBairroPJ() {
		if (jTextFieldBairroPJ == null) {
			jTextFieldBairroPJ = new JTextField();
			jTextFieldBairroPJ.setColumns(10);
			jTextFieldBairroPJ.setBounds(739, 88, 225, 22);
		
		}
		return jTextFieldBairroPJ;
	}

	public JLabel getjLabelMunicipioPJ() {
		if (jLabelMunicipioPJ == null) {
			jLabelMunicipioPJ = new JLabel("Munic\u00EDpio");
			jLabelMunicipioPJ.setBounds(199, 122, 150, 22);
			
		}
		return jLabelMunicipioPJ;
	}

	public JTextField getJTextFieldMunicipioPJ() {
		if (jTextFieldMunicipioPJ == null) {
			jTextFieldMunicipioPJ = new JTextField();
			jTextFieldMunicipioPJ.setColumns(10);
			jTextFieldMunicipioPJ.setBounds(199, 145, 200, 22);
			
		}
		return jTextFieldMunicipioPJ;
	}

	public JTextField getJTextFieldEmailPJ() {
		if (jTextFieldEmailPJ == null) {
			jTextFieldEmailPJ = new JTextField();
			jTextFieldEmailPJ.setColumns(10);
			jTextFieldEmailPJ.setBounds(558, 145, 255, 22);
			
		}
		return jTextFieldEmailPJ;
	}

	public JLabel getJLabelEmailPJ() {
		if (jLabelEmailPJ == null) {
			jLabelEmailPJ = new JLabel("E-mail");
			jLabelEmailPJ.setBounds(558, 122, 109, 22);
		}
		return jLabelEmailPJ;
	}

	public JTextField getJTextFieldCelularPJ() {
		if (jTextFieldCelularPJ == null) {
			jTextFieldCelularPJ = new JFormattedTextField(new FormataMascaras().getCelular());
			jTextFieldCelularPJ.setColumns(10);
			jTextFieldCelularPJ.setBounds(79, 197, 143, 22);
			
		}
		return jTextFieldCelularPJ;
	}

	public JLabel getJLabelCelularPJ() {
		if (jLabelCelularPJ == null) {
			jLabelCelularPJ = new JLabel("Celular");
			jLabelCelularPJ.setBounds(79, 174, 109, 22);
			
		}
		return jLabelCelularPJ;
	}

	public JTextField getJTextFieldTelefonePJ() {
		if (jTextFieldTelefonePJ == null) {
			jTextFieldTelefonePJ = new JFormattedTextField(new FormataMascaras().getTelefone());
			jTextFieldTelefonePJ.setColumns(10);
			jTextFieldTelefonePJ.setBounds(821, 145, 143, 22);
			
		}
		return jTextFieldTelefonePJ;
	}

	public JLabel getJLabelTelefonePJ() {
		if (jLabelTelefonePJ == null) {
			jLabelTelefonePJ = new JLabel("Telefone");
			jLabelTelefonePJ.setBounds(823, 122, 109, 22);
			
		}
		return jLabelTelefonePJ;
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
			jComboBoxUFPJ.setBounds(412, 145, 134, 22);
			
		}
		return jComboBoxUFPJ;
	}

	public JLabel getJLabelUFPJ() {
		if (jLabelUFPJ == null) {
			jLabelUFPJ = new JLabel("UF");
			jLabelUFPJ.setBounds(412, 122, 63, 22);
			
		}
		return jLabelUFPJ;
	}

	public JTextField getJTextFieldCreditoPJ() {
		if (jTextFieldCreditoPJ == null) {
			jTextFieldCreditoPJ = new JTextField();
			jTextFieldCreditoPJ.setColumns(10);
			jTextFieldCreditoPJ.setBounds(234, 197, 143, 22);
			
			
		}
		return jTextFieldCreditoPJ;
	}

	public JLabel getJLabelCreditoPJ() {
		if (jLabelCreditoPJ == null) {
			jLabelCreditoPJ = new JLabel("Cr\u00E9dito(R$)");
			jLabelCreditoPJ.setBounds(234, 174, 109, 22);
			
		}
		return jLabelCreditoPJ;
	}

	public JRadioButton getJRadioButtonInativoPJ() {
		if (jRadioButtonInativoPJ == null) {
			jRadioButtonInativoPJ = new JRadioButton("Inativo");
			getgrupoIna_AtiPJ().add(getJRadioButtonInativoPJ());
			jRadioButtonInativoPJ.setBackground(Color.LIGHT_GRAY);
			jRadioButtonInativoPJ.setBounds(385, 197, 63, 23);
			
		}
		return jRadioButtonInativoPJ;
	}

	public JRadioButton getJRadioButtonAtivoPJ() {
		if (jRadioButtonAtivoPJ == null) {
			jRadioButtonAtivoPJ = new JRadioButton("Ativo", false);
			getgrupoIna_AtiPJ().add(getJRadioButtonAtivoPJ());
			jRadioButtonAtivoPJ.setBackground(Color.LIGHT_GRAY);
			jRadioButtonAtivoPJ.setBounds(452, 197, 63, 23);
			
		}
		return jRadioButtonAtivoPJ;
	}

	public ButtonGroup getgrupoIna_AtiPJ() {
		if (grupoIna_AtiPJ == null) {
			grupoIna_AtiPJ = new ButtonGroup();
		}
		return grupoIna_AtiPJ;
	}

	public JSeparator getSeparatorPJ() {
		if (separatorPJ == null) {
			separatorPJ = new JSeparator();
			separatorPJ.setBackground(Color.BLACK);
			separatorPJ.setBounds(0, 245, 1340, 2);
			
		}
		return separatorPJ;
	}

	public JComboBox<String> getJComboBoxPesquisaPJ() {
		if (jComboBoxPesquisaPJ == null) {
			jComboBoxPesquisaPJ = new JComboBox<String>();
			jComboBoxPesquisaPJ.setModel(new DefaultComboBoxModel(new String[] { "--", "Razão social", "Codigo", "CNPJ" }));
			jComboBoxPesquisaPJ.setBounds(79, 260, 119, 22);
			
		}
		return jComboBoxPesquisaPJ;
	}

	public JTextField getJTextFieldPesquisaPJ() {
		if (jTextFieldPesquisaPJ == null) {
			jTextFieldPesquisaPJ = new JTextField();
			jTextFieldPesquisaPJ.setColumns(10);
			jTextFieldPesquisaPJ.setBounds(208, 259, 595, 22);
			
		}
		return jTextFieldPesquisaPJ;
	}

	public JButton getJButtonPesquisaPJ() {
		if (jButtonPesquisaPJ == null) {
			jButtonPesquisaPJ = new JButton("Pesquisar");
			jButtonPesquisaPJ.setBounds(818, 259, 173, 23);
			
		}
		return jButtonPesquisaPJ;
	}

	public DefaultTableModel getDefaultTableModelClientePJ() {
		if (defaultTableModelClientePJ == null) {
			defaultTableModelClientePJ = new DefaultTableModel(new Object[][] {},
					new String[] { "Codigo", "Razão social", "CNPJ", "E-mail" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelClientePJ;
	}

	public JTable getJTableClientePJ() {
		if (jTableClientePJ == null) {
			jTableClientePJ = new JTable(getDefaultTableModelClientePJ());
			jTableClientePJ.getTableHeader().setReorderingAllowed(false);
			jTableClientePJ.setRowSelectionAllowed(true);
			jTableClientePJ.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTableClientePJ.getColumnModel().getColumn(1).setPreferredWidth(300);
			jTableClientePJ.getColumnModel().getColumn(2).setPreferredWidth(150);
			jTableClientePJ.getColumnModel().getColumn(3).setPreferredWidth(300);
			jTableClientePJ.setBounds(79,384,700, 317);
		}
		return jTableClientePJ;
	}

	public JScrollPane getBarraRolagemClientePJ() {
		if (barraRolagemClientePJ == null) {
			barraRolagemClientePJ = new JScrollPane(getJTableClientePJ());
			barraRolagemClientePJ.setBounds(79, 294, 912, 260);
		}
		return barraRolagemClientePJ;
	}

	public JButton getJButtonIncluir() {
		if (jButtonIncluir == null) {
			jButtonIncluir = new JButton("Incluir");
			jButtonIncluir.setForeground(Color.WHITE);
			jButtonIncluir.setBackground(new Color(51, 0, 255));
			jButtonIncluir.setBounds(301, 664, 111, 23);
		}
		return jButtonIncluir;
	}

	public JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton("Excluir");
			jButtonExcluir.setForeground(Color.WHITE);
			jButtonExcluir.setBackground(new Color(255, 0, 0));
			jButtonExcluir.setBounds(422, 664, 111, 23);
		}
		return jButtonExcluir;
	}

	public JButton getJButtonAlterar() {
		if (jButtonAlterar == null) {
			jButtonAlterar = new JButton("Alterar");
			jButtonAlterar.setForeground(Color.WHITE);
			jButtonAlterar.setBackground(new Color(0, 0, 0));
			jButtonAlterar.setBounds(547, 664, 111, 23);
		}
		return jButtonAlterar;
	}

	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102, 204, 0));
			jButtonConfirmar.setBounds(666, 664, 111, 23);
		}
		return jButtonConfirmar;
	}

	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102, 102, 102));
			jButtonCancelar.setBounds(785, 664, 98, 23);
		}
		return jButtonCancelar;
	}
	
	public JRadioButton getJRadioButtonPessoaFisica() {
		if (jRadioButtonPessoaFisica == null) {
			jRadioButtonPessoaFisica = new JRadioButton("Pessoa F\u00EDsica", false);
			getgrupoFis_Jur().add(getJRadioButtonPessoaFisica());
			jRadioButtonPessoaFisica.setBackground(Color.LIGHT_GRAY);
			jRadioButtonPessoaFisica.setBounds(371, 39, 109, 23);
		}
		return jRadioButtonPessoaFisica;
	}

	public JRadioButton getJRadioButtonPessoaJuridica() {
		if (jRadioButtonPessoaJuridica == null) {
			jRadioButtonPessoaJuridica = new JRadioButton("Pessoa Jur\u00EDdica", false);
			getgrupoFis_Jur().add(getJRadioButtonPessoaJuridica());
			jRadioButtonPessoaJuridica.setBackground(Color.LIGHT_GRAY);
			jRadioButtonPessoaJuridica.setBounds(484, 39, 130, 23);
		}
		return jRadioButtonPessoaJuridica;
	}

	public ButtonGroup getgrupoFis_Jur() {
		if (grupoFis_Jur == null) {
			grupoFis_Jur = new ButtonGroup();
		}
		return grupoFis_Jur;
	}
	public JLabel getJLabelAberturaPJ() {
		if (jLabelAberturaPJ == null) {
			jLabelAberturaPJ = new JLabel("Abertura");
			jLabelAberturaPJ.setBounds(714, 12, 96, 22);
		}
		return jLabelAberturaPJ;
	}
	public JDateChooser getJDateChooserDataDeEmissaoPF() {
		if (jDateChooserDataDeEmissaoPF == null) {
			jDateChooserDataDeEmissaoPF = new JDateChooser();
			jDateChooserDataDeEmissaoPF.setBounds(781, 32, 114, 22);
		}
		return jDateChooserDataDeEmissaoPF;
	}
	public JDateChooser getJDateChooserCadastradoEmPF() {
		if (jDateChooserCadastradoEmPF == null) {
			jDateChooserCadastradoEmPF = new JDateChooser();
			jDateChooserCadastradoEmPF.setBounds(805, 89, 114, 22);
		}
		return jDateChooserCadastradoEmPF;
	}
	public JDateChooser getJDateChooserDataDeNascimentoPF() {
		if (jDateChooserDataDeNascimentoPF == null) {
			jDateChooserDataDeNascimentoPF = new JDateChooser();
			jDateChooserDataDeNascimentoPF.setBounds(79, 89, 114, 22);
		}
		return jDateChooserDataDeNascimentoPF;
	}
	public JDateChooser getJDateChooserDataDeAberturaPJ() {
		if (jDateChooserDataDeAberturaPJ == null) {
			jDateChooserDataDeAberturaPJ = new JDateChooser();
			jDateChooserDataDeAberturaPJ.setBounds(714, 32, 114, 22);
		}
		return jDateChooserDataDeAberturaPJ;
	}
	public JDateChooser getJDateChooserCadastradoEmPJ() {
		if (jDateChooserCadastradoEmPJ == null) {
			jDateChooserCadastradoEmPJ = new JDateChooser();
			jDateChooserCadastradoEmPJ.setBounds(845, 32, 114, 22);
		}
		return jDateChooserCadastradoEmPJ;
	}
}
