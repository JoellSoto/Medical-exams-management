public interface ConstrutorTabela{
	public abstract int pesquisarAnaliseT(int id);
	public abstract String[][] dadosDoElementoT(int posicao);

	public abstract String[][] quantidades();
	public abstract String[][] todasAnalises();

	public abstract String[][] valorGanho();
	public abstract String[][] valorGanhoSeguros();

	public abstract String[][] todasBioquimica();
	public abstract String[][] colesterolAlto();

	public abstract String[][] todasHematologia();
	public abstract String[][] anemia();

	public abstract String[][] todasMicrobiologia();
	public abstract String[][] infeccao();
	public abstract void ordenarPorData();

	public abstract String lucroPrejuizo();
}