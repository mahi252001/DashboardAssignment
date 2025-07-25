# V1.0.0

You can find the binaries in the [releases](https://github.com/mahi252001/DashboardAssignment/releases/tag/1)

## Project Structure

2 Modules:
- **app** module – UI, ViewModel, UseCase, and models
- **data** module – Remote API integration, DI and repositories

---

### [app module](https://github.com/mahi252001/DashboardAssignment/tree/main/app)

This is the main Android application module that:
- Implements the Dashboard UI using Jetpack Compose
- Follows **Clean MVVM** architecture
- Contains:
  - ViewModels
  - UseCases
  - UI state management (StateFlow, sealed classes)
  - Error handling
  - Theme switching via `SystemConfig`
  - Hilt setup for dependency injection

The dashboard screen loads:
1. Profile
2. Transactions (requires profile)
3. System Configuration  
All network calls are executed **sequentially using Kotlin Coroutines** with **structured concurrency**.

---

### [data module](https://github.com/mahi252001/DashboardAssignment/tree/main/app/data)

This module contains:
- Retrofit API services
- Repositories for Profile, Transactions, and Config
- DTOs matching the backend response models

It abstracts all network communication and exposes domain-safe results to the app module.

---

## Sequence Diagram

Here's a high-level sequence diagram describing the dashboard loading flow:

<br>

<img src="https://github.com/mahi252001/DashboardAssignment/blob/main/sequence.png" alt="Dashboard Sequence Flow"/>

> 💡 This diagram outlines the sequential call order and retry logic from UI to API layer.

## 🎬 UI Demo

<img src="https://raw.githubusercontent.com/mahi252001/DashboardAssignment/main/TransactionDashboard.gif" width="100%" alt="Dashboard Demo"/>

---
