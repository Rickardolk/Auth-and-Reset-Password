package com.example.myapp.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signup(email: String, password: String, navController: NavController, context: Context) {
        viewModelScope.launch {
            if (email.isNotBlank() && password.isNotBlank()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navController.navigate("login")
                        } else {
                            Toast.makeText(context, "Email sudah terdaftar", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .addOnFailureListener {
                        Log.e("signUp", "Terjadi kesalahan")
                    }
            } else {
                Toast.makeText(context,"Mohon isi semua kolom", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun login(email: String, password: String, navController: NavController,context: Context) {
        viewModelScope.launch {
            if (email.isNotBlank() && password.isNotBlank()) {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            navController.navigate("home")
                        } else {
                            Toast.makeText(context, "Email atau Password salah", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .addOnFailureListener {
                        Log.e("Login", "Terjadi kesalahan")
                    }
            } else {
                Log.e("Login", "Mohon isi semua kolom")
            }
        }
    }

    fun resetPassword(email: String, context: Context) {
        if (email.isNotBlank()) {
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(context, "Periksa email anda untuk reset password", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "Gagal mengirim link reset password", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener {
                    Log.e("Reset Password", "Terjadi kesalahan")
                }
        } else {
            Toast.makeText(context, "Mohon masukan email anda",Toast.LENGTH_SHORT).show()
        }
    }
}