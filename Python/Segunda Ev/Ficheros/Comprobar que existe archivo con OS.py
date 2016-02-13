import os
__author__ = 'AlumnoT'
def comprobarfichero(dato):
    if os.path.isfile(dato):
        print "fichero"
    if os.path.isdir(dato):
        print "directorio"
    else:
        print "cualquier cosa"

dato=raw_input("Introduzca el nombre: ")
comprobarfichero(dato)

