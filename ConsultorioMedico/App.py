
import pymysql
db = pymysql.connect("localhost", "root", "", "consultorio")

from Controlador.ControladorPersona import Persona, ControladorPersona
from Controlador.ControladorMedico import Medico, ControladorMedico
from Controlador.ControladorPaciente import Paciente, ControladorPaciente

def iniciar(self):
    persona = Persona(10,"0105452171","Ricardo Vinicio", "Jara Jara","Cuenca","0990550716","12/12/1999","vinicio1004@hotmail.com","1004")
    paciente = Paciente(1, 1,"0105452171","Ricardo Vinicio", "Jara Jara","Cuenca","0990550716","12/12/1999","vinicio1004@hotmail.com","1004", "Masculino")
    medico = Medico(5, 5,"0105452171","Ricardo Vinicio", "Jara Jara","Cuenca","0990550716","12/12/1999","vinicio1004@hotmail.com","1004", "Traumatologo")

    controladorPer = ControladorPersona(db)
    controladorPer.ingresar(persona)
    controladorPer.actualizar(persona)
    controladorPer.eliminar(persona.idp)

    controladorPaciente = ControladorPaciente(db)
    controladorPaciente.ingresarNoCreado(paciente)
    controladorPaciente.ingresarYaCreado(paciente)
    controladorPaciente.eliminar(paciente.idpa)
    controladorPaciente.eliminar(paciente.idp)

    cM = ControladorMedico(db)
    cM.ingresarNoCreado(medico)

