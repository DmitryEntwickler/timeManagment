import java.io.File

fun readFile(): List<String>{
    return if (File("myDB.txt").exists())
        File("myDB.txt").readLines()
    else {
        println()
        println("-> File myDB.txt not found")
        val ls = listOf<String>()
        ls
    }
}

fun showContent(){
    val mFileList = readFile()
    println()
    println("myDB.txt hat Zeilen: ${mFileList.size}")
    mFileList.forEach(){
        println("\t$it")
    }
    menu()
}

fun writeToFile(){
    println("-----")
    print("Stunden heute: ")
    val hours = readlnOrNull()
    print("Minuten heute: ")
    val minutes = readlnOrNull()
    if (hours != null && minutes != null) {
        if(hours.toIntOrNull() != null && minutes.toIntOrNull() != null) {
            File("myDB.txt").appendText("\n$hours")
            File("myDB.txt").appendText("\n$minutes")
            println("speichern ok")
        }
        else {
            println()
            println("-> Mindestens eine Eingabe war falsch! Nichts gespeichert")
        }
    }
    else {
        println()
        println("-> Mindestens eine Eingabe war null. Nichts gespeichert")
    }
    menu()
}

fun menu(){
    println()
    println("--------------------")
    println("ZEIT MANAGMENT, v1.0")
    println("1 - alles anzeigen")
    println("2 - speichern")
    println("0 - ENDE")
    print("Was möchten Sie tun? ")
    val selected = readlnOrNull()
    if (selected == "1") showContent()
    if (selected == "2") writeToFile()
}