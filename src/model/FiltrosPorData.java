package model;

public enum FiltrosPorData {
	TODO_PEROODO("Todo o Período"),
	ANUAL("Anual"),
	SEMESTRAL("Semestral"),
	MENSAL("Mensal"),
	PERSONALIZADO("Personalizado");
	
	private String mensagem;
	
	private FiltrosPorData(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
        return mensagem;
    }
	
	@Override
    public String toString() {
        return mensagem;
    }
}
