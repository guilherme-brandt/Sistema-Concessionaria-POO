public abstract class Veiculo {
    private String chassi;
    private String marca;
    private String modelo;
    private int ano;
    private double quilometragem;
    private char combustivel;
    private double peso;
    private boolean vendido = false;

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public void setCombustivel(char combustivel) {
        this.combustivel = combustivel;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getChassi() {
        return chassi;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public char getCombustivel() {
        return combustivel;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public double getPeso() {
        return peso;
    }

    Veiculo(String chassi, String marca, String modelo, int ano, char combustivel, double quilometragem, double peso){
        setChassi(chassi);
        setMarca(marca);
        setModelo(modelo);
        setAno(ano);
        setCombustivel(combustivel);
        setQuilometragem(quilometragem);
        setPeso(peso);
    }

    Veiculo(Veiculo veiculo){
        setChassi(veiculo.getChassi());
        setMarca(veiculo.getMarca());
        setModelo(veiculo.getModelo());
        setAno(veiculo.getAno());
        setCombustivel(veiculo.getCombustivel());
        setQuilometragem(veiculo.getQuilometragem());
        setPeso(veiculo.getPeso());
    }

    Veiculo(String marca, String modelo, int ano){
        setMarca(marca);
        setModelo(modelo);
        setAno(ano);
    }

}
