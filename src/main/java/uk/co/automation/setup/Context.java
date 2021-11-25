package uk.co.automation.setup;

import org.openqa.selenium.Cookie;

public class Context {

    protected static Context instance;

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context(true);
        }
        return instance;
    }

    public static void reset() {
        if (instance != null) {
            instance = null;
        }

    }

    protected Context(boolean deleteCookie) {
        BrowserFacade.initialize(deleteCookie);
    }

    public void goTo(final String accountUrl) throws Exception {
        BrowserFacade.getDriver().get(accountUrl);
    }

    public void clearCookies() {
        BrowserFacade.clearCookies();
    }

    public void addCookie(Cookie cookie) {
        BrowserFacade.getDriver().manage().addCookie(cookie);
    }

    public Cookie getCookie(String cookiName) {
        return BrowserFacade.getDriver().manage().getCookieNamed(cookiName);
    }
}
