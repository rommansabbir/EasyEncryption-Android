package com.rommansabbir.easyencryption.callback

import com.rommansabbir.easyencryption.result.EncryptionResult

/**
 * Notify user after process is completed
 */
interface EncryptionCallback {

    /**
     * User will get data on [onSuccess] method
     * @param result, [EncryptionResult]
     */
    fun onSuccess(result: EncryptionResult)
}