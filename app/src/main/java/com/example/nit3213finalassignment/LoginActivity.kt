package com.example.nit3213finalassignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.nit3213finalassignment.ui.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editUsername = findViewById<android.widget.EditText>(R.id.editUsername)
        val editPassword = findViewById<android.widget.EditText>(R.id.editPassword)
        val buttonLogin = findViewById<android.widget.Button>(R.id.buttonLogin)
        val textError = findViewById<android.widget.TextView>(R.id.textError)

        buttonLogin.setOnClickListener {
            viewModel.login(editUsername.text.toString(), editPassword.text.toString())
        }

        lifecycleScope.launch {
            viewModel.keypassState.collect { keypass ->
                if (keypass != null) {
                    val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                    intent.putExtra("keypass", keypass)
                    startActivity(intent)
                }
            }
        }

        lifecycleScope.launch {
            viewModel.errorState.collect { error ->
                if (error != null) {
                    textError.text = error
                }
            }
        }

        lifecycleScope.launch {
            viewModel.keypassState.collect { keypass ->
                if (keypass != null) {
                    val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                    intent.putExtra("keypass", keypass)
                    startActivity(intent)
                    viewModel.clearKeypassState()
                }
            }
        }
    }
}