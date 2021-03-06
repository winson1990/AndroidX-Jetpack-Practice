package com.hi.dhl.paging3.data

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/6/16
 *     desc  :
 * </pre>
 */


object AppExecutors{

    fun disIO(disk:() -> Unit){
        doAsync {
            disk()
        }
    }

    fun networkIO(network:()->Unit){
        doAsync {
            network()
        }
    }

    fun mainThread(io:()->Unit,main:()->Unit){
        doAsync {
            io()
            uiThread {
                main()
            }
        }
    }
}