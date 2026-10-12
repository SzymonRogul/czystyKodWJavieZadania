import java.time.LocalDate;
import java.time.LocalTime;

public class Egzamin {
    public String nazwaPrzedmiotu;
    protected LocalDate data;
    protected LocalTime godzinaRozpoczecia;
    protected LocalTime godzinaZakoczenia;

    public void start(LocalTime godzinaRozpoczecia) {
        this.godzinaRozpoczecia = godzinaRozpoczecia;
    }
    public void stop() {
        if (godzinaRozpoczecia == null) {
            throw new IllegalStateException("Nie ustawiono godziny rozpoczęcia egzaminu.");
        }
        this.godzinaZakoczenia = godzinaRozpoczecia.plusMinutes(120);
    }

    public Egzamin(String nazwaPrzedmiotu, LocalDate data) {
        this.nazwaPrzedmiotu = nazwaPrzedmiotu;
        this.data = data;
        System.out.println("Utworzono egzamin: " + nazwaPrzedmiotu);
    }

    public String getNazwa_przedmiotu() {
        return nazwaPrzedmiotu;
    }

    public LocalDate getData() {
        return data;
    }

    public String getGodziny() {
        return "Start: " + (godzinaRozpoczecia != null ? godzinaRozpoczecia : "brak") +
                ", Stop: " + (godzinaZakoczenia != null ? godzinaZakoczenia : "brak");
    }
}
class egzPraktyczny extends Egzamin{
    public String forma;
    public String opis;

    @Override
    public void stop() {
        if (godzinaRozpoczecia == null) {
            throw new IllegalStateException(
                    "Nie ustawiono godziny rozpoczęcia egzaminu."
            );
        }

        this.godzinaZakoczenia =
                godzinaRozpoczecia.plusMinutes(150);
    }

    public egzPraktyczny(String nazwaPrzedmiotu, LocalDate data) {
        super(nazwaPrzedmiotu, data);

    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
class Main {
    public static void main(String[] args) {
        Egzamin eProgramowanie = new Egzamin("Programowanie aplikacji", LocalDate.of(2026, 10, 12));
        eProgramowanie.start(LocalTime.of(9, 0));
        eProgramowanie.stop();
        System.out.println(eProgramowanie.getGodziny());
        // Wynik: Start: 09:00, Stop: 11:00
        egzPraktyczny praktyczny = new egzPraktyczny(
                "Programowanie aplikacji",
                LocalDate.now()
        );

        praktyczny.start(LocalTime.of(12, 0));
        praktyczny.stop();

        System.out.println(praktyczny.getGodziny());
    }
}


