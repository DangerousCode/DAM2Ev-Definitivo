__author__ = 'AlumnoT'
def bead(fich,num):
    for i in range(num):
        print fich.readline()

#main
fich=open("ejercicio1.txt","r")
num=int(raw_input("Introduce el numero de lineas a leer: "))

bead(fich,num)