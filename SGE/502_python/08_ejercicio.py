# Escribe un programa en Python que solicite al usuario su nombre,
# primer apellido y segundo apellido. El programa debe construir y
# mostrar una cuenta de correo electrónico utilizando el siguiente
# formato: nombre.primerapellido.segundoapellido@iesjoanramis.org.
# Asegúrate de que la cuenta de correo resultante esté en minúsculas y
# sin espacios en blanco innecesarios al principio o al final de cada parte
# del nombre.


frase = input("Ingrese su nombre completo: ")
resultado = ""

for num in frase:
  
    if(num == any):
        resultado += "."
    else:
        resultado += num.lower()
        
resultado += "@iesjoanramis.org"
print(resultado)
        