package model;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import view.PainelGerenciarFornecedor;

public class ValidarTelaFornecedor {

	private static PainelGerenciarFornecedor painelGerenciarFornecedor;

	public ValidarTelaFornecedor(PainelGerenciarFornecedor painelGerenciarFornecedor) {
		this.painelGerenciarFornecedor = painelGerenciarFornecedor;
	}

	public boolean TesteRazaoSocialPJ() {
		String numeros = "0123457899";

		/*
		 * for (int i = 0; i < 10; i++) {
		 * 
		 * if (getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().getText().
		 * contains(Character.toString(numeros.charAt(i)))) { return false; } }
		 */

		if (getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Razão Social incorreto");
			getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCNPJPJ() {

		if (getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().getText().equals("  .   .   /    -  ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "CNPJ incorreto");
			getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldCNPJPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCEPPJ() {

		if (getPainelGerenciarFornecedor().getJTextFieldCEPPJ().getText().equals("  .   -   ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "CEP incorreto");
			getPainelGerenciarFornecedor().getJTextFieldCEPPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldCEPPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldCEPPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteLogradouroPJ() {

		if (getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Logradouro incorreto");
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteNumeroPJ() {
		if (getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Numero incorreto");
			getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldNumeroPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteIEPJ() {
		String IE = getPainelGerenciarFornecedor().getJTextFieldIEPJ().getText();
		if (IE.matches("[0-9]+")) {
			getPainelGerenciarFornecedor().getJTextFieldIEPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		} else {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "IE incorreto");
			getPainelGerenciarFornecedor().getJTextFieldIEPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldIEPJ().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteComplementoPJ() {

		if (getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Complemento incorreto");
			getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldComplementoPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteBairroPJ() {
		if (getPainelGerenciarFornecedor().getJTextFieldBairroPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Bairro incorreto");
			getPainelGerenciarFornecedor().getJTextFieldBairroPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldBairroPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldBairroPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteMunicipioPJ() {

		if (getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Município incorreto");
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteUFPJ() {
		if (getPainelGerenciarFornecedor().getJComboBoxUFPJ().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Selecione UF");
			getPainelGerenciarFornecedor().getJComboBoxUFPJ().grabFocus();
			getPainelGerenciarFornecedor().getJComboBoxUFPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJComboBoxUFPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteEmailPJ() {

		if (getPainelGerenciarFornecedor().getJTextFieldEmailPJ().getText().equals("")
				|| !FormataMascaras.validar(getPainelGerenciarFornecedor().getJTextFieldEmailPJ().getText())) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Email incorreto");
			getPainelGerenciarFornecedor().getJTextFieldEmailPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldEmailPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldEmailPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteTelefoneCelularPJ() {

		if (getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().getText().equals("(  )     -    ")
				&& getPainelGerenciarFornecedor().getJTextFieldCelularPJ().getText().equals("(  )      -    ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Telefone incorreto");
			getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().setBorder(new LineBorder(Color.RED));
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Celular incorreto");
			getPainelGerenciarFornecedor().getJTextFieldCelularPJ().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldCelularPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldTelefonePJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			getPainelGerenciarFornecedor().getJTextFieldCelularPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteAtivoInativoPJ() {

		if (!getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().isSelected()
				&& !getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().isSelected()) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Selecione a situação do cliente");
			return false;
		} else
			return true;
	}

	//////////////////////////////////// PF
	//////////////////////////////////// ////////////////////////////////////////////////

	public boolean TesteNome() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {

			if (getPainelGerenciarFornecedor().getJTextFieldNomePF().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Nome incorreto");
				getPainelGerenciarFornecedor().getJTextFieldNomePF().grabFocus();
				getPainelGerenciarFornecedor().getJTextFieldNomePF().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}
		if (getPainelGerenciarFornecedor().getJTextFieldNomePF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Nome incorreto");
			getPainelGerenciarFornecedor().getJTextFieldNomePF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldNomePF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldNomePF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteCPFPF() {

		if (getPainelGerenciarFornecedor().getJTextFieldCPFPF().getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "CPF incorreto");
			getPainelGerenciarFornecedor().getJTextFieldCPFPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldCPFPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldCPFPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteOrgaoEmissorPF() {
		String numeros = "0123457899";

		/*
		 * for (int i = 0; i < 10; i++) {
		 * 
		 * if (getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissor().getText().
		 * contains(Character.toString(numeros.charAt(i)))) { return false; } }
		 */
		if (getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Órgão emissor incorreto");
			getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeEmissaoPF() {
		Date date = new Date();
		if (getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Data de emissão incorreta");
			getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF().grabFocus();
			getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCadastradoEmPF() {
		Date date = new Date();
		if (getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Cadastrado em incorreto");
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF().grabFocus();
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCadastradoEmPJ() {
		Date date = new Date();
		if (getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Cadastrado em incorreto");
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().grabFocus();
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteRGPF() {
		String RG = getPainelGerenciarFornecedor().getJTextFieldRGPF().getText();
		if (RG.matches("[0-9]+")) {
			getPainelGerenciarFornecedor().getJTextFieldRGPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		} else {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "RG incorreto");
			getPainelGerenciarFornecedor().getJTextFieldRGPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldRGPF().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteNacionalidadePF() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {

			if (getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Nacionalidade incorreta");
				getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().grabFocus();
				getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}

		if (getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Nacionalidade incorreta");
			getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteUFDocPF() {
		if (getPainelGerenciarFornecedor().getJComboBoxUFDocPF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Selecione UF");
			getPainelGerenciarFornecedor().getJComboBoxUFDocPF().grabFocus();
			getPainelGerenciarFornecedor().getJComboBoxUFDocPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJComboBoxUFDocPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteNaturalidadePF() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {

			if (getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Naturalidade incorreta");
				getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().grabFocus();
				getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}

		if (getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Naturalidade incorreta");
			getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteSexoPF() {
		if (getPainelGerenciarFornecedor().getJComboBoxSexoPF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Selecione Sexo");
			getPainelGerenciarFornecedor().getJComboBoxSexoPF().grabFocus();
			getPainelGerenciarFornecedor().getJComboBoxSexoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJComboBoxSexoPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteCEPPF() {

		if (getPainelGerenciarFornecedor().getJTextFieldCEPPF().getText().equals("  .   -   ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "CEP incorreto");
			getPainelGerenciarFornecedor().getJTextFieldCEPPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldCEPPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldCEPPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteLogradouroPF() {

		if (getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Logradouro incorreto");
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteNumeroPF() {
		if (getPainelGerenciarFornecedor().getJTextFieldNumeroPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Numero incorreto");
			getPainelGerenciarFornecedor().getJTextFieldNumeroPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldNumeroPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldNumeroPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteComplementoPF() {

		if (getPainelGerenciarFornecedor().getJTextFieldComplementoPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Complemento incorreto");
			getPainelGerenciarFornecedor().getJTextFieldComplementoPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldComplementoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldComplementoPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteBairroPF() {

		if (getPainelGerenciarFornecedor().getJTextFieldBairroPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Bairro incorreto");
			getPainelGerenciarFornecedor().getJTextFieldBairroPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldBairroPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldBairroPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteMunicipioPF() {

		if (getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Município incorreto");
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteUFPF() {
		if (getPainelGerenciarFornecedor().getJComboBoxUFPF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Selecione UF");
			getPainelGerenciarFornecedor().getJComboBoxUFPF().grabFocus();
			getPainelGerenciarFornecedor().getJComboBoxUFPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJComboBoxUFPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteEmailPF() {
		if (getPainelGerenciarFornecedor().getJTextFieldEmailPF().getText().equals("")
				|| !FormataMascaras.validar(getPainelGerenciarFornecedor().getJTextFieldEmailPF().getText())) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Email incorreto");
			getPainelGerenciarFornecedor().getJTextFieldEmailPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldEmailPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldEmailPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteTelefoneCelularPF() {

		if (getPainelGerenciarFornecedor().getJTextFieldTelefonePF().getText().equals("(  )     -    ")
				&& getPainelGerenciarFornecedor().getJTextFieldCelularPF().getText().equals("(  )      -    ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Telefone incorreto");
			getPainelGerenciarFornecedor().getJTextFieldTelefonePF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldTelefonePF().setBorder(new LineBorder(Color.RED));
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Celular incorreto");
			getPainelGerenciarFornecedor().getJTextFieldCelularPF().grabFocus();
			getPainelGerenciarFornecedor().getJTextFieldCelularPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarFornecedor().getJTextFieldTelefonePF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			getPainelGerenciarFornecedor().getJTextFieldCelularPF()
					.setBorder(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteAtivoInativoPF() {

		if (!getPainelGerenciarFornecedor().getJRadioButtonInativoPF().isSelected()
				&& !getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().isSelected()) {
			JOptionPane.showMessageDialog(getPainelGerenciarFornecedor(), "Selecione a situação do cliente");
			return false;
		} else
			return true;
	}

	public static PainelGerenciarFornecedor getPainelGerenciarFornecedor() {
		if (painelGerenciarFornecedor == null) {
			painelGerenciarFornecedor = new PainelGerenciarFornecedor();
		}
		return painelGerenciarFornecedor;
	}
}
