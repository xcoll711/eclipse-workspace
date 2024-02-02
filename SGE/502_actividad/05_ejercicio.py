# Desarrolla un programa que cree un diccionario para guardar los precios
# de las distintas frutas. El programa pedirá el nombre de la fruta y la
# cantidad que se ha vendido y nos mostrará el precio final de la fruta a
# partir de los datos guardados en el diccionario. Si la fruta no existe nos
# dará un error. Tras cada consulta el programa nos preguntará si
# queremos hacer otra consulta.


precios = {
    'manzana' : 0.5,
    'banana' : 0.6,
    'plátano de canarias' : 500.5,
    'tomate': 1.5,
    'lichi': 0.9,
    'pera': 2,
    'mandarina': 1,
}

while True:

    fruta = input("Ingresa el nombre de la fruta (o 'salir' para terminar): ").lower()

    if fruta == 'salir':
        break

    if fruta in precios:
    
            cantidad = float(input(f"Ingresa la cantidad de {fruta} vendida: "))

            precio_total = cantidad * precios[fruta]

            print(f"El precio total de {cantidad} {fruta} es: {precio_total} €\n")
     
    else:
        print(f"Lo siento, la fruta '{fruta}' no existe.\n")

print("Chaito!")
