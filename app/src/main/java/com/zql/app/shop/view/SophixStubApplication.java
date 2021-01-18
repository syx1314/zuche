//package com.zql.app.shop.view;
//
//import android.content.Context;
//import android.support.annotation.Keep;
//import android.util.Log;
//
//import com.taobao.sophix.PatchStatus;
//import com.taobao.sophix.SophixApplication;
//import com.taobao.sophix.SophixEntry;
//import com.taobao.sophix.SophixManager;
//import com.taobao.sophix.listener.PatchLoadStatusListener;
//import com.zql.app.lib.util.sys.LogMe;
//import com.zql.app.shop.TbiApplication;
//
///**
// * Created by Administrator on 2019/8/12 0012.
// */
//
//public class SophixStubApplication extends SophixApplication {
//    private final String TAG = "SophixStubApplication";
//    private SophixManager instance;
//
//    // 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
//    @Keep
//    @SophixEntry(TbiApplication.class)
//    static class RealApplicationStub {}
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
////         如果需要使用MultiDex，需要在此处调用。
////         MultiDex.install(this);
//        initSophix();
//    }
//    private void initSophix() {
//        String appVersion = "0.0.0";
//        try {
//            appVersion = this.getPackageManager()
//                    .getPackageInfo(this.getPackageName(), 0)
//                    .versionName;
//        } catch (Exception e) {
//        }
//          instance = SophixManager.getInstance();
//        instance.setContext(this)
//                .setAppVersion(appVersion)
//                .setSecretMetaData("27752430-1", "ae68e740bcd9136f871256370a84a506", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCe/lJrDFbarRA5BCVwEwP6nTb3oZVOyhc94SSg4nWGYre9Gq4uteI9+OtFDjPjvG0QfDsEb6BZrrnQFuNn8fvdT91nqHPZD4L99au891drIJztcctalurn8OoY5pmuMInqueGIL1T/6CPtjt1rW+dxlqtRsbdIvdcarGn+VkcgACP5mpa2ktBow8NyU97am+vM2INrE02NN26HssNgIZMl09rQxufQOeU6Mwcjhc4VJPvn6EfpIyu7x1hFXWau2rSJ/pXOgUyBxj5NKKQI218Uk9xdEaySPxW03nWusqI2gWd//ip/1y/xkcZt9KheahSPwz5/mcrQ8e3sVXviTEzFAgMBAAECggEAExU/Wy3d9t0yx0UiITOHFLtt74brXsuOwpSVSuIjbP/IQeBD68NU5k9MHbu4qqrhBEuE4eFsA5efIcS9gqpeqo99aYWkcfcUp9qmxEWDro35h95SpArdIv2de2OiKnAU/aFV2nyj3RtFxKuTE+GyA8YrxeBouUhf2wm6pxY/7y0kd2bhcCDGEjTVN5NX0tNH4JNA1EQOewzuCUBvEbMYRm978atQwwJPZtOF/njSAzGUpNgdpgWx49hYkgnPhEbzQUAYwFLM8pX0bdStbWordtWrg+4JDTHVZ15e+tMXfjg5pQcAUNnMXWiYLm6RVN4zGjljkpEphDdLOy0RAvjUOQKBgQDfGZf4p2dmRYBPuAIWlu4E5KoEf0DKzun78/e3xgFCa6t8S92Mmjbsz7bbGjCoPm/wgSr+MVKt0WgruS3jmMcsxR8OySNu9bZQBNk7dhM/xAboN7Bpjtays0LVfubzoMvC31xPz7utc3Mnk5q/fKyZ3GeypzrvwIFXozdMAYlMjwKBgQC2cJjRg0iiNrIwee1Nbv5Up2FJG3CGjDPEQmropO0GaM19qO45Wn4K7gCan/10mPMlW8eOYj35/hYhFEbk2VT2FysY3+OmTjJ18AMERCpx8lP9AuWO7wF1pecvJq5ANtEuQKsNqI2jdEJ/pCv2swVGWrBM54M9C5jEB134KNJjawKBgFwy64crR6QQXPKVDOfhAAStq0WogVJPKIujS2B7R9H3RStc/vY4VTKQtPTfYfRluUUfXHEoWQ7UV8SaBsjkPovV+vvVS/tzOCDhoBTeux3DGUemnBVDnp7DTn+ErlVIwmyKek/RfbI04AYfDfjMwVfkqkY+rjCe0dUx8oxKpj8pAoGBALPP3D67R05h3FQ9B+9G0zL6Wb9lZQ2nh6oK0DYFv3uOteIBKvKqRwpcs4my4GsYCKWshM3H9E+952+o/Yq2za9S/G4i1MvnzIJDEaYVzUPLVI5NWZX76RNcdbQaSqoNnTQaFr16gEc24gfN9mrK3QsPfS3/DHGRSXsDy9E34syLAoGBAJ0c8AxCag17CZwAtx+IvmeDICvwHjg66z1JPxxHXiqnukm61xQw2v9J2GmVUw3wRHM23AmcWleLm2qGOf0Srz92UunOjf9a02BCH42CBvgtnFrHHt47aRJrIad+WsBKtKBKmTIbflHmorRC0+wArJvcgPZgUsqID9F05OmbRvpm")
//                .setEnableDebug(true)
//                .setEnableFullLog()
//                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
//                    @Override
//                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
//                        LogMe.e("code--->"+code+"info--->"+info);
//                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
//                            Log.i(TAG, "sophix load patch success!");
//                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
//                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
//                            Log.i(TAG, "sophix preload patch success. restart app to make effect.");
//                        }
//                    }
//                }).initialize();
//
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        if (instance!=null){
//            instance.queryAndLoadNewPatch();
//        }
//    }
//}
