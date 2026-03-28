# Microservicios con Quarkus + API Gateway

Proyecto de microservicios desarrollado con **Quarkus**, **Panache** y **H2** como base de datos en memoria. Incluye un API Gateway que actúa como punto de entrada único para todos los servicios.

---

## 🏗️ Arquitectura

```
Cliente (Postman)
       |
       v
 [API Gateway]  → Puerto 8082
       |
       |──────────────────────────┐
       v                          v
[producto-service]         [orden-service]
   Puerto 8080               Puerto 8081
       |
       v
  [Base de datos H2]
   (en memoria)
```

---

## 📦 Proyectos

### 1. prueba_producto_service (Puerto 8080)
Servicio encargado de gestionar los productos. Usa **Panache** para persistencia con base de datos **H2 en memoria**.

**Endpoints:**
| Método | Ruta | Descripción |
|--------|------|-------------|
| `POST` | `/productos` | Crea un nuevo producto |
| `GET` | `/productos/{id}` | Obtiene un producto por ID |

**Tecnologías:**
- `quarkus-rest-jackson` — API REST con JSON
- `quarkus-hibernate-orm-panache` — Persistencia con Panache
- `quarkus-jdbc-h2` — Base de datos H2 en memoria

---

### 2. prueba_orden_service (Puerto 8081)
Servicio encargado de gestionar las órdenes. Llama al servicio de productos para verificar que el producto existe antes de crear la orden.

**Endpoints:**
| Método | Ruta | Descripción |
|--------|------|-------------|
| `POST` | `/ordenes` | Crea una orden dado un ID de producto |

**Tecnologías:**
- `quarkus-rest-jackson` — API REST con JSON
- `quarkus-rest-client-jackson` — Cliente REST para llamar a producto-service

---

### 3. api-gateway (Puerto 8082)
Punto de entrada único para todos los servicios. El cliente nunca necesita saber en qué puerto está cada servicio — solo habla con el gateway.

**Endpoints:**
| Método | Ruta | Descripción |
|--------|------|-------------|
| `POST` | `/api/productos` | Redirige a producto-service |
| `GET` | `/api/productos/{id}` | Redirige a producto-service |
| `POST` | `/api/ordenes` | Redirige a orden-service |

**Tecnologías:**
- `quarkus-rest-jackson` — API REST con JSON
- `quarkus-rest-client-jackson` — Cliente REST para llamar a los servicios

---

## 🚀 Cómo correr el proyecto

> ⚠️ Importante: Los servicios deben correrse en este orden.

### Requisitos
- Java 21
- Maven
- NetBeans (o cualquier IDE con soporte Maven)

### Paso 1 — Correr producto-service
```bash
cd prueba_producto_service
mvn quarkus:dev
```

### Paso 2 — Correr orden-service
```bash
cd prueba_orden_service
mvn quarkus:dev
```

### Paso 3 — Correr api-gateway
```bash
cd api-gateway
mvn quarkus:dev
```

---

## 🧪 Cómo probar con Postman

### 1. Crear un producto
```
POST http://localhost:8082/api/productos
Content-Type: application/json

{
    "name": "Laptop Gaming",
    "price": 1500.00
}
```

### 2. Obtener un producto
```
GET http://localhost:8082/api/productos/1
```

### 3. Crear una orden
```
POST http://localhost:8082/api/ordenes
Content-Type: application/json

1
```

---

## ⚠️ Notas importantes

- La base de datos es **en memoria (H2)** — cada vez que reinicias el servicio de productos, la base de datos se vacía.
- Siempre crea al menos un producto antes de intentar crear una orden.
- Los 3 servicios deben estar corriendo al mismo tiempo para que funcione correctamente.

---

## 👨‍💻 Autor
Desarrollado como práctica de microservicios con Quarkus.
