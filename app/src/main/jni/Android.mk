LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE    := fmodutil
LOCAL_C_INCLUDES:= dev_gwj_mfmod_MFmod.h
LOCAL_SRC_FILES := dev_gwj_mfmod_MFmod.cpp

##play_sound.cpp

LOCAL_LDLIBS += -llog
LOCAL_CPP_FEATURES := exceptions
LOCAL_SHARED_LIBRARIES := fmodL
include $(BUILD_SHARED_LIBRARY)



#include $(CLEAR_VARS)
#LOCAL_MODULE    := fmod
#LOCAL_SRC_FILES := libfmod.so
#include $(PREBUILT_SHARED_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := fmodL
LOCAL_SRC_FILES := libfmodL.so
LOCAL_LDLIBS += -llog
include $(PREBUILT_SHARED_LIBRARY)
