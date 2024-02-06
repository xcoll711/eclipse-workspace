"""
3. Escribe una función que requiera una cantidad indefinida de argumentos. Lo que
hará esta función es devolver True si en algún momento se ha ingresado el
número cero repetido dos veces consecutivas.
Por ejemplo: (5,6,1,0,0,9,3,5) >>> True
(6,0,5,1,0,3,0,1) >>> False

El usuario ingresará el tamaño y datos de los argumentos.

"""

def doble_cero(*args):

    for i in range(len(args) - 1):
        if args[i] == 0 and args[i + 1] == 0:
            return True
    return False


tamanio = int(input("Ingrese la cantidad de números: "))
numeros = [int(input(f"Ingrese el número {i + 1}: ")) for i in range(tamanio)]

resultado = doble_cero(*numeros)
print(resultado)
