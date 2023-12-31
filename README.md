# 项目简介

S-DES是一个基于Simplified Data Encryption Standard算法的工具，其中包含加解密工具和暴力破解工具。加解密工具用于进行二进制和ASCII字符串的加密和解密操作。暴力破解工具提供了暴力破解功能和破解时间可视化功能。

# 安装说明

要使用S-DES，您需要执行以下安装步骤：
* 确保您的计算机上已安装Java运行时环境（JRE）。
* 下载S-DES的源代码或可执行JAR文件。您可以从项目的GitHub存储库获取它。
* 如果您下载的是源代码，请在命令行或集成开发环境中编译并运行工具。如果您下载的是可执行JAR文件，请直接运行它。

# 代码结构：

* SDES.java实现了S-DES算法
    encrypt函数用于加密
    decrypt函数用于解密
* GUI.java是基于S-DES算法的加解密工具，它提供用户交互界面，可以实现二进制、ASCII字符串的加密、解密操作，其中加解密调用SDES.java；
* SDESBruteGUI同样是基于S-DES算法的暴力破解工具，它提供用户交互界面，用户可以选择明密文对的数量，输入明密文对来暴力破解密钥。同时，用户可以了解暴力破解的时间。

# 使用指南

## GUI.java

S-DES加解密工具允许用户对二进制或字符串进行加密和解密操作。以下是GUI.java的使用指南：

1. 运行加解密工具GUI.java。
2. 在文本框中输入您要加密的明文。
3. 选择明文的类型是二进制数字或ASCII字符串。
4. 在 "密钥" 文本框中输入10位二进制密钥。
5. 选择加密或解密操作。
6. 点击“执行”按钮。
7. 结果将显示在 "结果" 区域中。

## SDESBruteGUI.java

SDESBruteGUI是一个用于暴力破解S-DES密钥的工具。以下是使用SDESBruteGUI的使用指南：

1. 运行SDESBruteGUI.java。
2. 从下拉框中选择要使用的明文密文对的数量（1到5对）。
3. 每对明文密文输入8位二进制数字。
4. 单击 "查找密钥" 按钮开始暴力破解过程。
5. 结果区域将显示已找到的密钥列表。
6. 在完成暴力破解后，工具将显示破解所需的总时间。

# 示例

以下是一些使用S-DES的示例：

## 示例 1：加解密工具

* 输入明文或密文：11110010
* 密钥：1010101010
* 选择加密或解密后，结果将显示在 "结果" 区域中。

## 示例 2：加解密工具

* 输入明文或密文：abc
* 密钥：1010101010
* 选择加密或解密后，结果将显示在 "结果" 区域中。

## 示例 3：密钥暴力破解

* 输入多对明文密文
* 单击 "查找密钥" 按钮
* 工具将尝试暴力破解密钥并显示已找到的密钥列表和破解所需的总时间。

# 配置说明

S-DES通常不需要额外的配置。
