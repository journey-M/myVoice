//
// Created by dd on 18-4-13.
//
#include "inc/fmod.hpp"
#include "inc/fmod_errors.h"
#include "dev_gwj_mfmod_MFmod.h"




FMOD::System     *system;
FMOD::Sound      *sound;
FMOD_RESULT       result;
FMOD::Channel    *channel = 0;


JNIEXPORT void JNICALL Java_dev_gwj_mfmod_MFmod_init
  (JNIEnv * env, jobject jobj)
{


       FMOD::Channel    *channel = 0;
       unsigned int      version;
       void             *extradriverdata = 0;

       /*
           Create a System object and initialize
       */
       result = FMOD::System_Create(&system);
       if(cheeckResult(result)) return ;

       result = system->getVersion(&version);
       if(cheeckResult(result)) return ;

       if (version < FMOD_VERSION)
       {
          // Common_Fatal("FMOD lib version %08x doesn't match header version %08x", version, FMOD_VERSION);
            LOGE("FMOD lib version %08x doesn't match header version %08x",version, FMOD_VERSION);
       }

       result = system->init(32, FMOD_INIT_NORMAL, extradriverdata);
       if(cheeckResult(result)) return ;

       result = system->update();
       if(cheeckResult(result)) return ;

       LOGE("-----init  over");


}

/*
 * Class:     dev_gwj_mfmod_MFmod
 * Method:    playSound
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_dev_gwj_mfmod_MFmod_playSound
  (JNIEnv * env, jobject jobj, jstring jstr)
{
    result = system->update();
    if(cheeckResult(result)) return ;


    FMOD::Sound *msound;
    const char *name = env->GetStringUTFChars(jstr, NULL);
    LOGE("path == %s", name);

    //char *filePath = "file:///android_asset/drumloop.wav";


    system->createSound(name ,FMOD_DEFAULT , 0, &msound);
    result = msound->setMode(FMOD_LOOP_OFF);
    if(cheeckResult(result)) return ;

    result = system->playSound(msound, 0, false, &channel);
    if(cheeckResult(result)) return ;


}

/*
 * Class:     dev_gwj_mfmod_MFmod
 * Method:    onFmodEvent1
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_dev_gwj_mfmod_MFmod_onFmodEvent1
  (JNIEnv * env, jobject jobj)
{
    LOGE("android log from jni");


}

/*
 * Class:     dev_gwj_mfmod_MFmod
 * Method:    onFmodEvent2
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_dev_gwj_mfmod_MFmod_onFmodEvent2
  (JNIEnv * env, jobject jobj)
{


    return ;
}


bool cheeckResult(FMOD_RESULT result)
{
    if (result != FMOD_OK)
    {
        LOGE("err = %s",FMOD_ErrorString(result));
        return true;
    }
    return false;
}
