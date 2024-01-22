#Desarrolla un programa que pregunte el nombre del usuario, un número entero e imprima por pantalla en líneas distintas el nombre del usuario tantas veces como el número introducido.

nombre = input("Ingrese su nombre: ")

numero = int(input("Ingrese un número entero: "))

for i in range(numero):
    print(nombre)