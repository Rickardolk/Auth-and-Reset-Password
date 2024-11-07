package com.example.myapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.screens.Home
import com.example.myapp.screens.LoginScreen
import com.example.myapp.screens.ResetPasswordScreen
import com.example.myapp.screens.SignUpScreen

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val context = LocalContext.current
    
    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                context = context,
                navController = navController
            )
        }

        composable("signup") {
            SignUpScreen(
                navController = navController,
                context = context
            )
        }

        composable("reset_password") {
            ResetPasswordScreen(
                context = context,
                navController = navController
            )
        }

        composable("home") {
            Home()
        }
    }
}