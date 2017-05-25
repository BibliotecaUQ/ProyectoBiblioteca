package co.edu.uniquindio.android.project.biblioteca.packages.actividades;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;

import com.unity3d.player.UnityPlayer;

/**
 * clase principal donde se tiene el manejo de la realida aumentada para el paseo virtual
 *
 * @author jhoan sebastian gomez medina
 * @author john sebastian agudelo ospina
 */
public class UnityPlayerActivity extends Activity {// don't change the name of this variable; referenced from native code
    protected UnityPlayer mUnityPlayer;

    /**
     * onCreate:Evento de android studio en ciclo de vida de la APP, se instancian los elementos necesarios para esta vista
     *
     * @param savedInstanceState
     */
    // Setup activity layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBX_8888); // <--- This makes xperia play happy
        mUnityPlayer = new UnityPlayer(this);
        setContentView(mUnityPlayer);
        mUnityPlayer.requestFocus();
    }

    /**
     * onBackPressed:Evento de android studio en ciclo de vida de la APP
     */
    @Override
    public void onBackPressed() {   // Invoca al método
        super.onBackPressed();
    }

    /**
     * onDestroy:Evento de android studio en ciclo de vida de la APP
     */
    // Quit Unity
    @Override
    protected void onDestroy() {
        mUnityPlayer.quit();
        super.onDestroy();
    }

    /**
     * onPause:Evento de android studio en ciclo de vida de la APP
     */
    // Pause Unity
    @Override
    protected void onPause() {
        super.onPause();
        mUnityPlayer.pause();
    }

    /**
     * onResume:Evento de android studio en ciclo de vida de la APP
     */
    // Resume Unity
    @Override
    protected void onResume() {
        super.onResume();
        mUnityPlayer.resume();
    }

    /**
     * onConfigurationChanged:Evento de android studio en ciclo de vida de la APP
     *
     * @param newConfig
     */
    // This ensures the layout will be correct.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mUnityPlayer.configurationChanged(newConfig);
    }

    /**
     * onwindowFocusChanged:Evento de android studio en ciclo de vida de la APP
     *
     * @param hasFocus
     */
    // Notify Unity of the focus change.
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mUnityPlayer.windowFocusChanged(hasFocus);
    }

    /**
     * dispatchKeyEvent:Evento de android studio en ciclo de vida de la APP
     *
     * @param event
     * @return Boolean
     */
    // For some reason the multiple keyevent type is not supported by the ndk.
    // Force event injection by overriding dispatchKeyEvent().
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_MULTIPLE)
            return mUnityPlayer.injectEvent(event);
        return super.dispatchKeyEvent(event);
    }

    /**
     * onKeyUP:Evento de android studio en ciclo de vida de la APP
     *
     * @param keyCode
     * @param event
     * @return Boolean
     */
    // Pass any events not handled by (unfocused) views straight to UnityPlayer
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return mUnityPlayer.injectEvent(event);
    }

    /**
     * onKeyDown: Evento de android studio en ciclo de vida de la APP
     *
     * @param keyCode
     * @param event
     * @return Boolean
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mUnityPlayer.injectEvent(event);
    }

    /**
     * onTuochEven: eventos al tacto con la pantalla
     *
     * @param event
     * @return Boolean
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mUnityPlayer.injectEvent(event);
    }
    /*API12*/

    /**
     * onGenericMotionEvent:Evento de android studio en ciclo de vida de la APP
     *
     * @param event
     * @return Boolean
     */
    public boolean onGenericMotionEvent(MotionEvent event) {
        return mUnityPlayer.injectEvent(event);
    }
}
