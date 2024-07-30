package br.ufpb.dcx.tobias.ex03;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto,String emailRemetente,String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;

    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        if(isAnonima()){
            return "Mensagem para " + getEmailRemetente() + ". Texto: " + getTexto();
        }
        return "Mensagem de: "+ getEmailRemetente() +" para " +getEmailDestinatario() +". Texto: "+getTexto();
    }

}
