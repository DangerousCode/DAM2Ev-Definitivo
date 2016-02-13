__author__ = 'AlumnoT'
with open("C:/Users/AlumnoT/Desktop/a.txt","w+") as f:
    f.write("hola\nnuevamente")
f1=open("C:/Users/AlumnoT/Desktop/a.txt","r")
cont=f1.read()
print cont
f1.close()