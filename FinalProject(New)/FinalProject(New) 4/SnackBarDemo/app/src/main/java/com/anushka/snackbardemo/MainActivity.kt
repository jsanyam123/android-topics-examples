package com.anushka.snackbardemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.anushka.snackbardemo.ui.theme.SnackBarDemoTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            SnackBarDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //  Greeting("Android")
                    DisplaySnackBar()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DisplaySnackBar(){
    //val scaffoldState : ScaffoldState = rememberScaffoldState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope : CoroutineScope = rememberCoroutineScope()

//    Scaffold(scaffoldState = scaffoldState) {
//        Button(onClick = {
//            coroutineScope.launch {
//                val snackBarResult =  scaffoldState.snackbarHostState.showSnackbar(
//                    message = "This is the message",
//                    actionLabel = "Undo",
//                    duration = SnackbarDuration.Indefinite
//                )
//                when(snackBarResult){
//                    SnackbarResult.ActionPerformed -> Log.i("MYTAG","action label clicked")
//                    SnackbarResult.Dismissed -> Log.i("MYTAG","dismissed!")
//                }
//            }
//        }) {
//            Text(text = "Display SnackBar")
//        }
//    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Button(
                onClick = {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = "This is the message",
                            actionLabel = "Undo",
                            duration = SnackbarDuration.Indefinite
                        )
                    }
                })
            {
                Text(text = "Display SnackBar")
            }
        }
    )

}