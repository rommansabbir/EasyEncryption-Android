package com.rommansabbir.easyencryption.handler

import android.annotation.SuppressLint
import android.os.AsyncTask
import com.rommansabbir.easyencryption.callback.EncryptionCallback
import com.rommansabbir.easyencryption.result.EncryptionResult
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec

/**
 * This class perform encryption using [AsyncTask] in a separated thread
 * @param password, [ByteArray]
 * @param fileData, [ByteArray]
 * @param callback, [EncryptionResult]
 */
class EncryptionWorker(
    private val password: String,
    private val fileData: ByteArray,
    private val callback: EncryptionCallback
) :
    AsyncTask<Unit, Unit, Unit>() {
    /**
     * Performing the encryption logic here
     */
    @SuppressLint("GetInstance")
    @Throws(Exception::class)
    public override fun doInBackground(vararg p0: Unit?) {
        val keyStart = password.toByteArray(charset("UTF-8"))
        val kgen = KeyGenerator.getInstance("AES")
        val sr = SecureRandom.getInstance("SHA1PRNG")
        sr.setSeed(keyStart)
        kgen.init(128, sr)
        val key = kgen.generateKey().encoded
        val skeySpec = SecretKeySpec(key, "AES")
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec)
        callback.onSuccess(
            EncryptionResult(
                key,
                cipher.doFinal(fileData)
            )
        )
    }
}