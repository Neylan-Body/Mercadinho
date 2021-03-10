package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import model.FormataMascaras;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class PainelGerenciarFuncionario extends JPanel {

	private JLabel jLabelGerenciarFuncionario;
	private JLabel jLabelCodigo;
	private JTextField jTextFieldCodigo;
	private JLabel jLabelNome;
	private JTextField jTextFieldNome;
	private JLabel jLabelCpf;
	private JTextField jTextFieldCPF;
	private JLabel jLabelRG;
	private JTextField jTextFieldRG;
	private JLabel jLabelOrgaoEmissor;
	private JTextField jTextFieldOrgaoEmissor;
	private JLabel jLabelDataDeEmissao;
	private JLabel jLabelEstadoCivil;
	private JComboBox<String> jComboBoxEstadoCivil;
	private JLabel jLabelDataDeNascimento;
	private JLabel jLabelNacionalidade;
	private JTextField jTextFieldNacionalidade;
	private JLabel jLabelUFDoc;
	private JComboBox<String> jComboBoxUFDoc;
	private JLabel jLabelNaturalidade;
	private JTextField jTextFieldNaturalidade;
	private JLabel jLabelSexo;
	private JComboBox<String> jComboBoxSexo;
	private JLabel jLabelCadastradoEm;
	private JLabel jLabelCep;
	private JTextField jTextFieldCEP;
	private JLabel jLabelLogradouro;
	private JTextField jTextFieldLogradouro;
	private JLabel jLabelNumero;
	private JLabel jLabelComplemento;
	private JTextField jTextFieldNumero;
	private JLabel jLabelBairro;
	private JTextField jTextFieldBairro;
	private JTextField jTextFieldComplemento;
	private JLabel jLabelMunicipio;
	private JTextField jTextFieldMunicipio;
	private JLabel jLabelEmail;
	private JLabel jLabelTelefone;
	private JTextField jTextFieldEmail;
	private JLabel jLabelCelular;
	private JTextField jTextFieldCelular;
	private JTextField jTextFieldTelefone;
	private JLabel jLabelUF;
	private JComboBox<String> jComboBoxUF;
	private JLabel jLabelOcupacao;
	private JComboBox<String> jComboBoxOcupacao;
	private JButton JButtonAddOcupacao;
	private JButton jButtonRemoverOcupacao;
	private JButton jButtonAlterarOcupacao;
	private JLabel jLabelSalario;
	private JLabel jLabelSenha;
	private JTextField jTextFieldSalario;
	private JLabel jLabelConfirmarSenha;
	private JTextField jTextFieldConfirmarSenha;
	private JTextField jTextFieldSenha;
	private JComboBox<String> jComboBoxPesquisa;
	private JTextField jTextFieldPesquisa;
	private JButton jButtonPesquisar;
	private JSeparator separator;
	private DefaultTableModel defaultTableModelFuncionario;
	private JTable jTableFuncionario;
	private JScrollPane barraRolagemFuncionario;
	private JButton jButtonIncluir;
	private JButton jButtonExcluir;
	private JButton jButtonAlterar;
	private JButton jButtonConfirmar;
	private JButton jButtonCancelar;
	private JDateChooser jDateChooserDataDeNascimento;
	private JDateChooser jDateChooserDataDeEmissao;
	private JDateChooser jDateChooserCadastradoEm;
	
	public PainelGerenciarFuncionario() {
		setBackground(Color.LIGHT_GRAY);
		setSize(1210, 693);
		setLayout(null);

		add(getJLabelGerenciarFuncionario());
		add(getJLabelCodigo());
		add(getJTextFieldCodigo());
		add(getJLabelNome());
		add(getJTextFieldNome());
		add(getJLabelCpf());
		add(getJTextFieldCPF());
		add(getJLabelRG());
		add(getJTextFieldRG());
		add(getJLabelOrgaoEmissor());
		add(getJTextFieldOrgaoEmissor());
		add(getJLabelDataDeEmissao());
		add(getJLabelEstadoCivil());
		add(getJComboBoxEstadoCivil());
		add(getJLabelDataDeNascimento());
		add(getJLabelNacionalidade());
		add(getJTextFieldNacionalidade());
		add(getJLabelUFDoc());
		add(getjComboBoxUF());
		add(getJLabelNaturalidade());
		add(getJTextFieldNaturalidade());
		add(getJLabelSexo());
		add(getjComboBoxSexo());
		add(getJLabelCadastradoEm());
		add(getJLabelCep());
		add(getJTextFieldCEP());
		add(getJLabelLogradouro());
		add(getJTextFieldLogradouro());
		add(getJLabelNumero());
		add(getJLabelComplemento());
		add(getJTextFieldNumero());
		add(getJLabelBairro());
		add(getJTextFieldBairro());
		add(getJTextFieldComplemento());
		add(getJLabelMunicipio());
		add(getJTextFieldMunicipio());
		add(getJLabelEmail());
		add(getJLabelTelefone());
		add(getJTextFieldEmail());
		add(getJLabelCelular());
		add(getJTextFieldCelular());
		add(getJTextFieldTelefone());
		add(getJLabelUF());
		add(getjComboBoxUFDoc());
		add(getJLabelOcupacao());
		add(getjComboBoxOcupacao());
		add(getJButtonAddOcupacao());
		add(getJButtonRemoverOcupacao());
		add(getJButtonAlterarOcupacao());
		add(getJLabelSalario());
		add(getJLabelSenha());
		add(getJTextFieldSalario());
		add(getJLabelConfirmarSenha());
		add(getJTextFieldConfirmarSenha());
		add(getJTextFieldSenha());
		add(getJComboBoxPesquisa());
		add(getJTextFieldPesquisa());
		add(getJButtonPesquisar());
		add(getSeparator());
		add(getBarraRolagemFuncionario());
		add(getJButtonIncluir());
		add(getJButtonExcluir());
		add(getJButtonAlterar());
		add(getJButtonConfirmar());
		add(getJButtonCancelar());
		add(getJDateChooserDataDeNascimento());
		add(getJDateChooserDataDeEmissao());
		add(getJDateChooserCadastradoEm());
	}

	public JLabel getJLabelGerenciarFuncionario() {
		if (jLabelGerenciarFuncionario == null) {
			jLabelGerenciarFuncionario = new JLabel("Gerenciar funcionario");
			jLabelGerenciarFuncionario.setFont(new Font("Arial", Font.BOLD, 32));
			jLabelGerenciarFuncionario.setBounds(79, 39, 489, 65);
		}
		return jLabelGerenciarFuncionario;
	}

	public JLabel getJLabelCodigo() {
		if (jLabelCodigo == null) {
			jLabelCodigo = new JLabel("Codigo");
			jLabelCodigo.setBounds(79, 116, 75, 22);
		}
		return jLabelCodigo;
	}

	public JTextField getJTextFieldCodigo() {
		if (jTextFieldCodigo == null) {
			jTextFieldCodigo = new JTextField();
			jTextFieldCodigo.setColumns(10);
			jTextFieldCodigo.setBounds(79, 133, 75, 22);
		}
		return jTextFieldCodigo;
	}

	public JLabel getJLabelNome() {
		if (jLabelNome == null) {
			jLabelNome = new JLabel("Nome");
			jLabelNome.setBounds(166, 116, 245, 22);
		}
		return jLabelNome;
	}

	public JTextField getJTextFieldNome() {
		if (jTextFieldNome == null) {
			jTextFieldNome = new JTextField();
			jTextFieldNome.setColumns(10);
			jTextFieldNome.setBounds(166, 133, 245, 22);
		}
		return jTextFieldNome;
	}

	public JLabel getJLabelCpf() {
		if (jLabelCpf == null) {
			jLabelCpf = new JLabel("CPF");
			jLabelCpf.setBounds(423, 116, 124, 22);
		}
		return jLabelCpf;
	}

	public JTextField getJTextFieldCPF() {
		if (jTextFieldCPF == null) {
			jTextFieldCPF = new JFormattedTextField(new FormataMascaras().getCPF());
			jTextFieldCPF.setColumns(10);
			jTextFieldCPF.setBounds(423, 133, 124, 22);
		}
		return jTextFieldCPF;
	}

	public JLabel getJLabelRG() {
		if (jLabelRG == null) {
			jLabelRG = new JLabel("RG");
			jLabelRG.setBounds(559, 116, 124, 22);
		}
		return jLabelRG;
	}

	public JTextField getJTextFieldRG() {
		if (jTextFieldRG == null) {
			jTextFieldRG = new JTextField();
			jTextFieldRG.setColumns(10);
			jTextFieldRG.setBounds(559, 133, 124, 22);
		}
		return jTextFieldRG;
	}

	public JLabel getJLabelOrgaoEmissor() {
		if (jLabelOrgaoEmissor == null) {
			jLabelOrgaoEmissor = new JLabel("Org\u00E3o emissor");
			jLabelOrgaoEmissor.setBounds(695, 116, 96, 22);
		}
		return jLabelOrgaoEmissor;
	}

	public JTextField getJTextFieldOrgaoEmissor() {
		if (jTextFieldOrgaoEmissor == null) {
			jTextFieldOrgaoEmissor = new JTextField();
			jTextFieldOrgaoEmissor.setColumns(10);
			jTextFieldOrgaoEmissor.setBounds(695, 133, 96, 22);
		}
		return jTextFieldOrgaoEmissor;
	}

	public JLabel getJLabelDataDeEmissao() {
		if (jLabelDataDeEmissao == null) {
			jLabelDataDeEmissao = new JLabel("Data da emiss\u00E3o");
			jLabelDataDeEmissao.setBounds(803, 116, 96, 22);
		}
		return jLabelDataDeEmissao;
	}

	public JLabel getJLabelEstadoCivil() {
		if (jLabelEstadoCivil == null) {
			jLabelEstadoCivil = new JLabel("Estado civil");
			jLabelEstadoCivil.setBounds(928, 116, 124, 22);
		}
		return jLabelEstadoCivil;
	}

	public JComboBox<String> getJComboBoxEstadoCivil() {
		if (jComboBoxEstadoCivil == null) {
			jComboBoxEstadoCivil = new JComboBox<String>();
			jComboBoxEstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"--"," Solteiro", "Casado", "Uni\u00E3o est\u00E1vel", "Vi\u00FAvo", "Divorciado"}));
			jComboBoxEstadoCivil.setBounds(928, 134, 124, 21);
		}
		return jComboBoxEstadoCivil;
	}

	public JLabel getJLabelDataDeNascimento() {
		if (jLabelDataDeNascimento == null) {
			jLabelDataDeNascimento = new JLabel("Data de nascimento");
			jLabelDataDeNascimento.setBounds(79, 155, 124, 22);
		}
		return jLabelDataDeNascimento;
	}

	public JLabel getJLabelNacionalidade() {
		if (jLabelNacionalidade == null) {
			jLabelNacionalidade = new JLabel("Nacionalidade");
			jLabelNacionalidade.setBounds(215, 155, 124, 22);
		}
		return jLabelNacionalidade;
	}

	public JTextField getJTextFieldNacionalidade() {
		if (jTextFieldNacionalidade == null) {
			jTextFieldNacionalidade = new JTextField();
			jTextFieldNacionalidade.setColumns(10);
			jTextFieldNacionalidade.setBounds(215, 174, 177, 22);
		}
		return jTextFieldNacionalidade;
	}

	public JLabel getJLabelUFDoc() {
		if (jLabelUFDoc == null) {
			jLabelUFDoc = new JLabel("UF");
			jLabelUFDoc.setBounds(404, 155, 103, 22);
		}
		return jLabelUFDoc;
	}

	public JComboBox<String> getjComboBoxUFDoc() {
		if (jComboBoxUFDoc == null) {
			jComboBoxUFDoc = new JComboBox<String>();
			jComboBoxUFDoc.setBounds(404, 174, 143, 22);
			jComboBoxUFDoc.setModel(new DefaultComboBoxModel(
					new String[] { "--", "Acre", "Alagoas", "Amap\u00E1", "Amazonas", "Bahia", "Cear\u00E1",
							"Distrito Federal", "Espir\u00EDto Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso",
							"Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1",
							"Pernambuco", "Piau\u00ED", "Rio de Janero", "Rio Grande do Norte", "Rio Grande do Sul",
							"Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins" }));
		}
		return jComboBoxUFDoc;
	}

	public JLabel getJLabelNaturalidade() {
		if (jLabelNaturalidade == null) {
			jLabelNaturalidade = new JLabel("Naturalidade");
			jLabelNaturalidade.setBounds(559, 155, 124, 22);
		}
		return jLabelNaturalidade;
	}

	public JTextField getJTextFieldNaturalidade() {
		if (jTextFieldNaturalidade == null) {
			jTextFieldNaturalidade = new JTextField();
			jTextFieldNaturalidade.setColumns(10);
			jTextFieldNaturalidade.setBounds(558, 174, 200, 22);
		}
		return jTextFieldNaturalidade;
	}

	public JLabel getJLabelSexo() {
		if (jLabelSexo == null) {
			jLabelSexo = new JLabel("Sexo");
			jLabelSexo.setBounds(770, 155, 103, 22);
		}
		return jLabelSexo;
	}

	public JComboBox<String> getjComboBoxSexo() {
		if (jComboBoxSexo == null) {
			jComboBoxSexo = new JComboBox<String>();
			jComboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"--", "Masculino", "Feminino"}));
			jComboBoxSexo.setBounds(770, 174, 135, 22);
		}
		return jComboBoxSexo;
	}

	public JLabel getJLabelCadastradoEm() {
		if (jLabelCadastradoEm == null) {
			jLabelCadastradoEm = new JLabel("Cadastrado em");
			jLabelCadastradoEm.setBounds(917, 155, 124, 22);
		}
		return jLabelCadastradoEm;
	}

	public JLabel getJLabelCep() {
		if (jLabelCep == null) {
			jLabelCep = new JLabel("CEP");
			jLabelCep.setBounds(79, 200, 124, 22);
		}
		return jLabelCep;
	}

	public JTextField getJTextFieldCEP() {
		if (jTextFieldCEP == null) {
			jTextFieldCEP = new JFormattedTextField(new FormataMascaras().getCEP());
			jTextFieldCEP.setColumns(10);
			jTextFieldCEP.setBounds(79, 219, 157, 22);
		}
		return jTextFieldCEP;
	}

	public JLabel getJLabelLogradouro() {
		if (jLabelLogradouro == null) {
			jLabelLogradouro = new JLabel("Logradouro");
			jLabelLogradouro.setBounds(248, 200, 124, 22);
		}
		return jLabelLogradouro;
	}

	public JTextField getJTextFieldLogradouro() {
		if (jTextFieldLogradouro == null) {
			jTextFieldLogradouro = new JTextField();
			jTextFieldLogradouro.setColumns(10);
			jTextFieldLogradouro.setBounds(248, 219, 372, 22);
		}
		return jTextFieldLogradouro;
	}

	public JLabel getJLabelNumero() {
		if (jLabelNumero == null) {
			jLabelNumero = new JLabel("Numero");
			jLabelNumero.setBounds(632, 200, 75, 22);
		}
		return jLabelNumero;
	}

	public JLabel getJLabelComplemento() {
		if (jLabelComplemento == null) {
			jLabelComplemento = new JLabel("Complemento");
			jLabelComplemento.setBounds(719, 200, 124, 22);
		}
		return jLabelComplemento;
	}

	public JTextField getJTextFieldNumero() {
		if (jTextFieldNumero == null) {
			jTextFieldNumero = new JTextField();
			jTextFieldNumero.setColumns(10);
			jTextFieldNumero.setBounds(632, 219, 75, 22);
		}
		return jTextFieldNumero;
	}

	public JLabel getJLabelBairro() {
		if (jLabelBairro == null) {
			jLabelBairro = new JLabel("Bairro");
			jLabelBairro.setBounds(884, 200, 157, 22);
		}
		return jLabelBairro;
	}

	public JTextField getJTextFieldBairro() {
		if (jTextFieldBairro == null) {
			jTextFieldBairro = new JTextField();
			jTextFieldBairro.setColumns(10);
			jTextFieldBairro.setBounds(884, 219, 168, 22);
		}
		return jTextFieldBairro;
	}

	public JTextField getJTextFieldComplemento() {
		if (jTextFieldComplemento == null) {
			jTextFieldComplemento = new JTextField();
			jTextFieldComplemento.setColumns(10);
			jTextFieldComplemento.setBounds(719, 219, 153, 22);
		}
		return jTextFieldComplemento;
	}

	public JLabel getJLabelMunicipio() {
		if (jLabelMunicipio == null) {
			jLabelMunicipio = new JLabel("Municipio");
			jLabelMunicipio.setBounds(79, 243, 124, 22);
		}
		return jLabelMunicipio;
	}

	public JTextField getJTextFieldMunicipio() {
		if (jTextFieldMunicipio == null) {
			jTextFieldMunicipio = new JTextField();
			jTextFieldMunicipio.setColumns(10);
			jTextFieldMunicipio.setBounds(79, 262, 200, 22);
		}
		return jTextFieldMunicipio;
	}

	public JLabel getJLabelEmail() {
		if (jLabelEmail == null) {
			jLabelEmail = new JLabel("Email");
			jLabelEmail.setBounds(446, 243, 75, 22);
		}
		return jLabelEmail;
	}

	public JLabel getJLabelTelefone() {
		if (jLabelTelefone == null) {
			jLabelTelefone = new JLabel("Telefone");
			jLabelTelefone.setBounds(665, 243, 124, 22);
		}
		return jLabelTelefone;
	}

	public JTextField getJTextFieldEmail() {
		if (jTextFieldEmail == null) {
			jTextFieldEmail = new JTextField();
			jTextFieldEmail.setColumns(10);
			jTextFieldEmail.setBounds(446, 262, 207, 22);
		}
		return jTextFieldEmail;
	}

	public JLabel getJLabelCelular() {
		if (jLabelCelular == null) {
			jLabelCelular = new JLabel("Celular");
			jLabelCelular.setBounds(855, 243, 157, 22);
		}
		return jLabelCelular;
	}

	public JTextField getJTextFieldCelular() {
		if (jTextFieldCelular == null) {
			jTextFieldCelular = new JFormattedTextField(new FormataMascaras().getCelular());
			jTextFieldCelular.setColumns(10);
			jTextFieldCelular.setBounds(855, 262, 197, 22);
		}
		return jTextFieldCelular;
	}

	public JTextField getJTextFieldTelefone() {
		if (jTextFieldTelefone == null) {
			jTextFieldTelefone = new JFormattedTextField(new FormataMascaras().getTelefone());
			jTextFieldTelefone.setColumns(10);
			jTextFieldTelefone.setBounds(665, 262, 178, 22);
		}
		return jTextFieldTelefone;
	}

	public JLabel getJLabelUF() {
		if (jLabelUF == null) {
			jLabelUF = new JLabel("UF");
			jLabelUF.setBounds(291, 243, 103, 22);
		}
		return jLabelUF;
	}

	public JComboBox<String> getjComboBoxUF() {
		if (jComboBoxUF == null) {
			jComboBoxUF = new JComboBox<String>();
			jComboBoxUF.setModel(new DefaultComboBoxModel(
					new String[] { "--", "Acre", "Alagoas", "Amap\u00E1", "Amazonas", "Bahia", "Cear\u00E1",
							"Distrito Federal", "Espir\u00EDto Santo", "Goi\u00E1s", "Maranh\u00E3o", "Mato Grosso",
							"Mato Grosso do Sul", "Minas Gerais", "Par\u00E1", "Para\u00EDba", "Paran\u00E1",
							"Pernambuco", "Piau\u00ED", "Rio de Janero", "Rio Grande do Norte", "Rio Grande do Sul",
							"Rond\u00F4nia", "Roraima", "Santa Catarina", "S\u00E3o Paulo", "Sergipe", "Tocantins" }));
			jComboBoxUF.setBounds(291, 262, 143, 22);
		}
		return jComboBoxUF;
	}

	public JLabel getJLabelOcupacao() {
		if (jLabelOcupacao == null) {
			jLabelOcupacao = new JLabel("Ocupa\u00E7\u00E3o");
			jLabelOcupacao.setBounds(80, 294, 124, 22);
		}
		return jLabelOcupacao;
	}

	public JComboBox<String> getjComboBoxOcupacao() {
		if (jComboBoxOcupacao == null) {
			jComboBoxOcupacao = new JComboBox<String>();
			jComboBoxOcupacao.setModel(new DefaultComboBoxModel(new String[] {"--"}));
			jComboBoxOcupacao.setBounds(79, 312, 177, 22);
		}
		return jComboBoxOcupacao;
	}

	public JButton getJButtonAddOcupacao() {
		if (JButtonAddOcupacao == null) {
			JButtonAddOcupacao = new JButton("+");
			JButtonAddOcupacao.setBounds(268, 312, 53, 23);
		}
		return JButtonAddOcupacao;
	}

	public JButton getJButtonRemoverOcupacao() {
		if (jButtonRemoverOcupacao == null) {
			jButtonRemoverOcupacao = new JButton("-");
			jButtonRemoverOcupacao.setBounds(333, 312, 53, 23);
		}
		return jButtonRemoverOcupacao;
	}

	public JButton getJButtonAlterarOcupacao() {
		if (jButtonAlterarOcupacao == null) {
			jButtonAlterarOcupacao = new JButton("A");
			jButtonAlterarOcupacao.setBounds(398, 312, 53, 23);
		}
		return jButtonAlterarOcupacao;
	}

	public JLabel getJLabelSalario() {
		if (jLabelSalario == null) {
			jLabelSalario = new JLabel("Salario (R$)");
			jLabelSalario.setBounds(469, 294, 75, 22);
		}
		return jLabelSalario;
	}

	public JLabel getJLabelSenha() {
		if (jLabelSenha == null) {
			jLabelSenha = new JLabel("Senha");
			jLabelSenha.setBounds(666, 293, 124, 22);
		}
		return jLabelSenha;
	}

	public JTextField getJTextFieldSalario() {
		if (jTextFieldSalario == null) {
			jTextFieldSalario = new JTextField();
			jTextFieldSalario.setColumns(10);
			jTextFieldSalario.setBounds(468, 312, 186, 22);
		}
		return jTextFieldSalario;
	}

	public JLabel getJLabelConfirmarSenha() {
		if (jLabelConfirmarSenha == null) {
			jLabelConfirmarSenha = new JLabel("Confirmar senha");
			jLabelConfirmarSenha.setBounds(856, 293, 157, 22);
		}
		return jLabelConfirmarSenha;
	}

	public JTextField getJTextFieldConfirmarSenha() {
		if (jTextFieldConfirmarSenha == null) {
			jTextFieldConfirmarSenha = new JPasswordField();
			jTextFieldConfirmarSenha.setBounds(856, 312, 196, 22);
		}
		return jTextFieldConfirmarSenha;
	}

	public JTextField getJTextFieldSenha() {
		if (jTextFieldSenha == null) {
			jTextFieldSenha = new JPasswordField();
			jTextFieldSenha.setBounds(666, 312, 178, 22);
		}
		return jTextFieldSenha;
	}

	public JComboBox<String> getJComboBoxPesquisa() {
		if (jComboBoxPesquisa == null) {
			jComboBoxPesquisa = new JComboBox<String>();
			jComboBoxPesquisa.setModel(new DefaultComboBoxModel(new String[] {"--", "Nome", "Codigo", "CPF", "Ocupação"}));
			jComboBoxPesquisa.setBounds(79, 381, 119, 22);
		}
		return jComboBoxPesquisa;
	}

	public JTextField getJTextFieldPesquisa() {
		if (jTextFieldPesquisa == null) {
			jTextFieldPesquisa = new JTextField();
			jTextFieldPesquisa.setColumns(10);
			jTextFieldPesquisa.setBounds(205, 382, 595, 22);
		}
		return jTextFieldPesquisa;
	}

	public JButton getJButtonPesquisar() {
		if (jButtonPesquisar == null) {
			jButtonPesquisar = new JButton("Pesquisar");
			jButtonPesquisar.setBounds(810, 381, 173, 23);
		}
		return jButtonPesquisar;
	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBackground(Color.BLACK);
			separator.setBounds(0, 360, 1340, 2);
		}
		return separator;
	}
	
	public DefaultTableModel getDefaultTableModelFuncionario() {
		if (defaultTableModelFuncionario == null) {
			defaultTableModelFuncionario = new DefaultTableModel(new Object[][] {},
					new String[] { "Codigo", "CPF", "Nome", "Ocupação", "E-mail" }) {
				public boolean isCellEditable(int row, int column) {
					return false;

				}
			};
		}
		return defaultTableModelFuncionario;
	}
	
	
	public JTable getJTableFuncionario() {
		if (jTableFuncionario == null) {
			jTableFuncionario = new JTable(getDefaultTableModelFuncionario());
			jTableFuncionario.getTableHeader().setReorderingAllowed(false);
			jTableFuncionario.setRowSelectionAllowed(true);
			jTableFuncionario.getColumnModel().getColumn(0).setPreferredWidth(50);
			jTableFuncionario.getColumnModel().getColumn(1).setPreferredWidth(150);
			jTableFuncionario.getColumnModel().getColumn(2).setPreferredWidth(300);
			jTableFuncionario.getColumnModel().getColumn(3).setPreferredWidth(300);
			jTableFuncionario.getColumnModel().getColumn(4).setPreferredWidth(300);
			jTableFuncionario.setLocation(79, 384);
			jTableFuncionario.setSize(700, 317);
		}
		return jTableFuncionario;
	}

	public JScrollPane getBarraRolagemFuncionario() {
		if (barraRolagemFuncionario == null) {
			barraRolagemFuncionario = new JScrollPane(getJTableFuncionario());
			barraRolagemFuncionario.setLocation(79, 427);
			barraRolagemFuncionario.setSize(1070, 218);
		}
		return barraRolagemFuncionario;
	}
	public JButton getJButtonIncluir() {
		if (jButtonIncluir == null) {
			jButtonIncluir = new JButton("Incluir");
			jButtonIncluir.setForeground(Color.WHITE);
			jButtonIncluir.setBackground(new Color(51,0,255));
			jButtonIncluir.setBounds(258, 659, 111, 23);
		}
		return jButtonIncluir;
	}
	public JButton getJButtonExcluir() {
		if (jButtonExcluir == null) {
			jButtonExcluir = new JButton("Excluir");
			jButtonExcluir.setForeground(Color.WHITE);
			jButtonExcluir.setBackground(new Color(255,0,0));
			jButtonExcluir.setBounds(379, 659, 111, 23);
		}
		return jButtonExcluir;
	}
	public JButton getJButtonAlterar() {
		if (jButtonAlterar == null) {
			jButtonAlterar = new JButton("Alterar");
			jButtonAlterar.setForeground(Color.WHITE);
			jButtonAlterar.setBackground(new Color(0,0,0));
			jButtonAlterar.setBounds(504, 659, 111, 23);
		}
		return jButtonAlterar;
	}
	public JButton getJButtonConfirmar() {
		if (jButtonConfirmar == null) {
			jButtonConfirmar = new JButton("Confirmar");
			jButtonConfirmar.setForeground(Color.WHITE);
			jButtonConfirmar.setBackground(new Color(102,204,0));
			jButtonConfirmar.setBounds(623, 659, 111, 23);
		}
		return jButtonConfirmar;
	}
	public JButton getJButtonCancelar() {
		if (jButtonCancelar == null) {
			jButtonCancelar = new JButton("Cancelar");
			jButtonCancelar.setForeground(Color.WHITE);
			jButtonCancelar.setBackground(new Color(102,102,102));
			jButtonCancelar.setBounds(742, 659, 98, 23);
		}
		return jButtonCancelar;
	}
	public JDateChooser getJDateChooserDataDeNascimento() {
		if (jDateChooserDataDeNascimento == null) {
			jDateChooserDataDeNascimento = new JDateChooser();
			jDateChooserDataDeNascimento.getSpinner().setModel(new SpinnerDateModel(new Date(1562554384248L), null, null, Calendar.WEEK_OF_MONTH));
			jDateChooserDataDeNascimento.setBounds(79, 174, 124, 22);
		}
		return jDateChooserDataDeNascimento;
	}
	public JDateChooser getJDateChooserDataDeEmissao() {
		if (jDateChooserDataDeEmissao == null) {
			jDateChooserDataDeEmissao = new JDateChooser();
			jDateChooserDataDeEmissao.setBounds(803, 133, 114, 22);
		}
		return jDateChooserDataDeEmissao;
	}
	public JDateChooser getJDateChooserCadastradoEm() {
		if (jDateChooserCadastradoEm == null) {
			jDateChooserCadastradoEm = new JDateChooser();
			jDateChooserCadastradoEm.setBounds(917, 174, 135, 22);
		}
		return jDateChooserCadastradoEm;
	}
}
