__author__ = 'AlumnoT'
import string
def sumador(fichero):
    acum=0
    lista=string.split(fichero.read())
    for i in range(len(lista)):
        acum+=int(lista[i])
    return acum

#main
f=open('ejercicio1.txt','r')
print "La suma es: ",sumador(f)