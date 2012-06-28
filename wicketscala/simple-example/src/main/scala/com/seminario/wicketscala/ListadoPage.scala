package com.seminario.wicketscala

import org.apache.wicket.markup.html.list._
import org.apache.wicket.markup.html._
import org.apache.wicket.markup.html.form._
import org.apache.wicket.model._
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.spring.injection.annot.SpringBean
import com.seminario.wicketscala.service.AlumnoService
import java.util.{ List => JList }

class ListadoPage extends WebPage {
  // servicio
  @SpringBean var alumnoService: AlumnoService = _

  // listado de alumnos, el wicket model es el encargado de traer la información 
  val model = new LoadableDetachableModel[JList[Alumno]]() {
    def load = alumnoService.getAll
  }

  // listado de alumnos usando el modelo construido arriba
  add(new ListView[Alumno]("listado", model) {
    // invocado con cada elemento de la lista para popular cada fila
    override def populateItem(item: ListItem[Alumno]) {
      // model de cada alumno
      val model = item.getModel

      // por cada fila agregamos el nombre del alumno
      item.add(new Label("nombre", new PropertyModel[String](model, "nombre")))
    }
  })

  add(new WebMarkupContainer("sin_alumnos") {
    override def isVisible = model.getObject.size == 0
  })
}