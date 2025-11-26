# kotlin_task6
World Nations App (Task 6)

A simple Android application built with Jetpack Compose that displays a curated list of countries and their flags using modern UI components and Material Design 3.

Project Overview

This app demonstrates the use of Jetpack Compose to create a list of items without using LazyColumn. It showcases custom theming, font integration, and responsive card layouts.

Key Features

Card Layout: Displays 4 countries (Finland, Germany, Japan, Brazil) in vertically stacked cards using a Column.

Custom Styling:

Cards feature rounded corners (16.dp) and elevation.

Dynamic Colors: Supports Material You (Dynamic Color) on Android 12+, adapting the card colors to the user's wallpaper.

Dark Theme: Fully supports system-wide dark mode.

Typography: Uses the custom Geo font for all text elements.

Assets:

Custom Globe app icon.

High-quality flag images for each country.

Project Structure

MainActivity.kt: The entry point of the application. It contains the CountryListScreen Composable which arranges the CountryCard components.

ui/theme/: Contains the theme definitions (Theme.kt, Color.kt, Type.kt) to handle dynamic coloring and dark mode logic.

Resources:

res/font/geo.ttf: The custom font file.

res/drawable/: Contains the flag images (flag_finland, flag_germany, etc.).

![Screenshot 2025-11-26 212635](https://github.com/user-attachments/assets/b4eb49bc-a8f5-460e-827e-5fc93e45ee9f)
