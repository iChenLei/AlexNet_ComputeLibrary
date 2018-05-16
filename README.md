<p align="center"><img src="http://wx2.sinaimg.cn/mw690/0060lm7Tly1fra1117rhgj306j02mq2x.jpg" with="235px" height="94px"></p>

<p align="center"><img src="https://img.shields.io/badge/build-failing-red.svg?style=flat-square">  <img src="https://img.shields.io/badge/Platform-Android-green.svg?style=flat-square">  <img src="https://img.shields.io/badge/framework-ComputeLibrary-red.svg?style=flat-square">  <img src="https://img.shields.io/badge/language-C++-green.svg?style=flat-square">   <img src="https://img.shields.io/badge/Model-AlexNet-green.svg?style=flat-square"> </p>

#### How to run it?
>No , You can't run it, because some cross complie question i didn't solve

```bash
  git clone https://github.com/iChenLei/AlexNet_ComputeLibrary.git -depth=1
```


#### If you meet any problem!
```bash
Please contact with me by my Email (chenleicoder@gmail.com
```

####  what is this project?
```bash
A android project which use ARM-ComputeLibrary! Use the neon/opencl api to mock AlexNet
and run it on ARM-arch-based SmartPhone.
```
>Maybe you need a guide(link) to use ComputeLibrary!
```bash
  https://github.com/ARM-software/ComputeLibrary/issues/434
```

#### The library and main code of the project
```bash
// All is the ComputeLibary static or Dynamic lib
---libarm_compute-static.a
---libarm_compute.so
---libarm_compute_core-static.a
---libarm_compute_core.so

// OenCL for SmartPhone
---libOpenCL.so

// Mock the alexnet with NEON
---alexnet_neon.cpp

// Mock the alexnet with OpenCL
---alexnet_opencl.cpp
```

<p align="center">MIT License Copyright © 2018-present</p>
<p align="center">Created by chenlei © xidian_university</p>
