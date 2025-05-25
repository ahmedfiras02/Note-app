package com.example.note

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.noteapp.di.AppContainer
import com.noteapp.navigation.Navigation
import com.noteapp.navigation.Screens
import com.noteapp.ui.theme.NoteTheme

class MainActivity : ComponentActivity() {
    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appContainer = AppContainer(this)

        setContent {
            NoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()

                ) {
                    // Check if user is logged in
                    val startDestination = if (isUserLoggedIn()) {
                        Screens.AllNotes.route
                    } else {
                        Screens.Login.route
                    }

                    Navigation(
                        appContainer = appContainer,
                        startDestination = startDestination
                    )
                }
            }
        }
    }

    private fun isUserLoggedIn(): Boolean {
        // Check SharedPreferences or SessionManager
        return appContainer.sessionManager.isLoggedIn()
    }
}