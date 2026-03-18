package cl.ucn.disc.ads.tragamonedas.model;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Box of Tragamonedas.
 *
 * @author Arquitectura de Sistemas.
 */
public final class Box {

    /**
     * The number of Ruedas.
     */
    private final int NUMERO_RUEDAS = 3;

    /**
     * The List of Rueda.
     */
    private final List<Rueda> ruedas;


    /**
     * The Constructor.
     */
    public Box() {

        // construction
        this.ruedas = Stream
                .generate(Rueda::new)
                .limit(NUMERO_RUEDAS)
                .collect(Collectors.toList());

    }

    /**
     * Spin the wheel!
     */
    public void girarRuedas() {
        // random throw.
        ruedas.forEach(Rueda::girarAlAzar);
    }

    /**
     * @return the current values of Ruedas.
     */
    public List<Character> getRuedasValues() {

        // the array of chars
        return this.ruedas.stream()
                .map(Rueda::getChar)
                .collect(Collectors.toList());
    }

    public List<Rueda> getRuedas() {
        return this.ruedas;
    }

}
