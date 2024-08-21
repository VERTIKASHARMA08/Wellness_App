package com.example.wellnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wellnessapp.data.Tasks
import com.example.wellnessapp.data.tasks
import com.example.wellnessapp.ui.theme.WellnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WellnessAppTheme {

                Surface(
                    modifier =Modifier.fillMaxSize()
                ){
                    WellApp()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellTopAppBarr(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(title = {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_size))
                .padding(dimensionResource(id = R.dimen.padding_small)),
                  painter = painterResource(R.drawable.icon) ,
                  contentDescription = null
            )
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
     },
        modifier =Modifier
     )
}

@Composable
fun WellApp (){
    Scaffold(
        topBar = {
            WellTopAppBarr()
        }
    ) { it ->
         LazyColumn(contentPadding = it) {
             items(tasks) {
                 TasksItem(
                     tasks = it,
                     modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                 )
             }
         }
    }
}
@Composable
fun TasksItem(
    tasks: Tasks,
    modifier: Modifier = Modifier
){ var expanded by remember { mutableStateOf(false) }

    Card(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )

        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ){
               Row {
                   TasksInformation(tasks.day, tasks.topic)
                   Spacer(modifier = Modifier.weight(1f))
                   TasksItemButton(expanded = expanded,
                       onClick = { expanded = !expanded }
                   )
               }
               TasksIcon(tasks.imageResourceId)
            }

            if (expanded){
                TasksDescription(
                    tasks.description,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}
@Composable
fun TasksInformation(
    tasksDay : Int,
    @StringRes tasksTopic: Int,
    modifier: Modifier = Modifier
){
    Column(modifier= modifier){
        Text(
            text = stringResource(R.string.Day,tasksDay),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
        Text(
            text = stringResource(tasksTopic),
            style = MaterialTheme.typography.displayMedium,
            )
    }
}
@Composable
fun TasksIcon(
    @DrawableRes tasksIcon :Int,
    modifier: Modifier = Modifier
){
    Column( modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = modifier
                .size(200.dp)
                .padding(dimensionResource(R.dimen.padding_small)),
            contentScale = ContentScale.Crop,
            painter = painterResource(tasksIcon),
            contentDescription = null
        )
    }

}
@Composable
fun TasksItemButton(
    expanded : Boolean,
    onClick : () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(onClick = onClick,
        modifier = Modifier) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}


@Composable
fun TasksDescription(
    @StringRes tasksDescription: Int,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(tasksDescription),
        style = MaterialTheme.typography.displayMedium,
        modifier = modifier.padding(start = 8.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WellnessAppPreview() {
    WellnessAppTheme() {
                 WellApp()
    }
}