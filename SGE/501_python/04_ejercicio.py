#Desarrolla un programa de calculadora en Python que solicite al usuario ingresar dos números y una operación (todos los operadores aritméticos).
# El programa debe realizar la operación seleccionada y mostrar el resultado.
# Asegúrate de manejar adecuadamente la división por cero y proporciona mensajes de error en caso de entradas no válidas.

num1 = float(input("Ingrese el primer número: "))
num2 = float(input("Ingrese el segundo número: "))

operacion = input("Ingrese la operación a realizar (+, -, *, /): ")

if operacion not in ["+", "-", "*", "/"]:
    print("Error: Operación no válida")

else:
    if operacion == "+":
        resultado = num1 + num2
    elif operacion == "-":
        resultado = num1 - num2
    elif operacion == "*":
        resultado = num1 * num2
    elif operacion == "/":
        if num2 == 0:
            print("Error: División por cero")
        else:
            resultado = num1 / num2

    # Mostrar el resultado
    if operacion != "/" or num2 != 0:
        print("El resultado de la operación es:", resultado)