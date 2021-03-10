package model;

import view.PainelConfirmarPagamento;

public class ValidarTelaPagamento {
	
	
	private static PainelConfirmarPagamento painelConfirmarPagamento;
	

		public ValidarTelaPagamento(PainelConfirmarPagamento painelConfirmarPagamento){
				
				this.painelConfirmarPagamento = painelConfirmarPagamento;
				
			}

		public boolean TesteFormaDePagamento() {
			
	
				if(getPainelConfirmarPagamento().getJRadioButtonAVista().isSelected()==false &&
				   getPainelConfirmarPagamento().getJRadioButtonAPrazo().isSelected()==false)
				{
					return true;
				}
				
				
				else
				{
					return false;
				}
				
			
		}
		
		
		public boolean TesteTotalRecebido() {
			try {
				
				double totalrecebido = Double.parseDouble(getPainelConfirmarPagamento().getJTextFieldTotalRecebido().getText());
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		
		public boolean TesteDesconto() {
			try {
				
				double desconto = Double.parseDouble(getPainelConfirmarPagamento().getJTextFieldDesconto().getText());
				
				if(desconto>=1 && desconto<=100)
					return true;
				
				else
					return false;
				
			} catch (NumberFormatException e) {
				return false;
			}
			
		}
		
		public boolean TesteTotalPagar() {
			try {
				
				double totalpagar = Double.parseDouble(getPainelConfirmarPagamento().getJTextFieldTotalPagar().getText());
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		
		public boolean TesteTroco() {
			try {
				
				double troco = Double.parseDouble(getPainelConfirmarPagamento().getJTextFieldTroco().getText());
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		
		

	public static PainelConfirmarPagamento getPainelConfirmarPagamento() {
		if (painelConfirmarPagamento == null) {
			painelConfirmarPagamento = new PainelConfirmarPagamento();
		}
		return painelConfirmarPagamento;
	}

}
