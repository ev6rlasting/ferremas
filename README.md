# FERREMAS

Proyecto Spring Boot para la gestión de productos, sucursales, autenticación y conversión de monedas, además de integración con Webpay.

---

## Tecnologías y dependencias principales

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- Spring Web
- Spring Security con JWT
- MySQL Connector
- Lombok
- Transbank SDK (Webpay)
- JAX-WS (para servicios SOAP)
- jjwt (JWT handling)

----

## Estructura del proyecto

### Controladores REST

- **AuthController**  
  Endpoints para autenticación vía JWT.
    - `POST /auth/login` — Recibe usuario y contraseña, devuelve un token JWT.

- **BancoCentralController**  
  Consulta valores de monedas y UF del Banco Central de Chile y realiza conversiones monetarias.  
  Endpoints incluyen:
    - `/dolar`, `/euro`, `/uf` — Obtienen el valor actual.
    - `/convertir/usdaclp`, `/convertir/clpausd`, `/convertir/ufaclp`, `/convertir/clpauf`, `/convertir/euroaclp`, `/convertir/clpaeuro` — Conversiones entre USD, CLP, UF y EUR.

- **ProductoController**  
  CRUD para productos con soporte para filtrado avanzado y manejo de sucursales asociadas.  
  Endpoints:
    - `POST /productos` — Crear producto.
    - `GET /productos/{id}` — Buscar producto por ID.
    - `GET /productos/filtrar` — Filtrar productos por nombre, categoría, marca, precio mínimo y stock mínimo.
    - `PUT /productos/{id}` — Actualización completa de producto.
    - `PATCH /productos/{id}` — Actualización parcial.
    - `DELETE /productos/{id}` — Eliminar producto.

- **SucursalController**  
  Gestión básica de sucursales y listado de productos asociados.  
  Endpoints:
    - `POST /sucursales` — Crear sucursal.
    - `GET /sucursales/{id}/productos` — Listar productos de una sucursal.

- **WebpayController**  
  Integración con Webpay para creación y confirmación de transacciones.  
  Endpoints:
    - `POST /webpay/crear` — Crear una transacción Webpay.
    - `GET /webpay/confirmacion` — Confirmar transacción con token.

---

## DTOs

- `ProductoResponseDto`  
  Record que contiene datos de producto para crear o actualizar:
  ```java
  public record ProductoResponseDto(
      String nombre,
      String categoria,
      String marca,
      Float precio,
      Long stock,
      List<Long> idsSucursal
  ) {}
