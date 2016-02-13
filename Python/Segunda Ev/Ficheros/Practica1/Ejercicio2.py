
import string

def norep(*lista):
    contrep=0
    for i in lista:

        igual=False
        f=open("ejercicio2.txt","r")
        listaf=string.split(f.read())
        f.close()

        #Comparacion de cada cadena
        for j in listaf:
            if(i==j):
                igual=True
                contrep+=1
                break

        #Si esa palabra no esta repetida, se escribe en el txt
        if(igual==False):
            f=open("ejercicio2.txt","a")
            f.write(i+" ")
            f.close()
    return contrep



#main
contrep=norep("Hola", "Manolo","que","tal","tal","que","Manolo","la","tarde", "Hola", "la","buen", "tiempo")
f=open("ejercicio2.txt","r")
print f.read()
f.close()
print "La cantidad de repetidos pasados por parametro es: ",contrep
