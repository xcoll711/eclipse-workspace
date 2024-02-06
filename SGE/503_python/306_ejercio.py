"""
6. Crea un programa para gestionar una agenda básica de contactos de
manera interactiva. El programa debe tener las siguientes funciones:
a. agregar_contacto(agenda): Permite al usuario agregar un nuevo
contacto. Solicita al usuario el nombre, teléfono, correo electrónico
y ciudad del contacto. Verifica si ya existe un contacto con el mismo
nombre.
b. mostrar_contacto(agenda): Permite al usuario mostrar los detalles
de un contacto específico. Solicita al usuario el nombre del contacto
a mostrar.
c. mostrar_todos_los_contactos(agenda): Muestra al usuario todos los
contactos almacenados en la agenda.
d. Implementa un menú interactivo que permita al usuario elegir entre
las opciones anteriores, así como la opción para salir del programa.
Manejo de excepciones para que el usuario escoja opción válida.

"""

agenda = {}


def agregar_contacto(agenda):
    nombre = input("Introduzca el nombre: ")

    if nombre in agenda:
        print(f"Ya existe un contacto con el nombre {nombre}.")
    else:
        telefono = input("Introduzca el teléfono: ")
        email = input("Introduzca el email: ")
        ciudad = input("Introduzca la ciudad: ")
        agenda[nombre] = {"telefono": telefono, "email": email, "ciudad": ciudad}
        print("Añadido correctamente.")


def mostrar_contacto(agenda):
    nombre = input("Introduzca el nombre del contacto a mostrar: ")
    if nombre in agenda:
        print(f"\nNombre: {nombre}")
        print(f"Teléfono: {agenda[nombre]['telefono']}")
        print(f"Email: {agenda[nombre]['email']}")
        print(f"Ciudad: {agenda[nombre]['ciudad']}")
    else:
        print(f"Contacto {nombre} no encontrado.")


def mostrar_todos_los_contactos(agenda):
    print("\n--- Todos los Contactos ---")
    if not agenda:
        print("La agenda está vacía.")
    else:
      #  for nombre, datos in agenda.items():
            print(f"\nNombre: {nombre}")
            print(f"Teléfono: {datos['telefono']}")
            print(f"Email: {datos['email']}")
            print(f"Ciudad: {datos['ciudad']}")


while True:
    print("\n--- Agenda de Contactos ---")
    print("a. Mostrar Todos los Contactos")
    print("b. Agregar Contacto")
    print("c. Mostrar Contacto Específico")
    print("d. Salir")

    opcion = input("Introduzca una opción: ")

    # Opciones del menú
    if opcion == "a":
        mostrar_todos_los_contactos(agenda)
    elif opcion == "b":
        agregar_contacto(agenda)
    elif opcion == "c":
        mostrar_contacto(agenda)
    elif opcion == "d":
        print("Chaito!")
        break
    else:
        print("NO EXISTE ESA OPCIÓN")
