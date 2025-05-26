# Tic Tac Toe - Java CLI Application

A clean and modular command-line Tic Tac Toe game built in Java, following clean architecture principles. This project features a robust design with service and repository layers, dependency management, and in-memory data storage using Maps.

## 🧠 Features

- **Player Management:** Register and log in players with unique usernames.
- **Gameplay:** Play Tic Tac Toe against another user with a 3x3 game board.
- **Game Tracking:** Save and track game results in memory.
- **Input Safety:** Utilizes `InputUtils` for secure and validated user input.
- **Preloaded Users:** Comes with default users (`ali` and `mehdi`) for quick testing.
- **Prevent Self-Play:** Ensures players cannot play against themselves.
- **Extensible Design:** Built with clean architecture for easy future enhancements (e.g., AI opponent, database integration).

> **Note:** The computer player (AI) feature is planned but not yet implemented.

## 📂 Project Structure

   
      com.basic
     ├── model
     │   ├── Player.java           # Player entity with username and symbol
     │   ├── Symbol.java           # Enum for game symbols (X, O)
     │   └── PlayerType.java       # Enum for player types (Human, Computer)
     ├── repository
     │   ├── PlayerRepository.java # Manages player data storage
     │   └── GameRepository.java   # Manages game data storage
     ├── service
     │   ├── PlayerService.java    # Handles player-related business logic
     │   └── GameService.java      # Handles game-related business logic
     ├── util
     │    ├── InputUtils.java       # Utilities for safe user input
     │   └── InitializedData.java  # Preloads default users
     ├── ApplicationContext.java   # Dependency injection management
     ├── GameBoard.java            # Manages the Tic Tac Toe board
     └── CLI.java                  # Main class for the command-line interface


## 🚀 How to Run

1. Clone the Repository:

   ```bash
   git clone https://github.com/Mehdi-Sokhanvar/Tic-Tac-Toe
   cd tic-tac-toe-cli
   ## 🚀 How to Run

### Compile the Java Files:
 
  
     javac com/basic/**/*.java
     java com.basic.CLI
     
## 🧪 Preloaded Users

The game includes two preloaded users for testing, initialized in `InitializedData.java`:

| Username | Symbol |
| -------- | ------ |
| ali      | O      |
| mehdi    | X      |

## 🛠 Future Improvements

- **AI Opponent:** Add a computer player for single-player mode.
- **Persistent Storage:** Save game data to a file or database.
- **GUI/Web Version:** Develop a graphical or web-based interface.
- **Enhanced Features:** Add leaderboards, game replays, or multiplayer over a network.

## 📄 License

This project is licensed under the MIT License.



