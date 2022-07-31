package com.example.camerafinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login: Button = findViewById(R.id.login)
        val key: CheckBox = findViewById(R.id.key)
        val accountedit: EditText = findViewById(R.id.accountEdit)
        val passwardedit: EditText = findViewById(R.id.passwardEdit)
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val isRemember = pref.getBoolean("remember_key", false)
        if(isRemember) {
            val accountkey = pref.getString("account", "")
            val passwardkey = pref.getString("passward", "")
            accountedit.setText(accountkey)
            passwardedit.setText(passwardkey)
        }
        login.setOnClickListener {
            val account = accountedit.text.toString()
            val passward = passwardedit.text.toString()
            if (account == "bytedance" && passward == "123456") {
                val editor = pref.edit()
                if(key.isChecked) {
                    editor.putBoolean("remember_key", true)
                    editor.putString("account", account)
                    editor.putString("passward", passward)
                } else {
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "账号或密码错误",
                Toast.LENGTH_SHORT).show()
            }
        }
    }
}