__author__ = 'AlumnoT'
with open("C:/Users/AlumnoT/Desktop/a.txt","a") as f:
    f.write("texto\n del\nfinal")
f1=open("C:/Users/AlumnoT/Desktop/a.txt","r")
cont=f1.read()
print cont
f1.close()