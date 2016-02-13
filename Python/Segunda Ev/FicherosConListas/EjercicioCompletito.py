__author__ = 'AlumnoT'
'''1-pedir ruta directorio. Si no existe se creara y si existe dara error.
Dentro del directorio crearemos un archivo alumnos.txt dicho fichero tendra la estructura:
-nombre:apellido:edad:nota (crear tres)
El programa debe imprimir el promedio de las notas de los alumnos asi como el nombre y las edades de dichos alumnos'''

'''import os

ruta=raw_input("Introduce la ruta del directorio: ")
if os.path.isdir(ruta):
    print  "El directorio ya existe"
else:
    os.system("MKDIR "+ruta)
    print "Directorio creado"

fich=open(ruta+"/alumnos.txt","w")

for i in range(3):
    fich.write(raw_input("Introduce los datos del alumno: ")+"\n")

fich.close()
#lectura
fich=open(ruta+"/alumnos.txt","r")

alumno1=fich.readline()
alumno2=fich.readline()
alumno3=fich.readline()

lista1=alumno1.split(':')
lista2=alumno2.split(':')
lista3=alumno3.split(':')

print "Los nombres son: ",lista1[0]," ",lista2[0]," ",lista3[0]
print "Las edades son: ",lista1[-2]," ",lista2[-2]," ",lista3[-2]
print "La media es: ",(int(lista1[-1])+int(lista2[-1])+int(lista3[-1]))/3'''

'''2-Pedir por teclado un dato y comprobar si el dato es un fichero o un directorio, si es un fichero, nos situamos en la penultima
linea del fichero y la vamos a mostrar, si es un directorio, comprobar si es el directorio actual, mostrar si lo es o no(con mensaje)
y comprobar si hay archivos con una extension pedida por teclado, si la hay mostrar los archivos con esa extension, si no, mensaje de
error'''

import os
import glob
dato=raw_input("Introduce el dato (fichero o directorio): ")

if(os.path.isfile(dato)):
    print "Leyendo archivo."
    f=open(dato,"r")
    lista=f.readlines()
    print "La penultima linea es: "+lista[-2]

elif(os.path.isdir(dato)):
    if(os.getcwd()==dato):
        print "El directorio introducido es el actual."
    else:
        print "El directorio introducido no es el actual"

    extension=raw_input("Introduce la extension: ")
    fichero=glob.glob(dato+"\*"+extension)
    print fichero


