package br.senai.jandira.sp.zero_wasteapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.jandira.sp.zero_wasteapplication.ui.theme.Zero_WasteApplicationTheme
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zero_WasteApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ZeroWasteAppplication()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun ZeroWasteAppplication() {

    var recicladorClick by remember {
        mutableStateOf(true)
    }

    var catadorClick by remember {
        mutableStateOf(false)
    }

    var color1 by remember {
        mutableStateOf(Color(128, 204, 40))
    }
    var color2 by remember {
        mutableStateOf(Color.Transparent)
    }

    var nameValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var cpfValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var emailValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var telephoneValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var cepValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var residencialValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var complementValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var passwordValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    var confirmPasswordValueChangeReciclador by rememberSaveable {
        mutableStateOf("")
    }

    val calendarState = rememberSheetState()

    var birthdayValueChangeReciclador by rememberSaveable {
        mutableStateOf("Ano-Mes-Dia")
    }

    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.visibility_icon_on)
    } else {
        painterResource(id = R.drawable.visibility_icon_off)
    }
    val confirmIcon = if (confirmPasswordVisibility) {
        painterResource(id = R.drawable.visibility_icon_on)
    } else {
        painterResource(id = R.drawable.visibility_icon_off)
    }

    var nameValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var cpfValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var emailValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var telephoneValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var cepValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var residencialValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var complementValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var passwordValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var confirmPasswordValueChangeCatador by rememberSaveable {
        mutableStateOf("")
    }

    var birthdayValueChangeCatador by rememberSaveable {
        mutableStateOf("Ano-Mes-Dia")
    }

    var confirmPassError by remember {
        mutableStateOf(false)
    }

    fun validatePass(pass: String, confirmPass: String): Boolean {
        return confirmPass != pass
    }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(96.dp)
                    .padding(end = 13.dp)
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Zero")
                    }
                    append(' ')
                    withStyle(style = SpanStyle(color = Color(8, 113, 19))) {
                        append("Waste")
                    }
                },
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(8, 113, 19))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.background(
                        color = Color.White,
                        shape = RoundedCornerShape(5.dp)
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.recycler),
                        modifier = Modifier
                            .background(
                                color1,
                                shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)
                            )
                            .clickable {
                                recicladorClick = true
                                catadorClick = false
                                color1 = Color(128, 204, 40)
                                color2 = Color.Transparent
                            }
                            .padding(
                                top = 15.dp,
                                bottom = 15.dp
                            )
                            .width(130.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = stringResource(id = R.string.catador),
                        modifier = Modifier
                            .background(
                                color2,
                                shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                            )
                            .clickable {
                                recicladorClick = false
                                catadorClick = true
                                color2 = Color(128, 204, 40)
                                color1 = Color.Transparent
                            }
                            .padding(
                                top = 15.dp,
                                bottom = 15.dp,
                            )
                            .width(130.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Text(
                text = stringResource(id = R.string.welcome_message),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 20.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center
            )
            AnimatedVisibility(
                visible = recicladorClick,
                enter = slideInHorizontally(animationSpec = tween(500)) { fullWidth -> -fullWidth } + fadeIn(
                    animationSpec = tween(durationMillis = 300)
                ),
                exit =
                slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessHigh)) {
                    300
                } + fadeOut()
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    OutlinedTextField(
                        value = nameValueChangeReciclador, onValueChange = { newValue ->
                            nameValueChangeReciclador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.name_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = ""
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = cpfValueChangeReciclador, onValueChange = { newValue ->
                            cpfValueChangeReciclador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.cpf_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Code, //Procurar um Icon para substituir o atual
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = emailValueChangeReciclador, onValueChange = { newValue ->
                            emailValueChangeReciclador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.email_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = telephoneValueChangeReciclador, onValueChange = { newValue ->
                            telephoneValueChangeReciclador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.telephone_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row {
                        OutlinedTextField(
                            value = cepValueChangeReciclador, onValueChange = { newValue ->
                                cepValueChangeReciclador = newValue
                            },
                            modifier = Modifier
                                .width(220.dp)
                                .padding(start = 30.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            placeholder = { Text(text = stringResource(id = R.string.cep_label)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = ""
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        OutlinedTextField(
                            value = residencialValueChangeReciclador, onValueChange = { newValue ->
                                residencialValueChangeReciclador = newValue
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .padding(end = 30.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            placeholder = { Text(text = stringResource(id = R.string.residencial_label)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Menu, //Procurar um Icon para substituir o atual
                                    contentDescription = ""
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = complementValueChangeReciclador, onValueChange = { newValue ->
                            complementValueChangeReciclador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.complement_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )

                    CalendarDialog(
                        state = calendarState,
                        config = CalendarConfig(
                            yearSelection = true
                        ),
                        selection = CalendarSelection.Date { birthdate ->
                            birthdayValueChangeReciclador = birthdate.toString()
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            calendarState.show()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(128, 204, 40))
                    ) {
                        Text(
                            text = stringResource(id = R.string.select_bithday),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = birthdayValueChangeReciclador,
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                            .height(30.dp)
                            .fillMaxWidth(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = passwordValueChangeReciclador,
                        onValueChange = { newValue ->
                            passwordValueChangeReciclador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.password_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = ""
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(
                                    painter = icon,
                                    contentDescription = "visibility icon",
                                    modifier = Modifier.width(35.dp)
                                )
                            }
                        },
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = confirmPasswordValueChangeReciclador,
                        onValueChange = { newValue ->
                            confirmPasswordValueChangeReciclador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.confirm_password_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = if (confirmPassError) {
                                    Icons.Default.Error
                                } else {
                                    Icons.Default.Lock
                                },
                                contentDescription = "",
                                tint = if (confirmPassError)
                                    Color.Red
                                else
                                    Color.Gray
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility = !confirmPasswordVisibility
                            }) {
                                Icon(
                                    painter = confirmIcon,
                                    contentDescription = "Visibility Icon",
                                    modifier = Modifier.width(35.dp)
                                )
                            }
                        },
                        isError = confirmPassError,
                        visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            confirmPassError = validatePass(
                                passwordValueChangeReciclador,
                                confirmPasswordValueChangeReciclador
                            )
                        },
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(128, 204, 40))
                    ) {
                        Text(
                            text = (stringResource(id = R.string.login_as) + " " + stringResource(id = R.string.recycler)),
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
            AnimatedVisibility(
                visible = catadorClick,
                enter = slideInHorizontally(animationSpec = tween(500)) { fullWidth -> -fullWidth } + fadeIn(
                    animationSpec = tween(durationMillis = 200)
                ),
                exit =
                slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessHigh)) {
                    300
                } + fadeOut()
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    OutlinedTextField(
                        value = nameValueChangeCatador, onValueChange = { newValue ->
                            nameValueChangeCatador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.name_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = ""
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = cpfValueChangeCatador, onValueChange = { newValue ->
                            cpfValueChangeCatador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.cpf_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Send, //Procurar um Icon para substituir o atual
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = emailValueChangeCatador, onValueChange = { newValue ->
                            emailValueChangeCatador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.email_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = telephoneValueChangeCatador, onValueChange = { newValue ->
                            telephoneValueChangeCatador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.telephone_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row {
                        OutlinedTextField(
                            value = cepValueChangeCatador, onValueChange = { newValue ->
                                cepValueChangeCatador = newValue
                            },
                            modifier = Modifier
                                .width(220.dp)
                                .padding(start = 30.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            placeholder = { Text(text = stringResource(id = R.string.cep_label)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Home,
                                    contentDescription = ""
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        OutlinedTextField(
                            value = residencialValueChangeCatador, onValueChange = { newValue ->
                                residencialValueChangeCatador = newValue
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .padding(end = 30.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            placeholder = { Text(text = stringResource(id = R.string.residencial_label)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Menu, //Procurar um Icon para substituir o atual
                                    contentDescription = ""
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = complementValueChangeCatador, onValueChange = { newValue ->
                            complementValueChangeCatador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.complement_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = ""
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    CalendarDialog(
                        state = calendarState,
                        config = CalendarConfig(
                            yearSelection = true
                        ),
                        selection = CalendarSelection.Date { birthdate ->
                            birthdayValueChangeCatador = birthdate.toString()
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(
                        onClick = {
                            calendarState.show()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(128, 204, 40))
                    ) {
                        Text(
                            text = stringResource(id = R.string.select_bithday),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = birthdayValueChangeCatador,
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                            .height(30.dp)
                            .fillMaxWidth(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = passwordValueChangeCatador, onValueChange = { newValue ->
                            passwordValueChangeCatador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.password_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = ""
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                                Icon(
                                    painter = icon,
                                    contentDescription = "visibility icon",
                                    modifier = Modifier.width(35.dp)
                                )
                            }
                        },
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = confirmPasswordValueChangeCatador, onValueChange = { newValue ->
                            confirmPasswordValueChangeCatador = newValue
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp)
                            .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                        placeholder = { Text(text = stringResource(id = R.string.confirm_password_label)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = ""
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility = !confirmPasswordVisibility
                            }) {
                                Icon(
                                    painter = confirmIcon,
                                    contentDescription = "visibility icon",
                                    modifier = Modifier.width(35.dp)
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        shape = RoundedCornerShape(10.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(128, 204, 40))
                    ) {
                        Text(
                            text = (stringResource(id = R.string.login_as) + " " + stringResource(id = R.string.catador)),
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ZeroWasteApplicationPreview() {
    ZeroWasteAppplication()
}





