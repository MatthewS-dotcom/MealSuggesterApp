package za.co.varsitycollege.st10489708.mealsuggesterapp

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import java.lang.reflect.Modifier

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Variables declaration
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        //Created a reset button to allow the user to easily remove text added
        resetButton.setOnClickListener {
            timeInput.text.clear()  //clear EditText
            resultText.text = ""  //Reset TextView to empty
        }

        // On click button has been used to retaliate once user has pressed it
        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()
            //User inputs time of day
            val mealSuggestion = if (timeOfDay == "morning") {
                "Breakfast: How about eggs and bacon?"
                //Give recommended food items
            } else if (timeOfDay == "mid-morning") {
                "Light Snack: How about a protein bar?"
            } else if (timeOfDay == "afternoon") {
                "Lunch: How about a burger and fries?"
            } else if (timeOfDay == "mid-afternoon") {
                "Mid-afternoon: How about fruit?"
            } else if (timeOfDay == "dinner") {
                "Dinner: How about chicken and rice?"
                //Have to recommend a dessert :)
            } else if (timeOfDay == "after dinner") {
                "Dessert: How about a brownie?"
                //If anything else is input show user it is an error
            } else {
                "Please enter 'morning' , 'mid-morning' , 'afternoon' , 'mid-afternoon' , 'dinner' , or 'after dinner' "
                //Show recommendations based on users input
            }
            resultText.text = mealSuggestion
            //Allows text to show example and have an input

        }
    }
}

