"""
1. Crea una función llamada saludo_personalizado que tome dos parámetros,
nombre y edad, y muestre un mensaje de saludo que incluya tanto el
nombre como la edad del usuario. Agrega manejo de excepción por si el
usuario ingresa la edad que no sea número entero.

"""

def saludo_personalizado(nombre, edad):
    try:
        edad_entero = int(edad)
        mensaje = f"Hola {nombre}! Tienes {edad_entero} años."
        print(mensaje)
    except ValueError:
        print("ERROR Edad que no es número entero.")

# Ejemplos de uso:
nombre = input("Tu nombre: ")
edad = input("Tu edad: ")

saludo_personalizado(nombre, edad)
