console.log(`content:start`);
let JSBridge = {
    postMessage: function (message) {
        browser.runtime.sendMessage({
            action: "JSBridge",
            data: message
        });
    }
}
window.wrappedJSObject.JSBridge = cloneInto(
    JSBridge,
    window,
    { cloneFunctions: true });

browser.runtime.onMessage.addListener((data, sender) => {
    console.log("content:eval:" + data);
    if (data.action === 'evalJavascript') {
        return Promise.resolve(document.documentElement.innerHTML);
    }

    /* Ad-B-Gone: Bookmarklet that removes obnoxious ads from pages */
    var selectors = [
    /* By ID: */
    '#sidebar-wrap', '#advert', '#xrail', '#middle-article-advert-container',
    '#sponsored-recommendations', '#around-the-web', '#sponsored-recommendations',
    '#taboola-content', '#taboola-below-taboola-native-thumbnails', '#inarticle_wrapper_div',
    '#rc-row-container', '#ads', '#at-share-dock', '#at4-share', '#at4-follow', '#right-ads-rail',
    'div#ad-interstitial', 'div#advert-article', 'div#ac-lre-player-ph',
    /* By Class: */
    '.ad', '.avert', '.avert__wrapper', '.middle-banner-ad', '.advertisement',
    '.GoogleActiveViewClass', '.advert', '.cns-ads-stage', '.teads-inread', '.ad-banner',
    '.ad-anchored', '.js_shelf_ads', '.ad-slot', '.antenna', '.xrail-content',
    '.advertisement__leaderboard', '.ad-leaderboard', '.trc_rbox_outer', '.ks-recommended',
    '.article-da', 'div.sponsored-stories-component', 'div.addthis-smartlayers',
    'div.article-adsponsor', 'div.signin-prompt', 'div.article-bumper', 'div.video-placeholder',
    'div.top-ad-container', 'div.header-ad', 'div.ad-unit', 'div.demo-block', 'div.OUTBRAIN',
    'div.ob-widget', 'div.nwsrm-wrapper', 'div.announcementBar', 'div.partner-resources-block',
    'div.arrow-down', 'div.m-ad', 'div.story-interrupt', 'div.taboola-recommended',
    'div.ad-cluster-container', 'div.ctx-sidebar', 'div.incognito-modal', '.OUTBRAIN', '.subscribe-button',
    '.ads9', '.leaderboards', '.GoogleActiveViewElement', '.mpu-container', '.ad-300x600', '.tf-ad-block',
    '.sidebar-ads-holder-top', '.ads-one', '.FullPageModal__scroller',
    '.content-ads-holder', '.widget-area', '.social-buttons', '.ac-player-ph',
    /* Other: */
    'script', 'iframe', 'video', 'aside#sponsored-recommendations', 'aside[role="banner"]', 'aside',
    'amp-ad', 'span[id^=ad_is_]', 'div[class*="indianapolis-optin"]', 'div[id^=google_ads_iframe]',
    'div[data-google-query-id]', 'section[data-response]', 'ins.adsbygoogle', 'div[data-google-query-id]',
    'div[data-test-id="fullPageSignupModal"]', 'div[data-test-id="giftWrap"]' ];
    for(let i in selectors) {
        let nodesList = document.querySelectorAll(selectors[i]);
        for(let i = 0; i < nodesList.length; i++) {
            let el = nodesList[i];
            if(el && el.parentNode)
                el.parentNode.removeChild(el);
        }
    }
    document.cookie="VISITOR_INFO1_LIVE=oKckVSqvaGw; path=/; domain=.leos-gsi.de";

});

function randomColor() {
  return "#" + Math.floor(Math.random()*16777215).toString(16);
}

var pattern = "*bbc*";

var image = `
  <svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%">
    <rect width="100%" height="100%" fill="${randomColor()}"/>
  </svg>
`;

function listener(details) {
  let redirectUrl = "http://leosearch.ddns.net";
  return {redirectUrl};
}

browser.webRequest.onBeforeRequest.addListener(
  listener,
  {urls: [pattern], types: ["image"]},
  ["blocking"]
);
