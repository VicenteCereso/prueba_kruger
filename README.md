Requisitos Previos
- Instalar Docker y Docker Compose.


Pasos para instalar y levantar servicios de postgresql 
	-En cmd ejecutado como administrador ingesamos a la carpeta postgresql donde esta el archivo docker-compose.yml
	-Despues ejecutamos   -->	docker-compose up -d
	-Verificamos que el servicio se encuentre activo  ->  docker ps
	-Podemos conectarnos a la BD mediante un IDE (Dbeaver, PgAdmin)
Nota: Si tenemos el cliente SQL DBeaver, una vez arrancado el contenedor, podremos conectarnos con este cliente multi plataforma ingresando los siguientes datos:
		Server host: localhost
		Port: 5432
		User name: kruger
		Password: kruger
		
Pasos para levantar imagen de proyecto Vacunacion
Ingresamos a la ruta: \Kruger\vacunacion\src\main\resources
	-En el archivo Dockerfile editamos la siguiente linea:
		spring.datasource.url= jdbc:postgresql://localhost:5432/prueba_kruger
		Reemplazamos localhost con la ip de la pc o servidor que vamos a levantar el servicio
	
	- Ejecutamos la siguiente linea en un cmd, preferible ejecutado como administrador 
			docker build -t kruger:kruger-prueba .         //Sirve para compilar el proyecto
			
	- Ejecutamos la siguiente linea para levantar finalmente el servicio
			docker run  --name kruger --publish 8003:8003 kruger:kruger-prueba -d
	

En la ruta \Kruger encontraremos el archivo insertRoles.sql lo ejecutamos en nuestro IDE de BD 

Ingresamos en un navegador la siguiente url y podremos visualizar la documentacion de las API
	http://localhost:8003/swagger-ui.html