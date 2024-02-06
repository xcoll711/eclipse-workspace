"""
4. Escribe una función llamada que a partir de dos números cumpla lo
siguiente:
a. Si el primer número es mayor que el segundo, debe devolver 1.
b. Si el primer número es menor que el segundo, debe devolver -1.
c. Si ambos números son iguales, debe devolver un 0.
d. Comprueba la relación entre los números: '5 y 10', '10 y 5' y '5 y 5'.

"""
comparar_numeros = lambda num1, num2: 1 if num1 > num2 else (-1 if num1 < num2 else 0)

print(f'5 y 10: {comparar_numeros(5, 10)}')
print(f'10 y 5: {comparar_numeros(10, 5)}')
print(f'5 y 5: {comparar_numeros(5, 5)}')


