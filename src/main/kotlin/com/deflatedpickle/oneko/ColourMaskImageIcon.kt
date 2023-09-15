package com.deflatedpickle.oneko

import java.awt.Color
import java.awt.image.BufferedImage
import javax.swing.ImageIcon

class ColourMaskImageIcon(
    image: BufferedImage,
    mask: BufferedImage,
) : ImageIcon() {
    init {
        val icon = BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_ARGB).apply {
            for (y in 0 until height) {
                for (x in 0 until width) {
                    setRGB(x, y, image.getRGB(x, y))
                }
            }
        }

        for (y in 0 until image.height) {
            for (x in 0 until image.width) {
                val maskColour = mask.getRGB(x, y)

                if (maskColour == Color.WHITE.rgb) {
                    icon.setRGB(x, y, Color(0, 0, 0, 0).rgb)
                }
            }
        }

        this.image = icon
    }
}