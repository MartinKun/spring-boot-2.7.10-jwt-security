
<p align = "center"> <img src = "https://res.cloudinary.com/dozwd1ssj/image/upload/v1681658892/banner_zjejwo.png" /> </p>
<h1>Implementación de Spring Boot 2.7.1 Security con JWT</h1>
<p>Este proyecto demuestra una implementación de seguridad utilizando Spring Boot 2.7.10 ay JSON Web Tokens (JWT) para autenticar y autorizar las solicitudes en una API RESTful.</p>
<h2>Funcionalidades:</h2>

- Registro de usuario y login con JWT authentication.
- Encriptación de contraseña utilizando BCrypt.
- Autorización basada en roles con Spring Security.
<br />
<h2>Tecnologías:</h2>

- Frameworks: Spring Boot 2.7.10, Spring Security 2.7.1, JPA y Hibernate
- Seguridad: JSON Web Tokens (JWT), BCrypt
- Manejo de dependencias: Maven
- Base de datos: MySQL
<br />
<h2>Cómo utilizar</h2>

Requerimientos: Primero necesitarás instalar lo siguiente:

- JDK 11+
- MySQL workbench

<p>Además, debes configurar las siguientes variables de entorno en tu sistema o en el archivo <code>application.yml</code>:</p>

- <code>DB_USERNAME</code>: nombre de usuario de la base de datos.
- <code>DB_PASSWORD</code>: contraseña del usuario de la base de datos.
- <code>EXPIRATION_TIME</code>: tiempo de expiración en horas del token.
- <code>SECRET_KEY</code>: clave de más de 256 bits para generar y verificar los tokens.

Una vez cumplidos estos pasos, puedes clonar el proyecto y ejecutarlo en tu IDE preferido.






