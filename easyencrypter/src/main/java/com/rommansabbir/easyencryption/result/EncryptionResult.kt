package com.rommansabbir.easyencryption.result

/**
 * This data class hold reference for encryption key & data
 * @param key, [ByteArray]
 * @param encryptedData, [ByteArray]
 */
data class EncryptionResult(val key: ByteArray, val encryptedData: ByteArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EncryptionResult

        if (!key.contentEquals(other.key)) return false
        if (!encryptedData.contentEquals(other.encryptedData)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = key.contentHashCode()
        result = 31 * result + encryptedData.contentHashCode()
        return result
    }
}