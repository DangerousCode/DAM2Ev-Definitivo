__author__ = 'AlumnoT'
f=open('ejemplo2.txt','w')
f.write('Ejemplonuevoclase')
f.write('\n\n')
f.write('Pruebadeclase')

f.close()

z=open('ejemplo2.txt','r')
z.seek(0,0)
print z.readline()

z.seek(-5,2)
print z.read(5)

z.seek(-13,2)
print z.read(6)
