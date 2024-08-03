package com.example.details_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.details_screen.ui.screens.DetailsScreen
import com.example.details_screen.ui.screens.HomeScreen
import com.example.details_screen.ui.screens.Repo
import com.example.details_screen.ui.screens.RepoAppBar
import com.example.details_screen.ui.screens.RepoScreen
import com.example.details_screen.ui.theme.DetailsScreenTheme

@Composable
fun RepoApp(navController: NavHostController = rememberNavController()) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = RepoScreen.valueOf(
        backStackEntry?.destination?.route ?: RepoScreen.HOME.name
    )

    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        RepoAppBar(
            currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() })
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RepoScreen.HOME.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = RepoScreen.HOME.name) {
                HomeScreen(onNavToDetailsClicked = { navController.navigate(RepoScreen.DETAILS.name) })
            }
            composable(route = RepoScreen.DETAILS.name) {
                DetailsScreen(
                    repo = Repo(
                        imageUrl = R.drawable.google,
                        name = "language",
                        language = "Python",
                        stars = 1525,
                        forks = 347,
                        description = "Shared repository for open-sourced projects from the Google AI Language team."
                    )
                )
            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DetailsScreenTheme {
        RepoApp()
    }
}