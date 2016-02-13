__author__ = 'AlumnoT'
archivo=open("C:/Users/AlumnoT/Desktop/a.txt","a")
lista=['esto\n','tambien\n','lo\n','meto']
archivo.writelines(lista)
archivo.close()

archivo1=open("C:/Users/AlumnoT/Desktop/a.txt","a")
c=archivo1.read()
print c
archivo1.close()