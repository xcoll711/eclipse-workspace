#Desarrolla un programa que pida al usuario un número entero positivo mayor que 2 y muestre por pantalla si es un número primo o no

num = int(input("Introduce un número entero positivo mayor o igual a 2: "))

if num <= 2:
    print("Número no válido. Debe ser mayor o igual a 2.")
else:
    es_primo = True
    #rango de 2 al número que se inserta
    for i in range(2,num-1):
        if num % i == 0:
            es_primo = False
            break

    if es_primo:
        print(f"{num} es un número primo.")
    else:
        print(f"{num} NO es un número primo.")
