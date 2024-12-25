package com.example.openaccess

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCamera = findViewById<MaterialButton>(R.id.btn_camera)
        val btnContacts = findViewById<MaterialButton>(R.id.btn_contacts)

        // Запрос разрешения на доступ к камере
        val requestCameraPermission = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                startActivity(Intent(this, CameraActivity::class.java))
            }
        }

        // Запрос разрешения на чтение контактов
        val requestContactsPermission = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                startActivity(Intent(this, ContactsActivity::class.java))
            }
        }

        btnCamera.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                startActivity(Intent(this, CameraActivity::class.java))
            } else {
                requestCameraPermission.launch(Manifest.permission.CAMERA)
            }
        }

        btnContacts.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                startActivity(Intent(this, ContactsActivity::class.java))
            } else {
                requestContactsPermission.launch(Manifest.permission.READ_CONTACTS)
            }
        }
    }
}