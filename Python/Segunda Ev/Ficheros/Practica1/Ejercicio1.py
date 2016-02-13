__author__ = 'AlumnoT'
import string
def contarlineas(f):

    #Obtencion de las palabras
    lineas=f.readlines()
    print "La cantidad de lineas es: ",len(lineas)
    f.close()
    return 0

def contarpalabras(f):

    palabras=string.split(f.read())
    print "La cantidad de palabras es: ",len(palabras)
    return 0

def contarletras(f):

    letras=f.read()
    print "La cantidad de letras es: ",len(letras)
    return 0

f=open("ejercicio1.txt","r")
contarlineas(f)
f.close()

f=open("ejercicio1.txt","r")
contarpalabras(f)
f.close()

f=open("ejercicio1.txt","r")
contarletras(f)
f.close()


