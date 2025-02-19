package modelo;

public class Automovil extends Vehiculo {

	
	
    public Automovil(int cilindraje, int peso, int tamanoTanque) throws AutonomiaException {
        super(cilindraje, peso, tamanoTanque);
    }

    @Override
    public double calcularAutonomia() {
        return (15 * Math.pow(10, 4) / (cilindraje + peso)) * tamanoTanque;
        
        
        
    }
}
