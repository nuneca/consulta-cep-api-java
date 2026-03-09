import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Endereco> listaEnderecos = new ArrayList<>();
        ArrayList<Endereco> historico = new ArrayList<>();

        int opcao = 0;

        while (opcao != 4) {

            System.out.println("\n==== MENU ====");
            System.out.println("1 - Buscar CEP");
            System.out.println("2 - Excluir endereço");
            System.out.println("3 - Histórico");
            System.out.println("4 - Sair");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("Digite o CEP:");
                    String cep = sc.nextLine();

                    boolean existe = false;

                    for (Endereco e : listaEnderecos) {
                        if (e.cep.equals(cep)) {
                            System.out.println("\nEndereço já está na lista:");
                            System.out.println(e);
                            existe = true;
                        }
                    }

                    if (!existe) {

                        Endereco endereco = CepService.buscarCep(cep);

                        if (endereco != null) {
                            listaEnderecos.add(endereco);
                            historico.add(endereco);

                            System.out.println("\nEndereço encontrado:");
                            System.out.println(endereco);
                        }
                    }

                    break;

                case 2:

                    System.out.println("Digite o CEP para remover:");
                    String cepRemover = sc.nextLine();

                    listaEnderecos.removeIf(e -> e.cep.equals(cepRemover));

                    System.out.println("Removido da lista.");

                    break;

                case 3:

                    System.out.println("\n==== HISTÓRICO ====");

                    for (Endereco e : historico) {
                        System.out.println(e);
                        System.out.println("------------------");
                    }

                    break;

                case 4:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }

        sc.close();
    }
}
