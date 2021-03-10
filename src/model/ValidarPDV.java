package model;

import view.PainelPDV;

public class ValidarPDV {
	
	
private static PainelPDV painelPDV;
	
	
	public ValidarPDV(PainelPDV painelPDV){
		
		this.painelPDV = painelPDV;
		
	}
	
	public boolean TesteCodigo() {
		try {
			
			int codigo = Integer.parseInt(getPainelPDV().getJTextFieldCodigo().getText());
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	public static PainelPDV getPainelPDV()
	{
		if(painelPDV == null)
		{
			painelPDV = new PainelPDV();
		}
		return painelPDV;
	}

}
