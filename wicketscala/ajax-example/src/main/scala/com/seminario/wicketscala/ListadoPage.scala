package com.seminario.wicketscala

import org.apache.wicket.markup.html.list._
import org.apache.wicket.markup.html._
import org.apache.wicket.markup.html.form._
import org.apache.wicket.model._
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.spring.injection.annot.SpringBean
import com.seminario.wicketscala.service.AlumnoService
import java.util.{ List => JList }
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.ajax.AjaxRequestTarget

class ListadoPage extends WebPage {
  // servicio
  @SpringBean var alumnoService: AlumnoService = _

  // listado de alumnos, el wicket model es el encargado de traer la información 
  val model = new LoadableDetachableModel[JList[Alumno]]() {
    def load = alumnoService.getAll
  }

  // contenedor del listado de alumnos
  val container = new WebMarkupContainer("container")
  container.setOutputMarkupId(true)
  add(container)

  // listado de alumnos usando el modelo construido arriba
  container.add(new ListView[Alumno]("listado", model) {
    // invocado con cada elemento de la lista para popular cada fila
    override def populateItem(item: ListItem[Alumno]) {
      // model de cada alumno
      val model = item.getModel

      // por cada fila agregamos el nombre del alumno
      item.add(new Label("nombre", new PropertyModel[String](model, "nombre")))
      item.add(new Label("apellido", new PropertyModel[String](model, "apellido")))
    }
  })

  // contenedor para mostrar el cartel si no hay alumnos
  container.add(new WebMarkupContainer("sin_alumnos") {
    override def isVisible = model.getObject.size == 0
  })

  // link via ajax, agrega un alumno a la base y refresca el listado
  add(new AjaxLink("agregar_random") {
    def onClick(target: AjaxRequestTarget) {
      // creamos el alumno y lo mandamos a la base de dato
      val alumno = new Alumno
      alumno.nombre = "Pablo"
      alumno.apellido = "Cosso"
      alumnoService add alumno

      // necesitamos refrescar el listado de alumnos
      target addComponent container
    }
  })
}