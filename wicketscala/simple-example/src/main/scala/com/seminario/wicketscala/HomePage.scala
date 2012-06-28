package com.seminario.wicketscala

import org.apache.wicket.markup.html.link._
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form._
import org.apache.wicket.model._
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.spring.injection.annot.SpringBean
import com.seminario.wicketscala.service.AlumnoService
import org.apache.wicket.markup.html.panel.FeedbackPanel

class HomePage extends WebPage {
  // servicio
  @SpringBean var alumnoService: AlumnoService = _
  // alumno
  val alumno = new Alumno

  // links a otras páginas
  add(new BookmarkablePageLink("link", classOf[ListadoPage]))

  // muestra la info del alumno en un label
  add(new Label("alumno_info", new Model(alumno)))

  // formulario
  add(new Form("form") {
    // feedback panel, muestra errores de validación de formulario
    add(new FeedbackPanel("feedback"))
    // campos del formulario, 3 texts, 1 requerido.
    add(new RequiredTextField("nombre", new PropertyModel[String](alumno, "nombre")))
    add(new TextField("apellido", new PropertyModel[String](alumno, "apellido")))
    add(new TextField("edad", new PropertyModel[Integer](alumno, "edad"), classOf[Integer]))

    // que haces en el submit
    override def onSubmit = {
      alumnoService.add(alumno)
    }
  })
}