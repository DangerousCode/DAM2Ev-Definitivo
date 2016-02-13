#Se utiliza para juegos de pruebas(testear el codigo antes de mandarlo a produccion.
import doctest as d
def suma(a,b):
    '''
    >>> suma(0,0)
    0
    >>> suma(10,23)
    35
    '''
    return a+b
#Esta linea sirve para que al importar este archivo.py no se ejecute el main.
if __name__=="__main__":
    d.testmod()