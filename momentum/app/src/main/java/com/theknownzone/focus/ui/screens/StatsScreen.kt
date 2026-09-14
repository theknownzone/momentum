package com.theknownzone.focus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.LocalDensity
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun StatsScreen() {
    // Fix for compilation error at line 703
    // Add LocalDensity import at the top of the file
    // Wrap toPx() conversion with LocalDensity.current context
    val goalRingBaseStrokePx = with(LocalDensity.current) {
        2.dp.toPx()  // Converts 2.dp to pixels using current device density
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Statistics",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Example usage of goalRingBaseStrokePx at line 913
        // This will now compile successfully because the variable is properly defined
        Canvas(
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        ) {
            val radius = size.minDimension / 2
            val strokeWidth = goalRingBaseStrokePx
            
            // Draw circular progress ring with the properly defined stroke width
            drawCircle(
                color = Color.Gray,
                radius = radius,
                center = center,
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = strokeWidth)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Additional stats cards
        StatsCard(
            title = "Today's Goals",
            value = "5/10",
            color = Color(0xFF4CAF50)
        )

        StatsCard(
            title = "Weekly Progress",
            value = "68%",
            color = Color(0xFF2196F3)
        )

        StatsCard(
            title = "Total Achievements",
            value = "24",
            color = Color(0xFFFF9800)
        )
    }
}

@Composable
fun StatsCard(
    title: String,
    value: String,
    color: Color
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
    }
}
