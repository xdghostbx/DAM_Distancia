# Respostas ás preguntas da Tarefa03.1

    O comando para xenerar as clases de forma automatica é
        mvn clean generate-sources


    A etiqueta para permitir o borrado en cascada dos movementos da conta ao borrar a conta é

        cascade = CascadeType.REMOVE

        que ten que ir localizado na relacion oneToMany de Account a AccMovement