package com.servicio.RotarMatriz.utils;

import org.springframework.stereotype.Component;

@Component
public class Utilidades {

    public String[][] GenerarMatrizAntihorario(String[][] matrizOriginal){

        int tamanioMatrizOriginal = matrizOriginal.length;
        String[][] nuevaMatriz = new String[tamanioMatrizOriginal][tamanioMatrizOriginal];

        for (int fila=0; fila<tamanioMatrizOriginal; fila++) {
            for (int columna=0; columna<tamanioMatrizOriginal; columna++) {
                nuevaMatriz[tamanioMatrizOriginal-1-columna][fila] = matrizOriginal[fila][columna];
            }
        }
        return nuevaMatriz;
    }
}
