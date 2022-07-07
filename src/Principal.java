
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Principal {

    public static void main(String args[]) {


        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        boolean permissao = false;

        Arquivos arquivos = new Arquivos();
        String aux = "";
        while (!permissao) {
            arquivos.lerDadosGerentes(gerentes);
            arquivos.lerDadosVendedores(vendedores, gerentes);
            System.out.println("\tConcessionária José Motors\nSelecione a opção desejada:\n1 - Login\n2 - Cadastro de usuário");
            Scanner sc1 = new Scanner(System.in);
            int comando = sc1.nextInt();

            switch (comando) {
                case 1: {
                    Scanner sc2 = new Scanner(System.in);
                    Scanner sc3 = new Scanner(System.in);

                    System.out.println("Login");
                    System.out.println("Usuário: ");
                    String usuario = sc2.nextLine();
                    aux = usuario;
                    System.out.println("Senha:");
                    String senha = sc3.nextLine();
                    permissao = arquivos.verificaUsuario(usuario, senha, gerentes, vendedores);
                    break;
                }
                case 2: {

                    Scanner sc2 = new Scanner(System.in);
                    Scanner sc3 = new Scanner(System.in);
                    Scanner sc4 = new Scanner(System.in);
                    Scanner sc5 = new Scanner(System.in);
                    Scanner sc6 = new Scanner(System.in);
                    Scanner sc7 = new Scanner(System.in);
                    Scanner sc8 = new Scanner(System.in);
                    System.out.println("O usuário é gerente ou vendedor");
                    char tipo = sc3.nextLine().charAt(0);

                    if (tipo == 'G'|| tipo =='g') {
                        System.out.println("Nome:");
                        String nome = sc2.nextLine();
                        System.out.println("RG:");
                        String RG = sc2.nextLine();
                        System.out.println("Dia do nascimento:");
                        int diaNasc = sc2.nextInt();
                        System.out.println("Mês do nascimento:");
                        int mesNasc = sc3.nextInt();
                        System.out.println("Ano do nascimento:");
                        int anoNasc = sc5.nextInt();
                        System.out.println("Horario do nascimento:");
                        String horarioNasc = sc4.nextLine();
                        DataHora dataHora1 = new DataHora(diaNasc, mesNasc, anoNasc, horarioNasc);

                        System.out.println("Dia da admissão:");
                        int diaAdm = sc4.nextInt();
                        System.out.println("Mês da admissão:");
                        int mesAdm = sc6.nextInt();
                        System.out.println("Ano da admissão:");
                        int anoAdm = sc5.nextInt();
                        System.out.println("Horario da admissão:");
                        String horarioAdm = sc7.nextLine();
                        DataHora dataHora2 = new DataHora(diaAdm, mesAdm, anoAdm, horarioAdm);
                        System.out.println("Salario:");
                        double salario = sc5.nextDouble();
                        System.out.println("Anos de experiência:");
                        int anosExp = sc6.nextInt();
                        System.out.println("Usuario:");
                        String novoUsuario = sc7.nextLine();
                        System.out.println("Senha:");
                        String senhaNovoUsuario = sc8.nextLine();

                        Gerente gerente = new Gerente(nome, RG, dataHora1, dataHora2, salario, anosExp, novoUsuario, senhaNovoUsuario);

                        gerentes.add(gerente);

                    } else if (tipo == 'V'|| tipo == 'v') {
                        System.out.println("Nome:");
                        String nome = sc2.nextLine();
                        System.out.println("RG:");
                        String RG = sc2.nextLine();
                        System.out.println("Dia do nascimento:");
                        int diaNasc = sc2.nextInt();
                        System.out.println("Mês do nascimento:");
                        int mesNasc = sc3.nextInt();
                        System.out.println("Ano do nascimento:");
                        int anoNasc = sc5.nextInt();
                        System.out.println("Horario do nascimento:");
                        String horarioNasc = sc4.nextLine();
                        DataHora dataHora1 = new DataHora(diaNasc, mesNasc, anoNasc, horarioNasc);

                        System.out.println("Dia da admissão:");
                        int diaAdm = sc4.nextInt();
                        System.out.println("Mês da admissão:");
                        int mesAdm = sc6.nextInt();
                        System.out.println("Ano da admissão:");
                        int anoAdm = sc5.nextInt();
                        System.out.println("Horario da admissão:");
                        String horarioAdm = sc7.nextLine();
                        DataHora dataHora2 = new DataHora(diaAdm, mesAdm, anoAdm, horarioAdm);
                        System.out.println("Salario:");
                        double salario = sc5.nextDouble();
                        System.out.println("Gerente Responsável:");
                        String nomeGerenteResponsavel = sc8.nextLine();
                        Gerente responsavel = null;
                        for (Gerente value : gerentes) {
                            if (nomeGerenteResponsavel.equalsIgnoreCase(value.getNome())) {

                                responsavel = new Gerente(value);
                            }
                        }
                        System.out.println("Tempo de treino:");
                        int treino = sc6.nextInt();
                        System.out.println("Usuario:");
                        String novoUsuario = sc7.nextLine();
                        System.out.println("Senha:");
                        String senhaNovoUsuario = sc8.nextLine();

                        Vendedor vendedor = new Vendedor(nome, RG, dataHora1, dataHora2, salario, responsavel, treino, novoUsuario, senhaNovoUsuario);
                        vendedores.add(vendedor);

                    } else {
                        System.out.println("Tipo Invalido!");
                    }
                    arquivos.gravaDadosGerentes(gerentes);
                    arquivos.gravaDadosVendedores(vendedores);
                    arquivos.lerDadosGerentes(gerentes);
                    arquivos.lerDadosVendedores(vendedores, gerentes);
                    break;
                }
                default: {
                    System.out.println("Comando inválido!");
                    break;
                }
            }
        }
        if (permissao) {

            char credencial = ' ';
            for (Gerente value : gerentes) {
                if (aux.equalsIgnoreCase(value.getLogin())) {
                    credencial = 'G';
                    break;
                }
            }
            for (Vendedor value : vendedores) {
                if (aux.equalsIgnoreCase(value.getLogin())) {
                    credencial = 'V';
                    break;
                }
            }
            ArrayList<Cliente> clientes = new ArrayList<>();
            ArrayList<Carro> carros = new ArrayList<>();
            ArrayList<Motocicleta> motos = new ArrayList<>();
            ArrayList<Vista> vendasVista = new ArrayList<>();
            ArrayList<Prazo> vendasPrazo = new ArrayList<>();


            if (credencial == 'G') {
                arquivos.lerDadosClientes(clientes);
                arquivos.lerDadosCarros(carros);
                arquivos.lerDadosMotos(motos);
                arquivos.lerDadosVista(vendasVista);
                arquivos.lerDadosPrazo(vendasPrazo);

                System.out.println("Olá Gerente!");
                int comando = 0;
                Scanner sc = new Scanner(System.in);
                Scanner scc = new Scanner(System.in);
                while (comando != 4) {

                    System.out.println("Selecione a classe desejada:\n\t1 - Clientes\n\t2 - Veículos\n\t3 - Funcionários\n\t4 - Salvar e sair");


                    comando = sc.nextInt();
                    int comando2=0;

                    switch (comando) {
                        case 1: {
                            while(comando2!=4){
                                System.out.println("Clientes:\n\t1 - Cadastrar\n\t2 - Alterar\n\t3 - Excluir\n\t4 - Voltar");
                                comando2 = scc.nextInt();
                                switch (comando2) {
                                    case 1: {
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);
                                        Scanner scanner3 = new Scanner(System.in);
                                        Scanner scanner4 = new Scanner(System.in);
                                        System.out.println("Cadastrar Cliente");
                                        System.out.println("Nome:");
                                        String nome = scanner1.nextLine();
                                        System.out.println("CPF:");
                                        String cpf = scanner1.nextLine();
                                        System.out.println("Dia do nascimento:");
                                        int diaNasc = scanner2.nextInt();
                                        System.out.println("Mês do nascimento:");
                                        int mesNasc = scanner2.nextInt();
                                        System.out.println("Ano de nasciento:");
                                        int anoNasc = scanner2.nextInt();
                                        DataHora dataHora = new DataHora(diaNasc, mesNasc, anoNasc, "00:00");

                                        System.out.println("Rua:");
                                        String rua = scanner3.nextLine();
                                        System.out.println("Número:");
                                        int numero = scanner4.nextInt();
                                        System.out.println("Cidade:");
                                        String cidade = scanner3.nextLine();
                                        System.out.println("Renda:");
                                        double renda = scanner2.nextDouble();
                                        System.out.println("Dependentes:");
                                        String dependentes = scanner3.nextLine();

                                        Cliente cliente = new Cliente(nome,cpf,dataHora,rua,numero,cidade,renda,dependentes);
                                        clientes.add(cliente);
                                        arquivos.gravaDadosClientes(clientes);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Alterar Cliente");
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);
                                        System.out.println("Nome do cliente:");
                                        String nome = scanner1.nextLine();
                                        Iterator<Cliente> itr = clientes.iterator();
                                        int comando3 = 0;
                                        while(comando3!=4){
                                            System.out.println("O que deseja alterar?\n\t1 - Renda\n\t2 - Endereço\n\t3 - Dependentes\n\t4 - Voltar ");
                                            comando3 = scanner2.nextInt();
                                            switch (comando3){
                                                case 1:{
                                                    System.out.println("Nova renda: ");
                                                    double renda = scanner2.nextDouble();


                                                    while(itr.hasNext()){
                                                        Cliente cliente = itr.next();
                                                        String str = cliente.getNome();

                                                        if(nome.equalsIgnoreCase(str)){
                                                            cliente.setRenda(renda);
                                                            arquivos.gravaDadosClientes(clientes);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    System.out.println("Nova rua: ");
                                                    String rua = scanner1.nextLine();
                                                    System.out.println("Novo numero: ");
                                                    int numero = scanner2.nextInt();
                                                    System.out.println("Nova cidade: ");
                                                    String cidade = scanner1.nextLine();

                                                    while(itr.hasNext()){
                                                        Cliente cliente = itr.next();
                                                        String str = cliente.getNome();

                                                        if(nome.equalsIgnoreCase(str)){
                                                            cliente.setRua(rua);
                                                            cliente.setNumero(numero);
                                                            cliente.setCidade(cidade);
                                                            arquivos.gravaDadosClientes(clientes);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 3:{
                                                    System.out.println("Novos dependentes: ");
                                                    String dependentes = scanner1.nextLine();


                                                    while(itr.hasNext()){
                                                        Cliente cliente = itr.next();
                                                        String str = cliente.getNome();

                                                        if(nome.equalsIgnoreCase(str)){
                                                            cliente.setDependentes(dependentes);
                                                            arquivos.gravaDadosClientes(clientes);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 4:{
                                                    break;
                                                }
                                                default:{
                                                    break;
                                                }
                                            }
                                        }

                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Excluir Cliente");
                                        System.out.println("CPF:");
                                        Scanner scanner = new Scanner(System.in);
                                        String cpf = scanner.nextLine();
                                        Iterator<Cliente> itr = clientes.iterator();
                                        boolean encontrou = false;
                                        while(itr.hasNext()){
                                            Cliente cliente = itr.next();
                                            String match = cliente.getCpf();

                                            if(cpf.equalsIgnoreCase(match)){
                                                encontrou = true;
                                                clientes.remove(cliente);
                                                System.out.println("Cliente removido com sucesso!");
                                                arquivos.gravaDadosClientes(clientes);
                                                break;
                                            }
                                        }

                                        if(!encontrou){
                                            System.out.println("CPF não consta na base de dados!");
                                        }
                                        break;
                                    }
                                    case 4: {

                                        break;
                                    }
                                    default: {
                                        System.out.println("Comando inválido!");
                                        break;
                                    }
                                }
                            }

                            break;
                        }
                        case 2: {
                            while(comando2!=7){
                                System.out.println("Veículos:\n\t1 - Cadastrar carro\t4 - Cadastrar moto\n\t2 - Alterar carro\t5 - Alterar moto\n\t3 - Excluir carro\t6 - Excluir moto\n\t\t\t\t\t\t7 - Voltar");
                                comando2 = scc.nextInt();
                                switch (comando2) {
                                    case 1: {
                                        System.out.println("Cadastrar carro");
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);
                                        Scanner scanner3 = new Scanner(System.in);
                                        Scanner scanner4 = new Scanner(System.in);
                                        System.out.println("Chassi: ");
                                        String chassi = scanner1.nextLine();
                                        System.out.println("Marca: ");
                                        String marca = scanner1.nextLine();
                                        System.out.println("Modelo: ");
                                        String modelo = scanner1.nextLine();
                                        System.out.println("Ano: ");
                                        int ano = scanner4.nextInt();
                                        System.out.println("Tipo de combustível: ");
                                        char tipoCombustivel = scanner2.nextLine().charAt(0);
                                        System.out.println("Peso: ");
                                        double peso = scanner3.nextDouble();
                                        System.out.println("Quilometragem: ");
                                        double quilometragem = scanner3.nextDouble();
                                        System.out.println("Potência: ");
                                        double potencia = scanner3.nextDouble();
                                        System.out.println("Cilindros: ");
                                        int cilindros = scanner4.nextInt();
                                        System.out.println("Numero de ocupantes: ");
                                        int ocupantes = scanner4.nextInt();
                                        System.out.println("Tipo: ");
                                        char tipo = scanner2.nextLine().charAt(0);
                                        System.out.println("Altura: ");
                                        double altura = scanner3.nextDouble();
                                        System.out.println("Largura: ");
                                        double largura = scanner3.nextDouble();
                                        System.out.println("Comprimento: ");
                                        double comprimento = scanner3.nextDouble();
                                        Carro carro = new Carro(chassi, marca, modelo,ano, tipoCombustivel, quilometragem, peso,potencia,cilindros,ocupantes,tipo, altura, largura, comprimento);
                                        carros.add(carro);
                                        arquivos.gravaDadosCarros(carros);
                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Alterar carro");

                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Excluir carro");
                                        System.out.println("Chassi:");
                                        Scanner scanner = new Scanner(System.in);
                                        String chassi = scanner.nextLine();
                                        Iterator<Carro> itr = carros.iterator();
                                        boolean encontrou = false;
                                        while(itr.hasNext()){
                                            Carro carro = itr.next();
                                            String match = carro.getChassi();

                                            if(chassi.equalsIgnoreCase(match)){
                                                encontrou = true;
                                                carros.remove(carro);
                                                System.out.println("Carro removido com sucesso!");
                                                arquivos.gravaDadosCarros(carros);
                                                break;
                                            }
                                        }

                                        if(!encontrou){
                                            System.out.println("Chassi não consta na base de dados!");
                                        }
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Cadastrar moto: ");
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);
                                        Scanner scanner3 = new Scanner(System.in);
                                        Scanner scanner4 = new Scanner(System.in);
                                        System.out.println("Chassi: ");
                                        String chassi = scanner1.nextLine();
                                        System.out.println("Marca: ");
                                        String marca = scanner1.nextLine();
                                        System.out.println("Modelo: ");
                                        String modelo = scanner1.nextLine();
                                        System.out.println("Ano: ");
                                        int ano = scanner4.nextInt();
                                        System.out.println("Tipo de combustível: ");
                                        char tipoCombustivel = scanner2.nextLine().charAt(0);
                                        System.out.println("Peso: ");
                                        double peso = scanner3.nextDouble();
                                        System.out.println("Quilometragem: ");
                                        double quilometragem = scanner3.nextDouble();

                                        System.out.println("Cilindradas: ");
                                        int cilindradas = scanner4.nextInt();
                                        System.out.println("Tipo: ");
                                        char tipo = scanner2.nextLine().charAt(0);

                                        Motocicleta moto = new Motocicleta(chassi, marca, modelo,ano, tipoCombustivel, quilometragem, peso,cilindradas,tipo);
                                        motos.add(moto);
                                        arquivos.gravaDadosMotos(motos);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Alterar ");
                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Excluir Moto");
                                        System.out.println("Chassi:");
                                        Scanner scanner = new Scanner(System.in);
                                        String chassi = scanner.nextLine();
                                        Iterator<Motocicleta> itr = motos.iterator();
                                        boolean encontrou = false;
                                        while(itr.hasNext()){
                                            Motocicleta moto = itr.next();
                                            String match = moto.getChassi();

                                            if(chassi.equalsIgnoreCase(match)){
                                                encontrou = true;
                                                motos.remove(moto);
                                                System.out.println("Moto removida com sucesso!");
                                                arquivos.gravaDadosMotos(motos);
                                                break;
                                            }
                                        }

                                        if(!encontrou){
                                            System.out.println("Chassi não consta na base de dados!");
                                        }

                                        break;
                                    }
                                    case 7: {

                                        break;
                                    }

                                    default: {
                                        System.out.println("Comando inválido!");
                                        break;
                                    }
                                }
                            }

                            break;
                        }
                        case 3: {
                            while(comando2!=8) {
                                System.out.println("Funcionários:\n\t1 - Cadastrar vendedor\t4 - Cadastrar gerente\n\t2 - Alterar vendedor\t5 - Alterar gerente\n\t3 - Excluir vendedor\t6 - Excluir gerente\n\t\t\t\t\t\t\t7 - Desempenho vendedores\n\t\t\t\t\t\t\t8 - Voltar");
                                comando2 = scc.nextInt();
                                switch (comando2) {
                                    case 1: {
                                        Scanner sc2 = new Scanner(System.in);
                                        Scanner sc3 = new Scanner(System.in);
                                        Scanner sc4 = new Scanner(System.in);
                                        Scanner sc5 = new Scanner(System.in);
                                        Scanner sc6 = new Scanner(System.in);
                                        Scanner sc7 = new Scanner(System.in);
                                        Scanner sc8 = new Scanner(System.in);

                                        System.out.println("Cadastrar vendedor");
                                        System.out.println("Nome:");
                                        String nome = sc2.nextLine();
                                        System.out.println("RG:");
                                        String RG = sc2.nextLine();
                                        System.out.println("Dia do nascimento:");
                                        int diaNasc = sc2.nextInt();
                                        System.out.println("Mês do nascimento:");
                                        int mesNasc = sc3.nextInt();
                                        System.out.println("Ano do nascimento:");
                                        int anoNasc = sc5.nextInt();
                                        System.out.println("Horario do nascimento:");
                                        String horarioNasc = sc4.nextLine();
                                        DataHora dataHora1 = new DataHora(diaNasc, mesNasc, anoNasc, horarioNasc);

                                        System.out.println("Dia da admissão:");
                                        int diaAdm = sc4.nextInt();
                                        System.out.println("Mês da admissão:");
                                        int mesAdm = sc6.nextInt();
                                        System.out.println("Ano da admissão:");
                                        int anoAdm = sc5.nextInt();
                                        System.out.println("Horario da admissão:");
                                        String horarioAdm = sc7.nextLine();
                                        DataHora dataHora2 = new DataHora(diaAdm, mesAdm, anoAdm, horarioAdm);
                                        System.out.println("Salario:");
                                        double salario = sc5.nextDouble();
                                        System.out.println("Gerente Responsável:");
                                        String nomeGerenteResponsavel = sc8.nextLine();
                                        Gerente responsavel = null;
                                        for (Gerente value : gerentes) {
                                            if (nomeGerenteResponsavel.equalsIgnoreCase(value.getNome())) {

                                                responsavel = new Gerente(value);
                                            }
                                        }
                                        System.out.println("Tempo de treino:");
                                        int treino = sc6.nextInt();
                                        System.out.println("Usuario:");
                                        String novoUsuario = sc7.nextLine();
                                        System.out.println("Senha:");
                                        String senhaNovoUsuario = sc8.nextLine();

                                        Vendedor vendedor = new Vendedor(nome, RG, dataHora1, dataHora2, salario, responsavel, treino, novoUsuario, senhaNovoUsuario);
                                        vendedores.add(vendedor);
                                        arquivos.gravaDadosVendedores(vendedores);

                                        break;
                                    }
                                    case 2: {
                                        System.out.println("Alterar vendedor");
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);

                                        System.out.println("Qual o nome do vendedor que deseja alterar?");
                                        String nome = scanner1.nextLine();

                                        int comando3 = 0;
                                        while (comando3 != 3) {
                                            System.out.println("O que deseja mudar?\n\t1 - Gerente responsável\n\t2 - Salário\n\t3 - voltar");
                                            comando3 = scanner2.nextInt();
                                            switch (comando3) {
                                                case 1: {
                                                    System.out.println("Digite o nome do novo gerente:");
                                                    String novoGerente = scanner1.nextLine();
                                                    Iterator<Vendedor> itr = vendedores.iterator();


                                                    while (itr.hasNext()) {
                                                        Vendedor vendedor = itr.next();
                                                        String str = vendedor.getNome();
                                                        if (str.equalsIgnoreCase(nome)) {
                                                            for (Gerente value : gerentes) {
                                                                if (novoGerente.equalsIgnoreCase(value.getNome())) {
                                                                    vendedor.setResponsavel(value);
                                                                    arquivos.gravaDadosVendedores(vendedores);
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    }

                                                    break;
                                                }
                                                case 2: {
                                                    System.out.println("Digite o novo salário: ");
                                                    double novoSalario = scanner2.nextDouble();
                                                    Iterator<Vendedor> itr = vendedores.iterator();

                                                    while (itr.hasNext()) {
                                                        Vendedor vendedor = itr.next();
                                                        String str = vendedor.getNome();

                                                        if (nome.equalsIgnoreCase(str)) {
                                                            vendedor.setSalario(novoSalario);
                                                            arquivos.gravaDadosVendedores(vendedores);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 3: {
                                                    break;
                                                }

                                            }
                                        }
                                        break;
                                    }
                                    case 3: {
                                        System.out.println("Excluir vendedor");
                                        System.out.println("RG:");
                                        Scanner scanner = new Scanner(System.in);
                                        String RG = scanner.nextLine();
                                        Iterator<Vendedor> itr = vendedores.iterator();
                                        boolean encontrou = false;
                                        while (itr.hasNext()) {
                                            Vendedor vendedor = itr.next();
                                            String match = vendedor.getRG();

                                            if (RG.equalsIgnoreCase(match)) {
                                                encontrou = true;
                                                vendedores.remove(vendedor);
                                                System.out.println("Vendedor removido com sucesso!");
                                                arquivos.gravaDadosVendedores(vendedores);
                                                break;
                                            }
                                        }

                                        if (!encontrou) {
                                            System.out.println("RG não consta na base de dados!");
                                        }
                                        break;
                                    }
                                    case 4: {
                                        System.out.println("Cadastrar gerente");
                                        Scanner sc2 = new Scanner(System.in);
                                        Scanner sc3 = new Scanner(System.in);
                                        Scanner sc4 = new Scanner(System.in);
                                        Scanner sc5 = new Scanner(System.in);
                                        Scanner sc6 = new Scanner(System.in);
                                        Scanner sc7 = new Scanner(System.in);
                                        Scanner sc8 = new Scanner(System.in);

                                        System.out.println("Nome:");
                                        String nome = sc2.nextLine();
                                        System.out.println("RG:");
                                        String RG = sc2.nextLine();
                                        System.out.println("Dia do nascimento:");
                                        int diaNasc = sc2.nextInt();
                                        System.out.println("Mês do nascimento:");
                                        int mesNasc = sc3.nextInt();
                                        System.out.println("Ano do nascimento:");
                                        int anoNasc = sc5.nextInt();
                                        System.out.println("Horario do nascimento:");
                                        String horarioNasc = sc4.nextLine();
                                        DataHora dataHora1 = new DataHora(diaNasc, mesNasc, anoNasc, horarioNasc);

                                        System.out.println("Dia da admissão:");
                                        int diaAdm = sc4.nextInt();
                                        System.out.println("Mês da admissão:");
                                        int mesAdm = sc6.nextInt();
                                        System.out.println("Ano da admissão:");
                                        int anoAdm = sc5.nextInt();
                                        System.out.println("Horario da admissão:");
                                        String horarioAdm = sc7.nextLine();
                                        DataHora dataHora2 = new DataHora(diaAdm, mesAdm, anoAdm, horarioAdm);
                                        System.out.println("Salario:");
                                        double salario = sc5.nextDouble();
                                        System.out.println("Anos de experiência:");
                                        int anosExp = sc6.nextInt();
                                        System.out.println("Usuario:");
                                        String novoUsuario = sc7.nextLine();
                                        System.out.println("Senha:");
                                        String senhaNovoUsuario = sc8.nextLine();

                                        Gerente gerente = new Gerente(nome, RG, dataHora1, dataHora2, salario, anosExp, novoUsuario, senhaNovoUsuario);

                                        gerentes.add(gerente);
                                        arquivos.gravaDadosGerentes(gerentes);
                                        break;
                                    }
                                    case 5: {
                                        System.out.println("Alterar gerente");
                                        Scanner scanner1 = new Scanner(System.in);
                                        Scanner scanner2 = new Scanner(System.in);

                                        System.out.println("Qual o nome do gerente que deseja alterar?");
                                        String nome = scanner1.nextLine();
                                        Iterator<Gerente> itr = gerentes.iterator();


                                        while(itr.hasNext()){
                                            Gerente gerente = itr.next();
                                            String str = gerente.getNome();
                                            if(nome.equalsIgnoreCase(str)){
                                                System.out.println("Digite o novo salário: ");
                                                double novoSal = scanner2.nextDouble();
                                                gerente.setSalario(novoSal);
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    case 6: {
                                        System.out.println("Excluir gerente");
                                        System.out.println("RG:");
                                        Scanner scanner = new Scanner(System.in);
                                        String RG = scanner.nextLine();
                                        Iterator<Gerente> itr = gerentes.iterator();
                                        boolean encontrou = false;
                                        while(itr.hasNext()){
                                            Gerente gerente = itr.next();
                                            String match = gerente.getRG();

                                            if(RG.equalsIgnoreCase(match)){
                                                encontrou = true;
                                                gerentes.remove(gerente);
                                                System.out.println("Gerente removido com sucesso!");
                                                arquivos.gravaDadosGerentes(gerentes);
                                                break;
                                            }
                                        }

                                        if(!encontrou){
                                            System.out.println("RG não consta na base de dados!");
                                        }
                                        break;
                                    }
                                    case 7:{
                                        System.out.println("Desempenho vendedores:");
                                        arquivos.desempenhoVendedores(vendedores, vendasVista, vendasPrazo);
                                        break;
                                    }
                                    case 8:{

                                        break;
                                    }
                                    default: {
                                        System.out.println("Comando inválido!");
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Até a próxima!");
                            break;
                        }

                        default: {
                            System.out.println("Comando inválido");
                            break;
                        }
                    }
                }
            } else if (credencial == 'V') {

                arquivos.lerDadosClientes(clientes);
                arquivos.lerDadosCarros(carros);
                arquivos.lerDadosMotos(motos);
                arquivos.lerDadosVista(vendasVista);
                arquivos.lerDadosPrazo(vendasPrazo);

                System.out.println("Olá vendedor!");
                int comando = 0;
                Scanner sc1 = new Scanner(System.in);
                while (comando != 3) {
                    System.out.println("Selecione a opção desejada:\n\t1 - Venda à vista\n\t2 - Venda a prazo\n\t3 - Salvar e sair");
                    arquivos.lerDadosVista(vendasVista);
                    arquivos.lerDadosPrazo(vendasPrazo);
                    comando = sc1.nextInt();
                    switch (comando) {
                        case 1: {
                            System.out.println("Venda à vista:");
                            Scanner scanner1 = new Scanner(System.in);
                            Scanner scanner2 = new Scanner(System.in);
                            Scanner scanner3 = new Scanner(System.in);
                            Scanner scanner4 = new Scanner(System.in);
                            Scanner scanner5 = new Scanner(System.in);

                            System.out.println("ID da venda:");
                            int id = scanner1.nextInt();
                            System.out.println("Nome do vendedor: ");
                            String nomeVendedor = scanner2.nextLine();

                            boolean encontrou1 = false;
                            boolean encontrou2 = false;
                            boolean encontrou3 = false;


                            for(Vendedor value: vendedores){
                                if(encontrou1){
                                    break;
                                }
                                if(nomeVendedor.equalsIgnoreCase(value.getNome())){
                                    encontrou1 = true;
                                    System.out.println("Tipo do veiculo: ");
                                    char tipo = scanner3.nextLine().charAt(0);

                                    if(tipo=='C'){
                                        System.out.println("Chassi: ");
                                        String chassi = scanner2.nextLine();

                                        for(Carro value2: carros){
                                            if(encontrou2){
                                                break;
                                            }
                                            if(chassi.equalsIgnoreCase(value2.getChassi())){
                                                encontrou2 = true;
                                                System.out.println("Nome do cliente: ");
                                                String nomeCliente = scanner2.nextLine();

                                                for(Cliente value3: clientes){
                                                    if(nomeCliente.equalsIgnoreCase(value3.getNome())){
                                                        encontrou3 = true;
                                                        System.out.println("Valor:");
                                                        double valor = scanner4.nextDouble();
                                                        System.out.println("Dia da venda:");
                                                        int diaVenda = scanner5.nextInt();
                                                        System.out.println("Mês da venda:");
                                                        int mesVenda = scanner5.nextInt();
                                                        System.out.println("Ano da venda:");
                                                        int anoVenda = scanner5.nextInt();
                                                        System.out.println("Horario da venda:");
                                                        String horarioVenda = scanner2.nextLine();
                                                        DataHora dataHora1 = new DataHora(diaVenda, mesVenda, anoVenda, horarioVenda);

                                                        Vista vendaVista = new Vista(id, value, value3, value2, valor, dataHora1);
                                                        vendasVista.add(vendaVista);
                                                        arquivos.gravaDadosVista(vendasVista);
                                                        break;
                                                    }

                                                }
                                            }
                                        }

                                    }else if(tipo=='M'){
                                        System.out.println("Chassi: ");
                                        String chassi = scanner4.nextLine();

                                        for(Motocicleta value2: motos){
                                            if(encontrou2){
                                                break;
                                            }
                                            if(chassi.equalsIgnoreCase(value2.getChassi())){
                                                encontrou2 = true;
                                                System.out.println("Nome do cliente: ");
                                                String nomeCliente = scanner5.nextLine();

                                                for(Cliente value3: clientes){
                                                    if(nomeCliente.equalsIgnoreCase(value3.getNome())){
                                                        System.out.println("Valor:");
                                                        double valor = scanner4.nextDouble();
                                                        System.out.println("Dia da venda:");
                                                        int diaVenda = scanner5.nextInt();
                                                        System.out.println("Mês da venda:");
                                                        int mesVenda = scanner5.nextInt();
                                                        System.out.println("Ano da venda:");
                                                        int anoVenda = scanner5.nextInt();
                                                        System.out.println("Horario da venda:");
                                                        String horarioVenda = scanner2.nextLine();
                                                        DataHora dataHora1 = new DataHora(diaVenda, mesVenda, anoVenda, horarioVenda);

                                                        Vista vendaVista = new Vista(id, value, value3, value2, valor, dataHora1);
                                                        vendasVista.add(vendaVista);
                                                        arquivos.gravaDadosVista(vendasVista);
                                                        break;
                                                    }

                                                }
                                            }
                                        }
                                    }

                                }

                            }

                            break;
                        }
                        case 2: {
                            System.out.println("Venda a prazo:");
                            Scanner scanner1 = new Scanner(System.in);
                            Scanner scanner2 = new Scanner(System.in);
                            Scanner scanner3 = new Scanner(System.in);
                            Scanner scanner4 = new Scanner(System.in);
                            Scanner scanner5 = new Scanner(System.in);
                            System.out.println("ID da venda:");
                            int id = scanner1.nextInt();
                            System.out.println("Nome do vendedor: ");
                            String nomeVendedor = scanner2.nextLine();
                            boolean encontrou1 = false;
                            boolean encontrou2 = false;
                            boolean encontrou3 = false;

                            for(Vendedor value: vendedores){
                                if(encontrou1){
                                    break;
                                }
                                if(nomeVendedor.equalsIgnoreCase(value.getNome())){
                                    encontrou1 = true;
                                    System.out.println("Tipo do veiculo: ");
                                    char tipo = scanner3.nextLine().charAt(0);

                                    if(tipo=='C'){
                                        System.out.println("Chassi: ");
                                        String chassi = scanner4.nextLine();

                                        for(Carro value2: carros){
                                            if (encontrou2){
                                                break;
                                            }
                                            if(chassi.equalsIgnoreCase(value2.getChassi())){
                                                encontrou2 = true;
                                                System.out.println("Nome do cliente: ");
                                                String nomeCliente = scanner5.nextLine();

                                                for(Cliente value3: clientes){
                                                    if(nomeCliente.equalsIgnoreCase(value3.getNome())){
                                                        encontrou3 = true;
                                                        System.out.println("Valor:");
                                                        double valor = scanner3.nextDouble();
                                                        System.out.println("Dia da venda:");
                                                        int diaVenda = scanner5.nextInt();
                                                        System.out.println("Mês da venda:");
                                                        int mesVenda = scanner5.nextInt();
                                                        System.out.println("Ano da venda:");
                                                        int anoVenda = scanner5.nextInt();
                                                        System.out.println("Horario da venda:");
                                                        String horarioVenda = scanner2.nextLine();
                                                        System.out.println("Número de parcelas:");
                                                        int parcelas = scanner1.nextInt();
                                                        System.out.println("Porcentagem de juros ao mês:");
                                                        double juros  = scanner1.nextDouble();
                                                        DataHora dataHora1 = new DataHora(diaVenda, mesVenda, anoVenda, horarioVenda);

                                                        Prazo vendaPrazo = new Prazo(id, value, value3, value2, valor, dataHora1, parcelas, juros);
                                                        vendasPrazo.add(vendaPrazo);
                                                        arquivos.gravaDadosPrazo(vendasPrazo);
                                                        break;

                                                    }

                                                }
                                            }

                                        }

                                    }else if(tipo=='M'){
                                        System.out.println("Chassi: ");
                                        String chassi = scanner4.nextLine();

                                        for(Motocicleta value2: motos){
                                            if (encontrou2){
                                                break;
                                            }
                                            if(chassi.equalsIgnoreCase(value2.getChassi())){
                                                System.out.println("Nome do cliente: ");
                                                String nomeCliente = scanner4.nextLine();

                                                for(Cliente value3: clientes){
                                                    if(nomeCliente.equalsIgnoreCase(value3.getNome())){
                                                        System.out.println("Valor:");
                                                        double valor = scanner3.nextDouble();
                                                        System.out.println("Dia da venda:");
                                                        int diaVenda = scanner1.nextInt();
                                                        System.out.println("Mês da venda:");
                                                        int mesVenda = scanner1.nextInt();
                                                        System.out.println("Ano da venda:");
                                                        int anoVenda = scanner1.nextInt();
                                                        System.out.println("Horario da venda:");
                                                        String horarioVenda = scanner2.nextLine();
                                                        System.out.println("Número de parcelas:");
                                                        int parcelas = scanner1.nextInt();
                                                        System.out.println("Porcentagem de juros ao mês:");
                                                        double juros  = scanner1.nextDouble();
                                                        DataHora dataHora1 = new DataHora(diaVenda, mesVenda, anoVenda, horarioVenda);

                                                        Prazo vendaPrazo = new Prazo(id, value, value3, value2, valor, dataHora1, parcelas, juros);
                                                        vendasPrazo.add(vendaPrazo);
                                                        arquivos.gravaDadosPrazo(vendasPrazo);
                                                        break;
                                                    }

                                                }
                                            }
                                        }
                                    }else{
                                        System.out.println("Tipo do veículo inválido");
                                    }

                                }

                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Até a próxima!");
                            break;
                        }
                        default: {
                            System.out.println("Comando inválido!");
                            break;
                        }
                    }
                }

            } else {
                System.out.println("Usuario e/ou senha inválidos!");
            }
            arquivos.gravaDadosGerentes(gerentes);
            arquivos.gravaDadosVendedores(vendedores);
            arquivos.gravaDadosClientes(clientes);
            arquivos.gravaDadosCarros(carros);
            arquivos.gravaDadosMotos(motos);
            arquivos.gravaDadosVista(vendasVista);
            arquivos.gravaDadosPrazo(vendasPrazo);

        }
    }
}


