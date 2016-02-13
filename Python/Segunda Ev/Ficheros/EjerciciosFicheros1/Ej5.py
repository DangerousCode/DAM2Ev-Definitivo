#_*_coding:utf-8
'''Vamos a buscar un carácter a buscar en
un fichero .Ambos datos los introducimos por teclado.
Nos debe mostrar un mensaje indicando si lo ha encontrado o no'''
import string

nfich=raw_input("Introduce el nombre del fichero/ruta sin extension: ")
f=open(nfich+".txt","r")
lista=string.split(f.read(),"\n")

car=raw_input("Introduce un caracter: ");
for i in lista:
    if(i==car):
        print "El caracter ha sido encontrado."
        break