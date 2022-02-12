package com.hiddenservices.genesissearchengine.production.constants;

public class enums
{
    /*Settings Manager*/
    public enum etype{
        M_CHANGE_HOME_THEME, M_IS_ERROR_PAGE, on_update_favicon,M_RELOAD,ON_UPDATE_TAB_TITLE, ON_OPEN_TAB_VIEW,ON_NEW_TAB_ANIMATION, M_UPDATE_SESSION_STATE,ON_LOAD_REQUEST, GECKO_SCROLL_UP, GECKO_SCROLL_UP_ALWAYS, GECKO_SCROLL_DOWN, WAS_SCROLL_CHANGED, GECKO_SCROLL_DOWN_MOVE, GECKO_SCROLL_UP_MOVE, GECKO_SCROLL_DOWN_CALLER,ON_UPDATE_SEARCH_BAR,M_ON_MAIL,SESSION_ID,M_UPDATE_PIXEL_BACKGROUND, M_ON_SCROLL_BOUNDARIES, M_ON_SCROLL_TOP_BOUNDARIES, M_ON_SCROLL_NO_BOUNDARIES, M_INIT_PADDING, M_RATE_COUNT,M_CACHE_UPDATE_TAB,M_DEFAULT_BROWSER,
        on_verify_selected_url_menu,FINDER_RESULT_CALLBACK,M_ADMOB_BANNER_RECHECK,M_OPEN_SESSION,M_DOWNLOAD_FAILURE, M_ADVERT_LOADED,
        welcome, reload,download_folder, M_UPDATE_THEME,M_ON_BANNER_UPDATE, M_LOAD_HOMEPAGE_GENESIS,M_INIT_TAB_COUNT_FORCED,M_SPLASH_DISABLE,M_NEW_LINK_IN_NEW_TAB, M_NEW_LINK_IN_NEW_TAB_LOAD,M_RESET_SUGGESTION,
        url_triggered, url_triggered_new_tab,url_clear,fetch_favicon,M_OPEN_BOOKMARK_SETTING, M_COPY_URL,url_clear_at,remove_from_database,is_empty,M_HOME_PAGE,M_PRELOAD_URL,ON_KEYBOARD_CLOSE,M_CLOSE_TAB, M_CLOSE_TAB_BACK,
        on_close_sesson,on_long_press, on_full_screen,on_handle_external_intent,on_update_suggestion_url,progress_update,progress_update_forced, ON_EXPAND_TOP_BAR,recheck_orbot,on_url_load,on_playstore_load,back_list_empty,start_proxy, ON_UPDATE_THEME, M_NEW_IDENTITY,M_INDEX_WEBSITE, M_NEW_IDENTITY_MESSAGED, M_INITIALIZE_TAB_SINGLE, M_HOME_BUTTON_PRESSED, M_INITIALIZE_TAB_LINK,on_request_completed, on_update_history,on_update_suggestion,M_WELCOME_MESSAGE,ON_FIRST_PAINT, ON_INVOKE_PARSER, ON_LOAD_TAB_ON_RESUME, ON_SESSION_REINIT,on_page_loaded,on_load_error, M_ORBOT_LOADING,download_file_popup,on_init_ads, M_GET_CURRENT_URL,search_update, open_new_tab,open_new_tab_instant
    }

    /*General Enums*/
    public static class StoreType {
        public static final int GOOGLE_PLAY = 0;
        public static final int AMAZON = 1;
        public static final int SAMSUNG = 2;
    }

    public static class AddTabCallback {
        public static final int TAB_ADDED = 0;
        public static final int TAB_FULL = 1;
    }

    public static class Theme {
        public static final int THEME_LIGHT = 0;
        public static final int THEME_DARK = 1;
        public static final int THEME_DEFAULT = 2;
    }

    public static class WidgetResponse {
        public static final int NONE = 0;
        public static final int VOICE = 1;
        public static final int SEARCHBAR = 2;
    }

    public static class ImageQueueStatus {
        public static final int M_IMAGE_LOADING = 0;
        public static final int M_IMAGE_LOADED_SUCCESSFULLY = 1;
        public static final int M_IMAGE_LOADING_FAILED = 2;
    }

    public static class ScrollDirection {
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;
    }

    public static class WidgetCommands {
        public static final String OPEN_APPLICATION = "mOpenApplication";
        public static final String OPEN_VOICE = "mOpenVoice";
    }

    public static class LandingPageTypes {
        public static final int M_LANDING_WELCOME = 0;
        public static final int M_LANDING_INTRO = 1;
        public static final int M_LANDING_START = 2;
    }


}