package npe.prelievo;

public class RisultatoSalvataggio {
    public enum Risultato { OK, KO };

    private final Risultato risultato;
    private final String messaggio;

    public RisultatoSalvataggio(Risultato risultato, String messaggio) {
        this.risultato = risultato;
        this.messaggio = messaggio;
    }

    public Risultato getRisultato() {
        return risultato;
    }

    public String getMessaggio() {
        return messaggio;
    }
}
