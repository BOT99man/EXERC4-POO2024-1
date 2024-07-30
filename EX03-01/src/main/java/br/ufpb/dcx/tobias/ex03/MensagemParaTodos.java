package br.ufpb.dcx.tobias.ex03;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    public String getTextoCompletoAExibir(){
        if(isAnonima()){
            return " Mensagem para todos. Texto: " + getTexto();
        }
        return "Mensagem de " + getEmailRemetente() + " para todos. Texto: " + getTexto();
    }
}
