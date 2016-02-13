import string
def costo_total_paciente(rut):
    f=open("atenciones.txt","r")
    #Contador para el coste
    costotal=0
    #Separo cada linea con \n porque si no incluye ese caracter al final.
    lista=string.split(f.read(),"\n")
    for i in lista:
        #Separacion de la cadena por el caracter ":"
        listasub=string.split(i,":")
        if(listasub[0]==rut):
            costotal+=int(listasub[-1])
    print "El coste total es: ",costotal
    f.close()

def pacientes_dia(d,m,a):
    f=open("atenciones.txt","r")
    #Creamos la lista vacia de clientes. Albergara los numeros de cliente.
    listaclientes=list()
    #Concatenacion de los parametros para hacerlo mas facil.
    fecha=d+"-"+m+"-"+a
    #Mismo procedimiento que en el anterior punto.
    lista=string.split(f.read(),"\n")
    for i in lista:
        listasub=string.split(i,":")
        if(listasub[1]==fecha):
            #Guardamos cada numero de cliente en una lista.
            listaclientes.append(listasub[0])
    f.close()

    z=open("pacientes.txt","r")
    #Creamos la lista de nombres vacia para mostrarla al final
    listanombres=list()
    lista=string.split(z.read(),"\n")
    for i in lista:
        listasub=string.split(i,":")
        for j in listaclientes:
            #Comparamos la primera posicion de cada linea de la lista de pacientes con la lista creada anteriormente y sacamos los nombres.
            if(listasub[0]==j):
                listanombres.append(listasub[1])
    print listanombres
    z.close()




#main
rut=raw_input("Introduce el rut: ")
costo_total_paciente(rut)

#ejercicio2
pacientes_dia("18","5","2010")