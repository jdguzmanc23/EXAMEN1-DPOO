package modelo;

public class Motocicleta extends Vehiculo {

    public Motocicleta(int cilindraje, int peso, int tamanoTanque) throws AutonomiaException {
        super(cilindraje, peso, tamanoTanque);
        
        
        
    }

    @Override
    public double calcularAutonomia() {
        return (8 * Math.pow(10, 4) / (cilindraje + 2 * peso)) * tamanoTanque;
    }
    
    
    
}
