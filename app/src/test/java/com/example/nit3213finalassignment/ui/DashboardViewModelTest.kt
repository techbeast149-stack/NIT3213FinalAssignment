package com.example.nit3213finalassignment.ui

import com.example.nit3213finalassignment.data.AuthRepository
import com.example.nit3213finalassignment.data.DashboardResponse
import com.example.nit3213finalassignment.data.Entity
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var repository: AuthRepository
    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repository = mockk()
        viewModel = DashboardViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `loadDashboard updates entitiesState`() = runTest {
        val fakeEntity = Entity(
            "Eiffel Tower",
            "Gustave Eiffel",
            "Paris, France",
            1889,
            "Structural Expressionism",
            324,
            "desc"
        )
        coEvery { repository.getDashboard("architecture") } returns DashboardResponse(
            listOf(
                fakeEntity
            ), 1
        )

        viewModel.loadDashboard("architecture")
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(1, viewModel.entitiesState.value.size)
        assertEquals("Eiffel Tower", viewModel.entitiesState.value[0].name)
    }
}