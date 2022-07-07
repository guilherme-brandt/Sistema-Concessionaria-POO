public abstract class Funcionario {
   private String nome;
   private String RG;
   private DataHora dataNasc;
   private DataHora dataAdmissao;
   private double salario;

   private String login;
   private String senha;

   public void setLogin(String login) {
      this.login = login;
   }

   public void setSenha(String senha) {
      this.senha = senha;
   }

   public String getLogin() {
      return login;
   }

   public String getSenha() {
      return senha;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setRG(String RG) {
      this.RG = RG;
   }

   public void setDataNasc(DataHora dataNasc) {
      this.dataNasc = dataNasc;
   }

   public void setDataAdmissao(DataHora dataAdmissao) {
      this.dataAdmissao = dataAdmissao;
   }

   public void setSalario(double salario) {
      this.salario = salario;
   }

   public String getNome() {
      return nome;
   }

   public String getRG() {
      return RG;
   }

   public DataHora getDataNasc() {
      return dataNasc;
   }

   public DataHora getDataAdmissao() {
      return dataAdmissao;
   }

   public double getSalario() {
      return salario;
   }

   Funcionario(String nome, String RG, DataHora dataNasc, DataHora dataAdmissao, double salario, String login, String senha){
      setNome(nome);
      setRG(RG);
      setDataNasc(dataNasc);
      setDataAdmissao(dataAdmissao);
      setSalario(salario);
      setLogin(login);
      setSenha(senha);
   }

   Funcionario(String nome){
      setNome(nome);
   }

   Funcionario(Funcionario funcionario){
      setNome(funcionario.getNome());
      setRG(funcionario.getRG());
      setDataNasc(funcionario.getDataNasc());
      setDataAdmissao(funcionario.getDataAdmissao());
      setSalario(funcionario.getSalario());
   }


}
