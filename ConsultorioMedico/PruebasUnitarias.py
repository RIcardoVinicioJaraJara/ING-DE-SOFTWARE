import unittest
import pymysql
db = pymysql.connect("localhost", "root", "", "consultorio")

from Controlador.ControladorPersona import Persona, ControladorPersona
from Controlador.ControladorPaciente import Paciente, ControladorPaciente
from Controlador.ControladorMedico import Medico, ControladorMedico


class PreubasPersona(unittest.TestCase):
    controladorPer = ControladorPersona(db)
    persona = Persona(10,"0105452171","Ricardo Vinicio", "Jara Jara","Cuenca","0990550716","12/12/1999","vinicio1004@hotmail.com","1004")
    def testCrearPersona(self):
        self.assertEqual(True, self.controladorPer.ingresar(self.persona))
    
    def testActualizarPersona(self):
        self.assertEqual(True, self.controladorPer.actualizar(self.persona))
    
    def testEliminarPersona(self):
        self.assertEqual(True, self.controladorPer.eliminar(self.persona.idp))

class PreuebasPaciente(unittest.TestCase):
    controladorPer = ControladorPersona(db)
    controladorPaciente = ControladorPaciente(db)

    paciente = Paciente(1, 1,"0105452171","Ricardo Vinicio", "Jara Jara","Cuenca","0990550716","12/12/1999","vinicio1004@hotmail.com","1004", "Masculino")

    def testCrearPacienteSiNoExistePersona(self):
        self.assertEqual(True, self.controladorPaciente.ingresarNoCreado(self.paciente))

    def testCrearPacienteSiYaExistePersona(self):
        self.paciente.idpa = 2
        self.assertEqual(True, self.controladorPaciente.ingresarYaCreado(self.paciente))

    def testActualizarPaciente(self):
        self.assertEqual(True, self.controladorPaciente.actualizar(self.paciente))
    
    def testEliminarPaciente1(self):
        self.assertEqual(True, self.controladorPaciente.eliminar(self.paciente.idpa))

    def testEliminarPaciente2(self):
        self.paciente.idpa = 1
        self.assertEqual(True, self.controladorPaciente.eliminar(self.paciente.idpa))

    def testEliminarPersona1(self):
        self.assertEqual(True, self.controladorPer.eliminar(self.paciente.idp))

class PreuebasMedico(unittest.TestCase):
    controladorPer = ControladorPersona(db)
    controladorMedico = ControladorMedico(db)
    medico = Medico(5, 5,"0105452171","Ricardo Vinicio", "Jara Jara","Cuenca","0990550716","12/12/1999","vinicio1004@hotmail.com","1004", "Traumatologo")

    def testCrearMedicoSiNoExistePersona(self):
        self.medico.idme = 5
        self.assertEqual(True, self.controladorMedico.ingresarNoCreado(self.medico))

    def testCrearMedicoSiYaExistePersona(self):
        self.medico.idme = 6
        self.assertEqual(True, self.controladorMedico.ingresarYaCreado(self.medico))

    def testActualizarMedico(self):
        self.assertEqual(True, self.controladorMedico.actualizar(self.medico))
    
    def testEliminarMedico1(self):
        self.medico.idme = 6
        self.assertEqual(True, self.controladorMedico.eliminar(self.medico.idme))

    def testEliminarMedico2(self):
        self.medico.idme = 5
        self.assertEqual(True, self.controladorMedico.eliminar(self.medico.idme))

    def testEliminarPersona2(self):
        self.assertEqual(True, self.controladorPer.eliminar(self.medico.idp))    

if __name__ == "__main__":
   unittest.main() 
    