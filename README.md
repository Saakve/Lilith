# Lilith
Imitación de [ELIZA](https://en.wikipedia.org/wiki/ELIZA) (Chat bot) para un proyecto escolar.

Este repositorio levanta un servidor web sirviendo los estáticos de la ruta src/main/resources/public
de un [proyecto](https://github.com/Saakve/Lilith-frontend) hecho con React así como un endpoint para darle vida al pequeño Chat bot.

# ¿Cómo iniciar el servidor?
## Con Maven
### Windows
* Abrir el CMD
* Ir a la raiz del proyecto
* Y ejecutar: <code>mvnw spring-boot:run</code>

### MacOS/Linux:
* Abrir la línea de comandos
* Ir a la raíz del proyecto
* Y ejecutar: <code>./mvnw spring-boot:run</code>

## Con Docker
<b>Advertencia para Windows.</b> El archivo <code>mvnw</code> debe tener saltos de línea de linux antes de construir la imagen, [fuente](https://stackoverflow.com/questions/61226664/build-docker-error-bin-sh-1-mvnw-not-found). La forma más fácil de lograrlo es ejecutando el comando <code>dos2unix mvnw</code> integrado en la terminal Git Bash.

* Abrir la línea de comandos o CMD dependiendo del SO.
* Ir a la raiz del proyecto
* Ejecutar el comando <code>docker build --tag lilith .</code>
* Correr un contenedor de la imagen exponiendo el puerto 8080 <code>docker run -d -p 8080:8080 lilith</code>
