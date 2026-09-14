# NIT3213 Final Assignment

An Android application demonstrating API integration, dependency injection, and modern Android development practices. The app authenticates against a REST API, displays a list of entities in a RecyclerView, and shows full details when an item is selected.

## Features

- **Login screen** - authenticates against the `vu-nit3213-api` (footscray endpoint)
- **Dashboard screen** - displays a list of entities fetched from the API using a RecyclerView
- **Details screen** - shows full information for a selected entity
- **Dependency Injection** - implemented with Hilt
- **Networking** - Retrofit + Moshi + OkHttp
- **Unit tests** - ViewModel tests using JUnit, MockK, and kotlinx-coroutines-test

## Tech Stack

- Kotlin
- Retrofit 3.0.0 (networking)
- Moshi 1.15.2 (JSON parsing)
- OkHttp logging interceptor 5.5.0
- Hilt 2.59.2 (dependency injection)
- AndroidX RecyclerView
- JUnit 4 + MockK 1.14.11 + kotlinx-coroutines-test 1.10.2 (testing)

## Prerequisites

- Android Studio (a recent stable release)
- JDK 11 or later
- An internet connection (the app calls a live API)

## Setup Instructions

1. Clone this repository:
   git clone https://github.com/techbeast149-stack/NIT3213FinalAssignment.git
2. Open the project in Android Studio (File → Open, select the cloned folder).
3. Let Gradle sync automatically. If it doesn't start, click **Sync Now** in the banner at the top of the editor.
4. No additional configuration or API keys are required, the base URL is already set in `Nit3213RetrofitClient.kt`.

## Running the App

1. Connect a physical Android device (with USB debugging enabled) or start an emulator.
2. Click **Run** (the green play button) in Android Studio, or press Shift+F10.
3. The app opens on the Login screen with the username and password fields pre-filled with valid credentials for this account.
4. Tap **Login** to authenticate and proceed to the Dashboard.

### Login Credentials

This API authenticates a single specific account per student, not arbitrary users. The Login screen is pre-filled with the correct credentials:

- **Username:** student ID (digits only, no `s` prefix)
- **Password:** first name (case-sensitive)

## Running the Unit Tests

1. In Android Studio's Project panel, navigate to `app/src/test/java/.../ui`.
2. Right-click the `ui` folder and select **Run Tests in 'ui'**.
3. All tests should pass, covering both `LoginViewModel` (success and failure cases) and `DashboardViewModel`.

## Project Structure

app/src/main/java/com/example/nit3213finalassignment/
├── data/ # Data classes, ApiService interface, Retrofit client, Repository
├── di/ # Hilt module providing the ApiService
├── ui/ # ViewModels and RecyclerView adapter
├── LoginActivity.kt
├── DashboardActivity.kt
├── DetailsActivity.kt
└── MyApplication.kt

app/src/test/java/com/example/nit3213finalassignment/ui/
├── LoginViewModelTest.kt
└── DashboardViewModelTest.kt