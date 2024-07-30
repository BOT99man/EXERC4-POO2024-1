package br.ufpb.dcx.tobias.ex03;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistemaAmigo = new SistemaAmigo();
        sistemaAmigo.cadastraAmigo("José","jose@gmail.com");
        sistemaAmigo.cadastraAmigo("Maria","maria@gmail.com");
        try {
            sistemaAmigo.configuraAmigoSecretoDe("jose@gmail.com","maria@gmail.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
        try {
            sistemaAmigo.configuraAmigoSecretoDe("maria@gmail.com","jose@gmail.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
        sistemaAmigo.enviarMensagemParaAlguem("OI","maria@gmail.com","jose@gmail.com",true);
        sistemaAmigo.enviarMensagemParaTodos("OIII","maria@gmail.com",true);
        List<Mensagem> listMsg = sistemaAmigo.pesquisarMensagensAnonimas();
        for (Mensagem msg : listMsg) {
            System.out.println(msg.getTextoCompletoAExibir());
        }
        try {
            String amigoSorteado = sistemaAmigo.pesquisaAmigoSecretoDe("jose@gmail.com");
            if(amigoSorteado.equalsIgnoreCase("maria@gmail.com")){
                System.out.println("OK");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
            throw new RuntimeException(e);
        }

    }
}
