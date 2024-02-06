"""
5. Escribe un programa en Python que utilice múltiples funciones para realizar
operaciones matemáticas con dos números ingresados por el usuario. Cada
función debe llevar a cabo una tarea específica. Maneja excepciones
división por cero, entradas no numéricas.
"""

def suma(a, b):
    return a + b

def resta(a, b):
    return a - b

def multiplicacion(a, b):
    return a * b

def division(a, b):
    return a / b if b != 0 else "NO SE PUEDE DIVIDIR POR CERO"

try:
    num1 = float(input("Ingrese el primer número: "))
    num2 = float(input("Ingrese el segundo número: "))
    
    print(f"Suma: {suma(num1, num2)}")
    print(f"Resta: {resta(num1, num2)}")
    print(f"Multiplicación: {multiplicacion(num1, num2)}")
    print(f"División: {division(num1, num2)}")

except ValueError:
    print("ENTRADA NO NUMÉRICA")
except Exception as e:
    print(f"Error: {e}")


