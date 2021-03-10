/**
 * Autor Robson
 * classe para formata��o de mascara para o componente JFormattedTextField uma 
 * homenagem a Remix que duvidou que eu faria uma classe t�o besta como essa 
 */
package model;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class FormataMascaras {
	public MaskFormatter mascara = null;

	// construtor padrao
	void Formata(String formato) {
		try {
			mascara = new MaskFormatter(formato);
		} catch (ParseException exc) {
		}
	}

	// construtor que recebe uma String para o formato da mascara

	// retorna a mascara com o formato inserido pelo usuario

	// retorna mascara CPF
	public DefaultFormatterFactory getCPF() {
		Formata("###.###.###-##");
		return new DefaultFormatterFactory(mascara);
	}

	public DefaultFormatterFactory getSenha() {
		Formata("########");
		return new DefaultFormatterFactory(mascara);
	}

	public static boolean validar(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	public DefaultFormatterFactory getCNPJ() {
		Formata("##.###.###/####-##");
		return new DefaultFormatterFactory(mascara);
	}

	public DefaultFormatterFactory getPorcentagem() {
		Formata("###,##%");
		return new DefaultFormatterFactory(mascara);
	}

	public DefaultFormatterFactory getHora() {
		Formata("##:##");
		return new DefaultFormatterFactory(mascara);
	}

	// retorna m�scara telefone
	public DefaultFormatterFactory getTelefone() {
		Formata("(##) ####-####");
		return new DefaultFormatterFactory(mascara);
	}

	public DefaultFormatterFactory getCelular() {
		Formata("(##) #####-####");
		return new DefaultFormatterFactory(mascara);
	}

	// retorna m�scara CEP
	public DefaultFormatterFactory getCEP() {
		Formata("##.###-###");
		return new DefaultFormatterFactory(mascara);
	}

	// retorna m�scara Data
	public DefaultFormatterFactory getData() {
		Formata("##-##-####");
		return new DefaultFormatterFactory(mascara);
	}

	// retorna m�scara Ano
	public DefaultFormatterFactory getAno() {
		Formata("####");
		return new DefaultFormatterFactory(mascara);
	}

	// retorna m�scara RG
	public DefaultFormatterFactory getRG() {
		Formata("##.###.###-##");
		return new DefaultFormatterFactory(mascara);
	}

	// retorna m�scara Chassi
	public DefaultFormatterFactory getChassi() {
		Formata("###.######.##.######");
		return new DefaultFormatterFactory(mascara);
	}

	public DefaultFormatterFactory getMatriculaAluno() {
		Formata("#########");
		return new DefaultFormatterFactory(mascara);
	}
} // fim da classe FormataMascaras
