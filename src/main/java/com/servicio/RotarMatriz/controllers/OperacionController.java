package com.servicio.RotarMatriz.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "operacion")
public class OperacionController {

    @PostMapping(value = "/RotarMatriz", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public  ResponseEntity<?>  PostRotarMatriz(@RequestBody  Map<String,Object> map){

        Map<String,Object> response = new HashMap<>();
        String[][] matriz = null;
        ArrayList<ArrayList<String>> mainList = new ArrayList<ArrayList<String>>();
        for (Map.Entry<String, Object> pair : map.entrySet()) {
            mainList = (ArrayList<ArrayList<String>>) pair.getValue();
            matriz = mainList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        }
        try{
            String[][] nuevaMatriz = this.GenerarMatrizAntihorario(matriz);
            response.put("Mensaje","Se rotó la matriz en sentido antihorario");
            response.put("Nueva matriz",nuevaMatriz);
        }
        catch (Exception e){
            response.put("Mensaje","Ocurrio un error");
            response.put("Error",e.getMessage());
            return new ResponseEntity< Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity< Map<String,Object>>(response, HttpStatus.OK);

    }

    @PostMapping(value = "/RotarMatriz2", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> PostRotarMatriz(@RequestBody  String[][] matriz){
        Map<String,Object> response = new HashMap<>();
        try{
            String[][] nuevaMatriz = this.GenerarMatrizAntihorario(matriz);
            response.put("Mensaje","Se rotó la matriz en sentido antihorario");
            response.put("Nueva matriz",nuevaMatriz);
        }
        catch (Exception e){
            response.put("Mensaje","Ocurrio un error");
            response.put("Error",e.getMessage());
            return new ResponseEntity< Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity< Map<String,Object>>(response, HttpStatus.OK);
    }

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
