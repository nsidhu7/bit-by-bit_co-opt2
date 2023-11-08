package com.mobile.coopt2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.coopt2.ui.theme.Coopt2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Coopt2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer(){
    
    val drawerItem = listOf(
        DrawerItems(Icons.Default.Face, "Profile", 0, false),
        DrawerItems(Icons.Filled.Email, "Inbox", 32, true),
        DrawerItems(Icons.Filled.Favorite, "Favorite", 32, true),
        DrawerItems(Icons.Filled.Settings, "Setting", 0, false),
    )
    va
    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {

            Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(12.dp)) {

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xfffc107)),
                    contentAlignment = Alignment.Center
                ){
                    Column(Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile pic",
                            modifier = Modifier
                                .size(130.dp)
                                .clip(CircleShape)
                        )
                        Text(text = "Name",
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            fontSize = 22.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Divider(
                        Modifier.align(Alignment.BottomCenter), thickness = 1.dp,
                        Color.DarkGray
                    )

                }

            }
            drawerItem.forEach{
                NavigationDrawerItem(label = { Text(text = it.text) }, 
                    selected = it == selectedItem, 
                    onClick = { /*TODO*/ },
                    icon = {
                        Icon(imageVector = it.icon, contentDescription = it.text)
                    },
                    badge = {
                        if (it.hasBadge){
                            BadgedBox(badge = {
                                Text(
                                    text = it.badgeCount.toString(),
                                    fontSize = 17.sp
                                )
                            }) {
                                
                            }
                        }
                    })
            }
        }
    }) {

    }

}
data class DrawerItems(
    val icon : ImageVector,
    val text: String,
    val badgeCount: Int,
    val hasBadge : Boolean
)