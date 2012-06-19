List(1,2,3,4,5,6).foreach { e => println(e) }

List(1,2,3,4,5,6).map { e => e * e }

List(5,10,15,20,30).partition { e => e < 15 }
