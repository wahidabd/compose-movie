package com.wahidabd.movieapps.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.wahidabd.movieapps.R

val GoogleSans = FontFamily(
    Font(R.font.googlesans_regular, FontWeight.Normal),
    Font(R.font.googlesans_medium, FontWeight.Medium),
    Font(R.font.googlesans_bold, FontWeight.Bold)
)

val quickSandFontFamily = FontFamily(
    Font(R.font.quicksand_regular, weight = FontWeight.Normal),
    Font(R.font.quicksand_light, weight = FontWeight.Light),
    Font(R.font.quicksand_medium, weight = FontWeight.Medium),
    Font(R.font.quicksand_semibold, weight = FontWeight.SemiBold),
    Font(R.font.quicksand_bold, weight = FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = quickSandFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),

    /* Other default text styles to override
     button = TextStyle(
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.W500,
         fontSize = 14.sp
     ),
     caption = TextStyle(
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.Normal,
         fontSize = 12.sp
     )*/
)
