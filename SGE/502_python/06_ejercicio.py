# 6. Desarrolla un programa que cree un diccionario donde la clave sea el
# nombre del usuario y el valor sea el teléfono (no es necesario validar).
# Tendrás que ir pidiendo contactos hasta que el usuario diga que no
# quiere insertar más. No se podrán ingresar nombres repetidos.


telefonos = {}
existe = False

while True:
    
    nombre = input("Agenda de contactos\nIngrese el nombre del nuevo contacto (o 'salir' para salir):\n")
   
    if nombre.lower() == 'salir':
        break   
    
    for num in telefonos:
        if nombre == num:
            print("\nEl nombre ya existe en la agenda.\n")
            existe = True
            continue
        
    if (existe == False):
        telefono = input("Ingrese su número de teléfono:\n")
        telefonos[nombre] = telefono
    
    existe = False

    
print("Lista de contactos:")
print(telefonos)
