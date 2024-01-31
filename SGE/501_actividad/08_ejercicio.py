#Escribe un programa que permite gestionar información sobre estudiantes.
#Usa diccionarios para representar cada estudiante e incluye información
#sobre su nombre, edad y calificaciones (3). Las calificaciones represéntalas a
#través de una tupla. Recorre la lista de estudiantes, imprime la información
#de cada uno e imprime el promedio de las calificaciones de cada estudiante.

estudiantes = {}

while True:
    print("\nMenú:")
    print("1. Mostrar estudiantes")
    print("2. Añadir estudiante")
    print("3. Modificar estudiante")
    print("4. Salir")

    opcion = input("Seleccione una opción (1-4): ")



    if opcion == "1":
        for nombre, info_estudiante in estudiantes.items():
            print("\nInformación del estudiante:")
            print("Nombre:", nombre)
            print("Edad:", info_estudiante["Edad"])
            print("Calificaciones:", info_estudiante["Calificaciones"])
            
            total_calificaciones = sum(info_estudiante["Calificaciones"])
            promedio = total_calificaciones / len(info_estudiante["Calificaciones"])
            
            print("Promedio de calificaciones:", promedio)



    elif opcion == "2":
        nombre = input("Ingrese el nombre del estudiante: ")
        edad = int(input("Ingrese la edad del estudiante: "))
        
        calificaciones = tuple(float(input(f"Ingrese la calificación {j + 1} del estudiante {nombre}: ")) for j in range(3))

        estudiantes[nombre] = {"Edad": edad, "Calificaciones": calificaciones}
        print(f"Estudiante {nombre} agregado.")



    elif opcion == "3":
        nombre = input("Ingrese el nombre del estudiante a modificar: ")
        
        if nombre in estudiantes:
            modificar = input ("Que deseas modificar? \n1. Edad \n2. Notas \nElige 1 o 2")
      
            if modificar == '1':
                nueva_edad = int(input("Ingrese la nueva edad: "))
                estudiantes[nombre]["Edad"] = nueva_edad

            elif modificar == '2':
                modificar = int(input("¿Cuál nota desea cambiar? \nIngrese el número correspondiente: (1 - 3)"))
                if modificar >=1 and modificar <= 3:
                    nueva_nota= float(input("¿Cual será la nueva nota?"))
                    estudiantes[nombre]["Calificaciones"][modificar -1] = nueva_nota
                    
                

            
            
            print(f"Estudiante {nombre} modificado.")
        else:
            print(f"No se encontró a {nombre}.")

    elif opcion == "4":
        print("Saliendo...")
        break

    else:
        print("Elige una opción entre 1 y 4.")
