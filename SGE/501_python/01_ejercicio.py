# Desarrolla un programa que pregunte dos números al usuario, calcule cual es el número mayor e imprima el resultado.

# Pedir los dos números al usuario
numero1 = int(input("Ingrese el primer número: "))
numero2 = int(input("Ingrese el segundo número: "))

# Encontrar el número
numero_mayor = max(numero1, numero2)

# Imprimir 
print("El número mayor es:", numero_mayor)