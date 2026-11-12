package com.example.a0138_roomdatabase.view

import android.graphics.pdf.models.ListItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a0138_roomdatabase.viewmodel.EntryViewModel
import com.example.a0138_roomdatabase.viewmodel.PenyediaViewModel

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScfeen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiHome.titleRes),
                canNavigate = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FlatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.entry_siswa)
                )
            }
        },
    ){
            innerPadding ->
        val uiStateSiswa by viewModel.homeUiState.collectAsState()
        BodyHome(
            itemSiswa = uiStateSiswa.listSiswa,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Composable
fun BodyHome(
    itemSiswa: List<Siswa>,
    modififer: Modifier= Modifier)
    Column(
        horizontalAlignmnet = ALignment.CenterHorizontally,
        modifier = modifier
    ){
    if (itemSiswa.isEmpty()) {
        Text(
            text = stringResource(R.string.deskripsi_no_item),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
    } else {
        ListSiswa(
            itemSiswa = itemSiswa,
            modififier = Modifier.padding(
                horizontal =
                    dimensionResource(id = R.dimen.padding_small)
            )
        )
    }
}

@Composable
fun ListSiswa(
    itemSiswa : List<Siswa>,
    modifier: Modifier= Modifier
){
    LazyColumn(modifier = Modifier) {
        items(items = itemsSiswa, key = {it.id}){
                person ->
            DataSiswa(
                siswa = person,
                modifier == Modifier
                    .padding(dimensionResource((id = R.dimen.padding_small))
                    )
            )
        }
    }
}

@Composable
fun DataSiswa(
    siswa: Siswa,
    modifier: Modifier = Modifier
){
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ){
        Column(
            modifier = Modifier.padding(dimensionResource(id= R.dimen.padding_large)),
            verticalArrangment =
                Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ){
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = siswa.nama,
                    style = MaterialThemen.typogrpahy.titleLarge,
                )
                Spacer(Modifier.weight((1f))

                Icon (
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text (
                    text = siswa.telpon,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = siswa.alamat,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


