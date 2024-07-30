package br.ufpb.dcx.tobias.ex03;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        this.amigos.add(amigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        for(Amigo amigo : amigos){
            if(amigo.getEmail().equalsIgnoreCase(emailAmigo));
            return amigo;
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        MensagemParaTodos msg = new MensagemParaTodos(texto, emailRemetente, anonima);
        mensagens.add(msg);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima){
        MensagemParaAlguem msg = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonima);
        mensagens.add(msg);
    }

    public List<Mensagem> pesquisarMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<Mensagem>();
        for(int i=0; i<mensagens.size(); i++){
            if(mensagens.get(i).isAnonima()){
                mensagensAnonimas.add(mensagens.get(i));
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public void configuraAmigoSecretoDe(String emialDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        for(Amigo amigo : amigos){
            if(amigo.getEmail().equalsIgnoreCase(emialDaPessoa)){
                amigo.setEmailAmigoSorteado(emailAmigoSorteado);
            }
        }
        throw new AmigoInexistenteException("AMIGO INEXISTENTE");
        }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa)throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(Amigo amigo : amigos){
            if(amigo.getEmail().equalsIgnoreCase(emailDaPessoa)){
                if(amigo.getEmailAmigoSorteado() != null) {
                    return amigo.getEmailAmigoSorteado();
                }
                throw new AmigoNaoSorteadoException("AMIGO SECRETO NÃO SORTEADO");
            }
        }
        throw new AmigoInexistenteException("AMIGO INEXISTENTE");

    }

    public void sortear(){
        List<Amigo> naoSorteados = amigos;
        for(Amigo amigo : amigos){
            int posicaoDaListaSorteada = (int) (Math.random()*naoSorteados.size());
            amigo.setEmailAmigoSorteado(amigos.get(posicaoDaListaSorteada).getEmail());
            naoSorteados.remove(posicaoDaListaSorteada);
        }
    }

}
