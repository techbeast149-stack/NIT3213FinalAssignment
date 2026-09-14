package com.example.nit3213finalassignment.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nit3213finalassignment.data.AuthRepository
import com.example.nit3213finalassignment.data.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _entitiesState = MutableStateFlow<List<Entity>>(emptyList())
    val entitiesState: StateFlow<List<Entity>> = _entitiesState

    private val _errorState = MutableStateFlow<String?>(null)
    val errorState: StateFlow<String?> = _errorState

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repository.getDashboard(keypass)
                _entitiesState.value = response.entities
            } catch (e: Exception) {
                _errorState.value = "Failed to load dashboard: ${e.message}"
            }
        }
    }
}