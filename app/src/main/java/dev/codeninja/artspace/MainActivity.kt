package dev.codeninja.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.codeninja.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ArtSpaceTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
					ArtSpaceScreen()
				}
			}
		}
	}
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
	val artworks = listOf(
		R.drawable.anne ,
		R.drawable.daryl,
		R.drawable.eleven,
		R.drawable.gloria,
		R.drawable.sheldon,
		R.drawable.serena, R.drawable.tokyo, R.drawable.monica, R.drawable.pablo, R.drawable.jughead
	)

	val titles = listOf(
		R.string.Anne,
		R.string.Daryl,
		R.string.Eleven,
		R.string.Gloria,
		R.string.Sheldon,
		R.string.Serena, R.string.Tokyo, R.string.Monica, R.string.Pablo, R.string.Jughead
	)

	val description = listOf(
		R.string.Anne_text,
		R.string.Daryl_text,
		R.string.Eleven_text,
		R.string.Gloria_text,
		R.string.Sheldon_text,
		R.string.Serena_text, R.string.Tokyo_text, R.string.Monica_text, R.string.Pablo_text, R.string.Jughead_text
	)

	var currentIndex by remember { mutableStateOf(0) }
	var currentArtwork by remember { mutableStateOf(artworks[0]) }
	var title by remember { mutableStateOf(titles[0]) }
	var texto_serie by remember { mutableStateOf(description[0]) }

	fun changeArtwork(index: Int) {
		currentArtwork = artworks[index]
		title = titles[index]
		texto_serie = description[index]
	}

	var restartButtonPressed by remember { mutableStateOf(false) }

	DisposableEffect(restartButtonPressed) {
		if (restartButtonPressed) {
			restartButtonPressed = false
		}
		onDispose { }
	}

	fun onButtonClick(isNext: Boolean) {
		val newIndex = if (isNext) (currentIndex + 1) % artworks.size else (currentIndex - 1 + artworks.size) % artworks.size
		currentIndex = newIndex
		changeArtwork(newIndex)
	}

	Column(
		modifier = modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = modifier.size(16.dp))
		Text(text = "Mayra Alejandra Sanchez Salinas", fontSize = 20.sp)
		Spacer(modifier = modifier.size(16.dp))
		Text(text = "- 202040506 -", fontSize = 20.sp)
		Spacer(modifier = modifier.size(16.dp))
		Text(text = "My favorite characters", fontSize = 20.sp)
		Spacer(modifier = modifier.size(16.dp))
		ArtworkDisplay(currentArtwork = currentArtwork)
		Spacer(modifier = modifier.size(16.dp))
		ArtworkTitle(title = title, texto_serie = texto_serie)
		Spacer(modifier = modifier.size(25.dp))
		Row(
			modifier = modifier.padding(horizontal = 8.dp),
			horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
		) {
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.spacedBy(8.dp)
			) {
				Button(
					onClick = {
						currentIndex = (currentIndex - 1 + artworks.size) % artworks.size
						changeArtwork(currentIndex)
					},
					colors = ButtonDefaults.buttonColors(
						backgroundColor = colorResource(id = R.color.gray_900)
					),
					elevation = ButtonDefaults.elevation(
						defaultElevation = 1.dp,
						pressedElevation = 0.dp,
						focusedElevation = 0.dp
					)
				) {
					Text(
						text = "Previous character",
						fontSize = 16.sp,
						fontWeight = FontWeight.Medium,
						color = colorResource(id = R.color.blue_300)
					)
				}

				Button(
					onClick = {
						currentIndex = (currentIndex + 1) % artworks.size
						changeArtwork(currentIndex)
					},
					colors = ButtonDefaults.buttonColors(
						backgroundColor = colorResource(id = R.color.gray_900)
					),
					elevation = ButtonDefaults.elevation(
						defaultElevation = 1.dp,
						pressedElevation = 0.dp,
						focusedElevation = 0.dp
					)
				) {
					Text(
						text = "Next character",
						fontSize = 16.sp,
						fontWeight = FontWeight.Medium,
						color = colorResource(id = R.color.blue_300)
					)
				}
			}

			IconButton(
				onClick = {
					restartButtonPressed = true
					currentIndex = 0 // Reinicia el índice de la galería
					changeArtwork(0) // Cambia el arte a la primera imagen
				},
				modifier = Modifier.size(48.dp),
				content = {
					Icon(
						imageVector = Icons.Default.Refresh,
						contentDescription = null,
						tint = Color.White
					)
				}
			)
		}
	}
}

@Composable
fun ArtworkDisplay(
	modifier: Modifier = Modifier,
	@DrawableRes currentArtwork: Int
) {
	Box(
		modifier = modifier
			.fillMaxWidth()
			.aspectRatio(1f),
		contentAlignment = Alignment.Center
	) {
		Image(
			painter = painterResource(currentArtwork),
			contentDescription = stringResource(id = R.string.Daryl),
			contentScale = ContentScale.Crop,
			modifier = Modifier
				.fillMaxSize()
				.clip(shape = RoundedCornerShape(15.dp))
		)
	}
}

@Composable
fun ArtworkTitle(
	@StringRes title: Int,
	@StringRes texto_serie: Int
) {
	Column (
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Artwork title
		Text(
			text = stringResource(id = title),
			fontWeight = FontWeight.Bold,
			color = colorResource(id = R.color.white),
			fontSize = 32.sp
		)

		// Artwork year
		Text(
			text = "— ${stringResource(id = texto_serie)} —",
			fontSize = 16.sp,
			fontWeight = FontWeight.Medium,
			color = colorResource(id = R.color.black)
		)
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	ArtSpaceTheme {
		ArtSpaceScreen()
	}
}