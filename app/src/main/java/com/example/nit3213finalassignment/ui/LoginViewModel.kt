package com.example.nit3213finalassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nit3213finalassignment.data.AuthRepository
import com.example.nit3213finalassignment.data.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _keypassState = MutableStateFlow<String?>(null)
    val keypassState: StateFlow<String?> = _keypassState

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(LoginRequest(username, password))
                _keypassState.value = response.keypass
            } catch (e: Exception) {
                _errorState.value = "Login failed: ${e.message}"
            }
        }
    }

}