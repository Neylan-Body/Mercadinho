package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import dao.FuncionarioDAO;
import dao.OcupacaoDAO;
import model.ClientePessoaFisica;
import model.ClientePessoaJuridica;
import model.Funcionario;
import model.Ocupacao;
import model.Tipo;
import model.Unidade;
import model.ValidarTelaCliente;
import model.ValidarTelaFuncionario;
import view.FrameGerenciarFuncionario;
import view.FrameGerenciarOcupacao;
import view.PainelGerenciarFuncionario;
import view.PainelGerenciarOcupacao;

public class ControladorTelaGerenciarFuncionario implements ActionListener, MouseListener, KeyListener, WindowListener {

	private static FrameGerenciarFuncionario frameGerenciarFuncionario;
	private static FrameGerenciarOcupacao frameGerenciarOcupacao;

	private static PainelGerenciarFuncionario painelGerenciarFuncionario;
	private static PainelGerenciarOcupacao painelGerenciarOcupacao;
	private static FuncionarioDAO funcionarioDAO;
	private static OcupacaoDAO ocupacaoDAO;
	private boolean alterarFuncionario = false;
	private boolean alterarOcupacao;

	public ControladorTelaGerenciarFuncionario(FrameGerenciarFuncionario frameGerenciarFuncionario,
			PainelGerenciarFuncionario painelGerenciarFuncionario) {
		this.frameGerenciarFuncionario = frameGerenciarFuncionario;
		this.painelGerenciarFuncionario = painelGerenciarFuncionario;
		Eventos();
		PovoarJComboBox();
		Inicio();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonIncluir()) {
			LimparCampos();
			OpcaoIncluir();
			alterarFuncionario = false;
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonCancelar()) {
			LimparCampos();
			Inicio();
			getPainelGerenciarFuncionario().getJTextFieldPesquisa().setText("");
			getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().setNumRows(0);
			getPainelGerenciarFuncionario().getJComboBoxPesquisa().setSelectedIndex(0);
			getPainelGerenciarFuncionario().repaint();
			getPainelGerenciarFuncionario().validate();
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonPesquisar()) {
			if (getPainelGerenciarFuncionario().getJComboBoxPesquisa().getSelectedIndex() > 0) {
				Pesquisar();
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarFuncionario(), "Selecione uma forma de pesquisa");
			}
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonAlterar()) {
			if (getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() > -1) {
				LinhaSelecionada();
				OpcaoAlterar();
				alterarFuncionario = true;
			} else {
				JOptionPane.showMessageDialog(getFrameGerenciarFuncionario(), "Selecione uma linha da tabela",
						"Alterar", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == getPainelGerenciarOcupacao().getJButtonConfirmar()) {
			if (alterarOcupacao == false) {
				if (!getPainelGerenciarOcupacao().getJTextFieldGerenciarOcupacao().getText().equals("")) {
					Ocupacao tipo = new Ocupacao();
					String nome = getPainelGerenciarOcupacao().getJTextFieldGerenciarOcupacao().getText();
					tipo.setOcupacao(nome);
					getOcupacaoDAO().create(tipo);
				}
			}
			if (alterarOcupacao == true) {
				if (!getPainelGerenciarOcupacao().getJTextFieldGerenciarOcupacao().getText().equals("")) {
					Ocupacao tipo = new Ocupacao();
					int id = getOcupacaoDAO()
							.OcupacaoPorNome(
									getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedItem().toString())
							.getId();
					String nome = getPainelGerenciarOcupacao().getJTextFieldGerenciarOcupacao().getText();
					tipo.setOcupacao(nome);
					tipo.setId(id);
					getOcupacaoDAO().update(tipo);
				}
			}
			getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonPesquisar().setEnabled(true);
			getPainelGerenciarFuncionario().getjComboBoxOcupacao().removeAllItems();
			PovoarJComboBox();
			getFrameGerenciarOcupacao().dispose();
			getFrameGerenciarOcupacao().repaint();
			getFrameGerenciarOcupacao().validate();
		}
		if (e.getSource() == getPainelGerenciarOcupacao().getJButtonCancelar()) {
			getFrameGerenciarOcupacao().dispose();
			getFrameGerenciarOcupacao().repaint();
			getFrameGerenciarOcupacao().validate();
			getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(true);
			getPainelGerenciarFuncionario().getJButtonPesquisar().setEnabled(true);
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonAddOcupacao()) {
			painelGerenciarOcupacao = null;
			frameGerenciarOcupacao = null;
			getFrameGerenciarOcupacao().addWindowListener(this);
			getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(false);
			getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(false);
			getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(false);
			getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(false);
			getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(false);
			getPainelGerenciarFuncionario().getJButtonPesquisar().setEnabled(false);
			getPainelGerenciarOcupacao().getJButtonCancelar().addActionListener(this);
			getPainelGerenciarOcupacao().getJButtonConfirmar().addActionListener(this);
			getFrameGerenciarOcupacao().setContentPane(getPainelGerenciarOcupacao());
			getFrameGerenciarOcupacao().repaint();
			getFrameGerenciarOcupacao().validate();
			alterarOcupacao = false;
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonAlterarOcupacao()) {
			if (getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedIndex() > 0) {
				alterarOcupacao = true;
				painelGerenciarOcupacao = null;
				frameGerenciarOcupacao = null;
				getFrameGerenciarOcupacao().addWindowListener(this);
				getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(false);
				getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(false);
				getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(false);
				getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(false);
				getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(false);
				getPainelGerenciarFuncionario().getJButtonPesquisar().setEnabled(false);
				getPainelGerenciarOcupacao().getJButtonCancelar().addActionListener(this);
				getPainelGerenciarOcupacao().getJButtonConfirmar().addActionListener(this);
				getFrameGerenciarOcupacao().setContentPane(getPainelGerenciarOcupacao());
				getPainelGerenciarOcupacao().getJTextFieldGerenciarOcupacao()
						.setText(getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedItem().toString());
				getFrameGerenciarOcupacao().repaint();
				getFrameGerenciarOcupacao().validate();
			}
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonRemoverOcupacao()) {
			if (getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedIndex() > 0) {
				int id = getOcupacaoDAO()
						.OcupacaoPorNome(
								getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedItem().toString())
						.getId();
				Ocupacao ocupacao = new Ocupacao();
				String nome = getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedItem().toString();
				ocupacao.setOcupacao(nome);
				ocupacao.setId(id);
				getOcupacaoDAO().delete(ocupacao);
				getPainelGerenciarFuncionario().getjComboBoxOcupacao().removeAllItems();
				PovoarJComboBox();
			}
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonConfirmar()) {
			ValidarTelaFuncionario validarTelaFuncionario = new ValidarTelaFuncionario(getPainelGerenciarFuncionario());
			if (validarTelaFuncionario.TesteNome() && validarTelaFuncionario.TesteCPF()
					&& validarTelaFuncionario.TesteRG() && validarTelaFuncionario.TesteOrgaoEmissor()
					&& validarTelaFuncionario.TesteDataDeEmissao() && validarTelaFuncionario.TesteEstadoCivil()
					&& validarTelaFuncionario.TesteDataDeNascimentoEDataDeEmissao()
					&& validarTelaFuncionario.TesteDataDeNascimento() && validarTelaFuncionario.TesteNacionalidade()
					&& validarTelaFuncionario.TesteUFDoc() && validarTelaFuncionario.TesteNaturalidade()
					&& validarTelaFuncionario.TesteSexo() && validarTelaFuncionario.TesteDataDeNascimentoECadastradoEm()
					&& validarTelaFuncionario.TesteCadastradoEm() && validarTelaFuncionario.TesteCEP()
					&& validarTelaFuncionario.TesteLogradouro() && validarTelaFuncionario.TesteNumero()
					&& validarTelaFuncionario.TesteComplemento() && validarTelaFuncionario.TesteBairro()
					&& validarTelaFuncionario.TesteMunicipio() && validarTelaFuncionario.TesteUF()
					&& validarTelaFuncionario.TesteEmail() && validarTelaFuncionario.TesteTelefoneCelular()
					&& validarTelaFuncionario.TesteOcupacao() && validarTelaFuncionario.TesteSalario()
					&& validarTelaFuncionario.TesteSenha() && validarTelaFuncionario.TesteConfirmarSenha()
					&& validarTelaFuncionario.TesteSenhasIguais()) {
				Confirmar();
			}
		}
		if (e.getSource() == getPainelGerenciarFuncionario().getJButtonExcluir()) {
			Exclusao();
		}
	}

	private void PovoarJComboBox() {
		getPainelGerenciarFuncionario().getjComboBoxOcupacao()
				.setModel(new DefaultComboBoxModel(new String[] { "--" }));
		for (int i = 0; i < getOcupacaoDAO().read().size(); i++) {
			getPainelGerenciarFuncionario().getjComboBoxOcupacao()
					.addItem(getOcupacaoDAO().read().get(i).getOcupacao());
		}
	}

	private void Exclusao() {
		if (getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() > -1) {
			int opc = JOptionPane.showConfirmDialog(getFrameGerenciarFuncionario(), "Deseja excluir esse funcionario?",
					"Confirmar exclusão", JOptionPane.INFORMATION_MESSAGE);
			if (opc == 0) {
				Funcionario funcionario = new Funcionario();
				funcionario.setCodigo((int) getPainelGerenciarFuncionario().getJTableFuncionario()
						.getValueAt(getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow(), 0));
				getFuncionarioDAO().delete(funcionario);
				getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().setNumRows(0);
				getPainelGerenciarFuncionario().getJComboBoxPesquisa().setSelectedIndex(0);
				LimparCampos();
				Inicio();

			}
		} else {
			JOptionPane.showMessageDialog(getFrameGerenciarFuncionario(), "Selecione uma linha da tabela", "Exclusão",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void Confirmar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setBairro(getPainelGerenciarFuncionario().getJTextFieldBairro().getText());
		java.util.Date cadastradoEm = getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().getDate();
		funcionario.setCadastradoEm(new Date(cadastradoEm.getTime()));
		funcionario.setCelular(getPainelGerenciarFuncionario().getJTextFieldCelular().getText());
		funcionario.setCep(getPainelGerenciarFuncionario().getJTextFieldCEP().getText());
		funcionario.setComplemento(getPainelGerenciarFuncionario().getJTextFieldComplemento().getText());
		funcionario.setCpf(getPainelGerenciarFuncionario().getJTextFieldCPF().getText());
		java.util.Date dataEmissao = getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().getDate();
		funcionario.setDtEmissao(new Date(dataEmissao.getTime()));
		java.util.Date dataNascimento = getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().getDate();
		funcionario.setDtNascimento(new Date(dataNascimento.getTime()));
		funcionario.setEmail(getPainelGerenciarFuncionario().getJTextFieldEmail().getText());
		funcionario
				.setEstadoCivil(getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().getSelectedItem().toString());
		funcionario.setLogradouro(getPainelGerenciarFuncionario().getJTextFieldLogradouro().getText());
		funcionario.setMunicipio(getPainelGerenciarFuncionario().getJTextFieldMunicipio().getText());
		funcionario.setNacionalidade(getPainelGerenciarFuncionario().getJTextFieldNacionalidade().getText());
		funcionario.setNaturalidade(getPainelGerenciarFuncionario().getJTextFieldNaturalidade().getText());
		funcionario.setNome(getPainelGerenciarFuncionario().getJTextFieldNome().getText());
		funcionario.setNumero(getPainelGerenciarFuncionario().getJTextFieldNumero().getText());
		funcionario.setOrgaoEmissor(getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().getText());
		funcionario.setRg(getPainelGerenciarFuncionario().getJTextFieldRG().getText());
		funcionario.setSexo(getPainelGerenciarFuncionario().getjComboBoxSexo().getSelectedItem().toString());
		funcionario.setTelefone(getPainelGerenciarFuncionario().getJTextFieldTelefone().getText());
		funcionario.setUf(getPainelGerenciarFuncionario().getjComboBoxUF().getSelectedItem().toString());
		funcionario.setUfDoc(getPainelGerenciarFuncionario().getjComboBoxUFDoc().getSelectedItem().toString());
		funcionario.setIdOcupacao(getOcupacaoDAO()
				.OcupacaoPorNome(getPainelGerenciarFuncionario().getjComboBoxOcupacao().getSelectedItem().toString())
				.getId());
		funcionario.setSalario(Double.parseDouble(getPainelGerenciarFuncionario().getJTextFieldSalario().getText()));
		funcionario.setSenha(getPainelGerenciarFuncionario().getJTextFieldSenha().getText());
		if (alterarFuncionario == false) {
			if (getFuncionarioDAO().create(funcionario)) {
				getPainelGerenciarFuncionario().getJTextFieldPesquisa().setText("");
				getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().setNumRows(0);
				getPainelGerenciarFuncionario().getJComboBoxPesquisa().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}
		if (alterarFuncionario == true) {
			funcionario.setCodigo(Integer.parseInt(getPainelGerenciarFuncionario().getJTextFieldCodigo().getText()));
			if (getFuncionarioDAO().update(funcionario)) {
				getPainelGerenciarFuncionario().getJTextFieldPesquisa().setText("");
				getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().setNumRows(0);
				getPainelGerenciarFuncionario().getJComboBoxPesquisa().setSelectedIndex(0);
				LimparCampos();
				Inicio();
			}
		}

	}

	private void Pesquisar() {
		getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().setNumRows(0);
		int cont = 0;
		if (getPainelGerenciarFuncionario().getJComboBoxPesquisa().getSelectedIndex() == 1) {
			String nome = getPainelGerenciarFuncionario().getJTextFieldPesquisa().getText().toString();
			for (int i = 0; i < getFuncionarioDAO().FuncionariosPorNome(nome).size(); i++) {
				getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().addRow(new Object[] {
						getFuncionarioDAO().FuncionariosPorNome(nome).get(i).getCodigo(),
						getFuncionarioDAO().FuncionariosPorNome(nome).get(i).getCpf(),
						getFuncionarioDAO().FuncionariosPorNome(nome).get(i).getNome(),
						getOcupacaoDAO()
								.OcupacaoPorId(getFuncionarioDAO().FuncionariosPorNome(nome).get(i).getIdOcupacao())
								.getOcupacao(),
						getFuncionarioDAO().FuncionariosPorNome(nome).get(i).getEmail() });
				cont++;
			}
		}
		if (getPainelGerenciarFuncionario().getJComboBoxPesquisa().getSelectedIndex() == 2) {
			try {
				int codigo = Integer
						.parseInt(getPainelGerenciarFuncionario().getJTextFieldPesquisa().getText().toString());
				if (!getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNome().equals("")) {
					getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().addRow(new Object[] {
							getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCodigo(),
							getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCpf(),
							getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNome(),
							getOcupacaoDAO()
									.OcupacaoPorId(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getIdOcupacao())
									.getOcupacao(),
							getFuncionarioDAO().FuncionarioPorCodigo(codigo).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarFuncionario(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (getPainelGerenciarFuncionario().getJComboBoxPesquisa().getSelectedIndex() == 3) {
			try {
				String CPF = getPainelGerenciarFuncionario().getJTextFieldPesquisa().getText().toString();
				CPF.replace(".", "");
				CPF.replace("-", "");
				String mascara = CPF.substring(0, 3);
				mascara = mascara + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
				CPF = mascara;
				if (!getFuncionarioDAO().FuncionarioPorCPF(CPF).getNome().equals("")) {
					getPainelGerenciarFuncionario().getDefaultTableModelFuncionario()
							.addRow(new Object[] { getFuncionarioDAO().FuncionarioPorCPF(CPF).getCodigo(),
									getFuncionarioDAO().FuncionarioPorCPF(CPF).getCpf(),
									getFuncionarioDAO().FuncionarioPorCPF(CPF).getNome(),
									getOcupacaoDAO()
											.OcupacaoPorId(getFuncionarioDAO().FuncionarioPorCPF(CPF).getIdOcupacao())
											.getOcupacao(),
									getFuncionarioDAO().FuncionarioPorCPF(CPF).getEmail() });
					cont++;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarFuncionario(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (getPainelGerenciarFuncionario().getJComboBoxPesquisa().getSelectedIndex() == 4) {
			try {
				String ocupacao = getPainelGerenciarFuncionario().getJTextFieldPesquisa().getText().toString();
				int idOcupacao = getOcupacaoDAO().OcupacaoPorNome(ocupacao).getId();
				if (getFuncionarioDAO().FuncionariosPorOcupacao(idOcupacao).size() > 0) {
					for (int i = 0; i < getFuncionarioDAO().FuncionariosPorOcupacao(idOcupacao).size(); i++) {
						getPainelGerenciarFuncionario().getDefaultTableModelFuncionario().addRow(new Object[] {
								getFuncionarioDAO().FuncionariosPorOcupacao(idOcupacao).get(i).getCodigo(),
								getFuncionarioDAO().FuncionariosPorOcupacao(idOcupacao).get(i).getCpf(),
								getFuncionarioDAO().FuncionariosPorOcupacao(idOcupacao).get(i).getNome(),
								getOcupacaoDAO().OcupacaoPorId(
										getFuncionarioDAO().FuncionariosPorOcupacao(idOcupacao).get(i).getIdOcupacao())
										.getOcupacao(),
								getFuncionarioDAO().FuncionariosPorOcupacao(idOcupacao).get(i).getEmail() });
						cont++;
					}
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(getFrameGerenciarFuncionario(), "Campo não preenchido corretamente",
						"Pesquisa", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (cont == 0) {
			JOptionPane.showMessageDialog(getFrameGerenciarFuncionario(), "Funcionario inexistente", "Pesquisa",
					JOptionPane.ERROR_MESSAGE);
		}
		cont = 0;
	}

	private void LinhaSelecionada() {
		int codigo = (int) getPainelGerenciarFuncionario().getJTableFuncionario()
				.getValueAt(getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow(), 0);
		getPainelGerenciarFuncionario().getJTextFieldCodigo().setText(Integer.toString(codigo));
		getPainelGerenciarFuncionario().getJTextFieldNome()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNome());
		getPainelGerenciarFuncionario().getJTextFieldCPF()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCpf());
		getPainelGerenciarFuncionario().getJTextFieldRG()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getRg());
		getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getOrgaoEmissor());
		getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao()
				.setDate(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getDtEmissao());
		getPainelGerenciarFuncionario().getJComboBoxEstadoCivil()
				.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getEstadoCivil());
		getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento()
				.setDate(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getDtNascimento());
		getPainelGerenciarFuncionario().getJTextFieldNacionalidade()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNacionalidade());
		getPainelGerenciarFuncionario().getjComboBoxUFDoc()
				.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getUfDoc());
		getPainelGerenciarFuncionario().getJTextFieldNaturalidade()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNaturalidade());
		getPainelGerenciarFuncionario().getjComboBoxSexo()
				.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSexo());
		getPainelGerenciarFuncionario().getJDateChooserCadastradoEm()
				.setDate(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCadastradoEm());
		getPainelGerenciarFuncionario().getJTextFieldCEP()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCep());
		getPainelGerenciarFuncionario().getJTextFieldLogradouro()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getLogradouro());
		getPainelGerenciarFuncionario().getJTextFieldNumero()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNumero());
		getPainelGerenciarFuncionario().getJTextFieldComplemento()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getComplemento());
		getPainelGerenciarFuncionario().getJTextFieldBairro()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getBairro());
		getPainelGerenciarFuncionario().getJTextFieldMunicipio()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getMunicipio());
		getPainelGerenciarFuncionario().getjComboBoxUF()
				.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getUf());
		getPainelGerenciarFuncionario().getjComboBoxOcupacao().setSelectedItem(getOcupacaoDAO()
				.OcupacaoPorId(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getIdOcupacao()).getOcupacao());
		getPainelGerenciarFuncionario().getJTextFieldEmail()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getEmail());
		getPainelGerenciarFuncionario().getJTextFieldTelefone()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getTelefone());
		getPainelGerenciarFuncionario().getJTextFieldCelular()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCelular());
		getPainelGerenciarFuncionario().getJTextFieldSalario()
				.setText(Double.toString(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSalario()));
		getPainelGerenciarFuncionario().getJTextFieldSenha()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSenha());
		getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha()
				.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSenha());
	}

	private void LinhaSelecionada(String sinal) {
		try {
			alterarFuncionario = true;
			int codigo = -1;
			if (sinal.equals("+")) {
				codigo = (int) getPainelGerenciarFuncionario().getJTableFuncionario()
						.getValueAt(getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() + 1, 0);
			}
			if (sinal.equals("-")) {
				codigo = (int) getPainelGerenciarFuncionario().getJTableFuncionario()
						.getValueAt(getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() - 1, 0);
			}
			getPainelGerenciarFuncionario().getJTextFieldCodigo().setText(Integer.toString(codigo));
			getPainelGerenciarFuncionario().getJTextFieldNome()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNome());
			getPainelGerenciarFuncionario().getJTextFieldCPF()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCpf());
			getPainelGerenciarFuncionario().getJTextFieldRG()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getRg());
			getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getOrgaoEmissor());
			getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao()
					.setDate(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getDtEmissao());
			getPainelGerenciarFuncionario().getJComboBoxEstadoCivil()
					.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getEstadoCivil());
			getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento()
					.setDate(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getDtNascimento());
			getPainelGerenciarFuncionario().getJTextFieldNacionalidade()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNacionalidade());
			getPainelGerenciarFuncionario().getjComboBoxUFDoc()
					.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getUfDoc());
			getPainelGerenciarFuncionario().getJTextFieldNaturalidade()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNaturalidade());
			getPainelGerenciarFuncionario().getjComboBoxSexo()
					.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSexo());
			getPainelGerenciarFuncionario().getJDateChooserCadastradoEm()
					.setDate(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCadastradoEm());
			getPainelGerenciarFuncionario().getJTextFieldCEP()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCep());
			getPainelGerenciarFuncionario().getJTextFieldLogradouro()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getLogradouro());
			getPainelGerenciarFuncionario().getJTextFieldNumero()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getNumero());
			getPainelGerenciarFuncionario().getJTextFieldComplemento()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getComplemento());
			getPainelGerenciarFuncionario().getJTextFieldBairro()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getBairro());
			getPainelGerenciarFuncionario().getJTextFieldMunicipio()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getMunicipio());
			getPainelGerenciarFuncionario().getjComboBoxUF()
					.setSelectedItem(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getUf());
			getPainelGerenciarFuncionario().getjComboBoxOcupacao().setSelectedItem(getOcupacaoDAO()
					.OcupacaoPorId(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getIdOcupacao()).getOcupacao());
			getPainelGerenciarFuncionario().getJTextFieldEmail()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getEmail());
			getPainelGerenciarFuncionario().getJTextFieldTelefone()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getTelefone());
			getPainelGerenciarFuncionario().getJTextFieldCelular()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getCelular());
			getPainelGerenciarFuncionario().getJTextFieldSalario()
					.setText(Double.toString(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSalario()));
			getPainelGerenciarFuncionario().getJTextFieldSenha()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSenha());
			getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha()
					.setText(getFuncionarioDAO().FuncionarioPorCodigo(codigo).getSenha());
		} catch (Exception e) {

		}
	}

	public static FrameGerenciarFuncionario getFrameGerenciarFuncionario() {
		if (frameGerenciarFuncionario == null) {
			frameGerenciarFuncionario = new FrameGerenciarFuncionario();
		}
		return frameGerenciarFuncionario;
	}

	public static PainelGerenciarFuncionario getPainelGerenciarFuncionario() {
		if (painelGerenciarFuncionario == null) {
			painelGerenciarFuncionario = new PainelGerenciarFuncionario();
		}
		return painelGerenciarFuncionario;
	}

	public static FrameGerenciarOcupacao getFrameGerenciarOcupacao() {
		if (frameGerenciarOcupacao == null) {
			frameGerenciarOcupacao = new FrameGerenciarOcupacao();
		}
		return frameGerenciarOcupacao;
	}

	public static PainelGerenciarOcupacao getPainelGerenciarOcupacao() {
		if (painelGerenciarOcupacao == null) {
			painelGerenciarOcupacao = new PainelGerenciarOcupacao();
		}
		return painelGerenciarOcupacao;
	}

	public static FuncionarioDAO getFuncionarioDAO() {
		if (funcionarioDAO == null) {
			funcionarioDAO = new FuncionarioDAO();
		}
		return funcionarioDAO;
	}

	public static OcupacaoDAO getOcupacaoDAO() {
		if (ocupacaoDAO == null) {
			ocupacaoDAO = new OcupacaoDAO();
		}
		return ocupacaoDAO;
	}

	private void Eventos() {
		// TODO Auto-generated method stub
		getPainelGerenciarFuncionario().getJButtonAddOcupacao().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonIncluir().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonExcluir().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonAlterar().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonConfirmar().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonPesquisar().addActionListener(this);
		getPainelGerenciarFuncionario().getJButtonCancelar().addActionListener(this);
		getPainelGerenciarFuncionario().getJTableFuncionario().addMouseListener(this);
		getPainelGerenciarFuncionario().getJTableFuncionario().addKeyListener(this);
		getFrameGerenciarFuncionario().addWindowListener(this);
	}

	public void Inicio() {
		getPainelGerenciarFuncionario().getJTextFieldCodigo().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldNome().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldCPF().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldRG().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().setEnabled(false);
		getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().getSpinner().setEnabled(false);
		getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().setEnabled(false);
		getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().getSpinner().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldNacionalidade().setEnabled(false);
		getPainelGerenciarFuncionario().getjComboBoxUF().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldNaturalidade().setEnabled(false);
		getPainelGerenciarFuncionario().getjComboBoxSexo().setEnabled(false);
		getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().getSpinner().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldCEP().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldLogradouro().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldNumero().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldComplemento().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldBairro().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldMunicipio().setEnabled(false);
		getPainelGerenciarFuncionario().getjComboBoxUFDoc().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldEmail().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldTelefone().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldCelular().setEnabled(false);
		getPainelGerenciarFuncionario().getjComboBoxOcupacao().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldSalario().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldSenha().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(false);
	}

	public void OpcaoIncluir() {
		getPainelGerenciarFuncionario().getJTextFieldCodigo().setEnabled(false);
		getPainelGerenciarFuncionario().getJTextFieldNome().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldCPF().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldRG().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().setEnabled(true);
		getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().getSpinner().setEnabled(true);
		getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().setEnabled(true);
		getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().getSpinner().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNacionalidade().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxUF().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNaturalidade().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxSexo().setEnabled(true);
		getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().getSpinner().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldCEP().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldLogradouro().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNumero().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldComplemento().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldBairro().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldMunicipio().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldSalario().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldSenha().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxUFDoc().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldEmail().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldTelefone().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldCelular().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNome().grabFocus();
	}

	private void OpcaoAlterar() {
		getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().setEnabled(true);
		getPainelGerenciarFuncionario().getJDateChooserDataDeEmissao().getSpinner().setEnabled(true);
		getPainelGerenciarFuncionario().getJDateChooserDataDeNascimento().getSpinner().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNome().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldCPF().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNacionalidade().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNaturalidade().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxSexo().setEnabled(true);
		getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxUFDoc().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJDateChooserCadastradoEm().getSpinner().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldCEP().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldRG().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldLogradouro().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldComplemento().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldSalario().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldSenha().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldBairro().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldMunicipio().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNumero().setEnabled(true);
		getPainelGerenciarFuncionario().getjComboBoxUF().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldEmail().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldTelefone().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldCelular().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonExcluir().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonIncluir().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonAlterar().setEnabled(false);
		getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarFuncionario().getJTextFieldNome().grabFocus();
	}

	private void LimparCampos() {
		getPainelGerenciarFuncionario().getJTextFieldCodigo().setText("");
		getPainelGerenciarFuncionario().getJTextFieldNome().setText("");
		getPainelGerenciarFuncionario().getJTextFieldCPF().setText("");
		getPainelGerenciarFuncionario().getJTextFieldRG().setText("");
		getPainelGerenciarFuncionario().getJTextFieldOrgaoEmissor().setText("");
		getPainelGerenciarFuncionario().getJComboBoxEstadoCivil().setSelectedIndex(0);
		getPainelGerenciarFuncionario().getJTextFieldBairro().setText("");
		getPainelGerenciarFuncionario().getJTextFieldCelular().setText("");
		getPainelGerenciarFuncionario().getJTextFieldCEP().setText("");
		getPainelGerenciarFuncionario().getJTextFieldComplemento().setText("");
		getPainelGerenciarFuncionario().getJTextFieldSalario().setText("");
		getPainelGerenciarFuncionario().getJTextFieldSenha().setText("");
		getPainelGerenciarFuncionario().getJTextFieldConfirmarSenha().setText("");
		getPainelGerenciarFuncionario().getJTextFieldEmail().setText("");
		getPainelGerenciarFuncionario().getJTextFieldLogradouro().setText("");
		getPainelGerenciarFuncionario().getJTextFieldMunicipio().setText("");
		getPainelGerenciarFuncionario().getJTextFieldNacionalidade().setText("");
		getPainelGerenciarFuncionario().getJTextFieldNaturalidade().setText("");
		getPainelGerenciarFuncionario().getJTextFieldNumero().setText("");
		getPainelGerenciarFuncionario().getJTextFieldTelefone().setText("");
		getPainelGerenciarFuncionario().getjComboBoxSexo().setSelectedIndex(0);
		getPainelGerenciarFuncionario().getjComboBoxUF().setSelectedIndex(0);
		getPainelGerenciarFuncionario().getjComboBoxUFDoc().setSelectedIndex(0);
		getPainelGerenciarFuncionario().getjComboBoxOcupacao().setSelectedIndex(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() > -1) {
				if (!getPainelGerenciarFuncionario().getJTextFieldCelular().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarFuncionario().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarFuncionario().getJButtonAlterar().isEnabled()) {
					LinhaSelecionada("+");
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() > -1) {
				if (!getPainelGerenciarFuncionario().getJTextFieldCelular().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarFuncionario().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarFuncionario().getJButtonAlterar().isEnabled()) {
					LinhaSelecionada("-");
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() > -1) {
				if (!getPainelGerenciarFuncionario().getJTextFieldCelular().isEnabled()) {
					OpcaoTabela();
				}
				if (getPainelGerenciarFuncionario().getJButtonIncluir().isEnabled()
						&& getPainelGerenciarFuncionario().getJButtonAlterar().isEnabled()) {
					LinhaSelecionada("+");
				}
			}
		}
	}

	private void OpcaoTabela() {
		getPainelGerenciarFuncionario().getJButtonAlterar().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonExcluir().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonIncluir().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (getPainelGerenciarFuncionario().getJTableFuncionario().getSelectedRow() > -1) {
			if (!getPainelGerenciarFuncionario().getJTextFieldCelular().isEnabled()) {
				OpcaoTabela();
			}
			if (getPainelGerenciarFuncionario().getJButtonIncluir().isEnabled()
					&& getPainelGerenciarFuncionario().getJButtonAlterar().isEnabled()) {
				LinhaSelecionada();
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		getFrameGerenciarOcupacao().dispose();
		getFrameGerenciarOcupacao().repaint();
		getFrameGerenciarOcupacao().validate();
		getPainelGerenciarFuncionario().getJButtonAddOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonRemoverOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonAlterarOcupacao().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonCancelar().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonConfirmar().setEnabled(true);
		getPainelGerenciarFuncionario().getJButtonPesquisar().setEnabled(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
