# EasyEncryption-Android Usages

## Documentation

### Installation
---
Step 1. Add the JitPack repository to your build file 

```gradle
	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```gradle
	dependencies {
  	        implementation 'com.github.rommansabbir:EasyEncryption-Android:Tag'
	}
```

---

### Version available

| Releases        
| ------------- |
| v1.0-beta     |


# Usages

```kotlin
@ExperimentalStdlibApi
class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        .................................
        
        /**
         * Encrypt a file using [EasyEncryption.encryptWithAES]
         */
        EasyEncryption.encryptWithAES(
            "test",
            stringToByteArray("hello"),
            object : EncryptionCallback {
                override fun onSuccess(result: EncryptionResult) {
                    val key = result.key
                    val data = result.encryptedData
                    Log.e("TAG", byteArrayToString(data))

                    /**
                     * Decrypt a file using [EasyEncryption.decryptWithAES]
                     */
                    EasyEncryption.decryptWithAES(key, data, object :
                        EncryptionCallback {
                        override fun onSuccess(result: EncryptionResult) {
                            Toast.makeText(this@MainActivity, result.encryptedData.decodeToString(), Toast.LENGTH_LONG).show()
                        }

                    })
                }

            })
            
            .............................
    }

    fun stringToByteArray(data: String): ByteArray = data.encodeToByteArray()

    fun byteArrayToString(data: ByteArray): String = data.decodeToString()
}
```

### Contact me
[Portfolio](https://www.rommansabbir.com/) | [LinkedIn](https://www.linkedin.com/in/rommansabbir/) | [Twitter](https://www.twitter.com/itzrommansabbir/) | [Facebook](https://www.facebook.com/itzrommansabbir/)

