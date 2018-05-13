#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_chenleiblogs_mlopencl_ml_1opencl_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Wa! AlexNet on Android";
    return env->NewStringUTF(hello.c_str());
}

