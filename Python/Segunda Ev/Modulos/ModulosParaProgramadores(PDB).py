#Esto es un debugger en Python.
import subprocess as s

import pdb
pdb.Pdb().set_trace()
s.call(" ls",shell=True)