package dev.codeninja.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
	val firstArtwork = R.drawable.anne
	val secondArtwork = R.drawable.daryl
	val thirdArtwork = R.drawable.eleven
	val fourthArtwork = R.drawable.gloria
	val fifthArtwork = R.drawable.sheldon
	val sixthArtwork = R.drawable.serena
	val seventhArtwork = R.drawable.tokyo
	val eighthArtwork = R.drawable.monica
	val ninthArtwork = R.drawable.pablo
	val tenthArtwork = R.drawable.jughead

	var title by remember {
		mutableStateOf(R.string.Anne)
	}

	var texto_serie by remember {
		mutableStateOf(R.string.Anne_text)
	}

	var currentArtwork by remember {
		mutableStateOf(firstArtwork)
	}

	var imageResource by remember {
		mutableStateOf(currentArtwork)
	}


	Column(
		modifier = modifier
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		ArtworkDisplay(currentArtwork = currentArtwork)
		Spacer(modifier = modifier.size(16.dp))
		ArtworkTitle(title = title, texto_serie = texto_serie)
		Spacer(modifier = modifier.size(25.dp))
		Row(
			modifier = modifier.padding(horizontal = 8.dp),
			horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
		) {
			// Previous Button
			Button(
				onClick = {
					when (currentArtwork) {
						firstArtwork -> {
							currentArtwork = tenthArtwork
							title = R.string.Jughead
							texto_serie = R.string.Jughead_text
						}
						secondArtwork -> {
							currentArtwork = firstArtwork
							title = R.string.Anne
							texto_serie = R.string.Anne_text
						}
						thirdArtwork -> {
							currentArtwork = secondArtwork
							title = R.string.Daryl
							texto_serie = R.string.Daryl_text
						}
						fourthArtwork -> {
							currentArtwork = thirdArtwork
							title = R.string.Eleven
							texto_serie = R.string.Eleven_text
						}
						fifthArtwork -> {
							currentArtwork = fourthArtwork
							title = R.string.Gloria
							texto_serie = R.string.Gloria_text
						}
						sixthArtwork -> {
							currentArtwork = fifthArtwork
							title = R.string.Sheldon
							texto_serie = R.string.Sheldon_text
						}
						seventhArtwork -> {
							currentArtwork = sixthArtwork
							title = R.string.Serena
							texto_serie = R.string.Serena_text
						}
						eighthArtwork -> {
							currentArtwork = seventhArtwork
							title = R.string.Tokyo
							texto_serie = R.string.Tokyo_text
						}
						ninthArtwork -> {
							currentArtwork = eighthArtwork
							title = R.string.Monica
							texto_serie = R.string.Monica_text
						}
						else -> {
							currentArtwork = ninthArtwork
							title = R.string.Pablo
							texto_serie = R.string.Pablo_text
						}
					}
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

			// Next Button
			Button(
				onClick = {
					when (currentArtwork) {
						firstArtwork -> {
							currentArtwork = tenthArtwork
							title = R.string.Jughead
							texto_serie = R.string.Jughead_text
						}
						secondArtwork -> {
							currentArtwork = firstArtwork
							title = R.string.Anne
							texto_serie = R.string.Anne_text
						}
						thirdArtwork -> {
							currentArtwork = secondArtwork
							title = R.string.Daryl
							texto_serie = R.string.Daryl_text
						}
						fourthArtwork -> {
							currentArtwork = thirdArtwork
							title = R.string.Eleven
							texto_serie = R.string.Eleven_text
						}
						fifthArtwork -> {
							currentArtwork = fourthArtwork
							title = R.string.Gloria
							texto_serie = R.string.Gloria_text
						}
						sixthArtwork -> {
							currentArtwork = fifthArtwork
							title = R.string.Sheldon
							texto_serie = R.string.Sheldon_text
						}
						seventhArtwork -> {
							currentArtwork = sixthArtwork
							title = R.string.Serena
							texto_serie = R.string.Serena_text
						}
						eighthArtwork -> {
							currentArtwork = seventhArtwork
							title = R.string.Tokyo
							texto_serie = R.string.Tokyo_text
						}
						ninthArtwork -> {
							currentArtwork = eighthArtwork
							title = R.string.Monica
							texto_serie = R.string.Monica_text
						}
						else -> {
							currentArtwork = ninthArtwork
							title = R.string.Pablo
							texto_serie = R.string.Pablo_text
						}
					}
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
	}
}

@Composable
fun ArtworkDisplay(
	modifier: Modifier = Modifier,
	@DrawableRes currentArtwork: Int
) {
	Image(
		painter = painterResource(currentArtwork),
		contentDescription = stringResource(id = R.string.Daryl),
		modifier = modifier.fillMaxWidth(),
		contentScale = ContentScale.FillWidth
	)
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