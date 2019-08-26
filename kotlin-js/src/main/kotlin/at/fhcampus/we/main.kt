package at.fhcampus.we

import org.w3c.dom.HTMLPreElement
import org.w3c.dom.events.Event
import org.w3c.xhr.XMLHttpRequest
import kotlin.browser.document
import kotlin.js.Json

// Interesting it seems that kotlin 2 js only allows for very basic code?!
// https://javalin.io/
fun main(args: Array<String>) {
    // https://www.raywenderlich.com/201669-web-app-with-kotlin-js-getting-started
    println("Hello World! (JS)")
    fetch()
}

fun fetch(): Unit {
    val url = "http://localhost:8080/api/hello-world"
    val req = XMLHttpRequest()
    req.onloadend = fun(_: Event){
        val text = req.responseText
        val objArray  = JSON.parse<Array<Json>>(text)
        val htmlPreElement = document.getElementById("data-area") as HTMLPreElement
        htmlPreElement.textContent = text;
        println(objArray)
    }
    req.open("GET", url, true)
    req.send()
}
