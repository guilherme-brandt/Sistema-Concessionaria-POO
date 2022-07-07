public class Cliente {
    private String nome;
    private String cpf;
    private DataHora nascimento;
    private String rua;
    private int numero;
    private String cidade;
    private double renda;
    private String dependentes;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNascimento(DataHora nascimento) {
        this.nascimento = nascimento;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public void setDependentes(String dependentes) {
        this.dependentes = dependentes;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public DataHora getNascimento() {
        return nascimento;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public double getRenda() {
        return renda;
    }

    public String getDependentes() {
        return dependentes;
    }
    Cliente(String nome, String cpf, DataHora nascimento, String rua, int numero, String cidade, double renda, String dependentes){
        setNome(nome);
        setCpf(cpf);
        setNascimento(nascimento);
        setRua(rua);
        setNumero(numero);
        setCidade(cidade);
        setRenda(renda);
        setDependentes(dependentes);
    }

    Cliente(Cliente cliente){
        setNome(cliente.getNome());
        setCpf(cliente.getCpf());
        setNascimento(cliente.getNascimento());
        setRua(cliente.getRua());
        setNumero(cliente.getNumero());
        setCidade(cliente.getCidade());
        setRenda(cliente.getRenda());
        setDependentes(cliente.getDependentes());
    }

    Cliente(String nome,String cpf){
        setNome(nome);
        setCpf(cpf);
    }

}
