//EJ 1
def activity(day: String) = {
    day match {
        case "lunes" => "codear"
        case "martes" => "refactorizar"
    }
}

activity("lunes")

//EJ 2
def activity(day: String, hour: Int) = {
    day match {
        case "lunes" if hour >= 9 && hour < 18 => "codear"
        case "lunes" => "descansar"
    }
}

activity("lunes", 9)

activity("lunes", 19)

