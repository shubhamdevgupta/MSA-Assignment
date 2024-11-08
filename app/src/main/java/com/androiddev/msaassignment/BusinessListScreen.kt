package com.androiddev.msaassignment

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.androiddev.msaassignment.model.FoursquarePlace
import com.androiddev.msaassignment.viewmodel.SearchViewModel


@Composable
fun BusinessListScreen(viewModel: SearchViewModel) {
    val businesses = viewModel.results.collectAsState()

    if (businesses.value.isEmpty()) {
        LottieLoadingScreen()
    } else {
        Column(modifier = Modifier.fillMaxSize())
        {
            CenteredTitle()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp) // Margin around the list
            ) {
                items(businesses.value) { business ->
                    BusinessItem(business)
                }
            }
        }
    }
}

@Composable
fun CenteredTitle() {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill width for the title
            .padding(16.dp) // Optional padding around the text
    ) {
        Text(
            text = "MSA Assignment",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold, // Make the title bold
                fontSize = 28.sp // Adjust the font size
            ),
            color = MaterialTheme.colorScheme.primary, // Title color from color scheme
            modifier = Modifier.align(Alignment.Center) // Center the text
        )
    }
}

@Composable
fun BusinessItem(business: FoursquarePlace) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Margin between cards
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp) // Padding inside the card
        ) {
            // Name
            Text(
                text = business.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp)) // Small space between items

            // Address
            Text(
                text = "Address: ${business.location.formatted_address ?: "N/A"}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Distance
            Text(
                text = "Distance: ${business.distance} meters",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Category
            val categoryName = business.categories.firstOrNull()?.name ?: "N/A"
            Text(
                text = "Category: $categoryName",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Geocode Information
            Text(
                text = "Latitude: ${business.geocodes.main.latitude}, Longitude: ${business.geocodes.main.longitude}",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .padding(16.dp), // Add padding for spacing
            color = MaterialTheme.colorScheme.primary // Set your color for progress
        )
    }
}

@Composable
fun LottieLoadingScreen() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(200.dp)
        )
    }
}

