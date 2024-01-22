# Desarrolla un programa/ juego “Adivina el Número”. El programa
# escogerá un número aleatorio entre 1 y 20, y te pedirá que intentes
# adivinarlo. Te dirá si cada intento es muy alto o muy bajo. Además te dirá
# cuántos intentos llevas. Gana si adivinas el número en seis intentos o
# menos. Muestra finalmente un mensaje con el nombre del jugador,
# numero de intentos y numero adivinado.

import random;

intentos = 0
numero_aleatorio = random.randint(1, 20)
numero_jugador = 0

print("Adivina el Número!")

while intentos < 6:
    intentos += 1
    try:
        numero_jugador = int(input(f"Intento {intentos}: Adivina el número entre 1 y 20: "))
        if numero_jugador == numero_aleatorio:
            print(f"Adivinaste el número {numero_aleatorio} en {intentos} intentos!!!")
            break
        elif numero_jugador < numero_aleatorio:
            print("El número es mayor. Intenta de nuevo.")
        else:
            print("El número es menor. Intenta de nuevo.")
    except ValueError:
        print("Por favor, introduce un número válido.")

if intentos == 6 and numero_jugador != numero_aleatorio:
    print(f"Lo siento, no adivinaste el número {numero_aleatorio} en 6 intentos. Juega de nuevo!")