package com.servicio.RotarMatriz.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servicio.RotarMatriz.models.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "operacion")
public class OperacionController {

    @PostMapping(value = "/RotarMatriz", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public  String test2(@RequestBody  Map<String,Object> map){
       /* ObjectMapper mapper = new ObjectMapper();
        String jsonArray = null;
        try {
            //Don't need Gson, can use writerWithDefaultPrettyPrinter with Jackson which
            //You are already using
            jsonArray = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonArray;*/
        String[][] stringArray = null;
        ArrayList<ArrayList<String>> mainList = new ArrayList<ArrayList<String>>();
        for (Map.Entry<String, Object> pair : map.entrySet()) {
            mainList = (ArrayList<ArrayList<String>>) pair.getValue();
            stringArray = mainList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        }

        return "Resultado" + stringArray[1][1];

    }
    @PostMapping(value = "/RotarMatriz2", consumes = { MediaType.APPLICATION_JSON_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public int[][] rotarCuadrado90Grados(@RequestBody int [][] matOriginal){
        int fil = matOriginal.length;
        int col = matOriginal[0].length;
        int contFil = 0;
        int contCol = 0;
        int[][] matNueva = new int [fil][col];
        for (int i = fil; i >= 0; i--)
        {
            contCol =  0;
            for (int j = col; j >= 0; j--)
            {
                matNueva[contFil][contCol] = matOriginal[i][j];
                contCol ++;
            }
            contFil ++;
        }
        return matNueva;
    }

}
