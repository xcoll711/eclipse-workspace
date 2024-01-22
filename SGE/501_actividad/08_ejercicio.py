#Escribe un programa que permite gestionar información sobre estudiantes.
#Usa diccionarios para representar cada estudiante e incluye información
#sobre su nombre, edad y calificaciones (3). Las calificaciones represéntalas a
#través de una tupla. Recorre la lista de estudiantes, imprime la información
#de cada uno e imprime el promedio de las calificaciones de cada estudiante.


estudiantes = []

num_estudiantes = int(input("Ingrese la cantidad de estudiantes: "))

for i in range(num_estudiantes):
    nombre = input(f"Ingrese el nombre del estudiante {i + 1}: ")
    edad = int(input(f"Ingrese la edad del estudiante {i + 1}: "))
    
    calificaciones = []
    for j in range(3):
        calificacion = float(input(f"Ingrese la calificación {j + 1} del estudiante {i + 1}: "))
        calificaciones.append(calificacion)

    estudiante = {"Nombre": nombre, "Edad": edad, "Calificaciones": calificaciones}
    estudiantes.append(estudiante)

for i in estudiantes:
    print("\nInformación del estudiante:")
    print("Nombre:", i["Nombre"])
    print("Edad:", i["Edad"])
    print("Calificaciones:", i["Calificaciones"])
    
    totalCalificacion = sum(i["Calificaciones"])
    
    promedio = totalCalificacion / len(i["Calificaciones"])
    
    print("Promedio de calificaciones:", promedio)
