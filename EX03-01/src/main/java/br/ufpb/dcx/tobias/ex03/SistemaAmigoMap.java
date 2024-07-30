package br.ufpb.dcx.tobias.ex03;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class SistemaAmigoMap {
    private Map<String,Mensagem> mensagens;
    private Map<String,Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new HashMap<>();
        this.amigos = new HashMap<>();
    }

    public void cadastraAmigoMap(String nomeAmigo, String emailAmigo, String key){
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        this.amigos.put(key,amigo);
    }

    public Amigo pesquisaAmigo(String key){
        return this.amigos.get(key);
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima, String key){
        MensagemParaTodos msg = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.put(key,msg);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima, String key){
        MensagemParaAlguem msg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.put(key,msg);
    }

    public Map<String,Mensagem> pesquisarMensagensAnonimas() {
        Map<String,Mensagem> mensagensAnonimas = new HashMap<>();
        for(String key : mensagens.keySet()) {
            if (mensagens.get(key).isAnonima()) {
                mensagensAnonimas.put(key, mensagens.get(key));
            }
        }

        return mensagensAnonimas;
    }

    public Map<String,Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emialDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        for(String key: amigos.keySet()){
            if(amigos.get(key) != null){
                amigos.get(key).setEmailAmigoSorteado(emailAmigoSorteado);
            }
        }
        throw new AmigoInexistenteException("AMIGO INEXISTENTE");
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa)throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(String key : amigos.keySet()){
            if(amigos.get(key).getEmail().equalsIgnoreCase(emailDaPessoa)){
                if(amigos.get(key).getEmailAmigoSorteado() != null) {
                    return amigos.get(key).getEmailAmigoSorteado();
                }
                throw new AmigoNaoSorteadoException("AMIGO SECRETO NÃO SORTEADO");
            }
        }
        throw new AmigoInexistenteException("AMIGO INEXISTENTE");

    }

    public void sortear() {
        Random random = new Random();
        Map<String, Amigo> naoSorteados = amigos;
        Set<String> keys = naoSorteados.keySet();
        String[] keysArray = keys.toArray(new String[keys.size()]);
        while (naoSorteados != null) {
            int i = random.nextInt(0, keys.size());
            int j = random.nextInt(0, keys.size());
            if (i != j) {
                naoSorteados.get(keysArray[i]).setEmailAmigoSorteado(naoSorteados.get(keysArray[j]).getEmail());
            }
            naoSorteados.remove(keysArray[i]);
            naoSorteados.remove(keysArray[j]);
        }
    }
}
