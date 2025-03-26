package za.co.varsitycollege.st10489708.mealsuggesterapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        //Created a reset button to allow the user to easily remove text added
        resetButton.setOnClickListener {
            timeInput.text.clear()
            //Allows the test to be blank
            resultText.text = ""
        }

// without the on click listener the button would not do as it is required
        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()
//figure out time of day
            val mealSuggestion = if (timeOfDay == "breakfast") {
                "How about eggs and bacon?"
                //Give a recommended food items
            }else if (timeOfDay == "light snack") {
                "How about a protein bar?"
            } else if (timeOfDay == "lunch") {
                "How about a burger and fries?"
            }else if (timeOfDay == "quick bite") {
                "How about fruit?"
            }else if (timeOfDay == "dinner") {
                "How about chicken and rice?"
                //Have to recommend a dessert :)
            }else if (timeOfDay == "dessert") {
                "How about a brownie?"
                //If anything else is input show user it is an error and only for the vals
            // and time of day added
            }else{
                "Please enter 'breakfast' , 'light snack' , 'lunch' , 'quick bite' , 'dinner', or 'dessert' "
                //Show recommendations based on users input
            }
            resultText.text = mealSuggestion
            //Allows text to show example and have an input
             {

                }
            }
        }
        }

