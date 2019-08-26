package com.rommansabbir.easyencryption.handler

import android.annotation.SuppressLint
import android.os.AsyncTask
import com.rommansabbir.easyencryption.callback.EncryptionCallback
import com.rommansabbir.easyencryption.result.EncryptionResult
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * This class perform decryption using [AsyncTask] in a separated thread
 * @param key, [ByteArray]
 * @param fileData, [ByteArray]
 * @param callback, [EncryptionResult]
 */
class DecryptionWorker(
    private val key: ByteArray,
    private val fileData: ByteArray,
    private val callback: EncryptionCallback
) :
    AsyncTask<Unit, Unit, Unit>() {
    /**
     * Performing the decryption logic here
     */
    @SuppressLint("GetInstance")
    @Throws(Exception::class)
    public override fun doInBackground(vararg p0: Unit?) {
        val skeySpec = SecretKeySpec(key, "AES")
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, skeySpec)
        callback.onSuccess(
            EncryptionResult(
                key,
                cipher.doFinal(fileData)
            )
        )
    }

}