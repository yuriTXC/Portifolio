import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
        Scanner read = new Scanner (System.in);

        Map <String, Integer> cli_dic = new HashMap<>();

        double login = 111, senha = 111, esc_login, esc_senha;


        int esc_burger = 1, salvar_cancel, opcao = 0,  total = 0;

        boolean controle = true;

        String nome = "";

        int bovino = 10, queijo = 10, cheddar = 10, bacon = 10, tilapia = 10, abacaxi = 10, frango = 10, porco = 10;


        do {
            System.out.print("\n\n---- Bem vindo ao ROCK BURGERS ----");
            System.out.print("\n   'We will, we will, feed you!'");
            System.out.print("\nDigite o login: ");
            esc_login = read.nextDouble();
            System.out.print("Digite o senha: ");
            esc_senha = read.nextDouble();


            if (esc_login != login || esc_senha != senha) {
                System.out.print("Senha ou login errados. Tente novamente!");
            }
        } while (esc_login != login || esc_senha != senha);

        while (controle == true) {
            while (opcao != 3 && controle) {
                System.out.print("\n\n---- MENU DE OPÇÕES ----");
                System.out.print("\n1. Cadastrar Clientes" + "\n2. Relatório de pedidos" + "\n3. Registro de pedidos" + "\n4. Sair");
                System.out.print("\nDigite a opção desejada: ");
                opcao = read.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o nome do usuário: ");
                        nome = read.next();
                        cli_dic.put(nome, 0);
                        System.out.print("Usuário " + nome + " cadastrado!");
                        break;
                    case 2:
                    System.out.print("\n--- Relatório de Clientes ---");
                    if (cli_dic.isEmpty()) {
                        System.out.print("\nNão foram realizados cadastros.");
                    } else {
                        System.out.print("\nClientes: ");
                        for (String i: cli_dic.keySet()){
                            System.out.print("\nNome do cliente: " + i + " Valor: " + cli_dic.get(i));
                        }
                    }
                        break;

                    case 4:
                        System.out.print("Obrigado por usar o sistema!");
                        controle = false;
                        break;

                    default:
                        break;
                }
                }
                while (esc_burger != 0 && controle) {
                    if (nome.equals("")) {
                        System.out.print("\nUsuário não encontrado ou cadastrado.");
                        esc_burger = 1;
                        opcao = 0;
                        break;
                    }
                    System.out.print("\n\n---- SABORES ----");
                    System.out.print("\n\n1. Red Hot Chili Peppers - Especial da Casa (Bovino, Queijo, Bacon)" + "\n2. The Beatles (Bovino, Cheddar e Bacon)");
                    System.out.print("\n3. Nirvana (Tilápia, Queijo e Abacaxi Caramelizado)" + "\n4. The Rolling Stones (Frango e Cheddar)");
                    System.out.print("\n5. A-ha (Porco, Queijo e Bacon)" + "\n6. Kiss (Frango, Bacon e Abacaxi Caramelizado)");
                    System.out.print("\n\nTodos os sandubas saem por apenas R$20,00! (Todos tendo alface, tomate e molho especial)");
                    System.out.print("\nDigite (1 - 6) para escolher o sabor (0 para fechar): ");
                
                    esc_burger = read.nextInt();
                    if (esc_burger == 0) {
                        esc_burger = 1;
                        opcao = 0;
                        break;
                    }
                    switch (esc_burger) {
                        case 1:
                            int qtd_sandubas;
                            System.out.print("Deseja quantas unidades do Red Hot Chili Peppers?: ");
                            qtd_sandubas = read.nextInt();
                            System.out.print("\nDeseja salvar os pedidos? (1 - Sim / 2 - Não): ");
                            salvar_cancel = read.nextInt();
                            if (salvar_cancel == 1) {
                                if (qtd_sandubas <= queijo && qtd_sandubas <= bovino && qtd_sandubas <= bacon) {
                                    queijo -= qtd_sandubas;
                                    bovino -= qtd_sandubas;
                                    bacon -= qtd_sandubas;
                                    total = qtd_sandubas * 20;
                                    cli_dic.replace(nome, cli_dic.get(nome) + total);
                                    System.out.print("\nVocê pediu " + qtd_sandubas + " Red Hot Chili Peppers.");
                                    System.out.print("\nO valor total do pedido até agora é de R$" + total);
                                } else {
                                    System.out.print("\nExcede a quantidade de ingredientes ou estamos sem estoque. Não foi possível concluir o pedido.");
                                }
                                break;
                            } else {
                                System.out.println("Você cancelou o seu pedido!");
                                break;
                            }
                        
                        case 2:
                            int qtd_sandubas2;
                            System.out.print("Deseja quantas unidades do The Beatles?: ");
                            qtd_sandubas2 = read.nextInt();
                            System.out.print("\nDeseja salvar os pedidos? (1 - Sim / 2 - Não): ");
                            salvar_cancel = read.nextInt();
                            if (salvar_cancel == 1) {
                                if (qtd_sandubas2 <= cheddar && qtd_sandubas2 <= bovino && qtd_sandubas2 <= bacon) {
                                    cheddar -= qtd_sandubas2;
                                    bovino -= qtd_sandubas2;
                                    bacon -= qtd_sandubas2;
                                    total = qtd_sandubas2 * 20;
                                    cli_dic.replace(nome, cli_dic.get(nome) + total); 
                                    System.out.print("\nVocê pediu " + qtd_sandubas2 + " The Beatles.");
                                    System.out.print("\nO valor total do pedido até agora é de R$" + total);
                                } else {
                                    System.out.print("\nExcede a quantidade de ingredientes. Não foi possível concluir o pedido.");
                                }
                                break;
                            } else {
                                System.out.println("Você cancelou o seu pedido!");
                                break;
                            }
                
                        case 3:
                            int qtd_sandubas3;
                            System.out.print("Deseja quantas unidades do Nirvana?: ");
                            qtd_sandubas3 = read.nextInt();
                            System.out.print("\nDeseja salvar os pedidos? (1 - Sim / 2 - Não): ");
                            salvar_cancel = read.nextInt();
                            if (salvar_cancel == 1) {
                                if (qtd_sandubas3 <= tilapia && qtd_sandubas3 <= queijo && qtd_sandubas3 <= abacaxi) {
                                    tilapia -= qtd_sandubas3;
                                    queijo -= qtd_sandubas3;
                                    abacaxi -= qtd_sandubas3;
                                    total = qtd_sandubas3 * 20;
                                    cli_dic.replace(nome, cli_dic.get(nome) + total);
                                    System.out.print("\nVocê pediu " + qtd_sandubas3 + " The Beatles.");
                                    System.out.print("\nO valor total do pedido até agora é de R$" + total);
                                } else {
                                    System.out.print("\nExcede a quantidade de ingredientes. Não foi possível concluir o pedido.");
                                }
                                break;
                            } else {
                                System.out.println("Você cancelou o seu pedido!");
                                break;
                            }
                        case 4:
                            int qtd_sandubas4;
                            System.out.print("Deseja quantas unidades do The Rolling Stones?: ");
                            qtd_sandubas4 = read.nextInt();
                            System.out.print("\nDeseja salvar os pedidos? (1 - Sim / 2 - Não): ");
                            salvar_cancel = read.nextInt();
                            if (salvar_cancel == 1) {
                                if (qtd_sandubas4 <= cheddar && qtd_sandubas4 <= frango) {
                                    cheddar -= qtd_sandubas4;
                                    frango -= qtd_sandubas4;
                                    total = qtd_sandubas4 * 20;
                                    cli_dic.replace(nome, cli_dic.get(nome) + total);
                                    System.out.print("\nVocê pediu " + qtd_sandubas4 + " The Rolling Stones.");
                                    System.out.print("\nO valor total do pedido até agora é de R$" + total);
                                } else {
                                    System.out.print("Excede a quantidade de ingredientes. Não foi possível concluir o pedido.");
                                }
                                break;
                            } else {
                                System.out.println("Você cancelou o seu pedido!");
                                break;
                            }

                        case 5:
                            int qtd_sandubas5;
                            System.out.print("Deseja quantas unidades do A-ha?: ");
                            qtd_sandubas5 = read.nextInt();
                            System.out.print("\nDeseja salvar os pedidos? (1 - Sim / 2 - Não): ");
                            salvar_cancel = read.nextInt();
                            if (salvar_cancel == 1) {
                                if (qtd_sandubas5 <= porco && qtd_sandubas5 <= queijo && qtd_sandubas5 <= bacon) {
                                    porco -= qtd_sandubas5;
                                    queijo -= qtd_sandubas5;
                                    bacon -= qtd_sandubas5;
                                    total = qtd_sandubas5 * 20;
                                    cli_dic.replace(nome, cli_dic.get(nome) + total);
                                    System.out.print("\nVocê pediu " + qtd_sandubas5 + " The Rolling Stones.");
                                    System.out.print("\nO valor total do pedido até agora é de R$" + total);
                                } else {
                                    System.out.print("Excede a quantidade de ingredientes. Não foi possível concluir o pedido.");
                                }
                                break;
                            } else {
                                System.out.println("Você cancelou o seu pedido!");
                                break;
                            }
                
                        case 6:
                            int qtd_sandubas6;
                            System.out.print("Deseja quantas unidades do Kiss: ");
                            qtd_sandubas6 = read.nextInt();
                            System.out.print("\nDeseja salvar os pedidos? (1 - Sim / 2 - Não): ");
                            salvar_cancel = read.nextInt();
                            if (salvar_cancel == 1) {
                                if (qtd_sandubas6 <= queijo && qtd_sandubas6 <= frango && qtd_sandubas6 <= abacaxi) {
                                    queijo -= qtd_sandubas6;
                                    frango -= qtd_sandubas6;
                                    abacaxi -= qtd_sandubas6;
                                    total = qtd_sandubas6 * 20;
                                    cli_dic.replace(nome, cli_dic.get(nome) + total);
                                    System.out.print("\nVocê pediu " + qtd_sandubas6 + " Kiss.");
                                    System.out.print("\nO valor total do pedido até agora é de R$" + total);
                                } else {
                                    System.out.print("Excede a quantidade de ingredientes. Não foi possível concluir o pedido.");
                                }
                                break;
                            } else {
                                System.out.println("Você cancelou o seu pedido!");
                                break;
                            }
                        }
                    }
                }
            }
        }






























