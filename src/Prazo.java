public class Prazo extends Venda{
    private int parcelas;
    private double juros;

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public int getParcelas() {
        return parcelas;
    }

    public double getJuros() {
        return juros;
    }

    Prazo(int idVenda, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, DataHora dataHora, int parcelas, double juros){
        super(idVenda, vendedor, cliente, veiculo, valor, dataHora);
        setParcelas(parcelas);
        setJuros(juros);
    }

    Prazo(int idVenda, Vendedor vendedor, Cliente cliente, Carro carro, double valor, DataHora dataHora, int parcelas, double juros){
        super(idVenda, vendedor, cliente,carro, valor, dataHora);
        setParcelas(parcelas);
        setJuros(juros);
    }
}
