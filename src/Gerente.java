public class Gerente extends Funcionario{
    private int anosExp;

    public void setAnosExp(int anosExp) {
        this.anosExp = anosExp;
    }

    public int getAnosExp() {
        return anosExp;
    }

    Gerente(String nome, String RG, DataHora dataNasc, DataHora dataAdmissao, double salario, int anosExp, String login, String senha){
        super(nome,RG, dataNasc, dataAdmissao,salario, login, senha);
        setAnosExp(anosExp);
    }

    Gerente(Gerente gerente){
        super(gerente.getNome(), gerente.getRG(), gerente.getDataNasc(), gerente.getDataAdmissao(), gerente.getSalario(), gerente.getLogin(), gerente.getSenha());
        setAnosExp(gerente.getAnosExp());
    }

    Gerente(String nulo){
        super(nulo);
    }

}
