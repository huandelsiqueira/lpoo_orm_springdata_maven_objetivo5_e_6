package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.exemplares;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class ExemplaresController {

    private static final Scanner input = new Scanner(System.in);

    private static ExemplaresService exemplaresService;

    public ExemplaresController(ExemplaresService exemplaresService) {

        ExemplaresController.exemplaresService = exemplaresService;

    }

    public static void main(String[] args) {

        int opcao;
        do {
            System.out.print("\n\"-------  MENU Exemplares -------\"\n");
            System.out.print(
                    """
                            (0). Sair\s
                            (1). Inserir novo exemplar
                            (2). Atualizar um exemplar
                            (3). Excluir um exemplar
                            (4). Listar todos os exemplares
                            (5). Buscar exemplar pelo código
                            (6). Buscar exemplar pelo nome:\s""");

            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> excluir();
                case 4 -> selectclientes();
                case 5 -> selectclientesById();
                case 6 -> selectclientesByNome();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }

    //opção 1
    private static void inserir() {

        Exemplares exemplares = new Exemplares();

        System.out.println("\n++++++ Cadastro de novo Exemplar ++++++");

        System.out.print("\nDigite o nome do exemplar: ");
        exemplares.setNome(input.nextLine());

        System.out.print("Digite o gênero do exemplar: ");
        exemplares.setTipoExemplar(input.nextLine());

        System.out.println("Exemplar salvo com sucesso:" + exemplaresService.insert(exemplares));

    }

    //opção 2
    private static void atualizar() {

        System.out.println("\n++++++ Alterar um cliente ++++++");
        Exemplares exemplar;
        int opcao = 0;

        do {

            System.out.println("\nDigite o código do exemplar (Zero p/ sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else {
                exemplar = exemplaresService.getExemplarById(codigo);
                if (exemplar == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println("Nome: " + exemplar.getNome());
                    System.out.println("Alterar? (0).SIM / (1).NÃO");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo nome do exemplar: ");
                        exemplar.setNome(input.nextLine());
                    }
                    System.out.println("Gênero: " + exemplar.getTipoExemplar());
                    System.out.println("Alterar? (0).SIM / (1).NÃO");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Digite o novo gênero do exemplar: ");
                        exemplar.setTipoExemplar(input.nextLine());
                    }

                    if (exemplaresService.update(exemplar) != null) {
                        System.out.println("Exemplar atualizado com sucesso. " + exemplaresService.getExemplarById((exemplar.getId())));
                    }

                    opcao = 1;

                }
            }

        } while (opcao != 0);

    }

    private static void excluir() {

        System.out.println("\n++++++ Excluir um cliente ++++++");
        Exemplares exemplar;
        int opcao = 0;

        do {

            System.out.println("\nDigite o código do exemplar (Zero p/ sair: ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0) {
                opcao = 0;
            } else if (codigo > 0) {
                exemplar = exemplaresService.getExemplarById(codigo);
                if (exemplar == null) {
                    System.out.println("Código inválido.");
                } else {
                    System.out.println(exemplar);
                    System.out.println("Excluir este cliente? (0).SIM / (1).NÃO");
                    if (input.nextInt() == 0) {
                        input.nextLine();
                        System.out.println("Tem certeza disso? (0).SIM / (1).NÃO");
                        input.nextLine();
                        exemplaresService.delete(exemplar.getId());
                        System.out.println("Exemplar excluído com sucesso: " + exemplar);
                    }

                    opcao = 1;

                }
            } else {
                System.out.println("Código inválido.");
            }

        } while (opcao != 0);

    }

    //opção 3
    private static void selectclientes() {
        System.out.println("\nLista de exemplares cadastrados no banco de dados:\n");
        List<Exemplares> exemplares = exemplaresService.getExemplares();
        System.out.println(exemplares);
    }

    //opção 4
    private static void selectclientesById() {
        System.out.print("\nDigite o código do exemplar: ");
        Exemplares exemplar = exemplaresService.getExemplarById(input.nextLong());
        input.nextLine();
        if (exemplar != null) {
            System.out.println(exemplar);
        } else {
            System.out.println("Código não localizado.");
        }
    }

    //opção 5
    private static void selectclientesByNome() {
        System.out.print("Digite o nome do exemplar: ");
        String nome = input.nextLine();
        System.out.println("Chave da pesquisa: " + nome);
        List<Exemplares> exemplares = exemplaresService.getExemplaresByNome("%" + nome + "%");
        if (exemplares.isEmpty()) {
            System.out.println("Não há registros corespondentes para: " + nome);
        } else {
            System.out.println(exemplares);
        }
    }


}
