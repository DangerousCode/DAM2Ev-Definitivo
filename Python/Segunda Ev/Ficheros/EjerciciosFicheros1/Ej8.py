import os
def muestra(ruta) :
	if os.path.isdir(ruta) == True :
		lista = os.listdir(ruta)
		for i in lista :
			print i
	elif os.path.isfile(ruta) == True :
		with open (ruta,'r') as f :
			print f.read()
	else :
		print "No se sabe"

# main

muestra(raw_input("Introduce una ruta: "))