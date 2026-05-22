#include <jni.h>
#include <string.h>

JNIEXPORT jint JNICALL
Java_com_example_demo_MainActivity_addNumbers(
        JNIEnv *env, jobject thiz, jint a, jint b) {
    return a + b;
}

JNIEXPORT jstring JNICALL
Java_com_example_demo_MainActivity_getBuildInfo(
        JNIEnv *env, jobject thiz) {
    return (*env)->NewStringUTF(env,
        "Built with NDK + Clang on GitHub Actions");
}
