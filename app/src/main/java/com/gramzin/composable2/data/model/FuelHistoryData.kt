package ru.rigellab.hb.domain.model

import java.util.Date

/**
 * История изменения цены топлива
 * @property date дата (день, месяц, год)
 * @property priceInPenny цена в копейках
 */
data class FuelHistoryData(val date: Date, val priceInPenny: Int)
