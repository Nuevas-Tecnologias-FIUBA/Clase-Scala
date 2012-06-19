class Document(val title:String)

def getTitle(doc:Document) = {
    if (doc.title == null)  None else Some(doc.title)
}

val doc = new Document(null) 

val title = getTitle(doc)

val titleUpperCase = title.getOrElse("Sin Titulo").toUpperCase() //SIN TITULO

title.isDefined // indica si el valor no es null
title.isEmpty   // indica si el valor es null
 
