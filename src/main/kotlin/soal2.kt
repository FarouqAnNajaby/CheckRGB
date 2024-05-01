data class Color2(val red: Int, val green: Int, val blue: Int)

data class TextWithColor2(val text: String, val backgroundColor: Color2)


fun isBlackWhite(color: Color2, threshold: Int): Boolean {
    val average = (color.red + color.green + color.blue) / 3
    return (color.red <= average + threshold &&
            color.green <= average + threshold &&
            color.blue <= average + threshold)
}

fun main() {
    val textsWithColors = listOf(
        TextWithColor2("Text 1", Color2(87, 76, 63)),
        TextWithColor2("Text 2", Color2(67, 76, 73)),
        TextWithColor2("Text 3", Color2(178, 173, 169)),
        TextWithColor2("Text 4", Color2(99, 105, 93)),
        TextWithColor2("Text 5", Color2(48, 35, 46))
    )

    val threshold = 30

    for (textWithColor in textsWithColors) {
        val backgroundColor = textWithColor.backgroundColor
        val isBW = isBlackWhite(backgroundColor,threshold)

        val textColor = if (isBW) "\u001B[37m" else "\u001B[33m"
        println("$textColor${textWithColor.text}\u001B[0m")
    }
}
