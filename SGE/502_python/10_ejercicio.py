"""
Escribe un programa que muestre un menú interactivo con las siguientes opciones:
a. Crear una lista nueva con números enteros aleatorios.
b. Imprimir la lista. Si la lista no ha sido creada, mostrar un mensaje
    de aviso.
c. Mostrar el mayor número de la lista. Si la lista no ha sido creada,
    mostrar un mensaje de aviso.
d. Mostrar el menor número de la lista. Si la lista no ha sido creada,
    mostrar un mensaje de aviso.
e. Sumar los números de la lista. Si la lista no ha sido creada,
    mostrar un mensaje de aviso.
f. Calcular el promedio de la lista. Si la lista no ha sido creada,
    mostrar un mensaje de aviso.
g. Salir del programa.

El programa debe permitir al usuario seleccionar una opción del menú y
realizar la operación correspondiente. La lista de números debe ser
creada mediante la opción 1 y luego utilizada para realizar las
operaciones de las opciones restantes. Además, el programa debe
verificar si la lista ha sido creada antes de realizar operaciones que
requieran su existencia, mostrando mensajes de aviso en caso
contrario. El programa debe continuar ejecutándose hasta que el
usuario seleccione la opción para salir.

"""

import random

lista_numeros = None

def crear_lista():
    return random.sample(range(100), 10 )

def imprimir_lista(lista):
    if lista:
        print("Lista actual:", lista)
    else:
        aviso()

def mayor(lista):
    if lista:
        print("El mayor número es:", max(lista))
    else:
       aviso()

def menor(lista):
    if lista:
        print("El menor número es:", min(lista))
    else:
        aviso()

def sumar(lista):
    if lista:
        print("La suma de la lista es:", sum(lista))
    else:
        aviso()

def promedio(lista):
    if lista:
        promedio = sum(lista) / len(lista)
        print("El promedio de la lista es:", promedio)
    else:
        aviso()

def aviso():
        print("¡¡¡¡Crea una lista primero!!!!")



while True:
    print("\nMenú:")
    print("a. Crear una lista nueva")
    print("b. Imprimir la lista")
    print("c. Mostrar el mayor número")
    print("d. Mostrar el menor número")
    print("e. Sumar los números")
    print("f. Calcular el promedio")
    print("g. Salir")

    opcion = input("Selecciona una opción: ")

    if opcion == 'a':
        lista_numeros = crear_lista()
        print("Lista creada:", lista_numeros)
    elif opcion == 'b':
        imprimir_lista(lista_numeros)
    elif opcion == 'c':
        mayor(lista_numeros)
    elif opcion == 'd':
        menor(lista_numeros)
    elif opcion == 'e':
        sumar(lista_numeros)
    elif opcion == 'f':
        promedio(lista_numeros)
    elif opcion == 'g':
        print("¡Hasta luego!")
        break
    else:
        print("Opción no válida. Inténtalo de nuevo.")

