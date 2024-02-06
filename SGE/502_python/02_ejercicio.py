# Desarrolla un programa que cree una tupla con los meses del año, pide
# números al usuario, si el numero esta entre 1 y la longitud máxima de la
# tupla, muestra el contenido de esa posición sino muestra un mensaje de
# error. El programa termina cuando el usuario introduce un cero.

meses = ("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Augusto", "Septiembre", "Oktoberfest", "Noviembre", "Diciembre")

numero = int(input("Elige un número del 1 al 12 =>"))

if 0 < numero  <= len(meses):
    print(meses[numero -1])
else:
    print("Muy mal, te he dicho que entre 1 y 12")
