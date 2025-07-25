
# V1.0.0

You can find the binaries in the [releases](https://github.com/your-username/your-repo/releases/tag/v1.0.0)

## Project Structure

3 Modules:
- **app** module – Dashboard UI
- **core** module – Shared models, utils, theme
- **data** module – Remote API, repositories

### [app module](https://github.com/your-username/your-repo/tree/main/app)

This is the Android client module that:
- Implements the UI using Jetpack Compose
- Follows Clean MVVM architecture
- Uses Hilt for DI and ViewModel instantiation
- Displays the Dashboard screen by sequentially fetching:
  - User Profile
  - Recent Transactions
  - System Configuration

It also handles:
- Error/retry logic
- Dynamic theming (dark/light)
- Showing/hiding transaction counterparty based on configuration

### [data module](https://github.com/your-username/your-repo/tree/main/data)

This module contains:
- Retrofit-based API layer
- Repository implementations for the use case layer
- DTOs for `Profile`, `Transaction`, and `SystemConfig`

All calls are made sequentially using Kotlin Coroutines with proper error handling and cancellation.

### [core module](https://github.com/your-username/your-repo/tree/main/core)

This module contains:
- Domain models
- Use case for `DashboardUseCase`
- Utility classes (e.g., error mapping, constants)
- Sealed classes like `Result`, `ThemeMode`, `TransactionType`, and `TransactionStatus`

## Sequence Diagram

Here is a basic sequence diagram explaining the dashboard loading flow:

<br>

<img src="https://github.com/mahi252001/DashboardAssignment/blob/main/sequence.png" alt="Dashboard Sequence Flow"/>

> **Note:** This diagram shows the ordered API flow and retry logic for the dashboard screen.
