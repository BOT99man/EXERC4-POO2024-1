package br.ufpb.dcx.tobias.ex03;
import java.util.Scanner;
public class TestaSIstemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo obj = new SistemaAmigo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de amigos: ");
        int qtd = sc.nextInt();
        for (int i = 0; i < qtd; i++) {
            System.out.println("Digite o nome do amigo: ");
            String nome = sc.next();
            System.out.println("Digite o email do amigo(EX:fulano@gmail.com): ");
            String email = sc.next();
            obj.cadastraAmigo(nome,email);
        }
        obj.sortear();
        for (int i = 0; i < qtd; i++) {
            System.out.println("Digite o email do amigo(EX:fulano@gmail.com): ");
            String email = sc.next();
            try {
                System.out.println(email + "tirou: " +obj.pesquisaAmigoSecretoDe(email));
            } catch (AmigoInexistenteException e) {
                throw new RuntimeException(e);
            } catch (AmigoNaoSorteadoException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Qual e-mail será o remetente da mensagem para todos? ");
        String remetente = sc.next();
        System.out.println("Digite aqui o texto: ");
        String texto = sc.next();
        System.out.println("Se deseja que a mensagem seja anônima, digite 1.\n Se não deseja, digite 0.");
        int opcao = sc.nextInt();
        if (opcao == 1) {
            obj.enviarMensagemParaTodos(texto,remetente,true);
        }
        if (opcao == 0) {
            obj.enviarMensagemParaTodos(texto,remetente,false);
        }

    }
}
