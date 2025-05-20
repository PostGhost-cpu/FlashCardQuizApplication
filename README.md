#Flashcard Quiz App
A simple and interactive Android flashcard app designed to help users learn and test their knowledge through a series of quiz-style flashcards.

#Design Considerations:
  In designing the Flashcard Quiz app, simplicity and usability were prioritized. The following decisions were made to enhance the user experience:
    #Straightforward Navigation: The app uses a series of screens, each presenting a single question. This avoids overwhelming users and keeps focus on one task at a time.
    #User Feedback: Users receive a toast message ("Correct!" or "Incorrect!") after each response, making the experience interactive and rewarding.
    #Personalized Score Summary: The score screen provides a total count of correct answers and a motivational message:“Great Job!” if the user scores 3 or higher/“Keep Practicing” for scores below 3.
    #Review Feature: A "Review" button displays all five quiz questions along with the correct answers, giving the user a chance to learn and improve.
    #Exit Options: All screens include an “Exit” button, allowing users to leave the app at any stage.

#Application Logic:
  -The logic of the application is structured around a five-question quiz using true/false flashcards.
  -Each question is stored as part of a parallel array, with a corresponding Boolean value indicating the correct answer.
  -The app starts at Question 1, and based on the user’s answer, the score is updated and passed to the next screen using Intent extras.
  -At each stage, the app checks whether the user’s selected answer matches the stored correct answer. Only correct answers increment the score.
  -After the fifth question, the total score is passed to the Score screen where feedback is displayed.
  -The Score screen also provides access to a Review screen, where all questions and correct answers are listed.

#UI Simplicity:
The app uses standard Android buttons, TextViews, and basic layout design to ensure compatibility and ease of use across various devices.
#Features
- Tap to reveal answers
- Swipe to navigate through flashcards
- Clean and responsive UI
- Ideal for quick learning and revision

#Built With:
- Kotlin
- Android Studio
- XML for UI design

2. Open the project in Android Studio.
3. Build and run the app on an emulator or a physical Android device.

#Project Structure
- `MainActivity.kt` – Handles flashcard logic and user interaction.
- `activity_main.xml` – Main layout file for the UI.
- `colors.xml` – App color theme.
- `strings.xml` – App text and labels.

#Future Improvements
- Add categories and topics
- Allow users to create custom flashcards
- Add scoring system and progress tracking

#License
This project is open-source and available under the MIT License.
