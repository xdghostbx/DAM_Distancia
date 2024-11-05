Proyecto de Gestión de Tareas
Descripción del Proyecto

Este proyecto se centra en el desarrollo de una aplicación para la gestión de tareas, en el que participan dos estudiantes del ciclo de Desarrollo de Aplicaciones Multiplataforma: Ana y Juan. A medida que avanzan en la implementación, se subraya la importancia de la documentación y las condiciones de sincronismo para garantizar que el software sea correcto, seguro y eficiente.
Requisitos de Calidad del Software

Los programas concurrentes deben cumplir con los siguientes requisitos de calidad:

    Seguridad:
        Prevenir que dos procesos accedan simultáneamente a una sección crítica.
        Respetar las condiciones de sincronismo entre productor y consumidor, asegurando que el consumidor no acceda a un dato que aún no ha sido producido y que el productor no produzca datos si el buffer está lleno.

    Vivacidad:
        Evitar condiciones de bloqueo activo (livelock), en las que los procesos no avanzan debido a interacciones continuas sin progreso.
        Prevenir el aplazamiento indefinido (starvation), donde un proceso no recibe el tiempo de CPU necesario para avanzar.
        Asegurar que no haya interbloqueos (deadlocks), donde los procesos quedan atrapados esperando recursos que nunca obtendrán.

    Eficiencia:
        Utilizar recursos de manera óptima, sin sobrecargar el sistema.
        Mantener rigurosidad en la implementación, asegurando que todas las funcionalidades esperadas se implementen correctamente y de forma concreta.

    Reusabilidad:
        Implementar el código de forma modular, utilizando clases, métodos y funciones.
        Documentar adecuadamente el código y el proyecto para facilitar su uso y mantenimiento futuros.

Propiedades del Software Concurrente

Los programas concurrentes deben satisfacer dos tipos de propiedades:

    Propiedades de Seguridad:
        Evitar estados erróneos durante la ejecución mediante el control de acceso a secciones críticas.

    Propiedades de Vivacidad:
        Asegurar que cada sentencia contribuya al progreso del programa.

Herramientas de Sincronización: Semáforos y Monitores

Para gestionar la concurrencia y la sincronización en el acceso a recursos compartidos, se utilizan herramientas como semáforos y monitores:

    Semáforos:
        Un semáforo es una variable que controla el acceso a un recurso compartido. Puede ser binario (semáforo que solo permite un acceso a la vez) o contar (que permite un número limitado de accesos simultáneos).
        Los semáforos ayudan a evitar condiciones de carrera al regular el acceso a secciones críticas del código.

    Monitores:
        Un monitor es un constructo de programación que proporciona una forma de encapsular el acceso a un recurso compartido, combinando la seguridad y la vivacidad.
        Dentro de un monitor, solo un hilo puede ejecutar su código a la vez, lo que permite una gestión más sencilla de la sincronización sin el uso explícito de semáforos.

Arquitecturas y Patrones de Diseño

La arquitectura del software es crucial y debe elegir entre varias opciones:

    Monolítica: Estructura de software acoplado donde todos los componentes están interrelacionados.
    Cliente-servidor: Distribución de cargas entre cliente y servidor, donde cada uno tiene roles definidos.
    Tres niveles: Separación en capas de presentación, cálculo y almacenamiento para una clara distribución de responsabilidades.
    Otros:
        Pipeline: Modela procesos en fases secuenciales.
        Entre pares: Todos los elementos actúan como clientes y servidores simultáneamente.
        En pizarra: Agentes que interactúan con un recurso compartido (la pizarra) para completar tareas.
        Orientada a servicios (SOA): Diseño de servicios interoperables e independientes de la plataforma.
        Dirigida por eventos: Se centra en la producción y respuesta a eventos.

Los patrones de diseño ofrecen soluciones reutilizables que facilitan la escalabilidad y el mantenimiento del software.
Documentación

La documentación es fundamental y debe incluir:

    Explicaciones claras y no redundantes sobre la funcionalidad del código.
    Uso de Javadoc para documentar clases, métodos y variables, enfatizando condiciones de sincronismo y recursos compartidos.
    Responder preguntas clave sobre la función y uso de cada componente del código.

Dificultades en la Depuración

La depuración de programas concurrentes presenta desafíos adicionales, como errores de temporización y sincronización. Es esencial utilizar herramientas específicas para facilitar la identificación y resolución de problemas, incluyendo:

    Depurador de IDE: El depurador de NetBeans está preparado para la depuración concurrente de hilos dentro de un mismo proceso.
    Volcados de actividad: Registros de actividad que ayudan a comprender el comportamiento durante la depuración.
    Herramientas específicas: TotalView y StreamIt Debugger Tool, entre otras, que ofrecen funcionalidades avanzadas para la depuración de programas concurrentes.

Validación de Programas Concurrentes

La validación requiere comprobar el correcto funcionamiento y orden de ejecución, así como las condiciones de sincronismo y la correcta implementación de las regiones críticas.
