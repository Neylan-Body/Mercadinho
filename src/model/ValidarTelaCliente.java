package model;

import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import view.PainelGerenciarCliente;

public class ValidarTelaCliente {

	private static PainelGerenciarCliente painelGerenciarCliente;

	public ValidarTelaCliente(PainelGerenciarCliente painelGerenciarCliente) {
		ValidarTelaCliente.painelGerenciarCliente = painelGerenciarCliente;
	}

	public boolean TesteNomePF() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {

			if (getPainelGerenciarCliente().getJTextFieldNomePF().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Nome incorreto");
				getPainelGerenciarCliente().getJTextFieldNomePF().grabFocus();
				getPainelGerenciarCliente().getJTextFieldNomePF().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}
		if (getPainelGerenciarCliente().getJTextFieldNomePF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Nome incorreto");
			getPainelGerenciarCliente().getJTextFieldNomePF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldNomePF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldNomePF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteCPFPF() {

		if (getPainelGerenciarCliente().getJTextFieldCPFPF().getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "CPF incorreto");
			getPainelGerenciarCliente().getJTextFieldCPFPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCPFPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldCPFPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteOrgaoEmissorPF() {

		if (getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Órgão Emissor incorreto");
			getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteRGPF() {
		String RG = getPainelGerenciarCliente().getjTextFieldRGPF().getText();
		if (RG.matches("[0-9]+")) {
			getPainelGerenciarCliente().getjTextFieldRGPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		} else {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "RG incorreto");
			getPainelGerenciarCliente().getjTextFieldRGPF().grabFocus();
			getPainelGerenciarCliente().getjTextFieldRGPF().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteNacionalidadePF() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {

			if (getPainelGerenciarCliente().getJTextFieldNacionalidadePF().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Nacionalidade incorreta");
				getPainelGerenciarCliente().getJTextFieldNacionalidadePF().grabFocus();
				getPainelGerenciarCliente().getJTextFieldNacionalidadePF().setBorder(new LineBorder(Color.RED));
				return false;
			}
		}
		if (getPainelGerenciarCliente().getJTextFieldNacionalidadePF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Nacionalidade incorreta");
			getPainelGerenciarCliente().getJTextFieldNacionalidadePF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldNacionalidadePF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldNacionalidadePF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteNaturalidadePF() {
		String numeros = "0123457899";

		for (int i = 0; i < 10; i++) {

			if (getPainelGerenciarCliente().getJTextFieldNaturalidadePF().getText()
					.contains(Character.toString(numeros.charAt(i)))) {
				JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Naturalidade incorreta");
				return false;
			}
		}
		if (getPainelGerenciarCliente().getJTextFieldNaturalidadePF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Naturalidade incorreta");
			getPainelGerenciarCliente().getJTextFieldNaturalidadePF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldNaturalidadePF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldNaturalidadePF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteCEPPF() {
		if (getPainelGerenciarCliente().getJTextFieldCEPPF().getText().equals("  .   -   ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "CEP incorreto");
			getPainelGerenciarCliente().getJTextFieldCEPPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCEPPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldCEPPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteEstadoCivilPF() {
		if (getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Selecione o estado civil");
			getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().grabFocus();
			getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJComboBoxEstadoCivilPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteUFDocPF() {
		if (getPainelGerenciarCliente().getJComboBoxUFDocPF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Selecione UF");
			getPainelGerenciarCliente().getJComboBoxUFDocPF().grabFocus();
			getPainelGerenciarCliente().getJComboBoxUFDocPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJComboBoxUFDocPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteSexoPF() {
		if (getPainelGerenciarCliente().getJComboBoxSexoPF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Selecione o Sexo");
			getPainelGerenciarCliente().getJComboBoxSexoPF().grabFocus();
			getPainelGerenciarCliente().getJComboBoxSexoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJComboBoxSexoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteUFPF() {
		if (getPainelGerenciarCliente().getJComboBoxUFPF().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Selecione UF");
			getPainelGerenciarCliente().getJComboBoxUFPF().grabFocus();
			getPainelGerenciarCliente().getJComboBoxUFPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJComboBoxUFPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteLogradouroPF() {

		if (getPainelGerenciarCliente().getJTextFieldLogradouroPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Logradouro incorreto");
			getPainelGerenciarCliente().getJTextFieldLogradouroPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldLogradouroPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldLogradouroPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteNumeroPF() {
		if (getPainelGerenciarCliente().getJTextFieldNumeroPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Numero incorreto");
			getPainelGerenciarCliente().getJTextFieldNumeroPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldNumeroPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldNumeroPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteComplementoPF() {

		if (getPainelGerenciarCliente().getJTextFieldComplementoPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Complemento incorreto");
			getPainelGerenciarCliente().getJTextFieldComplementoPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldComplementoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldComplementoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteBairroPF() {

		if (getPainelGerenciarCliente().getJTextFieldBairroPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Bairro incorreto");
			getPainelGerenciarCliente().getJTextFieldBairroPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldBairroPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldBairroPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteMunicipioPF() {

		if (getPainelGerenciarCliente().getJTextFieldMunicipioPF().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Município incorreto");
			getPainelGerenciarCliente().getJTextFieldMunicipioPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldMunicipioPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldMunicipioPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteEmailPF() {
		if (getPainelGerenciarCliente().getJTextFieldEmailPF().getText().equals("")
				|| !FormataMascaras.validar(getPainelGerenciarCliente().getJTextFieldEmailPF().getText())) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Email incorreto");
			getPainelGerenciarCliente().getJTextFieldEmailPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldEmailPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldEmailPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteTelefoneCelularPF() {
		if (getPainelGerenciarCliente().getJTextFieldCelularPF().getText().equals("(  )      -    ") && getPainelGerenciarCliente().getJTextFieldTelefonePF().getText().equals("(  )     -    ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Celular incorreto");
			getPainelGerenciarCliente().getJTextFieldCelularPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCelularPF().setBorder(new LineBorder(Color.RED));
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Telefone incorreto");
			getPainelGerenciarCliente().getJTextFieldTelefonePF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldTelefonePF().setBorder(new LineBorder(Color.RED));
			return false;
		}
		else {
			getPainelGerenciarCliente().getJTextFieldCelularPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			getPainelGerenciarCliente().getJTextFieldTelefonePF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteCreditoPF() {
		try {
			double Credito = Double
					.parseDouble(getPainelGerenciarCliente().getJTextFieldCreditoPF().getText().replace(",", "."));
			getPainelGerenciarCliente().getJTextFieldCreditoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Crédito incorreto");
			getPainelGerenciarCliente().getJTextFieldCreditoPF().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCreditoPF().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteAtivoInativoPF() {
		if (!getPainelGerenciarCliente().getJRadioButtonInativoPF().isSelected()
				&& !getPainelGerenciarCliente().getJRadioButtonAtivoPF().isSelected()) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Selecione a situação do cliente");
			return false;
		} else
			return true;
	}

	/////////////////////////////////////////////////////////////// PJ
	/////////////////////////////////////////////////////////////// ////////////////////////////////

	public boolean TesteRazaoSocialPJ() {
		String numeros = "0123457899";

//		for (int i = 0; i < 10; i++) {
//
//			if (getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().getText()
//					.contains(Character.toString(numeros.charAt(i)))) {
//				JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Razão Social incorreto");
//				return false;
//			}
//		}
		if (getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Razão Social incorreto");
			getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCNPJPJ() {

		if (getPainelGerenciarCliente().getJTextFieldCNPJPJ().getText().equals("  .   .   /    -  ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "CNPJ incorreto");
			getPainelGerenciarCliente().getJTextFieldCNPJPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCNPJPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldCNPJPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteIEPJ() {
		String IE = getPainelGerenciarCliente().getjTextFieldIEPJ().getText();
		if (IE.matches("[0-9]+")) {
			getPainelGerenciarCliente().getjTextFieldIEPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		} else {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "IE incorreto");
			getPainelGerenciarCliente().getjTextFieldIEPJ().grabFocus();
			getPainelGerenciarCliente().getjTextFieldIEPJ().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteCEPPJ() {

		if (getPainelGerenciarCliente().getJTextFieldCEPPJ().getText().equals("  .   -   ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "CEP incorreto");
			getPainelGerenciarCliente().getJTextFieldCEPPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCEPPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldCEPPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteUFPJ() {
		if (getPainelGerenciarCliente().getJComboBoxUFPJ().getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Selecione UF ");
			getPainelGerenciarCliente().getJComboBoxUFPJ().grabFocus();
			getPainelGerenciarCliente().getJComboBoxUFPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJComboBoxUFPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteLogradouroPJ() {

		if (getPainelGerenciarCliente().getJTextFieldLogradouroPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Logradouro incorreto");
			getPainelGerenciarCliente().getJTextFieldLogradouroPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldLogradouroPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldLogradouroPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteNumeroPJ() {
		if (getPainelGerenciarCliente().getJTextFieldNumeroPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Numero incorreto");
			getPainelGerenciarCliente().getJTextFieldNumeroPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldNumeroPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldNumeroPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteComplementoPJ() {

		if (getPainelGerenciarCliente().getJTextFieldComplementoPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Complemento incorreto");
			getPainelGerenciarCliente().getJTextFieldComplementoPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldComplementoPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldComplementoPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteBairroPJ() {

		if (getPainelGerenciarCliente().getJTextFieldBairroPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Bairro incorreto");
			getPainelGerenciarCliente().getJTextFieldBairroPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldBairroPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldBairroPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteMunicipioPJ() {

		if (getPainelGerenciarCliente().getJTextFieldMunicipioPJ().getText().equals("")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Município incorreto");
			getPainelGerenciarCliente().getJTextFieldMunicipioPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldMunicipioPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldMunicipioPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteEmailPJ() {
		if (getPainelGerenciarCliente().getJTextFieldEmailPJ().getText().equals("")
				|| !FormataMascaras.validar(getPainelGerenciarCliente().getJTextFieldEmailPJ().getText())) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Email incorreto");
			getPainelGerenciarCliente().getJTextFieldEmailPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldEmailPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldEmailPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteTelefoneCelularPJ() {
		if (getPainelGerenciarCliente().getJTextFieldCelularPJ().getText().equals("(  )      -    ") && getPainelGerenciarCliente().getJTextFieldTelefonePJ().getText().equals("(  )     -    ")) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Celular incorreto");
			getPainelGerenciarCliente().getJTextFieldCelularPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCelularPJ().setBorder(new LineBorder(Color.RED));
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Telefone incorreto");
			getPainelGerenciarCliente().getJTextFieldTelefonePJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldTelefonePJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJTextFieldTelefonePJ()
			.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			getPainelGerenciarCliente().getJTextFieldCelularPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCreditoPJ() {
		try {

			double Credito = Double
					.parseDouble(getPainelGerenciarCliente().getJTextFieldCreditoPJ().getText().replace(",", "."));
			getPainelGerenciarCliente().getJTextFieldCreditoPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Crédito incorreto");
			getPainelGerenciarCliente().getJTextFieldCreditoPJ().grabFocus();
			getPainelGerenciarCliente().getJTextFieldCreditoPJ().setBorder(new LineBorder(Color.RED));
			return false;
		}
	}

	public boolean TesteAtivoInativoPJ() {

		if (!getPainelGerenciarCliente().getJRadioButtonInativoPJ().isSelected()
				&& !getPainelGerenciarCliente().getJRadioButtonAtivoPJ().isSelected()) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Selecione a situação do cliente");
			return false;
		} else
			return true;
	}

	public boolean TesteDataDeEmissaoPF() {
		Date date = new Date();
		if (getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Data de emissão incorreta");
			getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().grabFocus();
			getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeNascimentoPF() {
		Date date = new Date();
		if (getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Data de nascimento incorreta");
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().grabFocus();
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCadastradoEmPF() {
		Date date = new Date();
		if (getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Cadastrado em incorreto");
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().grabFocus();
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteCadastradoEmPJ() {
		Date date = new Date();
		if (getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Cadastrado em incorreto");
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().grabFocus();
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeNascimentoECadastradoEmPF() {
		if (getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().getDate()
				.before(getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().getDate())) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(),
					"'Cadastrado em' e 'Data de nascimento' incorretos, data de nascimento está depois da data do cadastro");
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().grabFocus();
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().grabFocus();
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().setBorder(new LineBorder(Color.RED));
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeNascimentoEDataDeEmissaoPF() {
		if (getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().getDate()
				.before(getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().getDate())) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(),
					"'Data de emissão' e 'Data de nascimento' incorretos, data de nascimento está depois da data de emissao");
			getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().grabFocus();
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().grabFocus();
			getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().setBorder(new LineBorder(Color.RED));
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteCadastradoEmEDataDeAberturaPJ() {
		if (getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().getDate()
				.before(getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().getDate())) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(),
					"'Data de abertura' e 'Cadastrado em' incorretos, data de nascimento está depois da data de emissao");
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().grabFocus();
			getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().grabFocus();
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().setBorder(new LineBorder(Color.RED));
			getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPF().getBorder());
			return true;
		}
	}

	public boolean TesteDataDeAberturaPJ() {
		Date date = new Date();
		if (getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().getDate().after(date)) {
			JOptionPane.showMessageDialog(getPainelGerenciarCliente(), "Cadastrado em incorreto");
			getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().grabFocus();
			getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().setBorder(new LineBorder(Color.RED));
			return false;
		} else {
			getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ()
					.setBorder(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getBorder());
			return true;
		}
	}

	public static PainelGerenciarCliente getPainelGerenciarCliente() {
		if (painelGerenciarCliente == null) {
			painelGerenciarCliente = new PainelGerenciarCliente();
		}
		return painelGerenciarCliente;
	}

}
