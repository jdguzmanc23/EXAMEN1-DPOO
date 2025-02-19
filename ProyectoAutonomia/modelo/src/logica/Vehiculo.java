package modelo;

public abstract class Vehiculo {
    protected int cilindraje;
    protected int peso;
    protected int tamanoTanque;

    public Vehiculo(int cilindraje, int peso, int tamanoTanque) throws AutonomiaException {
        if (cilindraje <= 0) {
            throw new AutonomiaException("El cilindraje debe ser mayor a 0.");
        }
        if (peso <= 0) {
            throw new AutonomiaException("El peso debe ser mayor a 0.");
        }
        if (tamanoTanque <= 0) {
            throw new AutonomiaException("El tamaño del tanque debe ser mayor a 0.");
        }

        
        this.cilindraje = cilindraje;
        this.peso = peso;
        this.tamanoTanque = tamanoTanque;
    }

    public abstract double calcularAutonomia();

    
    
    
    
    public void mostrarInfo() {
        System.out.println("Cilindraje: " + cilindraje + " cc");
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Tamaño del tanque: " + tamanoTanque + " galones");
        System.out.println("Autonomía estimada: " + calcularAutonomia() + " km\n");
    }
}
