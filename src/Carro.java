public class Carro extends Veiculo{
    private double potencia;
    private int cilindros;
    private int ocupantes;
    private char tipo;
    private double altura;
    private double largura;
    private double comprimento;

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public double getPotencia() {
        return potencia;
    }

    public int getCilindros() {
        return cilindros;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public char getTipo() {
        return tipo;
    }

    public double getAltura() {
        return altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    Carro(String chassi, String marca, String modelo, int ano, char combustivel, double quilometragem, double peso, double potencia, int cilindros, int ocupantes, char tipo, double altura, double largura, double comprimento){
        super(chassi, marca, modelo, ano, combustivel, quilometragem, peso);
        setPotencia(potencia);
        setCilindros(cilindros);
        setOcupantes(ocupantes);
        setTipo(tipo);
        setAltura(altura);
        setLargura(largura);
        setComprimento(comprimento);
    }

    Carro(Veiculo carro){
        super(carro);

    }

    Carro(String marca, String modelo, int ano){
        super(marca, modelo, ano);
    }
}
