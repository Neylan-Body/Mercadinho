package model;

import java.awt.Color;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import view.PainelGerenciarFuncionario;

public class ValidarTelaFuncionario {

	private static PainelGerenciarFuncionario painelGerenciarFuncionario;

	public ValidarTelaFuncionario(PainelGerenciarFuncionario painelGerenciarFuncionario) {
		this.painelGerenciarFuncionario = painelGerenciarFuncionario;
	}

	public boolean TesteNome() {
		String numeros = "0123457899";
		for (int i = 0; i < 10; i++) {

			if (getPainelGerenciarFuncionario().getJTextFieldNome().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Nome incorreto");
				getPainelGerenciarFuncionario().getJTextFieldNome().grabFocus();
				getPainelGerenciarFuncionario().getJTextFieldNome().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}
		if (getPainelGerenciarFuncionario().getJTextFieldNome().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Nome incorreto");
			getPainelGerenciarFuncionario().getJTextFieldNome().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldNome().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldNome()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteCPF() {

		if (getPainelGerenciarFuncionario().getJTextFieldCPF().getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "CPF incorreto");
			getPainelGerenciarFuncionario().getJTextFieldCPF().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldCPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldCPF()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteRG() {
		String RG = getPainelGerenciarFuncionario().getJTextFieldRG().getText();
		if (RG.matches("[0-9]+")) {
			getPainelGerenciarFuncionario().getJTextFieldRG()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		} else {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "RG incorreto");
			getPainelGerenciarFuncionario().getJTextFieldRG().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldRG().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteEstadoCivil() {
		if (getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Selecione o estado civil");
			getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().grabFocus();
			getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJComboBoxEstadoCivil()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteOrgaoEmissor() {
		String numeros = "0123457899";

		/*
		 * for (int i = 0; i < 10; i++) {
		 * 
		 * if (getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().getText().
		 * contains(Character.toString(numeros.charAt(i)))) { return false; } }
		 */
		if (getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Órgão emissor incorreto");
			getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteUFDoc() {
		if (getPainelGerenciarFuncionario().getjComboBoxUFDoc().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Selecione UF");
			getPainelGerenciarFuncionario().getjComboBoxUFDoc().grabFocus();
			getPainelGerenciarFuncionario().getjComboBoxUFDoc().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getjComboBoxUFDoc()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeEmissao() {
		Date date = new Date();
		if (getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Data de emissão incorreta");
			getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().grabFocus();
			getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeNascimento() {
		Date date = new Date();
		if (getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Data de nascimento incorreta");
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().grabFocus();
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteCadastradoEm() {
		Date date = new Date();
		if (getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Cadastrado em incorreto");
			getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().grabFocus();
			getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJDateChooserCadastradoEm()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeNascimentoECadastradoEm() {
		if (getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().getDate()
				.before(getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().getDate())) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(),
					"'Cadastrado em' e 'Data de nascimento' incorretos, data de nascimento está depois da data do cadastro");
			getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().grabFocus();
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().grabFocus();
			getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().setBorder(new LineBorder(Color.RED));
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJDateChooserCadastradoEm()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeNascimentoEDataDeEmissao() {
		if (getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().getDate()
				.before(getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().getDate())) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(),
					"'Data de emissão' e 'Data de nascimento' incorretos, data de nascimento está depois da data de emissao");
			getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().grabFocus();
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().grabFocus();
			getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().setBorder(new LineBorder(Color.RED));
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteSexo() {
		if (getPainelGerenciarFuncionario().getjComboBoxSexo().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Selecione o Sexo");
			getPainelGerenciarFuncionario().getjComboBoxSexo().grabFocus();
			getPainelGerenciarFuncionario().getjComboBoxSexo().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getjComboBoxSexo()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteNacionalidade() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {
			if (getPainelGerenciarFuncionario().getJTextFieldNacionalidade().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Nacionalidade incorreta");
				getPainelGerenciarFuncionario().getJTextFieldNacionalidade().grabFocus();
				getPainelGerenciarFuncionario().getJTextFieldNacionalidade().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}
		if (getPainelGerenciarFuncionario().getJTextFieldNacionalidade().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Nacionalidade incorreta");
			getPainelGerenciarFuncionario().getJTextFieldNacionalidade().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldNacionalidade().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldNacionalidade()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteNaturalidade() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {
			if (getPainelGerenciarFuncionario().getJTextFieldNaturalidade().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Naturalidade incorreta");
				getPainelGerenciarFuncionario().getJTextFieldNaturalidade().grabFocus();
				getPainelGerenciarFuncionario().getJTextFieldNaturalidade().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}

		if (getPainelGerenciarFuncionario().getJTextFieldNaturalidade().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Naturalidade incorreta");
			getPainelGerenciarFuncionario().getJTextFieldNaturalidade().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldNaturalidade().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldNaturalidade()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteCEP() {
		if (getPainelGerenciarFuncionario().getJTextFieldCEP().getText().equals("  .   -   ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "CEP incorreto");
			getPainelGerenciarFuncionario().getJTextFieldCEP().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldCEP().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldCEP()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}

	}

	public boolean TesteLogradouro() {

		if (getPainelGerenciarFuncionario().getJTextFieldLogradouro().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Logradouro incorreto");
			getPainelGerenciarFuncionario().getJTextFieldLogradouro().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldLogradouro().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldLogradouro()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteNumero() {
		if (getPainelGerenciarFuncionario().getJTextFieldNumero().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Número incorreto");
			getPainelGerenciarFuncionario().getJTextFieldNumero().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldNumero().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldNumero()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}

	}

	public boolean TesteComplemento() {

		if (getPainelGerenciarFuncionario().getJTextFieldComplemento().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Complemento incorreto");
			getPainelGerenciarFuncionario().getJTextFieldComplemento().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldComplemento().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldComplemento()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteBairro() {

		if (getPainelGerenciarFuncionario().getJTextFieldBairro().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Bairro incorreto");
			getPainelGerenciarFuncionario().getJTextFieldBairro().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldBairro().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldBairro()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteMunicipio() {

		if (getPainelGerenciarFuncionario().getJTextFieldMunicipio().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Município incorreto");
			getPainelGerenciarFuncionario().getJTextFieldMunicipio().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldMunicipio().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldMunicipio()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteUF() {
		if (getPainelGerenciarFuncionario().getjComboBoxUF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Selecione UF");
			getPainelGerenciarFuncionario().getjComboBoxUF().grabFocus();
			getPainelGerenciarFuncionario().getjComboBoxUF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getjComboBoxUF()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteEmail() {

		if (getPainelGerenciarFuncionario().getJTextFieldEmail().getText().equals("")
				|| !FormataMascaras.validar(getPainelGerenciarFuncionario().getJTextFieldEmail().getText())) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Email incorreto");
			getPainelGerenciarFuncionario().getJTextFieldEmail().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldEmail().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldEmail()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteTelefoneCelular() {
		if (getPainelGerenciarFuncionario().getJTextFieldCelular().getText().equals("(  )      -    ")
				&& getPainelGerenciarFuncionario().getJTextFieldTelefone().getText().equals("(  )     -    ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Celular incorreto");
			getPainelGerenciarFuncionario().getJTextFieldCelular().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldCelular().setBorder(new LineBorder(Color.RED));
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Telefone incorreto");
			getPainelGerenciarFuncionario().getJTextFieldTelefone().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldTelefone().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldCelular()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			getPainelGerenciarFuncionario().getJTextFieldTelefone()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteSalario() {
		try {

			double Salario = Double
					.parseDouble(getPainelGerenciarFuncionario().getJTextFieldSalario().getText().replace(",", "."));
			getPainelGerenciarFuncionario().getJTextFieldSalario()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Salario incorreto");
			getPainelGerenciarFuncionario().getJTextFieldSalario().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldSalario().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteOcupacao() {
		if (getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Selecione Ocupação");
			getPainelGerenciarFuncionario().getjComboBoxOcupacao().grabFocus();
			getPainelGerenciarFuncionario().getjComboBoxOcupacao().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getjComboBoxOcupacao()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteSenha() {

		if (getPainelGerenciarFuncionario().getJTextFieldSenha().getText().equals("")
				|| getPainelGerenciarFuncionario().getJTextFieldSenha().getText().length() < 8) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Campo Senha deve ter no minimo 8 digitos");
			getPainelGerenciarFuncionario().getJTextFieldSenha().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldSenha().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldSenha()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteConfirmarSenha() {

		if (getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().getText().equals("")
				|| getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().getText().length() < 8) {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(),
					"Campo Confirmar Senha deve ter no minimo 8 digitos");
			getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		}
	}

	public boolean TesteSenhasIguais() {
		if (getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().getText()
				.equals(getPainelGerenciarFuncionario().getJTextFieldSenha().getText())
				&& !getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().getText().equals("")) {
			getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			getPainelGerenciarFuncionario().getJTextFieldSenha()
					.setBorder(getPainelGerenciarFuncionario().getJTextFieldCodigo().getBorder());
			return true;
		} else {
			JOptionPane.showMessageDialog(getPainelGerenciarFuncionario(), "Senhas não conferem");
			getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().setBorder(new LineBorder(Color.RED));
			getPainelGerenciarFuncionario().getJTextFieldSenha().grabFocus();
			getPainelGerenciarFuncionario().getJTextFieldSenha().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public static PainelGerenciarFuncionario getPainelGerenciarFuncionario() {
		if (painelGerenciarFuncionario == null) {
			painelGerenciarFuncionario = new PainelGerenciarFuncionario();
		}
		return painelGerenciarFuncionario;
	}

}
