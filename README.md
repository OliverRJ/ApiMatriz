# ApiMatriz
Servicio para rotar matriz en sentido antihorario.

## Consideraciones:
- JDK versión 17.0.3.1
- Apache Maven version 3.8.5
- Sprint boot version 2.6.7
- Intellij IDEA Community Edition 2022.1 como IDE de desarrollo.
- Visual Studio Code con Thunder Client para simular las peticiones al api
- Swagger como herramienta de documentación y pruebas.

## Comandos para Docker:
1. Primero construimos la imagen con el nombre "api-matriz".
```docker
docker build -t "api-matriz" .
```
2. Luego verificamos que se ha creado la imagen.
```docker
docker images
```
3. A continuación levantamos la imagen creada especificando el puerto.
```docker
docker run --name java-app -p 8081:8080 api-matriz:latest 
```
4. Comprobamos que el contenedor haya sido creado y esté activo.
```docker
docker ps -a  
```
5. Verificamos que la imagen esté funcionando.


## ¿Cómo probar el api rest?
Para el api se creó dos formas de enviar los paramámetros al servicio, en la primera forma se envía la matriz directamente y en la segunda se envía con la estructura de clave y valor.

- Primera Forma
1. Llamar al método post:  http://localhost:8080/operaciones/rotarmatriz
2. Ingresar la matriz de datos:
```json
{
  [ [1,2,3], 
    [4,5,6],
    [7,8,9]
  ]
}
```
- Segunda Forma
1. Llamar al método post: http://localhost:8080/operaciones/rotarmatrizjson
2. Ingresar la matriz de datos:
```json
{
    "array": 
    [
        [  "1", "2"],
        [  "3", "4" ]
    ]
}
```
- Verificando mensaje en caso de error
![Image text](https://raw.githubusercontent.com/OliverRJ/imagenes/main/apimatriz/error.png)

## Usar swagger para realizar pruebas:
Para realizar las pruebas del servicio se puede usar postman o thunder client, pero se agregó swagger para que lo puedan probar directamente sin la necesidad de algún otro programa.

1. ingresar a swagger: http://localhost:8080/swagger-ui/index.html#/
2. Colocar los datos de ingreso de acuerdo a la forma a probar.
3. Verificando el servicio:
![Image text](https://raw.githubusercontent.com/OliverRJ/imagenes/main/apimatriz/swagger.png)
