package com.example.nit3213finalassignment.ui

import com.example.nit3213finalassignment.data.AuthRepository
import com.example.nit3213finalassignment.data.LoginRequest
import com.example.nit3213finalassignment.data.LoginResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.assertNotNull

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var repository: AuthRepository
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mockk()
        viewModel = LoginViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `login success updates keypassState`() = runTest {
        coEvery { repository.login(
            LoginRequest(
                "8218414",
                "Muhammadh"
            )
        ) } returns LoginResponse("architecture")

        viewModel.login("8218414", "Muhammadh")
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals("architecture", viewModel.keypassState.value)
    }

    @Test
    fun `login failure updates errorState`() = runTest {
        coEvery { repository.login(any()) } throws Exception("Invalid credentials")

        viewModel.login("wrong", "wrong")
        testDispatcher.scheduler.advanceUntilIdle()

        assertNotNull(viewModel.errorState.value)
    }
}