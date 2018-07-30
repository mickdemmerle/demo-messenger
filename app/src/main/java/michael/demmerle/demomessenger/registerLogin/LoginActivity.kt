package michael.demmerle.demomessenger.registerLogin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import michael.demmerle.demomessenger.R
import michael.demmerle.demomessenger.messages.LatestMessagesActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        back_to_registration_text_view.setOnClickListener {
            finish()
        }

        val email = email_text_edit_login.text.toString()
        val password = password_edit_text_login.text.toString()


        button_login.setOnClickListener {

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (!it.isSuccessful) return@addOnCompleteListener

                        val intent = Intent(this, LatestMessagesActivity::class.java)
                        startActivity(intent)
                    }
        }
    }
}