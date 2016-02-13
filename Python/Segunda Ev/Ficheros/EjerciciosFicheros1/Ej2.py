__author__ = 'AlumnoT'
'''Pedimos por teclado un directorio, como no sabemos si lo sera o no.
 Indica que es lo que realmente se ha introducido.'''
import os

directorio=raw_input("Introduce el nombre del directorio: ")
if(os.path.isdir(directorio)):
    print("Es un directorio.")
else:
    print("NO es un directorio.")