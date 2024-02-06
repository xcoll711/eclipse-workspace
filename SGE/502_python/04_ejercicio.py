# Desarrolla un programa que pida números y guárdalos en una lista,
# cuando el usuario ingrese un 0 dejaremos de insertar. Por último,
# muestra los números ordenados de menor a mayor y viceversa.


numeros = []
numero = -1

while numero != 0:
    
    numero = int(input("Ingresa un número (ingresa 0 para terminar): "))
    numeros.append(numero)


print("\nNúmeros ordenados de menor a mayor:")
menor_mayor = sorted(numeros)
print(menor_mayor)

print("\nNúmeros ordenados de mayor a menor:")
mayor_menor = sorted(numeros, reverse=True)
print(mayor_menor)
