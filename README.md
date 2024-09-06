# The Flight Search App

An Android app that lets the user enter an airport and view a list of destinations using that airport as a departure. 
This project is created for demo purposes to demonstrate everything I learned within the "Android Basics with Compose" Course (Unit 6).
Built fully with Jetpack Compose.

## Features

* The app queries the database to provide autocomplete suggestions as the user types.
* When the user chooses a suggestion, the app generates a list of available flights from that airport, including the IATA identifier and airport name to other airports in the database.
* The app lets the user save favorite individual routes.
* When no search query is entered, the app displays all the user-selected favorite routes in a list, showing the departure and destination.
* If there are no favorite routes saved, the "No Favorites" screen is shown.
* The search text (user input) is saved with Preferences DataStore.
* When the user reopens the app, the search text, if any, prepopulates the text field with appropriate results from the database.
* More frequently visited airports are shown in descending order.

## Screenshots
<img width="700" alt="flightsearch" src="https://github.com/user-attachments/assets/eb3c89eb-a8ef-4183-b044-4686f3634a98">

## Demo
| Light mode | Dark mode |
| ------------- | ------------- |
| <video src="https://github.com/user-attachments/assets/f4f80d44-332c-4ef9-8d15-59e902633346"> | <video src="https://github.com/user-attachments/assets/11c0bccd-0ac7-4317-8b74-8c1e85c06b9d">| 

### Material Design theming
The Gallery App uses [Material Theme Builder](https://material-foundation.github.io/material-theme-builder/) and `MaterialTheme` composable. The app uses a custom, branded color scheme. 

## Libraries & dependencies used in the project:

*   Jetpack Compose 
*   Kotlin coroutines
*   Room
*   Preferences DataStore
*   Manual Dependency Injection.

## Credits 
A prepopulated database is provided by [Android Codelabs](https://developer.android.com/get-started/codelabs).

<a href="https://www.freepik.com/icon/worldwide_1604503#fromView=search&page=1&position=76&uuid=55ba9a10-6676-42dc-b3e6-6de27efbe744">Icon by Freepik</a>


