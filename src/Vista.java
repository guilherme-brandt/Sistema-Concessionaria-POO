
public class Vista extends Venda{
    private double desconto = 1;

    public void setDesconto(double desconto) {
        if (desconto<=1&&desconto>=0.7){
            this.desconto = desconto;
        }
        else{
            this.desconto = 1;
        }

    }

    public double getDesconto() {
        return desconto;
    }

    Vista(int idVenda, Vendedor vendedor, Cliente cliente, Veiculo veiculo, double valor, DataHora dataHora, double desconto){
        super(idVenda, vendedor, cliente, veiculo, valor, dataHora);
        setDesconto(desconto);
    }
    Vista(int idVenda, Vendedor vendedor, Cliente cliente, Carro carro, double valor, DataHora dataHora){
        super(idVenda, vendedor, cliente, carro, valor, dataHora);
    }
    Vista(int idVenda, Vendedor vendedor, Cliente cliente, Motocicleta moto, double valor, DataHora dataHora){
        super(idVenda, vendedor, cliente, moto, valor, dataHora);
    }
}
