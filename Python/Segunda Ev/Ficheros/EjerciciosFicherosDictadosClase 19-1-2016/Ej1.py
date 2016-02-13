__author__ = 'AlumnoT'
'''Mostrar el contenido de un fichero
de texto cuyo nombre es introducido por el usuario.
 Realizar todas las comprobaciones pertinentes antes
 de leerlo linea a linea.'''

import os
strfich=raw_input("Introduce el nombre con extension: ")

if(os.path.isfile("C:/Users/AlumnoT/Desktop/"+strfich)):

    print "Es un fichero"
    fichero=open("C:/Users/AlumnoT/Desktop/"+strfich,"r")
    print "Lectura del fichero"

    print fichero.read()

elif(os.path.isdir("C:/Users/AlumnoT/Desktop/"+strfich)):
    print "Es un directorio"

else:
    print "El dato introducido no existe"
