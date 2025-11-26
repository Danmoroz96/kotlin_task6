package com.example.task6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task6.ui.theme.Task6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This applies the theme (Task6Theme)
            Task6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CountryListScreen()
                }
            }
        }
    }
}

// Data model for a Country
data class Country(val name: String, val flagResId: Int)

@Composable
fun CountryListScreen() {
    // 1. Load the Custom Geo Font
    // Ensure 'geo.ttf' is in res/font/ folder
    val geoFontFamily = FontFamily(
        Font(R.font.geo)
    )

    // 2. Define the list of countries
    // Ensure these images are in res/drawable/ folder
    val countries = listOf(
        Country("Finland", R.drawable.flag_finland),
        Country("Germany", R.drawable.flag_germany),
        Country("Japan", R.drawable.flag_japan),
        Country("Brazil", R.drawable.flag_brazil)
    )

    // 3. Main Layout: A Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "World Nations",
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = geoFontFamily,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        countries.forEach { country ->
            CountryCard(country = country, customFont = geoFontFamily)
        }
    }
}

@Composable
fun CountryCard(country: Country, customFont: FontFamily) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            // Uses the dynamic color scheme
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Flag Image
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(80.dp, 60.dp)
            ) {
                Image(
                    painter = painterResource(id = country.flagResId),
                    contentDescription = "Flag of ${country.name}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(24.dp))

            // Country Name
            Text(
                text = country.name,
                fontSize = 28.sp,
                fontFamily = customFont,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}
