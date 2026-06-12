package com.thepourved.veterinarydictionary.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.thepourved.veterinarydictionary.R

@Composable
fun MainScreen() {
    val selectedTab = remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = stringResource(R.string.search)) },
                    label = { Text(stringResource(R.string.search)) },
                    selected = selectedTab.value == 0,
                    onClick = { selectedTab.value = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = stringResource(R.string.categories)) },
                    label = { Text(stringResource(R.string.categories)) },
                    selected = selectedTab.value == 1,
                    onClick = { selectedTab.value = 1 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = stringResource(R.string.favorites)) },
                    label = { Text(stringResource(R.string.favorites)) },
                    selected = selectedTab.value == 2,
                    onClick = { selectedTab.value = 2 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AccountCircle, contentDescription = stringResource(R.string.profile)) },
                    label = { Text(stringResource(R.string.profile)) },
                    selected = selectedTab.value == 3,
                    onClick = { selectedTab.value = 3 }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab.value) {
                0 -> SearchScreen()
                1 -> CategoriesScreen()
                2 -> FavoritesScreen()
                3 -> ProfileScreen()
            }
        }
    }
}

@Composable
fun SearchScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("صفحه جستجو")
    }
}

@Composable
fun CategoriesScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("صفحه دسته‌بندی‌ها")
    }
}

@Composable
fun FavoritesScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("صفحه علاقه‌مندی‌ها")
    }
}

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("صفحه پروفایل")
    }
}