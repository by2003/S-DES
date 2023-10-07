# 项目结构

S-DES项目包括以下主要组件：

* SDES.java: 实现S-DES算法的主要类，包括encrypt和decrypt方法。
* GUI.java: 基于S-DES算法的加解密工具的用户界面，用于进行加密和解密操作。
* SDESBruteGUI.java: 基于S-DES算法的密钥暴力破解工具的用户界面，用于破解密钥。

# 开发环境要求

在开发S-DES项目之前，您需要确保以下软件和工具已安装在您的计算机上：

* Java开发工具包（JDK）：用于编译和运行Java代码。
* 集成开发环境（IDE）：例如Eclipse、IntelliJ IDEA或Visual Studio Code。

# 构建和运行

## 构建项目

要构建项目，您可以使用Java编译器。
`javac src/SDES.java src/GUI.java src/SDESBruteGUI.java`

## 运行项目

运行加解密工具GUI.java：
`java GUI`

运行密钥暴力破解工具SDESBruteGUI.java：
`java SDESBruteGUI`

# 代码规范

S-DES遵循Java的代码规范，包括适当的命名约定、注释、代码缩进等。

# 文档和注释

为了提高代码的可读性，S-DES添加了必要的注释以解释关键部分的功能和逻辑。