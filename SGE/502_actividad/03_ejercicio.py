# Desarrolla un programa que pida un número por teclado y guarde en
# una lista su tabla de multiplicar hasta el 10. Por ejemplo, si pide el 5 la
# lista tendrá: 5,10,15,20,25,30,35,40,45,50

numero = int(input("Ingrese un número: "))

tabla = []

for i in range(1, 11):
    resultado = numero * i
    tabla.append(resultado)

print(f"La tabla de multiplicar de {numero} hasta el 10 es: {tabla}")
