def leerFichero(f) :
	cad = f.read().split()

	for i in cad:
		print i

# main

f = open ('ej4.txt','r')

leerFichero(f)

f.close()