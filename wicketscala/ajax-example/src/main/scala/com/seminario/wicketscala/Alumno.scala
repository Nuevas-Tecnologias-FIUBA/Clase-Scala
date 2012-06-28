package com.seminario.wicketscala

import javax.persistence._

@Entity
class Alumno extends Serializable {

  @Id @GeneratedValue private var id: Integer = _
  @Column var nombre: String = _
  @Column var apellido: String = _
  @Column var edad: Integer = _

  override def toString = "[Alumno nombre=%s apellido=%s edad=%s]".format(nombre, apellido, edad)
}