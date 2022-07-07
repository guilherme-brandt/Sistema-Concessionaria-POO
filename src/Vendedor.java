public class Vendedor extends Funcionario{
    private Gerente responsavel;
    private int tempoTreino;

    public void setResponsavel(Gerente responsavel) {
        this.responsavel = responsavel;
    }

    public void setTempoTreino(int tempoTreino) {
        this.tempoTreino = tempoTreino;
    }

    public Gerente getResponsavel() {
        return responsavel;
    }

    public int getTempoTreino() {
        return tempoTreino;
    }


    Vendedor(String nome, String RG, DataHora dataNasc, DataHora dataAdmissao, double salario, Gerente responsavel, int tempoTreino, String login, String senha){
        super(nome,RG, dataNasc, dataAdmissao,salario,login, senha);
        setResponsavel(responsavel);
        setTempoTreino(tempoTreino);
    }

    Vendedor(Vendedor vendedor){
        super(vendedor.getNome(), vendedor.getRG(), vendedor.getDataNasc(), vendedor.getDataAdmissao(), vendedor.getSalario(), vendedor.getLogin(), vendedor.getSenha());
        setResponsavel(vendedor.getResponsavel());
        setTempoTreino(vendedor.getTempoTreino());
    }

    Vendedor(String nome){
        super(nome);
    }

}
