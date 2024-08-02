## Entregable
A) Objetivo : Crear minimo endpoint con JAVA hasta N (spring boot java) utilizando SOAP para consumir una API
tipo rest https://pokeapi.co/api/v2/pokemon/
El desarrollo consiste en consumir la API rest de https://pokeapi.co/ y en base a lo que retorna crear un endpoint en SOAP con los siguientes
métodos:
- abilities
- base_experience
- held_items
- id
- name 
- location_area_encounters

Todos los métodos antes mencioandados tienen que aceptar como parámetro requerido un String, este String sera el nombre del
pokemon, ya que la búsqueda tiene ser el consumo en tiempo real de la API https://pokeapi.co/

B) Se tiene que guardar en una base de datos h2, mysql, etc. Los request de las peticiones guardando como variables:
- ip de origin
- fecha de request
- método que se ejecuta

#Desarrollo
1.- Cambiar directorio :
```
cd pokemon
```
2.- Limpiar el proyecto y crear el .jar
```
 mvn clean install
```
4.- Ejecutar la applicacion
```
 java -jar target/pokemon-0.0.1-SNAPSHOT.jar
```
5.- Ejecutar test
```
curl --header "content-type: text/xml" -d @pikachu.xml http:/localhost:8080/ws > output.xml
```
```
curl --header "content-type: text/xml" -d @ditto.xml http:/localhost:8080/ws > output.xml
```