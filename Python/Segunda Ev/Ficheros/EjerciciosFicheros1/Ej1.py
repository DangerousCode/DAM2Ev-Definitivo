__author__ = 'AlumnoT'
'''Escribir los numeros  pares  comprendidos entre el 1 y el 100 en un
fichero y luego lo muestras'''

f=open('ejercicio1.txt','w')
for i in range(2,100,2):
    f.write(str(i)+'\n')

f.close()

z=open('ejercicio1.txt','r')

print z.read()