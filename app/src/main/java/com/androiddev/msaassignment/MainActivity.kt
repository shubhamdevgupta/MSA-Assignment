package com.androiddev.msaassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androiddev.msaassignment.ui.theme.MSAAssignmentTheme
import com.androiddev.msaassignment.viewmodel.SearchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MSAAssignmentTheme {

                val viewModel: SearchViewModel = viewModel()
                LaunchedEffect(Unit) {
                    viewModel.searchNearby()
                }
                BusinessListScreen(viewModel)
            }
        }
    }
}
