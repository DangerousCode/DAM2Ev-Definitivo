__author__ = 'AlumnoT'
import pickle
lista=['Perl','Python','Ruby']
arduino=open("ejemplo.dat",'wb')
#Cargar lista al archivo
pickle.dump(lista,arduino)
arduino.close()

#Cargar lista desde el fichero
archivo=open("ejemplo.dat",'rb')
lista=pickle.load(archivo)
print(lista)
archivo.close()