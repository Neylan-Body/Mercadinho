package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.ClientePessoaFisicaDAO;
import dao.ClientePessoaJuridicaDAO;
import model.ClientePessoaFisica;
import model.ClientePessoaJuridica;
import model.FormataMascaras;
import model.ValidarTelaCliente;
import model.ValidarTelaProduto;
import view.FrameGerenciarCliente;
import view.PainelGerenciarCliente;

public class ControladorTelaGerenciarCliente implements ActionListener, MouseListener, KeyListener {

	private static FrameGerenciarCliente frameGerenciarCliente;
	private static PainelGerenciarCliente painelGerenciarCliente;
	private static boolean alterarCliente = false;
	private static ClientePessoaFisicaDAO clientePessoaFisicaDAO;
	private static ClientePessoaJuridicaDAO clientePessoaJuridicaDAO;

	public ControladorTelaGerenciarCliente(FrameGerenciarCliente frameGerenciarCliente,
			PainelGerenciarCliente painelGerenciarCliente) {
		this.frameGerenciarCliente = frameGerenciarCliente;
		this.painelGerenciarCliente = painelGerenciarCliente;
		Eventos();
		Inicio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPainelGerenciarCliente().getJRadioButtonPessoaFisica()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarCliente().getJTextFieldPesquisaPF().setText("");
			getPainelGerenciarCliente().getJTextFieldPesquisaPJ().setText("");
			getPainelGerenciarCliente().getDefaultTableModelClientePF().setNumRows(0);
			getPainelGerenciarCliente().getDefaultTableModelClientePJ().setNumRows(0);
			getPainelGerenciarCliente().getJComboBoxPesquisaPF().setSelectedIndex(0);
			getPainelGerenciarCliente().getJComboBoxPesquisaPJ().setSelectedIndex(0);
			getPainelGerenciarCliente().repaint();
			getPainelGerenciarCliente().validate();
			PessoaFisica();
		}
		if (e.getSource() == getPainelGerenciarCliente().getJRadioButtonPessoaJuridica()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarCliente().getJTextFieldPesquisaPF().setText("");
			getPainelGerenciarCliente().getJTextFieldPesquisaPJ().setText("");
			getPainelGerenciarCliente().getDefaultTableModelClientePF().setNumRows(0);
			getPainelGerenciarCliente().getDefaultTableModelClientePJ().setNumRows(0);
			getPainelGerenciarCliente().getJComboBoxPesquisaPF().setSelectedIndex(0);
			getPainelGerenciarCliente().getJComboBoxPesquisaPJ().setSelectedIndex(0);
			getPainelGerenciarCliente().repaint();
			getPainelGerenciarCliente().validate();
			PessoaJuridica();
		}
		if (e.getSource() == getPainelGerenciarCliente().getJButtonIncluir()
				&& (getPainelGerenciarCliente().getJRadioButtonPessoaFisica().isSelected()
						|| getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().isSelected())) {
			if (getPainelGerenciarCliente().getJRadioButtonPessoaFisica().isSelected()) {
				PessoaFisica();
			}
			if (getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().isSelected()) {
				PessoaJuridica();
			}
			LimparCampos();
			OpcaoIncluir();
			alterarCliente = false;
		}
		if (e.getSource() == getPainelGerenciarCliente().getJButtonCancelar()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarCliente().getJTextFieldPesquisaPF().setText("");
			getPainelGerenciarCliente().getJTextFieldPesquisaPJ().setText("");
			getPainelGerenciarCliente().getDefaultTableModelClientePF().setNumRows(0);
			getPainelGerenciarCliente().getDefaultTableModelClientePJ().setNumRows(0);
			getPainelGerenciarCliente().getJComboBoxPesquisaPF().setSelectedIndex(0);
			getPainelGerenciarCliente().getJComboBoxPesquisaPJ().setSelectedIndex(0);
			getPainelGerenciarCliente().repaint();
			getPainelGerenciarCliente().validate();
		}
		if (e.getSource() == getPainelGerenciarCliente().getJButtonPesquisaPF()) {
			if (getPainelGerenciarCliente().getJComboBoxPesquisaPF().getSelectedIndex() > 0) {
				PesquisaPF();
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Selecione uma forma de pesquisa");
			}
		}
		if (e.getSource() == getPainelGerenciarCliente().getJButtonPesquisaPJ()) {
			if (getPainelGerenciarCliente().getJComboBoxPesquisaPJ().getSelectedIndex() > 0) {
				PesquisaPJ();
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Selecione uma forma de pesquisa");
			}
		}
		if (e.getSource() == getPainelGerenciarCliente().getJButtonAlterar()) {
			if (getPainelGerenciarCliente().getJRadioButtonPessoaFisica().isSelected()) {
				if (getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() > -1) {
					LinhaSelecionadaPF();
					OpcaoAlterarPF();
					alterarCliente = true;
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Selecione uma linha da tabela",
							"Alterar", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().isSelected()) {
				if (getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() > -1) {
					LinhaSelecionadaPJ();
					OpcaoAlterarPJ();
					alterarCliente = true;
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Selecione uma linha da tabela",
							"Alterar", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (e.getSource() == getPainelGerenciarCliente().getJButtonConfirmar()) {

			ValidarTelaCliente validarTelaCliente = new ValidarTelaCliente(getPainelGerenciarCliente());
			if (getPainelGerenciarCliente().getJRadioButtonPessoaFisica().isSelected()) {
				if (validarTelaCliente.TesteNomePF() && validarTelaCliente.TesteCPFPF()
						&& validarTelaCliente.TesteRGPF() && validarTelaCliente.TesteOrgaoEmissorPF()
						&& validarTelaCliente.TesteDataDeEmissaoPF() && validarTelaCliente.TesteEstadoCivilPF()
						&& validarTelaCliente.TesteDataDeNascimentoPF()
						&& validarTelaCliente.TesteDataDeNascimentoEDataDeEmissaoPF()
						&& validarTelaCliente.TesteNacionalidadePF() && validarTelaCliente.TesteUFDocPF()
						&& validarTelaCliente.TesteNaturalidadePF() && validarTelaCliente.TesteSexoPF()
						&& validarTelaCliente.TesteCadastradoEmPF()
						&& validarTelaCliente.TesteDataDeNascimentoECadastradoEmPF() && validarTelaCliente.TesteCEPPF()
						&& validarTelaCliente.TesteLogradouroPF() && validarTelaCliente.TesteNumeroPF()
						&& validarTelaCliente.TesteComplementoPF() && validarTelaCliente.TesteBairroPF()
						&& validarTelaCliente.TesteMunicipioPF() && validarTelaCliente.TesteUFPF()
						&& validarTelaCliente.TesteEmailPF() && validarTelaCliente.TesteTelefoneCelularPF()
						&& validarTelaCliente.TesteCreditoPF()
						&& validarTelaCliente.TesteDataDeNascimentoECadastradoEmPF()
						&& validarTelaCliente.TesteDataDeNascimentoEDataDeEmissaoPF()
						&& validarTelaCliente.TesteAtivoInativoPF()) {
					ConfirmarPessoaFisica();
				}
			}
			if (getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().isSelected()) {
				if (validarTelaCliente.TesteRazaoSocialPJ() && validarTelaCliente.TesteCNPJPJ()
						&& validarTelaCliente.TesteIEPJ() && validarTelaCliente.TesteDataDeAberturaPJ()
						&& validarTelaCliente.TesteCadastradoEmPJ()
						&& validarTelaCliente.TesteCadastradoEmEDataDeAberturaPJ()
						&& validarTelaCliente.TesteLogradouroPJ() && validarTelaCliente.TesteCEPPJ()
						&& validarTelaCliente.TesteComplementoPJ() && validarTelaCliente.TesteBairroPJ()
						&& validarTelaCliente.TesteNumeroPJ() && validarTelaCliente.TesteMunicipioPJ()
						&& validarTelaCliente.TesteUFPJ() && validarTelaCliente.TesteEmailPJ()
						&& validarTelaCliente.TesteTelefoneCelularPJ() && validarTelaCliente.TesteCreditoPJ()
						&& validarTelaCliente.TesteAtivoInativoPJ()) {
					ConfirmarPessoaJuridica();
				}
			}
		}
		if (e.getSource() == getPainelGerenciarCliente().getJButtonExcluir()) {
			if (getPainelGerenciarCliente().getJRadioButtonPessoaFisica().isSelected()) {
				if (getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() > -1) {
					int opc = JOptionPane.showConfirmDialog(getFrameGerenciarCliente(), "Deseja excluir esse cliente?",
							"Confirmar exclusão", JOptionPane.INFORMATION_MESSAGE);
					if (opc == 0) {
						ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
						clientePessoaFisica.setCodigo((int) getPainelGerenciarCliente().getJTableClientePF()
								.getValueAt(getPainelGerenciarCliente().getJTableClientePF().getSelectedRow(), 0));
						getClientePessoaFisicaDAO().delete(clientePessoaFisica);
						getPainelGerenciarCliente().getDefaultTableModelClientePF().setNumRows(0);
						getPainelGerenciarCliente().getJComboBoxPesquisaPF().setSelectedIndex(0);
						LimparCampos();
						Inicio();

					}
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Selecione uma linha da tabela",
							"Exclusão", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().isSelected()) {
				if (getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() > -1) {
					int opc = JOptionPane.showConfirmDialog(getFrameGerenciarCliente(), "Deseja excluir esse cliente?",
							"Confirmar exclusão", JOptionPane.INFORMATION_MESSAGE);
					if (opc == 0) {
						ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
						clientePessoaJuridica.setCodigo((int) getPainelGerenciarCliente().getJTableClientePJ()
								.getValueAt(getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow(), 0));
						getClientePessoaJuridicaDAO().delete(clientePessoaJuridica);
						getPainelGerenciarCliente().getDefaultTableModelClientePJ().setNumRows(0);
						getPainelGerenciarCliente().getJComboBoxPesquisaPJ().setSelectedIndex(0);
						LimparCampos();
						Inicio();

					}
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Selecione uma linha da tabela",
							"Exclusão", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	private void ConfirmarPessoaFisica() {
		ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
		clientePessoaFisica.setBairro(getPainelGerenciarCliente().getJTextFieldBairroPF().getText());
		java.util.Date cadastradoEm = getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().getDate();
		clientePessoaFisica.setCadastradoEm(new Date(cadastradoEm.getTime()));
		clientePessoaFisica.setCelular(getPainelGerenciarCliente().getJTextFieldCelularPF().getText());
		clientePessoaFisica.setCep(getPainelGerenciarCliente().getJTextFieldCEPPF().getText());
		clientePessoaFisica.setComplemento(getPainelGerenciarCliente().getJTextFieldComplementoPF().getText());
		clientePessoaFisica.setCpf(getPainelGerenciarCliente().getJTextFieldCPFPF().getText());
		clientePessoaFisica.setCredito(
				Double.parseDouble(getPainelGerenciarCliente().getJTextFieldCreditoPF().getText().replace(",", ".")));
		java.util.Date dataEmissao = getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().getDate();
		clientePessoaFisica.setDtEmissao(new Date(dataEmissao.getTime()));
		java.util.Date dataNascimento = getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().getDate();
		clientePessoaFisica.setDtNascimento(new Date(dataNascimento.getTime()));
		clientePessoaFisica.setEmail(getPainelGerenciarCliente().getJTextFieldEmailPF().getText());
		clientePessoaFisica
				.setEstadoCivil(getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().getSelectedItem().toString());
		clientePessoaFisica.setLogradouro(getPainelGerenciarCliente().getJTextFieldLogradouroPF().getText());
		clientePessoaFisica.setMunicipio(getPainelGerenciarCliente().getJTextFieldMunicipioPF().getText());
		clientePessoaFisica.setNacionalidade(getPainelGerenciarCliente().getJTextFieldNacionalidadePF().getText());
		clientePessoaFisica.setNaturalidade(getPainelGerenciarCliente().getJTextFieldNaturalidadePF().getText());
		clientePessoaFisica.setNome(getPainelGerenciarCliente().getJTextFieldNomePF().getText());
		clientePessoaFisica.setNumero(getPainelGerenciarCliente().getJTextFieldNumeroPF().getText());
		clientePessoaFisica.setOrgaoEmissor(getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().getText());
		clientePessoaFisica.setRg(getPainelGerenciarCliente().getjTextFieldRGPF().getText());
		clientePessoaFisica.setSexo(getPainelGerenciarCliente().getJComboBoxSexoPF().getSelectedItem().toString());
		if (getPainelGerenciarCliente().getJRadioButtonAtivoPF().isSelected()) {
			clientePessoaFisica.setSituacao(getPainelGerenciarCliente().getJRadioButtonAtivoPF().getText());
		} else {
			clientePessoaFisica.setSituacao(getPainelGerenciarCliente().getJRadioButtonInativoPF().getText());
		}
		clientePessoaFisica.setTelefone(getPainelGerenciarCliente().getJTextFieldTelefonePF().getText());
		clientePessoaFisica.setUf(getPainelGerenciarCliente().getJComboBoxUFPF().getSelectedItem().toString());
		clientePessoaFisica.setUfDoc(getPainelGerenciarCliente().getJComboBoxUFDocPF().getSelectedItem().toString());
		if (alterarCliente == false) {
			if (getClientePessoaFisicaDAO().create(clientePessoaFisica)) {
				getPainelGerenciarCliente().getJTextFieldPesquisaPF().setText("");
				getPainelGerenciarCliente().getDefaultTableModelClientePF().setNumRows(0);
				getPainelGerenciarCliente().getJComboBoxPesquisaPF().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}
		if (alterarCliente == true) {
			clientePessoaFisica
					.setCodigo(Integer.parseInt(getPainelGerenciarCliente().getJTextFieldCodigoPF().getText()));
			if (getClientePessoaFisicaDAO().update(clientePessoaFisica)) {
				getPainelGerenciarCliente().getJTextFieldPesquisaPF().setText("");
				getPainelGerenciarCliente().getDefaultTableModelClientePF().setNumRows(0);
				getPainelGerenciarCliente().getJComboBoxPesquisaPF().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}
	}

	private void ConfirmarPessoaJuridica() {
		ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
		clientePessoaJuridica.setBairro(getPainelGerenciarCliente().getJTextFieldBairroPJ().getText());
		java.util.Date cadastradoEm = getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().getDate();
		clientePessoaJuridica.setCadastradoEm(new Date(cadastradoEm.getTime()));
		clientePessoaJuridica.setCelular(getPainelGerenciarCliente().getJTextFieldCelularPJ().getText());
		clientePessoaJuridica.setCep(getPainelGerenciarCliente().getJTextFieldCEPPJ().getText());
		clientePessoaJuridica.setComplemento(getPainelGerenciarCliente().getJTextFieldComplementoPJ().getText());
		clientePessoaJuridica.setCnpj(getPainelGerenciarCliente().getJTextFieldCNPJPJ().getText());
		clientePessoaJuridica.setCredito(
				Double.parseDouble(getPainelGerenciarCliente().getJTextFieldCreditoPJ().getText().replace(",", ".")));
		clientePessoaJuridica.setEmail(getPainelGerenciarCliente().getJTextFieldEmailPJ().getText());
		clientePessoaJuridica.setLogradouro(getPainelGerenciarCliente().getJTextFieldLogradouroPJ().getText());
		clientePessoaJuridica.setMunicipio(getPainelGerenciarCliente().getJTextFieldMunicipioPJ().getText());
		clientePessoaJuridica.setRazaoSocial(getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().getText());
		clientePessoaJuridica.setNumero(getPainelGerenciarCliente().getJTextFieldNumeroPJ().getText());
		clientePessoaJuridica.setIe(getPainelGerenciarCliente().getjTextFieldIEPJ().getText());
		java.util.Date dataAbertura = getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().getDate();
		clientePessoaJuridica.setAbertura(new Date(dataAbertura.getTime()));
		if (getPainelGerenciarCliente().getJRadioButtonAtivoPJ().isSelected()) {
			clientePessoaJuridica.setSituacao(getPainelGerenciarCliente().getJRadioButtonAtivoPJ().getText());
		} else {
			clientePessoaJuridica.setSituacao(getPainelGerenciarCliente().getJRadioButtonInativoPJ().getText());
		}
		clientePessoaJuridica.setTelefone(getPainelGerenciarCliente().getJTextFieldTelefonePJ().getText());
		clientePessoaJuridica.setUf(getPainelGerenciarCliente().getJComboBoxUFPJ().getSelectedItem().toString());
		if (alterarCliente == false) {
			if (getClientePessoaJuridicaDAO().create(clientePessoaJuridica)) {
				getPainelGerenciarCliente().getJTextFieldPesquisaPJ().setText("");
				getPainelGerenciarCliente().getDefaultTableModelClientePJ().setNumRows(0);
				getPainelGerenciarCliente().getJComboBoxPesquisaPJ().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}
		if (alterarCliente == true) {
			clientePessoaJuridica
					.setCodigo(Integer.parseInt(getPainelGerenciarCliente().getJTextFieldCodigoPJ().getText()));
			if (getClientePessoaJuridicaDAO().update(clientePessoaJuridica)) {
				getPainelGerenciarCliente().getJTextFieldPesquisaPJ().setText("");
				getPainelGerenciarCliente().getDefaultTableModelClientePJ().setNumRows(0);
				getPainelGerenciarCliente().getJComboBoxPesquisaPJ().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}

	}

	private void OpcaoAlterarPF() {
		getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxUFDocPF().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCEPPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNomePF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCPFPF().setEnabled(true);
		getPainelGerenciarCliente().getjTextFieldRGPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldLogradouroPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldComplementoPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldBairroPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldMunicipioPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNumeroPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNacionalidadePF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNaturalidadePF().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxUFPF().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxSexoPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldEmailPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldTelefonePF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCelularPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCreditoPF().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonAtivoPF().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonInativoPF().setEnabled(true);
		getPainelGerenciarCliente().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarCliente().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarCliente().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarCliente().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarCliente().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonPessoaFisica().setEnabled(false);
		getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldNomePF().grabFocus();
	}

	private void OpcaoAlterarPJ() {
		getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCNPJPJ().setEnabled(true);
		getPainelGerenciarCliente().getjTextFieldIEPJ().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCEPPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldLogradouroPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNumeroPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldComplementoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldBairroPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldMunicipioPJ().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxUFPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldEmailPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldTelefonePJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCelularPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCreditoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonInativoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarCliente().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarCliente().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarCliente().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarCliente().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().grabFocus();
	}

	private void PesquisaPJ() {
		// TODO Auto-generated method stub
		getPainelGerenciarCliente().getDefaultTableModelClientePJ().setNumRows(0);
		int cont = 0;
		if (getPainelGerenciarCliente().getJComboBoxPesquisaPJ().getSelectedIndex() == 1) {
			String razaoSocial = getPainelGerenciarCliente().getJTextFieldPesquisaPJ().getText().toString();
			for (int i = 0; i < getClientePessoaJuridicaDAO().ClientePessoaJuridicasPorRazaoSocial(razaoSocial)
					.size(); i++) {
				getPainelGerenciarCliente().getDefaultTableModelClientePJ()
						.addRow(new Object[] {
								getClientePessoaJuridicaDAO().ClientePessoaJuridicasPorRazaoSocial(razaoSocial).get(i)
										.getCodigo(),
								getClientePessoaJuridicaDAO().ClientePessoaJuridicasPorRazaoSocial(razaoSocial).get(i)
										.getRazaoSocial(),
								getClientePessoaJuridicaDAO().ClientePessoaJuridicasPorRazaoSocial(razaoSocial).get(i)
										.getCnpj(),
								getClientePessoaJuridicaDAO().ClientePessoaJuridicasPorRazaoSocial(razaoSocial).get(i)
										.getEmail() });
				cont++;
			}
		}
		if (getPainelGerenciarCliente().getJComboBoxPesquisaPJ().getSelectedIndex() == 2) {
			try {
				int codigo = Integer
						.parseInt(getPainelGerenciarCliente().getJTextFieldPesquisaPJ().getText().toString());
				if (!getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getRazaoSocial().equals("")) {
					getPainelGerenciarCliente().getDefaultTableModelClientePJ()
							.addRow(new Object[] {
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCodigo(),
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo)
											.getRazaoSocial(),
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCnpj(),
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (getPainelGerenciarCliente().getJComboBoxPesquisaPJ().getSelectedIndex() == 3) {
			try {
				String CNPJ = getPainelGerenciarCliente().getJTextFieldPesquisaPJ().getText().toString();
				CNPJ.replace(".", "");
				CNPJ.replace("/", "");
				CNPJ.replace("-", "");
				String mascara = CNPJ.substring(0, 2);
				mascara = mascara + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "/"
						+ CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14);
				CNPJ = mascara;
				System.out.println(CNPJ);
				if (!getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCNPJ(CNPJ).getRazaoSocial().equals("")) {
					getPainelGerenciarCliente().getDefaultTableModelClientePJ()
							.addRow(new Object[] {
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCNPJ(CNPJ).getCodigo(),
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCNPJ(CNPJ).getRazaoSocial(),
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCNPJ(CNPJ).getCnpj(),
									getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCNPJ(CNPJ).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Cliente inexistente", "Pesquisa",
					JOptionPane.ERROR_MESSAGE);
		}
		cont = 0;
	}

	private void PesquisaPF() {
		// TODO Auto-generated method stub
		getPainelGerenciarCliente().getDefaultTableModelClientePF().setNumRows(0);
		int cont = 0;
		if (getPainelGerenciarCliente().getJComboBoxPesquisaPF().getSelectedIndex() == 1) {
			String nome = getPainelGerenciarCliente().getJTextFieldPesquisaPF().getText().toString();
			for (int i = 0; i < getClientePessoaFisicaDAO().ClientePessoaFisicasPorNome(nome).size(); i++) {
				getPainelGerenciarCliente().getDefaultTableModelClientePF()
						.addRow(new Object[] {
								getClientePessoaFisicaDAO().ClientePessoaFisicasPorNome(nome).get(i).getCodigo(),
								getClientePessoaFisicaDAO().ClientePessoaFisicasPorNome(nome).get(i).getNome(),
								getClientePessoaFisicaDAO().ClientePessoaFisicasPorNome(nome).get(i).getCpf(),
								getClientePessoaFisicaDAO().ClientePessoaFisicasPorNome(nome).get(i).getEmail() });
				cont++;
			}
		}
		if (getPainelGerenciarCliente().getJComboBoxPesquisaPF().getSelectedIndex() == 2) {
			try {
				int codigo = Integer
						.parseInt(getPainelGerenciarCliente().getJTextFieldPesquisaPF().getText().toString());
				if (!getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNome().equals("")) {
					getPainelGerenciarCliente().getDefaultTableModelClientePF()
							.addRow(new Object[] {
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCodigo(),
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNome(),
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCpf(),
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (getPainelGerenciarCliente().getJComboBoxPesquisaPF().getSelectedIndex() == 3) {
			try {
				String CPF = getPainelGerenciarCliente().getJTextFieldPesquisaPF().getText().toString();
				CPF.replace(".", "");
				CPF.replace("-", "");
				String mascara = CPF.substring(0, 3);
				mascara = mascara + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
				CPF = mascara;
				if (!getClientePessoaFisicaDAO().ClientePessoaFisicaPorCPF(CPF).getNome().equals("")) {
					getPainelGerenciarCliente().getDefaultTableModelClientePF()
							.addRow(new Object[] {
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCPF(CPF).getCodigo(),
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCPF(CPF).getNome(),
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCPF(CPF).getCpf(),
									getClientePessoaFisicaDAO().ClientePessoaFisicaPorCPF(CPF).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(getFrameGerenciarCliente(), "Cliente inexistente", "Pesquisa",
					JOptionPane.ERROR_MESSAGE);
		}
		cont = 0;
	}

	private void LinhaSelecionadaPF() {
		int codigo = (int) getPainelGerenciarCliente().getJTableClientePF()
				.getValueAt(getPainelGerenciarCliente().getJTableClientePF().getSelectedRow(), 0);
		getPainelGerenciarCliente().getJTextFieldCodigoPF().setText(Integer.toString(codigo));
		getPainelGerenciarCliente().getJTextFieldNomePF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNome());
		getPainelGerenciarCliente().getJTextFieldCPFPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCpf());
		getPainelGerenciarCliente().getjTextFieldRGPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getRg());
		getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getOrgaoEmissor());
		getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF()
				.setDate(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getDtEmissao());
		getPainelGerenciarCliente().getJComboBoxEstadoCivilPF()
				.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getEstadoCivil());
		getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF()
				.setDate(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getDtNascimento());
		getPainelGerenciarCliente().getJTextFieldNacionalidadePF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNacionalidade());
		getPainelGerenciarCliente().getJComboBoxUFDocPF()
				.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getUfDoc());
		getPainelGerenciarCliente().getJTextFieldNaturalidadePF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNaturalidade());
		getPainelGerenciarCliente().getJComboBoxSexoPF()
				.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getSexo());
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPF()
				.setDate(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCadastradoEm());
		getPainelGerenciarCliente().getJTextFieldCEPPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCep());
		getPainelGerenciarCliente().getJTextFieldLogradouroPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getLogradouro());
		getPainelGerenciarCliente().getJTextFieldNumeroPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNumero());
		getPainelGerenciarCliente().getJTextFieldComplementoPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getComplemento());
		getPainelGerenciarCliente().getJTextFieldBairroPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getBairro());
		getPainelGerenciarCliente().getJTextFieldMunicipioPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getMunicipio());
		getPainelGerenciarCliente().getJComboBoxUFPF()
				.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getUf());
		getPainelGerenciarCliente().getJTextFieldEmailPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getEmail());
		getPainelGerenciarCliente().getJTextFieldTelefonePF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getTelefone());
		getPainelGerenciarCliente().getJTextFieldCelularPF()
				.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCelular());
		getPainelGerenciarCliente().getJTextFieldCreditoPF()
				.setText(Double.toString(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCredito())
						.replace(".", ","));
		if (getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getSituacao().equals("Ativo")) {
			getPainelGerenciarCliente().getJRadioButtonAtivoPF().setSelected(true);
			getPainelGerenciarCliente().getJRadioButtonInativoPF().setSelected(false);
		}
		if (getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getSituacao().equals("Inativo")) {
			getPainelGerenciarCliente().getJRadioButtonAtivoPF().setSelected(false);
			getPainelGerenciarCliente().getJRadioButtonInativoPF().setSelected(true);
		}
	}

	private void LinhaSelecionadaPF(String sinal) {
		try {
			alterarCliente = true;
			int codigo = -1;
			if (sinal.equals("+")) {
				codigo = (int) getPainelGerenciarCliente().getJTableClientePF()
						.getValueAt(getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() + 1, 0);
			}
			if (sinal.equals("-")) {
				codigo = (int) getPainelGerenciarCliente().getJTableClientePF()
						.getValueAt(getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() - 1, 0);
			}
			getPainelGerenciarCliente().getJTextFieldCodigoPF().setText(Integer.toString(codigo));
			getPainelGerenciarCliente().getJTextFieldNomePF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNome());
			getPainelGerenciarCliente().getJTextFieldCPFPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCpf());
			getPainelGerenciarCliente().getjTextFieldRGPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getRg());
			getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getOrgaoEmissor());
			getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF()
					.setDate(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getDtEmissao());
			getPainelGerenciarCliente().getJComboBoxEstadoCivilPF()
					.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getEstadoCivil());
			getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF()
					.setDate(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getDtNascimento());
			getPainelGerenciarCliente().getJTextFieldNacionalidadePF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNacionalidade());
			getPainelGerenciarCliente().getJComboBoxUFDocPF()
					.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getUfDoc());
			getPainelGerenciarCliente().getJTextFieldNaturalidadePF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNaturalidade());
			getPainelGerenciarCliente().getJComboBoxSexoPF()
					.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getSexo());
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPF()
					.setDate(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCadastradoEm());
			getPainelGerenciarCliente().getJTextFieldCEPPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCep());
			getPainelGerenciarCliente().getJTextFieldLogradouroPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getLogradouro());
			getPainelGerenciarCliente().getJTextFieldNumeroPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getNumero());
			getPainelGerenciarCliente().getJTextFieldComplementoPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getComplemento());
			getPainelGerenciarCliente().getJTextFieldBairroPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getBairro());
			getPainelGerenciarCliente().getJTextFieldMunicipioPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getMunicipio());
			getPainelGerenciarCliente().getJComboBoxUFPF()
					.setSelectedItem(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getUf());
			getPainelGerenciarCliente().getJTextFieldEmailPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getEmail());
			getPainelGerenciarCliente().getJTextFieldTelefonePF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getTelefone());
			getPainelGerenciarCliente().getJTextFieldCelularPF()
					.setText(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCelular());
			getPainelGerenciarCliente().getJTextFieldCreditoPF()
					.setText(Double
							.toString(getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getCredito())
							.replace(".", ","));
			if (getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getSituacao().equals("Ativo")) {
				getPainelGerenciarCliente().getJRadioButtonAtivoPF().setSelected(true);
				getPainelGerenciarCliente().getJRadioButtonInativoPF().setSelected(false);
			}
			if (getClientePessoaFisicaDAO().ClientePessoaFisicaPorCodigo(codigo).getSituacao().equals("Inativo")) {
				getPainelGerenciarCliente().getJRadioButtonAtivoPF().setSelected(false);
				getPainelGerenciarCliente().getJRadioButtonInativoPF().setSelected(true);
			}
		} catch (Exception e) {

		}
	}

	private void LinhaSelecionadaPJ() {
		int codigo = (int) getPainelGerenciarCliente().getJTableClientePJ()
				.getValueAt(getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow(), 0);
		getPainelGerenciarCliente().getJTextFieldCodigoPJ().setText(Integer.toString(codigo));
		getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getRazaoSocial());
		getPainelGerenciarCliente().getJTextFieldCNPJPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCnpj());
		getPainelGerenciarCliente().getjTextFieldIEPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getIe());
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ()
				.setDate(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCadastradoEm());
		getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ()
				.setDate(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getAbertura());
		getPainelGerenciarCliente().getJTextFieldCEPPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCep());
		getPainelGerenciarCliente().getJTextFieldLogradouroPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getLogradouro());
		getPainelGerenciarCliente().getJTextFieldNumeroPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getNumero());
		getPainelGerenciarCliente().getJTextFieldComplementoPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getComplemento());
		getPainelGerenciarCliente().getJTextFieldBairroPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getBairro());
		getPainelGerenciarCliente().getJTextFieldMunicipioPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getMunicipio());
		getPainelGerenciarCliente().getJComboBoxUFPJ()
				.setSelectedItem(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getUf());
		getPainelGerenciarCliente().getJTextFieldEmailPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getEmail());
		getPainelGerenciarCliente().getJTextFieldTelefonePJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getTelefone());
		getPainelGerenciarCliente().getJTextFieldCelularPJ()
				.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCelular());
		getPainelGerenciarCliente().getJTextFieldCreditoPJ()
				.setText(Double
						.toString(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCredito())
						.replace(".", ","));
		if (getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getSituacao().equals("Ativo")) {
			getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setSelected(true);
			getPainelGerenciarCliente().getJRadioButtonInativoPJ().setSelected(false);
		}
		if (getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getSituacao().equals("Inativo")) {
			getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setSelected(false);
			getPainelGerenciarCliente().getJRadioButtonInativoPJ().setSelected(true);
		}
	}

	private void LinhaSelecionadaPJ(String sinal) {
		try {
			alterarCliente = true;
			int codigo = -1;
			if (sinal.equals("+")) {
				codigo = (int) getPainelGerenciarCliente().getJTableClientePJ()
						.getValueAt(getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() + 1, 0);
			}
			if (sinal.equals("-")) {
				codigo = (int) getPainelGerenciarCliente().getJTableClientePJ()
						.getValueAt(getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() - 1, 0);
			}
			getPainelGerenciarCliente().getJTextFieldCodigoPJ().setText(Integer.toString(codigo));
			getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getRazaoSocial());
			getPainelGerenciarCliente().getJTextFieldCNPJPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCnpj());
			getPainelGerenciarCliente().getjTextFieldIEPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getIe());
			getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ()
					.setDate(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCadastradoEm());
			getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ()
					.setDate(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getAbertura());
			getPainelGerenciarCliente().getJTextFieldCEPPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCep());
			getPainelGerenciarCliente().getJTextFieldLogradouroPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getLogradouro());
			getPainelGerenciarCliente().getJTextFieldNumeroPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getNumero());
			getPainelGerenciarCliente().getJTextFieldComplementoPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getComplemento());
			getPainelGerenciarCliente().getJTextFieldBairroPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getBairro());
			getPainelGerenciarCliente().getJTextFieldMunicipioPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getMunicipio());
			getPainelGerenciarCliente().getJComboBoxUFPJ()
					.setSelectedItem(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getUf());
			getPainelGerenciarCliente().getJTextFieldEmailPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getEmail());
			getPainelGerenciarCliente().getJTextFieldTelefonePJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getTelefone());
			getPainelGerenciarCliente().getJTextFieldCelularPJ()
					.setText(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCelular());
			getPainelGerenciarCliente().getJTextFieldCreditoPJ()
					.setText(Double
							.toString(getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getCredito())
							.replace(".", ","));
			if (getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getSituacao().equals("Ativo")) {
				getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setSelected(true);
				getPainelGerenciarCliente().getJRadioButtonInativoPJ().setSelected(false);
			}
			if (getClientePessoaJuridicaDAO().ClientePessoaJuridicaPorCodigo(codigo).getSituacao().equals("Inativo")) {
				getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setSelected(false);
				getPainelGerenciarCliente().getJRadioButtonInativoPJ().setSelected(true);
			}
		} catch (Exception e) {

		}
	}

	public void Eventos() {
		getPainelGerenciarCliente().getJButtonPesquisaPF().addActionListener(this);
		getPainelGerenciarCliente().getJComboBoxPesquisaPF().addActionListener(this);
		getPainelGerenciarCliente().getJComboBoxPesquisaPJ().addActionListener(this);
		getPainelGerenciarCliente().getJButtonPesquisaPJ().addActionListener(this);
		getPainelGerenciarCliente().getJButtonIncluir().addActionListener(this);
		getPainelGerenciarCliente().getJButtonExcluir().addActionListener(this);
		getPainelGerenciarCliente().getJButtonAlterar().addActionListener(this);
		getPainelGerenciarCliente().getJButtonConfirmar().addActionListener(this);
		getPainelGerenciarCliente().getJButtonCancelar().addActionListener(this);
		getPainelGerenciarCliente().getJRadioButtonPessoaFisica().addActionListener(this);
		getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().addActionListener(this);
		getPainelGerenciarCliente().getJTableClientePF().addMouseListener(this);
		getPainelGerenciarCliente().getJTableClientePJ().addMouseListener(this);
		getPainelGerenciarCliente().getJTableClientePF().addKeyListener(this);
		getPainelGerenciarCliente().getJTableClientePJ().addKeyListener(this);
	}

	private void OpcaoTabela() {
		getPainelGerenciarCliente().getJButtonAlterar().setEnabled(true);
		getPainelGerenciarCliente().getJButtonExcluir().setEnabled(true);
		getPainelGerenciarCliente().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarCliente().getJButtonCancelar().setEnabled(true);
	}

	private void PessoaFisica() {
		getPainelGerenciarCliente().getPainelPF().setVisible(true);
		getPainelGerenciarCliente().getPainelPJ().setVisible(false);
		getFrameGerenciarCliente().repaint();
		getFrameGerenciarCliente().validate();
	}

	private void PessoaJuridica() {
		getPainelGerenciarCliente().getPainelPJ().setVisible(true);
		getPainelGerenciarCliente().getPainelPF().setVisible(false);
		getFrameGerenciarCliente().repaint();
		getFrameGerenciarCliente().validate();
	}

	public void Inicio() {
		getPainelGerenciarCliente().getPainelPJ().setVisible(false);
		getPainelGerenciarCliente().getPainelPF().setVisible(false);
		getPainelGerenciarCliente().getJTextFieldCodigoPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldNomePF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCPFPF().setEnabled(false);
		getPainelGerenciarCliente().getjTextFieldRGPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().setEnabled(false);
		getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().getSpinner().setEnabled(false);
		getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().setEnabled(false);
		getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().getSpinner().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldNacionalidadePF().setEnabled(false);
		getPainelGerenciarCliente().getJComboBoxUFPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldNaturalidadePF().setEnabled(false);
		getPainelGerenciarCliente().getJComboBoxSexoPF().setEnabled(false);
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().getSpinner().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCEPPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldLogradouroPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldNumeroPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldComplementoPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldBairroPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldMunicipioPF().setEnabled(false);
		getPainelGerenciarCliente().getJComboBoxUFDocPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldEmailPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldTelefonePF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCelularPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCreditoPF().setEnabled(false);
		getPainelGerenciarCliente().getJRadioButtonInativoPF().setEnabled(false);
		getPainelGerenciarCliente().getJRadioButtonAtivoPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCodigoPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCNPJPJ().setEnabled(false);
		getPainelGerenciarCliente().getjTextFieldIEPJ().setEnabled(false);
		getPainelGerenciarCliente().getJComboBoxUFPJ().setEnabled(false);
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().getSpinner().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCEPPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldLogradouroPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldNumeroPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldComplementoPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldBairroPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldMunicipioPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldEmailPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldTelefonePJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCelularPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCreditoPJ().setEnabled(false);
		getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().getSpinner().setEnabled(false);
		getPainelGerenciarCliente().getJRadioButtonInativoPJ().setEnabled(false);
		getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setEnabled(false);
		getPainelGerenciarCliente().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarCliente().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarCliente().getJButtonConfirmar().setEnabled(false);
		getPainelGerenciarCliente().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarCliente().getJButtonCancelar().setEnabled(false);
		getPainelGerenciarCliente().getJRadioButtonPessoaFisica().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().setEnabled(true);
	}

	public void OpcaoIncluir() {
		getPainelGerenciarCliente().getJRadioButtonPessoaFisica().setEnabled(false);
		getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldCodigoPF().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldNomePF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCPFPF().setEnabled(true);
		getPainelGerenciarCliente().getjTextFieldRGPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserDataDeEmissaoPF().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserDataDeNascimentoPF().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNacionalidadePF().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxUFPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNaturalidadePF().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxSexoPF().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPF().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCEPPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldLogradouroPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNumeroPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldComplementoPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldBairroPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldMunicipioPF().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxUFDocPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldEmailPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldTelefonePF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCelularPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCreditoPF().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonInativoPF().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonAtivoPF().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCodigoPJ().setEnabled(false);
		getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCNPJPJ().setEnabled(true);
		getPainelGerenciarCliente().getjTextFieldIEPJ().setEnabled(true);
		getPainelGerenciarCliente().getJComboBoxUFPJ().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserCadastradoEmPJ().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCEPPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldLogradouroPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNumeroPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldComplementoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldBairroPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldMunicipioPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldEmailPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldTelefonePJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCelularPJ().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldCreditoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJDateChooserDataDeAberturaPJ().getSpinner().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonInativoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setEnabled(true);
		getPainelGerenciarCliente().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarCliente().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarCliente().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarCliente().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarCliente().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarCliente().getJTextFieldNomePF().grabFocus();
		getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().grabFocus();
	}

	private void LimparCampos() {
		getPainelGerenciarCliente().getJTextFieldCodigoPF().setText("");
		getPainelGerenciarCliente().getJTextFieldBairroPF().setText("");
		getPainelGerenciarCliente().getJTextFieldCelularPF().setText("");
		getPainelGerenciarCliente().getJTextFieldCEPPF().setText("");
		getPainelGerenciarCliente().getJTextFieldComplementoPF().setText("");
		getPainelGerenciarCliente().getJTextFieldCPFPF().setText("");
		getPainelGerenciarCliente().getJTextFieldCreditoPF().setText("");
		getPainelGerenciarCliente().getJTextFieldEmailPF().setText("");
		getPainelGerenciarCliente().getJTextFieldLogradouroPF().setText("");
		getPainelGerenciarCliente().getJTextFieldMunicipioPF().setText("");
		getPainelGerenciarCliente().getJTextFieldNacionalidadePF().setText("");
		getPainelGerenciarCliente().getJTextFieldNaturalidadePF().setText("");
		getPainelGerenciarCliente().getJTextFieldNomePF().setText("");
		getPainelGerenciarCliente().getJTextFieldNumeroPF().setText("");
		getPainelGerenciarCliente().getJTextFieldOrgaoEmissorPF().setText("");
		getPainelGerenciarCliente().getJTextFieldTelefonePF().setText("");
		getPainelGerenciarCliente().getJTextFieldTelefonePF().setText("");
		getPainelGerenciarCliente().getjTextFieldRGPF().setText("");
		getPainelGerenciarCliente().getJComboBoxEstadoCivilPF().setSelectedIndex(0);
		getPainelGerenciarCliente().getJComboBoxSexoPF().setSelectedIndex(0);
		getPainelGerenciarCliente().getJComboBoxUFPF().setSelectedIndex(0);
		getPainelGerenciarCliente().getJComboBoxUFDocPF().setSelectedIndex(0);
		getPainelGerenciarCliente().getJRadioButtonAtivoPF().setSelected(false);
		getPainelGerenciarCliente().getJRadioButtonInativoPF().setSelected(false);

		getPainelGerenciarCliente().getJTextFieldCodigoPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldBairroPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldCelularPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldCEPPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldComplementoPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldCNPJPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldCreditoPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldEmailPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldLogradouroPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldMunicipioPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldRazaoSocialPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldNumeroPJ().setText("");
		getPainelGerenciarCliente().getJTextFieldTelefonePJ().setText("");
		getPainelGerenciarCliente().getjTextFieldIEPJ().setText("");
		getPainelGerenciarCliente().getJComboBoxUFPJ().setSelectedIndex(0);
		getPainelGerenciarCliente().getJRadioButtonAtivoPJ().setSelected(false);
		getPainelGerenciarCliente().getJRadioButtonInativoPJ().setSelected(false);

		getPainelGerenciarCliente().getJRadioButtonPessoaFisica().setSelected(false);
		getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().setSelected(false);
	}

	private static FrameGerenciarCliente getFrameGerenciarCliente() {
		if (frameGerenciarCliente == null) {
			frameGerenciarCliente = new FrameGerenciarCliente();
		}
		return frameGerenciarCliente;
	}

	private static PainelGerenciarCliente getPainelGerenciarCliente() {
		if (painelGerenciarCliente == null) {
			painelGerenciarCliente = new PainelGerenciarCliente();
		}
		return painelGerenciarCliente;
	}

	public static ClientePessoaFisicaDAO getClientePessoaFisicaDAO() {
		if (clientePessoaFisicaDAO == null) {
			clientePessoaFisicaDAO = new ClientePessoaFisicaDAO();
		}
		return clientePessoaFisicaDAO;
	}

	public static ClientePessoaJuridicaDAO getClientePessoaJuridicaDAO() {
		if (clientePessoaJuridicaDAO == null) {
			clientePessoaJuridicaDAO = new ClientePessoaJuridicaDAO();
		}
		return clientePessoaJuridicaDAO;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (getPainelGerenciarCliente().getJRadioButtonPessoaFisica().isSelected()) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() > -1) {
					if (!getPainelGerenciarCliente().getJTextFieldCelularPF().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPF("+");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() > -1) {
					if (!getPainelGerenciarCliente().getJTextFieldCelularPF().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPF("-");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() > -1) {
					if (!getPainelGerenciarCliente().getJTextFieldCelularPF().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPF("+");
					}
				}
			}
		}
		if (getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().isSelected()) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() > -1) {
					if (!getPainelGerenciarCliente().getJTextFieldCelularPJ().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPJ("+");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() > -1) {
					if (!getPainelGerenciarCliente().getJTextFieldCelularPJ().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPJ("-");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() > -1) {
					if (!getPainelGerenciarCliente().getJTextFieldCelularPJ().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPJ("+");
					}
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (getPainelGerenciarCliente().getJRadioButtonPessoaFisica().isSelected()) {
			if (getPainelGerenciarCliente().getJTableClientePF().getSelectedRow() > -1) {
				if (!getPainelGerenciarCliente().getJTextFieldCelularPF().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
					LinhaSelecionadaPF();
				}
			}
		}
		if (getPainelGerenciarCliente().getJRadioButtonPessoaJuridica().isSelected()) {
			if (getPainelGerenciarCliente().getJTableClientePJ().getSelectedRow() > -1) {
				if (!getPainelGerenciarCliente().getJTextFieldCelularPJ().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarCliente().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarCliente().getJButtonAlterar().isEnabled()) {
					LinhaSelecionadaPJ();
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
