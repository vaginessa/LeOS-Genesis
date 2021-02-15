package com.darkweb.genesissearchengine.appManager.settingManager.trackingManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.darkweb.genesissearchengine.appManager.activityContextManager;
import com.darkweb.genesissearchengine.appManager.helpManager.helpController;
import com.darkweb.genesissearchengine.constants.constants;
import com.darkweb.genesissearchengine.constants.keys;
import com.darkweb.genesissearchengine.constants.status;
import com.darkweb.genesissearchengine.dataManager.dataController;
import com.darkweb.genesissearchengine.dataManager.dataEnums;
import com.darkweb.genesissearchengine.helperManager.eventObserver;
import com.darkweb.genesissearchengine.helperManager.helperMethod;
import com.darkweb.genesissearchengine.pluginManager.pluginController;
import com.darkweb.genesissearchengine.pluginManager.pluginEnums;
import com.example.myapplication.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class settingTrackingController extends AppCompatActivity {

    /* PRIVATE VARIABLES */
    private settingTrackingModel mSettingPrivacyModel;
    private settingTrackingViewController mSettingPrivacyViewController;
    private ArrayList<RadioButton> mTrackers = new ArrayList<>();
    private boolean mSettingChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pluginController.getInstance().onLanguageInvoke(Collections.singletonList(this), pluginEnums.eLangManager.M_ACTIVITY_CREATED);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.setting_tracking_view);

        viewsInitializations();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        pluginController.getInstance().onLanguageInvoke(Collections.singletonList(this), pluginEnums.eLangManager.M_ACTIVITY_CREATED);
    }

    private void viewsInitializations() {
        mTrackers.add(findViewById(R.id.pTrackingRadioOption1));
        mTrackers.add(findViewById(R.id.pTrackingRadioOption2));
        mTrackers.add(findViewById(R.id.pTrackingRadioOption3));

        activityContextManager.getInstance().onStack(this);
        mSettingPrivacyViewController = new settingTrackingViewController(this, new settingTrackingController.settingAccessibilityViewCallback(),  mTrackers);
        mSettingPrivacyModel = new settingTrackingModel(new settingTrackingController.settingAccessibilityModelCallback());
    }

    /*View Callbacks*/

    private class settingAccessibilityViewCallback implements eventObserver.eventListener{

        @Override
        public Object invokeObserver(List<Object> data, Object e_type)
        {
            return null;
        }
    }

    /*Model Callbacks*/

    private class settingAccessibilityModelCallback implements eventObserver.eventListener{

        @Override
        public Object invokeObserver(List<Object> data, Object e_type)
        {
            return null;
        }
    }

    /* LOCAL OVERRIDES */

    @Override
    public void onResume()
    {
        if(mSettingChanged){
            activityContextManager.getInstance().setCurrentActivity(this);
        }
        pluginController.getInstance().onLanguageInvoke(Collections.singletonList(this), pluginEnums.eLangManager.M_RESUME);
        super.onResume();
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        if(mSettingChanged){
            activityContextManager.getInstance().setCurrentActivity(this);
            activityContextManager.getInstance().getHomeController().initRuntimeSettings();
        }
        activityContextManager.getInstance().onRemoveStack(this);
        finish();
    }

    /*UI Redirection*/

    public void onClose(View view){
        onBackPressed();
    }

    public void onTracking(View view){
        mSettingChanged = true;
        mSettingPrivacyViewController.onTrigger(settingTrackingEnums.eTrackingViewController.M_SET_TRACKING_STATUS, Collections.singletonList(view));
        mSettingPrivacyModel.onTrigger(settingTrackingEnums.eTrackingModel.M_SET_TRACKING_PROTECTION, Collections.singletonList(view));
        dataController.getInstance().invokePrefs(dataEnums.ePreferencesCommands.M_SET_INT, Arrays.asList(keys.SETTING_COOKIE_ADJUSTABLE,status.sSettingCookieStatus));
    }

    public void onOpenInfo(View view) {
        helperMethod.openActivity(helpController.class, constants.CONST_LIST_HISTORY, this,true);
    }

}