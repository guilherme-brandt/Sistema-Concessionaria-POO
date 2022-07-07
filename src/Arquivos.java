import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Arquivos {
    public void gravaDadosGerentes(ArrayList<Gerente> gerentes) {
        try {

            FileWriter arq = new FileWriter("gerentes.txt");
            PrintWriter gravaArq = new PrintWriter(arq);

            for (Gerente value : gerentes) {

                DataHora dataNascimento = new DataHora(value.getDataNasc());
                DataHora dataAdmissao = new DataHora(value.getDataAdmissao());
                gravaArq.println(value.getNome() + "\t" + value.getRG() + "\t" + dataNascimento.getDia() + "/" + dataNascimento.getMes() + "/" + dataNascimento.getAno() + "-" + dataNascimento.getHorario() + "\t" + dataAdmissao.getDia() + "/" + dataAdmissao.getMes() + "/" + dataAdmissao.getAno() + "-" + dataAdmissao.getHorario() + "\t" + value.getSalario() + "\t" + value.getAnosExp()+"\t"+value.getLogin()+"\t"+value.getSenha());
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Erro na gravação dos dados");
        }
    }

    public void lerDadosGerentes(ArrayList<Gerente> gerentes) {
        try {

            FileReader arq = new FileReader("gerentes.txt");
            BufferedReader leitor = new BufferedReader(arq);

            while (leitor.ready()) {

                String[] aux = leitor.readLine().split("\t");

                String nome = aux[0];
                String RG = aux[1];

                String[] dataNascimento = aux[2].split("/");
                String[] dataNascimentoAux = dataNascimento[2].split("-");
                int diaNasc = Integer.parseInt(dataNascimento[0]);
                int mesNasc = Integer.parseInt(dataNascimento[1]);
                int anoNasc = Integer.parseInt(dataNascimentoAux[0]);
                DataHora dataHora1 = new DataHora(diaNasc, mesNasc, anoNasc, dataNascimentoAux[1]);

                String[] dataAdmissao = aux[3].split("/");
                String[] dataAdmissaoAux = dataAdmissao[2].split("-");
                int diaAdmissao = Integer.parseInt(dataAdmissao[0]);
                int mesAdmissao = Integer.parseInt(dataAdmissao[1]);
                int anoAdmissao = Integer.parseInt(dataAdmissaoAux[0]);
                DataHora dataHora2 = new DataHora(diaAdmissao, mesAdmissao, anoAdmissao, dataAdmissaoAux[1]);

                double salario = Double.parseDouble(aux[4]);
                int anosExp = Integer.parseInt(aux[5]);

                String login = aux[6];
                String senha = aux[7];
                Gerente gerente = new Gerente(nome, RG, dataHora1, dataHora2, salario, anosExp, login, senha);
                gerentes.add(gerente);

            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Atenção: ainda não há registro de gerentes no sistema");
        }catch (IndexOutOfBoundsException ee){

        }
    }

    public void gravaDadosVendedores(ArrayList<Vendedor> vendedores) {
        try {

            FileWriter arq = new FileWriter("vendedores.txt");
            PrintWriter gravaArq = new PrintWriter(arq);

            for (Vendedor value : vendedores) {

                DataHora dataNascimento = new DataHora(value.getDataNasc());
                DataHora dataAdmissao = new DataHora(value.getDataAdmissao());
                Gerente responsavel = new Gerente(value.getResponsavel());
                gravaArq.println(value.getNome() + "\t" + value.getRG() + "\t" + dataNascimento.getDia() + "/" + dataNascimento.getMes() + "/" + dataNascimento.getAno() + "-" + dataNascimento.getHorario() + "\t" + dataAdmissao.getDia() + "/" + dataAdmissao.getMes() + "/" + dataAdmissao.getAno() + "-" + dataAdmissao.getHorario() + "\t" + value.getSalario() + "\t" + value.getTempoTreino() + "\t" + responsavel.getNome()+"\t"+value.getLogin()+"\t"+value.getSenha());
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Erro na gravação dos dados");
        }
    }

    public void lerDadosVendedores(ArrayList<Vendedor> vendedores, ArrayList<Gerente> gerentes) {
        try {

            FileReader arq = new FileReader("vendedores.txt");
            BufferedReader leitor = new BufferedReader(arq);

            while (leitor.ready()) {

                String[] aux = leitor.readLine().split("\t");

                String nome = aux[0];
                String RG = aux[1];

                String[] dataNascimento = aux[2].split("/");
                String[] dataNascimentoAux = dataNascimento[2].split("-");
                int diaNasc = Integer.parseInt(dataNascimento[0]);
                int mesNasc = Integer.parseInt(dataNascimento[1]);
                int anoNasc = Integer.parseInt(dataNascimentoAux[0]);
                DataHora dataHora1 = new DataHora(diaNasc, mesNasc, anoNasc, dataNascimentoAux[1]);

                String[] dataAdmissao = aux[3].split("/");
                String[] dataAdmissaoAux = dataAdmissao[2].split("-");
                int diaAdmissao = Integer.parseInt(dataAdmissao[0]);
                int mesAdmissao = Integer.parseInt(dataAdmissao[1]);
                int anoAdmissao = Integer.parseInt(dataAdmissaoAux[0]);
                DataHora dataHora2 = new DataHora(diaAdmissao, mesAdmissao, anoAdmissao, dataAdmissaoAux[1]);

                double salario = Double.parseDouble(aux[4]);
                int tempoTreino = Integer.parseInt(aux[5]);


                Gerente responsavel = null;
                for (Gerente value : gerentes) {
                    if (aux[6].equalsIgnoreCase(value.getNome())) {

                        responsavel = new Gerente(value);
                    }
                }

                String login = aux[7];
                String senha = aux[8];

                Vendedor vendedor = new Vendedor(nome, RG, dataHora1, dataHora2, salario, responsavel, tempoTreino, login, senha);
                vendedores.add(vendedor);


            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Atenção: ainda não há registro de vendedores no sistema");
        }catch (IndexOutOfBoundsException ee){

        }
    }

    public void gravaDadosCarros(ArrayList<Carro> carros) {

        try {

            FileWriter arq = new FileWriter("carros.txt");
            PrintWriter gravaArq = new PrintWriter(arq);

            for (Carro value : carros) {

                gravaArq.println(value.getChassi() + "\t" + value.getMarca() + "\t" + value.getModelo() + "\t" + value.getAno() + "\t" + value.getCombustivel() + "\t" + value.getQuilometragem() + "\t" + value.getPeso() + "\t" + value.getPotencia() + "\t" + value.getCilindros() + "\t" + value.getOcupantes() + "\t" + value.getTipo() + "\t" + value.getAltura() + "\t" + value.getLargura() + "\t" + value.getComprimento());
            }
            arq.close();
        }catch(IOException e){
                System.err.println("Erro na gravação dos dados");
        }
    }

    public void gravaDadosMotos(ArrayList<Motocicleta> motos) {

        try {

            FileWriter arq = new FileWriter("motos.txt");
            PrintWriter gravaArq = new PrintWriter(arq);

            for (Motocicleta value : motos) {

                gravaArq.println(value.getChassi() + "\t" + value.getMarca() + "\t" + value.getModelo() + "\t" + value.getAno() + "\t" + value.getCombustivel() + "\t" + value.getQuilometragem() + "\t" + value.getPeso() + "\t" + value.getCilindradas() + "\t" + value.getTipo());
            }
            arq.close();
        }catch(IOException e){
            System.err.println("Erro na gravação dos dados");
        }
    }
    public void lerDadosCarros(ArrayList<Carro> carros) {
        try {

            FileReader arq = new FileReader("carros.txt");
            BufferedReader leitor = new BufferedReader(arq);

            while (leitor.ready()) {

                String[] aux = leitor.readLine().split("\t");

                String chassi = aux[0];
                String marca = aux[1];
                String modelo = aux[2];
                char combustivel = aux[4].charAt(0);
                double quilometragem = Double.parseDouble(aux[5]);
                double peso = Double.parseDouble(aux[6]);
                int ano = Integer.parseInt(aux[3]);
                double potencia = Double.parseDouble(aux[7]);
                int cilindros = Integer.parseInt(aux[8]);
                int ocupantes = Integer.parseInt(aux[9]);
                char tipo = aux[10].charAt(0);
                double altura = Double.parseDouble(aux[11]);
                double largura = Double.parseDouble(aux[12]);
                double comprimento = Double.parseDouble(aux[13]);

                Carro carro = new Carro(chassi, marca, modelo, ano, combustivel, quilometragem, peso, potencia, cilindros, ocupantes, tipo, altura, largura, comprimento);
                carros.add(carro);

            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Atenção: ainda não há registro de carros no sistema");
        }
    }

    public void lerDadosMotos(ArrayList<Motocicleta> motos) {
        try {

            FileReader arq = new FileReader("motos.txt");
            BufferedReader leitor = new BufferedReader(arq);

            while (leitor.ready()) {

                String[] aux = leitor.readLine().split("\t");

                String chassi = aux[0];
                String marca = aux[1];
                String modelo = aux[2];
                char combustivel = aux[4].charAt(0);
                double quilometragem = Double.parseDouble(aux[5]);
                double peso = Double.parseDouble(aux[6]);
                int ano = Integer.parseInt(aux[3]);
                int cilindradas = Integer.parseInt(aux[7]);
                char tipo = aux[8].charAt(0);
                Motocicleta moto = new Motocicleta(chassi, marca, modelo, ano, combustivel, quilometragem, peso,  cilindradas,tipo);
                motos.add(moto);

            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Atenção: ainda não há registro de motos no sistema");
        }
    }

    public void gravaDadosClientes(ArrayList<Cliente> clientes) {
        try {

            FileWriter arq = new FileWriter("clientes.txt");
            PrintWriter gravaArq = new PrintWriter(arq);

            for (Cliente value : clientes) {

                DataHora dataNascimento = new DataHora(value.getNascimento());
                gravaArq.println(value.getNome() + "\t" + value.getCpf() + "\t" + dataNascimento.getDia() + "/" + dataNascimento.getMes() + "/" + dataNascimento.getAno() + "-" + dataNascimento.getHorario() + "\t" + value.getRua()+"\t"+ value.getNumero()+"\t"+value.getCidade()+"\t"+value.getRenda()+"\t"+value.getDependentes());
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Erro na gravação dos dados");
        }
    }

    public void lerDadosClientes(ArrayList<Cliente> clientes) {
        try {

            FileReader arq = new FileReader("clientes.txt");
            BufferedReader leitor = new BufferedReader(arq);

            while (leitor.ready()) {

                String[] aux = leitor.readLine().split("\t");

                String nome = aux[0];
                String cpf = aux[1];

                String[] dataNascimento = aux[2].split("/");
                String[] dataNascimentoAux = dataNascimento[2].split("-");
                int diaNasc = Integer.parseInt(dataNascimento[0]);
                int mesNasc = Integer.parseInt(dataNascimento[1]);
                int anoNasc = Integer.parseInt(dataNascimentoAux[0]);
                DataHora dataHora1 = new DataHora(diaNasc, mesNasc, anoNasc, dataNascimentoAux[1]);

                String rua = aux[3];
                int numero = Integer.parseInt(aux[4]);
                String cidade = aux[5];

                double renda = Double.parseDouble(aux[6]);

                String dependentes = aux[7];

                Cliente cliente = new Cliente(nome, cpf, dataHora1, rua, numero, cidade, renda, dependentes);
                clientes.add(cliente);
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Atenção: ainda não há registro de clientes no sistema");
        }
    }

    public void gravaDadosVista(ArrayList<Vista> vistas) {
        try {

            FileWriter arq = new FileWriter("vistas.txt");
            PrintWriter gravaArq = new PrintWriter(arq);

            for (Vista value : vistas) {

                DataHora dataHora = new DataHora(value.getDataHora());
                Vendedor vendedor = new Vendedor(value.getVendedor());
                Cliente cliente = new Cliente(value.getCliente());

                if(value.getVeiculo() instanceof Carro){
                    Carro carro = new Carro(value.getVeiculo());
                    gravaArq.println(value.getIdVenda() +"\t"+vendedor.getNome()+"\t"+ cliente.getNome()+":"+cliente.getCpf()+"\t"+carro.getMarca()+" "+carro.getModelo()+" "+carro.getAno()+"\t" + value.getValor() + "\t" + dataHora.getDia() + "/" + dataHora.getMes() + "/" + dataHora.getAno() + "-" + dataHora.getHorario()+"\t"+value.getDesconto());

                }
                else{
                    Motocicleta moto = new Motocicleta(value.getVeiculo());
                    gravaArq.println(value.getIdVenda() +"\t"+vendedor.getNome()+"\t"+ cliente.getNome()+":"+cliente.getCpf()+"\t"+moto.getMarca()+" "+moto.getModelo()+" "+moto.getAno()+"\t" + value.getValor()*value.getDesconto() + "\t" + dataHora.getDia() + "/" + dataHora.getMes() + "/" + dataHora.getAno() + "-" + dataHora.getHorario());
                }
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Erro na gravação dos dados");
        }
    }

    public void gravaDadosPrazo(ArrayList<Prazo> prazos) {
        try {

            FileWriter arq = new FileWriter("prazos.txt");
            PrintWriter gravaArq = new PrintWriter(arq);

            for (Prazo value : prazos) {

                DataHora dataHora = new DataHora(value.getDataHora());
                Vendedor vendedor = new Vendedor(value.getVendedor());
                Cliente cliente = new Cliente(value.getCliente());

                if(value.getVeiculo() instanceof Carro){
                    Carro carro = new Carro(value.getVeiculo());
                    gravaArq.println(value.getIdVenda() +"\t"+vendedor.getNome()+"\t"+ cliente.getNome()+":"+cliente.getCpf()+"\t"+carro.getMarca()+" "+carro.getModelo()+" "+carro.getAno()+"\t" + value.getValor()+"/"+value.getParcelas() + "x juros de "+value.getJuros()+"% ao mês"+"\t" + dataHora.getDia() + "/" + dataHora.getMes() + "/" + dataHora.getAno() + "-" + dataHora.getHorario());

                }
                else{
                    Motocicleta moto = new Motocicleta(value.getVeiculo());
                    gravaArq.println(value.getIdVenda() +"\t"+vendedor.getNome()+"\t"+ cliente.getNome()+":"+cliente.getCpf()+"\t"+moto.getMarca()+" "+moto.getModelo()+" "+moto.getAno()+"\t" + value.getValor()+"/"+value.getParcelas() +"x juros de"+ value.getJuros() +"% ao mês"+"\t" + dataHora.getDia() + "/" + dataHora.getMes() + "/" + dataHora.getAno() + "-" + dataHora.getHorario());
                }
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Erro na gravação dos dados");
        }
    }

    public void lerDadosVista(ArrayList<Vista> vistas) {
        try {

            FileReader arq = new FileReader("vistas.txt");
            BufferedReader leitor = new BufferedReader(arq);

            while (leitor.ready()) {

                String[] aux = leitor.readLine().split("\t");

                int idVenda  = Integer.parseInt(aux[0]);

                Vendedor vendedor = new Vendedor(aux[1]);

                String[] clienteAux = aux[2].split(":");
                Cliente cliente = new Cliente(clienteAux[0], clienteAux[1]);

                String[] veiculoAux = aux[3].split(" ");
                int anoVeiculo = Integer.parseInt(veiculoAux[2]);
                Carro carro = new Carro(veiculoAux[0], veiculoAux[1], anoVeiculo);

                double valor = Double.parseDouble(aux[4]);
                String[] dataVenda = aux[5].split("/");
                String[] dataVendaAux = dataVenda[2].split("-");
                int diaVenda = Integer.parseInt(dataVenda[0]);
                int mesVenda = Integer.parseInt(dataVenda[1]);
                int anoVenda = Integer.parseInt(dataVendaAux[0]);
                DataHora dataHora1 = new DataHora(diaVenda, mesVenda, anoVenda, dataVendaAux[1]);

                Vista vista = new Vista(idVenda, vendedor, cliente, carro, valor, dataHora1);
                vistas.add(vista);

            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Atenção: ainda não há registro de vendas à vista no sistema");
        }
    }

    public void lerDadosPrazo(ArrayList<Prazo> prazos) {
        try {

            FileReader arq = new FileReader("prazos.txt");
            BufferedReader leitor = new BufferedReader(arq);

            while (leitor.ready()) {

                String[] aux = leitor.readLine().split("\t");

                int idVenda = Integer.parseInt(aux[0]);

                Vendedor vendedor = new Vendedor(aux[1]);

                String[] clienteAux = aux[2].split(":");
                Cliente cliente = new Cliente(clienteAux[0], clienteAux[1]);

                String[] veiculoAux = aux[3].split(" ");
                int anoVeiculo = Integer.parseInt(veiculoAux[2]);
                Carro carro = new Carro(veiculoAux[0], veiculoAux[1], anoVeiculo);

                String[] valorAux1 = aux[4].split("/");
                String[] valorAux2 = aux[4].split("x juros de ");
                String[] valorAux3 = valorAux2[0].split("/");
                String[] valorAux4 = valorAux2[1].split("%");
                double valor = Double.parseDouble(valorAux1[0]);
                int parcelas = Integer.parseInt(valorAux3[1]);
                double juros = Double.parseDouble(valorAux4[0]);

                String[] dataVenda = aux[5].split("/");
                String[] dataVendaAux = dataVenda[2].split("-");
                int diaVenda = Integer.parseInt(dataVenda[0]);
                int mesVenda = Integer.parseInt(dataVenda[1]);
                int anoVenda = Integer.parseInt(dataVendaAux[0]);
                DataHora dataHora1 = new DataHora(diaVenda, mesVenda, anoVenda, dataVendaAux[1]);

                Prazo prazo = new Prazo(idVenda, vendedor, cliente, carro, valor, dataHora1, parcelas, juros);
                prazos.add(prazo);

            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Atenção: ainda não há registro de vendas à prazo no sistema");
        }
    }

    public boolean verificaUsuario(String usuario, String senha, ArrayList<Gerente> gerentes, ArrayList<Vendedor> vendedores){
        for(Gerente value: gerentes){
            if(usuario.equalsIgnoreCase(value.getLogin())&&senha.equalsIgnoreCase(value.getSenha())){

                return true;
            }
        }
        for(Vendedor value: vendedores){
            if(usuario.equalsIgnoreCase(value.getLogin())&&senha.equalsIgnoreCase(value.getSenha())){

                return true;
            }
        }
        return false;
    }

    public void desempenhoVendedores(ArrayList<Vendedor> vendedores, ArrayList<Vista> vistas, ArrayList<Prazo> prazos){

        int vendasTotais = 0;
        int vendasVista = 0;
        int vendasPrazo = 0;


        for(Vendedor value1: vendedores){
            vendasTotais = 0;
            vendasVista = 0;
            vendasPrazo = 0;

            for(Vista value2: vistas){
                if(value1.getNome().equalsIgnoreCase(value2.getVendedor().getNome())){
                    vendasTotais++;
                    vendasVista++;

                }

            }
            for (Prazo value3: prazos){
                if (value1.getNome().equalsIgnoreCase(value3.getVendedor().getNome())){
                    vendasTotais++;
                    vendasPrazo++;
                }
            }

            System.out.println(value1.getNome()+" Vendas à vista: "+vendasVista+" Vendas a prazo: "+vendasPrazo+" Vendas totais: "+ vendasTotais);
        }

    }
}




