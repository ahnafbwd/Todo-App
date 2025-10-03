# Todo App

A simple and intuitive Todo application built with Kotlin for Android, featuring task management with status tracking and CRUD operations.

## Features

- ✅ Create new tasks with title and description
- 📝 Edit existing tasks
- 🗑️ Delete tasks
- ✔️ Mark tasks as completed/pending by tapping the status icon
- 📱 Material Design UI with CardView layout
- 💾 Local database storage using Room

## Architecture

This app follows the **MVVM (Model-View-ViewModel)** architecture pattern with Repository pattern for clean separation of concerns:

- **Model**: Room database entities (`Task`)
- **View**: Activities and Adapters for UI
- **ViewModel**: `MainViewModel` for business logic
- **Repository**: `TaskRepository` for data access abstraction

## Tech Stack

- **Language**: Kotlin
- **Database**: Room (SQLite)
- **Architecture**: MVVM + Repository Pattern
- **UI**: Material Design Components
- **Async Operations**: ExecutorService
- **Build System**: Gradle

## Project Structure

```
app/
├── src/main/java/com/ahnaf/todo/
│   ├── data/
│   │   ├── local/database/     # Room database, DAO, entities
│   │   └── repository/         # Repository implementation
│   ├── ui/
│   │   ├── main/              # MainActivity, MainViewModel, TaskAdapter
│   │   └── insert/            # TaskAddUpdateActivity
│   └── utils/                 # Helper classes
├── src/main/res/
│   ├── layout/                # XML layouts
│   ├── values/                # Strings, colors, themes
│   └── drawable/              # Icons and graphics
└── build.gradle
```

## Key Components

### Database
- **Task Entity**: Contains id, title, description, and status fields
- **Room Database**: Local SQLite database for persistent storage
- **DAO**: Database Access Objects for CRUD operations

### UI Components
- **MainActivity**: Displays list of tasks in RecyclerView
- **TaskAdapter**: Handles task list display and status toggle
- **TaskAddUpdateActivity**: Form for creating/editing tasks

### Business Logic
- **MainViewModel**: Manages UI-related data and business logic
- **TaskRepository**: Abstracts data access from multiple sources

## Installation

1. Clone this repository
```bash
git clone [repository-url]
```

2. Open the project in Android Studio

3. Build and run the application on your Android device or emulator

## Usage

1. **Add Task**: Tap the floating action button to create a new task
2. **Edit Task**: Tap on any task card to edit its details
3. **Toggle Status**: Tap the status icon to mark task as completed/pending
4. **Delete Task**: Use the delete option in the edit screen

## Database Schema

```sql
CREATE TABLE task_table (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    description TEXT,
    status BOOLEAN DEFAULT FALSE
);
```

## Dependencies

Key dependencies used in this project:

- AndroidX Core KTX
- AndroidX Lifecycle
- Room Database
- Material Design Components
- RecyclerView

## Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

**Ahnaf** - [GitHub Profile](https://github.com/ahnafbwd)

---

*Built with ❤️ using Kotlin and Android Studio*
```

This README provides a comprehensive overview of your Todo application, including its features, architecture, technical details, and usage instructions. It's structured to help other developers understand and contribute to your project.
