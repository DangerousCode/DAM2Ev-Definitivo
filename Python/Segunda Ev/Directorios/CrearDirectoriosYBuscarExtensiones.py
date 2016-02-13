__author__ = 'AlumnoT'
import os
import glob
#os.system("mkdir C:\ejemplo1")

f=open("C:/ejemplo1/a.txt","w")
f=open("C:/ejemplo1/b.jpg","w")
f=open("C:/ejemplo1/a.odt","w")
lista=glob.glob("C:\ejemplo1\*.txt")
print lista
