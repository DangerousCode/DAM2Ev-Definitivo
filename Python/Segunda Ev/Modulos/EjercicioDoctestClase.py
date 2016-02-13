'''Hacer un doctest de la serie de Fibonacci'''
import doctest as d
def fibonacci(n):
    '''
    >>>fibonacci(1)
    9
    >>>fibonacci(9)
    45
    '''
    for i in range(n):
        a,b=b,a+b
    return a
if __name__=="__main__":
    d.testmod()
