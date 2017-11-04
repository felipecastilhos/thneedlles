package br.com.felipecastilhos.thneedles

import br.com.felipecastilhos.thneedles.data.NeedleModel

/**
 * Created by felip on 04/11/2017.
 */
interface NeedleDataSource {
    fun insert(name:String, size: Int, quantity: Int)
    fun requestNeedleByName(name: String): NeedleModel?
    fun requestNeedleById(id: Int): NeedleModel?
}