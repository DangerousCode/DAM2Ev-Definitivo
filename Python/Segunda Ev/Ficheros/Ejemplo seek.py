__author__ = 'AlumnoT'
'''Vamos a crear un objeto file llamado archivo que abre el a.txt en modo lectura, vamos a leer de golpe toda la info y la vamos
a mostrar por pantalla'''

archivo=open("C:/Users/AlumnoT/Desktop/a.txt","r")
contenido=archivo.read()
print contenido

archivo.seek(6)
contenido=archivo.read()
print "\n",contenido,"\n"
archivo.close()
'''-------------------------'''
archivo=open("C:/Users/AlumnoT/Desktop/a.txt","r")
contenido=archivo.read(4)
print "\n",contenido,"\n-------------"

archivo.seek(6)
contenido=archivo.read()
print "\n",contenido,"\n-------------"

archivo.seek(9)
contenido=archivo.read()
print "\n",contenido,"\n-------------"

archivo.close()
