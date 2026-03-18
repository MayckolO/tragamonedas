# The Tragamonedas

Este proyecto es una implementación de un juego de Tragamonedas en Java, enfocado en la aplicación de principios de arquitectura de software y separación de responsabilidades.

## Autor
* **Nombre:** Mayckol Enrique Olivares Donoso

## Descripción del Proyecto
El proyecto simula el funcionamiento de una máquina tragamonedas con 3 ruedas. Se ha realizado una refactorización para mover la **Lógica de Negocio** (reglas de premios y cálculo de giro) desde la clase `Box` hacia la capa de servicios en `TragamonedasImpl`, cumpliendo con el patrón de diseño donde el modelo representa datos y el servicio la lógica.

## Estructura del Repositorio
* `/src`: Contiene el código fuente en Java.
* `/docs`: Contiene los diagramas de clases en formato PlantUML:
    * `tragamonedas-classes.puml`: Diagrama original.
    * `tragamonedas-classes-fixed.puml`: Diagrama con la lógica refactorizada.

## Instrucciones de Ejecución
1. Asegúrate de tener instalado **Java JDK 17** o superior.
2. Clona el repositorio: https://github.com/MayckolO/tragamonedas.git
3. Abre el proyecto en IntelliJ IDEA.
4. Ejecuta la clase TheMain.java ubicada en el paquete principal para iniciar la simulación.
---
(c) 2026 Arquitecturas de Software, DISC, UCN.
