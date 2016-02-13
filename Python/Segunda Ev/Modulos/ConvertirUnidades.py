#Ejemplo modulo doctest
'''Crear una funcion que pase kilometros a millas y viceversa y otra que pase de pulgadas a cm y viceversa'''
def mill_a_km(mi):
    return mi*1.609
def km_a_mill(km):
    return km/1.609
def pulg_a_cm(pulg):
    return pulg*2.54
def cm_a_pulg(cm):
    return cm/2.54

if __name__=="__main__":
    print mill_a_km(float(9))
    print km_a_mill(float(9))
    print pulg_a_cm(float(9))
    print cm_a_pulg(float(9))

