package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class MainJCF {

    public static void main(String[] args) {
        // Utilizamos la implementación de PriorityQueue del Java Collection Framework
        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>();

        try {
            cargarPacientes(colaEmergencias, "C:\\Users\\ariel\\OneDrive\\Desktop\\HDT8\\HDT8\\src\\main\\java\\org\\example\\pacientes");
            procesarPacientes(colaEmergencias);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private static void cargarPacientes(PriorityQueue<Paciente> cola, String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea por comas, pero manteniendo la estructura de los campos
                String[] partes = linea.split(",", 3);
                if (partes.length == 3) {
                    String nombre = partes[0].trim();
                    String sintoma = partes[1].trim();
                    char codigoEmergencia = partes[2].trim().charAt(0);

                    Paciente paciente = new Paciente(nombre, sintoma, codigoEmergencia);
                    cola.add(paciente);
                    System.out.println("Paciente agregado: " + paciente);
                }
            }
        }
    }

    private static void procesarPacientes(PriorityQueue<Paciente> cola) {
        System.out.println("\nAtendiendo pacientes según prioridad:");
        while (!cola.isEmpty()) {
            Paciente paciente = cola.poll(); // poll() es equivalente a remove()
            System.out.println("Atendiendo: " + paciente);
        }
    }
}
