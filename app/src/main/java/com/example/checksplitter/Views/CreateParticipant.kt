package com.example.checksplitter.Views

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.checksplitter.ViewModel.ParticipantViewModel


@Composable
fun ContentColorComponent(
    contentColor: Color = LocalContentColor.current,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalContentColor provides contentColor,
        content = content)
}


@Composable
fun SignUpScreen(viewModel: ParticipantViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {


    var participantName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            ,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


        Spacer(modifier = Modifier.height(16.dp))



        Spacer(modifier = Modifier.height(16.dp))




        BasicTextField(
            value = participantName,
            onValueChange = { participantName = it },
            modifier = Modifier
                .width(250.dp)
                .border(1.dp, MaterialTheme.colorScheme.onSurface)
                .padding(8.dp),
            textStyle = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))






        Spacer(modifier = Modifier.height(40.dp))


        ExtendedFloatingActionButton(
            onClick = {


                viewModel.addString(participantName)

            },
            icon = { Icon(Icons.Filled.Add, "Extended floating action button.") },
            text = { Text(text = "Agregar registro") }

        )



    }
}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FormContainer(){


    Scaffold(
        topBar = {},
        content = { SignUpScreen()



        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun FormContainerPreview(){



    FormContainer()

}
