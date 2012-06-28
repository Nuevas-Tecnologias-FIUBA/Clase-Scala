package com.seminario.wicketscala

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.spring.injection.annot.SpringComponentInjector

class WicketApplication extends WebApplication {
  // define la página de arranque de la aplicacion
  override def getHomePage = classOf[HomePage]

  override def init = {
    super.init
    // integracion con spring
    getComponentInstantiationListeners().add(new SpringComponentInjector(this))
  }
}