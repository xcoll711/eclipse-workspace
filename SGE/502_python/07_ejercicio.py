# Crea un programa que pida una frase o un nombre con apellidos al
# usuario y que imprima solo las iniciales de las palabras que contiene la
# frase. Si el usuario ingresa “Joan Pons” el programa mostrará “JP”.

frase = input("Ingrese una frase o nombre con varias palabras: ")
es_inicial = True
resultado = ""
for num in frase:
    if(es_inicial == True):
        resultado += num.upper()
        es_inicial = False
    else:
        if(num == " "):
            es_inicial = True

print(resultado)
        