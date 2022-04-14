Compilar y ejecutar el proyecto
Para copilar el proyecto se requiere Java y Maven instalado, ademas de libreria lombock la cual se explica como instalar en documento instalarLombok.doc

Abrir Carpeta manuelMarin en ide STS( Spring Tools 4 for Eclipse)
--> File --> Import --> Existing Maven Project --> Browse... --> Seleccionar Carpeta manuelMarin
Sobre el archivo POM hacer click derecho
-->Run AS --> Maven Install

En la vista Boot DashBoard
--> Click derecho proyecto manuelMarin
--> Click en (Re Star)

Nota: Debe estar disponible el puerto 8021 en el PC donde se ejecute esta API
Nota2: Servicio GET URL http://127.0.0.1:8021/validacionFecha
curl -X GET --header 'Accept: application/json' 'http://127.0.0.1:8021/validacionFecha'
