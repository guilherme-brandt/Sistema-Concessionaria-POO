public abstract class Venda {
    private int idVenda;
    private Vendedor vendedor;
    private Cliente cliente;
    private Veiculo veiculo;
    private double valor;
    private DataHora dataHora;

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDataHora(DataHora dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getValor() {
        return valor;
    }

    public DataHora getDataHora() {
        return dataHora;
    }

    Venda(int idVenda, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, DataHora dataHora){
        setIdVenda(idVenda);
        setVendedor(vendedor);
        setCliente(cliente);
        setVeiculo(veiculo);
        setValor(valor);
        setDataHora(dataHora);
    }
}
