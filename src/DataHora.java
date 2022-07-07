public class DataHora {
    private int dia;
    private int mes;
    private int ano;
    private String horario;

    public void setDia(int dia) {
        if(dia>=1 && dia<=31){
            this.dia = dia;
        }
        else{
            System.out.println("Atenção: Dia inválido!");
        }
    }

    public void setMes(int mes) {
        if(mes>=1 && mes<=12){
            this.mes = mes;
        }
        else{
            System.out.println("Atenção: Mês inválido!");
        }
    }

    public void setAno(int ano) {
        if(ano>=1950 && ano<=2050){
            this.ano = ano;
        }
        else{
            System.out.println("Atenção: Ano inválido!");
        }
    }

    public void setHorario(String horario) {

        String[] array;
        array = horario.split(":");
        int horas = Integer.parseInt(array[0]);
        int minutos = Integer.parseInt(array[1]);

        if(horas>=0 && horas<=23 && minutos>=0 && minutos<=59){
            this.horario = horario;
        }
        else{
            System.out.println("Atenção: Horário inválido!");
        }
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getDia() {
        return dia;
    }
    public String getHorario(){
        return horario;
    }
    DataHora(int dia, int mes, int ano, String horario){
        setDia(dia);
        setMes(mes);
        setAno(ano);
        setHorario(horario);
    }
    DataHora(DataHora dataHora){
        setDia(dataHora.dia);
        setMes(dataHora.mes);
        setAno(dataHora.ano);
        setHorario(dataHora.horario);
    }
}
