package com.example.myapp.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myapp.R
import com.example.myapp.viewModel.AuthViewModel

@Composable
fun ResetPasswordScreen(
    context: Context,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    authViewModel: AuthViewModel = viewModel()
) {

    var email by remember { mutableStateOf("") }

    Box(
        modifier
            .background(color = colorResource(id = R.color.primary))
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier
                .height(600.dp)
                .background(
                    color = Color.White, RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        ){
            Column(
                modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Reset Password",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.font)
                )
                Spacer(modifier = Modifier.height(44.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = {email = it},
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "ic home",
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(id = R.color.font),
                        focusedLabelColor = colorResource(id = R.color.font),
                        focusedLeadingIconColor = colorResource(id = R.color.font),
                        unfocusedLeadingIconColor = colorResource(id = R.color.defauld),
                        cursorColor = colorResource(id = R.color.font)
                    )
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { authViewModel.resetPassword(email, context)},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                    ,
                    shape = RoundedCornerShape(26.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.font),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Reset Password")
                }

                TextButton(
                    onClick = { navController.navigate("login")}
                ) {
                    Text(
                        text = "Kembali",
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.font)
                    )
                }
            }
        }
    }
}