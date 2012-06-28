package com.seminario.wicketscala.service

import org.hibernate.SessionFactory
import org.springframework.stereotype._
import org.springframework.beans.factory.annotation.Autowired
import com.seminario.wicketscala.Alumno
import java.util.{ List => JList }

@Service
class AlumnoService {
  // session factory de hibernate
  @Autowired var sessionFactory: SessionFactory = _

  def add(alumno: Alumno) {
    val session = sessionFactory.getCurrentSession
    session.save(alumno)
  }

  def getAll() = {
    val session = sessionFactory.getCurrentSession
    session.createCriteria(classOf[Alumno]).list.asInstanceOf[JList[Alumno]]
  }
}