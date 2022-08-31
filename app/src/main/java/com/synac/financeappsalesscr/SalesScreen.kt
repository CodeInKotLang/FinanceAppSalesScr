package com.synac.financeappsalesscr

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.synac.financeappsalesscr.ui.theme.*

@Composable
fun SalesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(CustomDarkGray, CustomLightGreen)
                )
            )
            .padding(25.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(R.drawable.more),
                    contentDescription = "more",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 1.dp,
                        color = CustomOrange,
                        shape = RoundedCornerShape(20f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.david),
                    contentDescription = "Profile Pic",
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(40.dp)
                )
            }
        }
        LazyRow(
            modifier = Modifier.height(250.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            items(year2022Sales) { item ->
                SingleBar(
                    monthlySalesData = item
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }
}

data class MonthlySalesData(
    val month: String,
    val salesInThousands: Int
)

val year2022Sales = mutableListOf(
    MonthlySalesData(month = "Jan", salesInThousands = 13),
    MonthlySalesData(month = "Feb", salesInThousands = 24),
    MonthlySalesData(month = "Mar", salesInThousands = 16),
    MonthlySalesData(month = "Apr", salesInThousands = 32),
    MonthlySalesData(month = "May", salesInThousands = 26),
    MonthlySalesData(month = "Jun", salesInThousands = 19),
    MonthlySalesData(month = "Jul", salesInThousands = 12),
    MonthlySalesData(month = "Aug", salesInThousands = 18),
    MonthlySalesData(month = "Sep", salesInThousands = 11),
    MonthlySalesData(month = "Oct", salesInThousands = 21),
    MonthlySalesData(month = "Nov", salesInThousands = 23),
    MonthlySalesData(month = "Dec", salesInThousands = 19),
)

@Composable
fun SingleBar(
    monthlySalesData: MonthlySalesData
) {
    val largestSalesValue = year2022Sales.maxOf {
        it.salesInThousands
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${monthlySalesData.salesInThousands}k",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.ubuntu)),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp
                    )
                )
                .background(
                    if (year2022Sales.indexOf(monthlySalesData) % 2 == 0) {
                        CustomLightOrange
                    } else CustomCyan
                )
                .width(40.dp)
                .height(
                    (200 * monthlySalesData.salesInThousands / largestSalesValue).dp
                )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = monthlySalesData.month,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.ubuntu)),
            fontSize = 12.sp
        )
    }
}

@Preview
@Composable
fun SalesScreenPrev() {
    SalesScreen()
}









