package br.ufpb.dcx.tobias.ex03;

import java.util.List;
import java.util.Map;

public class SistemaAmigoMapTest {
   public static void main(String[] args) {
       SistemaAmigoMap sistemaAmigoMap = new SistemaAmigoMap();
       sistemaAmigoMap.cadastraAmigoMap("José","jose@gmail.com","01");
       sistemaAmigoMap.cadastraAmigoMap("Maria","maria@gmail.com","02");
       try {
           sistemaAmigoMap.configuraAmigoSecretoDe("jose@gmail.com","maria@gmail.com");
       } catch (AmigoInexistenteException e) {
           System.out.println(e.getMessage());
       }
       try {
           sistemaAmigoMap.configuraAmigoSecretoDe("maria@gmail.com","jose@gmail.com");
       } catch (AmigoInexistenteException e) {
           System.out.println(e.getMessage());
       }
       sistemaAmigoMap.enviarMensagemParaAlguem("OI","maria@gmail.com","jose@gmail.com",true,"02");
       sistemaAmigoMap.enviarMensagemParaTodos("OIII","maria@gmail.com",true,"02");
       Map<String,Mensagem> mapMsg = sistemaAmigoMap.pesquisarMensagensAnonimas();
       for (String key : mapMsg.keySet()) {
           System.out.println(mapMsg.get(key).getTextoCompletoAExibir());
       }
       try {
           String amigoSorteado = sistemaAmigoMap.pesquisaAmigoSecretoDe("jose@gmail.com");
           if(amigoSorteado.equalsIgnoreCase("maria@gmail.com")){
               System.out.println("OK");
           }
       } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
           throw new RuntimeException(e);
       }
   }


}
