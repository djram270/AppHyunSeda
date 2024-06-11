# Ingeniería de Software II Proyecto final - Universidad del Cauca 

## Integrantes:
- Stiven Alirio Chanchi Dizu
- Samuel Guilombo Gomez
- Miguel Angel Polo Gomez
- Oscar Andres Tosne Perez

# Introducción
Este proyecto tiene como objetivo desarrollar una aplicación para HYUN SEDA, una empresa especializada en productos de seda.
La aplicación permitirá a los clientes realizar compras de productos de manera eficiente y conveniente. El producto final demuestra las habilidades adquiridas a lo largo de la materia.

El proyecto integra los siguientes componentes tecnológicos:

- Microservicios: Arquitectura basada en microservicios para modularizar la aplicación.
- Documentación de APIs REST con Swagger: Utilización de Swagger para documentar las APIs REST.
- Autenticación y autorización con JWT: Implementación de autenticación y autorización utilizando JSON Web Tokens (JWT).
- Patrón Hexagonal: Aplicación del patrón arquitectónico hexagonal para una mayor flexibilidad y mantenibilidad del código.

# Demo
[![](https://markdown-videos.deta.dev/youtube/jPCULxc54gM)](https://youtu.be/jPCULxc54gM)

# Requisitos
### Requisitos funcionales

1. **Como visitante (Usuario No Registrado) del e-commerce:**
   - Me gustaría ver los productos listados, así como su clasificación por categoría.
     - Un producto puede pertenecer a muchas categorías y una categoría puede asociar muchos productos.

2. **Como visitante (Usuario No Registrado):**
   - Me gustaría ver publicaciones relacionadas con la seda y su proceso a través de un blog.

3. **Como administrador:**
   - Me gustaría realizar las siguientes acciones:
     - **Gestionar las publicaciones del blog (CRUD):**
       - Cada post debe tener: title, keywords, short description, HTML content.
     - **Gestionar los productos del e-commerce (CRUD):**
       - Cada producto posee: ID, name, descripción, slug, price, stock, keywords, images, characteristics, categories.
     - **Importar y Exportar productos a través de archivos CSV:**
       - Esto para reducir el tiempo de actualización masiva de registros.
     - **Gestionar la información y configuración de la empresa:**
       - La información de la empresa incluye la razón social, los datos de contacto, y algunas variables para que el sistema se comporte de una determinada manera.

4. **Como super administrador:**
   - Me gustaría gestionar los usuarios administradores del sistema:
     - Deshabilitar, registrar, editar, eliminar, buscar.

5. **Como usuario registrado:**
   - Necesito tener un login para acceder al dashboard del sistema con email y password.

6. **Para los usuarios registrados:**
   - Se debe crear un dashboard que contenga las acciones permitidas para cada usuario en un panel lateral:
     - **Editor:**
       - Se encarga de hacer el CRUD de publicaciones para el blog.
     - **Administrador:**
       - Se encarga de la gestión de los productos, así como del blog.
     - **Super Administrador:**
       - Posee los permisos del administrador y adicionalmente puede gestionar los demás usuarios (Administrador y Editor).
       - Solo se permite el ingreso de un Super Administrador.
         
### Requisitos no funcionales

Tomando en cuenta los requerimientos no funcionales en [2]:

### 1. Seguridad

- **Autenticación:**
  - El sistema debe garantizar que únicamente los usuarios registrados tengan acceso al dashboard de administración. Solo el super administrador podrá registrar a los nuevos usuarios administradores. El registro autónomo de usuarios está deshabilitado.

- **Autorización:**
  - El sistema debe limitar las acciones de todos los usuarios dependiendo del rol que asuman.

- **Ocultamiento de la información:**
  - En el dashboard, así como en cualquier otra vista del sistema, el usuario registrado solo podrá ver las acciones y la información que su rol le permita.

### 2. Desempeño (Performance)

- **Carga de Imágenes:**
  - Para evitar que la base de datos aumente exponencialmente de tamaño debido a la carga de imágenes, se debe hacer uso de servicios autogestionados de almacenamiento de archivos multimedia como AWS S3, Google Cloud Storage, Azure Blob Storage, o cualquier otro servicio que permita la gestión de estos archivos. En la base de datos, solamente debe reposar la URL y algún tipo de identificador al objeto guardado en el Storage.

### 3. Escalabilidad

- **Arquitectura basada en microservicios:**
  - La arquitectura basada en microservicios con Spring Boot permite modularizar los sistemas y escalar componentes individualmente según sea necesario, asegurando así una escalabilidad eficiente del sistema.


# Historias de usuario
En el siguiente hipervinculo está el Excel con las historias de usuario: [Link de hojas de calculo](https://docs.google.com/spreadsheets/d/1grr7-cVlL6LpZ4J6KunZALOGq2nD-ev1lSFFSVl4Vtc/edit?usp=sharing).

# Decisiones de arquitectura

### 1. Tipo de Aplicación

En el contexto de desarrollar la aplicación para la empresa de producción de seda sostenible Hyun Seda, nos hemos decidido por una aplicación web. Descartamos las opciones de escritorio y móvil para crear un producto accesible desde cualquier navegador web, lo cual es más amigable para el usuario y no requiere instalación adicional.

### 2. Funcionalidad de pagos

Para permitir diferentes métodos de pago, hemos optado por la arquitectura basada en microservicios. Descartamos los microkernels e incorporación directa debido a su menor modularidad y escalabilidad. Aceptamos que esto requerirá un mayor esfuerzo en la gestión y comunicación entre los servicios.

### 3. Lógica de presentación

Con el objetivo de mantener una separación clara entre la lógica de negocio y la presentación de datos, hemos elegido el modelo MVC (Modelo-Vista-Controlador). Descartamos la actualización de datos por eventos para lograr una estructura organizada y modular, lo que facilita la reutilización de código y la gestión del crecimiento del proyecto.

### 4. Aplicación escalable

Para desarrollar una aplicación escalable y fácil de mantener, hemos optado por la arquitectura en capas. Descartamos la opción de microkernel en toda la aplicación. Aceptamos que esta elección puede tener un rendimiento ligeramente inferior, pero la arquitectura de capas nos permite dividir la aplicación en componentes bien definidos, facilitando el desarrollo y la evolución del sistema a lo largo del tiempo.

### 5. Arquitectura Hexagonal para el Microservicio de Producto

Con el objetivo de mejorar la flexibilidad y capacidad de mantenimiento del microservicio de producto, hemos decidido convertirlo a una arquitectura hexagonal. Descartamos mantener la arquitectura monolítica para lograr una mejor separación de preocupaciones y facilitar la integración con otros servicios. Aceptamos que esto introduce complejidad adicional en la configuración inicial y el diseño.

# Documentacion con swagger

- **End points de autorizacion**
![image](https://github.com/djram270/AppHyunSeda/assets/163693837/d2f89c06-422d-4306-abf0-ba26796eb6b6)

- **End point de productos**
![image](https://github.com/djram270/AppHyunSeda/assets/163693837/c4bd2b8a-f781-4757-a6b1-17041bdceaa4)

- **End point de categorías**
![image](https://github.com/djram270/AppHyunSeda/assets/163693837/ec5aaf28-8416-4710-8470-eeb70275b556)

# Pruebas Unitarias
![imagen](https://github.com/djram270/AppHyunSeda/assets/54742876/cb2672ed-c6e1-4b8b-a760-829995b6754a)


