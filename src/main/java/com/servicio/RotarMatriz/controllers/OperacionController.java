package com.servicio.RotarMatriz.controllers;

import com.servicio.RotarMatriz.utils.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "operaciones")
public class OperacionController {

    @Autowired
    private Utilidades utilidades;


    @PostMapping(value = "/rotarmatriz", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> PostRotarMatrizAntihorario(@RequestBody  String[][] matriz){
        Map<String,Object> response = new HashMap<>();
        try{
            String[][] nuevaMatriz = utilidades.GenerarMatrizAntihorario(matriz);
            response.put("Mensaje","Se rotó la matriz en sentido antihorario");
            response.put("Nueva matriz",nuevaMatriz);
        }
        catch (Exception e){
            response.put("Mensaje","Ocurrio un error");
            response.put("Error",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/rotarmatrizjson", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public  ResponseEntity<?>  PostRotarMatrizAntihorarioJson(@RequestBody  Map<String,Object> matrizJson){

        Map<String,Object> response = new HashMap<>();
        String[][] matriz = null;
        ArrayList<ArrayList<String>> listaArray;
        // Obtiene el valor de la llave encontrada, para este caso la llave fue "array".
        for (Map.Entry<String, Object> pair : matrizJson.entrySet()) {
            // Almacena el valor del map en una lista de arrays
            listaArray = (ArrayList<ArrayList<String>>) pair.getValue();
            // Convierte la lista de array en una matriz bidimencional
            matriz  = listaArray.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        }
        try{
            String[][] nuevaMatriz = utilidades.GenerarMatrizAntihorario(matriz);
            response.put("Mensaje","Se rotó la matriz en sentido antihorario");
            response.put("Nueva matriz",nuevaMatriz);
        }
        catch (Exception e){
            response.put("Mensaje","Ocurrio un error");
            response.put("Error",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


}
