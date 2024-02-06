"""

Escribe un programa permita gestionar una agenda de contactos. El
programa debe proporcionar las siguientes opciones a través de un
menú interactivo:
a. Mostrar Agenda: Muestra todos los contactos en la agenda con
    sus respectivos detalles (nombre, teléfono, email).
b. Añadir Contacto: Permite al usuario añadir un nuevo contacto a
    la agenda proporcionando el nombre, teléfono y email.
c. Borrar Contacto: Permite al usuario eliminar un contacto de la
    agenda. Solicita el nombre del contacto a borrar.
d. Modificar Contacto: Permite al usuario modificar los detalles de
    un contacto existente. Solicita el nombre del contacto y ofrece
    opciones para modificar el teléfono o el email.
e. Salir.
    Utiliza un diccionario para almacenar los contactos. Implementa el
programa sin funciones, manejando las operaciones directamente en el
bucle principal.

"""


agenda = {}


while True:
    print("\n--- Agenda de Contactos ---")
    print("a. Mostrar Agenda")
    print("b. Añadir Contacto")
    print("c. Borrar Contacto")
    print("d. Modificar Contacto")
    print("e. Salir")
    
    opcion = input("Introduzca una opción: ")

    # Opciones del menú
    if opcion == "a":
        
        # Mostrar la agenda
        if not agenda:
            print("La agenda está vacía.")
        else:
            for nombre, datos in agenda.items():
                print(f"\nNombre: {nombre}")
                print(f"Teléfono: {datos['telefono']}")
                print(f"Email: {datos['email']}")
         
                
    elif opcion == "b":
    # Añadir un contacto
        nombre = input("Introduzca el nombre: ")

        if nombre in agenda:
            print(f"Ya existe un contacto con el nombre {nombre}.")
        else:
            telefono = input("Introduzca el teléfono: ")
            email = input("Introduzca el email: ")
            agenda[nombre] = {"telefono": telefono, "email": email}
            print("Añadido correctamente.")
            

    elif opcion == "c":
        # Borrar un contacto
        nombre = input("Introduzca el nombre del contacto a eliminar: ")
        if nombre in agenda:
            del agenda[nombre]
            print("Eliminado correctamente.")
        else:
            print(f"Contacto {nombre} no encontrado.")
    
 
    elif opcion == "d":
        # Modificar un contacto
        nombre = input("Introduce el nombre del contacto a modificar: ")
        
        if nombre in agenda:
            print("¿Qué desea modificar?")
            print("1. Teléfono")
            print("2. Email")
            opcion_modificacion = int(input("Introduzca una opción: "))
            if opcion_modificacion == 1:
                nuevo_telefono = input("Introduzca el nuevo teléfono: ")
                agenda[nombre]["telefono"] = nuevo_telefono
                print(f"Teléfono del contacto {nombre} actualizado.")
            elif opcion_modificacion == 2:
                nuevo_email = input("Introduzca el nuevo email: ")
                agenda[nombre]["email"] = nuevo_email
                print(f"Email del contacto {nombre} actualizado.")
            else:
                print("Opción no válida.")
        else:
            print(f"Contacto {nombre} no encontrado.")
    
    elif opcion == "e":
        print("¡Hasta pronto!")
        break
    else:
        print("Opción no válida. Inténtelo de nuevo.")

