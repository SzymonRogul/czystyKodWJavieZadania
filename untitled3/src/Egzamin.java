import java.time.LocalDate;
import java.time.LocalTime;

public class Egzamin {
    public String nazwa_przedmiotu;
    protected LocalDate data;
    protected LocalTime godzina_rozpoczecia;
    protected LocalTime godzina_zakonczenia;

    public void start(LocalTime godzina_rozpoczecia) {
        this.godzina_rozpoczecia = godzina_rozpoczecia;
    }
    public void stop() {
        if (godzina_rozpoczecia == null) {
            throw new IllegalStateException("Nie ustawiono godziny rozpoczęcia egzaminu.");
        }
        this.godzina_zakonczenia = godzina_rozpoczecia.plusMinutes(120);
    }

    public Egzamin(String nazwa_przedmiotu, LocalDate data) {
        this.nazwa_przedmiotu = nazwa_przedmiotu;
        this.data = data;
        System.out.println("Utworzono egzamin: " + nazwa_przedmiotu);
    }

    public String getNazwa_przedmiotu() {
        return nazwa_przedmiotu;
    }

    public LocalDate getData() {
        return data;
    }

    public String getGodziny() {
        return "Start: " + (godzina_rozpoczecia != null ? godzina_rozpoczecia : "brak") +
                ", Stop: " + (godzina_zakonczenia != null ? godzina_zakonczenia : "brak");
    }
}
class Egz_praktyczny extends Egzamin{
    public String forma;
    public String opis;

    @Override
    public void stop() {
        if (godzina_rozpoczecia == null) {
            throw new IllegalStateException(
                    "Nie ustawiono godziny rozpoczęcia egzaminu."
            );
        }

        this.godzina_zakonczenia =
                godzina_rozpoczecia.plusMinutes(150);
    }

    public Egz_praktyczny(String nazwa_przedmiotu, LocalDate data) {
        super(nazwa_przedmiotu, data);

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
        Egzamin e_programowanie = new Egzamin("Programowanie aplikacji", LocalDate.of(2026, 10, 12));
        e_programowanie.start(LocalTime.of(9, 0));
        e_programowanie.stop();
        System.out.println(e_programowanie.getGodziny());
        // Wynik: Start: 09:00, Stop: 11:00
        Egz_praktyczny praktyczny = new Egz_praktyczny(
                "Programowanie aplikacji",
                LocalDate.now()
        );

        praktyczny.start(LocalTime.of(12, 0));
        praktyczny.stop();

        System.out.println(praktyczny.getGodziny());
    }
}


