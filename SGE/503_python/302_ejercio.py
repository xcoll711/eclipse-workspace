"""
Realiza una función separar() que tome una lista de números enteros y
devuelva dos listas ordenadas. La primera con los números pares y la
segunda con los números impares.
"""

def separar(numeros):
    pares = []
    impares = []

    for numero in numeros:
        if numero % 2 == 0:
            pares.append(numero)
        else:
            impares.append(numero)

    pares.sort()
    impares.sort()

    return pares, impares

numeros = [1,2,3,4,5,6,7,8,9]
pares, impares = separar(numeros)

print("Pares:", pares)
print("Números impares:", impares)
