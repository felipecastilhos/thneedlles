package br.com.felipecastilhos.thneedles.data

import br.com.felipecastilhos.thneedles.NeedleDataSource
import org.jetbrains.anko.db.insert

class NeedleDb(private val needleDbHelper: THDBHelper) : NeedleDataSource {
    override fun insert(name: String, size: Int, quantity: Int): Unit = needleDbHelper.use {
        insert( NeedleTable.TABLE_NAME,
                NeedleTable.NAME to name,
                NeedleTable.SIZE to size,
                NeedleTable.QUANTITY to quantity)
    }

    override fun requestNeedleByName(name: String): NeedleModel? = needleDbHelper.use {
        val needle = NeedleModel("oi", 1, 2)
        needle
    }

    override fun requestNeedleById(id: Int): NeedleModel? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}