data class Color(val red: Int, val green: Int, val blue: Int)

data class TextWithColor(val text: String, val color: Color)

fun calculateColorfulness(color: Color): Double {
    val max = maxOf(color.red, color.green, color.blue)
    val min = minOf(color.red, color.green, color.blue)
    val delta = max - min
    return if (max == 0) 0.0 else delta.toDouble() / max.toDouble()
}

fun main() {
    val textsWithColors = listOf(
        TextWithColor("Text 1", Color(34, 203, 55)),
        TextWithColor("Text 2", Color(67, 76, 73)),
        TextWithColor("Text 3", Color(99, 105, 93)),
        TextWithColor("Text 4", Color(178, 173, 169))
    )

    val threshold = 0.3 //terserah sih mau custom berapa pak bu

    for ((text, color) in textsWithColors) {
        val colorfulness = calculateColorfulness(color)
        val textColor = if (colorfulness < threshold) "\u001B[33m" else "\u001B[0m"
        println("$textColor$text\u001B[0m")
    }
}
