package dev.gwj.mfmod;

/**
 * Created by dd on 18-4-13.
 * <p>
 * 和原生fmod代码对接的 java 代码
 */

public class MFmod {

    static {
        System.loadLibrary("fmodL");
        System.loadLibrary("fmodutil");

        //加载本地的第so库
    }

    private static MFmod instance = null;


    public static MFmod getInstance() {
        if (instance == null) {
            instance = new MFmod();
        }
        return instance;
    }


    /**
     * 初始化
     */
    public native void init();

    /**
     * 播放
     *
     * @param path
     */
    public native void playSound(String path);

    /**
     * 事件1
     */
    public native void onFmodEvent1();

    /**
     * 事件1
     */
    public native void onFmodEvent2();

    /**
     * 从原生代码中返回的信息
     *
     * @param code
     * @param msg
     */
    public void onFmodRecieveEvent(int code, String msg) {

    }


}


