package br.senai.jandira.sp.zero_wasteapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
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
import br.senai.jandira.sp.zero_wasteapplication.api.ApiCalls
import br.senai.jandira.sp.zero_wasteapplication.api.RetrofitApi
import br.senai.jandira.sp.zero_wasteapplication.ime.rememberImeState
import br.senai.jandira.sp.zero_wasteapplication.model.Address
import br.senai.jandira.sp.zero_wasteapplication.model.User
import br.senai.jandira.sp.zero_wasteapplication.ui.theme.Zero_WasteApplicationTheme
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                    ZeroWasteApplication()
                }
            }
        }
    }
}

//@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun ZeroWasteApplication() {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    val retrofit = RetrofitApi.getRetrofit()
    val userCalls = retrofit.create(ApiCalls::class.java)
    val call = userCalls.getAll()

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue / 4, tween(200))
        }
    }

    var recyclerClick by remember {
        mutableStateOf(true)
    }

    var catcherClick by remember {
        mutableStateOf(false)
    }

    var color1 by remember {
        mutableStateOf(Color(128, 204, 40))
    }

    var color2 by remember {
        mutableStateOf(Color.Transparent)
    }

    var nameState by rememberSaveable {
        mutableStateOf("")
    }

    var cpfState by rememberSaveable {
        mutableStateOf("")
    }

    var emailState by rememberSaveable {
        mutableStateOf("")
    }

    var phoneState by rememberSaveable {
        mutableStateOf("")
    }

    var cepState by rememberSaveable {
        mutableStateOf("")
    }

    var resNumberState by rememberSaveable {
        mutableStateOf("")
    }

    var complementState by rememberSaveable {
        mutableStateOf("")
    }

    var passwordState by rememberSaveable {
        mutableStateOf("")
    }

    var confirmPassState by rememberSaveable {
        mutableStateOf("")
    }

    val calendarState = rememberSheetState()

    var birthdayState by rememberSaveable {
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

    var confirmPassError by remember {
        mutableStateOf(false)
    }

    fun validatePass(pass: String, confirmPass: String): Boolean {
        return confirmPass != pass
    }

    var nameError by remember {
        mutableStateOf(false)
    }

    var cpfError by remember {
        mutableStateOf(false)
    }

    var emailError by remember {
        mutableStateOf(false)
    }

    var phoneError by remember {
        mutableStateOf(false)
    }

    var cepError by remember {
        mutableStateOf(false)
    }

    var resNumError by remember {
        mutableStateOf(false)
    }

    var birthDayError by remember {
        mutableStateOf(false)
    }

    var passError by remember {
        mutableStateOf(false)
    }

    var conPassError by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
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
                                recyclerClick = true
                                catcherClick = false
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
                                recyclerClick = false
                                catcherClick = true
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
            Column {
                OutlinedTextField(
                    value = nameState, onValueChange = { newValue ->
                        nameState = newValue
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    placeholder = { Text(text = stringResource(id = R.string.name_label)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = ""
                        )
                    },
                    isError = nameError,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White)
                )
                if (nameError) {
                    Text(
                        text = stringResource(id = R.string.empty_error),
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp, start = 30.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                }
                OutlinedTextField(
                    value = cpfState, onValueChange = { newValue ->
                        cpfState = newValue
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                    placeholder = { Text(text = stringResource(id = R.string.cpf_label)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Code,
                            contentDescription = ""
                        )
                    },
                    isError = cpfError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp)
                )
                if (cpfError) {
                    Text(
                        text = stringResource(id = R.string.empty_error),
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp, start = 30.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                }
                OutlinedTextField(
                    value = emailState, onValueChange = { newValue ->
                        emailState = newValue
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
                    isError = emailError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp)
                )
                if (emailError) {
                    Text(
                        text = stringResource(id = R.string.empty_error),
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp, start = 30.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                }
                OutlinedTextField(
                    value = phoneState, onValueChange = { newValue ->
                        phoneState = newValue
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
                    isError = phoneError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp)
                )
                if (phoneError) {
                    Text(
                        text = stringResource(id = R.string.empty_error),
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp, start = 30.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                }
                Row {
                    Column{
                        OutlinedTextField(
                            value = cepState, onValueChange = { newValue ->
                                cepState = newValue
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
                            isError = cepError,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Right)
                                }
                            ),
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp)
                        )
                        if (cepError) {
                            Text(
                                text = stringResource(id = R.string.empty_field_reduced),
                                color = Color.Red,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(end = 30.dp, start = 30.dp),
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.height(7.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column{
                        OutlinedTextField(
                            value = resNumberState, onValueChange = { newValue ->
                                resNumberState = newValue
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .padding(end = 30.dp)
                                .background(color = Color.White, shape = RoundedCornerShape(10.dp)),
                            placeholder = { Text(text = stringResource(id = R.string.residencial_label)) },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = ""
                                )
                            },
                            isError = resNumError,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Ascii,
                                imeAction = ImeAction.Next
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            singleLine = true,
                            shape = RoundedCornerShape(10.dp)
                        )
                        if (resNumError) {
                            Text(
                                text = stringResource(id = R.string.empty_field_reduced),
                                color = Color.Red,
                                fontSize = 12.sp,
                                modifier = Modifier
                                    .padding(end = 30.dp, start = 30.dp),
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.height(7.dp))
                        }
                    }
                }
                if (!resNumError) {
                    Spacer(modifier = Modifier.height(15.dp))
                }
                OutlinedTextField(
                    value = complementState, onValueChange = { newValue ->
                        complementState = newValue
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
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Ascii,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp)
                )
                CalendarDialog(
                    state = calendarState,
                    config = CalendarConfig(
                        yearSelection = true
                    ),
                    selection = CalendarSelection.Date { birthdate ->
                        birthdayState = birthdate.toString()
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
                    text = birthdayState,
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                        .height(30.dp)
                        .fillMaxWidth(),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
                if (birthDayError) {
                    Text(
                        text = stringResource(id = R.string.birthday_error),
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp, start = 30.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                }
                OutlinedTextField(
                    value = passwordState,
                    onValueChange = { newValue ->
                        passwordState = newValue
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
                    isError = passError,
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp)
                )
                if (passError) {
                    Text(
                        text = stringResource(id = R.string.empty_error),
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp, start = 30.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                }
                OutlinedTextField(
                    value = confirmPassState,
                    onValueChange = { newValue ->
                        confirmPassState = newValue
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
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    singleLine = true,
                    shape = RoundedCornerShape(10.dp)
                )
                if (confirmPassError) {
                    Text(
                        text = stringResource(id = R.string.different_pass),
                        color = Color.Red,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 30.dp, start = 30.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(7.dp))
                } else {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                AnimatedVisibility(
                    visible = recyclerClick,
                    enter = slideInHorizontally(animationSpec = tween(500)) { fullWidth -> -fullWidth } + fadeIn(
                        animationSpec = tween(durationMillis = 300)
                    ),
                    exit =
                    slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessHigh)) {
                        300
                    } + fadeOut()
                ) {
                    Button(
                        onClick = {
                            confirmPassError = validatePass(
                                passwordState,
                                confirmPassState
                            )
                            nameError = nameState.isEmpty()
                            cpfError = cpfState.isEmpty()
                            emailError = emailState.isEmpty()
                            phoneError = phoneState.isEmpty()
                            cepError = cepState.isEmpty()
                            resNumError = resNumberState.isEmpty()
                            birthDayError = birthdayState == "Ano-Mes-Dia"
                            passError = passwordState.isEmpty()
                            conPassError = confirmPassState.isEmpty()

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
                }
                AnimatedVisibility(
                    visible = catcherClick,
                    enter = slideInHorizontally(animationSpec = tween(500)) { fullWidth -> -fullWidth } + fadeIn(
                        animationSpec = tween(durationMillis = 200)
                    ),
                    exit =
                    slideOutHorizontally(animationSpec = spring(stiffness = Spring.StiffnessHigh)) {
                        300
                    } + fadeOut()
                ) {
                    Button(
                        onClick = {
                            confirmPassError = validatePass(
                                passwordState,
                                confirmPassState
                            )
                            nameError = nameState.isEmpty()
                            cpfError = cpfState.isEmpty()
                            emailError = emailState.isEmpty()
                            phoneError = phoneState.isEmpty()
                            cepError = cepState.isEmpty()
                            resNumError = resNumberState.isEmpty()
                            birthDayError = birthdayState == "Ano-Mes-Dia"
                            passError = passwordState.isEmpty()
                            conPassError = confirmPassState.isEmpty()

                            if (!confirmPassError && !nameError && !cpfError && !emailError && !phoneError && !cepError && !resNumError && !birthDayError && !passError && !conPassError) {
                                var userAddress = Address(
                                    cep = cepState,
                                    complemento = complementState
                                )
                                var userData = User(
                                    name = nameState,
                                    cpf = cpfState,
                                    email = emailState,
                                    phone = phoneState,
                                    endereco = userAddress,
                                    birthDay = birthdayState,
                                    password = passwordState
                                )

                                val insertCatcher = userCalls.saveCatador(userData)

                                insertCatcher.enqueue(object : Callback<User> {
                                    override fun onResponse(
                                        call: Call<User>,
                                        response: Response<User>
                                    ) {
                                        Log.i("Okay?", response.body()!!.toString())
                                    }

                                    override fun onFailure(call: Call<User>, t: Throwable) {
                                        Log.i("Não deu?", t.message.toString())
                                    }
                                })
                            }
                        },
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
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ZeroWasteApplicationPreview() {
    ZeroWasteApplication()
}





