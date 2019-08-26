package com.rommansabbir.easyencryption

import com.rommansabbir.easyencryption.callback.EncryptionCallback
import com.rommansabbir.easyencryption.handler.DecryptionWorker
import com.rommansabbir.easyencryption.handler.EncryptionWorker
import com.rommansabbir.easyencryption.result.EncryptionResult

/**
 * Manage file encryption using the help of [EasyEncryption]
 * Encryption & Decryption both run in Async mode
 * Get encrypted/decrypted data as instance of [EncryptionResult]
 */
object EasyEncryption {

    /**
     * This method handle action to encrypt a file using AES algorithm
     * @param password, [String]
     * @param fileToEncrypt, [ByteArray]
     * @param callback, [EncryptionCallback]
     */
    fun encryptWithAES(password: String, fileToEncrypt: ByteArray, callback: EncryptionCallback) {
        EncryptionWorker(
            password,
            fileToEncrypt,
            callback
        ).doInBackground()
    }

    /**
     * This method handle action to decrypt a file using AES algorithm
     * @param key, [ByteArray]
     * @param fileToEncrypt, [ByteArray]
     * @param callback, [EncryptionCallback]
     */
    fun decryptWithAES(key: ByteArray, fileToEncrypt: ByteArray, callback: EncryptionCallback) {
        DecryptionWorker(
            key,
            fileToEncrypt,
            callback
        ).doInBackground()
    }
}