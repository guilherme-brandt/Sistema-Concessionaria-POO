public class Motocicleta extends Veiculo{
    private int cilindradas;
    private char tipo;

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public char getTipo() {
        return tipo;
    }

    Motocicleta(String chassi, String marca, String modelo, int ano, char combustivel, double quilometragem, double peso, int cilindradas, char tipo){
        super(chassi, marca, modelo, ano, combustivel, quilometragem, peso);
        setCilindradas(cilindradas);
        setTipo(tipo);
    }

    Motocicleta(Veiculo moto){
        super(moto);

    }
}
