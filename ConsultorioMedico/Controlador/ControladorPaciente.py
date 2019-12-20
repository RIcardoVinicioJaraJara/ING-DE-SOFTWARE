from flask_mysqldb import MySQL
import pymysql

from Controlador.ControladorPersona import Persona, ControladorPersona


class Paciente(Persona):
    def __init__(self, idpa,idp, cedula, nombre, apellido, direccion, telefono,  fechaNacimiento, mail, contracenia, genero):
        Persona.__init__(self,idp, cedula, nombre, apellido, direccion, telefono,  fechaNacimiento, mail, contracenia)
        self.idpa = idpa
        self.genero = genero

        
class ControladorPaciente: 
    def __init__(self, db):
        self.db = db

    def ingresarNoCreado(self, paciente):
        try:
            controladorPesrona = ControladorPersona(self.db)
            persona = Persona(paciente.idp,paciente.cedula, paciente.nombre, paciente.apellido, paciente.direccion, paciente.telefono, paciente.fechaNacimiento, paciente.mail, paciente.contracenia)
            if controladorPesrona.ingresar(persona):
                cursor = self.db.cursor()
                cursor.execute(''' INSERT INTO `paciente` (`pac_id`, `per_genero`, `Persona_per_id1`) VALUES (%s,%s, (select max(per_id) from persona))''',
                            (paciente.idpa, paciente.genero))
                self.db.commit()
                cursor.close()
                return True
            else: 
                return False
        except Exception as e:
            print(e)
            return False

    def ingresarYaCreado(self, paciente):
        try:
            cursor = self.db.cursor()
            cursor.execute(''' INSERT INTO `paciente` (`pac_id`, `per_genero`, `Persona_per_id1`) VALUES (%s,%s, %s)''',
                (paciente.idpa, paciente.genero, paciente.idp))
            self.db.commit()
            cursor.close()
            return True
        except Exception as e:
            print(e)
            return False

    def actualizar(self, paciente):
        try:
            cur = self.db.cursor()
            cur.execute("""
                UPDATE paciente
                SET per_genero = %s,
                    Persona_per_id1 = %s
                WHERE pac_id = %s
            """, (paciente.genero, paciente.idp, paciente.idpa))
            self.db.commit()
            cur.close()
            return True
        except Exception as e:
            print(str(e))
            return False   

    def listar(self):
        cur = self.db.cursor()
        cur.execute('SELECT * FROM paciente ')
        data = cur.fetchall()
        cur.close()
        return data
    
    def eliminar(self, id):
        try:
            cur = self.db.cursor()
            cur.execute('DELETE FROM paciente WHERE pac_id = %s', (id))
            self.db.commit()
            cur.close()
            return True
        except Exception as e:
            print(e)
            return False