#_*_coding:utf-8
'''Vamos a realizar un fichero que  va a contener una serie de número
introducidos por teclado de manera aleatoria.
Vamos a guardar esos datos en un fichero.
Mostraremos su contenido
A continuación lo leeremos y deberemos decir que números son pares
y cuales impares.

LA RESTRICCION DE ÉSTE EJERCICIO ES QUE DEBÉIS USAR

•	FICHEROS PYHTON
•	LISTAS O DICCIONARIOS
•	FUNCIONES DE ALTO NIVEL'''
import string

def pares(num):
    if(int(num)%2==0):
        print "El numero ",num," es par"
    else:
         print "El numero ",num," es impar"

#main
f=open("ejercicio1.txt","w")
ans="s"

while(ans.lower()=="s"):
    num=raw_input("Introduce un numero: ")
    if(num.isdigit()):
        f.write(num+"\n")
        ans=raw_input("Desea continuar?: ")
    else:
        print "El valor introducido no es un numero."

f.close()
f=open("ejercicio1.txt","r")

lista=string.split(f.read())

print lista

map(pares,lista)

