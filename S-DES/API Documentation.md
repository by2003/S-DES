# 接口文档

## SDES.java接口文档

SDES类实现了S-DES算法的加密和解密操作。

### 方法

**1. public static int[] encrypt(int[] plaintext, int[] key)**

* 描述：对给定的明文使用S-DES算法进行加密。
* 参数：
* plaintext：包含8位二进制明文的数组。
* key：包含10位二进制密钥的数组。
* 返回：包含8位二进制密文的数组。

**2. public static int[] decrypt(int[] ciphertext, int[] key)**

* 描述：对给定的密文使用S-DES算法进行解密。
* 参数：
* ciphertext：包含8位二进制密文的数组。
* key：包含10位二进制密钥的数组。
* 返回：包含8位二进制明文的数组。


## GUI.java接口文档

GUI类是基于S-DES算法的加解密工具的用户界面。

### 构造方法

**1. public GUI()**
描述：创建一个新的GUI实例。
参数：无。
返回：无。

### 公共方法

**1. public static void main(String[] args)**
* 描述：启动加解密工具的用户界面。
* 参数：args：命令行参数，用于启动应用程序。
* 返回：无。

**2. private void encryptText()**
* 描述：使用S-DES算法对用户输入的文本进行加密。
* 参数：无。
* 返回：无。

**3. private void decryptText()**
* 描述：使用S-DES算法对用户输入的文本进行解密。
* 参数：无。
* 返回：无。

**4. private boolean validateInput()**
* 描述：验证用户输入的文本和密钥是否有效。
* 参数：无。
* 返回：如果输入有效则返回true，否则返回false。

## SDESBruteGUI.java接口文档

SDESBruteGUI类是基于S-DES算法的密钥暴力破解工具的用户界面。

### 构造方法

**1. public SDESBruteGUI()**
* 描述：创建一个新的SDESBruteGUI实例。
* 参数：无。
* 返回：无。

### 公共方法

**1. public static void main(String[] args)**
* 描述：启动密钥暴力破解工具的用户界面。
* 参数：
* args：命令行参数，用于启动应用程序。
* 返回：无。

**2. private void updateInputPairsPanel()**
* 描述：根据用户选择的明密文对数量更新输入面板。
* 参数：无。
* 返回：无。

**3. private void findKey()**
* 描述：执行密钥暴力破解操作，查找可能的密钥。
* 参数：无。
* 返回：无。

**4. private String formatTime(long nanos)**
* 描述：将时间格式化为时间字符串。
* 参数： 
* nanos：要格式化的纳秒时间。
* 返回：格式化后的时间字符串。

**5. private int[] stringToArray(String str)**
* 描述：将二进制字符串转换为整数数组。
* 参数： 
* str：要转换的二进制字符串。
* 返回：包含二进制位的整数数组。

**6. private String arrayToString(int[] arr)**
* 描述：将整数数组转换为二进制字符串。
* 参数： 
* arr：要转换的整数数组。
* 返回：包含二进制位的字符串。

**7. private int[] intToBits(int n)**
* 描述：将整数转换为10位二进制位的整数数组。
* 参数： 
* n：要转换的整数。
* 返回：包含10位二进制位的整数数组。