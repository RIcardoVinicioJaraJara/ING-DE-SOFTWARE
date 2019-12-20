from flask_mysqldb import MySQL
import pymysql

from Controlador.ControladorPersona import Persona, ControladorPersona


class Medico(Persona):
    def __init__(self, idme,idp, cedula, nombre, apellido, direccion, telefono,  fechaNacimiento, mail, contracenia, especialidad):
        Persona.__init__(self,idp, cedula, nombre, apellido, direccion, telefono,  fechaNacimiento, mail, contracenia)
        self.idme = idme
        self.especialidad = especialidad

        
class ControladorMedico: 
    def __init__(self, db):
        self.db = db

    def ingresarNoCreado(self, medico):
        try:
            controladorPesrona = ControladorPersona(self.db)
            persona = Persona(medico.idp,medico.cedula, medico.nombre, medico.apellido, medico.direccion, medico.telefono, medico.fechaNacimiento, medico.mail, medico.contracenia)
            if controladorPesrona.ingresar(persona):
                cursor = self.db.cursor()
                cursor.execute(''' INSERT INTO `medico` (`med_id`, `med_especialidad`, `Persona_per_id`) VALUES (%s,%s, (select max(per_id) from persona))''',
                            (medico.idme, medico.especialidad))
                self.db.commit()
                cursor.close()
                return True
            else: 
                return False
        except Exception as e:
            print(e)
            return False

    def ingresarYaCreado(self, medico):
        try:
            cursor = self.db.cursor()
            cursor.execute(''' INSERT INTO `medico` (`med_id`, `med_especialidad`, `Persona_per_id`) VALUES (%s,%s, %s)''',
                (medico.idme, medico.especialidad, medico.idp))
            self.db.commit()
            cursor.close()
            return True
        except Exception as e:
            print(e)
            return False

    def actualizar(self, medico):
        try:
            cur = self.db.cursor()
            cur.execute("""
                UPDATE medico
                SET med_especialidad = %s,
                    Persona_per_id = %s
                WHERE med_id = %s
            """, (medico.especialidad, medico.idp, medico.idme))
            self.db.commit()
            cur.close()
            return True
        except Exception as e:
            print(str(e))
            return False   

    def listar(self):
        cur = self.db.cursor()
        cur.execute('SELECT * FROM Medico ')
        data = cur.fetchall()
        cur.close()
        return data
    
    def eliminar(self, id):
        try:
            cur = self.db.cursor()
            cur.execute('DELETE FROM medico WHERE med_id = %s', (id))
            self.db.commit()
            cur.close()
            return True
        except Exception as e:
            print(e)
            return False