/*
 * Copyright (c) 2023. Programacion Avanzada, DISC, UCN.
 */

package cl.ucn.disc.ads.tragamonedas.services;

import cl.ucn.disc.ads.tragamonedas.model.Box;
import cl.ucn.disc.ads.tragamonedas.model.Rueda;

import java.util.List;

/**
 * Implementation of the Tragamonedas Game.
 *
 * @author Arquitectura de Sistemas.
 */
public final class TragamonedasImpl implements Tragamonedas {

    /**
     * The internal Tragamonedas.
     */
    private final Box box = new Box();

    /**
     * The saldo of user.
     */
    private int saldo;

    /**
     * The Constructor.
     *
     * @param saldo del Usuario.
     */
    public TragamonedasImpl(final int saldo) {
        if (saldo <= 0) {
            throw new IllegalArgumentException("No se puede tener saldo inicial cero o negativo");
        }
        this.saldo = saldo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int realizarApuesta(final int apuesta) {

        // protection
        if (apuesta <= 0) {
            throw new IllegalArgumentException("El valor de la apuesta no puede ser cero o negativo");
        }

        // tengo saldo
        if (apuesta > this.saldo) {
            throw new IllegalArgumentException("No se puede apostar mas del saldo disponible");
        }

        // descuento la apuesta
        this.saldo -= apuesta;

        // girar las ruedas
        box.girarRuedas();

        // calcular el premio
        int premio = this.getPremio(apuesta);

        // sumar premio
        this.saldo += premio;
        return premio;

    }

    private int getPremio(int apuesta) {
        if (this.isValorRuedasIgualesDistintoDeCero()) {
            return apuesta * box.getRuedas().get(0).getValor();
        }

        int zeros = (int) box.getRuedas().stream()
                .filter(rueda -> rueda.getValor() == 0)
                .count();

        return switch (zeros) {
            case 1 -> 50;
            case 2 -> 300;
            case 3 -> 500;
            default -> 0;
        };
    }

    private boolean isValorRuedasIgualesDistintoDeCero() {
        List<Rueda> ruedas = box.getRuedas();
        return ruedas.stream()
                .allMatch(r -> r.getValor() == ruedas.get(0).getValor() && r.getValor() != 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Character> getRuedasValues() {
        return box.getRuedasValues();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSaldo() {
        return this.saldo;
    }
}
