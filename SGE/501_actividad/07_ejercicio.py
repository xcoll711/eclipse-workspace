midaLlista = int(input("Ingrese el tamaño de la lista: "))

llista = []

for i in range(midaLlista):
    valor = float(input(f"Ingrese el valor {i + 1}: "))
    llista.append(valor)

if midaLlista > 0:
    promedio = sum(llista) / midaLlista
    print(f"La lista ingresada es: {llista}")
    print(f"El promedio de los valores en la lista es: {promedio}")
else:
    print("La lista está vacía. No se puede calcular el promedio.")
