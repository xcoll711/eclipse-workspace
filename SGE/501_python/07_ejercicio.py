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
    
    

# Preguntar al usuario si quiere a1
# Añadir valores


afegir = "X"
while afegir != "S" and afegir != "N":
   
    while  afegir != "N":
        afegir = input("¿Quieres añadir más valores? [S o N]: ").upper()

        if(afegir == "S"):
            nuevo_dato = float(input("Ingrese un nuevo dato: ")) 
            
            pos_dato = int(input("Ingrese su posición: "))
            while not (pos_dato <= len(llista)) and not (pos_dato >= 0) :
                pos_dato = int(input("Ingrese su posición: "))
            
            
            llista.insert(pos_dato,nuevo_dato)
            print(f"La lista ingresada es: {llista}")

        if(afegir =="N"):
            print("Chaito")




