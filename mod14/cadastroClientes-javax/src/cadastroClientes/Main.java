package cadastroClientes;

import javax.swing.JOptionPane;
import cadastroClientes.dao.ClienteMapDAO;
import cadastroClientes.dao.IClienteDAO;
import cadastroClientes.domain.Cliente;

public class Main {
    private static IClienteDAO iClienteDAO;

    public static void main(String args[]) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if (opcao == null || "".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida! Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            switch (opcao) {
                case "1":
                    String dadosCadastro = JOptionPane.showInputDialog(null,
                            "Digite os dados do cliente separados por vírgula (Nome, CPF, Telefone, Endereço, Número, Cidade, Estado)",
                            "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    cadastrar(dadosCadastro);
                    break;
                case "2":
                    String cpfConsulta = JOptionPane.showInputDialog(null,
                            "Digite o CPF do cliente para consultar",
                            "Consulta", JOptionPane.INFORMATION_MESSAGE);
                    consultar(cpfConsulta);
                    break;
                case "3":
                    String cpfExclusao = JOptionPane.showInputDialog(null,
                            "Digite o CPF do cliente para exclusão",
                            "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                    excluir(cpfExclusao);
                    break;
                case "4":
                    String cpfAlteracao = JOptionPane.showInputDialog(null,
                            "Digite o CPF do cliente para alteração",
                            "Alteração", JOptionPane.INFORMATION_MESSAGE);
                    alterar(cpfAlteracao);
                    break;
                case "5":
                    sair();
                    break;
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        if (dadosSeparados.length < 7) {
            JOptionPane.showMessageDialog(null, "Passe todos os argumentos corretamente.", "Erro", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3],
                dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        JOptionPane.showMessageDialog(null,
                isCadastrado ? "Cliente cadastrado com sucesso." : "Cliente já se encontra cadastrado.",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void consultar(String cpf) {
        try {
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpf));
            JOptionPane.showMessageDialog(null,
                    cliente != null ? "Cliente encontrado: " + cliente.toString() : "Cliente não encontrado.",
                    "Consulta", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Digite apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void excluir(String cpf) {
        try {
            Boolean isExcluido = iClienteDAO.excluir(Long.parseLong(cpf));
            JOptionPane.showMessageDialog(null,
                    isExcluido ? "Cliente excluído com sucesso." : "Cliente não encontrado.",
                    "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Digite apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void alterar(String cpf) {
        try {
            Cliente clienteExistente = iClienteDAO.consultar(Long.parseLong(cpf));
            if (clienteExistente == null) {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Erro", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String novosDados = JOptionPane.showInputDialog(null,
                    "Digite os novos dados do cliente separados por vírgula (Nome, CPF, Telefone, Endereço, Número, Cidade, Estado)",
                    "Alteração", JOptionPane.INFORMATION_MESSAGE);
            String[] dadosSeparados = novosDados.split(",");
            if (dadosSeparados.length < 7) {
                JOptionPane.showMessageDialog(null, "Passe todos os argumentos corretamente.", "Erro", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Cliente clienteAtualizado = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],
                    dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
            iClienteDAO.alterar(clienteAtualizado);
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF inválido. Digite apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até mais. Tchau!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
