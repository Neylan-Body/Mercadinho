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

import javax.swing.JOptionPane;

import dao.ClientePessoaFisicaDAO;
import dao.ClientePessoaJuridicaDAO;
import dao.FornecedorPessoaFisicaDAO;
import dao.FornecedorPessoaJuridicaDAO;
import model.ClientePessoaFisica;
import model.ClientePessoaJuridica;
import model.FornecedorPessoaFisica;
import model.FornecedorPessoaJuridica;
import model.ValidarTelaCliente;
import model.ValidarTelaFornecedor;
import view.FrameGerenciarFornecedor;
import view.PainelGerenciarFornecedor;

public class ControladorTelaGerenciarFornecedor implements ActionListener, KeyListener, MouseListener {

	private static FrameGerenciarFornecedor frameGerenciarFornecedor;
	private static PainelGerenciarFornecedor painelGerenciarFornecedor;
	private static boolean alterarFornecedor = false;
	private static FornecedorPessoaFisicaDAO fornecedorPessoaFisicaDAO;
	private static FornecedorPessoaJuridicaDAO fornecedorPessoaJuridicaDAO;

	public ControladorTelaGerenciarFornecedor(FrameGerenciarFornecedor frameGerenciarFornecedor,
			PainelGerenciarFornecedor painelGerenciarFornecedor) {

		this.frameGerenciarFornecedor = frameGerenciarFornecedor;
		this.painelGerenciarFornecedor = painelGerenciarFornecedor;
		Eventos();
		Inicio();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().setText("");
			getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().setText("");
			getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().setNumRows(0);
			getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().setNumRows(0);
			getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().setSelectedIndex(0);
			getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().setSelectedIndex(0);
			getPainelGerenciarFornecedor().repaint();
			getPainelGerenciarFornecedor().validate();
			PessoaFisica();
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().setText("");
			getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().setText("");
			getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().setNumRows(0);
			getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().setNumRows(0);
			getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().setSelectedIndex(0);
			getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().setSelectedIndex(0);
			getPainelGerenciarFornecedor().repaint();
			getPainelGerenciarFornecedor().validate();
			PessoaJuridica();
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJButtonIncluir()
				&& (getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().isSelected()
						|| getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().isSelected())) {
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().isSelected()) {
				PessoaFisica();
			}
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().isSelected()) {
				PessoaJuridica();
			}
			LimparCampos();
			OpcaoIncluir();
			alterarFornecedor = false;
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJButtonCancelar()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().setText("");
			getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().setText("");
			getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().setNumRows(0);
			getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().setNumRows(0);
			getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().setSelectedIndex(0);
			getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().setSelectedIndex(0);
			getPainelGerenciarFornecedor().repaint();
			getPainelGerenciarFornecedor().validate();
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJButtonPesquisarPF()) {
			if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().getSelectedIndex() > 0) {
				PesquisaPF();
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Selecione uma forma de pesquisa");
			}
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJButtonPesquisarPJ()) {
			if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().getSelectedIndex() > 0) {
				PesquisaPJ();
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Selecione uma forma de pesquisa");
			}
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJButtonAlterar()) {
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().isSelected()) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() > -1) {
					LinhaSelecionadaPF();
					OpcaoAlterarPF();
					alterarFornecedor = true;
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Selecione uma linha da tabela",
							"Pesquisa", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().isSelected()) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() > -1) {
					LinhaSelecionadaPJ();
					OpcaoAlterarPJ();
					alterarFornecedor = true;
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Selecione uma linha da tabela",
							"Pesquisa", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJButtonConfirmar()) {
			ValidarTelaFornecedor validarTelaFornecedor = new ValidarTelaFornecedor(getPainelGerenciarFornecedor());
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().isSelected()) {
				if (validarTelaFornecedor.TesteNome() && validarTelaFornecedor.TesteCPFPF()
						&& validarTelaFornecedor.TesteRGPF() && validarTelaFornecedor.TesteOrgaoEmissorPF()
						&& validarTelaFornecedor.TesteDataDeEmissaoPF() && validarTelaFornecedor.TesteNacionalidadePF()
						&& validarTelaFornecedor.TesteUFDocPF() && validarTelaFornecedor.TesteNaturalidadePF()
						&& validarTelaFornecedor.TesteSexoPF() && validarTelaFornecedor.TesteCadastradoEmPF()
						&& validarTelaFornecedor.TesteCEPPF() && validarTelaFornecedor.TesteLogradouroPF()
						&& validarTelaFornecedor.TesteNumeroPF() && validarTelaFornecedor.TesteComplementoPF()
						&& validarTelaFornecedor.TesteBairroPF() && validarTelaFornecedor.TesteMunicipioPF()
						&& validarTelaFornecedor.TesteUFPF() && validarTelaFornecedor.TesteEmailPF()
						&& validarTelaFornecedor.TesteTelefoneCelularPF()
						&& validarTelaFornecedor.TesteAtivoInativoPF()) {
					ConfirmarPessoaFisica();
				}
			}
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().isSelected()) {
				if (validarTelaFornecedor.TesteRazaoSocialPJ() && validarTelaFornecedor.TesteCNPJPJ()
						&& validarTelaFornecedor.TesteIEPJ() && validarTelaFornecedor.TesteCadastradoEmPF()
						&& validarTelaFornecedor.TesteCEPPJ() && validarTelaFornecedor.TesteLogradouroPJ()
						&& validarTelaFornecedor.TesteNumeroPJ() && validarTelaFornecedor.TesteComplementoPJ()
						&& validarTelaFornecedor.TesteBairroPJ() && validarTelaFornecedor.TesteMunicipioPJ()
						&& validarTelaFornecedor.TesteUFPJ() && validarTelaFornecedor.TesteEmailPJ()
						&& validarTelaFornecedor.TesteTelefoneCelularPJ()
						&& validarTelaFornecedor.TesteAtivoInativoPJ()) {
					ConfirmarPessoaJuridica();
				}
			}
		}
		if (e.getSource() == getPainelGerenciarFornecedor().getJButtonExcluir()) {
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().isSelected()) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() > -1) {
					int opc = JOptionPane.showConfirmDialog(getFrameGerenciarFornecedor(),
							"Deseja excluir esse cliente?", "Confirmar exclusão", JOptionPane.INFORMATION_MESSAGE);
					if (opc == 0) {
						FornecedorPessoaFisica clientePessoaFisica = new FornecedorPessoaFisica();
						clientePessoaFisica
								.setCodigo((int) getPainelGerenciarFornecedor().getJTableFornecedorPF().getValueAt(
										getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow(), 0));
						getFornecedorPessoaFisicaDAO().delete(clientePessoaFisica);
						getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().setNumRows(0);
						getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().setSelectedIndex(0);
						LimparCampos();
						Inicio();

					}
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Selecione uma linha da tabela",
							"Pesquisa", JOptionPane.ERROR_MESSAGE);
				}
			}
			if (getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().isSelected()) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() > -1) {
					int opc = JOptionPane.showConfirmDialog(getFrameGerenciarFornecedor(),
							"Deseja excluir esse cliente?", "Confirmar exclusão", JOptionPane.INFORMATION_MESSAGE);
					if (opc == 0) {
						FornecedorPessoaJuridica clientePessoaJuridica = new FornecedorPessoaJuridica();
						clientePessoaJuridica
								.setCodigo((int) getPainelGerenciarFornecedor().getJTableFornecedorPJ().getValueAt(
										getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow(), 0));
						getFornecedorPessoaJuridicaDAO().delete(clientePessoaJuridica);
						getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().setNumRows(0);
						getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().setSelectedIndex(0);
						LimparCampos();
						Inicio();

					}
				} else {
					JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Selecione uma linha da tabela",
							"Pesquisa", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().isSelected()) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() > -1) {
					if (!getPainelGerenciarFornecedor().getJTextFieldCelularPF().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPF("+");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() > -1) {
					if (!getPainelGerenciarFornecedor().getJTextFieldCelularPF().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPF("-");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() > -1) {
					if (!getPainelGerenciarFornecedor().getJTextFieldCelularPF().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPF("+");
					}
				}
			}
		}
		if (getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().isSelected()) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() > -1) {
					if (!getPainelGerenciarFornecedor().getJTextFieldCelularPJ().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPJ("+");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() > -1) {
					if (!getPainelGerenciarFornecedor().getJTextFieldCelularPJ().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
						LinhaSelecionadaPJ("-");
					}
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() > -1) {
					if (!getPainelGerenciarFornecedor().getJTextFieldCelularPJ().isEnabled()) {
						OpcaoTabela();
					}
					if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
							&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
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
		if (getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().isSelected()) {
			if (getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() > -1) {
				if (!getPainelGerenciarFornecedor().getJTextFieldCelularPF().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
					LinhaSelecionadaPF();
				}
			}
		}
		if (getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().isSelected()) {
			if (getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() > -1) {
				if (!getPainelGerenciarFornecedor().getJTextFieldCelularPJ().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarFornecedor().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarFornecedor().getJButtonAlterar().isEnabled()) {
					LinhaSelecionadaPJ();
				}
			}
		}
	}

	public void Eventos() {
		getPainelGerenciarFornecedor().getJButtonPesquisarPF().addActionListener(this);
		getPainelGerenciarFornecedor().getJButtonPesquisarPJ().addActionListener(this);
		getPainelGerenciarFornecedor().getJButtonIncluir().addActionListener(this);
		getPainelGerenciarFornecedor().getJButtonExcluir().addActionListener(this);
		getPainelGerenciarFornecedor().getJButtonAlterar().addActionListener(this);
		getPainelGerenciarFornecedor().getJButtonConfirmar().addActionListener(this);
		getPainelGerenciarFornecedor().getJButtonCancelar().addActionListener(this);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().addActionListener(this);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().addActionListener(this);
		getPainelGerenciarFornecedor().getJTableFornecedorPF().addMouseListener(this);
		getPainelGerenciarFornecedor().getJTableFornecedorPJ().addMouseListener(this);
		getPainelGerenciarFornecedor().getJTableFornecedorPF().addKeyListener(this);
		getPainelGerenciarFornecedor().getJTableFornecedorPJ().addKeyListener(this);
	}

	private void PessoaFisica() {
		getPainelGerenciarFornecedor().getPainelPF().setVisible(true);
		getPainelGerenciarFornecedor().getPainelPJ().setVisible(false);
		getFrameGerenciarFornecedor().repaint();
		getFrameGerenciarFornecedor().validate();
	}

	private void PessoaJuridica() {
		getPainelGerenciarFornecedor().getPainelPJ().setVisible(true);
		getPainelGerenciarFornecedor().getPainelPF().setVisible(false);
		getFrameGerenciarFornecedor().repaint();
		getFrameGerenciarFornecedor().validate();
	}

	public void Inicio() {
		getPainelGerenciarFornecedor().getPainelPJ().setVisible(false);
		getPainelGerenciarFornecedor().getPainelPF().setVisible(false);
		getPainelGerenciarFornecedor().getJTextFieldCodigoPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldNomePF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCPFPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldRGPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF().getSpinner().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().setEnabled(false);
		getPainelGerenciarFornecedor().getJComboBoxUFPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().setEnabled(false);
		getPainelGerenciarFornecedor().getJComboBoxSexoPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF().getSpinner().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCEPPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldNumeroPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldComplementoPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldBairroPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJComboBoxUFDocPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldEmailPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldTelefonePF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCelularPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldIEPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJComboBoxUFPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().getSpinner().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCEPPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldBairroPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldEmailPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCelularPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonConfirmar().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonCancelar().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().setEnabled(true);
	}

	private void LimparCampos() {
		getPainelGerenciarFornecedor().getJTextFieldCodigoPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldBairroPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldCelularPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldCEPPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldComplementoPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldCPFPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldEmailPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldNomePF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldNumeroPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldTelefonePF().setText("");
		getPainelGerenciarFornecedor().getJTextFieldRGPF().setText("");
		getPainelGerenciarFornecedor().getJComboBoxSexoPF().setSelectedIndex(0);
		getPainelGerenciarFornecedor().getJComboBoxUFPF().setSelectedIndex(0);
		getPainelGerenciarFornecedor().getJComboBoxUFDocPF().setSelectedIndex(0);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setSelected(false);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setSelected(false);

		getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldBairroPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldCelularPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldCEPPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldIEPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldEmailPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().setText("");
		getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().setText("");
		getPainelGerenciarFornecedor().getJComboBoxUFPJ().setSelectedIndex(0);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setSelected(false);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setSelected(false);

		getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().setSelected(false);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().setSelected(false);
	}

	public void OpcaoIncluir() {
		getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldCodigoPF().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldNomePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCPFPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldRGPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF().getSpinner().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxUFPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxSexoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF().getSpinner().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCEPPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNumeroPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldComplementoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldBairroPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxUFDocPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldEmailPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldTelefonePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCelularPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldIEPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxUFPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().getSpinner().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCEPPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldBairroPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldEmailPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCelularPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNomePF().grabFocus();
		getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().grabFocus();
	}

	private void OpcaoAlterarPF() {
		getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF().getSpinner().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxUFDocPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF().getSpinner().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCEPPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNomePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCPFPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxSexoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldRGPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldComplementoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldBairroPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNumeroPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxUFPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldEmailPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldTelefonePF().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCelularPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNomePF().grabFocus();
	}

	private void OpcaoAlterarPJ() {
		getPainelGerenciarFornecedor().getJRadioButtonPessoaFisica().setEnabled(false);
		getPainelGerenciarFornecedor().getJRadioButtonPessoaJuridica().setEnabled(false);
		getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCEPPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldIEPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().getSpinner().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldBairroPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJComboBoxUFPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldEmailPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldCelularPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarFornecedor().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().grabFocus();
	}

	private void OpcaoTabela() {
		getPainelGerenciarFornecedor().getJButtonAlterar().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonExcluir().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarFornecedor().getJButtonCancelar().setEnabled(true);
	}

	private void ConfirmarPessoaFisica() {
		FornecedorPessoaFisica fornecedorPessoaFisica = new FornecedorPessoaFisica();
		fornecedorPessoaFisica.setBairro(getPainelGerenciarFornecedor().getJTextFieldBairroPF().getText());
		java.util.Date cadastradoEm = getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF().getDate();
		fornecedorPessoaFisica.setCadastradoEm(new Date(cadastradoEm.getTime()));
		fornecedorPessoaFisica.setCelular(getPainelGerenciarFornecedor().getJTextFieldCelularPF().getText());
		fornecedorPessoaFisica.setCep(getPainelGerenciarFornecedor().getJTextFieldCEPPF().getText());
		fornecedorPessoaFisica.setComplemento(getPainelGerenciarFornecedor().getJTextFieldComplementoPF().getText());
		fornecedorPessoaFisica.setCpf(getPainelGerenciarFornecedor().getJTextFieldCPFPF().getText());
		java.util.Date dataEmissao = getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF().getDate();
		fornecedorPessoaFisica.setDtEmissao(new Date(dataEmissao.getTime()));
		fornecedorPessoaFisica.setEmail(getPainelGerenciarFornecedor().getJTextFieldEmailPF().getText());
		fornecedorPessoaFisica.setLogradouro(getPainelGerenciarFornecedor().getJTextFieldLogradouroPF().getText());
		fornecedorPessoaFisica.setMunicipio(getPainelGerenciarFornecedor().getJTextFieldMunicipioPF().getText());
		fornecedorPessoaFisica
				.setNacionalidade(getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF().getText());
		fornecedorPessoaFisica.setNaturalidade(getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF().getText());
		fornecedorPessoaFisica.setNome(getPainelGerenciarFornecedor().getJTextFieldNomePF().getText());
		fornecedorPessoaFisica.setNumero(getPainelGerenciarFornecedor().getJTextFieldNumeroPF().getText());
		fornecedorPessoaFisica.setOrgaoEmissor(getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF().getText());
		fornecedorPessoaFisica.setRg(getPainelGerenciarFornecedor().getJTextFieldRGPF().getText());
		fornecedorPessoaFisica
				.setSexo(getPainelGerenciarFornecedor().getJComboBoxSexoPF().getSelectedItem().toString());
		if (getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().isSelected()) {
			fornecedorPessoaFisica.setSituacao(getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().getText());
		} else {
			fornecedorPessoaFisica.setSituacao(getPainelGerenciarFornecedor().getJRadioButtonInativoPF().getText());
		}
		fornecedorPessoaFisica.setTelefone(getPainelGerenciarFornecedor().getJTextFieldTelefonePF().getText());
		fornecedorPessoaFisica.setUf(getPainelGerenciarFornecedor().getJComboBoxUFPF().getSelectedItem().toString());
		fornecedorPessoaFisica
				.setUfDoc(getPainelGerenciarFornecedor().getJComboBoxUFDocPF().getSelectedItem().toString());
		if (alterarFornecedor == false) {
			if (getFornecedorPessoaFisicaDAO().create(fornecedorPessoaFisica)) {
				getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().setText("");
				getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().setNumRows(0);
				getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}
		if (alterarFornecedor == true) {
			fornecedorPessoaFisica
					.setCodigo(Integer.parseInt(getPainelGerenciarFornecedor().getJTextFieldCodigoPF().getText()));
			if (getFornecedorPessoaFisicaDAO().update(fornecedorPessoaFisica)) {
				getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().setText("");
				getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().setNumRows(0);
				getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}
	}

	private void ConfirmarPessoaJuridica() {
		FornecedorPessoaJuridica fornecedorPessoaJuridica = new FornecedorPessoaJuridica();
		fornecedorPessoaJuridica.setBairro(getPainelGerenciarFornecedor().getJTextFieldBairroPJ().getText());
		java.util.Date cadastradoEm = getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().getDate();
		fornecedorPessoaJuridica.setCadastradoEm(new Date(cadastradoEm.getTime()));
		fornecedorPessoaJuridica.setCelular(getPainelGerenciarFornecedor().getJTextFieldCelularPJ().getText());
		fornecedorPessoaJuridica.setCep(getPainelGerenciarFornecedor().getJTextFieldCEPPJ().getText());
		fornecedorPessoaJuridica.setComplemento(getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().getText());
		fornecedorPessoaJuridica.setCnpj(getPainelGerenciarFornecedor().getJTextFieldCNPJPJ().getText());
		fornecedorPessoaJuridica.setEmail(getPainelGerenciarFornecedor().getJTextFieldEmailPJ().getText());
		fornecedorPessoaJuridica.setLogradouro(getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().getText());
		fornecedorPessoaJuridica.setMunicipio(getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ().getText());
		fornecedorPessoaJuridica.setRazaoSocial(getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().getText());
		fornecedorPessoaJuridica.setNumero(getPainelGerenciarFornecedor().getJTextFieldNumeroPJ().getText());
		fornecedorPessoaJuridica.setIe(getPainelGerenciarFornecedor().getJTextFieldIEPJ().getText());
		if (getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().isSelected()) {
			fornecedorPessoaJuridica.setSituacao(getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().getText());
		} else {
			fornecedorPessoaJuridica.setSituacao(getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().getText());
		}
		fornecedorPessoaJuridica.setTelefone(getPainelGerenciarFornecedor().getJTextFieldTelefonePJ().getText());
		fornecedorPessoaJuridica.setUf(getPainelGerenciarFornecedor().getJComboBoxUFPJ().getSelectedItem().toString());
		if (alterarFornecedor == false) {
			if (getFornecedorPessoaJuridicaDAO().create(fornecedorPessoaJuridica)) {
				getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().setText("");
				getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().setNumRows(0);
				getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}
		if (alterarFornecedor == true) {
			fornecedorPessoaJuridica
					.setCodigo(Integer.parseInt(getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().getText()));
			if (getFornecedorPessoaJuridicaDAO().update(fornecedorPessoaJuridica)) {
				getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().setText("");
				getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().setNumRows(0);
				getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}

	}

	private void PesquisaPJ() {
		// TODO Auto-generated method stub
		getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().setNumRows(0);
		int cont = 0;
		if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().getSelectedIndex() == 1) {
			String razaoSocial = getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().getText().toString();
			for (int i = 0; i < getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicasPorRazaoSocial(razaoSocial)
					.size(); i++) {
				getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ()
						.addRow(new Object[] {
								getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicasPorRazaoSocial(razaoSocial)
										.get(i).getCodigo(),
								getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicasPorRazaoSocial(razaoSocial)
										.get(i).getRazaoSocial(),
								getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicasPorRazaoSocial(razaoSocial)
										.get(i).getCnpj(),
								getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicasPorRazaoSocial(razaoSocial)
										.get(i).getEmail() });
				cont++;
			}
		}
		if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().getSelectedIndex() == 2) {
			try {
				int codigo = Integer
						.parseInt(getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().getText().toString());
				if (!getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getRazaoSocial()
						.equals("")) {
					getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().addRow(new Object[] {
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCodigo(),
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getRazaoSocial(),
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCnpj(),
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPJ().getSelectedIndex() == 3) {
			try {
				String CNPJ = getPainelGerenciarFornecedor().getJTextFieldPesquisaPJ().getText().toString();
				CNPJ.replace(".", "");
				CNPJ.replace("/", "");
				CNPJ.replace("-", "");
				String mascara = CNPJ.substring(0, 2);
				mascara = mascara + "." + CNPJ.substring(2, 5) + "." + CNPJ.substring(5, 8) + "/"
						+ CNPJ.substring(8, 12) + "-" + CNPJ.substring(12, 14);
				CNPJ = mascara;
				if (!getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCNPJ(CNPJ).getRazaoSocial()
						.equals("")) {
					getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPJ().addRow(new Object[] {
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCNPJ(CNPJ).getCodigo(),
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCNPJ(CNPJ).getRazaoSocial(),
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCNPJ(CNPJ).getCnpj(),
							getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCNPJ(CNPJ).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Fornecedor inexistente", "Pesquisa",
					JOptionPane.ERROR_MESSAGE);
		}
		cont = 0;
	}

	private void PesquisaPF() {
		// TODO Auto-generated method stub
		getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().setNumRows(0);
		int cont = 0;
		if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().getSelectedIndex() == 1) {
			String nome = getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().getText().toString();
			for (int i = 0; i < getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicasPorNome(nome).size(); i++) {
				getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().addRow(new Object[] {
						getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicasPorNome(nome).get(i).getCodigo(),
						getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicasPorNome(nome).get(i).getNome(),
						getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicasPorNome(nome).get(i).getCpf(),
						getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicasPorNome(nome).get(i).getEmail() });
				cont++;
			}
		}
		if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().getSelectedIndex() == 2) {
			try {
				int codigo = Integer
						.parseInt(getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().getText().toString());
				if (!getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNome().equals("")) {
					getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF().addRow(new Object[] {
							getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCodigo(),
							getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNome(),
							getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCpf(),
							getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (getPainelGerenciarFornecedor().getJComboBoxPesquisaPF().getSelectedIndex() == 3) {
			try {
				String CPF = getPainelGerenciarFornecedor().getJTextFieldPesquisaPF().getText().toString();
				CPF.replace(".", "");
				CPF.replace("-", "");
				String mascara = CPF.substring(0, 3);
				mascara = mascara + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
				CPF = mascara;
				if (!getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCPF(CPF).getNome().equals("")) {
					getPainelGerenciarFornecedor().getDefaultTableModelFornecedorPF()
							.addRow(new Object[] {
									getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCPF(CPF).getCodigo(),
									getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCPF(CPF).getNome(),
									getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCPF(CPF).getCpf(),
									getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCPF(CPF).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(getFrameGerenciarFornecedor(), "Fornecedor inexistente", "Pesquisa",
					JOptionPane.ERROR_MESSAGE);
		}
		cont = 0;
	}

	private void LinhaSelecionadaPF() {
		int codigo = (int) getPainelGerenciarFornecedor().getJTableFornecedorPF()
				.getValueAt(getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow(), 0);
		getPainelGerenciarFornecedor().getJTextFieldCodigoPF().setText(Integer.toString(codigo));
		getPainelGerenciarFornecedor().getJTextFieldNomePF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNome());
		getPainelGerenciarFornecedor().getJTextFieldCPFPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCpf());
		getPainelGerenciarFornecedor().getJTextFieldRGPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getRg());
		getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getOrgaoEmissor());
		getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF()
				.setDate(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getDtEmissao());
		getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNacionalidade());
		getPainelGerenciarFornecedor().getJComboBoxUFDocPF()
				.setSelectedItem(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getUfDoc());
		getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNaturalidade());
		getPainelGerenciarFornecedor().getJComboBoxSexoPF()
				.setSelectedItem(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getSexo());
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF()
				.setDate(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCadastradoEm());
		getPainelGerenciarFornecedor().getJTextFieldCEPPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCep());
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getLogradouro());
		getPainelGerenciarFornecedor().getJTextFieldNumeroPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNumero());
		getPainelGerenciarFornecedor().getJTextFieldComplementoPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getComplemento());
		getPainelGerenciarFornecedor().getJTextFieldBairroPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getBairro());
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getMunicipio());
		getPainelGerenciarFornecedor().getJComboBoxUFPF()
				.setSelectedItem(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getUf());
		getPainelGerenciarFornecedor().getJTextFieldEmailPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getEmail());
		getPainelGerenciarFornecedor().getJTextFieldTelefonePF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getTelefone());
		getPainelGerenciarFornecedor().getJTextFieldCelularPF()
				.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCelular());
		if (getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getSituacao().equals("Ativo")) {
			getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setSelected(true);
			getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setSelected(false);
		}
		if (getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getSituacao().equals("Inativo")) {
			getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setSelected(false);
			getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setSelected(true);
		}
	}

	private void LinhaSelecionadaPF(String sinal) {
		try {
			alterarFornecedor = true;
			int codigo = -1;
			if (sinal.equals("+")) {
				codigo = (int) getPainelGerenciarFornecedor().getJTableFornecedorPF()
						.getValueAt(getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() + 1, 0);
			}
			if (sinal.equals("-")) {
				codigo = (int) getPainelGerenciarFornecedor().getJTableFornecedorPF()
						.getValueAt(getPainelGerenciarFornecedor().getJTableFornecedorPF().getSelectedRow() - 1, 0);
			}
			getPainelGerenciarFornecedor().getJTextFieldCodigoPF().setText(Integer.toString(codigo));
			getPainelGerenciarFornecedor().getJTextFieldNomePF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNome());
			getPainelGerenciarFornecedor().getJTextFieldCPFPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCpf());
			getPainelGerenciarFornecedor().getJTextFieldRGPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getRg());
			getPainelGerenciarFornecedor().getJTextFieldOrgaoEmissorPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getOrgaoEmissor());
			getPainelGerenciarFornecedor().getJDateChooserDataDeEmissaoPF()
					.setDate(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getDtEmissao());
			getPainelGerenciarFornecedor().getJTextFieldNacionalidadePF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNacionalidade());
			getPainelGerenciarFornecedor().getJComboBoxUFDocPF()
					.setSelectedItem(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getUfDoc());
			getPainelGerenciarFornecedor().getJTextFieldNaturalidadePF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNaturalidade());
			getPainelGerenciarFornecedor().getJComboBoxSexoPF()
					.setSelectedItem(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getSexo());
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPF()
					.setDate(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCadastradoEm());
			getPainelGerenciarFornecedor().getJTextFieldCEPPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCep());
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getLogradouro());
			getPainelGerenciarFornecedor().getJTextFieldNumeroPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getNumero());
			getPainelGerenciarFornecedor().getJTextFieldComplementoPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getComplemento());
			getPainelGerenciarFornecedor().getJTextFieldBairroPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getBairro());
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getMunicipio());
			getPainelGerenciarFornecedor().getJComboBoxUFPF()
					.setSelectedItem(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getUf());
			getPainelGerenciarFornecedor().getJTextFieldEmailPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getEmail());
			getPainelGerenciarFornecedor().getJTextFieldTelefonePF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getTelefone());
			getPainelGerenciarFornecedor().getJTextFieldCelularPF()
					.setText(getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getCelular());
			if (getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getSituacao().equals("Ativo")) {
				getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setSelected(true);
				getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setSelected(false);
			}
			if (getFornecedorPessoaFisicaDAO().FornecedorPessoaFisicaPorCodigo(codigo).getSituacao()
					.equals("Inativo")) {
				getPainelGerenciarFornecedor().getJRadioButtonAtivoPF().setSelected(false);
				getPainelGerenciarFornecedor().getJRadioButtonInativoPF().setSelected(true);
			}
		} catch (Exception e) {

		}
	}

	private void LinhaSelecionadaPJ() {
		int codigo = (int) getPainelGerenciarFornecedor().getJTableFornecedorPJ()
				.getValueAt(getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow(), 0);
		getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().setText(Integer.toString(codigo));
		getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getRazaoSocial());
		getPainelGerenciarFornecedor().getJTextFieldCNPJPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCnpj());
		getPainelGerenciarFornecedor().getJTextFieldIEPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getIe());
		getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ()
				.setDate(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCadastradoEm());
		getPainelGerenciarFornecedor().getJTextFieldCEPPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCep());
		getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getLogradouro());
		getPainelGerenciarFornecedor().getJTextFieldNumeroPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getNumero());
		getPainelGerenciarFornecedor().getJTextFieldComplementoPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getComplemento());
		getPainelGerenciarFornecedor().getJTextFieldBairroPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getBairro());
		getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getMunicipio());
		getPainelGerenciarFornecedor().getJComboBoxUFPJ()
				.setSelectedItem(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getUf());
		getPainelGerenciarFornecedor().getJTextFieldEmailPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getEmail());
		getPainelGerenciarFornecedor().getJTextFieldTelefonePJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getTelefone());
		getPainelGerenciarFornecedor().getJTextFieldCelularPJ()
				.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCelular());
		if (getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getSituacao().equals("Ativo")) {
			getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setSelected(true);
			getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setSelected(false);
		}
		if (getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getSituacao()
				.equals("Inativo")) {
			getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setSelected(false);
			getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setSelected(true);
		}
	}

	private void LinhaSelecionadaPJ(String sinal) {
		try {
			alterarFornecedor = true;
			int codigo = -1;
			if (sinal.equals("+")) {
				codigo = (int) getPainelGerenciarFornecedor().getJTableFornecedorPJ()
						.getValueAt(getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() + 1, 0);
			}
			if (sinal.equals("-")) {
				codigo = (int) getPainelGerenciarFornecedor().getJTableFornecedorPJ()
						.getValueAt(getPainelGerenciarFornecedor().getJTableFornecedorPJ().getSelectedRow() - 1, 0);
			}
			getPainelGerenciarFornecedor().getJTextFieldCodigoPJ().setText(Integer.toString(codigo));
			getPainelGerenciarFornecedor().getJTextFieldRazaoSocialPJ().setText(
					getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getRazaoSocial());
			getPainelGerenciarFornecedor().getJTextFieldCNPJPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCnpj());
			getPainelGerenciarFornecedor().getJTextFieldIEPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getIe());
			getPainelGerenciarFornecedor().getJDateChooserCadastradoEmPJ().setDate(
					getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCadastradoEm());
			getPainelGerenciarFornecedor().getJTextFieldCEPPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCep());
			getPainelGerenciarFornecedor().getJTextFieldLogradouroPJ().setText(
					getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getLogradouro());
			getPainelGerenciarFornecedor().getJTextFieldNumeroPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getNumero());
			getPainelGerenciarFornecedor().getJTextFieldComplementoPJ().setText(
					getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getComplemento());
			getPainelGerenciarFornecedor().getJTextFieldBairroPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getBairro());
			getPainelGerenciarFornecedor().getJTextFieldMunicipioPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getMunicipio());
			getPainelGerenciarFornecedor().getJComboBoxUFPJ().setSelectedItem(
					getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getUf());
			getPainelGerenciarFornecedor().getJTextFieldEmailPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getEmail());
			getPainelGerenciarFornecedor().getJTextFieldTelefonePJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getTelefone());
			getPainelGerenciarFornecedor().getJTextFieldCelularPJ()
					.setText(getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getCelular());
			if (getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getSituacao()
					.equals("Ativo")) {
				getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setSelected(true);
				getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setSelected(false);
			}
			if (getFornecedorPessoaJuridicaDAO().FornecedorPessoaJuridicaPorCodigo(codigo).getSituacao()
					.equals("Inativo")) {
				getPainelGerenciarFornecedor().getJRadioButtonAtivoPJ().setSelected(false);
				getPainelGerenciarFornecedor().getJRadioButtonInativoPJ().setSelected(true);
			}
		} catch (Exception e) {

		}
	}

	private static FrameGerenciarFornecedor getFrameGerenciarFornecedor() {
		if (frameGerenciarFornecedor == null) {
			frameGerenciarFornecedor = new FrameGerenciarFornecedor();
		}
		return frameGerenciarFornecedor;
	}

	private static PainelGerenciarFornecedor getPainelGerenciarFornecedor() {
		if (painelGerenciarFornecedor == null) {
			painelGerenciarFornecedor = new PainelGerenciarFornecedor();
		}
		return painelGerenciarFornecedor;
	}

	public static FornecedorPessoaFisicaDAO getFornecedorPessoaFisicaDAO() {
		if (fornecedorPessoaFisicaDAO == null) {
			fornecedorPessoaFisicaDAO = new FornecedorPessoaFisicaDAO();
		}
		return fornecedorPessoaFisicaDAO;
	}

	public static FornecedorPessoaJuridicaDAO getFornecedorPessoaJuridicaDAO() {
		if (fornecedorPessoaJuridicaDAO == null) {
			fornecedorPessoaJuridicaDAO = new FornecedorPessoaJuridicaDAO();
		}
		return fornecedorPessoaJuridicaDAO;
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
