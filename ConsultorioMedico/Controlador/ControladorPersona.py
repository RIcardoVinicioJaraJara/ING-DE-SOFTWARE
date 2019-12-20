from flask_mysqldb import MySQL
import pymysql

class Persona(object):
    def __init__(self, idp, cedula, nombre, apellido, direccion, telefono,  fechaNacimiento, mail, contracenia):
        self.idp = idp
        self.cedula = cedula
        self.nombre = nombre
        self.apellido = apellido
        self.direccion = direccion
        self.telefono = telefono
        self.fechaNacimiento = fechaNacimiento
        self.mail = mail
        self.contracenia = contracenia

class ControladorPersona: 
    def __init__(self, db):
        self.db = db

    def ingresar(self, persona):
        try:
            cursor = self.db.cursor()
            cursor.execute(''' INSERT INTO persona (per_id, per_cedula, per_nombre, per_apellido, pre_direccion, per_telefono, per_fec_nacimiento, per_mail, per_contro) 
                               VALUES(%s,%s, %s, %s, %s, %s, %s, %s, %s)''',
                        (persona.idp,persona.cedula, persona.nombre, persona.apellido, persona.direccion, persona.telefono, persona.fechaNacimiento, persona.mail, persona.contracenia))
            self.db.commit()
            cursor.close()
            return True
        except Exception as e:
            print(e)
            return False

    def actualizar(self, persona):
        try:
            cur = self.db.cursor()
            cur.execute("""
                UPDATE persona
                SET per_cedula = %s,
                    per_nombre = %s,
                    per_apellido = %s,
                    pre_direccion = %s,
                    per_telefono = %s,
                    per_fec_nacimiento = %s,
                    per_mail = %s,
                    per_contro = %s
                WHERE per_id = %s
            """, (persona.cedula, persona.nombre, persona.apellido, persona.direccion, persona.telefono, persona.fechaNacimiento, persona.mail, persona.contracenia, persona.idp))
            self.db.commit()
            cur.close()
            return True
        except Exception as e:
            print(str(e))
            return False   

    
    def eliminar(self, id):
        try:
            cur = self.db.cursor()
            cur.execute('DELETE FROM persona WHERE per_id = %s', (id))
            self.db.commit()
            cur.close()
            return True
        except Exception as e:
            print(e)
            return False

    
    
  