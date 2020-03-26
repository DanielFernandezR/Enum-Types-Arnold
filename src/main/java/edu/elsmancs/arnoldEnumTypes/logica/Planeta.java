package edu.elsmancs.arnoldEnumTypes.logica;

import java.util.EnumSet;

public enum Planeta {

	MERCURY(3.303e+23, 2.4397e6), VENUS(4.869e+24, 6.0518e6), EARTH(5.976e+24, 6.37814e6), MARS(6.421e+23, 3.3972e6),
	JUPITER(1.9e+27, 7.1492e7), SATURN(5.688e+26, 6.0268e7), URANUS(8.686e+25, 2.5559e7), NEPTUNE(1.024e+26, 2.4746e7);

	public static final double G = 6.67400e-11;

	private double masaPlaneta = 0.0d;
	private double radioPlaneta = 0.0d;

	private Planeta(double masaPlaneta, double radioPlaneta) {
		this.masaPlaneta = masaPlaneta;
		this.radioPlaneta = radioPlaneta;
	}

	public double getMasaPlaneta() {
		return masaPlaneta;
	}

	public double getRadioPlaneta() {
		return radioPlaneta;
	}

	public double pesoSuperficie(double peso) {
		return pesoEnTierra(peso) * gravedadSuperficie();
	}

	private double gravedadSuperficie(Planeta tierra) {
		return G * (tierra.getMasaPlaneta() / (Math.pow(tierra.getRadioPlaneta(), 2)));
	}

	private double gravedadSuperficie() {
		return G * (getMasaPlaneta() / (Math.pow(getRadioPlaneta(), 2)));
	}

	private double pesoEnTierra(double peso) {
		return peso / gravedadSuperficie(EARTH);
	}

	public static EnumSet<Planeta> getPlanetasTerrestres() {
		return EnumSet.range(MERCURY, MARS);
	}

	public static EnumSet<Planeta> getGigantesGaseosos() {
		return EnumSet.range(JUPITER, NEPTUNE);
	}
}
