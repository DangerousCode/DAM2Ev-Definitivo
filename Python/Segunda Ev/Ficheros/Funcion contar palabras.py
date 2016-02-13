__author__ = 'AlumnoT'
import string
def numpalabras(s):
    lista=string.split(s)
    return len(lista)

#main
nombre=raw_input("Introduce nombre del fichero: ")
f=open(nombre,'w')

for i in range(5):
    palabra=raw_input("Introduce palabra: ")
    f.write(palabra+"\n")

f.close()

z=open(nombre,'r')
print "El numero de palabrase es: ",numpalabras(z.read())