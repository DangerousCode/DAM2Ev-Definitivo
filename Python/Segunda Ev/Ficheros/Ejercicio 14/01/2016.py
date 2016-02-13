__author__ = 'AlumnoT'
'''abrir fichero en modo escritua
comprobar que esta ok
menu repetir tres veces
    pedir por teclado nombre de producto
    ident del producto
    precio del producto
cerrar el fichero y comprobar mediante atributo que se ha cerrado
leer el contenido'''
import os

f=open("C:/Users/AlumnoT/Desktop/datos.txt","w")
if os.path.isfile("C:/Users/AlumnoT/Desktop/datos.txt"):
    print "Es fichero"
for i in range(3):
    nombre=raw_input("Introduce el producto: ")
    ident=raw_input("Introduce el identificador: ")
    precio=raw_input("Introduce el precio: ")
    f.write(nombre)
    f.write(ident)
    f.write(precio)
    print "---------------------------------"
f.close()
z=open("C:/Users/AlumnoT/Desktop/datos.txt","r")
print z.readline()

'''Mostrar el contenido de un ficher de texto cuyo nombre lo introduce el usuario
realizar todas las operaciones pertinentes para leerlo linea a linea, supongamos que
el fichero se llame menu, y su estructura es el entrante, primero y postre.
Hacer un menu que lea todos los entrantes de los que dispone nuestro menu.txt, y dos, que muestre el ultimo postre introducidoç
Crear en nuestro propia version del comando copy, para ello copiaremos el contenido de un fichero en otro
al final mostraremos los dos ficheros y el contenido ha de ser igual
Creamos un fichero y nos dira el numero de letras que hay en la primera linea del fichero y el numero de letras de la ultima(ayuda: funcion split)'''