# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp
             src/main/cpp/alexnet_neon.cpp
             src/main/cpp/alexnet_opencl.cpp)

#我们需要链接一些头文件
#download link https://github.com/ARM-software/ComputeLibrary/releases
#请将路径修改成合适您的
#参考做法见issue https://github.com/ARM-software/ComputeLibrary/issues/434

include_directories("/Users/yangjingchou/Downloads/arm_compute-v18.03-bin-android")

include_directories("/Users/yangjingchou/Downloads/arm_compute-v18.03-bin-android/include")

#请修改成自己的test_helpers路径
include_directories("/Users/yangjingchou/code/android/app")

add_library( OpenCL SHARED IMPORTED )

set_target_properties( # Specifies the target library.
                       OpenCL
                       # Specifies the parameter you want to define.
                       PROPERTIES IMPORTED_LOCATION
                       # Provides the path to the library you want to import.
                       "${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libOpenCL.so" )

#link_libraries("${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libOpenCL.so")

add_library( lib_arm_compute_core STATIC IMPORTED)

set_target_properties(lib_arm_compute_core
        PROPERTIES IMPORTED_LOCATION
#       "${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libarm_compute-static.a"
        "${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libarm_compute_core-static.a")

add_library( lib_arm_compute STATIC IMPORTED)

set_target_properties(lib_arm_compute
        PROPERTIES IMPORTED_LOCATION
#       "${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libarm_compute-static.a"
        "${CMAKE_SOURCE_DIR}/libs/${ANDROID_ABI}/libarm_compute-static.a")


# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.



target_link_libraries( # Specifies the target library.


                       native-lib
                       lib_arm_compute_core
                       lib_arm_compute
                       OpenCL


                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )